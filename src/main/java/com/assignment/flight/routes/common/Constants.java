package com.assignment.flight.routes.common;

import org.apache.commons.cli.Options;

public class Constants {
    public static final String DELIMITER = "-";
    public static final Options options = createOptions();
    public static final String ARROW = "->";
    public static final String COMMA = ",";
    public static final String TIME_STR = "time:";
    public static final String NO_FOUND = "No flight found between the given source %s & destination %s";
    public static final String FOUND = "The shortest time to travel from %s to %s is: %f";

    private static Options createOptions() {
        Options options = new Options();
        options.addOption("f", true, "Dataset file path");
        options.addOption("s", true, "Start");
        options.addOption("e", true, "End");
        return options;
    }
}
