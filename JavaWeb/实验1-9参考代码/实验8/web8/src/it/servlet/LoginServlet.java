package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //【代码3】获取用户输入的用户名、密码和验证码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("userpass");
        String checkCode = req.getParameter("checkCode");
        //【代码4】获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //先判断验证码是否正确，忽略大小写比较
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {

            if (/*【代码5】进行用户名和密码的比较。登录成功的用户名为本人姓名，密码为本人学号*/"张三".equals(username) && "123".equals(password)) {

                //【代码6】登录成功，存储用户名到session，并重定向到welcome.jsp
                session.setAttribute("username",username);
                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");

            } else {
                //【代码7】登录失败，存储提示信息“用户名或密码错误”到request，
                // 并转发到login.jsp
                req.setAttribute("login_error", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            //验证码不一致，存储提示信息到request
            req.setAttribute("code_error", "验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
