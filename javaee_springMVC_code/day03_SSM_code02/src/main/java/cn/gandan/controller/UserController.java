package cn.gandan.controller;

import cn.gandan.domain.Account;
import cn.gandan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        List<Account> accounts = accountService.findAll();

        ModelAndView mv = new ModelAndView();

        mv.addObject("accounts", accounts);

        mv.setViewName("success");

        return mv;

    }

    @RequestMapping("/save")
    public ModelAndView save(Account account){

        accountService.save(account);

        List<Account> accounts = accountService.findAll();

        ModelAndView mv = new ModelAndView();

        mv.addObject("accounts", accounts);

        mv.setViewName("success");

        return mv;

    }

}
