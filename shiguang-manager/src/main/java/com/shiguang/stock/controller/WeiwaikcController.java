package com.shiguang.stock.controller;

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

import com.shiguang.stock.domain.WeiwaikcDO;
import com.shiguang.stock.service.WeiwaikcService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-30 01:34:01
 */
 
@Controller
@RequestMapping("/stock/weiwaikc")
public class WeiwaikcController {
	@Autowired
	private WeiwaikcService weiwaikcService;
	
	@GetMapping()
	@RequiresPermissions("stock:weiwaikc:weiwaikc")
	String Weiwaikc(){
	    return "stock/weiwaikc/weiwaikc";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwaikc:weiwaikc")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WeiwaikcDO> weiwaikcList = weiwaikcService.list(query);
		int total = weiwaikcService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaikcList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwaikc:add")
	String add(){
	    return "stock/weiwaikc/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:weiwaikc:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WeiwaikcDO weiwaikc = weiwaikcService.get(id);
		model.addAttribute("weiwaikc", weiwaikc);
	    return "stock/weiwaikc/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:weiwaikc:add")
	public R save( WeiwaikcDO weiwaikc){
		if(weiwaikcService.save(weiwaikc)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwaikc:edit")
	public R update( WeiwaikcDO weiwaikc){
		weiwaikcService.update(weiwaikc);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaikc:remove")
	public R remove( Long id){
		if(weiwaikcService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaikc:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		weiwaikcService.batchRemove(ids);
		return R.ok();
	}
	
}
