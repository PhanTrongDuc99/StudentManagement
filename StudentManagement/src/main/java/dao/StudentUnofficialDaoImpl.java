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

    private ProfileDao profileDao;
    private final RegisterDao registerDao;
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private int affectedRows = 0;
    private final String queryStudent = "INSERT INTO studentunofficial(Id, DiscountStatus, IdProfile , Cost, IdRegister, IdCourse) "
            + "VALUES(?,?,(SELECT Id from profile WHERE profile.Id=?),(SELECT Cost FROM course WHERE Id= ?),(SELECT Id from register WHERE register.Id=?),(SELECT Id from course WHERE course.Id=?))";

    private final String query = "SELECT Id, DiscountStatus, IdProfile , Cost, IdRegister, IdCourse " + "FROM studentunofficial";

    public StudentUnofficialDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
        registerDao = new RegisterDaoImpl();
        profileDao = new ProfileDaoImpl();
    }

    public static void main(String[] args) {
        new StudentUnofficialDaoImpl().getAll().forEach(x -> System.out.println(x));
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

                Profile profile = profileDao.getProfile(result.getString("Id"));
                Register register = registerDao.getRegister(result.getString("IdRegister"));
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
        String query = "SELECT st.Id, st.IdGrade, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.Id,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost\n"
                + "FROM STUDENTUNOFFICIAL st\n"
                + "INNER JOIN REGISTER rg ON st.IdRegister = rg.Id\n"
                + "INNER JOIN PROFILE pr ON st.Idprofile= pr.Id\n"
                + "WHERE st.Id=" + id;
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            StudentUnofficial studentUnofficial = new StudentUnofficial();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = new Profile(result.getString("Id"), result.getString("Name"), result.getBoolean("Gender"), result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                Register register = new Register(result.getString("IdRegister"), RegisterStatus.valueOf(result.getString("State")), RegisterType.valueOf(result.getString("TypeOfRegister")));
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

    public void deleteStudentByIdCourse(String idCourse) {
        try {
            connection = connectionManager.getConnection();
            String query = " DELETE FROM STUDENTUNOFFICIAL WHERE IdCourse=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idCourse);
            int amountRowDeleted = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<StudentUnofficial> getStudentByIdCourse(String idCourse) {
        connection = connectionManager.getConnection();
        List<StudentUnofficial> studentUnofficials = new ArrayList<>();
        String query = "SELECT st.IdCourse,st.IdProfile, st.Id, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,st.IdRegister,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost\n"
                + "FROM STUDENTUNOFFICIAL st\n"
                + "INNER JOIN REGISTER rg ON st.IdRegister = rg.Id\n"
                + "INNER JOIN PROFILE pr ON st.Idprofile= pr.Id\n"
                + "INNER JOIN COURSE c ON st.IdCourse=c.Id\n"
                + "WHERE st.IdCourse= ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idCourse);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                StudentUnofficial studentUnofficial = new StudentUnofficial();
                Profile profile = new Profile(result.getString("IdProfile"), result.getString("Name"), result.getBoolean("Gender"), result.getDate("DayOfBirth"), result.getString("IdNumber"),
                        result.getString("PhoneNumber"), result.getString("Email"), result.getString("Hometown"), result.getString("CurrentAddress"));
                Register register = new Register(result.getString("IdRegister"), RegisterStatus.valueOf(result.getString("State")), RegisterType.valueOf(result.getString("TypeOfRegister")));
                studentUnofficial.setId(result.getString("Id"));
                studentUnofficial.setProfile(profile);
                studentUnofficial.setDiscountStatus(result.getDouble("DiscountStatus"));

                studentUnofficial.setCost(result.getDouble("Cost"));
                studentUnofficial.setRegister(register);
                studentUnofficial.setIdRegisterCourse(result.getString("IdCourse"));
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

}
