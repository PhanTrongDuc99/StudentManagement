/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfileDao;
import dao.ProfileDaoImpl;
import entities.Student;
import java.util.List;

/**
 *
 * @author USER
 */
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;

    public ProfileServiceImpl() {
        profileDao = new ProfileDaoImpl();
    }

    @Override
    public void insertProfileStudent(List<Student> students) {
        profileDao.insertProfileStudent(students);
    }

}
