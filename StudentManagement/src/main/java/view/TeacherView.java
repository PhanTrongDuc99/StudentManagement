/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProfileDao;
import dao.ProfileDaoImpl;
import entities.Profile;
import entities.Teacher;
import java.util.List;
import readFromExcelFile.ReadTeacherFromExcelFile;
import service.TeacherService;
import service.TeacherServiceImpl;

/**
 *
 * @author PC
 */
public class TeacherView {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherServiceImpl();
        ProfileDao prDao = new ProfileDaoImpl();
        List<Teacher> teachers = ReadTeacherFromExcelFile.readTeacherFromFile("F:\\JavaProject\\StudentManagement\\teacher.xlsx");
        for (Teacher teacher : teachers) {
            Profile profile = teacher.getProfileTeacher();
            prDao.insertProfile(profile);
            teacherService.insertTeacher(teacher);
        }
    }

}
