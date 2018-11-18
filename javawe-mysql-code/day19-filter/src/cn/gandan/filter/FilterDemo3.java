package cn.gandan.filter;

import javax.servlet.*;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo3 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("盛利来了");

        // 放行
        chain.doFilter(req, resp);

        System.out.println("盛利睡觉觉了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
