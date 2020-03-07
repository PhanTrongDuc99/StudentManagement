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
import java.util.ArrayList;
import java.util.List;

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
    public List<Course> getCourses() {
        connection = connectionManager.getConnection();
        List<Course> courses = new ArrayList<>();
        String query = "SELECT c.Id, c.Name, \n"
                + "c.ClassQuantity, c.StartDay, c.EndDay, co.Price FROM COURSE c\n"
                + "INNER JOIN COST co ON c.IdCost=co.Id";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                courses.add(
                        new Course(result.getString("Id"), result.getString("Name"), result.getDate("StartDay"), result.getDate("EndDay"), result.getInt("ClassQuantity"), result.getDouble("Price")));
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

}
