/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class Grade {

    private String idGrade;
    private String nameGrade;
    private Schedule scheduleGrade;
    private Teacher idTeacher;
    private Course idCourse;
    private Integer studentQuantity;

    public Grade() {
    }

    public Grade(String idGrade, String nameGrade, Schedule scheduleGrade, Teacher idTeacher, Course idCourse, Integer studentQuantity) {
        this.idGrade = idGrade;
        this.nameGrade = nameGrade;
        this.scheduleGrade = scheduleGrade;
        this.idTeacher = idTeacher;
        this.idCourse = idCourse;
        this.studentQuantity = studentQuantity;
    }

    public Grade(String idGrade, String nameGrade, Schedule scheduleGrade, Integer studentQuantity) {
        this.idGrade = idGrade;
        this.nameGrade = nameGrade;
        this.scheduleGrade = scheduleGrade;
        this.studentQuantity = studentQuantity;
        this.idCourse=null;
        this.idTeacher=null;
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

    public Schedule getScheduleGrade() {
        return scheduleGrade;
    }

    public void setScheduleGrade(Schedule scheduleGrade) {
        this.scheduleGrade = scheduleGrade;
    }

    public Teacher getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Teacher idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(Integer studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idGrade);
        hash = 53 * hash + Objects.hashCode(this.nameGrade);
        hash = 53 * hash + Objects.hashCode(this.scheduleGrade);
        hash = 53 * hash + Objects.hashCode(this.idTeacher);
        hash = 53 * hash + Objects.hashCode(this.idCourse);
        hash = 53 * hash + Objects.hashCode(this.studentQuantity);
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
        final Grade other = (Grade) obj;
        if (!Objects.equals(this.idGrade, other.idGrade)) {
            return false;
        }
        if (!Objects.equals(this.nameGrade, other.nameGrade)) {
            return false;
        }
        if (!Objects.equals(this.scheduleGrade, other.scheduleGrade)) {
            return false;
        }
        if (!Objects.equals(this.idTeacher, other.idTeacher)) {
            return false;
        }
        if (!Objects.equals(this.idCourse, other.idCourse)) {
            return false;
        }
        if (!Objects.equals(this.studentQuantity, other.studentQuantity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grade{" + "idGrade=" + idGrade + ", nameGrade=" + nameGrade + ", scheduleGrade=" + scheduleGrade + ", idTeacher=" + idTeacher + ", idCourse=" + idCourse + ", studentQuantity=" + studentQuantity + '}';
    }

}
