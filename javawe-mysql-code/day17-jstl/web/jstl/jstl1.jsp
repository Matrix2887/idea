<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>jstl</title>
</head>
<body>


    <c:if test="true">
        <h1>我爱盛利</h1>
    </c:if>

    <%
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        request.setAttribute("list",list);
    %>

    <c:if test="${not empty list}">
        <h1>我爱盛利</h1>
    </c:if>

</body>
</html>
