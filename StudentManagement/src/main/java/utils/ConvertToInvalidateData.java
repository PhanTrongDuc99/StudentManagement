/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import common.RegisterStatus;
import common.RegisterType;
import common.Time;
import entities.Register;
import java.time.DayOfWeek;

/**
 *
 * @author PC
 */
public class ConvertToInvalidateData {

    public ConvertToInvalidateData() {
    }

    public Register converToRegister(String status, String type) {
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

    public DayOfWeek convertToDayOfWeek(int dayOfWeekInDatabase) {
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

}
