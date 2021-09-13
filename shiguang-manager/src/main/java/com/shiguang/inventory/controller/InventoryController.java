package com.shiguang.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.*;
import com.shiguang.inventory.domain.BillDO;
import com.shiguang.inventory.domain.GainLossDO;
import com.shiguang.inventory.domain.InventoryDO;
import com.shiguang.inventory.service.BillService;
import com.shiguang.inventory.service.GainLossService;
import com.shiguang.inventory.service.InventoryService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
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
	@Autowired
	private GainLossService gainLossService;
	@Autowired
	private StockService stockService;
	
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

	/**
	 * 生成盘盈单
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/isGainSure/{id}")
	@RequiresPermissions("information:inventory:isGainSure")
	String isGainSure(@PathVariable("id") Long id,Model model){
		InventoryDO inventory = inventoryService.get(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		inventory.setDocumentTime(simpleDateFormat.format(inventory.getDocumentDate()));
		model.addAttribute("gainlossType","盘盈");
		model.addAttribute("inventory", inventory);
		return "inventory/inventory/inventorySingle";
	}

	/**
	 * 生成盘亏单
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/isLossSure/{id}")
	@RequiresPermissions("information:inventory:isLossSure")
	String isLossSure(@PathVariable("id") Long id,Model model){
		InventoryDO inventory = inventoryService.get(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		inventory.setDocumentTime(simpleDateFormat.format(inventory.getDocumentDate()));
		model.addAttribute("gainlossType","盘亏");
		model.addAttribute("inventory", inventory);
		return "inventory/inventory/inventorySingle";
	}


	/**
	 * 生成盘盈盘亏单
	 */
	@PostMapping( "/saveSingle")
	@ResponseBody
	@RequiresPermissions("information:inventory:saveSingle")
	public R saveSingle(Long inventoryId,String gainlossType){
		InventoryDO inventory = inventoryService.getInventory(inventoryId);
		Map<String,Object> map = new HashMap<>();
		map.put("inventoryId",inventory.getInventoryId());
		List<BillDO> billDOList = billService.list(map);
		//增加盘盈盘亏单
		GainLossDO gainLossDO = new GainLossDO();
		gainLossDO.setDocumentNo("SC"+GuuidUtil.getUUID());
		gainLossDO.setDocumentDate(new Date());
		gainLossDO.setInventoryNumber("MAI"+GuuidUtil.getUUID());
		gainLossDO.setInventoryType(inventory.getInventoryType());
		gainLossDO.setDocumentType(gainlossType);
		gainLossDO.setDepartmentNumber(inventory.getDepartmentNumber());
		gainLossDO.setDepartmentName(inventory.getDepartmentName());
		gainLossDO.setPositionId(Long.valueOf(inventory.getInventoryPosition()));
		gainLossDO.setSingleName(inventory.getInventoryUser());
		StringBuffer countsb = new StringBuffer();
		StringBuffer goodsidsb = new StringBuffer();
		StringBuffer goodsNumsb = new StringBuffer();
		StringBuffer goodsCodesb = new StringBuffer();
		StringBuffer goodsNamesb = new StringBuffer();
		for(int i=0;i<billDOList.size();i++){
			if (i<billDOList.size()-1){
				if ("盘盈".equals(gainlossType)){
					if ("0".equals(billDOList.get(i).getInventoryType())){
						countsb.append(billDOList.get(i).getSurplus()+",");
						goodsidsb.append(billDOList.get(i).getGoodsId()+",");
						goodsNumsb.append(billDOList.get(i).getGoodsNum()+",");
						goodsCodesb.append(billDOList.get(i).getGoodsCode()+",");
						goodsNamesb.append(billDOList.get(i).getGoodsName()+",");
					}
				} else if ("盘亏".equals(gainlossType)){
					if ("1".equals(billDOList.get(i).getInventoryType())){
						countsb.append(billDOList.get(i).getSurplus().substring(1)+",");
						goodsidsb.append(billDOList.get(i).getGoodsId()+",");
						goodsNumsb.append(billDOList.get(i).getGoodsNum()+",");
						goodsCodesb.append(billDOList.get(i).getGoodsCode()+",");
						goodsNamesb.append(billDOList.get(i).getGoodsName()+",");
					}
				}
			} else {
				if ("盘盈".equals(gainlossType)){
					if ("0".equals(billDOList.get(i).getInventoryType())){
						countsb.append(billDOList.get(i).getSurplus());
						goodsidsb.append(billDOList.get(i).getGoodsId());
						goodsNumsb.append(billDOList.get(i).getGoodsNum());
						goodsCodesb.append(billDOList.get(i).getGoodsCode());
						goodsNamesb.append(billDOList.get(i).getGoodsName());
					}
				} else if ("盘亏".equals(gainlossType)){
					if ("1".equals(billDOList.get(i).getInventoryType())){
						countsb.append(billDOList.get(i).getSurplus().substring(1));
						goodsidsb.append(billDOList.get(i).getGoodsId());
						goodsNumsb.append(billDOList.get(i).getGoodsNum());
						goodsCodesb.append(billDOList.get(i).getGoodsCode());
						goodsNamesb.append(billDOList.get(i).getGoodsName());
					}
				}
			}
		}
		gainLossDO.setInventoryCount(countsb.toString());
		gainLossDO.setGoodsId(goodsidsb.toString());
		gainLossDO.setGoodsNum(goodsNumsb.toString());
		gainLossDO.setProducCode(goodsCodesb.toString());
		gainLossDO.setGoodsName(goodsNamesb.toString());
		//对库存进行操作
		if (null != gainLossDO.getProducCode()){
			String[] goodsCode = gainLossDO.getProducCode().split(",");
			String[] goodsCount = gainLossDO.getInventoryCount().split(",");
			for (int i=0;i<goodsCode.length;i++){
				StockDO stockDO = new StockDO();
				stockDO.setPositionId(String.valueOf(gainLossDO.getPositionId()));
				stockDO.setGoodsCode(goodsCode[i]);
				StockDO stockDO1 = stockService.getProduceCode(stockDO);
				StockDO stockDO2 = new StockDO();
				if (null != stockDO1){
					if ("盘盈".equals(gainLossDO.getDocumentType())){
						int count = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(goodsCount[i]);
						stockDO2.setGoodsCount(String.valueOf(count));
					} else if ("盘亏".equals(gainLossDO.getDocumentType())){
						int count = Integer.parseInt(stockDO1.getGoodsCount()) - Integer.parseInt(goodsCount[i]);
						if (count < 0){
							stockDO2.setGoodsCount("0");
						} else {
							stockDO2.setGoodsCount(String.valueOf(count));
						}

					}
					stockDO2.setGoodsCode(goodsCode[i]);
					stockDO2.setPositionId(String.valueOf(gainLossDO.getPositionId()));
					stockService.updateStockCCount(stockDO2);
				}

			}
		}
		if ("盘盈".equals(gainLossDO.getDocumentType())){
			inventory.setGain("已生成盘盈单");
		} else if ("盘亏".equals(gainLossDO.getDocumentType())){
			inventory.setLoss("已生成盘亏单");
		}
		inventoryService.update(inventory);
		gainLossDO.setExamineName(ShiroUtils.getUser().getName());
		gainLossDO.setExamineDate(new Date());
		gainLossDO.setExamineStatus("1");
		if(gainLossService.save(gainLossDO)>0){
			return R.ok();
		}
		return R.error();
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
		if ("盘盈".equals(query.get("gainlossType"))){
			query.put("inventoryType","0");
		} else if ("盘亏".equals(query.get("gainlossType"))){
			query.put("inventoryType","1");
		}
		List<BillDO> billDOList = billService.list(query);
		int total = inventoryService.count(query);
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
