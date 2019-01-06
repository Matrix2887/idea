package com.pinyougou.cart.service;

import com.pinyougou.pojogroup.Cart;

import java.util.List;

public interface CartService {

    /**
     * 添加到购物车的方法
     * @param list 没有添加商品之前的购物车
     * @param itemId 商品的id
     * @param num 商品的数量
     * @return
     */
    public List<Cart> addGoodsToCartList(List<Cart> list, Long itemId, Integer num);

    /**
     * 从redis中查询购物车
     * @param username 当前登陆的用户
     * @return
     */
    public List<Cart> findCartListFromRedis(String username);

    /**
     * 保存购物车到redis中
     * @param username 当前登陆的用户
     * @param cartList 购物车集合
     */
    public void saveCartListToRedis(String username, List<Cart> cartList);

    /**
     * 合并cookie和redis购物车
     * @param cartList1
     * @param cartList2
     * @return
     */
    public List<Cart> mergeCartList(List<Cart> cartList1, List<Cart> cartList2);

}
