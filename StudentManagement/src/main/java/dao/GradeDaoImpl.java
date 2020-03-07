/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.Time;
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
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConvertToInvalidateData;

/**
 *
 * @author PC
 */
public class GradeDaoImpl implements GradeDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private ConvertToInvalidateData convert;

    public GradeDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<Grade> getGrades() {
        List<Grade> grades = new ArrayList<>();
        Schedule schedule = new Schedule();
        Teacher teacher = new Teacher();
        Course course = new Course();
        convert = new ConvertToInvalidateData();
        connection = connectionManager.getConnection();
        String query = "SELECT cl.Id, cl.Name, cl.StudentQuantity, cl.IdTeacher, cl.IdCourse, cl.IdSchedule, sch.DaysOfWeek, sch.StartTime, sch.EndTime FROM CLASS cl\n"
                + "INNER JOIN SCHEDULE sch ON cl.IdSchedule=sch.Id";
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                schedule = new Schedule(result.getString("IdSchedule"), result.getTime("StartTime"), result.getTime("EndTime"), convert.convertToDayOfWeek(result.getInt("DaysOfWeek")));
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
