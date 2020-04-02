/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentOfficialDao;
import dao.StudentOfficialDaoImpl;
import entities.StudentOfficial;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentOfficialServiceImpl implements StudentOfficialService {

    private StudentOfficialDao studentOfficialDao;

    public StudentOfficialServiceImpl() {
        studentOfficialDao = new StudentOfficialDaoImpl();
    }

    @Override
    public List<StudentOfficial> getAll() {
        return studentOfficialDao.getAll();
    }

    @Override
    public StudentOfficial getStudent(String id) {
        return studentOfficialDao.getStudent(id);
    }

    @Override
    public void insertStudent(StudentOfficial student) {
        studentOfficialDao.insertStudent(student);
    }

    @Override
    public boolean deleteStudentById(String id) {
        return studentOfficialDao.deleteStudentById(id);
    }

}
