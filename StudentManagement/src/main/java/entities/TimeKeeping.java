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
public class TimeKeeping {

    private Double teachingHours;
    private String rewardLevel;
    private String disciplineLevel;

    public TimeKeeping() {
    }

    public TimeKeeping(Double teachingHours, String rewardLevel, String disciplineLevel) {
        this.teachingHours = teachingHours;
        this.rewardLevel = rewardLevel;
        this.disciplineLevel = disciplineLevel;
    }

    public Double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(Double teachingHours) {
        this.teachingHours = teachingHours;
    }

    public String getRewardLevel() {
        return rewardLevel;
    }

    public void setRewardLevel(String rewardLevel) {
        this.rewardLevel = rewardLevel;
    }

    public String getDisciplineLevel() {
        return disciplineLevel;
    }

    public void setDisciplineLevel(String disciplineLevel) {
        this.disciplineLevel = disciplineLevel;
    }

    @Override
    public String toString() {
        return "TimeKeeping{" + "teachingHours=" + teachingHours + ", rewardLevel=" + rewardLevel + ", disciplineLevel=" + disciplineLevel + '}';
    }

}
