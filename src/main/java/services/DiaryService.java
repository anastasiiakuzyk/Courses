package services;

import database.MySQLConnection;
import models.Diary;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiaryService {
    private static final String INSERT = "insert into diaries (course_id, student_id, points) values(?,?,-1)";

    public void setDiary(int courseId, int studentId) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setInt(1, courseId);
        preparedStatement.setInt(2, studentId);
        preparedStatement.executeUpdate();
        connection.close();
    }

    private static final String SELECT_ALL_USERS_POINTS_BY_COURSE_ID= "select users.id, users.name, email, course_id, points from users " +
            "left join diaries d on users.id = d.student_id " +
            "left join courses c on c.id = d.course_id " +
            "where d.course_id = ? and c.end < CURDATE()";

    public List<Diary> getUsersByCourse(int courseId) throws SQLException, ClassNotFoundException {
        List<Diary> diaries = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS_POINTS_BY_COURSE_ID);
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            diaries.add(new Diary(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5)));
        }
        connection.close();
        return diaries;
    }

    String INSERT_POINTS = "insert into diaries(course_id, student_id, points) VALUES (?,?,?)";

    String UPDATE_POINTS = "update diaries set points = ? " +
            "where student_id = ? and course_id = ?";

    public void setPoints(int courseId, int studentId, int points) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select 1 from diaries where course_id = ? and student_id = ?");
        preparedStatement.setInt(1, courseId);
        preparedStatement.setInt(2, studentId);
        if (preparedStatement.executeQuery().next()){
            preparedStatement = connection.prepareStatement(UPDATE_POINTS);
            preparedStatement.setInt(1, points);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, courseId);
        } else {
            preparedStatement = connection.prepareStatement(INSERT_POINTS);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, points);
        }
        preparedStatement.executeUpdate();
        connection.close();
    }
}
