<%@ page import="cn.gandan.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("盛利");
        user.setAge(17);
        user.setBirthday(new Date());
        request.setAttribute("sl",user);

        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("可爱","盛利");
        map.put("可耐","爆米花");
        map.put("user",user);
        request.setAttribute("map",map);

    %>
<h3>获取对象中的值</h3>

${requestScope.sl}<br>
${requestScope.sl.name}<br>
${requestScope.sl.age}<br>
${requestScope.sl.birthday}<br>
${requestScope.sl.bit}<br>

<h3>获取list值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[-1]}<br>
${list[2].name}<br>

${map.可耐}<br>
${map["可爱"]}<br>
${map.user.name}<br>



</body>
</html>
