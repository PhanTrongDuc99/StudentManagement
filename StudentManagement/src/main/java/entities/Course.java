/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class Course {

    private String idCourse;
    private String nameCourse;
    private Date startTime;
    private Date endTime;
    private Integer gradeQuantity;
    private Double cost;

    public Course() {
    }

    public Course(String idCourse, String nameCourse, Date startTime, Date endTime, Integer gradeQuantity, Double cost) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gradeQuantity = gradeQuantity;
        this.cost = cost;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getGradeQuantity() {
        return gradeQuantity;
    }

    public void setGradeQuantity(Integer gradeQuantity) {
        this.gradeQuantity = gradeQuantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double Cost) {
        this.cost = Cost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idCourse);
        hash = 23 * hash + Objects.hashCode(this.nameCourse);
        hash = 23 * hash + Objects.hashCode(this.startTime);
        hash = 23 * hash + Objects.hashCode(this.endTime);
        hash = 23 * hash + Objects.hashCode(this.gradeQuantity);
        hash = 23 * hash + Objects.hashCode(this.cost);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.idCourse, other.idCourse)) {
            return false;
        }
        if (!Objects.equals(this.nameCourse, other.nameCourse)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (!Objects.equals(this.gradeQuantity, other.gradeQuantity)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdCourse: " + idCourse + " - " + "NameCourse: " + nameCourse + " - " + "StartDay: " + startTime + " - " + "EndDay: " + " - " + endTime + " - " + "Price: " + cost;
    }

}
