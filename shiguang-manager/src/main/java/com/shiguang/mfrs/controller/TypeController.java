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

import com.shiguang.mfrs.domain.TypeDO;
import com.shiguang.mfrs.service.TypeService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 抛弃型分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
 
@Controller
@RequestMapping("/mfrs/type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:type:type")
	String Type(){
	    return "mfrs/type/type";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:type:type")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TypeDO> typeList = typeService.list(query);
		int total = typeService.count(query);
		PageUtils pageUtils = new PageUtils(typeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:type:add")
	String add(){
	    return "mfrs/type/add";
	}

	@GetMapping("/edit/{typeId}")
	@RequiresPermissions("mfrs:type:edit")
	String edit(@PathVariable("typeId") Integer typeId,Model model){
		TypeDO type = typeService.get(typeId);
		model.addAttribute("type", type);
	    return "mfrs/type/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:type:add")
	public R save( TypeDO type){
		if(typeService.save(type)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:type:edit")
	public R update( TypeDO type){
		typeService.update(type);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:type:remove")
	public R remove( Integer typeId){
		if(typeService.remove(typeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:type:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] typeIds){
		typeService.batchRemove(typeIds);
		return R.ok();
	}
	
}
