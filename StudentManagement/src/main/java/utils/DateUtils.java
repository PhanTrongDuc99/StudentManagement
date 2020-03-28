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
import java.time.DayOfWeek;
import java.time.LocalTime;

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

}
