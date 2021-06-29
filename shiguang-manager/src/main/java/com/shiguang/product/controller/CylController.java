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

import com.shiguang.product.domain.CylDO;
import com.shiguang.product.service.CylService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 柱镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:26:17
 */
 
@Controller
@RequestMapping("/product/cyl")
public class CylController {
	@Autowired
	private CylService cylService;
	
	@GetMapping()
	@RequiresPermissions("product:cyl:cyl")
	String Cyl(){
	    return "product/cyl/cyl";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:cyl:cyl")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CylDO> cylList = cylService.list(query);
		int total = cylService.count(query);
		PageUtils pageUtils = new PageUtils(cylList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:cyl:add")
	String add(){
	    return "product/cyl/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:cyl:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CylDO cyl = cylService.get(id);
		model.addAttribute("cyl", cyl);
	    return "product/cyl/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:cyl:add")
	public R save( CylDO cyl){
		if(cylService.save(cyl)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:cyl:edit")
	public R update( CylDO cyl){
		cylService.update(cyl);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:cyl:remove")
	public R remove( Integer id){
		if(cylService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:cyl:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		cylService.batchRemove(ids);
		return R.ok();
	}
	
}
