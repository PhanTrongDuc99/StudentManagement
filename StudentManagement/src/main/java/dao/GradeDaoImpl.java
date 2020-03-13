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
import entities.Schedule;
import entities.Teacher;
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
        String query = "SELECT cl.Id, cl.Name, cl.StudentQuantity, cl.IdTeacher, cl.IdCourse, cl.IdSchedule, sch.DaysOfWeek, sch.StartTime, sch.EndTime FROM CLASS cl\n"
                + "INNER JOIN SCHEDULE sch ON cl.IdSchedule=sch.Id";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Schedule schedule = new Schedule(result.getString("IdSchedule"), DateUtils.convertToLocalTime(result.getString("StartTime")), DateUtils.convertToLocalTime(result.getString("EndTime")), DateUtils.convertToDayOfWeek(result.getInt("DaysOfWeek")));
                Teacher teacher = new Teacher();
                Course course = new Course();
                teacher.setIdTeacher(result.getString("IdTeacher"));
                course.setIdCourse(result.getString("IdCourse"));
                grades.add(new Grade(result.getString("Id"), result.getString("Name"), schedule, teacher, course, result.getInt("StudentQuantity")));
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

}
