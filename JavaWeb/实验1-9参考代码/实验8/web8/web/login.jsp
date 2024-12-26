<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>login</title>
    <script>
        function _change() {
            //获取<img>元素
            var imgEle = document.getElementById("vCode");
            imgEle.src = "<%=request.getContextPath()%>/checkCodeServlet?"+new Date().getTime();
            //因为某些浏览器会对src缓存，所以需要添加不同的参数，保证每次的URL参数都不同
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="<%= request.getContextPath()%>/login" method="post">
    <table>
        <tr>
            <td>用户名</td><td><input type="text" name="username"></td></tr>
        <tr>
            <td>密码</td><td><input type="password" name="userpass"></td>
            <td><div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div></td></tr>
        <tr>
            <td>验证码</td><td><input type="text" name="checkCode"></td>
            <td><div><%= request.getAttribute("code_error") == null ? "" : request.getAttribute("code_error")%></div></td></tr>
        <tr>
            <td colspan="2">
                <img id="vCode" src="<%=request.getContextPath()%>/checkCodeServlet">
                <a href="javascript:_change()">看不清，换一张</a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
