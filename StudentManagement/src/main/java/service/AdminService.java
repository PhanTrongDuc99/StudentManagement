/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Admin;

/**
 *
 * @author SMILE ^^
 */
public interface AdminService {

    public Admin getAdmin(String username, String password);

}
