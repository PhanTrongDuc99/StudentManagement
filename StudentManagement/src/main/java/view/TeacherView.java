/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Teacher;
import java.util.List;
import service.TeacherService;
import service.TeacherServiceImpl;

/**
 *
 * @author PC
 */
public class TeacherView {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> teachers = teacherService.getAll();
        System.out.println("List teachers: ");
        teachers.forEach(item -> System.out.println(item));

    }

}
