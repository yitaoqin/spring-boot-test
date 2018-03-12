<%--
  Created by IntelliJ IDEA.
  User: qyt
  Date: 18/2/9
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>sssssss</title>
</head>
<body>
<sec:authorize access="hasRole('a')">
    超级管理员
</sec:authorize>
<sec:authorize access="hasRole('p')">
    普通用户
</sec:authorize>
ssssssssssss
</body>
</html>
