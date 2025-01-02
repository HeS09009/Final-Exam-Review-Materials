package it.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        Dbutils dbutils = new Dbutils();
        //根据输入的用户名和密码查询数据库
        String sql = "select * from users where username=? and userpass=?";
        Object[] params = {username, userpass};
        ResultSet resultSet = dbutils.executeQuery(sql, params);
        boolean successLogin = true;
        try {
            successLogin = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbutils.closeAll(dbutils.conn, dbutils.pstmt, dbutils.rs);
        }
        if (successLogin) {
            resp.getWriter().println("登录成功");
        } else {
            resp.getWriter().println("用户名或密码错误");
        }
    }
}
