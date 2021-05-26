package controllers;

import models.Course;
import models.User;
import services.CourseService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teachers")
public class TeachersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> teachers = null;
        List<List<Course>> coursesByTeachers = new ArrayList<>();


        CourseService courseService = new CourseService();

        try {
            teachers = userService.getAllTeachers();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        int max = 0;
        for (User teacher : teachers) {
            max = Math.max(teacher.getId(), max);
        }

        for (int i = 0; i < max+1 ; i++) {
            coursesByTeachers.add(null);
        }

        for (User teacher : teachers) {
            List<Course> courses = new ArrayList<>();
            try {
                courses = courseService.getCoursesByTeacherId(teacher.getId());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            coursesByTeachers.add(teacher.getId(), courses);
        }

        req.setAttribute("teachers", teachers);
        req.setAttribute("coursesByTeachers", coursesByTeachers);
        req.getRequestDispatcher("views/teachers.jsp").forward(req, resp);
    }
}
