package services;

import database.MySQLConnection;
import models.Course;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private static final String SELECT_ALL = "select courses.id, courses.name, courses.theme, courses.start, " +
            "courses.end, user.name, courses.description " +
            "from courses " +
            "join users user on courses.teacher_id = user.id";
    private static final String SELECT_COURSES_BY_STUDENT_ID = "select c.id, c.name, theme, start, end, u.name, description " +
            "from courses as c " +
            "         left join diaries d on c.id = d.course_id " +
            "left join users u on u.id = c.teacher_id " +
            "where student_id =?";
    private static final String SELECT_COURSES_BY_TEACHER_ID = "select * from courses where teacher_id = ?";
    private static final String SELECT_COURSE_BY_ID_AND_STUDENT_ID = "SELECT " +
            "courses.name, courses.theme, courses.description, " +
            "u.name, courses.start, courses.end, d.points FROM courses " +
            "LEFT JOIN users u on u.id = courses.teacher_id " +
            "LEFT JOIN diaries d on d.course_id =  courses.id " +
            "WHERE courses.id =? AND d.student_id=?";

    private static final String SELECT_COURSE_BY_ID = "select * from courses where id=?";

    private static final String INSERT = "insert into courses (name, theme, start, end, teacher_id, description) " +
            "values(?,?,?,?,?,?)";

    private static final String UPDATE = "update courses " +
            "set name = ?, theme = ?, start = ?, end = ?, teacher_id = ?, description = ? " +
            "where id = ?";
    private static final String SELECT_ALL_ORDER_BY_NAME = "select * from courses order by name";
    private static final String SELECT_ALL_ORDER_BY_DURATION = "select *, end-courses.start as duration from courses order by duration";
    private static final String SELECT_ALL_ORDER_BY_STUD_NUM = "select c.id, c.name, theme, start, end, teacher_id, description, count(u.id) as studNum from diaries " +
            "join courses c on c.id = diaries.course_id " +
            "join users u on u.id = diaries.student_id " +
            "group by c.id, c.name, theme, start, end, teacher_id, description " +
            "order by studNum";
    private String SELECT_SORT = "select * from ( " +
            "select c.id, " +
            "c.name, " +
            "c.theme, " +
            "c.start, " +
            "c.end, " +
            "teacher.name as teacher_name, " +
            "teacher_id, " +
            "c.description, " +
            "count(d.student_id) as studNum " +
            "from courses as c " +
            "left join users teacher on c.teacher_id = teacher.id " +
            "left join diaries as d on c.id = d.course_id " +
            "group by c.id, c.name, theme, start, end, teacher_id, description " +
            "order by ";

    private String SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS = "select c.id, c.name, theme, start, end, u.name, description " +
            "from courses as c " +
            "         left join diaries d on c.id = d.course_id " +
            "         left join users u on u.id = c.teacher_id " +
            "where student_id = ? " +
            "  and ";

    public List<Course> getCoursesByUserAndProgress(String progress, int userId) throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();

        if(progress == null){
            progress = "default";
        }

        switch (progress) {
            case "notStart":
                SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS = SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS.concat("start > CURDATE()");
                break;
            case "inProgress":
                SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS = SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS.concat("start <= CURDATE() and end >= CURDATE()");
                break;
            case "ended":
                SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS = SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS.concat("end < CURDATE()");
                break;
            default:
                SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS = SELECT_COURSES_BY_STUDENT_ID;
        }

        PreparedStatement statement = connection.prepareStatement(SELECT_COURSES_BY_STUDENT_ID_BY_PROGRESS);
        statement.setInt(1, userId);
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


    public List<Course> sortAndChoose(String sortType, int teacherId, String theme) throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        switch (sortType) {
            case "nameAsc":
                SELECT_SORT = SELECT_SORT.concat("c.name ) sort ");
                break;
            case "nameDesc":
                SELECT_SORT = SELECT_SORT.concat("c.name desc ) sort ");
                break;
            case "durationAsc":
                SELECT_SORT = SELECT_SORT.concat("(c.end - c.start) ) sort ");
                break;
            case "durationDesc":
                SELECT_SORT = SELECT_SORT.concat("(c.end - c.start) desc ) sort ");
                break;
            case "studNumbAsc":
                SELECT_SORT = SELECT_SORT.concat("studNum ) sort ");
                break;
            case "studNumbDesc":
                SELECT_SORT = SELECT_SORT.concat("studNum desc ) sort ");
                break;
            default:
                SELECT_SORT = SELECT_SORT.concat("c.id ) sort ");
        }

        PreparedStatement statement = connection.prepareStatement(SELECT_SORT);
        if (teacherId == 0 && theme != null) {
            SELECT_SORT = SELECT_SORT.concat("where theme = ?");
            statement = connection.prepareStatement(SELECT_SORT);
            statement.setString(1, theme);
        }
        if (theme == null && teacherId != 0) {
            SELECT_SORT = SELECT_SORT.concat("where teacher_id = ?");
            statement = connection.prepareStatement(SELECT_SORT);
            statement.setInt(1, teacherId);
        }
        if (teacherId != 0 && theme != null) {
            SELECT_SORT = SELECT_SORT.concat("where teacher_id = ? and theme = ?");
            statement = connection.prepareStatement(SELECT_SORT);
            statement.setInt(1, teacherId);
            statement.setString(2, theme);
        }

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            courses.add(new Course(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getString(6),
                    resultSet.getInt(7),
                    resultSet.getString(8)));
        }
        connection.close();
        return courses;
    }

    public void setCourse(String name, String theme, String start, String end, int teacherId, String description) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, theme);
        preparedStatement.setDate(3, java.sql.Date.valueOf(start));
        preparedStatement.setDate(4, Date.valueOf(end));
        preparedStatement.setInt(5, teacherId);
        preparedStatement.setString(6, description);

        preparedStatement.executeUpdate();
        connection.close();

    }

    public List<Course> getAllCourses() throws SQLException, ClassNotFoundException {
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

    public List<Course> getCoursesByStudentId(int user_id) throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COURSES_BY_STUDENT_ID);
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

    public List<Course> getCoursesByTeacherId(int user_id) throws SQLException, ClassNotFoundException {
        List<Course> courses = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COURSES_BY_TEACHER_ID);
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

    public Course getCourseByIdAndUserId(int courseId, int userId) throws SQLException, ClassNotFoundException {
        Course course = null;
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COURSE_BY_ID_AND_STUDENT_ID);
        statement.setInt(1, courseId);
        statement.setInt(2, userId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            course = new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getDate(6),
                    resultSet.getInt(7));
        }
        connection.close();
        return course;
    }


    public Course getCourseById(int courseId) throws SQLException, ClassNotFoundException {
        Course course = null;
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_COURSE_BY_ID);
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            course = new Course(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getInt(6),
                    resultSet.getString(7)
            );
        }
        connection.close();
        return course;
    }

    public void editCourse(String name, String theme, String start, String end, int teacher_id, String description, int id) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, theme);
        preparedStatement.setDate(3, java.sql.Date.valueOf(start));
        preparedStatement.setDate(4, Date.valueOf(end));
        preparedStatement.setInt(5, teacher_id);
        preparedStatement.setString(6, description);
        preparedStatement.setInt(7, id);

        preparedStatement.executeUpdate();
        connection.close();
    }

    public List<String> getThemes() throws SQLException, ClassNotFoundException {
        List<String> themesList = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        ResultSet resultSet = connection.prepareStatement("select theme from courses group by theme").executeQuery();
        while (resultSet.next()) {
            themesList.add(resultSet.getString(1));
        }
        connection.close();
        return themesList;
    }
}
