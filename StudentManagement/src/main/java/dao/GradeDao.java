/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Grade;
import java.util.List;

/**
 *
 * @author PC
 */
public interface GradeDao {

    public Grade getGrade(String id);

    public List<Grade> getAll();

    public void insertGrade(List<Grade> grades);

    public List<Grade> getAllGradesOfCourse(String idCourse);

    public void deleteGradeByIdCourse(String idCourse);

    public boolean deleteGradeById(String id);

    public boolean updateGradeById(String id, Grade grade);

}
