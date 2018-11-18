<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    div{
        color: red;
    }
</style>

<script>
    window.onload = function () {
        document.getElementById("img").onclick = function () {
            var img = document.getElementById("img");
            img.src = "/day16/checkCode?time" + new Date().getTime();
        }

        document.getElementById("change").onclick = function () {
            var img = document.getElementById("img");
            img.src = "/day16/checkCode?time" + new Date().getTime();

        }

    }



</script>

<body>
    <form action="/day16/loginServlet" method="post">
        <table>
            <tr>
                <td>
                    用户名:
                </td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>
                    密码:
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    验证码:
                </td>
                <td>
                    <input type="text" name="checkCode">
                </td>
            </tr>
            <tr>
                <th>
                    <img id="img" src="/day16/checkCode" name="checkCode">
                </th>
                <th>
                    <a id="change" href="javascript:void(0);">眼瞎了?换一张</a>
                </th>
            </tr>
            <tr>
                <th colspan="2" ><input type="submit" value="登录"></th>
            </tr>
        </table>
    </form>

    <div><%= request.getAttribute("checkCode_error") == null ? "" : request.getAttribute("checkCode_error") %></div>
    <div><%= request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>


</body>
</html>
