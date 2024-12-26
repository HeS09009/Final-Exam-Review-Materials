package it.servlet;

import it.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*【代码5】
        （1）获取ServletContext对象
        （2）从ServletContext对象中，获取全局变量users的值
        （3）获取被删除的用户的下标值
			将字符串转换为整型的方法为：int  Integer.parseInt(String s);
        （4）根据下标删除用户
	    （5）重定向到users.jsp页面。
			 resp.sendRedirect("users.jsp");
       */

        ServletContext context = req.getServletContext();
        List<User> users = (ArrayList<User>) context.getAttribute("users");
        int index = Integer.parseInt(req.getParameter("index"));
        users.remove(index);
        resp.sendRedirect("users.jsp");  //重定向到users.jsp页面
    }
}

