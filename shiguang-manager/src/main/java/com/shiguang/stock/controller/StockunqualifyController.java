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

import com.shiguang.stock.domain.StockunqualifyDO;
import com.shiguang.stock.service.StockunqualifyService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 不合格仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
 
@Controller
@RequestMapping("/stock/stockunqualify")
public class StockunqualifyController {
	@Autowired
	private StockunqualifyService stockunqualifyService;
	
	@GetMapping()
	@RequiresPermissions("stock:stockunqualify:stockunqualify")
	String Stockunqualify(){
	    return "stock/stockunqualify/stockunqualify";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:stockunqualify:stockunqualify")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StockunqualifyDO> stockunqualifyList = stockunqualifyService.list(query);
		int total = stockunqualifyService.count(query);
		PageUtils pageUtils = new PageUtils(stockunqualifyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:stockunqualify:add")
	String add(){
	    return "stock/stockunqualify/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:stockunqualify:edit")
	String edit(@PathVariable("id") Long id,Model model){
		StockunqualifyDO stockunqualify = stockunqualifyService.get(id);
		model.addAttribute("stockunqualify", stockunqualify);
	    return "stock/stockunqualify/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:stockunqualify:add")
	public R save( StockunqualifyDO stockunqualify){
		if(stockunqualifyService.save(stockunqualify)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:stockunqualify:edit")
	public R update( StockunqualifyDO stockunqualify){
		stockunqualifyService.update(stockunqualify);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:stockunqualify:remove")
	public R remove( Long id){
		if(stockunqualifyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:stockunqualify:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		stockunqualifyService.batchRemove(ids);
		return R.ok();
	}
	
}
