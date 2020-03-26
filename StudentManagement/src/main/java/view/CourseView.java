/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Course;
import java.util.List;
import readFromExcelFile.ReadCourseFromExcelFile;
import service.CourseService;
import service.CourseServiceImpl;

/**
 *
 * @author PC
 */
public class CourseView {

    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        List<Course> courses = ReadCourseFromExcelFile.readCourseFromExcelFile("F:\\JavaProject\\StudentManagement\\course.xlsx");
        courseService.insertCourses(courses);
        courses.forEach(item -> System.out.println(item));
    }

}
