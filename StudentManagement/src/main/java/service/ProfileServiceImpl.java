/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProfileDao;
import dao.ProfileDaoImpl;
import entities.Profile;
import entities.StudentUnofficial;
import entities.Teacher;
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
    public void insertProfile(Profile profile) {
        profileDao.insertProfile(profile);
    }

    @Override
    public void insertProfileStudent(List<StudentUnofficial> students) {
        profileDao.insertProfileStudents(students);
    }

    @Override
    public void insertProfileTeacher(List<Teacher> teachers) {
        profileDao.insertProfileTeachers(teachers);
    }

    @Override
    public List<Profile> getProfileStudents() {
        return profileDao.getProfileStudent();
    }

    @Override
    public List<Profile> getProfileTeacher() {
        return profileDao.getProfileTeacher();
    }

}
