/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.Register;
import entities.Result;
import entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DateUtils;

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
    public List<Student> getAll() {
        connection = connectionManager.getConnection();
        List<Student> students = new ArrayList<>();

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
                Profile profile = new Profile(result.getString("Id"), result.getString("Name"), gender, result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                Result resultStudent = new Result(result.getDouble("StudyMark"), result.getDouble("RewardMark"), result.getDouble("DisciplineMark"), result.getDouble("MoneyPaid"), result.getInt("NumberOfAbsences"));
                Register register = DateUtils.converToRegister(result.getString("State"), result.getString("TypeOfRegister"));
                Student student = new Student(result.getString("Id"), profile, result.getDouble("DiscountStatus"), result.getDouble("Cost"), register, resultStudent);
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
            String queryStudent = "INSERT INTO student(Id, DiscountStatus, IdProfile , Cost) VALUES(?,?,(SELECT Id from profile WHERE profile.Id=?),?)";

            preparedStatement = connection.prepareStatement(queryStudent);

            for (Student student : students) {
                preparedStatement.setString(1, student.getIdStudent());
                preparedStatement.setDouble(2, student.getDiscountStatus());
                preparedStatement.setString(3, student.getProfileStudent().getId());
                preparedStatement.setDouble(4, student.getCost());
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
