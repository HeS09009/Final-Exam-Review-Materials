<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            color:red;
            font-weight: bold
        }
    </style>
</head>
<body>
<%
    //【代码8】
    String username =(String)session.getAttribute("username");
    if (username==null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<span><%=username%></span>,欢迎您！

</body>
</html>
