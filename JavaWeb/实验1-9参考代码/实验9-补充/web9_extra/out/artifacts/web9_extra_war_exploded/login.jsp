<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div style="color:red"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error")%></div>
<form action="<%= request.getContextPath()%>/login" method="post">
    <table>
        <tr>
            <td>用户名</td><td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td><td><input type="password" name="userpass"></td>

        </tr>
        <tr>
            <td colspan="2"><input type="checkbox" name="remember" id="remember" value="yes"><label for="remember">记住我</label> </td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
