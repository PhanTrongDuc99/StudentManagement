/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CourseDao;
import dao.CourseDaoImpl;
import entities.Course;
import java.util.List;

/**
 *
 * @author PC
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl() {
        courseDao = new CourseDaoImpl();
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public void insertCourses(List<Course> courses) {
        courseDao.insertCourses(courses);
    }

    @Override
    public Course getCourseById(String id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void deleteCourseById(String id) {
        courseDao.deleteCourseById(id);
    }

    @Override
    public void updateCourseById(String id, Course course) {
        courseDao.updateCourseById(id, course);
    }

    @Override
    public void insertCourse(Course course) {
        courseDao.insertCourse(course);
    }
    

}
