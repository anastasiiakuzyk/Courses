package controllers;

import models.Course;
import models.User;
import services.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseService();
        User user = (User) req.getAttribute("user");
        String progress = req.getParameter("progress");
        List<Course> courses = null;
        try {
            if (user.getRoleId() == 3) {
                courses = courseService.getCoursesByUserAndProgress(progress, user.getId());
            } else if (user.getRoleId() == 2) {
                courses = courseService.getCoursesByTeacherId(user.getId());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("user", user);
        req.setAttribute("courses", courses);
        req.setAttribute("progress", progress);
        req.getRequestDispatcher("views/profile.jsp").forward(req, resp);
    }
}
