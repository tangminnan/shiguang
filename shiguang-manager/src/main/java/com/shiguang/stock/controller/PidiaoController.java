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
		List<PidiaoDO> pidiaoList = pidiaoService.list(query);
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
		model.addAttribute("pidiao", pidiao);
	    return "stock/pidiao/edit";
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


		String str = pidiao.getGoodsNum();
		String[] name = str.split(",");
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


			String goodsNum = name[i];
			pidiaoDO.setGoodsNum(goodsNum);
			String goodsName =pidiao.getGoodsName().split(",")[i];
			pidiaoDO.setGoodsName(goodsName);
			String factory =pidiao.getFactory().split(",")[i];
			pidiaoDO.setFactory(factory);
			String goodsCount =pidiao.getGoodsCount().split(",")[i];
			pidiaoDO.setGoodsCount(goodsCount);
			String useCount =pidiao.getUseCount().split(",")[i];
			pidiaoDO.setUseCount(useCount);

			String goodsCode =pidiao.getGoodsCode().split(",")[i];
			pidiaoDO.setGoodsCode(goodsCode);
			String useday =pidiao.getUseday().split(",")[i];
			pidiaoDO.setUseday(useday);
			String batch =pidiao.getBatch().split(",")[i];
			pidiaoDO.setBatch(batch);
			String zhuceNumber =pidiao.getZhuceNumber().split(",")[i];
			pidiaoDO.setZhuceNumber(zhuceNumber);
			String produceDay =pidiao.getProduceDay().split(",")[i];
			pidiaoDO.setProduceDay(produceDay);
			if(null != pidiao.getClasstype()){
				String classtype =pidiao.getClasstype().split(",")[i];
				pidiaoDO.setClasstype(classtype);
			}else{
				pidiaoDO.setClasstype("");
			}
			String goods =pidiao.getGoods().split(",")[i];
			pidiaoDO.setGoods(goods);
			String mfrsid =pidiao.getMfrsid().split(",")[i];
			pidiaoDO.setMfrsid(mfrsid);
			String brandname =pidiao.getBrandname().split(",")[i];
			pidiaoDO.setBrandname(brandname);

			//减库存
			stockDO.setPositionId(pidiao.getOutPosition());
			StockDO goodsNumList = stockService.haveNum(stockDO);
			if (null != goodsNumList) {
				String gdcount = goodsNumList.getGoodsCount();
				Integer goodsCountNew = Integer.valueOf(useCount);
				Integer gdcountNew = Integer.valueOf(gdcount);
				Integer newGoodsCount = gdcountNew - goodsCountNew;
				stockDO.setGoodsCount(String.valueOf(newGoodsCount));

				stockService.updateGoodsCount(stockDO);//修改数量
			}

			//加库存
			String st = stockDO.getGoodsNum();
			String[] name1 = st.split(",");
			for (int i1 = 0; i1 < name1.length; i1++) {
				stockDO.setPositionId(pidiao.getInPosition());
				StockDO goodsList = stockService.haveNum(stockDO);
				if (null != goodsList) {
					String kuCountG = goodsList.getGoodsCount();
					Integer kuNewCount = Integer.valueOf(useCount);
					Integer kuCount = Integer.valueOf(kuCountG);
					Integer kuNew = kuNewCount + kuCount;
					stockDO.setGoodsCount(String.valueOf(kuNew));
					stockService.updateGoodsCount(stockDO);//修改数量
				} else {
					String goodsNum1 = pidiao.getGoodsNum().split(",")[i];
					stockDO.setGoodsNum(goodsNum1);
					String goodsCode1 = pidiao.getGoodsCode().split(",")[i];
					stockDO.setGoodsCode(goodsCode1);
					String goodsName1 = pidiao.getGoodsName().split(",")[i];
					stockDO.setGoodsName(goodsName1);
					String goodsCount1 = pidiao.getUseCount().split(",")[i];
					stockDO.setGoodsCount(goodsCount1);
					String goodsType = pidiao.getGoods().split(",")[i];
					stockDO.setGoodsType(Integer.valueOf(goodsType));
					String mfrsid1 = pidiao.getMfrsid().split(",")[i];


				}

			}
























			pidiaoService.save(pidiaoDO);

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
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:remove")
	public R remove( Long id){
		if(pidiaoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		pidiaoService.batchRemove(ids);
		return R.ok();
	}
	
}
