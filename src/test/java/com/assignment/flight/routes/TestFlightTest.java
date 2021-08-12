package com.assignment.flight.routes;

import com.assignment.flight.routes.common.Tuple2;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestFlightTest {

  @Test
  public void testFindShortestTravel() throws Exception {
    Tuple2 flightTravel =
        FlightTravel.findShortestTravel(
            new String[] {"-f", "flights.csv", "-s", "NA01", "-e", "SFO"});
    assertEquals("NA01-SFO->time:488.611", flightTravel.getK());
  }

  @Test
  public void testFindShortestTravel_withSingleStopOver() throws Exception {
    Tuple2 flightTravel =
        FlightTravel.findShortestTravel(
            new String[] {"-f", "flights.csv", "-s", "LGW", "-e", "HND"});
    assertEquals("LGW-SHA-HND->time:533.8589999999999", flightTravel.getK());
  }

  @Test
  public void testFindShortestTravel_forNoEntry() throws Exception {
    Tuple2<String, FlightTravel> flightTravel =
        FlightTravel.findShortestTravel(
            new String[] {"-f", "flights.csv", "-s", "LGW", "-e", "DUR"});

    String route = flightTravel.getK();
    double timeValue = Double.parseDouble(route.split(":")[1]);
    if (timeValue == 1.7976931348623157E308) {
      route = "";
    }

    assertEquals("", route);
  }
}
