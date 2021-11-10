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

import com.shiguang.stock.domain.StocklogDO;
import com.shiguang.stock.service.StocklogService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * kucunlog

 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 15:00:50
 */
 
@Controller
@RequestMapping("/stock/stocklog")
public class StocklogController {
	@Autowired
	private StocklogService stocklogService;
	
	@GetMapping()
	@RequiresPermissions("stock:stocklog:stocklog")
	String Stocklog(){
	    return "stock/stocklog/stocklog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:stocklog:stocklog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StocklogDO> stocklogList = stocklogService.list(query);
		int total = stocklogService.count(query);
		PageUtils pageUtils = new PageUtils(stocklogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:stocklog:add")
	String add(){
	    return "stock/stocklog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:stocklog:edit")
	String edit(@PathVariable("id") Long id,Model model){
		StocklogDO stocklog = stocklogService.get(id);
		model.addAttribute("stocklog", stocklog);
	    return "stock/stocklog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:stocklog:add")
	public R save( StocklogDO stocklog){
		if(stocklogService.save(stocklog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:stocklog:edit")
	public R update( StocklogDO stocklog){
		stocklogService.update(stocklog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:stocklog:remove")
	public R remove( Long id){
		if(stocklogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:stocklog:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		stocklogService.batchRemove(ids);
		return R.ok();
	}
	
}
