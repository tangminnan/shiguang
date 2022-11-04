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
	    return "inventory/gainloss/gainLoss";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:gainLoss:gainLoss")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyId",ShiroUtils.getUser().getCompanyId());
		}
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
	    return "inventory/gainloss/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:gainLoss:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GainLossDO gainLoss = gainLossService.get(id);
		model.addAttribute("gainLoss", gainLoss);
	    return "inventory/gainloss/edit";
	}

	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:gainLoss:detail")
	String detail(@PathVariable("id") Long id,Model model){
		GainLossDO gainLoss = gainLossService.get(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		gainLoss.setDocumentTime(simpleDateFormat.format(gainLoss.getDocumentDate()));
		model.addAttribute("gainLoss",gainLoss);
		if ("镜架".equals(gainLoss.getInventoryType())){
			String[] goodsId = gainLoss.getProducCode().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsId.length;i++){
				StockDO stockDO = new StockDO();
				stockDO.setGoodsCode(goodsId[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceCodeCount(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("配件".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			//List<PartsDO> goodsList = new ArrayList<>();
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				PartsDO partsDO = partsService.getPartInfomation(goodsNum[i]);
//				partsDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(partsDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsNum(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceNum(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("镜片".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			//List<Object> goodsList = new ArrayList<>();
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				JpdzDO jpdzDO = jpdzService.getJpdzInfomation(goodsNum[i]);
//				if (null != jpdzDO){
//					jpdzDO.setInventoryCount(goodsCount[i]);
//					goodsList.add(jpdzDO);
//				} else {
//					JpcpDO jpcpDO = jpcpService.getJpcpInfomation(goodsNum[i]);
//					if (null != jpcpDO){
//						jpcpDO.setInventoryCount(goodsCount[i]);
//						goodsList.add(jpcpDO);
//					}
//				}
				StockDO stockDO = new StockDO();
				stockDO.setGoodsNum(goodsNum[i]);
				stockDO.setPositionId(gainLoss.getPositionId()+"");
				StockDO producaDO = stockService.getProduceNum(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
					goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("隐形".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getProducCode().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				YxcpDO yxcpDO =new YxcpDO();
//				if (null != yxcpDO){
//					yxcpDO.setInventoryCount(goodsCount[i]);
//					goodsList.add(yxcpDO);
//				} else {
//					YxdzDO yxdzDO = yxdzService.getYxdzInfomation(goodsNum[i]);
//					if (null != yxdzDO){
//						yxdzDO.setInventoryCount(goodsCount[i]);
//						goodsList.add(yxdzDO);
//					}
//				}
				StockDO stockDO = new StockDO();
				stockDO.setGoodsCode(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceCodeCount(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("护理液".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getProducCode().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				HlyDO hlyDO = hlyService.getHlyInfomation(goodsNum[i]);
//				hlyDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(hlyDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsCode(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceCodeCount(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("太阳镜".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				TyjDO tyjDO = tyjService.getTyjInfomation(goodsNum[i]);
//				tyjDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(tyjDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsNum(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceNum(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("老花镜".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			//List<OldlensDO> goodsList = new ArrayList<>();
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				OldlensDO oldlensDO = oldlensService.getOldlenInfomation(goodsNum[i]);
//				oldlensDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(oldlensDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsNum(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceNum(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("耗材".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			//List<HcDO> goodsList = new ArrayList<>();
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				HcDO hcDO = hcService.getHcInfomation(goodsNum[i]);
//				hcDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(hcDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsNum(goodsNum[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceNum(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		} else if ("视光".equals(gainLoss.getInventoryType())){
			String[] goodsNum = gainLoss.getGoodsNum().split(",");
			String[] gooddsCode = gainLoss.getProducCode().split(",");
			String[] goodsCount = gainLoss.getInventoryCount().split(",");
			//List<ShiguangDO> goodsList = new ArrayList<>();
			List<StockDO> goodsList = new ArrayList<>();
			for (int i=0;i<goodsNum.length;i++){
//				ShiguangDO shiguangDO = shiguangService.getShiguangInfomation(goodsNum[i]);
//				shiguangDO.setInventoryCount(goodsCount[i]);
//				goodsList.add(shiguangDO);
				StockDO stockDO = new StockDO();
				stockDO.setGoodsCode(gooddsCode[i]);
				stockDO.setPositionId(String.valueOf(gainLoss.getPositionId()));
				StockDO producaDO = stockService.getProduceCodeCount(stockDO);
				producaDO.setInventoryCount(goodsCount[i]);
				goodsList.add(producaDO);
			}
			model.addAttribute("goodsList",goodsList);
		}
		return "inventory/gainloss/detail";
	}

	@GetMapping("/goods/{goodsType}")
	@RequiresPermissions("information:gainLoss:goods")
	String goods(@PathVariable("goodsType") String goodsType,Model model){
		Map<String,Object> map = new HashMap<>();
		model.addAttribute("goodsType",goodsType);
		if ("镜架".equals(goodsType)){
			//List<ProducaDO> jingjialist = producaService.list(map);
			return "inventory/gainloss/jingjia";
		} else if ("配件".equals(goodsType)) {
			//List<ProducaDO> jingjialist = producaService.list(map);
			return "inventory/gainloss/peijian";
		} else if ("镜片".equals(goodsType)){
			return "inventory/gainloss/jingpian";
		} else if ("太阳镜".equals(goodsType)){
			return "inventory/gainloss/taiyangjing";
		} else if ("老花镜".equals(goodsType)){
			return "inventory/gainloss/laohuajing";
		} else if ("耗材".equals(goodsType)){
			return "inventory/gainloss/haocai";
		} else if ("视光".equals(goodsType)){
			return "inventory/gainloss/shiguang";
		}
		return "inventory/gainloss/goods";
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
	@GetMapping("/barcode/{goodsType}/{positionId}")
	@RequiresPermissions("information:gainLoss:barcode")
	String barcode(@PathVariable("goodsType") String goodsType,@PathVariable("positionId") String positionId,Model model){
		model.addAttribute("goodsType",goodsType);
		model.addAttribute("positionId",positionId);
		return "inventory/gainloss/barcode";
	}

	@ResponseBody
	@RequestMapping(value = "/codeList")
	List<?> codeList(String goodsCode, String goodsType, String positionId,Model model) {
//		List<GoodsDO> goodsDOList = brandService.caidan(mfrsid);
//		model.addAttribute("goodsDOList", goodsDOList);
		Map<String,Object> map = new HashMap<>();
		map.put("goodsCode",goodsCode);
		map.put("positionId",positionId);
		List<String> list = new ArrayList<>();
		List<StockDO> stockDOList = stockService.list(map);
		if (null != stockDOList && stockDOList.size() > 0){
			for (StockDO stockDO : stockDOList){
				stockDO.setGoodsCount("1");
			}
		}
//		if ("隐形".equals(goodsType)){
//			List<YxcpDO> yxcpDOList = yxcpService.list(map);
//			if (null != yxcpDOList && yxcpDOList.size() > 0){
//				return yxcpDOList;
//			} else {
//				List<YxdzDO> yxdzDOList = yxdzService.list(map);
//				return yxdzDOList;
//			}
//
//		} else if ("护理液".equals(goodsType)){
//			List<HlyDO> hlyDOList = hlyService.list(map);
//			return hlyDOList;
//		} else if ("镜架".equals(goodsType)){
//			List<ProducaDO> producaDOList = producaService.list(map);
//			return producaDOList;
//		} else if ("配件".equals(goodsType)){
//			List<PartsDO> partsDOList = partsService.list(map);
//			return partsDOList;
//		} else if ("镜片".equals(goodsType)){
//			List<JpcpDO> jpcpDOList = jpcpService.list(map);
//			if (null != jpcpDOList && jpcpDOList.size() > 0){
//				return jpcpDOList;
//			} else {
//				List<JpdzDO> jpdzDOList = jpdzService.listDz(map);
//				return jpdzDOList;
//			}
//		} else if ("太阳镜".equals(goodsType)){
//			List<TyjDO> tyjDOList = tyjService.list(map);
//			return tyjDOList;
//		} else if ("老花镜".equals(goodsType)){
//			List<OldlensDO> oldlensDOList = oldlensService.list(map);
//			return oldlensDOList;
//		} else if ("耗材".equals(goodsType)){
//			List<HcDO> hcDOList = hcService.list(map);
//			return hcDOList;
//		} else if ("视光".equals(goodsType)){
//			List<ShiguangDO> shiguangDOList = shiguangService.list(map);
//			return shiguangDOList;
//		}
		return stockDOList;
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
			String[] brandname = null;
			if (null != gainLoss.getBrandname()){
				brandname = gainLoss.getBrandname().split(",");
			}
			String[] unitname = null;
			if (null != gainLoss.getUnitname()){
				unitname = gainLoss.getUnitname().split(",");
			}
			String[] mfrsid = null;
			if (null != gainLoss.getMfrsid()){
				mfrsid = gainLoss.getMfrsid().split(",");
			}
			String[] retailPrice =null;
			if (null != gainLoss.getRetailPrice()){
				retailPrice = gainLoss.getRetailPrice().split(",");
			}
			for (int i=0;i<goodsNum.length;i++){
				//更新库存
				StockDO stockDOs = new StockDO();
				StockDO stockDO = null;
				String stockCount = "";
				if (goodsType==5 || goodsType==9 || goodsType==9){
					stockDOs.setGoodsCode(produceCode[i]);
					stockDOs.setPositionId(String.valueOf(gainLoss.getPositionId()));
					stockDO = stockService.getProduceCode(stockDOs);
				} else {
					stockDOs.setGoodsNum(goodsNum[i]);
					stockDOs.setPositionId(String.valueOf(gainLoss.getPositionId()));
					stockDO = stockService.getProduceNum(stockDOs);
				}
				if (null != stockDO){
					stockCount = stockDO.getGoodsCount();
					if ("盘盈".equals(gainLoss.getDocumentType())){
						int goodsCount = Integer.parseInt(stockCount) + Integer.parseInt(inventoryCount[i]);
						StockDO stockDO1 = new StockDO();
						stockDO1.setGoodsCount(goodsCount+"");
						stockDO1.setGoodsNum(goodsNum[i]);
						stockDO1.setPositionId(String.valueOf(gainLoss.getPositionId()));
						stockService.updateGoodsCount(stockDO1);
					}else if ("盘亏".equals(gainLoss.getDocumentType())){
						int goodsCount = Integer.parseInt(stockCount) - Integer.parseInt(inventoryCount[i]);
						StockDO stockDO1 = new StockDO();
						stockDO1.setGoodsCount(goodsCount+"");
						stockDO1.setGoodsNum(goodsNum[i]);
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
						if (null != retailPrice){
							stockDO1.setRetailPrice(retailPrice[i]);
						}
						if (null != unitname){
							stockDO1.setUnit(unitname[i]);
						}
						if (null != mfrsid){
							stockDO1.setMfrsid(mfrsid[i]);
						}
						if (null != brandname){
							stockDO1.setBrandname(brandname[i]);
						}
						stockDO1.setReturnzt("1");
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
