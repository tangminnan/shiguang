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

import com.shiguang.stock.domain.StockqualifyDO;
import com.shiguang.stock.service.StockqualifyService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 合格仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
 
@Controller
@RequestMapping("/stock/stockqualify")
public class StockqualifyController {
	@Autowired
	private StockqualifyService stockqualifyService;
	
	@GetMapping()
	@RequiresPermissions("stock:stockqualify:stockqualify")
	String Stockqualify(){
	    return "stock/stockqualify/stockqualify";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:stockqualify:stockqualify")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StockqualifyDO> stockqualifyList = stockqualifyService.list(query);
		int total = stockqualifyService.count(query);
		PageUtils pageUtils = new PageUtils(stockqualifyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:stockqualify:add")
	String add(){
	    return "stock/stockqualify/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:stockqualify:edit")
	String edit(@PathVariable("id") Long id,Model model){
		StockqualifyDO stockqualify = stockqualifyService.get(id);
		model.addAttribute("stockqualify", stockqualify);
	    return "stock/stockqualify/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:stockqualify:add")
	public R save( StockqualifyDO stockqualify){
		if(stockqualifyService.save(stockqualify)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:stockqualify:edit")
	public R update( StockqualifyDO stockqualify){
		stockqualifyService.update(stockqualify);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:stockqualify:remove")
	public R remove( Long id){
		if(stockqualifyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:stockqualify:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		stockqualifyService.batchRemove(ids);
		return R.ok();
	}
	
}
