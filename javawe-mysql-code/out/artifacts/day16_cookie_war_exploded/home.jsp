<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uplay</title>
</head>
<body>
  <%
//      response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write("233");

      Cookie[] cookies = request.getCookies();

      boolean count = false;
      if(cookies != null && cookies.length > 0) {
          for (Cookie cookie : cookies) {
              String name = cookie.getName();
              if ("lastTime".equals(name)) {
                  count = true;

                  String value = cookie.getValue();

                  Date date = new Date();

                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

                  String format = sdf.format(date);


                  format = URLEncoder.encode(format, "utf-8");

                  cookie.setValue(format);

                  cookie.setMaxAge(7 * 7 * 7 * 7 * 7 * 7 * 7);

                  response.addCookie(cookie);

                  value = URLDecoder.decode(value, "utf-8");

                  out.write("欢迎回来,你上次登陆的时间为" + value);

                  break;
              }
          }
      }

      if(cookies == null || cookies.length == 0 || count == false){
          Date date = new Date();

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

          String format = sdf.format(date);

          format = URLEncoder.encode(format, "utf-8");

          Cookie cookie = new Cookie("lastTime", format);

          cookie.setMaxAge(7*7*7*7*7*7*7);

          response.addCookie(cookie);

          out.write("欢迎新用户");
      }
  %>

<input type="text" value="name">

</body>
</html>
