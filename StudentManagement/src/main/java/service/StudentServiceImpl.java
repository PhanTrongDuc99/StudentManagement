/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import common.ReadFromExcelFile;
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
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void insertStudentsFromExcelFile(List<Student> students) {
        studentDao.insertStudent(students);
    }
}
