/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author USER
 */
public class ConvertToSqlDate {

    public static Date convertToSqlDate(java.util.Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.of("America/Montreal");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        LocalDate localDate = zdt.toLocalDate();
        return Date.valueOf(localDate);
    }
}
