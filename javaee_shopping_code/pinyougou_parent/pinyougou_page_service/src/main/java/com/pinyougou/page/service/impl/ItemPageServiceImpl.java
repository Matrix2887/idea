package com.pinyougou.page.service.impl;

import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.page.service.ItemPageService;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemPageServiceImpl implements ItemPageService {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Value("${pagedir}")
    private String pagedir;

    /**
     *
     * @param goodsId
     * @return
     */
    @Override
    public boolean genItemHtml(Long goodsId) {
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        try {
            Template template = configuration.getTemplate("item.ftl");

            // 创建数据模型
            Map dataModel = new HashMap<>();

            //  1.根据商品id查询商品主表数据
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goods", tbGoods);

            // 2.查询商品的扩展表数据
            TbGoodsDesc tbGoodsDesc = tbGoodsDescMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goodsDesc", tbGoodsDesc);

            // 3.读取商品分类
            String itemCat1 = tbItemCatMapper.selectByPrimaryKey(tbGoods.getCategory1Id()).getName();
            String itemCat2 = tbItemCatMapper.selectByPrimaryKey(tbGoods.getCategory2Id()).getName();
            String itemCat3 = tbItemCatMapper.selectByPrimaryKey(tbGoods.getCategory3Id()).getName();
            dataModel.put("itemCat1", itemCat1);
            dataModel.put("itemCat2", itemCat2);
            dataModel.put("itemCat3", itemCat3);

            // 4.读取SKU列表
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId); // SPU ID
            criteria.andStatusEqualTo("1"); // 状态有效

            // 按是否默认字段进行排序,目的是返回的结果第一条为默认SKU
            example.setOrderByClause("is_default desc");

            List<TbItem> itemList = tbItemMapper.selectByExample(example);
            dataModel.put("itemList", itemList);

            // 输出静态页面
//            Writer out = new FileWriter(pagedir + goodsId + ".html");
            Writer out = new OutputStreamWriter(new FileOutputStream(pagedir + goodsId + ".html"), "UTF-8");
            template.process(dataModel, out); // 输出
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteItemHtml(Long[] goodsIds) {
        try {
            for (Long goodsId : goodsIds) {
                new File(pagedir + goodsId + ".html").delete();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
