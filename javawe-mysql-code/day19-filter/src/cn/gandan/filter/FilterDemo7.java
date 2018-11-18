package cn.gandan.filter;

import javax.servlet.*;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo7 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter7-->go");
        chain.doFilter(req, resp);
        System.out.println("filter7-->break");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
