/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Course {

    private String idCourse;
    private String nameCourse;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer gradeQuantity;
    private Double Cost;

    public Course() {
    }

    public Course(String idCourse, String nameCourse, LocalDate startTime, LocalDate endTime, Integer gradeQuantity, Double Cost) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gradeQuantity = gradeQuantity;
        this.Cost = Cost;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public Integer getGradeQuantity() {
        return gradeQuantity;
    }

    public void setGradeQuantity(Integer gradeQuantity) {
        this.gradeQuantity = gradeQuantity;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double Cost) {
        this.Cost = Cost;
    }

}
