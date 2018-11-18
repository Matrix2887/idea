package cn.gandan.filter;

import javax.servlet.*;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo4 implements Filter {

    // 每次访问都会执行doFilter方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    // 在服务器启动后,会创建filter对象,然后调用init方法,只执行一次,获取资源
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    // 在服务器停止之前,会调用destroy方法,只执行一次,释放资源
    public void destroy() {
        System.out.println("destroy...");
    }

}
