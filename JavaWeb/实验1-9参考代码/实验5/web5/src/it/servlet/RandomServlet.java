package it.servlet;

import it.entity.Student;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.ArrayList;

@WebServlet("/random")
public class RandomServlet implements Servlet {
    ArrayList<Student> studentList = new ArrayList<>();
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        BufferedReader reader=null;
        try {
            //获取student.txt的实际路径
            String filePath = servletConfig.getServletContext().getRealPath("/WEB-INF/student.txt");
            System.out.println("student.txt的实际路径：" + filePath);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf8"));
            //通过转换流，将读取的字节使用utf-8编码方案转换为字符
            // JDK11中，可以直接在FileReader的构造方法中指定读取文件的编码方案
            String line = null;
            while ((line = reader.readLine()) != null) {
                //【代码2】解析line字符串，往studentList中添加Student对象
                String[] tokens = line.split("：");
                System.out.println(tokens[0]);
                System.out.println(tokens[1]);
                studentList.add(new Student(tokens[0], tokens[1]));
            }
            System.out.println("student data initialization completed!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String numString = servletRequest.getParameter("num");
        servletResponse.setContentType("text/html;charset=UTF-8");
        //当没有传num参数时，随机显示一位学生的姓名
        if (/*【代码3】*/numString == null) {
            int index = (int) (Math.random() * studentList.size());
            servletResponse.getWriter().println("<h1>幸运同学：</h1>"
                    + "编号：" + studentList.get(index).getSno() + "<br>"
                    + "姓名：" + studentList.get(index).getSname());
            return;
        }
        //判断num的值是否在学生集合的下标范围内，
        //如果是，则显示集合中下标为num的学生信息
        //否则，输出出错提示
        int num = /*【代码4】*/Integer.parseInt(numString);
        if (num >= 0 && num < studentList.size()) {
            servletResponse.getWriter().println("<h1>今日“特派员”：</h1>"
                    + "编号：" + studentList.get(num).getSno() + "<br>"
                    + "姓名：" + studentList.get(num).getSname());
        } else {
            //【代码5】输出出错提示
            servletResponse.getWriter().println("<h1>查无此人!</h1>");
            servletResponse.getWriter().println("num的值应在0~" + (studentList.size() - 1) + "之间");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
