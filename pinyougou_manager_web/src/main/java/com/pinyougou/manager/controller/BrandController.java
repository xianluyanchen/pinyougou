package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.ResultInformation;

@Controller
@ResponseBody
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/add")
	public ResultInformation add(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new ResultInformation(true,"新增成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResultInformation(false,"新增失败");
		}
	}
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(int currentPage,int pageSize) {
		
		PageResult pageResult = brandService.findByPage(currentPage, pageSize);
		return pageResult;
	}
}
