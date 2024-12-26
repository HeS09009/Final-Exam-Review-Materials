<!--product.jsp-->
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>

<h3>商品类别列表</h3>
<a href="product.jsp?item=服装">服装</a>
<a href="product.jsp?item=电器">电器</a>
<a href="product.jsp?item=礼品">礼品</a>
<a href="product.jsp?item=娱乐">娱乐</a>

<h3>上一次浏览的商品类别</h3>
<%
  String item = "";
  //读取cookie
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if ("item".equals(cookie.getName())) {
        item = cookie.getValue();
        item = URLDecoder.decode(item, "utf-8"); //使用utf-8对item（urlencoded字符串）解码
        break;
      }
    }
  }
  //在页面中输出item
  out.print(item);
  item = request.getParameter("item"); //获得用户点击的商品类别名，例如，服装
  if (item!=null) { //如果用户点击了某个商品类别，则将该类别存入cookie中
    item = URLEncoder.encode(item, "utf-8"); //使用utf-8，将item转换为urlencoded 格式的字符串
    Cookie c = new Cookie("item", item);
    c.setMaxAge(60 * 60 * 24 * 7);
    response.addCookie(c); //将c响应到客户端
    //response.sendRedirect("product.jsp");
  }
%>

</body>