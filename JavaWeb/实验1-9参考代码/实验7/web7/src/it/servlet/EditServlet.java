package it.servlet;

import it.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //【代码6】设置对请求体的数据进行重新编码使用的字符集为utf-8
        req.setCharacterEncoding("utf-8");
        /*【代码7】设置服务器响应给浏览器的编码方案、以及浏览器显示字符时采用解码方案为utf-8 */
        resp.setContentType("text/html;charset=utf-8");
        //从ServletContext对象中获取全局变量users的值
        List<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
        //获取要修改的用户的下标值
        int index = Integer.parseInt(req.getParameter("index"));
        //【代码8】根据下标获得待修改的用户对象user
        User user = users.get(index);

        //从请求对象中，获取修改后的用户信息
        String sno = req.getParameter("sno");
        // 【代码9】
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        //通过setter，完成用户信息的修改
        user.setSno(sno);
        // 【代码10】
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);

//        resp.getWriter().println("<script>alert('修改成功');window.location.href='"
//                +req.getContextPath()+"/users.jsp'</script>");
//        //如果使用
        resp.getWriter().println("<script>alert('修改成功')</script>");
        resp.sendRedirect(req.getContextPath()+"/users.jsp");
        //浏览器直接跳转到users.jsp，而不显示“修改成功”的javascript对话框

    }

}
