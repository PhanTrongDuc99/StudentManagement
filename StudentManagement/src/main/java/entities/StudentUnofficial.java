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
public class StudentUnofficial {

    private String id;
    private Profile profile;
    private Double discountStatus;
    private Double cost;
    private Register register;
    private String idRegisterGrade;

    public StudentUnofficial() {
    }

    public StudentUnofficial(String id, Profile profile, Double discountStatus, Double cost, Register register) {
        this.id = id;
        this.profile = profile;
        this.discountStatus = discountStatus;
        this.cost = cost;
        this.register = register;
    }

    public StudentUnofficial(String id, Profile profile, Double discountStatus, Double cost, Register register, String idRegisterGrade) {
        this.id = id;
        this.profile = profile;
        this.discountStatus = discountStatus;
        this.cost = cost;
        this.register = register;
        this.idRegisterGrade = idRegisterGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public String getIdRegisterGrade() {
        return idRegisterGrade;
    }

    public void setIdRegisterGrade(String idRegisterGrade) {
        this.idRegisterGrade = idRegisterGrade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.profile);
        hash = 29 * hash + Objects.hashCode(this.discountStatus);
        hash = 29 * hash + Objects.hashCode(this.cost);
        hash = 29 * hash + Objects.hashCode(this.register);
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
        final StudentUnofficial other = (StudentUnofficial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.profile, other.profile)) {
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
        return "StudentUnofficial{" + "id=" + id + ", profile=" + profile + ", discountStatus=" + discountStatus + ", cost=" + cost + ", register=" + register + '}';
    }

}
