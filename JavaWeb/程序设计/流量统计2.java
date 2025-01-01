package it.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        ServletContext application = req.getServletContext();
        Integer count = (Integer) application.getAttribute("count");
        count = count == null ? 1 : count + 1;
        application.setAttribute("count",count);
        resp.getWriter().print("登录次数为" + count);
    }
}
