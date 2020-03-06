/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.CellValue;
import common.RegisterStatus;
import common.RegisterType;
import common.WorkBookValue;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.Register;
import entities.Student;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author PC
 */
public class StudentDaoImpl implements StudentDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public StudentDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getStudents() {
        connection = connectionManager.getConnection();
        List<Student> students = new ArrayList<>();
        Student student = null;
        Profile profileStudent = null;
        Register register = null;
        boolean gender;
        String query = "SELECT *FROM STUDENT \n"
                + "INNER JOIN REGISTER ON STUDENT.Id= REGISTER.IdStudent\n"
                + "INNER JOIN PROFILE ON STUDENT.Id= PROFILE.Id;";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (result.getInt("Gender") == 0) {
                    gender = false;
                } else {
                    gender = true;
                }
                profileStudent = new Profile(result.getString("Name"), gender, result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                register = converToRegister(result.getString("State"), result.getString("TypeOfRegister"));
                student = new Student(result.getString("Id"), profileStudent, result.getDouble("DiscountStatus"), result.getDouble("Cost"), register);
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    @Override
    public void insertStudent(List<Student> students) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            String query = "INSERT INTO student(Id, DiscountStatus, Cost) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            for (Student student : students) {
                preparedStatement.setString(1, student.getIdStudent());
                preparedStatement.setDouble(2, student.getDiscountStatus());
                preparedStatement.setDouble(3, student.getCost());
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

    public Register converToRegister(String status, String type) {
        RegisterStatus registerStatus = null;
        RegisterType registerType = null;
        try {
            if ("Registered".equals(status)) {
                registerStatus = RegisterStatus.REGISTERED;
            }
            if ("Waitting".equals(status)) {
                registerStatus = RegisterStatus.WAITTING;
            }
            if ("Cancel".equals(status)) {
                registerStatus = RegisterStatus.CANCEL;
            }
            if ("Internet".equals(type)) {
                registerType = RegisterType.INTERNET;
            }
            if ("Maketing".equals(type)) {
                registerType = RegisterType.MARKETING;
            }
            if ("Direct".equals(type)) {
                registerType = RegisterType.DIRECT;
            }
        } catch (Exception e) {
        }

        return new Register(registerStatus, registerType);
    }

}
