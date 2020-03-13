/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.ReadFromExcelFile;
import java.util.List;
import entities.Student;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

/**
 *
 * @author PC
 */
public class StudentView {

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        ProfileService prService = new ProfileServiceImpl();
        List<Student> students = studentService.getAll();
        System.out.println("List students: ");
        students.forEach(item -> System.out.println(item));
        // List<Student> students = ReadFromExcelFile.readStudentFromExcelFile("F:\\JavaProject\\StudentManagement\\student.xlsx");
        //students.forEach(System.out::println);
        //prService.insertProfileStudent(students);
        //studentService.insertStudentsFromExcelFile(students);
    }
}
