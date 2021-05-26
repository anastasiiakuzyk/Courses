package controllers;

import models.User;
import services.DiaryService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/course/join")
public class DiaryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiaryService diaryService = new DiaryService();
        int id = Integer.parseInt(req.getParameter("id")); //course id
        User user = (User) req.getAttribute("user");
        try {
            diaryService.setDiary(id, user.getId());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getServletContext().getContextPath() + "/courses");
    }
}
