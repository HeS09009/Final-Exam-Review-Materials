<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>注册</title>
</head>
<body>
<h1>欢迎注册！</h1>
<form action="<%=request.getContextPath()%>/register" method="post">
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
      <td><input type='submit' value='注册'></td>
    </tr>
  </table>
</form>
</body>
</html>
