<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
<h1>输入评论内容</h1>
<form action="<%= request.getContextPath()%>/comment" method="post">
    <textarea name="comment" cols="30" rows="10"></textarea>
    <input type="submit" value="提交">
</form>
<p><%= request.getAttribute("tag") == null ? "" : request.getAttribute("tag")%>
    <span style="color:red"><%=request.getAttribute("comment") == null ? "" : request.getAttribute("comment")%></span>
</p>
</body>
</html>
