package cn.gandan.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Exception;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();

        SysException e = null;

        if(ex instanceof SysException){
            e = (SysException) ex;
        }else {
            e = new SysException("油腻的师姐被管理员抢走了");
        }

        // 创建ModelAndView对象

        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
