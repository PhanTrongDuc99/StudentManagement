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

    public List<Student> getAll();

    public void insertStudent(List<Student> students);

    //public List<Student> readStudentFromExcelFile(String excelFilePath);
}
