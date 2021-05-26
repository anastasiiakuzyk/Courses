package controllers.filters;

import models.User;
import services.BlockedService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    UserService userService = new UserService();
    BlockedService blockedService = new BlockedService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        User user = null;

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                try {
                    user = userService.getUserByToken(cookie.getValue());
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        if (!(uri.contains("login") || uri.contains("register")) && user == null) {
            res.sendRedirect("login");
            return;
        } else if (!(uri.contains("login") || uri.contains("register")) && user != null) {
            try {
                if (blockedService.isUserBlocked(user.getId()) == 1) {
                    res.sendRedirect("login");
                    return;
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        req.setAttribute("user", user);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
