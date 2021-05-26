package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.TokenService;
import services.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                response.sendRedirect("profile");
                return;
            }
        }
        response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        try {
            user = userService.getUserByEmail(email);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (user == null) {
            response.setContentType("text/html; charset=UTF-8");
            request.getRequestDispatcher("views/index.jsp").include(request, response);
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            TokenService tokenService = new TokenService();
            String token = tokenService.generateNewToken();
            try {
                tokenService.setToken(user.getId(), token);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            response.addCookie(new Cookie("token", token));
            response.sendRedirect("profile");
        } else {
            response.setContentType("text/html; charset=UTF-8");
            request.getRequestDispatcher("views/index.jsp").include(request, response);
        }
    }
}
