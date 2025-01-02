package it.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        Dbutils dbutils = new Dbutils();
        //根据用户名查询数据库
        String sql = "select * from users where username=?";
        Object[] params = {username};
        ResultSet resultSet = dbutils.executeQuery(sql, params);
        boolean existUser = true;
        try {
            existUser = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeAll(dbutils.conn,dbutils.pstmt,dbutils.rs);
        }
        if (existUser) {
            resp.getWriter().println("用户名已存在，注册失败！");
        } else {
            sql = "insert into users(username,userpass) values(?,?)";
            params = new Object[]{username, userpass};
            if (1 == dbutils.executeUpdate(sql, params)) {
                resp.getWriter().println("注册成功");
                resp.getWriter().println("<a href='login.jsp'>去登录</a>");
            }
        }
    }
}
