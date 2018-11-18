<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register</title>

    <script>

        window.onload = function () {
            document.getElementById("form").onsubmit = function(){
                return  checkName() && checkPassword() && checkPasswordTrue() && checkAge();
            }
            document.getElementById("name").onblur = checkName;
            document.getElementById("password").onblur = checkPassword;
            document.getElementById("password_true").onblur = checkPasswordTrue;
            document.getElementById("age").onblur = checkAge;
        }

        function checkName() {
            var name = document.getElementById("name").value;
            var reg_name = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
            var flag = reg_name.test(name);
            var s_name = document.getElementById("s_name");
            if(flag){
                s_name.innerText = "姓名正确";
            }else{
                s_name.innerText = "姓名错误";
            }
            return flag;
        }

        function checkPassword() {
            var password = document.getElementById("password").value;
            var s_password = document.getElementById("s_password");

            var reg_password = /^\w{6,12}$/;
            var flag = reg_password.test(password);

            if(flag){
                s_password.innerText = "密码符合规范";
            }else{
                s_password.innerText = "密码不符合规范";
            }
            return flag;

        }

        function checkPasswordTrue() {
            var password = document.getElementById("password").value;
            var password_true = document.getElementById("password_true").value;
            var s_password_true = document.getElementById("s_password_true");

            var flag = password == password_true;

            if(flag){
                s_password_true.innerText = "密码验证正确";
            }else{
                s_password_true.innerText = "密码验证错误";
            }
            return flag;
        }

        function checkAge() {
            var age = document.getElementById("age").value;
            var reg_age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
            var flag = reg_age.test(age);
            var s_age = document.getElementById("s_age");
            if(flag){
                s_age.innerText = "年龄正确";
            }else{
                s_age.innerText = "年龄错误";
            }
            return flag;
        }

    </script>
</head>
<body>



    <form action="${pageContext.request.contextPath}/registerServlet" method="post" id="form">
        用户名:<input type="text" name="name" class="form-control" id="name" placeholder="请输入用户名"/>
        <span id="s_name" class="error"></span><br/>
        密码:<input type="password" name="password" class="form-control" id="password" placeholder="请输入密码">
        <span id="s_password" class="error"></span><br/>
        确认密码:<input type="password" name="password-true" class="form-control" id="password_true" placeholder="请确认密码">
        <span id="s_password_true" class="error"></span><br/>
        年龄:<input type="text" name="age" class="form-control" id="age" placeholder="请输入年龄">
        <span id="s_age" class="error"></span><br/>
        爱好:<input type="checkbox" name="hobby" value="盛利" checked="checked">盛利
            <input type="checkbox" name="hobby" value="爆米花">爆米花<br/>
        籍贯:<input type="text"name="address" id="address" class="form-control" placeholder="请输入籍贯"><br/>
        <input class="btn btn-primary" type="submit" value="提交" />
    </form>




</body>
</html>
