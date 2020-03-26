/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Course;
import entities.Grade;
import entities.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import utils.DayOfWeekUtils;
import utils.TimeUtils;

/**
 *
 * @author PC
 */
public class GradeDaoImpl implements GradeDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public GradeDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Grade> getAll() {
        List<Grade> grades = new ArrayList<>();
        connection = connectionManager.getConnection();
        String query = "SELECT Id, Name, StudentQuantity, IdTeacher,"
                + " IdCourse, DaysOfWeek, StartTime,EndTime FROM grade";

        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Teacher teacher = new Teacher();
                Course course = new Course();
                teacher.setIdTeacher(result.getString("IdTeacher"));
                course.setIdCourse(result.getString("IdCourse"));
                grades.add(new Grade(result.getString("Id"), result.getString("Name"), teacher, course,
                        TimeUtils.convertStringToLocalTime(result.getString("StartTime")),
                        TimeUtils.convertStringToLocalTime(result.getString("EndTime")),
                        result.getInt("StudentQuantity"), DayOfWeekUtils.convertStringToDayOfWeek(result.getString("DaysOfWeek"))));
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
        return grades;
    }

    @Override
    public void insertGrade(List<Grade> grades) {
        String queryGrade = "INSERT INTO grade(Id, Name, StudentQuantity , Idteacher, IdCourse, StartTime, EndTime, DaysOfWeek) "
                + "VALUES(?,?,?,(SELECT Id from teacher WHERE teacher.Id=?),(SELECT Id from course WHERE course.Id=?),?,?,?)";
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(queryGrade);
            for (Grade grade : grades) {
                System.out.println(grade + "------" + grade.getTeacher().getIdTeacher());
                preparedStatement.setString(1, grade.getIdGrade());
                preparedStatement.setString(2, grade.getNameGrade());
                preparedStatement.setInt(3, grade.getStudentQuantity());
                preparedStatement.setString(4, grade.getTeacher().getIdTeacher());
                preparedStatement.setString(5, grade.getCourse().getIdCourse());
                preparedStatement.setString(6, grade.getStartTime().toString());
                preparedStatement.setString(7, grade.getEndTime().toString());
                preparedStatement.setString(8, String.join(",", Arrays.asList(grade.getDaysOfWeek()).stream().map(t -> t.toString()).collect(Collectors.toList())));
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
                Logger.getLogger(TeacherDaoImpl.class.getName()).log(Level.ALL.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Grade getGrade(String id) {
        connection = connectionManager.getConnection();
        String query = "SELECT Id, Name, StudentQuantity, IdTeacher,"
                + " IdCourse, DaysOfWeek, StartTime,EndTime FROM grade"
                + "WHERE Id=" + id;

        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Teacher teacher = new Teacher();
                Course course = new Course();
                teacher.setIdTeacher(result.getString("IdTeacher"));
                course.setIdCourse(result.getString("IdCourse"));
                Grade grade = new Grade(result.getString("Id"), result.getString("Name"), teacher, course,
                        TimeUtils.convertStringToLocalTime(result.getString("StartTime")),
                        TimeUtils.convertStringToLocalTime(result.getString("EndTime")),
                        result.getInt("StudentQuantity"), DayOfWeekUtils.convertStringToDayOfWeek(result.getString("DaysOfWeek")));
                return grade;
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
        return null;
    }

}
