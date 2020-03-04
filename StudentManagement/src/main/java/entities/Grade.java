/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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

}
