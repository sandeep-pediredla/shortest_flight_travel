package com.assignment.flight.routes;

import com.assignment.flight.routes.common.Tuple2;
import com.assignment.flight.routes.pojo.FlightInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.assignment.flight.routes.common.Constants.ARROW;
import static com.assignment.flight.routes.common.Constants.COMMA;
import static com.assignment.flight.routes.common.Constants.DELIMITER;
import static com.assignment.flight.routes.common.Constants.FOUND;
import static com.assignment.flight.routes.common.Constants.NO_FOUND;
import static com.assignment.flight.routes.common.Constants.TIME_STR;
import static com.assignment.flight.routes.common.Constants.options;

public class FlightTravel {
  private static final CommandLineParser parser = new DefaultParser();
  private final Map<String, Integer> cityIndexMap = new HashMap<>();
  private final Map<Integer, String> indexCityMap = new HashMap<>();
  private final HashMap<String, String> shortestTravelTimeMap = new HashMap<>();
  private final HashMap<String, String> travelRoutes = new HashMap<>();
  private Graph citiesGraph;

  public FlightTravel(String csvFilename) throws Exception {
    List<FlightInfo> flights = ReadData.readFile(new File(csvFilename));
    List<Edge> flightTimeEdges = createEdges(flights);
    int maxNumCities = indexCityMap.size();
    citiesGraph = new Graph(maxNumCities);
    citiesGraph = buildCitiesGraph(flightTimeEdges);
    genShortestTravelTimeMatrix(citiesGraph, maxNumCities);
  }

  public static void main(String[] args) throws Exception {
    CommandLine cmd = parser.parse(options, args);
    String startLoc = cmd.getOptionValue("s");
    String endLoc = cmd.getOptionValue("e");
    Tuple2<String, FlightTravel> tuple = findShortestTravel(args);
    String routePath = tuple.getK();
    String route = routePath.split(ARROW)[0];
    double timeValue = Double.parseDouble(routePath.split(ARROW)[1].replace(TIME_STR, ""));

    double totalTime = Math.round(timeValue * 100) / 100d;
    if (totalTime > 0) {
      System.out.printf(FOUND, startLoc, endLoc, totalTime);
    } else {
      System.out.printf(NO_FOUND, startLoc, endLoc);
      route = "";
    }
    tuple.getV().printPath(route);
  }

  public static Tuple2 findShortestTravel(String[] args) throws Exception {
    CommandLine cmd = parser.parse(options, args);
    String csvFilename = cmd.getOptionValue("f");
    String startLoc = cmd.getOptionValue("s");
    String endLoc = cmd.getOptionValue("e");

    final FlightTravel flight = new FlightTravel(csvFilename);
    return new Tuple2(flight.findShortestTravel(startLoc, endLoc), flight);
  }

  public String findShortestTravel(String startLoc, String endLoc) {
    int startCityIndex = cityIndexMap.get(startLoc);
    int endCityIndex = cityIndexMap.get(endLoc);
    return shortestTravelTimeMap.get(startCityIndex + DELIMITER + endCityIndex);
  }

  private void printPath(String route) {
    String[] airports = route.split(DELIMITER);
    System.out.println();
    for (int i = 0; i < airports.length - 1; ++i) {
      String routePath = airports[i] + DELIMITER + airports[i + 1];
      System.out.println(routePath + ARROW + travelRoutes.get(routePath));
    }
  }

  private Graph buildCitiesGraph(final List<Edge> edges) {
    for (final Edge edge : edges) {
      // add Edges
      citiesGraph.addEdge(cityIndexMap.get(edge.src), cityIndexMap.get(edge.dest), ((edge.weight)));
    }
    return citiesGraph;
  }

  private double[][] genShortestTravelTimeMatrix(final Graph citiesGraph, final int maxNumCities) {
    double[][] shortestTravelTimeMatrix = new double[maxNumCities][maxNumCities];

    // initialize with adjacency matrix time weight values
    for (int i = 0; i < maxNumCities; i++) {
      for (int j = 0; j < maxNumCities; j++) {
        shortestTravelTimeMatrix[i][j] = citiesGraph.getAdj()[i][j];
        if (i != j) {
          String key = String.valueOf(i).concat(DELIMITER).concat(String.valueOf(j));
          travelRoutes.put(
              indexCityMap.get(i) + DELIMITER + indexCityMap.get(j),
              String.valueOf(citiesGraph.getAdj()[i][j]));
          shortestTravelTimeMap.put(
              key,
              indexCityMap.get(i)
                  + DELIMITER
                  + indexCityMap.get(j)
                  + ARROW
                  + TIME_STR
                  + citiesGraph.getAdj()[i][j]);
        }
      }
    }

    // loop through all vertices one by one
    for (int k = 0; k < maxNumCities; k++) {
      // pick all as source
      for (int i = 0; i < maxNumCities; i++) {
        // pick all as destination
        for (int j = 0; j < maxNumCities; j++) {
          // If k is on the shortest path from i to j
          if (shortestTravelTimeMatrix[i][k] + shortestTravelTimeMatrix[k][j]
              < shortestTravelTimeMatrix[i][j]) {
            // update the value of shortestTravelTimeMatrix[i][j]
            shortestTravelTimeMatrix[i][j] =
                shortestTravelTimeMatrix[i][k] + shortestTravelTimeMatrix[k][j];
            String key = String.valueOf(i).concat(DELIMITER).concat(String.valueOf(j));
            shortestTravelTimeMap.put(
                key,
                indexCityMap
                    .get(i)
                    .concat(DELIMITER)
                    .concat(indexCityMap.get(k))
                    .concat(DELIMITER)
                    .concat(indexCityMap.get(j))
                    .concat(ARROW + TIME_STR)
                    .concat(String.valueOf(shortestTravelTimeMatrix[i][j])));
          }
        }
      }
    }

    return shortestTravelTimeMatrix;
  }

  private List<Edge> createEdges(List<FlightInfo> flights) throws IOException {
    final List<Edge> edges = new ArrayList<Edge>();
    int cityIndex = 0;
    for (FlightInfo flightInfo : flights) {
      String time = flightInfo.flightTimeMin.replace(COMMA, "");
      Double t = Double.parseDouble(time);
      final Edge edge = new Edge(flightInfo.originAirportID, flightInfo.destAirportID, t);
      edges.add(edge);
      if (!cityIndexMap.containsKey(flightInfo.originAirportID)) {
        cityIndexMap.put(flightInfo.originAirportID, cityIndex);
        ++cityIndex;
      }
      if (!cityIndexMap.containsKey(flightInfo.destAirportID)) {
        cityIndexMap.put(flightInfo.destAirportID, cityIndex);
        ++cityIndex;
      }
    }

    for (Map.Entry mapElement : cityIndexMap.entrySet()) {
      indexCityMap.put((int) mapElement.getValue(), (String) mapElement.getKey());
    }
    return edges;
  }
}
