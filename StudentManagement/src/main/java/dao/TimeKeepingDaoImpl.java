/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Teacher;
import entities.TimeKeeping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private final String query
            = "INSERT INTO timekeeping(TeachingHours, RewardLevel, DisciplineLevel, Id)\n"
            + "VALUES(?,?,?,?)";

    public TimeKeepingDaoImpl() {
        connectionManager = new ConnectionManagerImpl();

    }

    @Override
    public void insertTimeKeeping(List<Teacher> teachers) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (Teacher teacher : teachers) {
                TimeKeeping timeKeeping = teacher.getTimeKeeping();
                System.out.println("TK id: " + timeKeeping.getId());
                preparedStatement.setDouble(1, timeKeeping.getTeachingHours());
                preparedStatement.setString(2, timeKeeping.getRewardLevel());
                preparedStatement.setString(3, timeKeeping.getDisciplineLevel());
                preparedStatement.setString(4, timeKeeping.getId());
                preparedStatement.addBatch();
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
    public TimeKeeping getTimeKeeping(String id) {
        connection = connectionManager.getConnection();
        TimeKeeping timeKeeping = null;
        String query = "SELECT * FROM studentmanagement.timekeeping WHERE id='" + id + "'";
        try {
            preparedStatement = connection.prepareStatement(query);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                timeKeeping = new TimeKeeping(result.getString("Id"), result.getDouble("TeachingHours"), result.getString("RewardLevel"), result.getString("DisciplineLevel"));
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

}
