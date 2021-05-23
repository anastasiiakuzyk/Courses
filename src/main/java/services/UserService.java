package services;

import database.MySQLConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String SELECT_ALL = "select * from users";
    private static final String SELECT_ALL_STUDENTS = "select * from users where role_id=3";
    private static final String SELECT_ALL_TEACHERS = "select * from users where role_id=2";
    private static final String SELECT_BY_EMAIL = "select * from users where email=?";
    private static final String SELECT_BY_TOKEN = "select * from users " +
            "where id in (select user_id from tokens " +
            "where user_id = users.id and token = ?)";
    private static final String INSERT = "insert into users (name,email,password,role_id) values(?,?,?,?)";

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();
        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)));
        }
        connection.close();
        return users;
    }

    public List<User> getAllStudents() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        ResultSet resultSet = connection.prepareStatement(SELECT_ALL_STUDENTS).executeQuery();
        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)));
        }
        connection.close();
        return users;
    }

    public List<User> getAllTeachers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        ResultSet resultSet = connection.prepareStatement(SELECT_ALL_TEACHERS).executeQuery();
        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)));
        }
        connection.close();
        return users;
    }

    public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByToken(String token) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_TOKEN);
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setStudent(String email, String name, String password) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setInt(4, 3);
        preparedStatement.executeUpdate();
        connection.close();

    }

}
