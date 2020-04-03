/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentUnofficialDaoImpl;
import entities.StudentUnofficial;
import java.util.List;
import dao.StudentUnofficialDao;

/**
 *
 * @author PC
 */
public class StudentUnofficialServiceImpl implements StudentUnofficialService {

    private StudentUnofficialDao studentUnofficialDao;

    public StudentUnofficialServiceImpl() {
        studentUnofficialDao = new StudentUnofficialDaoImpl();
    }

    @Override
    public List<StudentUnofficial> getAll() {
        return studentUnofficialDao.getAll();
    }

    @Override
    public void insertStudent(StudentUnofficial student) {
        studentUnofficialDao.insertStudent(student);
    }

    @Override
    public void insertStudents(List<StudentUnofficial> students) {
        studentUnofficialDao.insertStudents(students);
    }

    @Override
    public StudentUnofficial getStudent(String string) {
        return studentUnofficialDao.getStudent(string);
    }

    @Override
    public boolean deleteUnofficialStudentById(String id) {
        return studentUnofficialDao.deleteUnofficialStudentById(id);
    }

    public void deleteStudentByIdCourse(String idCourse) {
        studentUnofficialDao.deleteStudentByIdCourse(idCourse);
    }

    @Override
    public List<StudentUnofficial> getStudentByIdCourse(String idCourse) {
        return studentUnofficialDao.getStudentByIdCourse(idCourse);
    }

}
