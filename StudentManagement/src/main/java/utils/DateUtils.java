/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import common.RegisterStatus;
import common.RegisterType;
import entities.Register;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author PC
 */
public class DateUtils {

    public DateUtils() {
    }

    public static Date convertToSqlDate(java.util.Date date) {

        java.sql.Date sqlDate = null;
        if (date != null) {
            sqlDate = new Date(date.getTime());
        }
        return sqlDate;
    }

    public static LocalTime convertToLocalTime(String time) {
        return LocalTime.parse(time);
    }

    public static String convertToDateFromString(java.util.Date date) {
        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        if (date != null) {
            String todayAsString = df.format(date);
            return todayAsString;
        }
        return null;
    }

}
