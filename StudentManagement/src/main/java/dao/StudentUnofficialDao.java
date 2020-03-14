/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.StudentUnofficial;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StudentUnofficialDao {

    public List<StudentUnofficial> getAll();

    public void insertStudent(List<StudentUnofficial> students);

    //public List<Student> readStudentFromExcelFile(String excelFilePath);
}
