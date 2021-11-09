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

import com.shiguang.stock.domain.StocksaleDO;
import com.shiguang.stock.service.StocksaleService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 销售仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
 
@Controller
@RequestMapping("/stock/stocksale")
public class StocksaleController {
	@Autowired
	private StocksaleService stocksaleService;
	
	@GetMapping()
	@RequiresPermissions("stock:stocksale:stocksale")
	String Stocksale(){
	    return "stock/stocksale/stocksale";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:stocksale:stocksale")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StocksaleDO> stocksaleList = stocksaleService.list(query);
		int total = stocksaleService.count(query);
		PageUtils pageUtils = new PageUtils(stocksaleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:stocksale:add")
	String add(){
	    return "stock/stocksale/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:stocksale:edit")
	String edit(@PathVariable("id") Long id,Model model){
		StocksaleDO stocksale = stocksaleService.get(id);
		model.addAttribute("stocksale", stocksale);
	    return "stock/stocksale/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:stocksale:add")
	public R save( StocksaleDO stocksale){
		if(stocksaleService.save(stocksale)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:stocksale:edit")
	public R update( StocksaleDO stocksale){
		stocksaleService.update(stocksale);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:stocksale:remove")
	public R remove( Long id){
		if(stocksaleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:stocksale:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		stocksaleService.batchRemove(ids);
		return R.ok();
	}
	
}
