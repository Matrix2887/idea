<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.gandan.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>text</title>
</head>
<body>

    <%
        List list = new ArrayList();
        list.add(new User("盛利",17,new Date()));
        list.add(new User("爆米花",12,new Date()));
        list.add(new User("丽丽",24,new Date()));

        request.setAttribute("list",list);


    %>

    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>

        <c:forEach items="${list}" var="user" varStatus="s">

            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="#808080">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.bit}</td>
                </tr>
            </c:if>

            <c:if test="${s.count % 2 == 1}">
                <tr bgcolor="#f0f8ff">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.bit}</td>
                </tr>
            </c:if>




        </c:forEach>





    </table>



</body>
</html>
