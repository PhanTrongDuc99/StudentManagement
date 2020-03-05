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
public class Student {

    private String idStudent;
    private Profile profileStudent;
    private Double discountStatus;
    private Double cost;
    private Register register;

    public Student() {
    }

    public Student(String idStudent, Profile profileStudent, Double discountStatus, Double cost, Register register) {
        this.idStudent = idStudent;
        this.profileStudent = profileStudent;
        this.discountStatus = discountStatus;
        this.cost = cost;
        this.register = register;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public Profile getProfileStudent() {
        return profileStudent;
    }

    public void setProfileStudent(Profile profileStudent) {
        this.profileStudent = profileStudent;
    }

    public Double getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(Double discountStatus) {
        this.discountStatus = discountStatus;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idStudent);
        hash = 67 * hash + Objects.hashCode(this.profileStudent);
        hash = 67 * hash + Objects.hashCode(this.discountStatus);
        hash = 67 * hash + Objects.hashCode(this.cost);
        hash = 67 * hash + Objects.hashCode(this.register);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.idStudent, other.idStudent)) {
            return false;
        }
        if (!Objects.equals(this.profileStudent, other.profileStudent)) {
            return false;
        }
        if (!Objects.equals(this.discountStatus, other.discountStatus)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.register, other.register)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", profileStudent=" + profileStudent + ", discountStatus=" + discountStatus + ", cost=" + cost + ", register=" + register + '}';
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

}
