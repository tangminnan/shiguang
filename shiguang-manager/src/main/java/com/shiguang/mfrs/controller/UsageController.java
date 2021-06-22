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

import com.shiguang.mfrs.domain.UsageDO;
import com.shiguang.mfrs.service.UsageService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 使用类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
 
@Controller
@RequestMapping("/mfrs/usage")
public class UsageController {
	@Autowired
	private UsageService usageService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:usage:usage")
	String Usage(){
	    return "mfrs/usage/usage";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:usage:usage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UsageDO> usageList = usageService.list(query);
		int total = usageService.count(query);
		PageUtils pageUtils = new PageUtils(usageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:usage:add")
	String add(){
	    return "mfrs/usage/add";
	}

	@GetMapping("/edit/{usageId}")
	@RequiresPermissions("mfrs:usage:edit")
	String edit(@PathVariable("usageId") Integer usageId,Model model){
		UsageDO usage = usageService.get(usageId);
		model.addAttribute("usage", usage);
	    return "mfrs/usage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:usage:add")
	public R save( UsageDO usage){
		if(usageService.save(usage)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:usage:edit")
	public R update( UsageDO usage){
		usageService.update(usage);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:usage:remove")
	public R remove( Integer usageId){
		if(usageService.remove(usageId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:usage:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] usageIds){
		usageService.batchRemove(usageIds);
		return R.ok();
	}
	
}
