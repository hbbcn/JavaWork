<%--
  Created by IntelliJ IDEA.
  User: 30988
  Date: 2021/8/1
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/13_cookie_session/loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
        密码：<input type="password" name="password" id=""><br/>
        <input type="submit" value="登录">


    </form>
</body>
</html>
