/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Register;
import entities.StudentUnofficial;
import java.util.List;

/**
 *
 * @author USER
 */
public interface RegisterService {

    public void insertRegister(Register register);

    public void insertRegisters(List<StudentUnofficial> students);

    public boolean updateRegister(Register register);
}
