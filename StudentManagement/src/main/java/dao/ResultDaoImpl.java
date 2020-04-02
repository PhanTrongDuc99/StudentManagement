/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ResultDaoImpl implements ResultDao {

    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    int rowsAffected = 0;

    public ResultDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public Result getResult(String id) {
        String query = "SELECT Id, IdGrade, StudyMark, RewardMark,"
                + " DisciplineMark, MoneyPaid,NumberOfAbsences FROM RESULT"
                + " WHERE Id =  '" + id + "'";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Result resultStudent = new Result();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                resultStudent.setId(result.getString("Id"));
                resultStudent.setIdGrade(result.getString("IdGrade"));
                resultStudent.setMoneyPaid(result.getDouble("MoneyPaid"));
                resultStudent.setDisciplineMark(result.getDouble("DisciplineMark"));
                resultStudent.setNumberOfAbsences(result.getInt("NumberOfAbsences"));
                resultStudent.setStudyMark(result.getDouble("StudyMark"));
                resultStudent.setRewardMark(result.getDouble("RewardMark"));
            }
            return resultStudent;
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

    @Override
    public boolean insertResult(Result result) {
        String query = "INSERT INTO `studentmanagement`.`result` (`IdGrade`, `Id`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`, `NumberOfAbsences`)" + "VALUES (?,?, ?, ?, ?, ?, ?)";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, result.getIdGrade());
            preparedStatement.setString(2, result.getId());
            preparedStatement.setDouble(3, result.getStudyMark());
            preparedStatement.setDouble(4, result.getRewardMark());
            preparedStatement.setDouble(5, result.getDisciplineMark());
            preparedStatement.setDouble(6, result.getMoneyPaid());
            preparedStatement.setInt(7, result.getNumberOfAbsences());

            rowsAffected = preparedStatement.executeUpdate();
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
        return rowsAffected != 0;
    }

    @Override
    public boolean deleteResultById(String id) {
        int amountRowDeleted = 0;
        try {
            connection = connectionManager.getConnection();
            String query = " DELETE FROM RESULT WHERE Id='" + id + "'";
            preparedStatement = connection.prepareStatement(query);
            amountRowDeleted = preparedStatement.executeUpdate();
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
        return amountRowDeleted != 0;
    }

}
