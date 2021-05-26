package tags;

import models.User;
import services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import java.sql.SQLException;

public class MenuTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        User user = null;
        UserService userService = new UserService();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                try {
                    user = userService.getUserByToken(cookie.getValue());
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        String path = request.getServletPath();
        String servletName = path.replace("/views", "").replace(".jsp", "");
        JspWriter out = getJspContext().getOut();
        out.print("        <div class=\"d-flex flex-column flex-shrink-0 p-3 text-white bg-dark\" style=\"width: 280px;\">\n" +
                "        <a href=\"/\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none\">\n" +
                "\n" +
                "            <span class=\"fs-4\" style=\"margin-left: 5px\">TechPortal</span>\n" +
                "        </a>\n" +
                "        <hr>\n" +
                "        <ul class=\"nav nav-pills flex-column mb-auto\">\n" +
                "            <li class=\"nav-item\">\n" +
                "                <a href=\"profile\" class=\"nav-link " + (servletName.equals("/profile") ? "active" : "text-white") + "\" >\n" +
                "                    Профіль\n" +
                "                </a>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                <a href=\"courses\" class=\"nav-link " + (servletName.equals("/courses") ? "active" : "text-white") + "\">\n" +
                "                    Курси\n" +
                "                </a>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                <a href=\"teachers\" class=\"nav-link " + (servletName.equals("/teachers") ? "active" : "text-white") + "\">\n" +
                "                    Викладачі\n" +
                "                </a>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                <a href=\"students\" class=\"nav-link " + (servletName.equals("/students") ? "active" : "text-white") + "\">\n" +
                "                    Учні\n" +
                "                </a>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        <hr>\n" +
                "        <div class=\"dropdown\">\n" +
                "            <a href=\"#\" class=\"d-flex align-items-center text-white text-decoration-none dropdown-toggle\"\n" +
                "               id=\"dropdownUser1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><strong>" +
                "                   "+user.getName()+
                "                  </strong>\n" +
                "            </a>\n" +
                "            <ul class=\"dropdown-menu dropdown-menu-dark text-small shadow\" aria-labelledby=\"dropdownUser1\">\n" +
                "                <li><a class=\"dropdown-item\" href=\"signout\">Sign out</a></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </div>");
    }
}
