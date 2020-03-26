/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Course;
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
public class CourseDaoImpl implements CourseDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public CourseDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Course> getAll() {
        connection = connectionManager.getConnection();
        List<Course> courses = new ArrayList<>();
        String query = "SELECT Id, Name, \n"
                + "ClassQuantity, StartDay, EndDay, Cost FROM COURSE c\n";

        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                courses.add(
                        new Course(result.getString("Id"), result.getString("Name"), result.getDate("StartDay"), result.getDate("EndDay"), result.getInt("ClassQuantity"), result.getDouble("Cost")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return courses;
    }

    @Override
    public void insertCourses(List<Course> courses) {
        String query = "INSERT INTO course(Id, Name, ClassQuantity, StartDay, EndDay, Cost) values(?,?,?,?,?,?)";
        connection = connectionManager.getConnection();
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            for (Course course : courses) {
                preparedStatement.setString(1, course.getIdCourse());
                preparedStatement.setString(2, course.getNameCourse());
                preparedStatement.setInt(3, course.getGradeQuantity());
                preparedStatement.setDate(4, DateUtils.convertToSqlDate(course.getStartTime()));
                preparedStatement.setDate(5, DateUtils.convertToSqlDate(course.getEndTime()));
                preparedStatement.setDouble(6, course.getCost());
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

}
