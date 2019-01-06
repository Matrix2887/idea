package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {

    /**
     * 搜索方法
     * @param searchMap
     * @return
     */
    public Map search(Map searchMap);

    /**
     * 导入列表
     * @param list
     */
    public void importList(List list);

    /**
     * 根据ID集合删除
     * @param goodsIds
     */
    public void deleteByGoodsIds(List goodsIds);

}
