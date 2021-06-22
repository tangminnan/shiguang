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

import com.shiguang.mfrs.domain.LightDO;
import com.shiguang.mfrs.service.LightService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 光度分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
 
@Controller
@RequestMapping("/mfrs/light")
public class LightController {
	@Autowired
	private LightService lightService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:light:light")
	String Light(){
	    return "mfrs/light/light";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:light:light")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LightDO> lightList = lightService.list(query);
		int total = lightService.count(query);
		PageUtils pageUtils = new PageUtils(lightList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:light:add")
	String add(){
	    return "mfrs/light/add";
	}

	@GetMapping("/edit/{lightId}")
	@RequiresPermissions("mfrs:light:edit")
	String edit(@PathVariable("lightId") Integer lightId,Model model){
		LightDO light = lightService.get(lightId);
		model.addAttribute("light", light);
	    return "mfrs/light/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:light:add")
	public R save( LightDO light){
		if(lightService.save(light)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:light:edit")
	public R update( LightDO light){
		lightService.update(light);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:light:remove")
	public R remove( Integer lightId){
		if(lightService.remove(lightId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:light:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] lightIds){
		lightService.batchRemove(lightIds);
		return R.ok();
	}
	
}
