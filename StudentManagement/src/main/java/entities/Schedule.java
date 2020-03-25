/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author USER
 */
public class Schedule {

    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek dayOfWeek;

    public Schedule() {
    }

    public Schedule(String id, LocalTime startTime, LocalTime endTime, DayOfWeek dayOfWeek) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", Time=" + startTime + " -> " + endTime + ", dayOfWeek=" + dayOfWeek + '}';
    }

}
