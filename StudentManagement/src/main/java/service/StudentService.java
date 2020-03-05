/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Student;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentService {

    public List<Student> getStudents();
    public List<Student> readStudentFromExcelFile(String excelFilePath);
}

