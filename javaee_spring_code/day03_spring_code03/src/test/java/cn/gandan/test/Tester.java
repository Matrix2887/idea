package cn.gandan.test;

import cn.gandan.service.Servicer;
import cn.gandan.utils.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

    @Test
    public void test(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(Logger.class);

        Servicer service =(Servicer) ac.getBean("serviceImpl");

        service.star();

        System.out.println("+---+---+");
        System.out.println("|   |   |");
        System.out.println("+---+---+");
        System.out.println("|   |   |");
        System.out.println("+---+---+");


        service.bao("爆米花");

    }

}
