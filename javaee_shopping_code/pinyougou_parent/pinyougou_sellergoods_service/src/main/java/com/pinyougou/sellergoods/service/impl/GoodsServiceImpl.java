package com.pinyougou.sellergoods.service.impl;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;
import com.pinyougou.pojogroup.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbGoodsExample.Criteria;
import com.pinyougou.sellergoods.service.GoodsService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;

	@Autowired
	private TbGoodsDescMapper goodsDescMapper;

	@Autowired
	private TbItemMapper tbItemMapper;

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Autowired
	private TbSellerMapper tbSellerMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbGoods> page=   (Page<TbGoods>) goodsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}


	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		TbGoods tbGoods = goods.getTbGoods(); // 获取商品基本信息
		tbGoods.setAuditStatus("0"); // 设置商品状态
		TbGoodsDesc tbGoodsDesc = goods.getTbGoodsDesc(); // 获取商品扩展信息
		goodsMapper.insert(tbGoods); // 把商品基本信息存入表中
		tbGoodsDesc.setGoodsId(tbGoods.getId()); // 因为在配置文件中设置会返回id 所以设置扩展表的id
		goodsDescMapper.insert(tbGoodsDesc); // 把扩展表存入数据库中


    }


	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods){
	    goodsMapper.updateByPrimaryKey(goods.getTbGoods());
	    goodsDescMapper.updateByPrimaryKey(goods.getTbGoodsDesc());

	    // 删除原有的SKU商品
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getTbGoods().getId());
        tbItemMapper.deleteByExample(example);
        saveItemList(goods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Long id){
		Goods goods = new Goods();
		TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
		goods.setTbGoods(tbGoods);
		TbGoodsDesc tbGoodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		goods.setTbGoodsDesc(tbGoodsDesc);
		// 读取SKU列表

		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> tbItemList = tbItemMapper.selectByExample(example);
		goods.setItemList(tbItemList);

		return goods;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			tbGoods.setIsDelete("1"); // 逻辑删除
			goodsMapper.updateByPrimaryKey(tbGoods);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGoodsExample example=new TbGoodsExample();
		Criteria criteria = example.createCriteria();

		criteria.andIsDeleteIsNull();// 指定条件为未逻辑删除
		
		if(goods!=null){			
						if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
				criteria.andSellerIdEqualTo(goods.getSellerId());
			}
			if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
			if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
				criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
			}
			if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
				criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
			}
			if(goods.getCaption()!=null && goods.getCaption().length()>0){
				criteria.andCaptionLike("%"+goods.getCaption()+"%");
			}
			if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
				criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
			}
			if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
				criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
			}
			if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
				criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
			}
	
		}
		
		Page<TbGoods> page= (Page<TbGoods>)goodsMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

    /**
     *
     * @param ids
     * @param status
     */
    @Override
    public void updateStatus(Long[] ids, String status) {
        for (Long id : ids) {
            TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
            tbGoods.setAuditStatus(status);
            goodsMapper.updateByPrimaryKey(tbGoods);
        }
    }

    /**
     *
     * @param goodsId 审核的商品ID集合
     * @param status 审核的状态
     * @return
     */
    @Override
    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsId, String status) {
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        // 条件符合传递的条件
        criteria.andStatusEqualTo(status);
        // 商品ID要在集合里
        criteria.andGoodsIdIn(Arrays.asList(goodsId));
        tbItemMapper.selectByExample(example);
        // 返回符合条件的商品ID
        return tbItemMapper.selectByExample(example);
    }

    // 存储SKU
    private void saveItemList(Goods goods){
        if("1".equals(goods.getTbGoods().getIsEnableSpec())){
            List<TbItem> itemList = goods.getItemList();
            for (TbItem tbItem : itemList) {
                // 构建标题
                String title = goods.getTbGoods().getGoodsName(); // SPU名称
                Map<String, Object> map = JSON.parseObject(tbItem.getSpec(), Map.class); // 属性
                Set<String> keySet = map.keySet();
                for (String s : keySet) {
                    Object o = map.get(s);
                    title += " " + o;
                }
                tbItem.setTitle(title);
                setItemValues(tbItem, goods);
                tbItemMapper.insert(tbItem);
            }

        }else { // 没有启用规格
            TbItem tbItem = new TbItem();
            tbItem.setTitle(goods.getTbGoods().getGoodsName());// 标题
            tbItem.setPrice(goods.getTbGoods().getPrice());// 价格
            tbItem.setNum(99999);// 库存数量
            tbItem.setStatus("1");
            tbItem.setIsDefault("1");
            setItemValues(tbItem, goods);
            tbItem.setSpec("{}");// 规格
            tbItemMapper.insert(tbItem);
        }
    }

    private void setItemValues(TbItem tbItem, Goods goods){

        // 商品分类
        tbItem.setCategoryid(goods.getTbGoods().getCategory3Id()); // 三级分类
        tbItem.setCreateTime(new Date()); // 创建日期
        tbItem.setUpdateTime(new Date());// 修改日期

        tbItem.setGoodsId(goods.getTbGoods().getId()); // 商品Id
        tbItem.setSellerId(goods.getTbGoods().getSellerId()); // 商家Id

        // 商品分类
        TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(goods.getTbGoods().getCategory3Id());
        tbItem.setCategory(tbItemCat.getName());
        // 品牌名称
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(goods.getTbGoods().getBrandId());
        tbItem.setBrand(tbBrand.getName());
        // 店铺名称
        TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(goods.getTbGoods().getSellerId());
        tbItem.setSeller(tbSeller.getNickName());
        // 图片名称
        List<Map> imageList = JSON.parseArray(goods.getTbGoodsDesc().getItemImages(), Map.class);
        if(imageList.size() > 0){
            tbItem.setImage((String) imageList.get(0).get("url"));
        }

    }



}
