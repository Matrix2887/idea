package cn.gandan.controller;


import cn.gandan.domain.Product;
import cn.gandan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static oracle.jdbc.driver.DatabaseError.test;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/test.do")
    public ModelAndView testService(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        String test = productService.test();
        System.out.println(test);
        return mv;
    }

    // 产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    // 产品查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList", productList);
        mv.setViewName("product-list");
        return mv;
    }

}
