package com.shiguang.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.domain.MfrsDO;
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

import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.TechnologyService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 工艺类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:58:57
 */
 
@Controller
@RequestMapping("/product/technology")
public class TechnologyController {
	@Autowired
	private TechnologyService technologyService;
	
	@GetMapping()
	@RequiresPermissions("product:technology:technology")
	String Technology(){
	    return "product/technology/technology";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:technology:technology")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TechnologyDO> technologyList = technologyService.list(query);
		int total = technologyService.count(query);
		PageUtils pageUtils = new PageUtils(technologyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:technology:add")
	String add(){
	    return "product/technology/add";
	}

	@GetMapping("/edit/{technologyId}")
	@RequiresPermissions("product:technology:edit")
	String edit(@PathVariable("technologyId") Long technologyId,Model model){
		TechnologyDO technology = technologyService.get(technologyId);
		model.addAttribute("technology", technology);
	    return "product/technology/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:technology:add")
	public R save( TechnologyDO technology){

		//判断是否已存在
		String technologyNum = technology.getTechnologyNum();
		Map<String, Object> map = new HashMap<>();
		map.put("technologyNum",technologyNum);
		List<TechnologyDO> list = technologyService.list(map);
		if (list.size() > 0){
			return R.error("编码已存在");
		}

		if(technologyService.save(technology)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:technology:edit")
	public R update( TechnologyDO technology){
		technologyService.update(technology);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:technology:remove")
	public R remove( Long technologyId){
		if(technologyService.remove(technologyId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:technology:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] technologyIds){
		technologyService.batchRemove(technologyIds);
		return R.ok();
	}
	
}
