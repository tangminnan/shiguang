package com.shiguang.mfrs.controller;

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

import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.service.MgService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 制造商商品类别表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 17:52:47
 */
 
@Controller
@RequestMapping("/mfrs/mg")
public class MgController {
	@Autowired
	private MgService mgService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:mg:mg")
	String Mg(){
	    return "mfrs/mg/mg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:mg:mg")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MgDO> mgList = mgService.list(query);
		int total = mgService.count(query);
		PageUtils pageUtils = new PageUtils(mgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:mg:add")
	String add(){
	    return "mfrs/mg/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:mg:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		MgDO mg = mgService.get(id);
		model.addAttribute("mg", mg);
	    return "mfrs/mg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:mg:add")
	public R save( MgDO mg){
		if(mgService.save(mg)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:mg:edit")
	public R update( MgDO mg){
		mgService.update(mg);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:mg:remove")
	public R remove( Integer goodsid){
		if(mgService.remove(goodsid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:mg:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		mgService.batchRemove(ids);
		return R.ok();
	}
	
}
