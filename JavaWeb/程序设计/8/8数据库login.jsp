<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>用户登录</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
  <table>
    <tr>
      <td>用户名</td>
      <td><input type='text' name='username'/></td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input type='password' name='userpass'/></td>
    </tr>
    <tr>
      <td><input type='submit' value='登录'></td>
      <td><a href="<%=request.getContextPath()%>/register.jsp">还没有用户名，去注册</a></td>
    </tr>
  </table>
</form>
</body>
</html>
