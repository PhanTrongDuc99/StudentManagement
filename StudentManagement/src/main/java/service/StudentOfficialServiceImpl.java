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

    private StudentOfficialDao studentUnofficialDao;

    public StudentOfficialServiceImpl() {
        studentUnofficialDao = new StudentOfficialDaoImpl();
    }

    @Override
    public List<StudentOfficial> getAll() {
        return studentUnofficialDao.getAll();
    }

    @Override
    public StudentOfficial getStudent(String id) {
        return studentUnofficialDao.getStudent(id);
    }

}
