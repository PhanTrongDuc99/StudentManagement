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
public class Result {

    private Double studyMark;
    private Double rewardMark;
    private Double disciplineMark;
    private Double moneyPaid;
    private Integer numberOfAbsences;
    private String idGrade;
    private String id;

    public Result() {
    }

    public Result(Double studyMark, Double rewardMark, Double disciplineMark, Double moneyPaid, Integer numberOfAbsences, String idGrade, String id) {
        this.studyMark = studyMark;
        this.rewardMark = rewardMark;
        this.disciplineMark = disciplineMark;
        this.moneyPaid = moneyPaid;
        this.numberOfAbsences = numberOfAbsences;
        this.idGrade = idGrade;
        this.id = id;
    }

    public String getIdGrade() {
        return idGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdGrade(String idGrade) {
        this.idGrade = idGrade;
    }

    public Double getStudyMark() {
        return studyMark;
    }

    public void setStudyMark(Double studyMark) {
        this.studyMark = studyMark;
    }

    public Double getRewardMark() {
        return rewardMark;
    }

    public void setRewardMark(Double rewardMark) {
        this.rewardMark = rewardMark;
    }

    public Double getDisciplineMark() {
        return disciplineMark;
    }

    public void setDisciplineMark(Double disciplineMark) {
        this.disciplineMark = disciplineMark;
    }

    public Integer getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void setNumberOfAbsences(Integer numberOfAbsences) {
        this.numberOfAbsences = numberOfAbsences;
    }

    public Double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(Double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.studyMark);
        hash = 71 * hash + Objects.hashCode(this.rewardMark);
        hash = 71 * hash + Objects.hashCode(this.disciplineMark);
        hash = 71 * hash + Objects.hashCode(this.moneyPaid);
        hash = 71 * hash + Objects.hashCode(this.numberOfAbsences);
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
        final Result other = (Result) obj;
        if (!Objects.equals(this.studyMark, other.studyMark)) {
            return false;
        }
        if (!Objects.equals(this.rewardMark, other.rewardMark)) {
            return false;
        }
        if (!Objects.equals(this.disciplineMark, other.disciplineMark)) {
            return false;
        }
        if (!Objects.equals(this.moneyPaid, other.moneyPaid)) {
            return false;
        }
        if (!Objects.equals(this.numberOfAbsences, other.numberOfAbsences)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Result{" + "studyMark=" + studyMark + ", rewardMark=" + rewardMark + ", disciplineMark=" + disciplineMark + ", moneyPaid=" + moneyPaid + ", numberOfAbsences=" + numberOfAbsences + ", idGrade=" + idGrade + ", id=" + id + '}';
    }

}
