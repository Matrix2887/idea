<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>foreach标签</title>
</head>
<body>

  <%

  %>

    <c:forEach begin="10" end="99" var="i" step="2" varStatus="s">
        ${i} <b>${s.index}</b> <i>${s.count}</i> <br>
    </c:forEach>


<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    request.setAttribute("list",list);
%>

<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} <b>${s.count}</b> <i>${str}</i> <br>

</c:forEach>




</body>
</html>
