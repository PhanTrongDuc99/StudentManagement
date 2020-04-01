/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Teacher;
import entities.TimeKeeping;
import java.util.List;

/**
 *
 * @author USER
 */
public interface TimeKeepingService {

    public void insertTimeKeeping(List<Teacher> teachers);

    public TimeKeeping getTimeKeeping(String id);
}
