/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.time.LocalTime;

/**
 *
 * @author USER
 */
public enum Time {
    option_1(LocalTime.of(7, 0), LocalTime.of(9, 30)),
    option_2(LocalTime.of(8, 0), LocalTime.of(10, 30)),
    option_3(LocalTime.of(13, 0), LocalTime.of(13, 30)),
    option_4(LocalTime.of(14, 0), LocalTime.of(16, 30)),
    option_5(LocalTime.of(19, 30), LocalTime.of(22, 30));

    private LocalTime startTime;
    private LocalTime endTime;

    private Time() {
    }

    private Time(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    
}
