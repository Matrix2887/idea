package cn.gandan.filter;

import javax.servlet.*;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo6 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter6-->go");
        chain.doFilter(req, resp);
        System.out.println("filter6-->break");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
