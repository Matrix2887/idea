package com.pinyougou.cart.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbOrderItem;
import com.pinyougou.pojogroup.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Cart> addGoodsToCartList(List<Cart> cartList, Long itemId, Integer num) {
    // 1    根据商品的id查询商品
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
        if(tbItem==null){
            throw new RuntimeException("商品不存在");
        }
        if(!"1".equals(tbItem.getStatus())){
            throw new RuntimeException("非法商品");
        }

    // 2    查询商家id
        String sellerId = tbItem.getSellerId();

    // 3    根据商家id在购物车列表中查找商家对象
        Cart cart = searchCartBySellerId(cartList, sellerId);

        // 4    如果购物车列表中不存在该商家
        if(cart==null){
            // 4.1  创建一个新的购物对象
            cart = new Cart();
            cart.setSellerId(sellerId); // 商家id
            cart.setSellerName(tbItem.getSeller()); // 商家名称
            List<TbOrderItem> orderItemList = new ArrayList<>();
            orderItemList.add(creatTbOrderItem(tbItem, num));
            cart.setTbOrderItemList(orderItemList);

            // 4.2  存到购物车集合中
            cartList.add(cart);

        }else {
            // 5    如果购物车列表中存在该商家
            TbOrderItem tbOrderItem = searchTbOrderItemByItemId(cart.getTbOrderItemList(), itemId);
            // 5.1  判断该商品是否存在该明细 列表
            if(tbOrderItem==null){
                // 5.2  不存在 创建新的明细对象 并添加到购物车列表中
                tbOrderItem = creatTbOrderItem(tbItem, num);
                cart.getTbOrderItemList().add(tbOrderItem);

            }else {
                // 5.3  存在 在原有的数量上添加数量
                tbOrderItem.setNum(tbOrderItem.getNum()+num);
                // 6    更新金额
                tbOrderItem.setTotalFee(new BigDecimal(tbItem.getPrice().doubleValue()* tbOrderItem.getNum()));
                // 如果数量小于等于0
                if(tbOrderItem.getNum()<=0){
                    cart.getTbOrderItemList().remove(tbOrderItem);
                }
                // 当购物车列表中没有商品
                if(cart.getTbOrderItemList().size()==0){
                    cartList.remove(cart);
                }
            }

        }

        return cartList;
    }

    /**
     *
     * @param username 当前登陆的用户
     * @return
     */
    @Override
    public List<Cart> findCartListFromRedis(String username) {
        List<Cart> cartList = (List<Cart>) redisTemplate.boundHashOps("cartList").get(username);
        if(cartList == null){
            cartList = new ArrayList<>();
        }
        return cartList;
    }

    /**
     *
     * @param username 当前登陆的用户
     * @param cartList 购物车集合
     */
    @Override
    public void saveCartListToRedis(String username, List<Cart> cartList) {
        redisTemplate.boundHashOps("cartList").put(username, cartList);

    }

    /**
     *
     * @param cartList1
     * @param cartList2
     * @return
     */
    @Override
    public List<Cart> mergeCartList(List<Cart> cartList1, List<Cart> cartList2) {
        for (Cart cart : cartList2) {
            for (TbOrderItem tbOrderItem : cart.getTbOrderItemList()) {
                cartList1 = addGoodsToCartList(cartList1, tbOrderItem.getItemId(), tbOrderItem.getNum());
            }
        }
        return cartList1;
    }

    /**
     * 根据商家id在购物车列表中查找商家对象
     * @param cartList
     * @param sellerId
     * @return
     */
    private Cart searchCartBySellerId(List<Cart> cartList, String sellerId){
        for (Cart cart : cartList) {
            if(cart.getSellerId().equals(sellerId)){
                return cart;
            }
        }
        return null;
    }

    private TbOrderItem creatTbOrderItem(TbItem tbItem, Integer num){
        TbOrderItem tbOrderItem = new TbOrderItem();

        //创建新的购物车明细对象
        TbOrderItem orderItem=new TbOrderItem();
        orderItem.setGoodsId(tbItem.getGoodsId());
        orderItem.setItemId(tbItem.getId());
        orderItem.setNum(num);
        orderItem.setPicPath(tbItem.getImage());
        orderItem.setPrice(tbItem.getPrice());
        orderItem.setSellerId(tbItem.getSellerId());
        orderItem.setTitle(tbItem.getTitle());
        orderItem.setTotalFee(  new BigDecimal(tbItem.getPrice().doubleValue()*num) );
        return orderItem;
    }

    /**
     * 在购物车明细列表中查询商品
     * @param tbOrderItemList
     * @param itemId
     * @return
     */
    private TbOrderItem searchTbOrderItemByItemId(List<TbOrderItem> tbOrderItemList, Long itemId){
        for (TbOrderItem tbOrderItem : tbOrderItemList) {
            if(tbOrderItem.getItemId().equals(itemId)){
                return tbOrderItem;
            }
        }
        return null;
    }
}
