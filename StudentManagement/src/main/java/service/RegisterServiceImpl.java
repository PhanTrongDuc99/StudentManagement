/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RegisterDao;
import dao.RegisterDaoImpl;
import entities.Register;
import entities.StudentUnofficial;
import java.util.List;

/**
 *
 * @author USER
 */
public class RegisterServiceImpl implements RegisterService {

    private RegisterDao registerDao;

    public RegisterServiceImpl() {
        registerDao = new RegisterDaoImpl();
    }

    @Override
    public void insertRegister(Register register) {
        registerDao.insertRegister(register);
    }

    @Override
    public void insertRegisters(List<StudentUnofficial> students) {
        registerDao.insertRegisters(students);
    }

}
