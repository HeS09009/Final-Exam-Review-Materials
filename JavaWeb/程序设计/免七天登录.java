package it.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //【代码2】
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String isLogin = req.getParameter("isLogin");//选中“七天内免登录”，则isLogin返回“y”；否则，返回null
        if (/*【代码3】登录成功的用户名为本人姓名，密码为本人学号*/"张三".equals(username) && "123456".equals(userpass)) { //登录成功

            resp.getWriter().println("登录成功");
            if ("y".equals(isLogin)) {//不能写成 isLogin.equals("y")
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(3600 * 24 * 7);
                Cookie userpassCookie = new Cookie("userpass", userpass);
                userpassCookie.setMaxAge(3600 * 24 * 7);
                //【代码4】
                resp.addCookie(usernameCookie);
                resp.addCookie(userpassCookie);

            } else {
                //【代码5】
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(0);
                Cookie userpassCookie = new Cookie("userpass", userpass);
                userpassCookie.setMaxAge(0);
                resp.addCookie(usernameCookie);
                resp.addCookie(userpassCookie);
            }

        } else {
            resp.getWriter().println("用户名或密码错误");
        }
    }
}
