package cn.gandan.web.servlet01;

import javax.servlet.*;
import java.io.IOException;

public class Demo02Servlet implements Servlet {


    // 初始方法
    // 在Servlet被创建时,执行 只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("盛利来了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    // 提供服务方法
    // 每一次Servlet被访问时,执行 执行多次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我爱盛利");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


    // 销毁方法
    // 在服务器正常关闭时,执行 执行一次
    @Override
    public void destroy() {
        System.out.println("拜拜盛利");
    }
}
