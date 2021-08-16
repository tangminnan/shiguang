package com.shiguang.settlement.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.ResultService;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
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
 * 结款管理
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
 
@Controller
@RequestMapping("/information/settlement")
public class SettlementController {
	@Autowired
	private SettlementService settlementService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CostService costService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private ResultService resultService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private MailInfoService mailInfoService;
	
	@GetMapping()
	@RequiresPermissions("information:settlement:settlement")
	String Settlement(){
	    return "settlement/settlement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:settlement:settlement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
		query.put("state",1);
		List<MemberDO> memberDOList = memberService.payList(query);
		int total = memberService.payCount(query);
		PageUtils pageUtils = new PageUtils(memberDOList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:settlement:add")
	String add(){
	    return "settlement/add";
	}

	@GetMapping("/edit/{cardNumber}/{saleNumber}")
	@RequiresPermissions("information:settlement:edit")
	String edit(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber,Model model){
		MemberDO memberDO = memberService.getCardNumber(cardNumber);
		model.addAttribute("memberDO",memberDO);
		//List<CostDO> costDOList = costService.getMemberNum(cardNumber);
		//CostDO costDO = costService.get(costId);
		Map<String,Object> map = new HashMap<>();
		map.put("saleNumber",saleNumber);
		List<CostDO> costDOList = costService.list(map);
		Double sumMoney =0.00;
		CostDO costDO = new CostDO();
		for (CostDO costDO1 : costDOList){
			if (null != costDO1.getCostMoney()){
				if (null != costDO1.getCostMoney()){
					sumMoney = sumMoney + costDO1.getCostMoney();
					costDO1.setSumMoney(sumMoney);
					costDO = new CostDO();
					costDO.setId(costDO1.getId());
					costDO.setMemberNumber(costDO1.getMemberNumber());
					costDO.setSaleNumber(costDO1.getSaleNumber());
					costDO.setSumMoney(sumMoney);
					costDO.setSaleName(costDO1.getSaleName());
				}
			}
		}

		model.addAttribute("costDO",costDO);
//		SettlementDO settlement = settlementService.get(id);
//		model.addAttribute("settlement", settlement);
	    return "settlement/edit";
	}

	@GetMapping("/editMoney/{cardNumber}")
	@RequiresPermissions("information:settlement:editMoney")
	String editMoney(@PathVariable("cardNumber") String cardNumber,Model model){
		MemberDO memberDO = memberService.getCardNumber(cardNumber);
		model.addAttribute("memberDO",memberDO);
		CostDO costDO = new CostDO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = new HashMap<>();
		map.put("cardNumber",cardNumber);
		String dt = sdf.format(date) + " 00:00:00";
		map.put("dateTime",dt);
		SalesDO salesDO = salesService.findDataByNumber(map);
		costDO.setMemberNumber(salesDO.getMemberNumber());
		costDO.setSaleNumber(salesDO.getSaleNumber());
		costDO.setSumMoney(salesDO.getAmountMoney());
		costDO.setSaleName(salesDO.getSaleName());
		model.addAttribute("costDO",costDO);
		return "settlement/jsedit";
	}

	@GetMapping("/detail/{cardNumber}/{saleNumber}/{costId}")
	@RequiresPermissions("information:settlement:detail")
	String detail(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber,@PathVariable("costId") Long costId,Model model){
		MemberDO memberDO = memberService.getCardNumber(cardNumber);
		model.addAttribute("memberDO",memberDO);
//		CostDO costDO = costService.get(costId);
		Map<String,Object> map = new HashMap<>();
		map.put("saleNumber",saleNumber);
		List<CostDO> costDOList = costService.list(map);
		Double sumMoney =0.00;
		CostDO costDO = new CostDO();
		for (CostDO costDO1 : costDOList){
			if (null != costDO1.getCostMoney()){
				if (null != costDO1.getCostMoney()){
					sumMoney = sumMoney + costDO1.getCostMoney();
					costDO1.setSumMoney(sumMoney);
					costDO = new CostDO();
					costDO.setId(costDO1.getId());
					costDO.setMemberNumber(costDO1.getMemberNumber());
					costDO.setSaleNumber(costDO1.getSaleNumber());
					costDO.setSumMoney(sumMoney);
					costDO.setSaleName(costDO1.getSaleName());
				}
			}
		}
//		if (null != costDO.getCostMoney()) {
//			if (null != costDO.getCostMoney()){
//				sumMoney = sumMoney + costDO.getCostMoney();
//				costDO.setSumMoney(sumMoney);
//			}
//		}
		model.addAttribute("costDO",costDO);
		SettlementDO settlement = settlementService.getCostId(costId);
		//List<SettlementDO> settlement = settlementService.list(map);

		model.addAttribute("settlement", settlement);
		return "settlement/detail";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:settlement:add")
	public R save(SettlementDO settlement){
		CostDO costDO = new CostDO();
		//costDO.setMemberNumber(settlement.getMemberNumber());
		costDO.setIsSale(1L);
		costDO.setSaleNumber(settlement.getSaleNumber());
		//costDO.setId(settlement.getCostId());
		costService.updateMember(costDO);
		if(settlementService.save(settlement)>0){
			return R.ok();
		}
		return R.error();
	}

    /**
     * 检查单打印
     * @param saleNumber
     * @param model
     * @return
     */
	@GetMapping("/jianchadayin")
	public String jianchadayin(String saleNumber, Model model) {
	    Map<String,Object> map = new HashMap<>();
	    map.put("saleNumber",saleNumber);
		List<CostDO> costDOList = costService.list(map);
		model.addAttribute("costDOList",costDOList);
		Double sumMoney =0.00;
		String jianchaDate="";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for (CostDO costDO : costDOList){
			sumMoney =sumMoney+costDO.getCostMoney();
		}
		model.addAttribute("sumMoney",sumMoney);
		model.addAttribute("jianchaTime",simpleDateFormat.format(new Date()));
		return "settlement/jianchadan";
	}

	/**
	 * 配镜单打印
	 * @param saleNumber
	 * @param model
	 * @return
	 */
	@GetMapping("/peijingdan")
	public String peijingdan(String saleNumber, Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("saleNumber",saleNumber);
//		List<CostDO> costDOList = costService.list(map);
//		model.addAttribute("costDOList",costDOList);
//		Double sumMoney =0.00;
//		String jianchaDate="";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		for (CostDO costDO : costDOList){
//			sumMoney =sumMoney+costDO.getCostMoney();
//		}
//		model.addAttribute("sumMoney",sumMoney);
//		model.addAttribute("jianchaTime",simpleDateFormat.format(new Date()));
		SalesDO settlementDO = salesService.getSaleNumber(saleNumber);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
		if (settlementDO.getSex() == 0){
			settlementDO.setSexx("男");
		} else if (settlementDO.getSex() == 1){
			settlementDO.setSexx("女");
		}
		model.addAttribute("settlementDO",settlementDO);
		DepartmentDO departmentDO = departmentService.getDepartName(settlementDO.getStoreNum());
		if (null != departmentDO){
			model.addAttribute("departmentDO",departmentDO);
		} else {
			DepartmentDO departmentDO1 = new DepartmentDO();
			departmentDO1.setDepartAddress("");
			departmentDO1.setDepartTel("");
			model.addAttribute("departmentDO",departmentDO1);
		}
		MailInfoDO mailInfoDO = mailInfoService.getMailAddress(settlementDO.getSaleNumber());
		if (null != mailInfoDO){
			model.addAttribute("address",mailInfoDO.getAddress());
		} else {
			model.addAttribute("address","");
		}
		SettlementDO settlementDO1 = settlementService.getSaleNumers(saleNumber);
		if (null != settlementDO1){
			if (settlementDO1.getPayModel() == 0){
				model.addAttribute("paymodel","微信");
			} else if (settlementDO1.getPayModel() == 1){
				model.addAttribute("paymodel","支付宝");
			} else if (settlementDO1.getPayModel() == 2){
				model.addAttribute("paymodel","医院收费处");
			} else if (settlementDO1.getPayModel() == 3){
				model.addAttribute("paymodel","一卡通");
			}
		}
		model.addAttribute("settlementDO1",settlementDO1);
		Map<String,Object> map2 = new HashMap<>();
		map2.put("cardNumber",settlementDO.getMemberNumber());
		List<Conclusion> conclusionList = salesService.conclusionList(map2);
		Conclusion conclusion = new Conclusion();
		if (null != conclusionList && conclusionList.size() > 0){
			conclusion.setRightsph(conclusionList.get(0).getRightsph());
			conclusion.setRightcyl(conclusionList.get(0).getRightcyl());
			conclusion.setRightzx(conclusionList.get(0).getRightzx());
			if (null != conclusionList.get(0).getRightyytj()){
				conclusion.setRightyytj(conclusionList.get(0).getRightyytj());
			} else {
				conclusion.setRightyytj(conclusionList.get(0).getRightjytj());
			}
			conclusion.setRighttg(conclusionList.get(0).getRighttg());
			conclusion.setRightprism(conclusionList.get(0).getRightprism());
			conclusion.setRightjd(conclusionList.get(0).getRightjd());
			conclusion.setLeftsph(conclusionList.get(0).getLeftsph());
			conclusion.setLeftcyl(conclusionList.get(0).getLeftcyl());
			conclusion.setLeftzx(conclusionList.get(0).getLeftzx());
			if (null != conclusionList.get(0).getLeftyytj()){
				conclusion.setLeftyytj(conclusionList.get(0).getLeftyytj());
			} else {
				conclusion.setLeftyytj(conclusionList.get(0).getLeftjytj());
			}
			conclusion.setLefttg(conclusionList.get(0).getLefttg());
			conclusion.setLeftprism(conclusionList.get(0).getLeftprism());
			conclusion.setLeftjd(conclusionList.get(0).getLeftjd());
		}
		model.addAttribute("conclusion",conclusion);
//		String goodsName = settlementDO.getStoreName();
//		String unit = settlementDO.getUnit();
//		String storeCount = settlementDO.getStoreCount();
//		String storeUnit = settlementDO.getStoreUnit();
//		String[] unitastr = unit.split(",");
//		String[] goods = goodsName.split(",");
//		String[] countstr = storeCount.split(",");
//		String[] storeUnitstr = storeUnit.split(",");
//		List<String> goodsNameList = new ArrayList<>();
//		for (int i=0;i<goods.length;i++){
//			goodsNameList.add(goods[i]);
//		}
//		model.addAttribute("goodsNameList",goodsNameList);
		//ResultDO resultDO = resultService.
		List<String> processList = new ArrayList<>();
		String processAsk = settlementDO.getProcessAsk();
		if (null != processAsk){
			String[] processStr = processAsk.split(",");
			for (int i=0;i<processStr.length;i++){
				processList.add(processStr[i]);
			}
			model.addAttribute("processList",processList);
		} else {
			model.addAttribute("processList","");
		}

		List<String> additionalCostList = new ArrayList<>();
		String additionalCost = settlementDO.getAdditionalCost();
		if (null != additionalCost){
			String[] addCostStr = additionalCost.split(",");
			for (int l=0;l<addCostStr.length;l++){
				additionalCostList.add(addCostStr[l]);
			}
			model.addAttribute("additionalCostList",additionalCostList);
		} else {
			model.addAttribute("additionalCostList","");
		}


		String addPrice = settlementDO.getAdditionalPrice();
		Double priceSum = 0.00;
		if (null != addPrice){
			String[] addPriceStr = addPrice.split(",");
			for (int d=0;d<addPriceStr.length;d++){
				String price = addPriceStr[d];
				priceSum = priceSum+Double.parseDouble(price);
			}
			model.addAttribute("priceSum",priceSum);
		} else {
			model.addAttribute("priceSum","");
		}
		String addCount = settlementDO.getAdditionalCount();
		Integer countSum=0;
		if (null != addCount){
			String[] addCountStr = addCount.split(",");
			for (int f=0;f<addCountStr.length;f++){
				String count = addCountStr[f];
				countSum = countSum + Integer.parseInt(count);
			}
			model.addAttribute("countSum",countSum);
		} else {
			model.addAttribute("countSum","");
		}

		return "settlement/peijingdan";
	}

		/**
         * 修改
         */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:settlement:edit")
	public R update( SettlementDO settlement){
		settlementService.update(settlement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:settlement:remove")
	public R remove( Long id){
		if(settlementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:settlement:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		settlementService.batchRemove(ids);
		return R.ok();
	}
	
}
