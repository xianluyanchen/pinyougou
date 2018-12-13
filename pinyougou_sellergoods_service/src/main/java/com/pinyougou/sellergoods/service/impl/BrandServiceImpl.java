package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.ResultInformation;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	/**
	 * 删除选中的品牌
	 */

	@Override
	public void delete(long[] ids) {

		for (long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}

	}

	/**
	 * 根据id查询品牌信息
	 */
	@Override
	public TbBrand findById(long id) {
		TbBrand selectByPrimaryKey = brandMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	/**
	 * 品牌修改/品牌信息维护
	 */
	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	/**
	 * 品牌增加功能
	 */
	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

	/**
	 * 查询所有
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

		PageHelper.startPage(currentPage, pageSize);
		Page<TbBrand> list = (Page<TbBrand>) brandMapper.selectByExample(null);

		PageResult pageResult = new PageResult();

		// 将pageHelper的总记录数封装至pageResult
		pageResult.setTotal(list.getTotal());
		// 将结果集封装至rows
		pageResult.setRows(list.getResult());

		return pageResult;
	}

	@Override
	public PageResult findByPage(TbBrand brand, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		TbBrandExample tbBrandExample = new TbBrandExample();
		Criteria createCriteria = tbBrandExample.createCriteria();
		if(brand != null) {
			if (brand.getName() != null && brand.getName().length() > 0) {
				createCriteria.andNameLike("%" + brand.getName() + "%");
			}
			if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
				createCriteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		
		Page<TbBrand> selectByExample = (Page<TbBrand>) brandMapper.selectByExample(tbBrandExample);

		PageResult pageResult = new PageResult();
		pageResult.setRows(selectByExample.getResult());
		pageResult.setTotal(selectByExample.getTotal());

		return pageResult;
	}

}
