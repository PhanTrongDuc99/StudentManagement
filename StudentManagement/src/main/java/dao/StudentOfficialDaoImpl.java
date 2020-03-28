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
import entities.Result;
import entities.StudentOfficial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DateUtils;

/**
 *
 * @author PC
 */
public class StudentOfficialDaoImpl implements StudentOfficialDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public StudentOfficialDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public List<StudentOfficial> getAll() {
        connection = connectionManager.getConnection();
        List<StudentOfficial> studentOfficials = new ArrayList<>();

        boolean gender;
        String query = "SELECT stoff.IdStudent,pr.Id, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,stunoff.Cost,stunoff.DiscountStatus,\n"
                + "res.StudyMark, res.RewardMark, res.DisciplineMark, res.MoneyPaid, res.NumberOfAbsences, reg.State, reg.TypeOfRegister\n"
                + "FROM STUDENTOFFICIAL stoff\n"
                + "INNER JOIN RESULT res ON stoff.IdStudent=res.IdStudent AND stoff.IdClass=res.IdClass\n"
                + "INNER JOIN PROFILE pr ON stoff.IdProfile=pr.Id\n"
                + "INNER JOIN STUDENTUNOFFICIAL stunoff ON stunoff.Id=stoff.IdStudent\n"
                + "INNER JOIN REGISTER reg ON reg.IdStudent=stoff.IdStudent;";
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
                Result resultStudy = new Result(result.getDouble("StudyMark"), result.getDouble("RewardMark"), result.getDouble("DisciplineMark"), result.getDouble("StudyMark"), result.getInt("NumberOfAbsences"));
                StudentOfficial studentOfficial = new StudentOfficial(resultStudy, result.getString("IdStudent"), profile, result.getDouble("DiscountStatus"), result.getDouble("Cost"), register);
                studentOfficials.add(studentOfficial);
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

}
