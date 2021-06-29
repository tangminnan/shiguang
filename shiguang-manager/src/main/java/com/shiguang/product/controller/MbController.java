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

import com.shiguang.product.domain.MbDO;
import com.shiguang.product.service.MbService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 制造商品牌关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-28 13:49:46
 */
 
@Controller
@RequestMapping("/product/mb")
public class MbController {
	@Autowired
	private MbService mbService;
	
	@GetMapping()
	@RequiresPermissions("product:mb:mb")
	String Mb(){
	    return "product/mb/mb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:mb:mb")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MbDO> mbList = mbService.list(query);
		int total = mbService.count(query);
		PageUtils pageUtils = new PageUtils(mbList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:mb:add")
	String add(){
	    return "product/mb/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:mb:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		MbDO mb = mbService.get(id);
		model.addAttribute("mb", mb);
	    return "product/mb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:mb:add")
	public R save( MbDO mb){
		if(mbService.save(mb)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:mb:edit")
	public R update( MbDO mb){
		mbService.update(mb);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:mb:remove")
	public R remove( Integer id){
		if(mbService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:mb:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		mbService.batchRemove(ids);
		return R.ok();
	}
	
}
