package cn.gandan.web.servlet;

import cn.gandan.service.UserService;
import cn.gandan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/existServlet")
public class ExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        System.out.println(name);

        UserService service = new UserServiceImpl();

        boolean exist = service.exist(name);

        request.setAttribute("exist",exist);

        System.out.println(exist);

        request.getRequestDispatcher("/register.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
