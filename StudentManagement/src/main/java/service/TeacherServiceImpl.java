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

    @Override
    public void insertTeacher(Teacher teacher) {
        teacherDao.insertTeacher(teacher);
    }

    @Override
    public void insertTeachers(List<Teacher> teachers) {
        teacherDao.insertTeachers(teachers);
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherDao.getTeacher(id);
    }

}
