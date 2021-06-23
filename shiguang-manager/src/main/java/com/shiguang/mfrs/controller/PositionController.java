package com.shiguang.mfrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.mfrs.domain.MfrsDO;
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

import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 仓位维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */
 
@Controller
@RequestMapping("/mfrs/position")
public class PositionController {
	@Autowired
	private PositionService positionService;
	//部门维护
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:position:position")
	String Position(){
	    return "mfrs/position/position";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:position:position")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PositionDO> positionList = positionService.list(query);
		int total = positionService.count(query);
		PageUtils pageUtils = new PageUtils(positionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:position:add")
	String add(Model model){
		Map<String,Object> map = new HashMap<>();
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList",departmentDOList);
	    return "mfrs/position/add";
	}

	@GetMapping("/edit/{positionId}")
	@RequiresPermissions("mfrs:position:edit")
	String edit(@PathVariable("positionId") Long positionId,Model model){
		PositionDO position = positionService.get(positionId);
		model.addAttribute("position", position);
		Map<String,Object> map = new HashMap<>();
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList",departmentDOList);
	    return "mfrs/position/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:position:add")
	public R save( PositionDO position){
		//判断是否已存在
		String positionNum = position.getPositionNum();
		Map<String, Object> map = new HashMap<>();
		map.put("positionNum",positionNum);
		List<PositionDO> list = positionService.list(map);
		if (list.size() > 0){
			return R.error("仓位代码已存在");
		}
		String departNumber = position.getDepartNumber();
		Map<String, Object> map1 = new HashMap<>();
		map.put("departNumber",departNumber);
		List<PositionDO> list1 = positionService.list(map1);
		if (list1.size() > 0){
			return R.error("所属部门已存在");
		}
		String positionName = position.getPositionName();
		Map<String, Object> map2 = new HashMap<>();
		map.put("positionName",positionName);
		List<PositionDO> list2 = positionService.list(map2);
		if (list2.size() > 0){
			return R.error("仓位名称已存在");
		}
		String positionOrder = position.getPositionNum();
		Map<String, Object> map3 = new HashMap<>();
		map.put("positionOrder",positionOrder);
		List<PositionDO> list3 = positionService.list(map3);
		if (list3.size() > 0){
			return R.error("排列序号已存在");
		}

		if(positionService.save(position)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:position:edit")
	public R update( PositionDO position){
		positionService.update(position);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:position:remove")
	public R remove( Long positionId){
		if(positionService.remove(positionId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:position:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] positionIds){
		positionService.batchRemove(positionIds);
		return R.ok();
	}
	
}
