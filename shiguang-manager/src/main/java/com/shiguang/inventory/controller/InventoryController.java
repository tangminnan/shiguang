package com.shiguang.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.*;
import com.shiguang.inventory.domain.BillDO;
import com.shiguang.inventory.domain.InventoryDO;
import com.shiguang.inventory.service.BillService;
import com.shiguang.inventory.service.InventoryService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
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
import org.springframework.web.multipart.MultipartFile;


/**
 * 盘点表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
 
@Controller
@RequestMapping("/information/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private BillService billService;
	
	@GetMapping()
	@RequiresPermissions("information:inventory:inventory")
	String Inventory(){
	    return "inventory/inventory/inventory";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:inventory:inventory")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<InventoryDO> inventoryList = inventoryService.list(query);
		int total = inventoryService.count(query);
		PageUtils pageUtils = new PageUtils(inventoryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:inventory:add")
	String add(Model model){
		String documentNo = String.valueOf(GuuidUtil.getUUID());
		model.addAttribute("documentNo",documentNo);
		String singleName = ShiroUtils.getUser().getName();
		model.addAttribute("inventoryUser",singleName);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String documentTime = simpleDateFormat.format(new Date());
		model.addAttribute("documentTime",documentTime);
		Map<String,Object> query = new HashMap<>();
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyId",ShiroUtils.getUser().getCompanyId());
		} else {
			if (null != ShiroUtils.getUser().getStoreNum()){
				query.put("departNumber",ShiroUtils.getUser().getStoreNum());
			}
		}
		List<PositionDO> positionDOList = positionService.list(query);
		model.addAttribute("positionDOList",positionDOList);
	    return "inventory/inventory/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:inventory:edit")
	String edit(@PathVariable("id") Long id,Model model){
		InventoryDO inventory = inventoryService.get(id);
		model.addAttribute("inventory", inventory);
	    return "inventory/inventory/edit";
	}

	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:inventory:detail")
	String detail(@PathVariable("id") Long id,Model model){
		InventoryDO inventory = inventoryService.get(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		inventory.setDocumentTime(simpleDateFormat.format(inventory.getDocumentDate()));
		model.addAttribute("inventory", inventory);
		return "inventory/inventory/inventorybill";
	}

	@ResponseBody
	@GetMapping("/billlist")
	@RequiresPermissions("information:inventory:detail")
	public PageUtils billlist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<BillDO> billDOList = billService.list(query);
		int total = inventoryService.count(query);
//		List<InventoryDO> inventoryList = inventoryService.list(query);
//		int total = inventoryService.count(query);
		PageUtils pageUtils = new PageUtils(billDOList, total);
		return pageUtils;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:inventory:add")
	public R save(String documentNo,String inventoryName,String inventoryPosition,String inventoryType,MultipartFile file){
		return inventoryService.importInventory(documentNo,inventoryName,inventoryPosition,inventoryType,file);
//		if(inventoryService.save(inventory)>0){
//			return R.ok();
//		}
//		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:inventory:edit")
	public R update( InventoryDO inventory){
		inventoryService.update(inventory);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:inventory:remove")
	public R remove( Long id){
		if(inventoryService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:inventory:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		inventoryService.batchRemove(ids);
		return R.ok();
	}
	
}
