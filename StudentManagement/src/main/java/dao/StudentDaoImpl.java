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
import entities.Result;
import entities.Student;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import utils.ConvertToInvalidateData;

/**
 *
 * @author PC
 */
public class StudentDaoImpl implements StudentDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private ConvertToInvalidateData convert;

    public StudentDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Student> getStudents() {
        connection = connectionManager.getConnection();
        List<Student> students = new ArrayList<>();
        convert = new ConvertToInvalidateData();
        Student student = null;
        Profile profileStudent = null;
        Register register = null;
        Result resultStudent = null;
        boolean gender;
        String query = "SELECT st.Id, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost, rs.StudyMark, rs.RewardMark, rs.DisciplineMark, rs.MoneyPaid, rs.NumberOfAbsences\n"
                + "FROM STUDENT st\n"
                + "INNER JOIN REGISTER rg ON st.Id= rg.IdStudent\n"
                + "INNER JOIN PROFILE pr ON st.Id= pr.Id\n"
                + "INNER JOIN RESULT rs ON st.Id=rs.IdStudent;";
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
                resultStudent = new Result(result.getDouble("StudyMark"), result.getDouble("RewardMark"), result.getDouble("DisciplineMark"), result.getDouble("MoneyPaid"), result.getInt("NumberOfAbsences"));
                register = convert.converToRegister(result.getString("State"), result.getString("TypeOfRegister"));
                student = new Student(result.getString("Id"), profileStudent, result.getDouble("DiscountStatus"), result.getDouble("Cost"), register, resultStudent);
                students.add(student);
            }
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

}
