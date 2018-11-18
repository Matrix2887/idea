package cn.gandan.controller;

import cn.gandan.domain.User;
import cn.gandan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<User> users = userService.findAll();
        mv.addObject("users", users);
        mv.setViewName("success");
        return mv;
    }

}
