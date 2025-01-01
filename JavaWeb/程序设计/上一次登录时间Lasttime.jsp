<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  //1、获取请求中的cookie
  String msg = "您是第一次访问本系统";
  Cookie[] cs = request.getCookies();
  if (cs != null) {
    for (Cookie c : cs) {
      if ("lasttime".equals(c.getName())) {
        msg = "上一次的访问时间为：" + URLDecoder.decode(c.getValue(),"utf-8");
        //存储lasttime时，对数据进行了编码；因此读取时要先解码
      }
    }
  }
  //2、把当前时间保存到cookie中
  DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH表示24小时制
  Date date = new Date();//获取当前时间
  String formatDate = dFormat.format(date); //对当前时间进行格式化处理，返回数据如：2023-12-12 21:15:20
  Cookie c = new Cookie("lasttime",URLEncoder.encode(formatDate,"utf-8"));
  //对包含空格的formatDate进行了编码，以免出现“Cookie值中存在无效字符”的错误
  c.setMaxAge(3600);
  response.addCookie(c);
%>
<%=msg%>
<h1>页面主体</h1>
</body>
</html>
