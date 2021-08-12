package com.assignment.flight.routes.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
  "AvgTicketPrice",
  "Cancelled",
  "Dest",
  "DestAirportID",
  "DestCityName",
  "DestCountry",
  "DestLocation",
  "DestRegion",
  "DestWeather",
  "DistanceKilometers",
  "DistanceMiles",
  "FlightDelay",
  "FlightDelayMin",
  "FlightDelayType",
  "FlightNum",
  "FlightTimeHour",
  "FlightTimeMin",
  "Origin",
  "OriginAirportID",
  "OriginCityName",
  "OriginCountry",
  "OriginLocation",
  "OriginRegion",
  "OriginWeather",
  "dayOfWeek",
  "hour_of_day"
})
public class FlightInfo {
  @JsonProperty("AvgTicketPrice")
  public String avgTicketPrice;

  @JsonProperty("Cancelled")
  public String cancelled;

  @JsonProperty("Dest")
  public String dest;

  @JsonProperty("DestAirportID")
  public String destAirportID;

  @JsonProperty("DestCityName")
  public String destCityName;

  @JsonProperty("DestCountry")
  public String destCountry;

  @JsonProperty("DestLocation")
  public String destLocation;

  @JsonProperty("DestRegion")
  public String destRegion;

  @JsonProperty("DestWeather")
  public String destWeather;

  @JsonProperty("DistanceKilometers")
  public String distanceKilometers;

  @JsonProperty("DistanceMiles")
  public String distanceMiles;

  @JsonProperty("FlightDelay")
  public String flightDelay;

  @JsonProperty("FlightDelayMin")
  public int flightDelayMin;

  @JsonProperty("FlightDelayType")
  public String flightDelayType;

  @JsonProperty("FlightNum")
  public String flightNum;

  @JsonProperty("FlightTimeHour")
  public double flightTimeHour;

  @JsonProperty("FlightTimeMin")
  public String flightTimeMin;

  @JsonProperty("Origin")
  public String origin;

  @JsonProperty("OriginAirportID")
  public String originAirportID;

  @JsonProperty("OriginCityName")
  public String originCityName;

  @JsonProperty("OriginCountry")
  public String originCountry;

  @JsonProperty("OriginLocation")
  public String originLocation;

  @JsonProperty("OriginRegion")
  public String originRegion;

  @JsonProperty("OriginWeather")
  public String originWeather;

  @JsonProperty("dayOfWeek")
  public int dayOfWeek;

  @JsonProperty("hour_of_day")
  public int hourOfDay;

  public FlightInfo() {}

  @Override
  public String toString() {
    return "FlightInfo{"
        + "avgTicketPrice='"
        + avgTicketPrice
        + '\''
        + ", cancelled='"
        + cancelled
        + '\''
        + ", dest='"
        + dest
        + '\''
        + ", destAirportID='"
        + destAirportID
        + '\''
        + ", destCityName='"
        + destCityName
        + '\''
        + ", destCountry='"
        + destCountry
        + '\''
        + ", destLocation='"
        + destLocation
        + '\''
        + ", destRegion='"
        + destRegion
        + '\''
        + ", destWeather='"
        + destWeather
        + '\''
        + ", distanceKilometers='"
        + distanceKilometers
        + '\''
        + ", distanceMiles='"
        + distanceMiles
        + '\''
        + ", flightDelay='"
        + flightDelay
        + '\''
        + ", flightDelayMin="
        + flightDelayMin
        + ", flightDelayType='"
        + flightDelayType
        + '\''
        + ", flightNum='"
        + flightNum
        + '\''
        + ", flightTimeHour="
        + flightTimeHour
        + ", flightTimeMin='"
        + flightTimeMin
        + '\''
        + ", origin='"
        + origin
        + '\''
        + ", originAirportID='"
        + originAirportID
        + '\''
        + ", originCityName='"
        + originCityName
        + '\''
        + ", originCountry='"
        + originCountry
        + '\''
        + ", originLocation='"
        + originLocation
        + '\''
        + ", originRegion='"
        + originRegion
        + '\''
        + ", originWeather='"
        + originWeather
        + '\''
        + ", dayOfWeek="
        + dayOfWeek
        + ", hourOfDay="
        + hourOfDay
        + '}';
  }
}
