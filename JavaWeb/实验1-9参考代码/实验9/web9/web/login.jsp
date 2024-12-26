<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = "";
    String userpass = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if ("username".equals(cookies[i].getName())) {
                username = cookies[i].getValue();
            }
            if ("userpass".equals(cookies[i].getName())) {
                //【代码1】
                userpass=cookies[i].getValue();
            }
        }
    }
%>

<form action="<%=request.getContextPath()%>/login" method="post">
    username:<input type="text" name="username" value="<%=username%>"/><br>
    password:<input type="password"  name="userpass" value="<%=userpass%>"/><br>
    <input type="checkbox" value="y" name="isLogin" checked>七天内免登录<br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
