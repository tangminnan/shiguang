package com.shiguang.unqualiffed.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import com.shiguang.unqualiffed.service.UnqualiffedService;
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


/**
 * 不合格表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
 
@Controller
@RequestMapping("/information/unqualiffed")
public class UnqualiffedController {
	@Autowired
	private UnqualiffedService unqualiffedService;
	
	@GetMapping()
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	String Unqualiffed(){
	    return "information/unqualiffed/unqualiffed";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UnqualiffedDO> unqualiffedList = unqualiffedService.list(query);
		int total = unqualiffedService.count(query);
		PageUtils pageUtils = new PageUtils(unqualiffedList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:unqualiffed:add")
	String add(){
	    return "information/unqualiffed/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:unqualiffed:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UnqualiffedDO unqualiffed = unqualiffedService.get(id);
		model.addAttribute("unqualiffed", unqualiffed);
	    return "information/unqualiffed/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:unqualiffed:add")
	public R save(UnqualiffedDO unqualiffed){
		if(unqualiffedService.save(unqualiffed)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:unqualiffed:edit")
	public R update( UnqualiffedDO unqualiffed){
		unqualiffedService.update(unqualiffed);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:remove")
	public R remove( Long id){
		if(unqualiffedService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		unqualiffedService.batchRemove(ids);
		return R.ok();
	}
	
}
