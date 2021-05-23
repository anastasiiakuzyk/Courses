package services;

import database.MySQLConnection;
import models.Course;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private static final String SELECT_ALL = "select courses.id, courses.name, courses.theme, courses.start, " +
            "courses.end, user.name, courses.description " +
            "from courses " +
            "join users user on courses.teacher_id = user.id";
    private static final String SELECT_COURSES_BY_USER_ID = "select * from courses " +
            "where id in(select course_id from diaries where student_id = ?)";

    public List<Course> gatAllCourses() throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();
        while (resultSet.next()) {
            courses.add(new Course(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    new User(resultSet.getString(6)),
                    resultSet.getString(7)));
        }
        connection.close();
        return courses;
    }

    public List<Course> getCoursesByUserId(int user_id) throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COURSES_BY_USER_ID);
        statement.setInt(1, user_id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            courses.add(new Course(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    new User(resultSet.getString(6)),
                    resultSet.getString(7)));
        }
        connection.close();
        return courses;
    }


}
