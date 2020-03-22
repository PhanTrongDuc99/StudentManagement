/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Teacher;
import java.util.List;
import readFromExcelFile.ReadTeacherFromExcelFile;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.TeacherService;
import service.TeacherServiceImpl;
import service.TimeKeepingService;
import service.TimeKeepingServiceImpl;

/**
 *
 * @author PC
 */
public class TeacherView {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherServiceImpl();
        TimeKeepingService tkS = new TimeKeepingServiceImpl();
        ProfileService pro = new ProfileServiceImpl();
        // ProfileDao prDao = new ProfileDaoImpl();

        List<Teacher> teachers = ReadTeacherFromExcelFile.readTeacherFromFile("F:\\JavaProject\\StudentManagement\\teacher.xlsx");
        pro.insertProfileTeacher(teachers);
        tkS.insertTimeKeeping(teachers);
        teacherService.insertTeachers(teachers);

        //listProfileTeachers.forEach(t -> System.out.println(t.getId()));
//        prDao.insertProfileTeachers(teachers);
//        teacherService.insertTeachers(teachers);
    }

}
