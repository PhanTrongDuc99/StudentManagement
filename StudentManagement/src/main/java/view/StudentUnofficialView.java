/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
        students.forEach(x -> {
            System.out.println("ID: " + x.getProfile().getId());
        });

        prService.insertProfileStudent(students);
        reService.insertRegisters(students);
        st.insertStudents(students);

//        Profile profile = new Profile("0000", "Hong", true, Date.valueOf(LocalDate.of(1999, 9, 8)), "1321232", "000000000", "nguyenhong1999@gmail.com", "QB", "QB");
//        prService.insertProfile(profile);
    }
}
