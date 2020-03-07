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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.idTeacher);
        hash = 73 * hash + Objects.hashCode(this.profileTeacher);
        hash = 73 * hash + Objects.hashCode(this.salary);
        hash = 73 * hash + Objects.hashCode(this.timeKeeping);
        hash = 73 * hash + Objects.hashCode(this.workPlace);
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
        final Teacher other = (Teacher) obj;
        if (!Objects.equals(this.idTeacher, other.idTeacher)) {
            return false;
        }
        if (!Objects.equals(this.workPlace, other.workPlace)) {
            return false;
        }
        if (!Objects.equals(this.profileTeacher, other.profileTeacher)) {
            return false;
        }
        if (!Objects.equals(this.salary, other.salary)) {
            return false;
        }
        if (!Objects.equals(this.timeKeeping, other.timeKeeping)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Teacher{" + "idTeacher=" + idTeacher + ", profileTeacher=" + profileTeacher + ", salary=" + salary + ", timeKeeping=" + timeKeeping + ", workPlace=" + workPlace + '}';
    }

}
