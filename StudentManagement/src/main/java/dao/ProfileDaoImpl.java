/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.StudentOfficial;
import entities.StudentUnofficial;
import entities.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import utils.DateUtils;

/**
 *
 * @author USER
 */
public class ProfileDaoImpl implements ProfileDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private final String query
            = "INSERT INTO profile(Name, Gender, DayOfBirth, PhoneNumber, Hometown, CurrentAddress, IdNumber, Email, Id)\n"
            + "VALUES(?,?,?,?,?,?,?,?,?)";

    public ProfileDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public void insertProfile(Profile profile) {
        connection = connectionManager.getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, profile.getFullName());
            preparedStatement.setBoolean(2, profile.isGender());
            preparedStatement.setDate(3, DateUtils.convertToSqlDate(profile.getDayOfBirth()));
            preparedStatement.setString(4, profile.getPhoneNumber());
            preparedStatement.setString(5, profile.getHomeTown());
            preparedStatement.setString(6, profile.getCurrentAddress());
            preparedStatement.setString(7, profile.getIdNumber());
            preparedStatement.setString(8, profile.getEmail());
            preparedStatement.setString(9, profile.getId());
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
    public void insertProfileStudents(List<StudentUnofficial> students) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (StudentUnofficial student : students) {
                Profile profile = student.getProfile();
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

    @Override
    public void insertProfileTeachers(List<Teacher> teachers) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (Teacher teacher : teachers) {
                Profile profile = teacher.getProfileTeacher();
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
    public List<Profile> getProfileStudentUnofficial() {
        StudentUnofficialDao studentDao = new StudentUnofficialDaoImpl();
        return studentDao.getAll().stream().map(StudentUnofficial::getProfile).collect(Collectors.toList());
    }

    @Override
    public List<Profile> getProfileTeacher() {
        TeacherDao teacherDao = new TeacherDaoImpl();
        return teacherDao.getAll().stream().map(Teacher::getProfileTeacher).collect(Collectors.toList());
    }

    @Override
    public Profile getProfile(String id) {
        String query = "SELECT Id, Name, Gender, PhoneNumber, IdNumber, Email, DayOfBirth, Hometown, CurrentAddress  FROM PROFILE WHERE Id='" + id + "'";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Profile profile = new Profile();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                profile.setId(result.getString("Id"));
                profile.setFullName(result.getString("Name"));
                profile.setGender(result.getInt("Gender") == 0);
                profile.setDayOfBirth(result.getDate("DayOfBirth"));
                profile.setIdNumber(result.getString("IdNumber"));
                profile.setPhoneNumber(result.getString("PhoneNumber"));
                profile.setEmail(result.getString("Email"));
                profile.setHomeTown(result.getString("Hometown"));
                profile.setCurrentAddress(result.getString("CurrentAddress"));
            }
            return profile;
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
    public List<Profile> getProfileStudentOfficial() {
        StudentOfficialDao studentDao = new StudentOfficialDaoImpl();
        return studentDao.getAll().stream().map(StudentOfficial::getProfile).collect(Collectors.toList());
    }

}
