/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Profile;
import entities.Register;
import java.util.List;
import entities.StudentUnofficial;
import readFromExcelFile.ReadStudentUnofficicalFromExcelFile;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.RegisterService;
import service.RegisterServiceImpl;
import service.StudentUnofficialServiceImpl;
import service.StudentUnofficialService;

/**
 *
 * @author PC
 */
public class StudentUnofficialView {

    public static void main(String[] args) {
        ProfileService prService = new ProfileServiceImpl();
        RegisterService reService = new RegisterServiceImpl();
        StudentUnofficialService st = new StudentUnofficialServiceImpl();
        List<StudentUnofficial> students = ReadStudentUnofficicalFromExcelFile.readStudentFromExcelFile("F:\\JavaProject\\StudentManagement\\student.xlsx");
        prService.insertProfileStudent(students);
        reService.insertRegisters(students);
        st.insertStudents(students);
        // prService.insertProfileStudent(students);

        // List<Student> students = ReadFromExcelFile.readStudentFromExcelFile("F:\\JavaProject\\StudentManagement\\student.xlsx");
        //students.forEach(System.out::println);
        //prService.insertProfileStudent(students);
        //studentService.insertStudentsFromExcelFile(students);
    }
}
