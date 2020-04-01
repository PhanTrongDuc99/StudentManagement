/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.RegisterStatus;
import common.RegisterType;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Register;
import entities.StudentUnofficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private ResultSet result;
    private final String query = "INSERT INTO register( State, TypeOfRegister, Id ) VALUES(?, ?, ?)";
    int rowsAffected = 0;

    public RegisterDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public Register getRegister(String id) {
        String query = "SELECT Id,State,TypeOfRegister FROM REGISTER WHERE Id='" + id + "'";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Register register = new Register();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                register.setId(result.getString("Id"));
                register.setStatus(RegisterStatus.valueOf(result.getString("State").toUpperCase()));
                register.setType(RegisterType.valueOf(result.getString("TypeOfRegister").toUpperCase()));
            }
            return register;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insertRegister(Register register) {
        try {
            String queryRegister = "INSERT INTO register(State, TypeOfRegister, Id ) VALUES(?,?,?)";
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(queryRegister);
            preparedStatement.setString(1, register.getStatus().toString());
            preparedStatement.setString(2, register.getType().toString());
            preparedStatement.setString(3, register.getId());
            preparedStatement.executeUpdate();
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
                preparedStatement.setString(1, register.getStatus().toString());
                preparedStatement.setString(2, register.getType().toString());
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

    @Override
    public boolean updateRegister(Register register) {
        String query = "UPDATE `studentmanagement`.`register` " + "SET `State` = ?" + " WHERE `Id` = '" + register.getId() + "'";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, register.getStatus().toString());

            rowsAffected = preparedStatement.executeUpdate();
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
        return rowsAffected != 0;
    }

}
