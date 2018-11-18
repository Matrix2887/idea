package cn.gandan.web;

import cn.gandan.dao.UserDao;
import cn.gandan.domain.User;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
   /*     // 获取用户名以及密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 创建一个用户类的对象
        User logUser = new User();
        // 更改这个用户类的用户名和密码属性值
        logUser.setUsername(username);
        logUser.setPassword(password);*/

        Map<String, String[]> map = request.getParameterMap();
        User loginUser = new User();
        try {
            org.apache.commons.beanutils.BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 创建一个登陆方法
        UserDao userDao = new UserDao();
        // 调用登陆方法login并传入参数user对象,并用一个user的对象接收
        User user = userDao.login(loginUser);
//        System.out.println(user);
        // 判断,如果这个user是个空值,证明这个用户不存在,跳转到用户不存在的页面
        if(user == null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            // 不是空,用户存在,跳转到这个用户存在的界面,并且设置区域共享资源
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
