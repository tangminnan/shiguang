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

import com.shiguang.mfrs.domain.LensDO;
import com.shiguang.mfrs.service.LensService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 材料分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
 
@Controller
@RequestMapping("/mfrs/lens")
public class LensController {
	@Autowired
	private LensService lensService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:lens:lens")
	String Lens(){
	    return "mfrs/lens/lens";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:lens:lens")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LensDO> lensList = lensService.list(query);
		int total = lensService.count(query);
		PageUtils pageUtils = new PageUtils(lensList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:lens:add")
	String add(){
	    return "mfrs/lens/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:lens:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LensDO lens = lensService.get(id);
		model.addAttribute("lens", lens);
	    return "mfrs/lens/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:lens:add")
	public R save( LensDO lens){
		if(lensService.save(lens)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:lens:edit")
	public R update( LensDO lens){
		lensService.update(lens);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:lens:remove")
	public R remove( Integer id){
		if(lensService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:lens:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		lensService.batchRemove(ids);
		return R.ok();
	}
	
}
