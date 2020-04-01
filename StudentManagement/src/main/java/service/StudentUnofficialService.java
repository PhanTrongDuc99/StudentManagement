/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.StudentUnofficial;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentUnofficialService {

    public List<StudentUnofficial> getAll();

    public StudentUnofficial getStudent(String string);

    public void insertStudent(StudentUnofficial student);

    public void insertStudents(List<StudentUnofficial> students);

    public void deleteStudentByIdCourse(String idCourse);

    public boolean deleteUnofficialStudentById(String id);
}
