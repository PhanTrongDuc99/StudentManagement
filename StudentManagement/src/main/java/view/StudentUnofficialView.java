/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.ReadFromExcelFile;
import java.util.List;
import entities.StudentUnofficial;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.StudentUnofficialServiceImpl;
import service.StudentUnofficialService;

/**
 *
 * @author PC
 */
public class StudentUnofficialView {

    public static void main(String[] args) {
        StudentUnofficialService studentUnofficialService = new StudentUnofficialServiceImpl();
        ProfileService prService = new ProfileServiceImpl();
        List<StudentUnofficial> students = studentUnofficialService.getAll();
        System.out.println("List students: ");
        students.forEach(item -> System.out.println(item));
        // List<Student> students = ReadFromExcelFile.readStudentFromExcelFile("F:\\JavaProject\\StudentManagement\\student.xlsx");
        //students.forEach(System.out::println);
        //prService.insertProfileStudent(students);
        //studentService.insertStudentsFromExcelFile(students);
    }
}
