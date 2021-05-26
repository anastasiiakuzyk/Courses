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

@WebServlet("/addCourse")
public class AddCourseController extends HttpServlet {
    UserService userService = new UserService();
    CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        List<User> teachers = null;
        try {
            teachers = userService.getAllTeachers();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        String edit = request.getParameter("edit");
        Course course = new Course();
        if (edit != null) {
            try {
                course = courseService.getCourseById(Integer.parseInt(edit));
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            // This block runs when user want to edit course.
        }

        request.setAttribute("course", course);
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("views/add-course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String theme = request.getParameter("theme");
        String description = request.getParameter("description");
        String idString = request.getParameter("id");
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        try {
            if (!idString.equals("")) {
                courseService.editCourse(name, theme, start, end, teacher_id, description, Integer.parseInt(idString));
            } else {
                courseService.setCourse(name, theme, start, end, teacher_id, description);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        response.sendRedirect("courses");
    }
}
