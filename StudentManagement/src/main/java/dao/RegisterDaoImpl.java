/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Register;
import entities.StudentUnofficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public class RegisterDaoImpl implements RegisterDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String query = "INSERT INTO register( State, TypeOfRegister, Id ) VALUES (?,?,?)";

    public RegisterDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public void insertRegister(Register register) {
        int affectedRows = 0;
        connection = connectionManager.getConnection();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, register.getStatus().getNote());
            preparedStatement.setString(2, register.getType().getNote());
            preparedStatement.setString(3, register.getId());
            preparedStatement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void insertRegisters(List<StudentUnofficial> students) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (StudentUnofficial student : students) {
                Register register = student.getRegister();
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, register.getStatus().getNote());
                preparedStatement.setString(2, register.getType().getNote());
                preparedStatement.setString(3, register.getId());
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

}
