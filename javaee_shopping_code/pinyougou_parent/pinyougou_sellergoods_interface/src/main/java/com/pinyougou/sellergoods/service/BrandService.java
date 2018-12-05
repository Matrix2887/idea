package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 *
 */
public interface BrandService {

	// 查询所有品牌
	abstract List<TbBrand> findAll();

	/**
	 * 品牌分页
	 * @param pageNum 当前页面
	 * @param pageSize 每页记录数
	 * @return
	 */
	abstract PageResult findPage(int pageNum, int pageSize);

    /**
     * 添加品牌
     * @param brand 品牌实体类对象
     */
	abstract void add(TbBrand brand);

    /**
     * 根据id查询
     * @param id 要查询对象的id
     * @return 返回查询的对象
     */
	abstract TbBrand findOne(Long id);

    /**
     * 根据id更新数据
     * @param brand 要更新的对象
     */
	abstract void update(TbBrand brand);

    /**
     * 根据id数组删除
     * @param ids 要删除对象的id数组
     */
    abstract void delete(Long[] ids);

	/**
	 * 根据条件查询
	 * @param brand 要查询的模糊对象
	 * @param pageNum 当前页
	 * @param pageSize 每页的记录
	 * @return
	 */
    abstract PageResult findPage(TbBrand brand, int pageNum, int pageSize);

	/**
	 * 返回下拉列表数据
	 * @return
	 */
	abstract List<Map> selectOptionList();

}
