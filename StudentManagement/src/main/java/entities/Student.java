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
public class Student {
    private String idStudent;
    private Profile profileStudent;
    private Double discountStatus;
    private Float cost;
    private Register register;

    public Student() {
    }

    public Student(String idStudent, Profile profileStudent, Double discountStatus, Float cost, Register register) {
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    

}
