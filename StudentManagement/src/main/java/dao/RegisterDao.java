/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Register;
import entities.StudentUnofficial;
import java.util.List;

/**
 *
 * @author USER
 */
public interface RegisterDao {

    public void insertRegister(Register register);

    public void insertRegisters(List<StudentUnofficial> students);

    public Register getRegister(String id);

    public boolean updateRegister(Register register);
}
