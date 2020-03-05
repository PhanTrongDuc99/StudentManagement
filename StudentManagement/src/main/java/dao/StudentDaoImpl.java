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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String query = "";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                if (result.getInt("Gender") == 0) {
                    gender = false;
                } else {
                    gender = true;
                }
                profileStudent = new Profile(result.getString("Name"), gender, result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                register = converToRegister(result.getString("Status"), result.getString("Type"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> readStudentFromExcelFile(String excelFilePath) {
        List<Student> students = new ArrayList<>();
        File file = new File(excelFilePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            Workbook workbook = WorkBookValue.getWorkbook(fileInputStream, excelFilePath);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rows = firstSheet.iterator();
            while (rows.hasNext()) {
                Student student = new Student();
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int columnIndex = cell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            String idStudent = String.valueOf(CellValue.getCellNumber(cell));
                            student.setIdStudent(idStudent);
                            break;
                        case 9:

                            break;
                        case 2:

                            break;
                    }
                }
                students.add(student);
            }
            workbook.close();
            fileInputStream.close();
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Register converToRegister(String status, String type) {
        RegisterStatus registerStatus = null;
        RegisterType registerType = null;
        try {
            if ("Registered".equals(result.getString("Status"))) {
                registerStatus = RegisterStatus.REGISTERED;
            }
            if ("Waitting".equals(result.getString("Status"))) {
                registerStatus = RegisterStatus.WAITTING;
            }
            if ("Cancel".equals(result.getString("Status"))) {
                registerStatus = RegisterStatus.CANCEL;
            }
            if ("Internet".equals(result.getString("Status"))) {
                registerType = RegisterType.INTERNET;
            }
            if ("Maketing".equals(result.getString("Status"))) {
                registerType = RegisterType.MARKETING;
            }
            if ("Direct".equals(result.getString("Status"))) {
                registerType = RegisterType.DIRECT;
            }
        } catch (Exception e) {
        }

        return new Register(registerStatus, registerType);
    }

}
