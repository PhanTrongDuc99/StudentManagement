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
    option_1(LocalTime.of(19, 0), LocalTime.of(22, 0)),
    option_2(LocalTime.of(15, 30), LocalTime.of(18, 30)),
    option_3(LocalTime.of(8, 0), LocalTime.of(11, 0)),
    option_4(LocalTime.of(19, 0), LocalTime.of(22, 0)),
    option_5(LocalTime.of(20, 0), LocalTime.of(23, 0));

    private LocalTime startTime;
    private LocalTime endTime;

    Time() {
    }

    Time(LocalTime startTime, LocalTime endTime) {
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

    @Override
    public String toString() {
        return "Time{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
    }

}
