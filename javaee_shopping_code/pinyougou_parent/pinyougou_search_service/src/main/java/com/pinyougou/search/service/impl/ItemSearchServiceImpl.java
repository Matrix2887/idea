package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 5000)
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public Map search(Map searchMap) {
        Map map = new HashMap<>();

        // 空格处理
        String keywords = (String) searchMap.get("keywords");
        // 去除空格
        searchMap.put("keywords", keywords.replace(" ", ""));

        // 1.查询列表
        map.putAll(searchMap(searchMap)); // 高亮显示查询列表

        // 2.分组查询 商品分类列表
        List<String> categoryList = searchCategoryList(searchMap); // 获取分类
        map.put("categoryList", categoryList);

        // 3.查询分类列表的品牌和规格选项
        // 判断分类是否有选择
        String category = (String) searchMap.get("category");
        if(!"".equals(category)){
            map.putAll(searchBrandAndSpecList(category));
        }else {
            if(categoryList.size()>0){
                map.putAll(searchBrandAndSpecList(categoryList.get(0)));
            }
        }

        return map;
    }

    @Override
    public void importList(List list) {
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }

    @Override
    public void deleteByGoodsIds(List goodsIds) {
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_goodsid").in(goodsIds);
        query.addCriteria(criteria);
        solrTemplate.delete(query);
        solrTemplate.commit();
    }


    // 高亮显示查询列表
    private Map searchMap(Map searchMap){
        Map map = new HashMap<>();

        HighlightQuery query = new SimpleHighlightQuery();
        HighlightOptions highlightOptions = new HighlightOptions().addField("item_title"); // 高亮域
        highlightOptions.setSimplePrefix("<em style='color:red'>"); // 设置前缀
        highlightOptions.setSimplePostfix("</em>");// 设置后缀
        query.setHighlightOptions(highlightOptions); // 为查询对象设置高亮选项

        // 1.1 关键字查询
        Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);

        // 1.2 按商品分类过滤
        if(!"".equals(searchMap.get("category"))){ // 如果用户选择了分类
            FilterQuery filterQuery = new SimpleFilterQuery();
            Criteria filterCriteria = new Criteria("item_category").is(searchMap.get("category"));
            filterQuery.addCriteria(filterCriteria);
            query.addFilterQuery(filterQuery);
        }

        // 1.3 按品牌过滤
        if(!"".equals(searchMap.get("brand"))){ // 如果用户选择了品牌
            FilterQuery filterQuery = new SimpleFilterQuery();
            Criteria filterCriteria = new Criteria("item_brand").is(searchMap.get("brand"));
            filterQuery.addCriteria(filterCriteria);
            query.addFilterQuery(filterQuery);
        }

        // 1.4 按规格过滤
        if(searchMap.get("spec") != null){ // 规格有多个所以要循环
            Map<String, String> specMap = (Map<String, String>) searchMap.get("spec");
            for (String key : specMap.keySet()) {

                FilterQuery filterQuery = new SimpleFilterQuery();
                Criteria filterCriteria = new Criteria("item_spec_" + key).is(specMap.get(key));
                filterQuery.addCriteria(filterCriteria);
                query.addFilterQuery(filterQuery);

            }
        }

        // 1.5 按价格过滤
        if(!"".equals(searchMap.get("price"))){
            String[] price = ((String) searchMap.get("price")).split("-");
            if(!"0".equals(price[0])){ // 如果最低价格不等于0
                FilterQuery filterQuery = new SimpleFilterQuery();
                Criteria filterCriteria = new Criteria("item_price").greaterThanEqual(price[0]);
                filterQuery.addCriteria(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
               if(!"*".equals(price[1])){ // 如果最高价格不等于*
                FilterQuery filterQuery = new SimpleFilterQuery();
                Criteria filterCriteria = new Criteria("item_price").lessThanEqual(price[1]);
                filterQuery.addCriteria(filterCriteria);
                query.addFilterQuery(filterQuery);
            }

        }

        // 1.6 分页过滤
        Integer pageNo = (Integer) searchMap.get("pageNo"); // 获取页码
        if(pageNo == null){
            pageNo = 1;
        }
        Integer pageSize = (Integer) searchMap.get("pageSize"); // 获取每页显示条数
        if(pageSize == null){
            pageSize = 20;
        }

        query.setOffset((pageNo - 1) * pageSize); //设置起始索引
        query.setRows(pageSize); // 每页记录数

        // 1.7 排序过滤
        String sortValue = searchMap.get("sort").toString(); // 排序方式 ASC升序  DESC降序
        String sortField = searchMap.get("sortField").toString(); // 排序字段
        if(sortValue != null && sortValue.length() > 0){
            if("ASC".equals(sortValue)){
                Sort sort = new Sort(Sort.Direction.ASC, "item_" + sortField);
                query.addSort(sort);
            }
            if("DESC".equals(sortValue)){
                Sort sort = new Sort(Sort.Direction.DESC, "item_" + sortField);
                query.addSort(sort);
            }
        }

        /*        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(query, TbItem.class);*/

        ////////////////高亮结果集\\\\\\\\\\\\\\\
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);

        List<HighlightEntry<TbItem>> entryList = page.getHighlighted(); // 高亮入口集合
        for (HighlightEntry<TbItem> entry : entryList) {
            // 高亮元素列表
            List<HighlightEntry.Highlight> highlightList = entry.getHighlights();
            if(highlightList.size()>0 && highlightList.get(0).getSnipplets().get(0).length()>0) {
                TbItem item = entry.getEntity();
                item.setTitle(highlightList.get(0).getSnipplets().get(0));
            }
        }

        map.put("rows", page.getContent());
        map.put("totalPages", page.getTotalPages()); // 总页数
        map.put("total", page.getTotalElements()); // 总记录数
        return map;
    }

    /**
     * 分组查询(查询商品分类列表)
     * @param searchMap
     * @return
     */
    private List searchCategoryList(Map searchMap){
        List<String> list = new ArrayList();
        Query query = new SimpleQuery("*:*");
        // 相当于where 根据关键字查询
        Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        // 相当于GroupBy 设置分组选项
        GroupOptions groupOptions = new GroupOptions().addGroupByField("item_category");
        query.setGroupOptions(groupOptions);
        // 获得分组页
        GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);
        // 获得分组结果对象
        GroupResult<TbItem> category = page.getGroupResult("item_category");
        // 获取分组入口页 具体分组数据
        Page<GroupEntry<TbItem>> groupEntries = category.getGroupEntries();
        // 获取分组入口集合
        List<GroupEntry<TbItem>> content = groupEntries.getContent();
        for (GroupEntry<TbItem> entry : content) {
            list.add(entry.getGroupValue()); // 要获得的字符串
        }
        return list;
    }

    /**
     * 从缓存中获取品牌列表和规格选项 根据分类的名称
     * @param category
     * @return
     */
    private Map searchBrandAndSpecList(String category){
        Map map = new HashMap();

        // 获取分类的id
        Long templateId = (Long) redisTemplate.boundHashOps("itemCat").get(category);

        if(templateId != null){
            // 根据分类的id获取品牌列表
            List brandList = (List) redisTemplate.boundHashOps("brandList").get(templateId);
            map.put("brandList", brandList);
            // 根据分类的id获取规格选项
            List specList = (List) redisTemplate.boundHashOps("specList").get(templateId);
            map.put("specList", specList);
        }

        return map;
    }
}
