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

/**
 *
 * @author PC
 */
public class GradeView {

    public static void main(String[] args) {
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = gradeService.getGrades();
        System.out.println("List grades: ");
        grades.forEach(item -> System.out.println(item));
    }

}
