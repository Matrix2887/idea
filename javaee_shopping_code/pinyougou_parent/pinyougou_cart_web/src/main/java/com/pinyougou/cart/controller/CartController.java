package com.pinyougou.cart.controller;

import com.alibaba.fastjson.JSON;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.pojogroup.Cart;
import entity.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference(timeout=6000)
    private CartService cartService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    // 从cookie中提取购物车
    @RequestMapping("/findCartList")
    public List<Cart> findCartList(){
        // 获取当前登陆人账号
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        String cartListString = util.CookieUtil.getCookieValue(request, "cartList", "UTF-8");

        if(cartListString==null || "".equals(cartListString)){
            cartListString="[]";
        }

        List<Cart> cartListFromCookies = JSON.parseArray(cartListString, Cart.class);
        if("anonymousUser".equals(username)){ // 如果未登陆
//            System.out.println(cartListFromCookies.toString());
            return cartListFromCookies;
        }else {
            List<Cart> cartListFromRedis = cartService.findCartListFromRedis(username);

            if(cartListFromCookies.size()>0) {//判断当本地购物车中存在数据
                // 合并两个购物车集合
                List<Cart> cartList = cartService.mergeCartList(cartListFromRedis, cartListFromCookies);
                //本地购物车清除
                util.CookieUtil.deleteCookie(request, response, "cartList");
                return cartList;
            }
//            System.out.println(cartListFromRedis.toString());
            return cartListFromRedis;
        }
    }

    @RequestMapping("/addGoodsToCartList")
    @CrossOrigin(origins = "http://localhost:9105", allowCredentials = "true")
    public Result addGoodsToCartList(Long itemId, Integer num){

        // 当此方法不需要操作cookie
        // response.setHeader("Access-Control-Allow-Origin", "http://localhost:9105"); // 可以访问的域
        // 操作cookie
        // response.setHeader("Access-Control-Allow-Credentials", "true"); // 如果操作cookie, 必须加上

        try {
            // 获取当前登陆人账号
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            List<Cart> cartList = findCartList();
            cartList = cartService.addGoodsToCartList(cartList, itemId, num);
            if("anonymousUser".equals(username)) { // 如果未登陆
                String cartListString = JSON.toJSONString(cartList);
                util.CookieUtil.setCookie(request, response, "cartList", cartListString, 3600 * 24, "UTF-8");
            }else { // 如果已经登陆
                cartService.saveCartListToRedis(username, cartList);
            }
            return new Result(true, "加入购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "加入购物车失败");
        }

    }

}
