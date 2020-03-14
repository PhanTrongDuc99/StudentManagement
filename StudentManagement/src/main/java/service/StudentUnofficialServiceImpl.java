/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import common.ReadFromExcelFile;
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
    public void insertStudentsFromExcelFile(List<StudentUnofficial> students) {
        studentUnofficialDao.insertStudent(students);
    }
}
