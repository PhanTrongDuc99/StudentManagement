/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SMILE ^^
 */
public class AdminDaoImp implements AdminDao {

    private Connection connection;
    private ConnectionManager connectionManager;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminDaoImp() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public Admin getAdmin(String username, String password) {
        connection = connectionManager.getConnection();
        Admin admin = null;
        String query = "SELECT * FROM studentmanagement.admin WHERE Username=?\n" + "AND Password=?";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                admin = new Admin(rs.getString("Id"), rs.getString("Username"), rs.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pst.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return admin;
    }
}
