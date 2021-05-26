package controllers;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.TokenService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addTeacher")
public class AddTeacherController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("views/add-teacher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        try {
            userService.setTeacher(email, name, hashPassword);
            response.setContentType("text/html; charset=UTF-8");
            response.sendRedirect("teachers");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
