/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import common.RegisterStatus;
import common.RegisterType;
import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Profile;
import entities.Register;
import entities.StudentUnofficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class StudentUnofficialDaoImpl implements StudentUnofficialDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private int affectedRows = 0;
    private final String queryStudent = "INSERT INTO studentunofficial(Id, DiscountStatus, IdProfile , Cost, IdRegister, IdCourse) "
            + "VALUES(?,?,(SELECT Id from profile WHERE profile.Id=?),(SELECT Cost FROM course WHERE Id= ?),(SELECT Id from register WHERE register.Id=?),(SELECT Id from course WHERE course.Id=?))";

    private final String query = "SELECT st.Id, st.IdCourse, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost\n"
            + "FROM STUDENTUNOFFICIAL st\n"
            + "INNER JOIN REGISTER rg ON st.IdRegister = rg.Id\n"
            + "INNER JOIN PROFILE pr ON st.IdProfile= pr.Id\n";

    public StudentUnofficialDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<StudentUnofficial> getAll() {
        connection = connectionManager.getConnection();
        List<StudentUnofficial> studentUnofficials = new ArrayList<>();
        boolean gender;

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
                Register register = new Register(RegisterStatus.valueOf(result.getString("State")), RegisterType.valueOf(result.getString("TypeOfRegister")));
                StudentUnofficial studentUnofficial = new StudentUnofficial(result.getString("Id"), profile, result.getDouble("DiscountStatus"), result.getDouble("Cost"), register, result.getString("IdCourse"));
                studentUnofficials.add(studentUnofficial);
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
        return studentUnofficials;
    }

    @Override
    public void insertStudent(StudentUnofficial student) {
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(queryStudent);
            preparedStatement.setString(1, student.getId());
            preparedStatement.setDouble(2, student.getDiscountStatus());
            preparedStatement.setString(3, student.getProfile().getId());
            preparedStatement.setString(4, student.getIdRegisterCourse());
            preparedStatement.setString(5, student.getId());
            preparedStatement.setString(6, student.getIdRegisterCourse());
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
    public void insertStudents(List<StudentUnofficial> students) {
        try {
            connection = connectionManager.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(queryStudent);
            for (StudentUnofficial student : students) {
                preparedStatement.setString(1, student.getId());
                preparedStatement.setDouble(2, student.getDiscountStatus());
                preparedStatement.setString(3, student.getProfile().getId());
                preparedStatement.setString(4, student.getIdRegisterCourse());
                preparedStatement.setString(5, student.getId());
                preparedStatement.setString(6, student.getIdRegisterCourse());
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
    public StudentUnofficial getStudent(String id) {
        String query = "SELECT st.Id, st.IdGrade, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost\n"
                + "FROM STUDENTUNOFFICIAL st\n"
                + "INNER JOIN REGISTER rg ON st.Id = rg.Id\n"
                + "INNER JOIN PROFILE pr ON st.Id= pr.Id\n"
                + "WHERE st.Id=" + id;
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            StudentUnofficial studentUnofficial = new StudentUnofficial();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = new Profile(result.getString("Id"), result.getString("Name"), result.getBoolean("Gender"), result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                Register register = new Register(RegisterStatus.valueOf(result.getString("State")), RegisterType.valueOf(result.getString("TypeOfRegister")));
                studentUnofficial.setId(result.getString("Id"));
                studentUnofficial.setProfile(profile);
                studentUnofficial.setDiscountStatus(result.getDouble("DiscountStatus"));

                studentUnofficial.setCost(result.getDouble("Cost"));
                studentUnofficial.setRegister(register);
                studentUnofficial.setIdRegisterCourse(result.getString("IdCourse"));
            }
            return studentUnofficial;
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
    public boolean deleteUnofficialStudentById(String id) {

        String query = "DELETE FROM studentmanagement.studentunofficial WHERE Id=" + id;
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            //StudentUnofficial studentUnofficial = new StudentUnofficial();
            affectedRows = preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                //result.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return affectedRows != 0;
    }

}
