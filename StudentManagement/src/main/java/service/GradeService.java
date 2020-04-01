/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Grade;
import java.util.List;

/**
 *
 * @author PC
 */
public interface GradeService {

    public List<Grade> getAll();

    public Grade getGrade(String id);

    public void insertGrades(List<Grade> grades);

    public List<Grade> getAllGradesOfCourse(String idCourse);

    public void deleteGradeByIdCourse(String idCourse);
}
