/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Teacher;
import entities.TimeKeeping;
import java.util.List;

/**
 *
 * @author USER
 */
public interface TimeKeepingDao {


    public void insertTimeKeeping(List<Teacher> teachers);
}
