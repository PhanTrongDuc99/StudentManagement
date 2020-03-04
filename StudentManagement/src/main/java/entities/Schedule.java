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

    private Integer id;
    private Time time;
    private DayOfWeek dayOfWeek;

    public Schedule() {
    }

    public Schedule(Integer id, Time time, DayOfWeek dayOfWeek) {
        this.id = id;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
