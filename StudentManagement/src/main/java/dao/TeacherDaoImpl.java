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

    private final ProfileDao profileDao;
    private final TimeKeepingDao timeKeepingDao;
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private final String query = "INSERT INTO teacher(Id, Workplace, Salary, IdProfile, IdTimeKeeping) "
            + "VALUES(?,?,?,(SELECT Id from profile WHERE profile.Id=?)";

    public TeacherDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
        profileDao = new ProfileDaoImpl();
        timeKeepingDao = new TimeKeepingDaoImpl();
    }

    @Override
    public List<Teacher> getAll() {
        connection = connectionManager.getConnection();
        List<Teacher> teachers = new ArrayList<>();
        String queryTeacher = "SELECT Id, Workplace, IdProfile, Salary FROM TEACHER";
        try {
            preparedStatement = connection.prepareStatement(queryTeacher);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = profileDao.getProfile(result.getString("IdProfile"));

                teachers.add(new Teacher(result.getString("Id"), profile, result.getDouble("Salary"), result.getString("Workplace")));
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

    @Override
    public void insertTeacher(Teacher teacher) {
        try {
            connection = connectionManager.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacher.getIdTeacher());
            preparedStatement.setString(2, teacher.getWorkPlace());
            preparedStatement.setDouble(3, teacher.getSalary());
            preparedStatement.setString(4, teacher.getIdTeacher());
            preparedStatement.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void insertTeachers(List<Teacher> teachers) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (Teacher teacher : teachers) {
                preparedStatement.setString(1, teacher.getIdTeacher());
                preparedStatement.setString(2, teacher.getWorkPlace());
                preparedStatement.setDouble(3, teacher.getSalary());
                preparedStatement.setString(4, teacher.getProfileTeacher().getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Teacher getTeacher(String id) {
        String queryStudent = "SELECT Id, Workplace, Salary, IdProfile FROM TEACHER WHERE Id= '" + id + "'";
        connection = connectionManager.getConnection();
        Teacher teacher = new Teacher();

        try {
            preparedStatement = connection.prepareStatement(queryStudent);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = profileDao.getProfile(result.getString("IdProfile"));

                teacher.setIdTeacher(result.getString("Id"));
                teacher.setWorkPlace(result.getString("Workplace"));
                teacher.setSalary(result.getDouble("Salary"));
                teacher.setProfileTeacher(profile);
            }
            return teacher;
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

}
