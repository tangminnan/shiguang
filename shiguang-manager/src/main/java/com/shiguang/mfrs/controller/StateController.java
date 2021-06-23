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

import com.shiguang.mfrs.domain.StateDO;
import com.shiguang.mfrs.service.StateService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 状态表

 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 14:19:37
 */
 
@Controller
@RequestMapping("/mfrs/state")
public class StateController {
	@Autowired
	private StateService stateService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:state:state")
	String State(){
	    return "mfrs/state/state";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:state:state")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StateDO> stateList = stateService.list(query);
		int total = stateService.count(query);
		PageUtils pageUtils = new PageUtils(stateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:state:add")
	String add(){
	    return "mfrs/state/add";
	}

	@GetMapping("/edit/{stateId}")
	@RequiresPermissions("mfrs:state:edit")
	String edit(@PathVariable("stateId") Integer stateId,Model model){
		StateDO state = stateService.get(stateId);
		model.addAttribute("state", state);
	    return "mfrs/state/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:state:add")
	public R save( StateDO state){
		if(stateService.save(state)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:state:edit")
	public R update( StateDO state){
		stateService.update(state);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:state:remove")
	public R remove( Integer stateId){
		if(stateService.remove(stateId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:state:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] stateIds){
		stateService.batchRemove(stateIds);
		return R.ok();
	}
	
}
