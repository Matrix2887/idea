package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbOrderItem;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {


    private String sellerId; // 商家id
    private String sellerName; // 商家名称
    private List<TbOrderItem> tbOrderItemList; // 购物车明细集合

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<TbOrderItem> getTbOrderItemList() {
        return tbOrderItemList;
    }

    public void setTbOrderItemList(List<TbOrderItem> tbOrderItemList) {
        this.tbOrderItemList = tbOrderItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "sellerId='" + sellerId + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", tbOrderItemList=" + tbOrderItemList +
                '}';
    }
}
