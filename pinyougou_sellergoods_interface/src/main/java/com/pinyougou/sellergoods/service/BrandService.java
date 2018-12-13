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
	 
	 public PageResult findByPage(int currentPage,int pageSize);

	
}
