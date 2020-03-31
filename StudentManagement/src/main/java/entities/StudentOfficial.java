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
public class StudentOfficial extends StudentUnofficial {

    private Result resultStudy;

    public StudentOfficial() {
        super(null, null, null, null, null);
    }

    public StudentOfficial(Result resultStudy, String id, Profile profile, Double discountStatus, Double cost, Register register, String idRegisterCourse) {
        super(id, profile, discountStatus, cost, register, idRegisterCourse);
        this.resultStudy = resultStudy;
    }

    public Result getResultStudy() {
        return resultStudy;
    }

    public void setResultStudy(Result resultStudy) {
        this.resultStudy = resultStudy;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.resultStudy);
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
        final StudentOfficial other = (StudentOfficial) obj;
        if (!Objects.equals(this.resultStudy, other.resultStudy)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentOfficial{" + super.toString() + "resultStudy=" + resultStudy + '}';
    }
}
