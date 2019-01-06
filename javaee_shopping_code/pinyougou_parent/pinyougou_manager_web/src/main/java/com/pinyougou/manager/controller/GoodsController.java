package com.pinyougou.manager.controller;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
//import com.pinyougou.page.service.ItemPageService;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojogroup.Goods;
//import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.sellergoods.service.GoodsService;

import entity.PageResult;
import entity.Result;
import sun.rmi.runtime.Log;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;

//	@Reference(timeout = 100000)
//	private ItemSearchService itemSearchService;

//	@Reference(timeout = 5000)
//	private ItemPageService itemPageService;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired // 导入索引库 点对点
	private Destination queueSolrDestination;

    @Autowired // 删除索引库 点对点
    private Destination queueSolrDeleteDestination;

    @Autowired // 生成页面 发布订阅
    private Destination topicPageDestination;

    @Autowired // 删除页面 发布订阅
    private Destination topicPageDeleteDestination;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Goods goods){
		try {
			goodsService.add(goods);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Goods goods){
		try {
			goodsService.update(goods);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbGoods findOne(Long id){
		Goods goods = goodsService.findOne(id);
		return goods.getTbGoods();
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(final Long [] ids){
		try {
			goodsService.delete(ids);

			// 从索引库中删除
//            itemSearchService.deleteByGoodsIds(Arrays.asList(ids));
			jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return null;
				}
			});

            // 删除每个服务器上的商品详细页
            jmsTemplate.send(topicPageDeleteDestination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(ids);
                }
            });

			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}

	@RequestMapping("/updateStatus")
	public Result updateStatus(Long[] ids, String status){
        try {
            goodsService.updateStatus(ids, status);

            if("1".equals(status)){
                // 得到需要导入的SKU列表
                List<TbItem> list = goodsService.findItemListByGoodsIdListAndStatus(ids, status);

                // 导入到solr
                if(list!= null && list.size()>0){
//                    itemSearchService.importList(list);
                    final String jsonString = JSON.toJSONString(list);
                    jmsTemplate.send(queueSolrDestination, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            return session.createTextMessage(jsonString);
                        }
                    });
                }

                // 生成静态页面
				for (final Long goodsId : ids) {
//					itemPageService.genItemHtml(goodsId);
                    jmsTemplate.send(topicPageDestination, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            return session.createTextMessage(goodsId+"");
                        }
                    });
				}

			}

            return new Result(true, "修改状态成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改状态失败");
        }
    }

/*    @RequestMapping("/genHtml")
    public void genHtml(Long goodsId){
		itemPageService.genItemHtml(goodsId);
	}*/
	
}
