/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Profile;
import entities.StudentUnofficial;
import entities.Teacher;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ProfileDao {
    
    public List<Profile> getProfileStudent();

    public void insertProfile(Profile profile);

    public void insertProfileStudents(List<StudentUnofficial> students);

    public void insertProfileTeachers(List<Teacher> teachers);

}
