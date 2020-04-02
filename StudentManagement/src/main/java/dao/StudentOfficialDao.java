/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.StudentOfficial;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentOfficialDao {

    public List<StudentOfficial> getAll();

    public StudentOfficial getStudent(String id);

    public void insertStudent(StudentOfficial student);

    public boolean deleteStudentById(String id);
}
