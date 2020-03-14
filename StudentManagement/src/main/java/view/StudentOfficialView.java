/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.StudentOfficial;
import java.util.List;
import service.StudentOfficialService;
import service.StudentOfficialServiceImpl;

/**
 *
 * @author PC
 */
public class StudentOfficialView {
    
    public static void main(String[] args) {
        StudentOfficialService studentOfficialService = new StudentOfficialServiceImpl();
        List<StudentOfficial> studentOfficials = studentOfficialService.getAll();
        System.out.println("List studentOfficials: ");
        studentOfficials.forEach(item -> System.out.println(item));
    }
}
