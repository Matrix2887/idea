package cn.gandan.test;

import cn.gandan.dao.ProductDao;
import cn.gandan.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDao {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextService.xml");

        ProductDao productDao = ac.getBean("productDao", ProductDao.class);

        List<Product> products = productDao.findAll();

        for (Product product : products) {
            System.out.println(product);
        }

    }

}
