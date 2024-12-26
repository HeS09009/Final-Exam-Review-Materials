package it.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet implements Servlet {
    String username;
    String userpass;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        username = servletConfig.getInitParameter("username");
        userpass = servletConfig.getInitParameter("userpass");
      }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        String username = servletRequest.getParameter("username");
        String userpass = servletRequest.getParameter("userpass");
        if (Objects.equals(username,this.username)&&Objects.equals(userpass,this.userpass)){
            servletResponse.getWriter().println(username+"，欢迎您！");
        }else{
            servletResponse.getWriter().println("用户名或密码错误");
        }
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
