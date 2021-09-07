package com.shiguang.integral.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.CardTypeService;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.integral.domain.IntegralDO;
import com.shiguang.integral.service.IntegralService;
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


/**
 * 积分设置表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-06 15:20:18
 */
 
@Controller
@RequestMapping("/information/integral")
public class IntegralController {
	@Autowired
	private IntegralService integralService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CardTypeService cardTypeService;
	
	@GetMapping()
	@RequiresPermissions("information:integral:integral")
	String Integral(){
	    return "integral/integral";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:integral:integral")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IntegralDO> integralList = integralService.list(query);
		int total = integralService.count(query);
		PageUtils pageUtils = new PageUtils(integralList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:integral:add")
	String add(){
	    return "integral/add";
	}

	@GetMapping("/store")
	@RequiresPermissions("information:integral:store")
	String store() {
		return "integral/store";
	}

	@ResponseBody
	@GetMapping("/storelist")
	@RequiresPermissions("information:integral:store")
	public PageUtils storelist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		if (null != ShiroUtils.getUser().getStoreNum()){
			String storeNum = ShiroUtils.getUser().getStoreNum();
			query.put("departNumber",storeNum);
		}
		query.put("departType","销售门店");
		query.put("state",1);
		List<DepartmentDO> departmentDOList = departmentService.list(query);
		int total = departmentService.count(query);
		PageUtils pageUtils = new PageUtils(departmentDOList, total);
		return pageUtils;
	}

	@GetMapping("/cardType")
	@RequiresPermissions("information:integral:cardType")
	String cardType() {
		return "integral/cardType";
	}

	@ResponseBody
	@GetMapping("/cardTypelist")
	@RequiresPermissions("information:integral:cardType")
	public PageUtils cardTypelist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		query.put("status",1);
		List<CardTypeDO> cardTypeDOList = cardTypeService.list(query);
		int total = cardTypeService.count(query);
		PageUtils pageUtils = new PageUtils(cardTypeDOList, total);
		return pageUtils;
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:integral:edit")
	String edit(@PathVariable("id") Long id,Model model){
		IntegralDO integral = integralService.get(id);
		model.addAttribute("integral", integral);
	    return "integral/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:integral:add")
	public R save(IntegralDO integral){
		integral.setCreateTime(new Date());
		if(integralService.save(integral)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:integral:edit")
	public R update( IntegralDO integral){
		integralService.update(integral);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:integral:remove")
	public R remove( Long id){
		if(integralService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:integral:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		integralService.batchRemove(ids);
		return R.ok();
	}
	
}
