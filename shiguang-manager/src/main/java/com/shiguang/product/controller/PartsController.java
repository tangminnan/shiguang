package com.shiguang.product.controller;

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

import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.service.PartsService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 配件表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
 
@Controller
@RequestMapping("/product/parts")
public class PartsController {
	@Autowired
	private PartsService partsService;
	
	@GetMapping()
	@RequiresPermissions("product:parts:parts")
	String Parts(){
	    return "product/parts/parts";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:parts:parts")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PartsDO> partsList = partsService.list(query);
		int total = partsService.count(query);
		PageUtils pageUtils = new PageUtils(partsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:parts:add")
	String add(){
	    return "product/parts/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:parts:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PartsDO parts = partsService.get(id);
		model.addAttribute("parts", parts);
	    return "product/parts/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:parts:add")
	public R save( PartsDO parts){
		if(partsService.save(parts)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:parts:edit")
	public R update( PartsDO parts){
		partsService.update(parts);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:parts:remove")
	public R remove( Long id){
		if(partsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:parts:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		partsService.batchRemove(ids);
		return R.ok();
	}
	
}
