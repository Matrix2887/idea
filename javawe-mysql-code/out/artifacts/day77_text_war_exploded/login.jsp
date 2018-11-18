<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    用户名:<input type="text" name="name" class="form-control" id="name" placeholder="请输入用户名"/><br/>
    密码:<input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"><br/>

    <input class="btn btn-primary" type="submit" value="登陆" />
</form>
    <h2>${login_error}</h2>

</body>
</html>
