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
import java.util.List;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        CourseService courseService = new CourseService();
        User user = null;
        List<Course> courses = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                try {
                    user = userService.getUserByToken(cookie.getValue());
                    courses = courseService.getCoursesByUserId(user.getId());
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        req.setAttribute("user", user);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("views/profile.jsp").forward(req, resp);

    }
}
