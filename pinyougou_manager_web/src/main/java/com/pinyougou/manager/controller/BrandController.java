package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@Controller
@ResponseBody
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,@RequestParam(name="currentPage")int currentPage,@RequestParam(name="pageSize")int pageSize) {
		PageResult findByPage = brandService.findByPage(tbBrand, currentPage, pageSize);
		
		return findByPage;
	}
	
	@RequestMapping("/delete")
	public Result delete(long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false,"删除失败");
		}
	}
	
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new Result(true,"新增成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false,"新增失败");
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
	
	@RequestMapping("/findById")
	public TbBrand findById(long id) {
		TbBrand findById = brandService.findById(id);
		return findById;
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false,"修改失败");
		}
	}
	
	/**
	 * 查询模板的中的品牌下拉框
	 * @return
	 */
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		List<Map> selectOptionList = brandService.selectOptionList();
		return selectOptionList;
	}
}
