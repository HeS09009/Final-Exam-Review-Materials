package it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收前端数据
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String remember = request.getParameter("remember");

        if (/*【代码一】登录成功的用户名为本人姓名，密码为本人学号*/"张三".equals(username) && "123456".equals(userpass)) {
            //登录成功

            //勾选了“记住我”，remember的值为“yes”；如果没有勾选,remember的值为null
            if ("yes".equals(remember)/*【代码二】*/) {
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("userpass", userpass);
                //设置cookie携带路径为整个项目都携带
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //设置cookie有效期(7天),cookie的过期时间是基于秒设置的
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie1);
                response.addCookie(cookie2);

            } else {
                Cookie cookie1 = new Cookie("username", "");
                Cookie cookie2 = new Cookie("userpass", "");
                cookie1.setMaxAge(0);
                cookie2.setMaxAge(0);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            // 用户名存入session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            //重定向到welcome.jsp
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            return;
        }
        //【代码三】登录失败，将错误信息“用户名或密码错误”转发给login.jsp
        request.setAttribute("error","用户名或密码错误");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
