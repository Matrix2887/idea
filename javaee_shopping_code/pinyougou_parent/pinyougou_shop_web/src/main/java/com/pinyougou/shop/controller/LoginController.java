package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Reference
    private SellerService sellerService;

    @RequestMapping("/name")
    public Map name(){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        TbSeller seller = sellerService.findOne(id);
        String name = seller.getNickName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

}
