package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.service.BrandService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.RefractivityService;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.StocklogDO;
import com.shiguang.stock.service.PidiaoService;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.StocklogService;
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

import com.shiguang.stock.domain.TuihuoDO;
import com.shiguang.stock.service.TuihuoService;

/**
 * 退货表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
 
@Controller
@RequestMapping("/stock/tuihuo")
public class TuihuoController {
	@Autowired
	private TuihuoService tuihuoService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	//品牌
	@Autowired
	private BrandService brandService;
	//批调
	@Autowired
	private PidiaoService pidiaoService;
	//库存
	@Autowired
	private StockService stockService ;
	@Autowired
	private StocklogService stocklogService;
	@Autowired
	private RefractivityService refractivityService;



	@GetMapping()
	@RequiresPermissions("stock:tuihuo:tuihuo")
	String Tuihuo(){
	    return "stock/tuihuo/tuihuo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tuihuo:tuihuo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		if (null != ShiroUtils.getUser().getCompanyId()){
			if(ShiroUtils.getUser().getCompanyId().equals("3")){
				query.put("companyId","");
			}else {
				query.put("companyId",ShiroUtils.getUser().getCompanyId());
			}
		}
		List<TuihuoDO> tuihuoList = tuihuoService.orderList(query);
		int total = tuihuoService.orderCount(query);
		PageUtils pageUtils = new PageUtils(tuihuoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tuihuo:add")
	String add(Model model){
		Long uuid = GuuidUtil.getUUID();
		String uuidstr = "EOP" + uuid.toString();
		model.addAttribute("uuidstr", uuidstr);
		model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String danjuDay = sdf.format(date);
		model.addAttribute("danjuDay", danjuDay);
		Map<String, Object> map = new HashMap<>();
		if (null != ShiroUtils.getUser().getCompanyId()){
			if(ShiroUtils.getUser().getCompanyId().equals("3")){
				map.put("companyId","");
			}else {
				map.put("companyId",ShiroUtils.getUser().getCompanyId());
			}
		}
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
	    return "stock/tuihuo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:tuihuo:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TuihuoDO tuihuo = tuihuoService.get(id);
		model.addAttribute("tuihuo", tuihuo);
	    return "stock/tuihuo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tuihuo:add")
	public R save(StockDO stockDO, TuihuoDO tuihuo){
		String[] shuliangs =tuihuo.getCount().split(",");
		String[] kyshuliangs =tuihuo.getGoodsCount().split(",");
		String[] num =tuihuo.getGoodsNum().split(",");
		String shuliang ;
		String kyshuliang = null;
		for (int i=0; i<num.length;i++){
			try {
				shuliang = shuliangs[i];
				kyshuliang = kyshuliangs[i];
			}catch (ArrayIndexOutOfBoundsException e){
				shuliang="";
			}
			if ("".equals(shuliang)){
				return R.error("数量不能为空！");
			}else if(Integer.valueOf(shuliang) > Integer.valueOf(kyshuliang)){
				return R.error("数量不能大于可用库存！");
			}
		}
		String positionId=stockDO.getPositionId();
		String[] goodsNum1 = stockDO.getGoodsNum().split(",");
		String[] goodsName1 = stockDO.getGoodsName().split(",");
		String[] factory1 = stockDO.getFactory().split(",");
		String[] unit1 = stockDO.getUnit().split(",");
		String[] goodsCount1 = stockDO.getGoodsCount().split(",");
		String[] count1 = stockDO.getCount().split(",");
		String[] goodsCode1 = stockDO.getGoodsCode().split(",");
		String style = stockDO.getStyle();
		String[] retailProce1 = stockDO.getRetailPrice().split(",");
		for (int i = 0; i < goodsNum1.length; i++) {
			StockDO stock = new StockDO();
			stock.setPositionId(stockDO.getPositionId());
			stock.setMfrsid(stockDO.getMfrsid());
			stock.setBrandname(stockDO.getBrandname());
			String goodsNum = goodsNum1[i];
			stock.setGoodsNum(goodsNum);
			String goodsCode = goodsCode1[i];
			stock.setGoodsCode(goodsCode);
			String count = count1[i];
			stock.setCount(count);
			StockDO goodsList = stockService.haveNum(stock);
			if (null != goodsList) {
				String yuancount = goodsList.getGoodsCount();
				Integer counts = Integer.valueOf(count);
				Integer yuancounts = Integer.valueOf(yuancount);
				Integer newCount = yuancounts - counts;
				stock.setGoodsCount(String.valueOf(newCount));
				stockService.updateGoodsCount(stock);
				TuihuoDO tuihuoDO = new TuihuoDO();
				tuihuoDO.setGoodsbrandname(goodsList.getBrandname());
				tuihuoDO.setTuihuoNum(tuihuo.getTuihuoNum());
				tuihuoDO.setZhidanPeople(tuihuo.getZhidanPeople());
				tuihuoDO.setDanjuDay(tuihuo.getDanjuDay());
				tuihuoDO.setMfrsid(tuihuo.getMfrsid());
				tuihuoDO.setPositionId(tuihuo.getPositionId());
				tuihuoDO.setBeizhu(tuihuo.getBeizhu());
				tuihuoDO.setGoodsxinxiid(tuihuo.getGoodsxinxiid());
				tuihuoDO.setGoodsid(goodsList.getGoodsType());
				try {
					tuihuoDO.setGoodsNum(goodsNum);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setGoodsNum("");
				}
				try {
					String goodsName = goodsName1[i];
					tuihuoDO.setGoodsName(goodsName);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setGoodsName("");
				}
				try {
					String factory = factory1[i];
					tuihuoDO.setFactory(factory);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setFactory("");
				}
				try {
					String unit = unit1[i];
					tuihuoDO.setUnit(unit);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setUnit("");
				}
				try {
					String goodsCount = goodsCount1[i];
					tuihuoDO.setGoodsCount(goodsCount);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setGoodsCount("");
				}
				try {
					tuihuoDO.setCount(count);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setCount("");
				}
				try {
					tuihuoDO.setGoodsCode(goodsCode);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setGoodsCode("");
				}
				try {
					tuihuoDO.setStyle(style);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setStyle("");
				}
				try {
					String retailProce = retailProce1[i];
					tuihuoDO.setRetailPrice(retailProce);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setRetailPrice("");
				}
				try {
					String stockorder = goodsList.getDanjuNumber();
					tuihuoDO.setStockorder(stockorder);
				}catch (ArrayIndexOutOfBoundsException e){
					tuihuoDO.setStockorder("");
				}
				StocklogDO stocklogDO=new StocklogDO();
				stocklogDO.setDanjunum(tuihuo.getTuihuoNum());
				stocklogDO.setNum(goodsList.getGoodsNum());
				stocklogDO.setCode(goodsList.getGoodsCode());
				stocklogDO.setName(goodsList.getGoodsName());
				stocklogDO.setGoodsid(goodsList.getGoodsType());
				stocklogDO.setMfrsnum(goodsList.getMfrsid());
				stocklogDO.setBrandname(goodsList.getBrandname());
				stocklogDO.setMoney(goodsList.getRetailPrice());
				stocklogDO.setUseday(goodsList.getUseday());
				stocklogDO.setBacth(goodsList.getBatch());
				stocklogDO.setCounts(String.valueOf(counts));
				stocklogDO.setInpositionId(null);
				stocklogDO.setOutpositionId(Long.valueOf(positionId));
				stocklogDO.setZhidanPeople(tuihuo.getZhidanPeople());
				stocklogDO.setDay(tuihuo.getDanjuDay());
				stocklogDO.setWay(style);
				stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
				stocklogService.save(stocklogDO);
				if (tuihuoService.save(tuihuoDO) < 0) {
					return R.error();
				}
			}
			}


		return R.ok();
}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tuihuo:edit")
	public R update( TuihuoDO tuihuo){
		tuihuoService.update(tuihuo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tuihuo:remove")
	public R remove( Long id){
		if(tuihuoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tuihuo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tuihuoService.batchRemove(ids);
		return R.ok();
	}
	@GetMapping("/findmfrs")
	@RequiresPermissions("stock:tuihuo:findmfrs")
	String findmfrs( Model model) {
		Map<String, Object> map = new HashMap<>();
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		return "/stock/tuihuo/findmfrs";
	}
	@GetMapping("/getGood/{positionId}/{positionName}/{mfrsid}/{mfrsName}")
	String getGood(@PathVariable("positionId") String positionId,@PathVariable("positionName") String positionName,
				   @PathVariable("mfrsid") String  mfrsid,@PathVariable("mfrsName") String mfrsName,Model model) {
		Map<String, Object> map = new HashMap<>();
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		model.addAttribute("positionId", positionId);
		model.addAttribute("positionName", positionName);
		if ("空值".equals(mfrsid)){
			mfrsid="";
		}
		if ("空值".equals(mfrsName)){
			mfrsName="";
		}
		model.addAttribute("mfrsid", mfrsid);
		model.addAttribute("mfrsName", mfrsName);
		List<RefractivityDO> refractivityDOList = refractivityService.list(map);
		model.addAttribute("refractivityDOList", refractivityDOList);
		return "/stock/tuihuo/getGood";
	}

@ResponseBody
@GetMapping("/selectjingjia")
public PageUtils selectjingjia(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);

	List<StockDO> jingjiagoods = tuihuoService.selectJingjia(query);
	int total = tuihuoService.selectJingjiacount(query);
	PageUtils pageUtils = new PageUtils(jingjiagoods, total);
	return pageUtils;
}



@ResponseBody
@GetMapping("/selectpeijian")
//@RequiresPermissions("mfrs:brand:brand")
public PageUtils selectpeijian(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> partsgoods  = tuihuoService.selectPeijian(query);
	int total = tuihuoService.selectPeijiancount(query);
	PageUtils pageUtils = new PageUtils(partsgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectJpcp")
public PageUtils selectJpcp(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> jpcpgoods = tuihuoService.selectJpcp(query);
	int total = tuihuoService.selectJpcpcount(query);
	PageUtils pageUtils = new PageUtils(jpcpgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectJpdz")
//@RequiresPermissions("mfrs:brand:brand")
public PageUtils selectJpdz(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> jpdzgoods = tuihuoService.selectJpdz(query);
	int total = tuihuoService.selectJpdzcount(query);
	PageUtils pageUtils = new PageUtils(jpdzgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectYxcp")
//@RequiresPermissions("mfrs:brand:brand")
public PageUtils selectYxcp(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> yxcpgoods = tuihuoService.selectYxcp(query);
	int total = tuihuoService.selectYxcpcount(query);
	PageUtils pageUtils = new PageUtils(yxcpgoods, total);
	return pageUtils;
}


@ResponseBody
@GetMapping("/selectYxdz")
//@RequiresPermissions("mfrs:brand:brand")
public PageUtils selectYxdz(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> yxdzgoods  = tuihuoService.selectYxdz(query);
	int total = tuihuoService.selectYxdzcount(query);
	PageUtils pageUtils = new PageUtils(yxdzgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectHly")
public PageUtils selecthly(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> hlygoods = tuihuoService.selectHly(query);
	int total = tuihuoService.selectHlycount(query);
	PageUtils pageUtils = new PageUtils(hlygoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectTyj")
//@RequiresPermissions("mfrs:brand:brand")
public PageUtils selecttyj(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> tyjgoods = tuihuoService.selectTyj(query);
	int total = tuihuoService.selectTyjcount(query);
	PageUtils pageUtils = new PageUtils(tyjgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectLhj")
public PageUtils selectLhj(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> lhjgoods = tuihuoService.selectLhj(query);
	int total = tuihuoService.selectLhjcount(query);
	PageUtils pageUtils = new PageUtils(lhjgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectHc")
public PageUtils selectHc(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> hcgoods = tuihuoService.selectHc(query);
	int total = tuihuoService.selectHccount(query);
	PageUtils pageUtils = new PageUtils(hcgoods, total);
	return pageUtils;
}

@ResponseBody
@GetMapping("/selectSg")
public PageUtils selectSg(@RequestParam Map<String, Object> params) {
	//查询列表数据
	Query query = new Query(params);
	List<StockDO> sggoods = tuihuoService.selectSg(query);
	int total = tuihuoService.selectSgcount(query);
	PageUtils pageUtils = new PageUtils(sggoods, total);
	return pageUtils;
}
	@ResponseBody
	@RequestMapping(value = "/selectOrder")
	public List<TuihuoDO> selectOrder(String tuihuoNum, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("tuihuoNum", tuihuoNum);
		List<TuihuoDO> tuihuoDOS = tuihuoService.selectOrder(map);
		model.addAttribute("tuihuoDOS", tuihuoDOS);
		return tuihuoDOS;
	}


	@GetMapping("/danju")
	String danju(String tuihuoNum, Model model) {
		TuihuoDO tuihuoDO = tuihuoService.getDanju(tuihuoNum);
		model.addAttribute("tuihuoDO", tuihuoDO);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String newday = sdf.format(date);
		model.addAttribute("newday", newday);
		return "/stock/tuihuo/danju";
	}
	@ResponseBody
	@RequestMapping(value = "/getDanjuList")
	public List<TuihuoDO> getDanjuList(String tuihuoNum, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("tuihuoNum", tuihuoNum);
		List<TuihuoDO> danjuList = tuihuoService.getDanjuList(map);
		model.addAttribute("danjuList", danjuList);
		return danjuList;
	}


	@ResponseBody
	@GetMapping("/countall")
	public Integer countall(
			@RequestParam("tuihuoNum") String tuihuoNum, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("tuihuoNum",tuihuoNum);
		int total=tuihuoService.countall(map);
		model.addAttribute("total",total);
		return total;
	}



	@GetMapping("/barcode/{positionId}/{mfrsname}")
	String barcode(    @PathVariable("positionId") String positionId,@PathVariable("mfrsname") String mfrsname,
					   Model model){
		model.addAttribute("positionId",positionId);
		model.addAttribute("mfrsname",mfrsname);
		return "stock/tuihuo/barcode";
	}

	@ResponseBody
	@RequestMapping(value = "/codeList")
	List<?> codeList(String positionId,String mfrsname, String goodsCode,  Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("positionId",positionId);
		if ("空值".equals(mfrsname)){
			mfrsname="";
		}
		map.put("mfrsname",mfrsname);
		map.put("goodsCode",goodsCode);
		List<StockDO> stockDOS = stockService.kccxList(map);
		return stockDOS;
	}

}
