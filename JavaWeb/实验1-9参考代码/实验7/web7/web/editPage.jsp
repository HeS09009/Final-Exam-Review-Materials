<%@page import="java.util.*"%>
<%@page import="it.entity.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<h1>编辑用户信息</h1>
<%
    //从application(ServletContext对象)中获取全局变量users的值
    List<User> users = (ArrayList<User>) application.getAttribute("users");
    //获取被编辑的用户的下标值
    int index = Integer.parseInt(request.getParameter("index"));
    //根据下标获取待编辑的用户
    User user = users.get(index);

    //【代码5】读取待编辑用户的基本信息，为sno、name、age、gender变量赋值
    String sno = user.getSno();
    String name=user.getName();
    Integer age=user.getAge();
    String gender = user.getGender();

%>
<form action="edit?index=<%=index%>" method = "post">
    <!--通过?在form的action后面传递参数时，需要指定form的method="post",不然无法获得?后面的参数-->
    学号 <input type="text" name="sno" readonly="true" value="<%=sno%>"><br/>
    姓名 <input type="text" name="name" value="<%=name%>"><br/>
    年龄 <input type="text" name="age" value="<%=age%>"><br/>
    性别 <input type="text" name="gender"  value="<%=gender%>"><br/>
    <br/>
    <input type="submit" value="提交"></br>
</form>
</body>
</html>
