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

import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-25 10:27:20
 */
 
@Controller
@RequestMapping("/stock/pidiao")
public class PidiaoController {
	@Autowired
	private PidiaoService pidiaoService;
	
	@GetMapping()
	@RequiresPermissions("stock:pidiao:pidiao")
	String Pidiao(){
	    return "stock/pidiao/pidiao";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:pidiao:pidiao")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PidiaoDO> pidiaoList = pidiaoService.list(query);
		int total = pidiaoService.count(query);
		PageUtils pageUtils = new PageUtils(pidiaoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:pidiao:add")
	String add(){
	    return "stock/pidiao/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:pidiao:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PidiaoDO pidiao = pidiaoService.get(id);
		model.addAttribute("pidiao", pidiao);
	    return "stock/pidiao/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:pidiao:add")
	public R save( PidiaoDO pidiao){
		if(pidiaoService.save(pidiao)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:pidiao:edit")
	public R update( PidiaoDO pidiao){
		pidiaoService.update(pidiao);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:remove")
	public R remove( Long id){
		if(pidiaoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		pidiaoService.batchRemove(ids);
		return R.ok();
	}
	
}
