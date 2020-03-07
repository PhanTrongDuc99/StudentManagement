/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import common.Time;
import java.time.DayOfWeek;

/**
 *
 * @author USER
 */
public class Schedule {

    private String id;
    //kiểu Time sql bị lệch lên 7h khi lấy ra tại source bên java
    private java.sql.Time startTime;
    private java.sql.Time endTime;
    private DayOfWeek dayOfWeek;

    public Schedule() {
    }

    public Schedule(String id, java.sql.Time startTime, java.sql.Time endTime, DayOfWeek dayOfWeek) {
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

    public java.sql.Time getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Time startTime) {
        this.startTime = startTime;
    }

    public java.sql.Time getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Time endTime) {
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
