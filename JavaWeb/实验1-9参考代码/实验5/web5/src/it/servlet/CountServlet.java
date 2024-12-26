package it.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/count")
public class CountServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String planet = servletRequest.getParameter("planet");
        ServletContext context = servletRequest.getServletContext();
        Integer count = (Integer) context.getAttribute("count");
        if (count==null){
            count=1;
        }else {
            count++;
        }
        //count=(count==null)?1:(count+1);
        context.setAttribute("count",count);
        servletResponse.setContentType("text/html;charset=utf-8");
        //设置服务器响应给浏览器的字符编码方案为utf8，并告知浏览器使用utf8对接收的字节进行解码
        servletResponse.getWriter().println("欢迎来到<span style='color: blue'>"+planet+"</span>的星球！");
        //输出星球名
        servletResponse.getWriter().println("所有星球的总访问次数为：<span style='color: red'>"+count+"</span>");
        //输出总访问次数
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
