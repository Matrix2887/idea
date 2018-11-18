package cn.gandan.day16.mysql.loginServlet;

import cn.gandan.day16.mysql.dao.UserDao;
import cn.gandan.day16.mysql.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        String check = request.getParameter("checkCode");
        session.removeAttribute("checkCode");


        if(checkCode != null && checkCode.equalsIgnoreCase(check)){

//===========================================================================================================================
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserDao userDao = new UserDao();
            User login = userDao.login(user);
            if(login == null){
                request.setAttribute("login_error","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                request.setAttribute("user",user);
                request.getRequestDispatcher("/successServlet").forward(request,response);
            }
//===========================================================================================================================

        }else {
            request.setAttribute("checkCode_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
