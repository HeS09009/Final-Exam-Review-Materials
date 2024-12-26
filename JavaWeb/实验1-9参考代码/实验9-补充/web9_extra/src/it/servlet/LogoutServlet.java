package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //【代码六】清除当前登录用户名（session中的username）以及cookie中的username和userpass

        // 清除当前登录用户
        req.getSession().removeAttribute("username");
        // 清除cookie
        Cookie cookie1 = new Cookie("username", "");
        Cookie cookie2 = new Cookie("userpass", "");
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

}
