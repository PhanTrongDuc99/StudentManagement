/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Grade;
import entities.Profile;
import entities.Register;
import entities.Result;
import entities.StudentOfficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class StudentOfficialDaoImpl implements StudentOfficialDao {

    private final ProfileDao profileDao;
    private final RegisterDao registerDao;
    private final GradeDao gradeDao;
    private final ResultDao resultDao;
    private final ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private final String query = "SELECT IdStudent, IdProfile, IdGrade, IdResult, IdRegister, DiscountStatus, Cost FROM STUDENTOFFICIAL";
    private final String queryStudent
            = "INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdGrade`, `IdProfile`, `IdResult`, `IdRegister`, `DiscountStatus`, `Cost`)"
            + "VALUES(?,(SELECT Id FROM grade WHERE ID=?),(SELECT Id from profile WHERE profile.Id=?),?,(SELECT Id FROM RESULT WHERE ID=?),(SELECT Id from register WHERE register.Id=?),?,(SELECT Cost FROM course WHERE Id= ?))";

    public StudentOfficialDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
        profileDao = new ProfileDaoImpl();
        gradeDao = new GradeDaoImpl();
        resultDao = new ResultDaoImpl();
        registerDao = new RegisterDaoImpl();
    }

    @Override
    public List<StudentOfficial> getAll() {
        connection = connectionManager.getConnection();
        List<StudentOfficial> studentOfficials = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = profileDao.getProfile(result.getString("IdProfile"));
                Register register = registerDao.getRegister(result.getString("IdRegister"));
                Grade grade = gradeDao.getGrade(result.getString("IdGrade"));
                Result resultStudent = resultDao.getResult(result.getString("IdResult"));
                StudentOfficial student = new StudentOfficial(resultStudent, grade, result.getString("IdStudent"), profile, result.getDouble("DiscountStatus"), grade.getCourse().getCost(), register);
                studentOfficials.add(student);
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
        return studentOfficials;
    }

    @Override
    public StudentOfficial getStudent(String id) {
        String queryStudent = "SELECT IdStudent, IdProfile, IdGrade, IdResult, IdRegister, DiscountStatus, Cost FROM STUDENTOFFICIAL WHERE IdStudent= '" + id + "'";
        connection = connectionManager.getConnection();
        StudentOfficial student = new StudentOfficial();
        try {
            preparedStatement = connection.prepareStatement(queryStudent);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Profile profile = profileDao.getProfile(result.getString("IdProfile"));
                Register register = registerDao.getRegister(result.getString("IdRegister"));
                Grade grade = gradeDao.getGrade(result.getString("IdGrade"));
                Result resultStudent = resultDao.getResult(result.getString("IdResult"));

                student.setResultStudy(resultStudent);
                student.setId(result.getString("IdStudent"));
                student.setDiscountStatus(result.getDouble("DiscountStatus"));
                student.setProfile(profile);
                student.setCost(grade.getCourse().getCost());
                student.setRegister(register);
                student.setIdRegisterCourse(grade.getCourse().getIdCourse());
            }
            return student;
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
    public void insertStudent(StudentOfficial student) {
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(queryStudent);
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getResultStudy().getIdGrade());
            preparedStatement.setString(3, student.getProfile().getId());
            preparedStatement.setString(4, student.getResultStudy().getId());
            preparedStatement.setString(5, student.getRegister().getId());
            preparedStatement.setDouble(6, student.getDiscountStatus());
            preparedStatement.setDouble(7, student.getCost());
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
}
