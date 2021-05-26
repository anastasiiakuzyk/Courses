package services;

import database.MySQLConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlockedService {
    private static final String SELECT = "select is_blocked from blocked_users where student_id = ?";
    private static final String INSERT = "insert into blocked_users(student_id, is_blocked) " +
            "VALUES (?,?)";
    private static final String UPDATE = "update blocked_users set student_id = ?, is_blocked =? where student_id = ?";

    public int isUserBlocked(int studentId) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT);
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        int result = -1;
        while (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        connection.close();
        return result;
    }

    public void setBlocked(int studentId, int isBlocked) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select 1 from blocked_users where student_id = ?");
        preparedStatement.setInt(1, studentId);
        if (preparedStatement.executeQuery().next()) {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, isBlocked);
            preparedStatement.setInt(3, studentId);
        } else {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, isBlocked);
        }
        preparedStatement.executeUpdate();
        connection.close();
    }
}
