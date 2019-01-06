package com.pinyougou.content.service.impl;
import java.util.List;

import com.pinyougou.coutent.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbContentMapper;
import com.pinyougou.pojo.TbContent;
import com.pinyougou.pojo.TbContentExample;
import com.pinyougou.pojo.TbContentExample.Criteria;

import entity.PageResult;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbContent> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbContent> page=   (Page<TbContent>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbContent content) {
		redisTemplate.boundHashOps("content").delete(content.getCategoryId()); // 清除缓存

		contentMapper.insert(content);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbContent newContent){
		Long oldCategoryId = contentMapper.selectByPrimaryKey(newContent.getId()).getCategoryId();
		redisTemplate.boundHashOps("content").delete(oldCategoryId); // 清除原分组的缓存
		if(oldCategoryId.longValue() != newContent.getCategoryId().longValue()){
		redisTemplate.boundHashOps("content").delete(newContent.getCategoryId()); // 清除现分组的缓存
		}
		contentMapper.updateByPrimaryKey(newContent);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbContent findOne(Long id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			// 清除缓存
			Long categoryId = contentMapper.selectByPrimaryKey(id).getCategoryId();
			redisTemplate.boundHashOps("content").delete(categoryId);
			contentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(TbContent content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		
		if(content!=null){			
						if(content.getTitle()!=null && content.getTitle().length()>0){
				criteria.andTitleLike("%"+content.getTitle()+"%");
			}
			if(content.getUrl()!=null && content.getUrl().length()>0){
				criteria.andUrlLike("%"+content.getUrl()+"%");
			}
			if(content.getPic()!=null && content.getPic().length()>0){
				criteria.andPicLike("%"+content.getPic()+"%");
			}
			if(content.getStatus()!=null && content.getStatus().length()>0){
				criteria.andStatusLike("%"+content.getStatus()+"%");
			}
	
		}
		
		Page<TbContent> page= (Page<TbContent>)contentMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 *
	 * @param categoryId
	 * @return
	 */
	@Override
	public List<TbContent> findByCategoryId(Long categoryId) {
		List<TbContent> content = (List<TbContent>) redisTemplate.boundHashOps("content").get(categoryId);
		if(content == null){
			System.out.println("查询数据库");
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			criteria.andCategoryIdEqualTo(categoryId); // 指定条件 分类ID
			criteria.andStatusEqualTo("1"); // 指定条件 有效
			example.setOrderByClause("sort_order"); // 排序

			content = contentMapper.selectByExample(example);
			redisTemplate.boundHashOps("content").put(categoryId, content); // 放入缓存
		}else{
			System.out.println("查询内存");
		}

        return content;
	}

}
