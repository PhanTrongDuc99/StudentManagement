/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author PC
 */
public class StudentView {

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        studentService.insertStudentsFromExcelFile();
        ///List<Student> students = studentService.getStudents();
        System.out.println("insert thành công");
        //StudentDaoImpl std= new StudentDaoImpl();
    }
}
