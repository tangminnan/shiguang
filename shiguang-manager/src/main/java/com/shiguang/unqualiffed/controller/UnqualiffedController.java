package com.shiguang.unqualiffed.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.SaleGoodsDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import com.shiguang.unqualiffed.service.UnqualiffedService;
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
 * 不合格表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
 
@Controller
@RequestMapping("/information/unqualiffed")
public class UnqualiffedController {
	@Autowired
	private UnqualiffedService unqualiffedService;
	@Autowired
	private UserService userService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private StockService stockService;
	@Autowired
	private JpdzService jpdzService;
	@Autowired
	private JpcpService jpcpService;
	@Autowired
	private YxdzService yxdzService;
	@Autowired
	private ProducaService producaService;
	@Autowired
	private TyjService tyjService;
	@Autowired
	private PartsService partsService;
	@Autowired
	private HcService hcService;
	@Autowired
	private OldlensService oldlensService;
	@Autowired
	private ShiguangService shiguangService;
	@Autowired
	private HlyService hlyService;
	
	@GetMapping()
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	String Unqualiffed(){
	    return "unqualiffed/unqualiffed";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyId",ShiroUtils.getUser().getCompanyId());
		}
		List<UnqualiffedDO> unqualiffedList = unqualiffedService.list(query);
		int total = unqualiffedService.count(query);
		PageUtils pageUtils = new PageUtils(unqualiffedList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:unqualiffed:add")
	String add(Model model){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String documentNumber = "DJ"+GuuidUtil.getUUID();
		String preparedName = ShiroUtils.getUser().getName();
		String departmentAppli = ShiroUtils.getUser().getStore();
		String billDate = simpleDateFormat.format(new Date());
		Map<String,Object> map = new HashMap<>();
		map.put("roleType","6");
		List<UserDO> userDOList = userService.getRoleList(map);
		List<PositionDO> positionDOS = positionService.positionList(map);
		model.addAttribute("documentNumber",documentNumber);
		model.addAttribute("preparedName",preparedName);
		model.addAttribute("departmentAppli",departmentAppli);
		model.addAttribute("billDate",billDate);
		model.addAttribute("userDOList",userDOList);
		model.addAttribute("positionDOS",positionDOS);
	    return "unqualiffed/add";
	}

	@GetMapping("/goods")
	@RequiresPermissions("information:unqualiffed:goods")
	String goods(Model model){
		return "unqualiffed/goods";
	}

	/**
	 * 按配镜单添加商品
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/goodslist")
	@RequiresPermissions("information:unqualiffed:goods")
	public PageUtils goodslist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyId",ShiroUtils.getUser().getCompanyId());
		}
		List<SalesDO> salesDOList = salesService.peijinglist(query);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (SalesDO salesDO : salesDOList){
			salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
			salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
		}
		for (int i=0;i<salesDOList.size();i++){
			List<SaleGoodsDO> list = new ArrayList<>();
			if (null != salesDOList.get(i).getStoreDescribe()){
				String[] storeDescribe = salesDOList.get(i).getStoreDescribe().split(",");
				String[] goodsCode = salesDOList.get(i).getGoodsCode().split(",");
				String[] goodsNum = salesDOList.get(i).getGoodsNum().split(",");
				String[] goodsName = salesDOList.get(i).getStoreName().split(",");
				String[] goodsCount = salesDOList.get(i).getStoreCount().split(",");
				String[] classType = salesDOList.get(i).getClasstype().split(",");
				for (int a=0;a<storeDescribe.length;a++){
//					if ("镜片".equals(storeDescribe[a])){
						SaleGoodsDO saleGoodsDO = new SaleGoodsDO();
						saleGoodsDO.setGoodsCode(goodsCode[a]);
						saleGoodsDO.setGoodsNum(goodsNum[a]);
						saleGoodsDO.setGoodsName(goodsName[a]);
						saleGoodsDO.setSaleCount(goodsCount[a]);
						saleGoodsDO.setGoodsbs(storeDescribe[a]);
						saleGoodsDO.setClassType(classType[a]);
						list.add(saleGoodsDO);
//					}
				}
				salesDOList.get(i).setList(list);
			}
		}
		int total = salesService.peijingcount(query);
		PageUtils pageUtils = new PageUtils(salesDOList, total);
		return pageUtils;
	}


	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:unqualiffed:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UnqualiffedDO unqualiffed = unqualiffedService.get(id);
		model.addAttribute("unqualiffed", unqualiffed);
	    return "unqualiffed/edit";
	}

	@GetMapping("/salegoods")
	@RequiresPermissions("information:unqualiffed:salegoods")
	String salegoods(Model model){
		return "unqualiffed/saleGoods";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:unqualiffed:add")
	public R save(UnqualiffedDO unqualiffed){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String[] saleNumber = unqualiffed.getSaleNumber().split(",");
		//SalesDO salesDO = salesService.getSaleNumber(saleNumber[0]);
		Map<String,Object> map = new HashMap<>();
		map.put("companyId",ShiroUtils.getUser().getCompanyId());
		PositionDO positionDO = stockService.findBuHegePosition(map);
		String[] goodsCode = unqualiffed.getGoodsCode().split(",");
		String[] count = unqualiffed.getCount().split(",");
		String[] storeDescribe = unqualiffed.getStoreDescribe().split(",");
		for (int i=0;i<goodsCode.length;i++){
			String[] goodsNum = unqualiffed.getGoodsNum().split(",");
			String[] goodsName = unqualiffed.getGoodsName().split(",");
			StockDO stockDO = new StockDO();
			stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
			stockDO.setGoodsCode(goodsCode[i]);
			String[] classType = unqualiffed.getClassType().split(",");
			if ("2".equals(classType[i])){
				Map<String,Object> maps = new HashMap<>();
				maps.put("producNum",goodsNum[i]);
				JpdzDO jpdzDOS = jpdzService.getJpdzInfomation(goodsNum[i]);
				if (null != jpdzDOS ){
					StockDO stockDOs = new StockDO();
					stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
					stockDOs.setGoodsCode(goodsCode[i]);
					StockDO stockDO1 = stockService.getProduceCode(stockDOs);
					if (null != stockDO1){
						int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
						stockDO.setGoodsCount(godsCount + "");
						unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
						stockService.updateGoodsCount(stockDO);
					} else {
						stockDO.setGoodsNum(goodsNum[i]);
						stockDO.setGoodsName(goodsName[i]);
						stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
						stockDO.setUnit(jpdzDOS.getUnitname());
						stockDO.setMfrsid(jpdzDOS.getMfrsid());
						stockDO.setGoodsType(3);
						stockDO.setBrandname(jpdzDOS.getBrandname());
						stockDO.setRetailPrice(jpdzDOS.getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != jpdzDOS.getFactory() && !"".equals(jpdzDOS.getFactory())){
							stockDO.setFactory(jpdzDOS.getFactory());
						}
						stockDO.setClasstype("2");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
						stockService.save(stockDO);
					}

				} else {
					YxdzDO yxdzDOList =yxdzService.getYxdzInfomation(goodsNum[i]);
					if (null != yxdzDOList){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(yxdzDOList.getUnitname());
							stockDO.setMfrsid(yxdzDOList.getMfrsid());
							stockDO.setGoodsType(4);
							stockDO.setBrandname(yxdzDOList.getBrandname());
							stockDO.setRetailPrice(yxdzDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != yxdzDOList.getFactory() && !"".equals(yxdzDOList.getFactory())){
								stockDO.setFactory(yxdzDOList.getFactory());
							}
							stockDO.setClasstype("2");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				}
			} else if ("1".equals(classType[i])){
				Map<String,Object> maps = new HashMap<>();
				maps.put("producNum",goodsNum[i]);
				if ("镜片".equals(storeDescribe[i])){
					JpcpDO jpcpDOS = jpcpService.getJpcpInfomation(goodsNum[i]);
					if (null != jpcpDOS){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(jpcpDOS.getUnitname());
							stockDO.setMfrsid(jpcpDOS.getMfrsid());
							stockDO.setGoodsType(3);
							stockDO.setBrandname(jpcpDOS.getBrandname());
							stockDO.setRetailPrice(jpcpDOS.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != jpcpDOS.getProducFactory() && !"".equals(jpcpDOS.getProducFactory())){
								stockDO.setFactory(jpcpDOS.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("镜架".equals(storeDescribe[i])){
					ProducaDO producaDOList = producaService.getJJInfomation(goodsNum[i]);
					if (null != producaDOList ){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(producaDOList.getUnitname());
							stockDO.setMfrsid(producaDOList.getMfrsid());
							stockDO.setGoodsType(1);
							stockDO.setBrandname(producaDOList.getBrandname());
							stockDO.setRetailPrice(producaDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != producaDOList.getProducFactory() && !"".equals(producaDOList.getProducFactory())){
								stockDO.setFactory(producaDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("配件".equals(storeDescribe[i])){
					PartsDO partsDOList = partsService.getPartInfomation(goodsNum[i]);
					if (null != partsDOList ){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(partsDOList.getUnitname());
							stockDO.setMfrsid(partsDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(partsDOList.getBrandname());
							stockDO.setRetailPrice(partsDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != partsDOList.getProducFactory() && !"".equals(partsDOList.getProducFactory())){
								stockDO.setFactory(partsDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("护理液".equals(storeDescribe[i])){
					HlyDO hlyDOList = hlyService.getHlyInfomation(goodsNum[i]);
					if (null != hlyDOList ){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(hlyDOList.getUnitname());
							stockDO.setMfrsid(hlyDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(hlyDOList.getBrandname());
							stockDO.setRetailPrice(hlyDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != hlyDOList.getProducFactory() && !"".equals(hlyDOList.getProducFactory())){
								stockDO.setFactory(hlyDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("太阳镜".equals(storeDescribe[i])){
					TyjDO tyjDOList = tyjService.getTyjInfomation(goodsNum[i]);
					if (null != tyjDOList){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(tyjDOList.getUnitname());
							stockDO.setMfrsid(tyjDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(tyjDOList.getBrandname());
							stockDO.setRetailPrice(tyjDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != tyjDOList.getProducFactory() && !"".equals(tyjDOList.getProducFactory())){
								stockDO.setFactory(tyjDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("老花镜".equals(storeDescribe[i])){
					OldlensDO oldlensDOList = oldlensService.getOldlenInfomation(goodsNum[i]);
					if (null != oldlensDOList){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(oldlensDOList.getUnitname());
							stockDO.setMfrsid(oldlensDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(oldlensDOList.getBrandname());
							stockDO.setRetailPrice(oldlensDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != oldlensDOList.getProducFactory() && !"".equals(oldlensDOList.getProducFactory())){
								stockDO.setFactory(oldlensDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("耗材".equals(storeDescribe[i])){
					HcDO hcDOList = hcService.getHcInfomation(goodsNum[i]);
					if (null != hcDOList ){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(hcDOList.getUnitname());
							stockDO.setMfrsid(hcDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(hcDOList.getBrandname());
							stockDO.setRetailPrice(hcDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != hcDOList.getProducFactory() && !"".equals(hcDOList.getProducFactory())){
								stockDO.setFactory(hcDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				} else if ("视光".equals(storeDescribe[i])){
					ShiguangDO shiguangDOList = shiguangService.getShiguangInfomation(goodsNum[i]);
					if (null != shiguangDOList){
						StockDO stockDOs = new StockDO();
						stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDOs.setGoodsCode(goodsCode[i]);
						StockDO stockDO1 = stockService.getProduceCode(stockDOs);
						if (null != stockDO1){
							int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
							stockDO.setGoodsCount(godsCount + "");
							unqualiffed.setDocumentNumber(stockDO1.getDanjuNumber());
							stockService.updateGoodsCount(stockDO);
						} else {
							stockDO.setGoodsNum(goodsNum[i]);
							stockDO.setGoodsName(goodsName[i]);
							stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
							stockDO.setUnit(shiguangDOList.getUnitname());
							stockDO.setMfrsid(shiguangDOList.getMfrsid());
							stockDO.setGoodsType(2);
							stockDO.setBrandname(shiguangDOList.getBrandname());
							stockDO.setRetailPrice(shiguangDOList.getRetailPrice());
							stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
							stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
							if (null != shiguangDOList.getProducFactory() && !"".equals(shiguangDOList.getProducFactory())){
								stockDO.setFactory(shiguangDOList.getProducFactory());
							}
							stockDO.setClasstype("1");
							stockDO.setUsername(ShiroUtils.getUser().getUsername());
							stockDO.setCreateTime(simpleDateFormat.format(new Date()));
							stockDO.setStatus("0");
							stockDO.setReturnzt("1");
							stockDO.setDanjuNumber(unqualiffed.getDocumentNumber());
							stockService.save(stockDO);
						}
					}
				}

			}
		}
		unqualiffed.setCompanyId(ShiroUtils.getUser().getCompanyId());
		if(unqualiffedService.save(unqualiffed)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:package:detail")
	String detail(@PathVariable("id") Long id,Model model){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		UnqualiffedDO unqualiffedDO = unqualiffedService.get(id);
		String positionapild = unqualiffedDO.getPositionAppli();
		PositionDO positionDO = positionService.getPositionNum(positionapild);
		unqualiffedDO.setBillTime(simpleDateFormat.format(unqualiffedDO.getBillDate()));
		if (null == unqualiffedDO.getPhenomenon()){
			unqualiffedDO.setPhenomenon("");
		}
		model.addAttribute("unqualiffedDO",unqualiffedDO);
		model.addAttribute("positionDO",positionDO);
		return "unqualiffed/detail";
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:unqualiffed:edit")
	public R update( UnqualiffedDO unqualiffed){
		unqualiffedService.update(unqualiffed);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:remove")
	public R remove( Long id){
		if(unqualiffedService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		unqualiffedService.batchRemove(ids);
		return R.ok();
	}
	
}
