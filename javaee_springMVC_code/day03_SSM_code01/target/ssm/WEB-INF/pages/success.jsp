<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>执行成功</h3>

<% System.out.println("执行成功");%>

    <c:forEach items="${accounts}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
