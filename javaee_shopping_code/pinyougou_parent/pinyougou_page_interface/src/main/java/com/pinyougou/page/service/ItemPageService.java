package com.pinyougou.page.service;

public interface ItemPageService {

    /**
     * 根据商品ID生成商品的详细信息页面
     * @param goodsId
     * @return
     */
    public boolean genItemHtml(Long goodsId);


    /**
     * 删除商品详细页
     * @param goodsIds
     * @return
     */
    public boolean deleteItemHtml(Long[] goodsIds);

}
