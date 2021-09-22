package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.baseinfomation.service.impl.DepartmentServiceImpl;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.HcDO;
import com.shiguang.stock.domain.OrderDO;
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

import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;

/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */
 
@Controller
@RequestMapping("/stock/pidiao")
public class PidiaoController {
	@Autowired
	private PidiaoService pidiaoService;
	//部门
	@Autowired
	private DepartmentService departmentService;
	//公司
	@Autowired
	private CompanyService companyService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	//仓位
	@Autowired
	private PositionService positionService;
	//库存
	@Autowired
	private StockService stockService;
	@GetMapping()
	@RequiresPermissions("stock:pidiao:pidiao")
	String Pidiao(){
	    return "stock/pidiao/pidiao";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:pidiao:pidiao")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		//———获取当前登录用户的公司id————
		String companyId = "";
		String departNumber="";
		if(null != ShiroUtils.getUser().getCompanyId()){
			companyId = ShiroUtils.getUser().getCompanyId();
			query.put("companyId",companyId);
		}else if (companyId == ""){
			departNumber=ShiroUtils.getUser().getStoreNum();
			query.put("departNumber",departNumber);
		}


		List<PidiaoDO> pidiaoList = pidiaoService.list(query);
		for (PidiaoDO pidiaoDO:pidiaoList){
			if(companyId != ""){
				if (companyId.equals(pidiaoDO.getInCompanyid())){
					pidiaoDO.setFlags("0");
				} else {
					pidiaoDO.setFlags("1");
				}
			}
			if (departNumber .equals(pidiaoDO.getOutDepartmentid())){
				pidiaoDO.setFlags("1");//发出部门

			}
			if (departNumber.equals(pidiaoDO.getInDepartmentid())){
				pidiaoDO.setFlags("0");//接收部门
			}


		}
		int total = pidiaoService.count(query);
		PageUtils pageUtils = new PageUtils(pidiaoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:pidiao:add")
	String add(Model model){
		//———生成单据编号————
		Long uuid = GuuidUtil.getUUID();
		String pidiaoNum = "PD" + uuid.toString();
		model.addAttribute("pidiaoNum", pidiaoNum);
		//部门
		Map<String, Object> map = new HashMap<>();
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			String departNumber=ShiroUtils.getUser().getStoreNum();
			map.put("departNumber",departNumber);
		}else if (companyId != null){
			map.put("companyId",companyId);
		}
		map.put("status","0");
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList", departmentDOList);

		map.put("xsstate",0);
		List<CompanyDO> companyList = companyService.list(map);
		model.addAttribute("companyList", companyList);
		//———获取当前登录用户的名称————
		model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String newDate = sdf.format(date);
		model.addAttribute("danjuDay", newDate);
		return "stock/pidiao/add";
	}
	//发出仓位
	@ResponseBody
	@RequestMapping(value = "/outposion")
	public List<PidiaoDO> outposion(String outDepartment, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("outDepartment", outDepartment);
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
		return outPositiion;
	}
	//接收部门
	@ResponseBody
	@RequestMapping(value = "/indepartment")
	public List<PidiaoDO> indepartment(String inCompany, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("inCompany", inCompany);
		List<PidiaoDO> indepartment = pidiaoService.indepartment(map);
		model.addAttribute("indepartment", indepartment);
		return indepartment;
	}
	//接收仓位
	@ResponseBody
	@RequestMapping(value = "/inposion")
	public List<PidiaoDO> inposion(String inDepartment, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("inDepartment", inDepartment);
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
		return outPositiion;
	}
	//跳转库存查询
	@GetMapping("/selextkc/{outPosition}")
	String selextkc(@PathVariable("outPosition") String outPosition,Model model) {
		Map<String, Object> map = new HashMap<>();
		//商品
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		//仓位
		map.put("xsstate", 0);
		List<PositionDO> positionList = positionService.positionList(map);
		model.addAttribute("positionList", positionList);
		model.addAttribute("outPosition", outPosition);
		return "/stock/pidiao/selectGoods";
	}


	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:pidiao:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PidiaoDO pidiao = pidiaoService.get(id);
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = pidiao.getDanjuDay();
		String danjuDay = sdftime.format(time);
		model.addAttribute("danjuDay", danjuDay);
		model.addAttribute("pidiao", pidiao);
	    return "stock/pidiao/edit";
	}
	@ResponseBody
	@RequestMapping(value = "/selectPidiao")
	public List<PidiaoDO> selectPidiao(String pidiaoNumber, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("pidiaoNumber", pidiaoNumber);
		List<PidiaoDO> pidiaoDOList = pidiaoService.selectPidiao(map);
		model.addAttribute("pidiaoDOList", pidiaoDOList);
		return pidiaoDOList;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:pidiao:add")
	public R save( PidiaoDO pidiao,StockDO stockDO){
		String pidiaoNumber=pidiao.getPidiaoNumber();
		String zhidanPeople=pidiao.getZhidanPeople();
		Date danjuDay=pidiao.getDanjuDay();
		String outDepartment=pidiao.getOutDepartment();
		String outPosition=pidiao.getOutPosition();
		String inCompany=pidiao.getInCompany();
		String inDepartment=pidiao.getInDepartment();
		String inPosition=pidiao.getInPosition();
		String beizhu=pidiao.getBeizhu();
		String status=pidiao.getStatus();
		String shTime=pidiao.getShTime();
		String retyrnzt=pidiao.getReturnzt();


		String str = pidiao.getGoodsNum();
		String[] name = str.split(",");
		String[] goodsName1= pidiao.getGoodsName().split(",");
		String[] factory1= pidiao.getFactory().split(",");
		String[] goodsCount1=  pidiao.getGoodsCount().split(",");
		String[] useCount1=  pidiao.getUseCount().split(",");
		String[] goodsCode1= pidiao.getGoodsCode().split(",");
		String[] useday1=pidiao.getUseday().split(",");
		String[] batch1=pidiao.getBatch().split(",");
		String[] zhuceNumber1= pidiao.getZhuceNumber().split(",");
		String[] produceDay1=pidiao.getProduceDay().split(",");
		String[] classtype1=pidiao.getClasstype().split(",");

		String[] goods1=pidiao.getGoods().split(",");


		String[] mfrsid1=pidiao.getMfrsid().split(",");
		String[] brandname1=pidiao.getBrandname().split(",");
		String[] unit1=pidiao.getUnit().split(",");
		String[] money1=pidiao.getMoney().split(",");
		String[] goodsxinxiid1=pidiao.getGoodsxinxiid().toString().split(",");

		for (int i = 0; i < name.length; i++) {
			PidiaoDO pidiaoDO = new PidiaoDO();
			pidiaoDO.setPidiaoNumber(pidiaoNumber);
			pidiaoDO.setZhidanPeople(zhidanPeople);
			pidiaoDO.setDanjuDay(danjuDay);
			pidiaoDO.setOutDepartmentid(outDepartment);
			pidiaoDO.setOutPositionid(outPosition);
			pidiaoDO.setInCompanyid(inCompany);
			pidiaoDO.setInDepartmentid(inDepartment);
			pidiaoDO.setInPositionid(inPosition);
			pidiaoDO.setBeizhu(beizhu);
			pidiaoDO.setStatus(status);
			pidiaoDO.setShTime(shTime);
			pidiaoDO.setReturnzt(retyrnzt);


			String goodsNum = name[i];
			pidiaoDO.setGoodsNum(goodsNum);
			String goodsName = goodsName1 [i];
			pidiaoDO.setGoodsName(goodsName);

			try {
				String factory = factory1[i];
				pidiaoDO.setFactory(factory);
			}catch (ArrayIndexOutOfBoundsException e){
				pidiaoDO.setFactory("");
			}

			String goodsCount = goodsCount1[i];
			pidiaoDO.setGoodsCount(goodsCount);
			String useCount = useCount1 [i];
			pidiaoDO.setUseCount(useCount);

			String goodsCode =goodsCode1[i];
			pidiaoDO.setGoodsCode(goodsCode);
			try {
				String useday =useday1[i];
				pidiaoDO.setUseday(useday);
			}catch (ArrayIndexOutOfBoundsException e){
				pidiaoDO.setUseday("");
			}
			try {
				String batch = batch1[i];
				pidiaoDO.setBatch(batch);
			}catch (ArrayIndexOutOfBoundsException e){
				pidiaoDO.setBatch("");
			}
			try {
				String zhuceNumber =zhuceNumber1[i];
				pidiaoDO.setZhuceNumber(zhuceNumber);
			}catch (ArrayIndexOutOfBoundsException e){
				pidiaoDO.setZhuceNumber("");
			}
			try {
				String produceDay = produceDay1 [i];
				pidiaoDO.setProduceDay(produceDay);
			}catch (ArrayIndexOutOfBoundsException e){
				pidiaoDO.setProduceDay("");
			}





			if(null != pidiao.getClasstype()){
				try {
					String classtype = classtype1[i];
					pidiaoDO.setClasstype(classtype);
				}catch (ArrayIndexOutOfBoundsException e){
					pidiaoDO.setClasstype("");
				}
			}else{
				pidiaoDO.setClasstype("");
			}



			String goods =goods1[i];
			pidiaoDO.setGoods(goods);


			String mfrsid =mfrsid1[i];
			pidiaoDO.setMfrsid(mfrsid);
			String brandname = brandname1[i];
			pidiaoDO.setBrandname(brandname);
			String unit = unit1[i];
			pidiaoDO.setUnit(unit);
			String money = money1[i];
			pidiaoDO.setMoney(money);

			String goodsxinxiid= goodsxinxiid1[i];
			pidiaoDO.setGoodsxinxiid(goodsxinxiid);

			pidiaoService.save(pidiaoDO);


			//减库存
			stockDO.setPositionId(pidiao.getOutPosition());
			stockDO.setGoodsNum(goodsNum);
			stockDO.setGoodsCode(goodsCode);
			StockDO jianJJGoodsList = stockService.haveNum(stockDO);
			if (null != jianJJGoodsList) {
				String gdcount = jianJJGoodsList.getGoodsCount();
				Integer goodsCountNew = Integer.valueOf(useCount);
				Integer gdcountNew = Integer.valueOf(gdcount);
				Integer newGoodsCount = gdcountNew - goodsCountNew;
				stockDO.setGoodsCount(String.valueOf(newGoodsCount));

				stockService.updateGoodsCount(stockDO);//修改数量
			}

			//加库存
			stockDO.setPositionId(pidiao.getInPosition());
			stockDO.setGoodsNum(goodsNum);
			StockDO jiaGoodsList = stockService.haveNum(stockDO);
			if (null != jiaGoodsList){
				String gdcount = jiaGoodsList.getGoodsCount();
				Integer goodsCountNew = Integer.valueOf(useCount);
				Integer gdcountNew = Integer.valueOf(gdcount);
				Integer newGoodsCount = gdcountNew + goodsCountNew;
				stockDO.setGoodsCount(String.valueOf(newGoodsCount));
				stockService.updateGoodsCount(stockDO);//修改数量
			}else {
				stockDO.setGoodsCode(goodsCode);
				stockDO.setGoodsName(goodsName);
				stockDO.setGoodsCount(useCount);



				stockDO.setGoodsType(Integer.valueOf(goods));


				stockDO.setMfrsid(Integer.valueOf(mfrsid));
				stockDO.setBrandname(brandname);
				stockDO.setUnit(unit);
				stockDO.setRetailPrice(money);
				stockDO.setStatus("1");
				stockDO.setReturnzt(retyrnzt);
				stockDO.setDanjuNumber(pidiaoNumber);
				stockDO.setCreateTime(danjuDay);
				stockDO.setDanjuDay(danjuDay);

				try {
					String useday =useday1[i];
					stockDO.setUseday(useday);
				}catch (ArrayIndexOutOfBoundsException e){
					stockDO.setUseday("");
				}
				try {
					String batch = batch1[i];
					stockDO.setBatch(batch);
				}catch (ArrayIndexOutOfBoundsException e){
					stockDO.setBatch("");
				}
				try {
					String zhuceNumber =zhuceNumber1[i];
					stockDO.setZhuceNumber(zhuceNumber);
				}catch (ArrayIndexOutOfBoundsException e){
					stockDO.setZhuceNumber("");
				}
				try {
					String produceDay = produceDay1 [i];
					stockDO.setProduceDay(produceDay);
				}catch (ArrayIndexOutOfBoundsException e){
					stockDO.setProduceDay("");
				}




				if(null != pidiao.getClasstype()){
					String classtype = classtype1[i];
					stockDO.setClasstype(classtype);
				}else{
					stockDO.setClasstype("");
				}
				try {
					String factory = factory1[i];

					stockDO.setFactory(factory);
				}catch (ArrayIndexOutOfBoundsException e){
					stockDO.setFactory("");
				}
				stockDO.setGoodsxinxiid(goodsxinxiid);

				if (stockService.save(stockDO) < 0) {
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
	@RequiresPermissions("stock:pidiao:edit")
	public R update( PidiaoDO pidiao){
		pidiaoService.update(pidiao);
		return R.ok();
	}
	
	/**
	 * 退回
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:remove")
	public R remove( String pidiaoNumber ){
		Map<String, Object> map = new HashMap<>();
		map.put("pidiaoNumber", pidiaoNumber);
		List<PidiaoDO> returnList =pidiaoService.returnList(map);
		for (PidiaoDO pidiaoDO:returnList){

			StockDO stockDO = new StockDO();
			String goodsNum=pidiaoDO.getGoodsNum();
			stockDO.setGoodsNum(goodsNum);
			String positionId = pidiaoDO.getOutPositionid();
			stockDO.setPositionId(positionId);
			String useCount = pidiaoDO.getUseCount();//退回数量
			StockDO returnJia = stockService.haveNum(stockDO);
			if (null != returnJia){
				String kcCount  = returnJia.getGoodsCount();
				Integer returnCount = Integer.valueOf(useCount);
				Integer kccountall = Integer.valueOf(kcCount);
				Integer newCount = kccountall + returnCount;
				stockDO.setGoodsCount(String.valueOf(newCount));
				stockDO.setReturnzt("0");
				//———退货号————
				String tuihuoNumber = pidiaoDO.getPidiaoNumber();
				stockDO.setTuihuoNumber(tuihuoNumber);
				stockService.updateGoodsCount(stockDO);//修改数量
				pidiaoDO.setReturnzt("0");
				pidiaoService.updatereturnzt(pidiaoDO);

			}else {
				String goodsCode = pidiaoDO.getGoodsCode();
				stockDO.setGoodsCode(goodsCode);
				String goodsName =pidiaoDO.getGoodsName();
				stockDO.setGoodsName(goodsName);
				stockDO.setGoodsCount(useCount);
				String goodsType= pidiaoDO.getGoodsType();
				stockDO.setGoodsType(Integer.valueOf(goodsType));
				String mfrsid = pidiaoDO.getMfrsid();
				stockDO.setMfrsid(Integer.valueOf(mfrsid));
				String brandname=pidiaoDO.getBrandname();
				stockDO.setBrandname(brandname);
				String unit =pidiaoDO.getUnit();
				stockDO.setUnit(unit);
				String retailPrice = pidiaoDO.getRetailPrice();
				stockDO.setRetailPrice(retailPrice);
				Date createTime=pidiaoDO.getCreateTime();
				stockDO.setCreateTime(createTime);
				String danjuNumber = pidiaoDO.getPidiaoNumber();
				stockDO.setDanjuNumber(danjuNumber);
				String zhidanPeople = pidiaoDO.getZhidanPeople();
				stockDO.setZhidanPeople(zhidanPeople);
				Date danjuDay = pidiaoDO.getCreateTime();
				stockDO.setDanjuDay(danjuDay);
				String zhuceNumber = pidiaoDO.getZhuceNumber();
				stockDO.setZhuceNumber(zhuceNumber);
				String classtype = pidiaoDO.getClasstype();
				stockDO.setClasstype(classtype);
				String factory = pidiaoDO.getFactory();
				stockDO.setFactory(factory);
				stockDO.setStatus("0");
				stockDO.setReturnzt("0");
				//———退货号————
				String tuihuoNumber = pidiaoDO.getPidiaoNumber();
				stockDO.setTuihuoNumber(tuihuoNumber);
				String username= pidiaoDO.getUsername();
				stockDO.setUsername(username);
				if (stockService.save(stockDO) < 0) {
					return R.error();
				}
				pidiaoDO.setReturnzt("0");
				pidiaoService.updatereturnzt(pidiaoDO);
			}

		}
		return R.ok();
	}
	//打印
	@GetMapping("/pidiaodan")
	@RequiresPermissions("stock:pidiao:pidiaodan")
	String pidiaodan(String pidiaoNumber, Model model) {
		PidiaoDO getpidiao = pidiaoService.getpidiao(pidiaoNumber);
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = getpidiao.getDanjuDay();
		String danjuDay = sdftime.format(time);
		model.addAttribute("danjuDay", danjuDay);
		model.addAttribute("getpidiao", getpidiao);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String newday = sdf.format(date);
		model.addAttribute("newday", newday);
		return "/stock/pidiao/pidiaodan";
	}
	//打印List
	@ResponseBody
	@RequestMapping(value = "/getpidiaoList")
	public List<PidiaoDO> getpidiaoList(String pidiaoNumber, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("pidiaoNumber", pidiaoNumber);
		List<PidiaoDO> pidiaoDOList = pidiaoService.getpidiaoList(map);
		model.addAttribute("pidiaoDOList", pidiaoDOList);
		return pidiaoDOList;
	}

	/**
	 * 工号
	 */
	@GetMapping("/userNum/{pidiaoNumber}")
	String userNum(@PathVariable("pidiaoNumber") String pidiaoNumber ,Model model) {
		model.addAttribute("pidiaoNumber",pidiaoNumber);
		return "/stock/pidiao/userNum";
	}
	/**
	 * 启用状态
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus")
	public R updateEnable(String pidiaoNumber, String status ,String username) {
		PidiaoDO pidiaoDO = new PidiaoDO();
		pidiaoDO.setPidiaoNumber(pidiaoNumber);
		pidiaoDO.setStatus(status);
		pidiaoDO.setUsername(username);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String shTime = sdf.format(date);
		pidiaoDO.setShTime(shTime);
		pidiaoService.updateStatus(pidiaoDO);

		StockDO stockDO = new StockDO();
		stockDO.setDanjuNumber(pidiaoNumber);
		stockDO.setStatus(status);
		stockDO.setUsername(username);
		stockDO.setZhidanPeople(username);
		stockService.updateStatus(stockDO);

		return R.ok();
	}
}
