package cn.gandan.controller;

import cn.gandan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class Usercontroller {

    @RequestMapping("user")
    public String login(Model model){
        User user = new User();
        user.setName("爆米花");
        user.setAddress("我的仙女");
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("request")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("装备不花一分钱");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 直接响应
        response.getWriter().print("hello");
    }

    @RequestMapping("model")
    public ModelAndView login(){
        System.out.println("古天乐绿了");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setName("盛利利");
        user.setAddress("我的仙女");
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("for")
    public String tfor(){
        System.out.println("大家好,我是渣渣辉");

        // 关键字 forward用于请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        // redirect 用于重定向
        return "redirect:/controller.jsp";
    }

    @RequestMapping("/ajax")
    public @ResponseBody User ajax(@RequestBody User user){

        System.out.println("点一下");
        System.out.println(user);

        user.setName("爆米花");

        return user;

    }

}
