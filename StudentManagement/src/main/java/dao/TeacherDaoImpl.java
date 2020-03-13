/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.Teacher;
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
 * @author PC
 */
public class TeacherDaoImpl implements TeacherDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public TeacherDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Teacher> getAll() {
        connection = connectionManager.getConnection();
        List<Teacher> teachers = new ArrayList<>();
        boolean gender;
        String query = "SELECT tc.Id,tc.IdProfile, pr.Name, pr.Gender,  pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber,tc.Workplace, tc.Salary, pr.Email, tk.TeachingHours, tk.RewardLevel, tk.DisciplineLevel  \n"
                + "FROM TEACHER tc\n"
                + "INNER JOIN PROFILE pr ON pr.Id=tc.IdProfile\n"
                + "INNER JOIN TIMEKEEPING tk ON tk.IdTeacher=tc.Id;";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (result.getInt("Gender") == 0) {
                    gender = false;
                } else {
                    gender = true;
                }
                Profile profile = new Profile(result.getString("Id"), result.getString("Name"), gender, result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                TimeKeeping timeKeeping = new TimeKeeping(result.getDouble("TeachingHours"), result.getString("RewardLevel"), result.getString("DisciplineLevel"));
                teachers.add(new Teacher(result.getString("Id"), profile, result.getDouble("Salary"), timeKeeping, result.getString("Workplace")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teachers;
    }

}
