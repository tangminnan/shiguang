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
				for (int a=0;a<storeDescribe.length;a++){
//					if ("镜片".equals(storeDescribe[a])){
						SaleGoodsDO saleGoodsDO = new SaleGoodsDO();
						saleGoodsDO.setGoodsCode(goodsCode[a]);
						saleGoodsDO.setGoodsNum(goodsNum[a]);
						saleGoodsDO.setGoodsName(goodsName[a]);
						saleGoodsDO.setSaleCount(goodsCount[a]);
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
		SalesDO salesDO = salesService.getSaleNumber(saleNumber[0]);
		Map<String,Object> map = new HashMap<>();
		map.put("companyId",ShiroUtils.getUser().getCompanyId());
		PositionDO positionDO = stockService.findBuHegePosition(map);
		String[] goodsCode = salesDO.getGoodsCode().split(",");
		String[] count = salesDO.getStoreCount().split(",");
		String[] storeDescribe = salesDO.getStoreDescribe().split(",");
		for (int i=0;i<goodsCode.length;i++){
			StockDO stockDO = new StockDO();
			stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
			stockDO.setGoodsCode(goodsCode[i]);
			String[] goodsNum = salesDO.getGoodsNum().split(",");
			String[] goodsName = salesDO.getStoreName().split(",");
			stockDO.setGoodsNum(goodsNum[i]);
			stockDO.setGoodsName(goodsName[i]);
			stockDO.setGoodsCount(Integer.parseInt(count[i]) +"");
			String[] classType = salesDO.getClasstype().split(",");
			if ("2".equals(classType[i])){
				Map<String,Object> maps = new HashMap<>();
				maps.put("producNum",goodsNum[i]);
				List<JpdzDO> jpdzDOS = jpdzService.listDz(maps);
				if (null != jpdzDOS && jpdzDOS.size() > 0){
					stockDO.setUnit(jpdzDOS.get(0).getUnitname());
					stockDO.setMfrsid(jpdzDOS.get(0).getMfrsid());
					stockDO.setGoodsType(3);
					stockDO.setBrandname(jpdzDOS.get(0).getBrandname());
					stockDO.setRetailPrice(jpdzDOS.get(0).getRetailPrice());
					stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
					stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
					if (null != jpdzDOS.get(0).getFactory() && !"".equals(jpdzDOS.get(0).getFactory())){
						stockDO.setFactory(jpdzDOS.get(0).getFactory());
					}
					stockDO.setClasstype("2");
					stockDO.setUsername(ShiroUtils.getUser().getUsername());
					stockDO.setCreateTime(simpleDateFormat.format(new Date()));
					stockDO.setStatus("0");
					stockDO.setReturnzt("1");
					stockService.save(stockDO);
				} else {
					List<YxdzDO> yxdzDOList =yxdzService.list(maps);
					if (null != yxdzDOList && yxdzDOList.size() > 0){
						stockDO.setUnit(yxdzDOList.get(0).getUnitname());
						stockDO.setMfrsid(yxdzDOList.get(0).getMfrsid());
						stockDO.setGoodsType(4);
						stockDO.setBrandname(yxdzDOList.get(0).getBrandname());
						stockDO.setRetailPrice(yxdzDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != yxdzDOList.get(0).getFactory() && !"".equals(yxdzDOList.get(0).getFactory())){
							stockDO.setFactory(yxdzDOList.get(0).getFactory());
						}
						stockDO.setClasstype("2");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				}
			} else if ("1".equals(classType[i])){
				Map<String,Object> maps = new HashMap<>();
				maps.put("producNum",goodsNum[i]);
				if ("镜片".equals(storeDescribe[i])){
					List<JpcpDO> jpcpDOS = jpcpService.list(maps);
					if (null != jpcpDOS && jpcpDOS.size() > 0){
						stockDO.setUnit(jpcpDOS.get(0).getUnitname());
						stockDO.setMfrsid(jpcpDOS.get(0).getMfrsid());
						stockDO.setGoodsType(3);
						stockDO.setBrandname(jpcpDOS.get(0).getBrandname());
						stockDO.setRetailPrice(jpcpDOS.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != jpcpDOS.get(0).getProducFactory() && !"".equals(jpcpDOS.get(0).getProducFactory())){
							stockDO.setFactory(jpcpDOS.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("镜架".equals(storeDescribe[i])){
					List<ProducaDO> producaDOList = producaService.list(maps);
					if (null != producaDOList && producaDOList.size() > 0){
						stockDO.setUnit(producaDOList.get(0).getUnitname());
						stockDO.setMfrsid(producaDOList.get(0).getMfrsid());
						stockDO.setGoodsType(1);
						stockDO.setBrandname(producaDOList.get(0).getBrandname());
						stockDO.setRetailPrice(producaDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != producaDOList.get(0).getProducFactory() && !"".equals(producaDOList.get(0).getProducFactory())){
							stockDO.setFactory(producaDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("配件".equals(storeDescribe[i])){
					List<PartsDO> partsDOList = partsService.list(maps);
					if (null != partsDOList && partsDOList.size() > 0){
						stockDO.setUnit(partsDOList.get(0).getUnitname());
						stockDO.setMfrsid(partsDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(partsDOList.get(0).getBrandname());
						stockDO.setRetailPrice(partsDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != partsDOList.get(0).getProducFactory() && !"".equals(partsDOList.get(0).getProducFactory())){
							stockDO.setFactory(partsDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("护理液".equals(storeDescribe[i])){
					List<HlyDO> hlyDOList = hlyService.list(maps);
					if (null != hlyDOList && hlyDOList.size() > 0){
						stockDO.setUnit(hlyDOList.get(0).getUnitname());
						stockDO.setMfrsid(hlyDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(hlyDOList.get(0).getBrandname());
						stockDO.setRetailPrice(hlyDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != hlyDOList.get(0).getProducFactory() && !"".equals(hlyDOList.get(0).getProducFactory())){
							stockDO.setFactory(hlyDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("太阳镜".equals(storeDescribe[i])){
					List<TyjDO> tyjDOList = tyjService.list(maps);
					if (null != tyjDOList && tyjDOList.size() > 0){
						stockDO.setUnit(tyjDOList.get(0).getUnitname());
						stockDO.setMfrsid(tyjDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(tyjDOList.get(0).getBrandname());
						stockDO.setRetailPrice(tyjDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != tyjDOList.get(0).getProducFactory() && !"".equals(tyjDOList.get(0).getProducFactory())){
							stockDO.setFactory(tyjDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("老花镜".equals(storeDescribe[i])){
					List<OldlensDO> oldlensDOList = oldlensService.list(maps);
					if (null != oldlensDOList && oldlensDOList.size() > 0){
						stockDO.setUnit(oldlensDOList.get(0).getUnitname());
						stockDO.setMfrsid(oldlensDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(oldlensDOList.get(0).getBrandname());
						stockDO.setRetailPrice(oldlensDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != oldlensDOList.get(0).getProducFactory() && !"".equals(oldlensDOList.get(0).getProducFactory())){
							stockDO.setFactory(oldlensDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("耗材".equals(storeDescribe[i])){
					List<HcDO> hcDOList = hcService.list(maps);
					if (null != hcDOList && hcDOList.size() > 0){
						stockDO.setUnit(hcDOList.get(0).getUnitname());
						stockDO.setMfrsid(hcDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(hcDOList.get(0).getBrandname());
						stockDO.setRetailPrice(hcDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != hcDOList.get(0).getProducFactory() && !"".equals(hcDOList.get(0).getProducFactory())){
							stockDO.setFactory(hcDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
					}
				} else if ("视光".equals(storeDescribe[i])){
					List<ShiguangDO> shiguangDOList = shiguangService.list(maps);
					if (null != shiguangDOList && shiguangDOList.size() > 0){
						stockDO.setUnit(shiguangDOList.get(0).getUnitname());
						stockDO.setMfrsid(shiguangDOList.get(0).getMfrsid());
						stockDO.setGoodsType(2);
						stockDO.setBrandname(shiguangDOList.get(0).getBrandname());
						stockDO.setRetailPrice(shiguangDOList.get(0).getRetailPrice());
						stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
						stockDO.setZhidanPeople(ShiroUtils.getUser().getName());
						if (null != shiguangDOList.get(0).getProducFactory() && !"".equals(shiguangDOList.get(0).getProducFactory())){
							stockDO.setFactory(shiguangDOList.get(0).getProducFactory());
						}
						stockDO.setClasstype("1");
						stockDO.setUsername(ShiroUtils.getUser().getUsername());
						stockDO.setCreateTime(simpleDateFormat.format(new Date()));
						stockDO.setStatus("0");
						stockDO.setReturnzt("1");
						stockService.save(stockDO);
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
