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

import com.shiguang.mfrs.domain.BatchDO;
import com.shiguang.mfrs.service.BatchService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 批号管理表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
 
@Controller
@RequestMapping("/mfrs/batch")
public class BatchController {
	@Autowired
	private BatchService batchService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:batch:batch")
	String Batch(){
	    return "mfrs/batch/batch";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:batch:batch")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BatchDO> batchList = batchService.list(query);
		int total = batchService.count(query);
		PageUtils pageUtils = new PageUtils(batchList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:batch:add")
	String add(){
	    return "mfrs/batch/add";
	}

	@GetMapping("/edit/{batchid}")
	@RequiresPermissions("mfrs:batch:edit")
	String edit(@PathVariable("batchid") Integer batchid,Model model){
		BatchDO batch = batchService.get(batchid);
		model.addAttribute("batch", batch);
	    return "mfrs/batch/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:batch:add")
	public R save( BatchDO batch){
		if(batchService.save(batch)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:batch:edit")
	public R update( BatchDO batch){
		batchService.update(batch);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:batch:remove")
	public R remove( Integer batchid){
		if(batchService.remove(batchid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:batch:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] batchids){
		batchService.batchRemove(batchids);
		return R.ok();
	}
	
}
