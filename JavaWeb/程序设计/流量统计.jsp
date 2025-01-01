<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    Integer count = (Integer) application.getAttribute("count");
    count = count == null ? 1 : count + 1;
    application.setAttribute("count", count);
%>
您是当前的第<%=count%>位访客
</body>
</html>
