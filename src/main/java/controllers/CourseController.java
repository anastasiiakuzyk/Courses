package controllers;

import models.Course;
import models.Diary;
import models.User;
import services.CourseService;
import services.DiaryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/course")
public class CourseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String courseId = request.getParameter("id");
        int courseIdInt = Integer.parseInt(courseId);
        User user = (User) request.getAttribute("user");

        List<Diary> usersByCourse = null;

        Course course = null;
        CourseService courseService = new CourseService();
        DiaryService diaryService = new DiaryService();
        try {
            course = courseService.getCourseByIdAndUserId(courseIdInt, user.getId());
            if (user.getRoleId() == 2) {
                course = courseService.getCourseById(courseIdInt);
                usersByCourse = diaryService.getUsersByCourse(courseIdInt);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        if (course != null) {
            request.setAttribute("course", course);
            request.setAttribute("usersByCourse", usersByCourse);
            request.getRequestDispatcher("views/course.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int points = Integer.parseInt(request.getParameter("points"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        DiaryService diaryService = new DiaryService();
        try {
            diaryService.setPoints(courseId, studentId, points);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("course?id=" + courseId);
    }
}
