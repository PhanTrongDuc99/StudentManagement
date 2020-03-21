/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AdminDao;
import dao.AdminDaoImp;
import entities.Admin;

/**
 *
 * @author SMILE ^^
 */
public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao;

    public AdminServiceImpl() {
        adminDao = new AdminDaoImp();
    }

    @Override
    public Admin getAdmin(String username, String password) {
        return adminDao.getAdmin(username, password);
    }

}
