/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Teacher;
import java.util.List;

/**
 *
 * @author PC
 */
public interface TeacherService {

    public List<Teacher> getAll();

    public void insertTeacher(Teacher teacher);

    public void insertTeachers(List<Teacher> teachers);

}
