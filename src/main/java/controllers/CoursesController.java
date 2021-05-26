package controllers;

import models.Course;
import models.User;
import services.CourseService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/courses")
public class CoursesController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CourseService courseService = new CourseService();
        String sort = req.getParameter("sort");

        String theme = req.getParameter("theme");
        if (theme == null) {
        } else if (theme.equals("default")) {
            theme = null;
        }
        int teacherId;
        String teacher = req.getParameter("teacher");
        if (teacher == null) {
        } else if (teacher.equals("default")) {
            teacher = null;
        }
        if (teacher == null) {
            teacherId = 0;
        } else {
            teacherId = Integer.parseInt(teacher);
        }
        if (sort == null) {
            sort = "default";
        }

        List<Course> courses = null;
        List<User> teachers = null;
        List<String> themes = null;
        try {
            teachers = userService.getAllTeachers();
            themes = courseService.getThemes();
            courses = courseService.sortAndChoose(sort, teacherId, theme);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("courses", courses);
        req.setAttribute("teachers", teachers);
        req.setAttribute("selectedTeacher", teacher);
        req.setAttribute("themes", themes);
        req.setAttribute("selectedTheme", theme);
        req.setAttribute("sort", sort);
        req.getRequestDispatcher("views/courses.jsp").forward(req, resp);
    }
}
