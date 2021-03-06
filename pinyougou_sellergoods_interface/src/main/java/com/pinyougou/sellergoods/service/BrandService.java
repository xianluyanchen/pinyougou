package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌服务层接口
 * @author 98137
 *
 */
public interface BrandService {
	
	public PageResult findByPage(TbBrand brand,int currentPage,int pageSize) ;
	
	/**
	 * 删除选中的品牌
	 * @param ids
	 */
	public void delete(long[] ids);
	
	

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
	 
	 /**
	  * 品牌修改
	  * @param brand
	  */
	 public void update(TbBrand brand);
	
	 /**
	  * 根据id查询单个brand
	  *  @param id
	  * @return
	  */
	 public TbBrand findById(long id);
	 
	 /**
	  * 类型模板中，查询商品列表
	  * @return
	  */
	 public List<Map> selectOptionList();
}
