package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lzqiang
 */
@Api("栏目相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@ApiOperation(value = "查询所有")
	@GetMapping("findAll")
	public Message findAll() {
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "通过id删除")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

	@ApiOperation(value = "批量删除")
	@PostMapping(value = "batchDelete")
	public Message batchDelete(@RequestBody long[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("删除成功");
	}

	@ApiOperation(value = "保存或更新",notes = "保存的时候无需传递id，如果传递id，后台认为你要完成更新操作，将后台数据更新为你传递的数据")
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Category category){
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	}
	
}
