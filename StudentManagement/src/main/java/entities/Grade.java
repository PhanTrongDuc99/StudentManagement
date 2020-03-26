/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class Grade {

    private String idGrade;
    private String nameGrade;
    private Teacher teacher;
    private Course course;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer studentQuantity;
    private DayOfWeek[] daysOfWeek;

    public Grade() {
    }

    public Grade(String idGrade, String nameGrade, Teacher teacher, Course course, LocalTime startTime, LocalTime endTime, Integer studentQuantity, DayOfWeek[] daysOfWeek) {
        this.idGrade = idGrade;
        this.nameGrade = nameGrade;
        this.teacher = teacher;
        this.course = course;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studentQuantity = studentQuantity;
        this.daysOfWeek = daysOfWeek;
    }

    public String getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(String idGrade) {
        this.idGrade = idGrade;
    }

    public String getNameGrade() {
        return nameGrade;
    }

    public void setNameGrade(String nameGrade) {
        this.nameGrade = nameGrade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public Integer getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(Integer studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    public DayOfWeek[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(DayOfWeek[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public String toString() {
        return "Grade{" + "idGrade=" + idGrade + ", nameGrade=" + nameGrade + ", startTime=" + startTime + ", endTime=" + endTime + ", studentQuantity=" + studentQuantity + ", daysOfWeek=" + String.join(",", Arrays.asList(daysOfWeek).stream().map(t -> t.toString()).collect(Collectors.toList())) + '}';
    }

}
