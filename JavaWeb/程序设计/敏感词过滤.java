package it.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //【代码2】如果上一级页面不是display.jsp，则跳转到display.jsp页面
        String referer = req.getHeader("referer");
        if (referer==null|| !referer.startsWith("http://localhost:8080/web9/display.jsp")){
            resp.sendRedirect(req.getContextPath()+"/display.jsp");
            return;
        }

        //【代码3】声明并初始化变量goods
        String goods="";
        //读取cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("goods".equals(c.getName())) {
                    goods = URLDecoder.decode(c.getValue(),"utf-8");
                    break;
                }
            }
        }

        //【代码4】从请求对象中，获取被点击的商品名，赋值给name
        String name = req.getParameter("name");

        //判断goods中是否包含被点击的商品名。若不包含，则将商品名添加到goods中。
        if (!goods.contains(name)) {
            goods =  name +" "+goods;
        }
        //【代码5】将goods进行URL编码后，存入客户端浏览器的Cookie中
        goods = URLEncoder.encode(goods,"utf-8");//对goods进行编码处理
        Cookie c = new Cookie("goods", goods);
        resp.addCookie(c);
        resp.sendRedirect(req.getContextPath() + "/display.jsp");
    }

}
