<%--【代码1】导入User、List、ArrayList--%>
<%@ page import="it.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>用户信息管理</h1>
    <%
        //application为ServletContext对象，即代表当前web应用
        List<User> users = (List<User>) application.getAttribute("users");
        //当网站中没有users全局变量时，创建users对象，包含初始的用户信息
        if (users == null) {
            users = new ArrayList<>();
            users.add(new User("990001", "张三", 12, "女"));
            users.add(new User("990002", "李四", 12, "男"));
            users.add(new User("990003", "王五", 12, "女"));
            users.add(new User("990004", "赵六", 12, "男"));
            users.add(new User("990005", "小七", 12, "男"));
            //【代码2】 往users中增加至少3个User对象，其中一个User对象对应本人的基本信息
            //【代码3】往ServletContext对象（application）中，存储users
            application.setAttribute("users", users);
        }
    %>
    <table border="1px" width="90%" cellspacing="0">
        <tr>
            <th width="15%">编号</th>
            <th width="15%">学号</th>
            <th width="15%">姓名</th>
            <th width="15%">年龄</th>
            <th width="15%">性别</th>
            <th width="25%">操作</th>
        </tr>
        <%
            int rowNum = 0;//行编号
            for (User user : users) {
                //【代码4】为rowNum、sno、name、age、gender以及deleteLink变量赋值
                rowNum++;
                String sno = user.getSno();
                String name = user.getName();
                Integer age = user.getAge();
                String gender = user.getGender();
                String deleteLink = "delete?index=" + (rowNum - 1);
        %>
        <tr style="text-align: center">
            <td><%= rowNum%>
            </td>
            <td><%= sno%>
            </td>
            <td><%= name%>
            </td>
            <td><%= age%>
            </td>
            <td><%= gender%>
            </td>
            <!--点击“删除”链接，使用javascript脚本弹出确认对话框，单击“确定”后，才执行删除操作-->
            <td>
                <a href="<%=deleteLink%>" onClick="return confirm('您确定要删除吗？请确认');">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
