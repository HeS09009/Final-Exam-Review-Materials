<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>商品列表</h3>
<a href="<%=request.getContextPath()%>/display?name=ThinkPad">ThinkPad</a><br/>
<a href="<%=request.getContextPath()%>/display?name=Lenovo">Lenovo</a><br/>
<a href="<%=request.getContextPath()%>/display?name=Apple">Apple</a><br/>
<a href="<%=request.getContextPath()%>/display?name=Sony">Sony</a><br/>
<a href="<%=request.getContextPath()%>/display?name=Dell">Dell</a><br/>
<a href="<%=request.getContextPath()%>/display?name=ACER">ACER</a><br/>

<h3>浏览过的商品</h3>
<%
    //【代码1】从Cookie中读取名为“goods”的值，URLDecoder解码后显示在页面中
    Cookie[] cookies = request.getCookies();
    if (cookies!=null) {
        for (Cookie cookie:cookies) {
            if ("goods".equals(cookie.getName())){
                out.print(URLDecoder.decode(cookie.getValue(),"utf-8"));
                break;
            }
        }
    }
%>
</body>
</html>
