/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Grade;
import java.util.List;
import service.GradeService;
import service.GradeServiceImpl;
import utils.FileUtils;

/**
 *
 * @author PC
 */
public class GradeView {

    public static void main(String[] args) {
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = readFromExcelFile.ReadGradeFromExcelFile.readGradeFromExcelFile(FileUtils.getPath("excels", "grade.xlsx"));
        System.out.println("List grades: ----------");
        grades.forEach(item -> System.out.println(item.getTeacher().getIdTeacher()));
        gradeService.insertGrades(grades);
        
        System.out.println(gradeService.getGrade("Class01"));
    }

}
