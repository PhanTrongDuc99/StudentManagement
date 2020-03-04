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
public class Result {

    private Double studyMark;
    private Double rewardMark;
    private Double disciplineMark;
    private Integer numberOfAbsences;

    public Result() {
    }

    public Result(Double studyMark, Double rewardMark, Double disciplineMark, Integer numberOfAbsences) {
        this.studyMark = studyMark;
        this.rewardMark = rewardMark;
        this.disciplineMark = disciplineMark;
        this.numberOfAbsences = numberOfAbsences;
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

}
