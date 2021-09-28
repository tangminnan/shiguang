package com.shiguang.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.*;
import com.shiguang.inventory.dao.GainLossDao;
import com.shiguang.inventory.domain.GainLossDO;
import com.shiguang.inventory.service.GainLossService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.apache.poi.ss.formula.functions.T;
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
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-07 15:27:42
 */
 
@Controller
@RequestMapping("/information/gainLoss")
public class GainLossController {
	@Autowired
	private GainLossService gainLossService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private ProducaService producaService;
	@Autowired
	private PartsService partsService;
	@Autowired
	private JpcpService jpcpService;
	@Autowired
	private JpdzService jpdzService;
	@Autowired
	private TyjService tyjService;
	@Autowired
	private OldlensService oldlensService;
	@Autowired
	private HcService hcService;
	@Autowired
	private ShiguangService shiguangService;
	@Autowired
	private YxcpService yxcpService;
	@Autowired
	private YxdzService yxdzService;
	@Autowired
	private HlyService hlyService;
	@Autowired
	private StockService stockService;
	
	@GetMapping()
	@RequiresPermissions("information:gainLoss:gainLoss")
	String GainLoss(){
	    return "inventory/gainLoss/gainLoss";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:gainLoss:gainLoss")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        query.put("companyId",ShiroUtils.getUser().getCompanyId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<GainLossDO> gainLossList = gainLossService.list(query);
		if (null != gainLossList && gainLossList.size() > 0){
			for (GainLossDO gainLossDO : gainLossList){
				if (null != gainLossDO.getExamineDate()){
					gainLossDO.setExamineTime(simpleDateFormat.format(gainLossDO.getExamineDate()));
				}

			}
		}
		int total = gainLossService.count(query);
		PageUtils pageUtils = new PageUtils(gainLossList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:gainLoss:add")
	String add(Model model){
		String singleName = ShiroUtils.getUser().getName();
		model.addAttribute("singleName",singleName);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String documentTime = simpleDateFormat.format(new Date());
		model.addAttribute("documentTime",documentTime);
		Map<String,Object> query = new HashMap<>();
		query.put("companyId",ShiroUtils.getUser().getCompanyId());
		List<PositionDO> positionDOList = positionService.list(query);
		model.addAttribute("positionDOList",positionDOList);
	    return "inventory/gainLoss/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:gainLoss:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GainLossDO gainLoss = gainLossService.get(id);
		model.addAttribute("gainLoss", gainLoss);
	    return "inventory/gainLoss/edit";
	}

	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:gainLoss:detail")
	String detail(@PathVariable("id") Long id,Model model){
		GainLossDO gainLoss = gainLossService.get(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		gainLoss.setDocumentTime(simpleDateFormat.format(gainLoss.getDocumentDate()));
		model.addAttribute("gainLoss",gainLoss);
		if ("镜架".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<ProducaDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				ProducaDO producaDO = producaService.get(Long.parseLong(goodsId[i]));
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("配件".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<PartsDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				PartsDO partsDO = partsService.get(Long.parseLong(goodsId[i]));
				partsDO.setInventoryCount(goodsCount[i]);
				goodsList.add(partsDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("镜片".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<Object> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				JpdzDO jpdzDO = jpdzService.get(Long.parseLong(goodsId[i]));
				if (null != jpdzDO){
					jpdzDO.setInventoryCount(goodsCount[i]);
					goodsList.add(jpdzDO);
				} else {
					JpcpDO jpcpDO = jpcpService.get(Long.parseLong(goodsId[i]));
					if (null != jpcpDO){
						jpcpDO.setInventoryCount(goodsCount[i]);
						goodsList.add(jpcpDO);
					}
				}
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("隐形".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<Object> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				YxcpDO yxcpDO = yxcpService.get(Long.parseLong(goodsId[i]));
				if (null != yxcpDO){
					yxcpDO.setInventoryCount(goodsCount[i]);
					goodsList.add(yxcpDO);
				} else {
					YxdzDO yxdzDO = yxdzService.get(Long.parseLong(goodsId[i]));
					if (null != yxdzDO){
						yxdzDO.setInventoryCount(goodsCount[i]);
						goodsList.add(yxdzDO);
					}
				}
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("护理液".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<HlyDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				HlyDO hlyDO = hlyService.get(Long.parseLong(goodsId[i]));
				hlyDO.setInventoryCount(goodsCount[i]);
				goodsList.add(hlyDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("太阳镜".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<TyjDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				TyjDO tyjDO = tyjService.get(Long.parseLong(goodsId[i]));
				tyjDO.setInventoryCount(goodsCount[i]);
				goodsList.add(tyjDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("老花镜".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<OldlensDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				OldlensDO oldlensDO = oldlensService.get(Long.parseLong(goodsId[i]));
				oldlensDO.setInventoryCount(goodsCount[i]);
				goodsList.add(oldlensDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("耗材".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<HcDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				HcDO hcDO = hcService.get(Long.parseLong(goodsId[i]));
				hcDO.setInventoryCount(goodsCount[i]);
				goodsList.add(hcDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("视光".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getGoodsId().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<ShiguangDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				ShiguangDO shiguangDO = shiguangService.get(Long.parseLong(goodsId[i]));
				shiguangDO.setInventoryCount(goodsCount[i]);
				goodsList.add(shiguangDO);
			}
			model.addAttribute("goodsList",goodsList);
		}
		return "inventory/gainLoss/detail";
	}

	@GetMapping("/goods/{goodsType}")
	@RequiresPermissions("information:gainLoss:goods")
	String goods(@PathVariable("goodsType") String goodsType,Model model){
		Map<String,Object> map = new HashMap<>();
		model.addAttribute("goodsType",goodsType);
		if ("镜架".equals(goodsType)){
			//List<ProducaDO> jingjialist = producaService.list(map);
			return "inventory/gainLoss/jingjia";
		} else if ("配件".equals(goodsType)) {
			//List<ProducaDO> jingjialist = producaService.list(map);
			return "inventory/gainLoss/peijian";
		} else if ("镜片".equals(goodsType)){
			return "inventory/gainLoss/jingpian";
		} else if ("太阳镜".equals(goodsType)){
			return "inventory/gainLoss/taiyangjing";
		} else if ("老花镜".equals(goodsType)){
			return "inventory/gainLoss/laohuajing";
		} else if ("耗材".equals(goodsType)){
			return "inventory/gainLoss/haocai";
		} else if ("视光".equals(goodsType)){
			return "inventory/gainLoss/shiguang";
		}
		return "inventory/gainLoss/goods";
	}

	@ResponseBody
	@GetMapping("/goodslist")
	@RequiresPermissions("information:gainLoss:goods")
	public PageUtils goodslist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		PageUtils pageUtils = null;
		if ("镜架".equals(query.get("goodsType"))){
			List<ProducaDO> jingjiaList = producaService.list(query);
			int total = producaService.count(query);
			pageUtils = new PageUtils(jingjiaList, total);
		} else if ("配件".equals(query.get("goodsType"))){
			List<PartsDO> partsList = partsService.list(query);
			int total = partsService.count(query);
			pageUtils = new PageUtils(partsList, total);
		} else if ("镜片".equals(query.get("goodsType"))){
			if ("0".equals(query.get("dzType"))){
				List<JpcpDO> jpcpDOList = jpcpService.list(query);
				int total = jpcpService.count(query);
				pageUtils = new PageUtils(jpcpDOList, total);
			} else if ("1".equals(query.get("dzType"))){
				List<JpdzDO> jpdzDOList = jpdzService.listDz(query);
				int total = jpdzService.countDz(query);
				pageUtils = new PageUtils(jpdzDOList, total);
			}
		} else if ("太阳镜".equals(query.get("goodsType"))){
			List<TyjDO> tyjDOList = tyjService.list(query);
			int total = tyjService.count(query);
			pageUtils = new PageUtils(tyjDOList, total);
		} else if ("老花镜".equals(query.get("goodsType"))){
			List<OldlensDO> oldlensDOList = oldlensService.list(query);
			int total = oldlensService.count(query);
			pageUtils = new PageUtils(oldlensDOList, total);
		} else if ("耗材".equals(query.get("goodsType"))){
			List<HcDO> hcDOList = hcService.list(query);
			int total = hcService.count(query);
			pageUtils = new PageUtils(hcDOList, total);
		} else if ("视光".equals(query.get("goodsType"))){
			List<ShiguangDO> shiguangDOList = shiguangService.list(query);
			int total = shiguangService.count(query);
			pageUtils = new PageUtils(shiguangDOList, total);
		}
		return pageUtils;
	}


	/**
	 * 条码扫描
	 */
	@GetMapping("/barcode/{goodsType}")
	@RequiresPermissions("information:gainLoss:barcode")
	String barcode(@PathVariable("goodsType") String goodsType,Model model){
		model.addAttribute("goodsType",goodsType);
		return "inventory/gainLoss/barcode";
	}

	@ResponseBody
	@RequestMapping(value = "/codeList")
	List<?> codeList(String goodsCode, String goodsType, Model model) {
//		List<GoodsDO> goodsDOList = brandService.caidan(mfrsid);
//		model.addAttribute("goodsDOList", goodsDOList);
		Map<String,Object> map = new HashMap<>();
		map.put("goodsCode",goodsCode);
		List<String> list = new ArrayList<>();
		if ("隐形".equals(goodsType)){
			List<YxcpDO> yxcpDOList = yxcpService.list(map);
			if (null != yxcpDOList && yxcpDOList.size() > 0){
				return yxcpDOList;
			} else {
				List<YxdzDO> yxdzDOList = yxdzService.list(map);
				return yxdzDOList;
			}

		} else if ("护理液".equals(goodsType)){
			List<HlyDO> hlyDOList = hlyService.list(map);
			return hlyDOList;
		} else if ("镜架".equals(goodsType)){
			List<ProducaDO> producaDOList = producaService.list(map);
			return producaDOList;
		} else if ("配件".equals(goodsType)){
			List<PartsDO> partsDOList = partsService.list(map);
			return partsDOList;
		} else if ("镜片".equals(goodsType)){
			List<JpcpDO> jpcpDOList = jpcpService.list(map);
			if (null != jpcpDOList && jpcpDOList.size() > 0){
				return jpcpDOList;
			} else {
				List<JpdzDO> jpdzDOList = jpdzService.listDz(map);
				return jpdzDOList;
			}
		} else if ("太阳镜".equals(goodsType)){
			List<TyjDO> tyjDOList = tyjService.list(map);
			return tyjDOList;
		} else if ("老花镜".equals(goodsType)){
			List<OldlensDO> oldlensDOList = oldlensService.list(map);
			return oldlensDOList;
		} else if ("耗材".equals(goodsType)){
			List<HcDO> hcDOList = hcService.list(map);
			return hcDOList;
		} else if ("视光".equals(goodsType)){
			List<ShiguangDO> shiguangDOList = shiguangService.list(map);
			return shiguangDOList;
		}
		return list;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:gainLoss:add")
	public R save(GainLossDO gainLoss){
		gainLoss.setDocumentNo("SC"+GuuidUtil.getUUID());
		gainLoss.setInventoryNumber("MAI"+GuuidUtil.getUUID());
		gainLoss.setDocumentDate(new Date());
		gainLoss.setDepartmentName(ShiroUtils.getUser().getStore());
		gainLoss.setDepartmentNumber(ShiroUtils.getUser().getStoreNum());
		gainLoss.setExamineStatus("0");
		if(gainLossService.save(gainLoss)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:gainLoss:edit")
	public R update( GainLossDO gainLoss){
		gainLossService.update(gainLoss);
		return R.ok();
	}

	/**
	 * 审核
	 */
	@PostMapping( "/examine")
	@ResponseBody
	@RequiresPermissions("information:gainLoss:examine")
	public R examine( Long id){
		GainLossDO gainLoss = gainLossService.get(id);
		Integer goodsType = null;
		if ("镜架".equals(gainLoss.getInventoryType())){
			goodsType = 1;
		} else if ("配件".equals(gainLoss.getInventoryType())){
			goodsType = 2;
		} else if ("镜片".equals(gainLoss.getInventoryType())){
			goodsType = 3;
		} else if ("隐形".equals(gainLoss.getInventoryType())){
			goodsType = 4;
		} else if ("护理液".equals(gainLoss.getInventoryType())){
			goodsType = 5;
		} else if ("太阳镜".equals(gainLoss.getInventoryType())){
			goodsType = 6;
		} else if ("老花镜".equals(gainLoss.getInventoryType())){
			goodsType = 7;
		} else if ("耗材".equals(gainLoss.getInventoryType())){
			goodsType = 8;
		} else if ("视光".equals(gainLoss.getInventoryType())){
			goodsType = 9;
		}
		if (null != gainLoss.getProducCode()){
			String[] produceCode = gainLoss.getProducCode().split(",");
			String[] inventoryCount = gainLoss.getInventoryCount().split(",");
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsName = gainLoss.getGoodsName().split(",");
			String[] classType = gainLoss.getClassType().split(",");
			for (int i=0;i<produceCode.length;i++){
				//更新库存
				StockDO stockDOs = new StockDO();
				stockDOs.setGoodsCode(produceCode[i]);
				stockDOs.setPositionId(String.valueOf(gainLoss.getPositionId()));
				String stockCount = "";
				StockDO stockDO = stockService.getProduceCode(stockDOs);
				if (null != stockDO){
					stockCount = stockDO.getGoodsCount();
					if ("盘盈".equals(gainLoss.getDocumentType())){
						int goodsCount = Integer.parseInt(stockCount) + Integer.parseInt(inventoryCount[i]);
						StockDO stockDO1 = new StockDO();
						stockDO1.setGoodsCount(goodsCount+"");
						stockDO1.setGoodsCode(produceCode[i]);
						stockDO1.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.updateGoodsCount(stockDO1);
					}else if ("盘亏".equals(gainLoss.getDocumentType())){
						int goodsCount = Integer.parseInt(stockCount) - Integer.parseInt(inventoryCount[i]);
						StockDO stockDO1 = new StockDO();
						stockDO1.setGoodsCount(goodsCount+"");
						stockDO1.setGoodsCode(produceCode[i]);
						stockDO1.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.updateGoodsCount(stockDO1);
					}
				} else {
					if ("盘盈".equals(gainLoss.getDocumentType())){
						StockDO stockDO1 = new StockDO();
						stockDO1.setGoodsCode(produceCode[i]);
						stockDO1.setUsername(ShiroUtils.getUser().getUsername());
						stockDO1.setStatus("0");
						stockDO1.setGoodsNum(goodsNum[i]);
						stockDO1.setGoodsName(goodsName[i]);
						stockDO1.setGoodsCount(inventoryCount[i]);
						stockDO1.setGoodsType(goodsType);
						stockDO1.setUnit(gainLoss.getUnitname());
						stockDO1.setMfrsid(gainLoss.getMfrsid());
						stockDO1.setBrandname(gainLoss.getBrandname());
						stockDO1.setReturnzt(gainLoss.getRetailPrice());
						stockDO1.setClasstype(classType[i]);
						stockDO1.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.save(stockDO1);
					}
				}

			}
		}
		GainLossDO gainLossDO = new GainLossDO();
		gainLossDO.setId(id);
		gainLossDO.setExamineName(ShiroUtils.getUser().getName());
		gainLossDO.setExamineDate(new Date());
		gainLossDO.setExamineStatus("1");
		if(gainLossService.update(gainLossDO)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:gainLoss:remove")
	public R remove( Long id){
		if(gainLossService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:gainLoss:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		gainLossService.batchRemove(ids);
		return R.ok();
	}
	
}
