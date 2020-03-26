/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.DayOfWeek;

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
}
