/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.StudentOfficial;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentOfficialService {

    public List<StudentOfficial> getAll();

    public StudentOfficial getStudent(String id);
    
    public List<StudentOfficial> getStudentsByNameGrade(String nameGrade);

    public void insertStudent(StudentOfficial student);

    public boolean deleteStudentById(String id);
}
