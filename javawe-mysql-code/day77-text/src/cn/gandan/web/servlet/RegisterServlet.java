package cn.gandan.web.servlet;

import cn.gandan.domain.User;
import cn.gandan.service.UserService;
import cn.gandan.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String[] hobby = request.getParameterValues("hobby");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hobby.length; i++) {
            if(i == hobby.length-1){
                sb.append(hobby[i]);
            }else {
                sb.append(hobby[i] + ",");
            }
        }

        user.setHobby(sb.toString());

        UserService service = new UserServiceImpl();

        service.addUser(user);

        request.setAttribute("user",user);

        request.getRequestDispatcher("/index.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
