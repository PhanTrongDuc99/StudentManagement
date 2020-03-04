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
    private Result result;
    private Double discountCoefficient;
    private Register register;

    public Student() {
    }

    public Student(String idStudent, Profile profileStudent, Result result, Double discountCoefficient, Register register) {
        this.idStudent = idStudent;
        this.profileStudent = profileStudent;
        this.result = result;
        this.discountCoefficient = discountCoefficient;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Double getDiscountCoefficient() {
        return discountCoefficient;
    }

    public void setDiscountCoefficient(Double discountCoefficient) {
        this.discountCoefficient = discountCoefficient;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

}
