package com.shiguang.mfrs.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.mfrs.domain.FunctionDO;
import com.shiguang.mfrs.service.FunctionService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 镜片功能表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
 
@Controller
@RequestMapping("/mfrs/function")
public class FunctionController {
	@Autowired
	private FunctionService functionService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:function:function")
	String Function(){
	    return "mfrs/function/function";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:function:function")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FunctionDO> functionList = functionService.list(query);
		int total = functionService.count(query);
		PageUtils pageUtils = new PageUtils(functionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:function:add")
	String add(){
	    return "mfrs/function/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:function:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		FunctionDO function = functionService.get(id);
		model.addAttribute("function", function);
	    return "mfrs/function/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:function:add")
	public R save( FunctionDO function){
		if(functionService.save(function)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:function:edit")
	public R update( FunctionDO function){
		functionService.update(function);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:function:remove")
	public R remove( Integer id){
		if(functionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:function:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		functionService.batchRemove(ids);
		return R.ok();
	}
	
}
