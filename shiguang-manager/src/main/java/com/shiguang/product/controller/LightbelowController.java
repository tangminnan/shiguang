package com.shiguang.product.controller;

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

import com.shiguang.product.domain.LightbelowDO;
import com.shiguang.product.service.LightbelowService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 下加光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
 
@Controller
@RequestMapping("/product/lightbelow")
public class LightbelowController {
	@Autowired
	private LightbelowService lightbelowService;
	
	@GetMapping()
	@RequiresPermissions("product:lightbelow:lightbelow")
	String Lightbelow(){
	    return "product/lightbelow/lightbelow";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:lightbelow:lightbelow")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LightbelowDO> lightbelowList = lightbelowService.list(query);
		int total = lightbelowService.count(query);
		PageUtils pageUtils = new PageUtils(lightbelowList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:lightbelow:add")
	String add(){
	    return "product/lightbelow/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:lightbelow:edit")
	String edit(@PathVariable("id") Long id,Model model){
		LightbelowDO lightbelow = lightbelowService.get(id);
		model.addAttribute("lightbelow", lightbelow);
	    return "product/lightbelow/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:lightbelow:add")
	public R save( LightbelowDO lightbelow){
		if(lightbelowService.save(lightbelow)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:lightbelow:edit")
	public R update( LightbelowDO lightbelow){
		lightbelowService.update(lightbelow);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:lightbelow:remove")
	public R remove( Long id){
		if(lightbelowService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:lightbelow:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		lightbelowService.batchRemove(ids);
		return R.ok();
	}
	
}
