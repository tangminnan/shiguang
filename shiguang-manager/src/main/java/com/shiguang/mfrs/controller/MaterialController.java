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

import com.shiguang.mfrs.domain.MaterialDO;
import com.shiguang.mfrs.service.MaterialService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 镜架材质表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 15:41:15
 */
 
@Controller
@RequestMapping("/mfrs/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:material:material")
	String Material(){
	    return "mfrs/material/material";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:material:material")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MaterialDO> materialList = materialService.list(query);
		int total = materialService.count(query);
		PageUtils pageUtils = new PageUtils(materialList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:material:add")
	String add(){
	    return "mfrs/material/add";
	}

	@GetMapping("/edit/{materialid}")
	@RequiresPermissions("mfrs:material:edit")
	String edit(@PathVariable("materialid") Integer materialid,Model model){
		MaterialDO material = materialService.get(materialid);
		model.addAttribute("material", material);
	    return "mfrs/material/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:material:add")
	public R save( MaterialDO material){
		if(materialService.save(material)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:material:edit")
	public R update( MaterialDO material){
		materialService.update(material);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:material:remove")
	public R remove( Integer materialid){
		if(materialService.remove(materialid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:material:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] materialids){
		materialService.batchRemove(materialids);
		return R.ok();
	}
	
}
