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

    private String id;
    private Double teachingHours;
    private String rewardLevel;
    private String disciplineLevel;
    private String idTeacher;

    public TimeKeeping() {
    }

    public TimeKeeping(String id, Double teachingHours, String rewardLevel, String disciplineLevel, String idTeacher) {
        this.id = id;
        this.teachingHours = teachingHours;
        this.rewardLevel = rewardLevel;
        this.disciplineLevel = disciplineLevel;
        this.idTeacher = idTeacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "TimeKeeping{" + "id=" + id + ", teachingHours=" + teachingHours + ", rewardLevel=" + rewardLevel + ", disciplineLevel=" + disciplineLevel + ", idTeacher=" + idTeacher + '}';
    }

}
