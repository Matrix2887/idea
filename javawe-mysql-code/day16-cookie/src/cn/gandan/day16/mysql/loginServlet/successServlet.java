package cn.gandan.day16.mysql.loginServlet;

import cn.gandan.day16.mysql.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getAttribute("user");
        User u =(User)user;
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(u.getUsername() + "欢迎登陆" + "<br>");



        response.setContentType("text/html;charset=utf-8");
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

                    response.getWriter().write("欢迎回来,你上次登陆的时间为" + value);

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

            response.getWriter().write("欢迎新用户");
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
