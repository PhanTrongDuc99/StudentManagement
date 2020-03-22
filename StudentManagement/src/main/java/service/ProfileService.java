/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Profile;
import entities.StudentUnofficial;
import entities.Teacher;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ProfileService {

    public List<Profile> getProfileStudents();

    public List<Profile> getProfileTeacher();

    public void insertProfile(Profile profile);

    public void insertProfileStudent(List<StudentUnofficial> students);

    public void insertProfileTeacher(List<Teacher> teachers);
}
