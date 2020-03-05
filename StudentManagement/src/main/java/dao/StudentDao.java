/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentDao {
   List<Student> getAll();

    void insertStudent(List<Student> students);

    List<Student> readStudentFromExcelFile(String excelFilePath);
    
}
