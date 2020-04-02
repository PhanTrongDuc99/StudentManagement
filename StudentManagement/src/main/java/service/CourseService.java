/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Course;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CourseService {

    public List<Course> getAll();

    public Course getCourseById(String id);

    public void deleteCourseById(String id);

    public void updateCourseById(String id, Course course);

    public void insertCourses(List<Course> courses);

    public void insertCourse(Course course);

}
