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

    public static Register
            converToRegister(String status, String type) {
        RegisterStatus registerStatus = null;
        RegisterType registerType = null;
        try {
            if ("Registered".equals(status)) {
                registerStatus = RegisterStatus.REGISTERED;
            }
            if ("Waitting".equals(status)) {
                registerStatus = RegisterStatus.WAITTING;
            }
            if ("Cancel".equals(status)) {
                registerStatus = RegisterStatus.CANCEL;
            }
            if ("Internet".equals(type)) {
                registerType = RegisterType.INTERNET;
            }
            if ("Maketing".equals(type)) {
                registerType = RegisterType.MARKETING;
            }
            if ("Direct".equals(type)) {
                registerType = RegisterType.DIRECT;
            }
        } catch (Exception e) {
        }
        return new Register(registerStatus, registerType);
    }

    public static DayOfWeek convertToDayOfWeek(int dayOfWeekInDatabase) {
        DayOfWeek dayOfWeek = null;
        switch (dayOfWeekInDatabase) {
            case 1: {
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            }
            case 2: {
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            }
            case 3: {
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            }
            case 4: {
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            }
            case 5: {
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            }
            case 6: {
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            }
            case 7: {
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            }
        }
        return dayOfWeek;
    }

    public static Date convertToSqlDate(java.util.Date date) {
//        Instant instant = date.toInstant();
//        ZoneId zoneId = ZoneId.of("America/Montreal");
//        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
//        LocalDate localDate = zdt.toLocalDate();
//        return Date.valueOf(localDate);
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
