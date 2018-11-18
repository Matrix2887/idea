package cn.gandan.controller;

import cn.gandan.domain.Birthday;
import cn.gandan.domain.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.xml.crypto.Data;

@Controller
@SessionAttributes(value = {"msg"})
public class HelloController {

    @RequestMapping(value = "/hello",method = {RequestMethod.GET}, params = {"name"})
    public String hello(String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping("/people")
    public String people(People people){

        System.out.println(people);
        return "success";
    }

    @RequestMapping("/date")
    public String date(Birthday birthday){

        System.out.println(birthday);
        return "success";
    }

    @RequestMapping("/session")
    public String session( Model model){

        System.out.println("session");
        model.addAttribute("msg", "盛利");
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSession(ModelMap modelMap){

        System.out.println("session");
        String s = (String) modelMap.get("msg");
        System.out.println(s);
        return "success";
    }

    @RequestMapping("/removeSession")
    public String removeSession(SessionStatus status){

        System.out.println("SessionStatus");
        status.setComplete();
        return "success";
    }

}
