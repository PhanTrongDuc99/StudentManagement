/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import entities.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author PC
 */
public class StudentView {
    
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.getStudents();
        System.out.println("List students: ");
        students.forEach(item -> System.out.println(item));
        //studentService.insertStudentsFromExcelFile();
        //System.out.println("Insert thành công");
    }
}
