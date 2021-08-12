package com.assignment.flight.routes;

import com.assignment.flight.routes.pojo.FlightInfo;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadData {

  public static List<FlightInfo> readFile(File csvFile) throws Exception {
    CsvMapper csvMapper = new CsvMapper();
    CsvSchema schema = CsvSchema.emptySchema().withHeader();
    MappingIterator<FlightInfo> personIter =
        csvMapper.reader(FlightInfo.class).with(schema).readValues(csvFile);
    return personIter.readAll();
  }

  public static void main(String[] args) throws IOException {}
}
