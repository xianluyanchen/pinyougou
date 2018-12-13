package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.ResultInformation;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private TbBrandMapper brandMapper;

	
/**
 * 品牌增加功能
 */
	@Override
	public void add(TbBrand brand) {
		ResultInformation resultInformation = new ResultInformation();
			brandMapper.insert(brand);
	}

	/**
	 * cha查询所有
	 */
	@Override
	public List<TbBrand> findAll() {
		
		
		List<TbBrand> list = brandMapper.selectByExample(null);
		return list;
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageResult findByPage(int currentPage, int pageSize) {
		
		PageHelper.startPage(currentPage,pageSize);
		 Page<TbBrand> list = (Page<TbBrand>) brandMapper.selectByExample(null);
		 
		 PageResult pageResult = new PageResult();
		 
		 //将pageHelper的总记录数封装至pageResult
		 pageResult.setTotal(list.getTotal());
		 //将结果集封装至rows
		 pageResult.setRows(list.getResult());
		
		return pageResult;
	}

}
