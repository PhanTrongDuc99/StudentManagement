/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author USER
 */
public class DayOfWeekUtils {

    public static DayOfWeek[] convertStringNumberToDayOfWeek(String string) {
        String[] dayOfWeekString = string.split("[,]");
        int length = dayOfWeekString.length;
        DayOfWeek[] daysOfWeek = new DayOfWeek[length];
        for (int i = 0; i < length; i++) {
            daysOfWeek[i] = DayOfWeek.of(Integer.parseInt(dayOfWeekString[i]));
        }
        return daysOfWeek;
    }

    public static DayOfWeek[] convertStringToDayOfWeek(String string) {
        String[] dayOfWeekString = string.split("[,]");
        int length = dayOfWeekString.length;
        DayOfWeek[] daysOfWeek = new DayOfWeek[length];
        for (int i = 0; i < length; i++) {
            daysOfWeek[i] = DayOfWeek.valueOf(dayOfWeekString[i]);
        }
        return daysOfWeek;
    }

    public static String convertDayOfWeekToString(DayOfWeek[] dayOfWeek) {
        return String.join(",", Arrays.asList(dayOfWeek).stream().map(t -> t.toString()).collect(Collectors.toList()));
    }
}
