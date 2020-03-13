/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.DateUtils;

/**
 *
 * @author USER
 */
public class ProfileDaoImpl implements ProfileDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProfileDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public void insertProfileStudent(List<Student> students) {
        System.out.println("Đã vào insert  profileStudent");
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            String query = "INSERT INTO profile( Name, Gender, DayOfBirth, PhoneNumber, Hometown, CurrentAddress, IdNumber, Email, Id )"
                    + " VALUES(?,?,?,?,?,?,?,?,?) ";
            preparedStatement = connection.prepareStatement(query);

            for (Student student : students) {
                Profile profile = student.getProfileStudent();
                // System.out.println(profile);
                preparedStatement.setString(1, profile.getFullName());
                preparedStatement.setBoolean(2, profile.isGender());
                preparedStatement.setDate(3, DateUtils.convertToSqlDate(profile.getDayOfBirth()));
                preparedStatement.setString(4, profile.getPhoneNumber());
                preparedStatement.setString(5, profile.getHomeTown());
                preparedStatement.setString(6, profile.getCurrentAddress());
                preparedStatement.setString(7, profile.getIdNumber());
                preparedStatement.setString(8, profile.getEmail());
                preparedStatement.setString(9, profile.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            System.out.println("Đã insert profileStudent");

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
