/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entities.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public List<Student> readStudentFromExcelFile(String excelFilePath) {
        return studentDao.readStudentFromExcelFile(excelFilePath);
    }

}
