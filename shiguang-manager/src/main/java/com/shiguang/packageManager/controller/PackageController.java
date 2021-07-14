package com.shiguang.packageManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.service.PackageService;
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
 * 套餐表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-13 13:48:48
 */
 
@Controller
@RequestMapping("/information/package")
public class PackageController {
	@Autowired
	private PackageService packageService;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping()
	@RequiresPermissions("information:package:package")
	String Package(){
	    return "packageInfo/package";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:package:package")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PackageDO> packageList = packageService.list(query);
		int total = packageService.count(query);
		PageUtils pageUtils = new PageUtils(packageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:package:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("departType","销售门店");
		map.put("state",1);
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList",departmentDOList);
	    return "packageInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:package:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PackageDO packages = packageService.get(id);
		model.addAttribute("package", packages);
	    return "packageInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:package:add")
	public R save(PackageDO packages){
		if(packageService.save(packages)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:package:edit")
	public R update( PackageDO packages){
		packageService.update(packages);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:package:remove")
	public R remove( Long id){
		if(packageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:package:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		packageService.batchRemove(ids);
		return R.ok();
	}
	
}
