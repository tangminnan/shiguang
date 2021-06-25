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

import com.shiguang.product.domain.SphDO;
import com.shiguang.product.service.SphService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 球镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
 
@Controller
@RequestMapping("/product/sph")
public class SphController {
	@Autowired
	private SphService sphService;
	
	@GetMapping()
	@RequiresPermissions("product:sph:sph")
	String Sph(){
	    return "product/sph/sph";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:sph:sph")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SphDO> sphList = sphService.list(query);
		int total = sphService.count(query);
		PageUtils pageUtils = new PageUtils(sphList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:sph:add")
	String add(){
	    return "product/sph/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:sph:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SphDO sph = sphService.get(id);
		model.addAttribute("sph", sph);
	    return "product/sph/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:sph:add")
	public R save( SphDO sph){
		if(sphService.save(sph)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:sph:edit")
	public R update( SphDO sph){
		sphService.update(sph);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:sph:remove")
	public R remove( Long id){
		if(sphService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:sph:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		sphService.batchRemove(ids);
		return R.ok();
	}
	
}
