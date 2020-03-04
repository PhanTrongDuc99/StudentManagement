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
public class Teacher {

    private String idTeacher;
    private Profile profileTeacher;
    private Double salary;
    private TimeKeeping timeKeeping;
    private String workPlace;

    public Teacher() {
    }

    public Teacher(String idTeacher, Profile profileTeacher, Double salary, TimeKeeping timeKeeping, String workPlace) {
        this.idTeacher = idTeacher;
        this.profileTeacher = profileTeacher;
        this.salary = salary;
        this.timeKeeping = timeKeeping;
        this.workPlace = workPlace;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Profile getProfileTeacher() {
        return profileTeacher;
    }

    public void setProfileTeacher(Profile profileTeacher) {
        this.profileTeacher = profileTeacher;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public TimeKeeping getTimeKeeping() {
        return timeKeeping;
    }

    public void setTimeKeeping(TimeKeeping timeKeeping) {
        this.timeKeeping = timeKeeping;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

}
