package it.servlet;

import it.entity.User;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*【代码4】当用户不是通过点击users.jsp的超链接来到该页面时，跳转到users.jsp */
        String referer = req.getHeader("referer");//获取上一级页面的URL
        //System.out.println(referer);
        if (!Objects.equals("http://localhost:8080/web7/users.jsp", referer)) {
            resp.sendRedirect("users.jsp");//重定向后，代码还会往下执行；
            return;// 通过return语句，让之后代码不再执行
        }
        int index = Integer.parseInt(req.getParameter("index"));
        List<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
        users.remove(index);
        resp.sendRedirect(req.getContextPath() + "/users.jsp");
//        req.getRequestDispatcher("/users.jsp").forward(req,resp);
    }
}
