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

import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 计量单位表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 15:13:48
 */
 
@Controller
@RequestMapping("/mfrs/unit")
public class UnitController {
	@Autowired
	private UnitService unitService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:unit:unit")
	String Unit(){
	    return "mfrs/unit/unit";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:unit:unit")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UnitDO> unitList = unitService.list(query);
		int total = unitService.count(query);
		PageUtils pageUtils = new PageUtils(unitList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:unit:add")
	String add(){
	    return "mfrs/unit/add";
	}

	@GetMapping("/edit/{unitid}")
	@RequiresPermissions("mfrs:unit:edit")
	String edit(@PathVariable("unitid") Integer unitid,Model model){
		UnitDO unit = unitService.get(unitid);
		model.addAttribute("unit", unit);
	    return "mfrs/unit/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:unit:add")
	public R save( UnitDO unit){
		if(unitService.save(unit)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:unit:edit")
	public R update( UnitDO unit){
		unitService.update(unit);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:unit:remove")
	public R remove( Integer unitid){
		if(unitService.remove(unitid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:unit:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] unitids){
		unitService.batchRemove(unitids);
		return R.ok();
	}
	
}
