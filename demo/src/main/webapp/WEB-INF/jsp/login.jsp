<%--
  Created by IntelliJ IDEA.
  User: qyt
  Date: 18/2/27
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
  <form action="/login" method="post">
      用户名：<input name="username">
      密码：  <input type="password" name="password">
      <input type="submit" value="提交">
  </form>
</body>
</html>
