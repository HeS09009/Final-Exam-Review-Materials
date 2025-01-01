<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    // 先判断session中是否有用户名
    String username = (String) session.getAttribute("username");
    String userpass = null;
    if (username == null) {
        /* session中没有用户名，即：用户没有经过LoginServlet的登录成功的验证（用户没有登录过）,
        则判断Cookie中是否有用户名，如果有，则说明用户之前登录时选择了“记住我”*/

        //【代码四】从cookie中读取用户名和密码
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if ("username".equals(cookie.getName())){
                    username= cookie.getValue();
                }
                if ("userpass".equals(cookie.getName())){
                    userpass = cookie.getValue();
                }
            }
        }

        if (username != null && userpass != null) {  //用户选择过“记住我”（免密登录）
            if ("张三".equals(username) && "123456".equals(userpass)) {
                 //【代码五】cookie中的用户名和密码正确，将用户名存储到session
                /* 存储到session的目的是，之后只要还是在一次会话中访问welcome.jsp，
                则直接从session中读取用户名，而不再访问cookie*/
                session.setAttribute("username",username);
            } else {//cookie中的用户名或密码不正确，跳转到登录页面
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        } else {//session中无用户名；cookie中无用户名或密码（用户没有选择免密登录），则跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
    }
%>
<%--session中有用户名；或者：session中无用户名，但cookie中存储了正确的用户名和密码，则显示“***，欢迎您！”--%>
<%=username%>，欢迎您！<a href="<%=request.getContextPath()%>/logout">退出登录</a>
</body>
</html>
