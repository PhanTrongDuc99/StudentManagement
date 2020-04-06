/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.TimeKeeping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TimeKeepingDaoImpl implements TimeKeepingDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private final String insertQuery
            = "INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `Id`, `IdTeacher`)\n"
            + "VALUES(?,?,?,?,?)";

    public TimeKeepingDaoImpl() {
        connectionManager = new ConnectionManagerImpl();

    }

    @Override
    public void insertTimeKeeping(TimeKeeping timeKeeping) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(insertQuery);
            System.out.println("TK id: " + timeKeeping.getId());
            preparedStatement.setDouble(1, timeKeeping.getTeachingHours());
            preparedStatement.setString(2, timeKeeping.getRewardLevel());
            preparedStatement.setString(3, timeKeeping.getDisciplineLevel());
            preparedStatement.setString(4, timeKeeping.getId());
            preparedStatement.setString(5, timeKeeping.getIdTeacher());
            preparedStatement.addBatch();
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
    public TimeKeeping getTimeKeeping(String id) {
        connection = connectionManager.getConnection();
        TimeKeeping timeKeeping = null;
        String query = "SELECT * FROM studentmanagement.timekeeping WHERE id='" + id + "'";
        try {
            preparedStatement = connection.prepareStatement(query);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                timeKeeping = new TimeKeeping(result.getString("Id"), result.getDouble("TeachingHours"), result.getString("RewardLevel"), result.getString("DisciplineLevel"), result.getString("IdTeacher"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return timeKeeping;
    }

    @Override
    public List<TimeKeeping> getAll() {
        List<TimeKeeping> timeKeepings = new ArrayList<>();
        connection = connectionManager.getConnection();
        String query = "SELECT * FROM studentmanagement.timekeeping";

        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                timeKeepings.add(new TimeKeeping(result.getString("Id"), result.getDouble("TeachingHours"), result.getString("RewardLevel"), result.getString("DisciplineLevel"), result.getString("IdTeacher")));
            }
        } catch (SQLException ex) {
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
        return timeKeepings;
    }

}
