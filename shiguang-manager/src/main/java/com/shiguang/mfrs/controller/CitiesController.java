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

import com.shiguang.mfrs.domain.CitiesDO;
import com.shiguang.mfrs.service.CitiesService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 行政区域地州市信息表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-20 17:25:32
 */
 
@Controller
@RequestMapping("/mfrs/cities")
public class CitiesController {
	@Autowired
	private CitiesService citiesService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:cities:cities")
	String Cities(){
	    return "mfrs/cities/cities";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:cities:cities")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CitiesDO> citiesList = citiesService.list(query);
		int total = citiesService.count(query);
		PageUtils pageUtils = new PageUtils(citiesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:cities:add")
	String add(){
	    return "mfrs/cities/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:cities:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CitiesDO cities = citiesService.get(id);
		model.addAttribute("cities", cities);
	    return "mfrs/cities/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:cities:add")
	public R save( CitiesDO cities){
		if(citiesService.save(cities)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:cities:edit")
	public R update( CitiesDO cities){
		citiesService.update(cities);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:cities:remove")
	public R remove( Integer id){
		if(citiesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:cities:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		citiesService.batchRemove(ids);
		return R.ok();
	}
	
}
