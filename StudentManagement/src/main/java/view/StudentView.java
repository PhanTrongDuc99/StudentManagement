/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Student;
import java.util.List;
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
        List<Student> studentsReadToExcel = studentService.readStudentFromExcelFile("");
        students.forEach(item -> System.out.println("Student:" + item));
    }
}
