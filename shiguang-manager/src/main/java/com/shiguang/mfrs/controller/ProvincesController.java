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

import com.shiguang.mfrs.domain.ProvincesDO;
import com.shiguang.mfrs.service.ProvincesService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 省份信息表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-15 17:18:59
 */
 
@Controller
@RequestMapping("/mfrs/provinces")
public class ProvincesController {
	@Autowired
	private ProvincesService provincesService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:provinces:provinces")
	String Provinces(){
	    return "mfrs/provinces/provinces";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:provinces:provinces")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProvincesDO> provincesList = provincesService.list(query);
		int total = provincesService.count(query);
		PageUtils pageUtils = new PageUtils(provincesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:provinces:add")
	String add(){
	    return "mfrs/provinces/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:provinces:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProvincesDO provinces = provincesService.get(id);
		model.addAttribute("provinces", provinces);
	    return "mfrs/provinces/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:provinces:add")
	public R save( ProvincesDO provinces){
		if(provincesService.save(provinces)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:provinces:edit")
	public R update( ProvincesDO provinces){
		provincesService.update(provinces);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:provinces:remove")
	public R remove( Integer id){
		if(provincesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:provinces:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		provincesService.batchRemove(ids);
		return R.ok();
	}
	
}
