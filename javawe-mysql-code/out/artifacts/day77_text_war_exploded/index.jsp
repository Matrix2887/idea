<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h1>注册成功</h1>
    <h3>${user.name}欢迎你</h3>

    <a
            href="${pageContext.request.contextPath}/login.jsp" style="text-decoration:none;font-size:33px;font-family: 方正喵呜体">立即登陆
    </a>

  </body>
</html>
