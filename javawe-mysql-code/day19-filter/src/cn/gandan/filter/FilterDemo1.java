package cn.gandan.filter;

import javax.servlet.*;
import java.io.IOException;


// @WebFilter("/*") // 访问所有资源之前,都会执行该过滤器
public class FilterDemo1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我爱盛利");

        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
