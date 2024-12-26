package it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns="/inner/random") //【代码2】
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet/*【代码3】*/(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        StringBuilder s = new StringBuilder(); //【代码4】创建字符串对象s
        for (int i = 1; i <= 4; i++) {
            //【代码5】从str中随机取得一个字符ch
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            s.append(ch);
        }
        String username = req.getParameter("username")/*【代码6】获取参数username的值*/;
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(username + "，您的幸运字符：" +
                                 "<span style='color: green;font-size: 30px'>"+
                                  s.toString()+"</span>");
    }
}
