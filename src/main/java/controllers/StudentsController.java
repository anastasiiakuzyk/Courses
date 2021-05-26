package controllers;

import models.Course;
import models.User;
import services.BlockedService;
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

@WebServlet("/students")
public class StudentsController extends HttpServlet {

    UserService userService = new UserService();
    CourseService courseService = new CourseService();
    BlockedService blockedService = new BlockedService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> students = null;
        try {
            students = userService.getAllStudents();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        List<List<Course>> coursesOfStudents = new ArrayList<>();

        int max = 0;
        for (User student : students) {
            max = Math.max(student.getId(), max);
        }

        for (int i = 0; i < max + 1; i++) {
            coursesOfStudents.add(null);
        }

        for (User student : students) {
            List<Course> courses = new ArrayList<>();
            try {
                courses = courseService.getCoursesByStudentId(student.getId());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            coursesOfStudents.add(student.getId(), courses);
        }

        req.setAttribute("students", students);
        req.setAttribute("coursesOfStudents", coursesOfStudents);

        req.getRequestDispatcher("views/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        try {
            blockedService.setBlocked(studentId, 1);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("students");
    }
}
