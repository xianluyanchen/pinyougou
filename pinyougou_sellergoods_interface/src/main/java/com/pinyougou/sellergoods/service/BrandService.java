package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌服务层接口
 * @author 98137
 *
 */
public interface BrandService {

	/**
	 * chaxun查询所有品牌
	 * @return
	 */
	 public List<TbBrand> findAll(); 
	 
	 /**
	  * 进行分页查询功能
	  * @param currentPage 当前页码
	  * @param pageSize	每页的条数
	  * @return
	  */
	 public PageResult findByPage(int currentPage,int pageSize);

	 /**
	  * 实现增加功能
	  */
	 public void add(TbBrand brand);
	
}
