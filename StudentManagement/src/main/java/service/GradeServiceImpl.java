/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GradeDao;
import dao.GradeDaoImpl;
import entities.Grade;
import java.util.List;

/**
 *
 * @author PC
 */
public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao;

    public GradeServiceImpl() {
        gradeDao = new GradeDaoImpl();
    }

    @Override
    public List<Grade> getAll() {
        return gradeDao.getAll();
    }

    @Override
    public void insertGrades(List<Grade> grades) {
        gradeDao.insertGrade(grades);
    }

    @Override
    public Grade getGrade(String id) {
        return gradeDao.getGrade(id);
    }

    @Override

    public List<Grade> getAllGradesOfCourse(String idCourse) {
        return gradeDao.getAllGradesOfCourse(idCourse);
    }

    public void deleteGradeByIdCourse(String idCourse) {
        gradeDao.deleteGradeByIdCourse(idCourse);
    }

    @Override
    public boolean deleteGradeById(String id) {
        return gradeDao.deleteGradeById(id);
    }

    @Override
    public boolean updateGradeById(String id, Grade grade) {
        return gradeDao.updateGradeById(id, grade);
    }

    @Override
    public boolean insertGrade(Grade grade) {
        return gradeDao.insertGrade(grade);
    }

}
