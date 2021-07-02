package com.shiguang.baseinfomation.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
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
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-30 16:55:50
 */
 
@Controller
@RequestMapping("/information/additional")
public class AdditionalController {
	@Autowired
	private AdditionalService additionalService;
	
	@GetMapping()
	@RequiresPermissions("information:additional:additional")
	String Additional(){
	    return "baseinfomation/additional/additional";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:additional:additional")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdditionalDO> additionalList = additionalService.list(query);
		int total = additionalService.count(query);
		PageUtils pageUtils = new PageUtils(additionalList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:additional:add")
	String add(){
	    return "baseinfomation/additional/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:additional:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AdditionalDO additional = additionalService.get(id);
		model.addAttribute("additional", additional);
	    return "baseinfomation/additional/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:additional:add")
	public R save(AdditionalDO additional){
		if(additionalService.save(additional)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:additional:edit")
	public R update( AdditionalDO additional){
		additionalService.update(additional);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:additional:remove")
	public R remove( Long id){
		if(additionalService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:additional:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		additionalService.batchRemove(ids);
		return R.ok();
	}
	
}
