<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"login/ajax",
                    contentType:"application/json; charset=UTF-8",
                    data:'{"name":"盛利","address":"我的仙女"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {

                        alert(data);
                        alert(data.name);
                        alert(data.address);

                    }
                });
            });
        });
    </script>
</head>
<body>

    <h3><a href="/login/user">点一下,玩一年</a></h3>
    <h3><a href="/login/request">装备不花一分钱</a></h3>
    <h3><a href="/login/model">古天乐绿了,古天乐绿了</a></h3>
    <h3><a href="/login/for">大家好,我是渣渣辉</a></h3>
    <br/>
    <button id="btn">点一下</button>

</body>
</html>