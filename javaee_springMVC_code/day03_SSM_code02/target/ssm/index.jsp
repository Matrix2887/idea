<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

</head>
<body>

<h3>我爱盛利</h3>

<a href="/user/findAll">查询所有盛利</a>

<form action="/user/save">
    姓名:<input type="text" name="name"><br/>
    收入:<input type="text" name="money"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>