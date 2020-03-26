/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalTime;

/**
 *
 * @author USER
 */
public class TimeUtils {

    public static LocalTime convertStringToLocalTime(String string) {
        String[] numbers = string.split("[:]");
        return LocalTime.of(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
    }

}
