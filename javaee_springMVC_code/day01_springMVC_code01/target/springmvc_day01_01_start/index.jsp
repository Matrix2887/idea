<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>我爱盛利</h3>
    <a href="/hello?name=shengli">盛利入口</a>
    <br/>
    <form action="/people" method="post">
        姓名 :<input type="text" name="name"><br/>
        属性 :<input type="text" name="address"><br/>
        年龄 :<input type="text" name="age"><br/>
        账户 :<input type="text" name="user.username"><br/>
        密码 :<input type="text" name="user.password"><br/>
        集合 :<input type="text" name="map['star'].username"><br/>
        集合 :<input type="text" name="map['star'].password"><br/>

        <input type="submit" value="提交">
    </form>

    <form action="/date" method="get">
        姓名: <input type="text" name="name">
        日期: <input type="text" name="date">
        <input type="submit" value="提交">
    </form>

    <a href="/session">存值</a>
    <a href="/getSession">取值</a>
    <a href="/removeSession">删值</a>


</body>
</html>
