package com.rest.timerRestApi.utilities;
public class TimeCalculator {
    private static final int NUMBER_OF_SECONDS_IN_HOUR = 3600;
    private static final int NUMBER_OF_SECONDS_IN_MINUTE = 60;

    public static int calculateTotalNumberOfSeconds(int hours, int minutes, int seconds){
        return hours * NUMBER_OF_SECONDS_IN_HOUR + minutes * NUMBER_OF_SECONDS_IN_MINUTE + seconds;
    }
}
