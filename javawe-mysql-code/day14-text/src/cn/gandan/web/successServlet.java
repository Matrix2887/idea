package cn.gandan.web;

import cn.gandan.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        response.setContentType("text/html;charset=utf-8");
        // 获取共享的资源,因为知道资源是由user进行多态的,所以可以进行向下转型成user用来调用user里面的方法
        User user = (User)request.getAttribute("user");

        // 打印之前在确定一下user对象是否为空
        if(user != null){
            // 调用user里面的特有方法,获取user的相关信息并打印出来
        response.getWriter().write("登陆成功" + user.getUsername() + "欢迎你");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
