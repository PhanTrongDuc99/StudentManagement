/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TeacherDao;
import dao.TeacherDaoImpl;
import entities.Teacher;
import java.util.List;

/**
 *
 * @author PC
 */
public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    public TeacherServiceImpl() {
        teacherDao = new TeacherDaoImpl();
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

}
