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

import com.shiguang.mfrs.domain.GradualDO;
import com.shiguang.mfrs.service.GradualService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 渐进片分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
 
@Controller
@RequestMapping("/mfrs/gradual")
public class GradualController {
	@Autowired
	private GradualService gradualService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:gradual:gradual")
	String Gradual(){
	    return "mfrs/gradual/gradual";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:gradual:gradual")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GradualDO> gradualList = gradualService.list(query);
		int total = gradualService.count(query);
		PageUtils pageUtils = new PageUtils(gradualList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:gradual:add")
	String add(){
	    return "mfrs/gradual/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:gradual:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GradualDO gradual = gradualService.get(id);
		model.addAttribute("gradual", gradual);
	    return "mfrs/gradual/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:gradual:add")
	public R save( GradualDO gradual){
		if(gradualService.save(gradual)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:gradual:edit")
	public R update( GradualDO gradual){
		gradualService.update(gradual);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:gradual:remove")
	public R remove( Integer id){
		if(gradualService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:gradual:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		gradualService.batchRemove(ids);
		return R.ok();
	}
	
}
