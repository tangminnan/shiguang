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
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.service.LogStatusService;
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
	@Autowired
	private KjyyService kjyyService;
	@Autowired
	private KjjyService kjjyService;
	@Autowired
	private RxjmjcjService rxjmjcjService;
	@Autowired
	private SgjjService sgjjService;
	@Autowired
	private SjxlService sjxlService;
	@Autowired
	private ZyService zyService;
	@Autowired
	private LogStatusService logStatusService;
	
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
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyid",ShiroUtils.getUser().getCompanyId());
		}
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
					if (null == costDO1.getOriginalPrice()){
						costDO.setOriginalPrice(sumMoney);
					} else {
						costDO.setOriginalPrice(costDO1.getOriginalPrice());
					}
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
//		if ("0".equals(settlement.getPayModel())){
//			settlement.setPayModel("微信");
//		} else if ("1".equals(settlement.getPayModel())){
//			settlement.setPayModel("支付宝");
//		} else if ("2".equals(settlement.getPayModel())){
//			settlement.setPayModel("医院收费处");
//		} else if ("3".equals(settlement.getPayModel())){
//			settlement.setPayModel("一卡通");
//		} else if ("4".equals(settlement.getPayModel())){
//			settlement.setPayModel("现金");
//		}
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
		if ("定金".equals(settlement.getPayWay())){
			costDO.setType("定金单");
		}
		costService.updateMember(costDO);
		settlement.setSaleName(ShiroUtils.getUser().getName());
		settlement.setSettleDate(new Date());
		LogStatusDO logStatusDO = new LogStatusDO();
		logStatusDO.setSaleNumber(settlement.getSaleNumber());
		logStatusDO.setLogisticStatus("销售完成");
		logStatusService.save(logStatusDO);
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
		if (null != settlementDO.getPeijingTime()){
			settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
		}else {
			settlementDO.setPeijingDate("");
		}
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
		Map<String,Object> mailMap = new HashMap<>();
		String dateNow = simpleDateFormat.format(new Date());
		mailMap.put("cardNumber",settlementDO.getMemberNumber());
		mailMap.put("dateNow",dateNow);
		mailMap.put("state",0);
		MailInfoDO mailInfoDO = mailInfoService.getMailAddress(settlementDO.getSaleNumber());
		if (null != mailInfoDO){
			model.addAttribute("address",mailInfoDO.getAddress());
		} else {
			List<MailInfoDO> mailInfoDOS = mailInfoService.getMailAddressByMember(mailMap);
			if (null != mailInfoDOS && mailInfoDOS.size() > 0){
				model.addAttribute("address",mailInfoDOS.get(0).getAddress());
			}else {
				model.addAttribute("address","");
			}
		}
		SettlementDO settlementDO1 = settlementService.getSaleNumers(saleNumber);
		if (null != settlementDO1){
			StringBuffer payModels = new StringBuffer();
			String[] paymodel = settlementDO1.getPayModel().split(",");
			String[] moneyPay = settlementDO1.getModelMoney().split(",");
			for (int i=0;i<paymodel.length;i++){
				if ("0".equals(paymodel[i])){
					model.addAttribute("paymodel","微信");
					payModels.append("微信:"+moneyPay[i]+",");
					//payModels[i]="微信";
				} else if ("1".equals(paymodel[i])){
					model.addAttribute("paymodel","支付宝");
					payModels.append("支付宝:"+moneyPay[i]+",");
				} else if ("2".equals(paymodel[i])){
					model.addAttribute("paymodel","医院收费处");
					payModels.append("医院收费处:"+moneyPay[i]+",");
				} else if ("3".equals(paymodel[i])){
					model.addAttribute("paymodel","一卡通");
					payModels.append("一卡通:"+moneyPay[i]+",");
				} else if ("4".equals(paymodel[i])){
					model.addAttribute("paymodel","现金");
					payModels.append("现金:"+moneyPay[i]+",");
				}
			}
			model.addAttribute("payModels",payModels.deleteCharAt(payModels.length()-1));
		}
		model.addAttribute("settlementDO1",settlementDO1);
		Map<String,Object> map2 = new HashMap<>();
		Conclusion conclusion = new Conclusion();
		map2.put("cardNumber",settlementDO.getMemberNumber());
		map2.put("saleNumber",settlementDO.getSaleNumber());

		if (!"".equals(settlementDO.getOptometrywlName()) && null != settlementDO.getOptometrywlName()){
			model.addAttribute("optometryName",settlementDO.getOptometrywlName());
			if (1 == settlementDO.getRecipelwlType()){
				List<KjjyDO> kjjyDOList = kjjyService.list(map2);
				if (null != kjjyDOList && kjjyDOList.size() > 0){
					conclusion.setRightsph(kjjyDOList.get(0).getKjjySphod());
					conclusion.setRightcyl(kjjyDOList.get(0).getKjjyCylod());
					conclusion.setRightzx(kjjyDOList.get(0).getKjjyAxialod());
					if (null != kjjyDOList.get(0).getKjjyYytjod()){
						conclusion.setRightyytj(kjjyDOList.get(0).getKjjyYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(kjjyDOList.get(0).getKjjyTgod());
					conclusion.setRightprism(kjjyDOList.get(0).getKjjyPrismod());
					conclusion.setRightjd(kjjyDOList.get(0).getKjjyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(kjjyDOList.get(0).getKjjySphos());
					conclusion.setLeftcyl(kjjyDOList.get(0).getKjjyCylos());
					conclusion.setLeftzx(kjjyDOList.get(0).getKjjyAxialos());
					if (null != kjjyDOList.get(0).getKjjyYytjos()){
						conclusion.setLeftyytj(kjjyDOList.get(0).getKjjyYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(kjjyDOList.get(0).getKjjyTgos());
					conclusion.setLeftprism(kjjyDOList.get(0).getKjjyPrismos());
					conclusion.setLeftjd(kjjyDOList.get(0).getKjjyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (2 == settlementDO.getRecipelwlType()){
				List<KjyyDO> kjyyDOList = kjyyService.list(map2);
				if (null != kjyyDOList && kjyyDOList.size() > 0){
					conclusion.setRightsph(kjyyDOList.get(0).getKjyySphod());
					conclusion.setRightcyl(kjyyDOList.get(0).getKjyyCylod());
					conclusion.setRightzx(kjyyDOList.get(0).getKjyyAxialod());
					if (null != kjyyDOList.get(0).getKjyyYytjod()){
						conclusion.setRightyytj(kjyyDOList.get(0).getKjyyYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(kjyyDOList.get(0).getKjyyTgod());
					conclusion.setRightprism(kjyyDOList.get(0).getKjyyPrismod());
					conclusion.setRightjd(kjyyDOList.get(0).getKjyyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(kjyyDOList.get(0).getKjyySphos());
					conclusion.setLeftcyl(kjyyDOList.get(0).getKjyyCylos());
					conclusion.setLeftzx(kjyyDOList.get(0).getKjyyAxialos());
					if (null != kjyyDOList.get(0).getKjyyYytjos()){
						conclusion.setLeftyytj(kjyyDOList.get(0).getKjyyYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(kjyyDOList.get(0).getKjyyTgos());
					conclusion.setLeftprism(kjyyDOList.get(0).getKjyyPrismos());
					conclusion.setLeftjd(kjyyDOList.get(0).getKjyyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (3 == settlementDO.getRecipelwlType()){
				List<SgjjDO> sgjjDOList = sgjjService.list(map2);
				if (null != sgjjDOList && sgjjDOList.size() > 0){
					conclusion.setRightsph(sgjjDOList.get(0).getSgjjSphod());
					conclusion.setRightcyl(sgjjDOList.get(0).getSgjjCylod());
					conclusion.setRightzx(sgjjDOList.get(0).getSgjjAxialod());
					if (null != sgjjDOList.get(0).getSgjjYytjod()){
						conclusion.setRightyytj(sgjjDOList.get(0).getSgjjYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(sgjjDOList.get(0).getSgjjTgod());
					conclusion.setRightprism("");
					conclusion.setRightjd("");
					conclusion.setRightAdd("");
					conclusion.setLeftsph(sgjjDOList.get(0).getSgjjSphos());
					conclusion.setLeftcyl(sgjjDOList.get(0).getSgjjCylos());
					conclusion.setLeftzx(sgjjDOList.get(0).getSgjjAxialos());
					if (null != sgjjDOList.get(0).getSgjjYytjos()){
						conclusion.setLeftyytj(sgjjDOList.get(0).getSgjjYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(sgjjDOList.get(0).getSgjjTgos());
					conclusion.setLeftprism("");
					conclusion.setLeftjd("");
					conclusion.setLeftAdd("");
				}
			} else if (4 == settlementDO.getRecipelwlType()){
				List<ZyDO> zyDOList = zyService.list(map2);
				if (null != zyDOList && zyDOList.size() > 0){
					conclusion.setRightsph(zyDOList.get(0).getZySphod());
					conclusion.setRightcyl(zyDOList.get(0).getZyCylod());
					conclusion.setRightzx(zyDOList.get(0).getZyAxialod());
					if (null != zyDOList.get(0).getZyZytjod()){
						conclusion.setRightyytj(zyDOList.get(0).getZyZytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(zyDOList.get(0).getZyTgod());
					conclusion.setRightprism(zyDOList.get(0).getZyPrismod());
					conclusion.setRightjd(zyDOList.get(0).getZyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(zyDOList.get(0).getZySphos());
					conclusion.setLeftcyl(zyDOList.get(0).getZyCylos());
					conclusion.setLeftzx(zyDOList.get(0).getZyAxialos());
					if (null != zyDOList.get(0).getZyZytjos()){
						conclusion.setLeftyytj(zyDOList.get(0).getZyZytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(zyDOList.get(0).getZyTgos());
					conclusion.setLeftprism(zyDOList.get(0).getZyPrismos());
					conclusion.setLeftjd(zyDOList.get(0).getZyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (5 == settlementDO.getRecipelwlType()){
				List<RxjmjcjDO> rxjmjcjDOList = rxjmjcjService.list(map2);
				if (null != rxjmjcjDOList && rxjmjcjDOList.size() > 0){
					conclusion.setRightsph(rxjmjcjDOList.get(0).getRxSphod());
					conclusion.setRightcyl(rxjmjcjDOList.get(0).getRxCylod());
					conclusion.setRightzx(rxjmjcjDOList.get(0).getRxAxialod());
					conclusion.setRightyytj("");
					conclusion.setRighttg("");
					conclusion.setRightprism("");
					conclusion.setRightjd("");
					conclusion.setRightAdd("");
					conclusion.setLeftsph(rxjmjcjDOList.get(0).getRxSphos());
					conclusion.setLeftcyl(rxjmjcjDOList.get(0).getRxCylos());
					conclusion.setLeftzx(rxjmjcjDOList.get(0).getRxAxialos());
					conclusion.setLeftyytj("");
					conclusion.setLefttg("");
					conclusion.setLeftprism("");
					conclusion.setLeftjd("");
					conclusion.setLeftAdd("");
				}
			} else if (7 == settlementDO.getRecipelwlType()){
				List<SjxlDO> sjxlDOList = sjxlService.list(map2);
				if (null != sjxlDOList && sjxlDOList.size() > 0){
					conclusion.setRightsph(sjxlDOList.get(0).getSjxlSphod());
					conclusion.setRightcyl(sjxlDOList.get(0).getSjxlCylod());
					conclusion.setRightzx(sjxlDOList.get(0).getSjxlAxialod());
					if (null != sjxlDOList.get(0).getSjxlYytjod()){
						conclusion.setRightyytj(sjxlDOList.get(0).getSjxlYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg("");
					conclusion.setRightprism(sjxlDOList.get(0).getSjxlSljod());
					conclusion.setRightjd(sjxlDOList.get(0).getSjxlJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(sjxlDOList.get(0).getSjxlSphos());
					conclusion.setLeftcyl(sjxlDOList.get(0).getSjxlCylos());
					conclusion.setLeftzx(sjxlDOList.get(0).getSjxlAxialos());
					if (null != sjxlDOList.get(0).getSjxlYytjos()){
						conclusion.setLeftyytj(sjxlDOList.get(0).getSjxlYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg("");
					conclusion.setLeftprism(sjxlDOList.get(0).getSjxlSljos());
					conclusion.setLeftjd(sjxlDOList.get(0).getSjxlJdos());
					conclusion.setLeftAdd("");
				}
			}
		} else {
			model.addAttribute("optometryName",settlementDO.getOptometryName());
			List<Conclusion> conclusionList = salesService.conclusionList(map2);
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
     * 定金单打印
     * @param saleNumber
     * @param model
     * @return
     */
    @GetMapping("/dingjindan")
    public String dingjindan(String saleNumber, Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
        SalesDO settlementDO = salesService.getSaleNumber(saleNumber);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
        settlementDO.setMirrorDate(simpleDateFormat.format(settlementDO.getMirrorTime()));
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
        Map<String,Object> mailMap = new HashMap<>();
        String dateNow = simpleDateFormat.format(new Date());
        mailMap.put("cardNumber",settlementDO.getMemberNumber());
        mailMap.put("dateNow",dateNow);
        mailMap.put("state",0);
        MailInfoDO mailInfoDO = mailInfoService.getMailAddress(settlementDO.getSaleNumber());
        if (null != mailInfoDO){
            model.addAttribute("address",mailInfoDO.getAddress());
        } else {
            List<MailInfoDO> mailInfoDOS = mailInfoService.getMailAddressByMember(mailMap);
            if (null != mailInfoDOS && mailInfoDOS.size() > 0){
                model.addAttribute("address",mailInfoDOS.get(0).getAddress());
            }else {
                model.addAttribute("address","");
            }
        }
        SettlementDO settlementDO1 = settlementService.getSaleNumers(saleNumber);
        if (null != settlementDO1){
			String[] paymodel = settlementDO1.getPayModel().split(",");
			for (int i=0;i<paymodel.length;i++){
				if (paymodel[i] == "0"){
					model.addAttribute("paymodel","微信");
				} else if (paymodel[i] == "1"){
					model.addAttribute("paymodel","支付宝");
				} else if (paymodel[i] == "2"){
					model.addAttribute("paymodel","医院收费处");
				} else if (paymodel[i] == "3"){
					model.addAttribute("paymodel","一卡通");
				}
			}
        }
        if ("定金".equals(settlementDO1.getPayWay())){
            Double arrearMoney = settlementDO1.getActualMoney() - settlementDO1.getPayMoney();
            settlementDO1.setArrearsMoney(arrearMoney);
        }
        model.addAttribute("settlementDO1",settlementDO1);
        Map<String,Object> map2 = new HashMap<>();
		Conclusion conclusion = new Conclusion();
		map2.put("cardNumber",settlementDO.getMemberNumber());
		map2.put("saleNumber",settlementDO.getSaleNumber());

		if (null != settlementDO.getOptometrywlName() && !"".equals(settlementDO.getOptometrywlName())){
			model.addAttribute("optometryName",settlementDO.getOptometrywlName());
			if (1 == settlementDO.getRecipelwlType()){
				List<KjjyDO> kjjyDOList = kjjyService.list(map2);
				if (null != kjjyDOList && kjjyDOList.size() > 0){
					conclusion.setRightsph(kjjyDOList.get(0).getKjjySphod());
					conclusion.setRightcyl(kjjyDOList.get(0).getKjjyCylod());
					conclusion.setRightzx(kjjyDOList.get(0).getKjjyAxialod());
					if (null != kjjyDOList.get(0).getKjjyYytjod()){
						conclusion.setRightyytj(kjjyDOList.get(0).getKjjyYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(kjjyDOList.get(0).getKjjyTgod());
					conclusion.setRightprism(kjjyDOList.get(0).getKjjyPrismod());
					conclusion.setRightjd(kjjyDOList.get(0).getKjjyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(kjjyDOList.get(0).getKjjySphos());
					conclusion.setLeftcyl(kjjyDOList.get(0).getKjjyCylos());
					conclusion.setLeftzx(kjjyDOList.get(0).getKjjyAxialos());
					if (null != kjjyDOList.get(0).getKjjyYytjos()){
						conclusion.setLeftyytj(kjjyDOList.get(0).getKjjyYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(kjjyDOList.get(0).getKjjyTgos());
					conclusion.setLeftprism(kjjyDOList.get(0).getKjjyPrismos());
					conclusion.setLeftjd(kjjyDOList.get(0).getKjjyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (2 == settlementDO.getRecipelwlType()){
				List<KjyyDO> kjyyDOList = kjyyService.list(map2);
				if (null != kjyyDOList && kjyyDOList.size() > 0){
					conclusion.setRightsph(kjyyDOList.get(0).getKjyySphod());
					conclusion.setRightcyl(kjyyDOList.get(0).getKjyyCylod());
					conclusion.setRightzx(kjyyDOList.get(0).getKjyyAxialod());
					if (null != kjyyDOList.get(0).getKjyyYytjod()){
						conclusion.setRightyytj(kjyyDOList.get(0).getKjyyYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(kjyyDOList.get(0).getKjyyTgod());
					conclusion.setRightprism(kjyyDOList.get(0).getKjyyPrismod());
					conclusion.setRightjd(kjyyDOList.get(0).getKjyyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(kjyyDOList.get(0).getKjyySphos());
					conclusion.setLeftcyl(kjyyDOList.get(0).getKjyyCylos());
					conclusion.setLeftzx(kjyyDOList.get(0).getKjyyAxialos());
					if (null != kjyyDOList.get(0).getKjyyYytjos()){
						conclusion.setLeftyytj(kjyyDOList.get(0).getKjyyYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(kjyyDOList.get(0).getKjyyTgos());
					conclusion.setLeftprism(kjyyDOList.get(0).getKjyyPrismos());
					conclusion.setLeftjd(kjyyDOList.get(0).getKjyyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (3 == settlementDO.getRecipelwlType()){
				List<SgjjDO> sgjjDOList = sgjjService.list(map2);
				if (null != sgjjDOList && sgjjDOList.size() > 0){
					conclusion.setRightsph(sgjjDOList.get(0).getSgjjSphod());
					conclusion.setRightcyl(sgjjDOList.get(0).getSgjjCylod());
					conclusion.setRightzx(sgjjDOList.get(0).getSgjjAxialod());
					if (null != sgjjDOList.get(0).getSgjjYytjod()){
						conclusion.setRightyytj(sgjjDOList.get(0).getSgjjYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(sgjjDOList.get(0).getSgjjTgod());
					conclusion.setRightprism("");
					conclusion.setRightjd("");
					conclusion.setRightAdd("");
					conclusion.setLeftsph(sgjjDOList.get(0).getSgjjSphos());
					conclusion.setLeftcyl(sgjjDOList.get(0).getSgjjCylos());
					conclusion.setLeftzx(sgjjDOList.get(0).getSgjjAxialos());
					if (null != sgjjDOList.get(0).getSgjjYytjos()){
						conclusion.setLeftyytj(sgjjDOList.get(0).getSgjjYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(sgjjDOList.get(0).getSgjjTgos());
					conclusion.setLeftprism("");
					conclusion.setLeftjd("");
					conclusion.setLeftAdd("");
				}
			} else if (4 == settlementDO.getRecipelwlType()){
				List<ZyDO> zyDOList = zyService.list(map2);
				if (null != zyDOList && zyDOList.size() > 0){
					conclusion.setRightsph(zyDOList.get(0).getZySphod());
					conclusion.setRightcyl(zyDOList.get(0).getZyCylod());
					conclusion.setRightzx(zyDOList.get(0).getZyAxialod());
					if (null != zyDOList.get(0).getZyZytjod()){
						conclusion.setRightyytj(zyDOList.get(0).getZyZytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg(zyDOList.get(0).getZyTgod());
					conclusion.setRightprism(zyDOList.get(0).getZyPrismod());
					conclusion.setRightjd(zyDOList.get(0).getZyJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(zyDOList.get(0).getZySphos());
					conclusion.setLeftcyl(zyDOList.get(0).getZyCylos());
					conclusion.setLeftzx(zyDOList.get(0).getZyAxialos());
					if (null != zyDOList.get(0).getZyZytjos()){
						conclusion.setLeftyytj(zyDOList.get(0).getZyZytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg(zyDOList.get(0).getZyTgos());
					conclusion.setLeftprism(zyDOList.get(0).getZyPrismos());
					conclusion.setLeftjd(zyDOList.get(0).getZyJdos());
					conclusion.setLeftAdd("");
				}
			} else if (5 == settlementDO.getRecipelwlType()){
				List<RxjmjcjDO> rxjmjcjDOList = rxjmjcjService.list(map2);
				if (null != rxjmjcjDOList && rxjmjcjDOList.size() > 0){
					conclusion.setRightsph(rxjmjcjDOList.get(0).getRxSphod());
					conclusion.setRightcyl(rxjmjcjDOList.get(0).getRxCylod());
					conclusion.setRightzx(rxjmjcjDOList.get(0).getRxAxialod());
					conclusion.setRightyytj("");
					conclusion.setRighttg("");
					conclusion.setRightprism("");
					conclusion.setRightjd("");
					conclusion.setRightAdd("");
					conclusion.setLeftsph(rxjmjcjDOList.get(0).getRxSphos());
					conclusion.setLeftcyl(rxjmjcjDOList.get(0).getRxCylos());
					conclusion.setLeftzx(rxjmjcjDOList.get(0).getRxAxialos());
					conclusion.setLeftyytj("");
					conclusion.setLefttg("");
					conclusion.setLeftprism("");
					conclusion.setLeftjd("");
					conclusion.setLeftAdd("");
				}
			} else if (7 == settlementDO.getRecipelwlType()){
				List<SjxlDO> sjxlDOList = sjxlService.list(map2);
				if (null != sjxlDOList && sjxlDOList.size() > 0){
					conclusion.setRightsph(sjxlDOList.get(0).getSjxlSphod());
					conclusion.setRightcyl(sjxlDOList.get(0).getSjxlCylod());
					conclusion.setRightzx(sjxlDOList.get(0).getSjxlAxialod());
					if (null != sjxlDOList.get(0).getSjxlYytjod()){
						conclusion.setRightyytj(sjxlDOList.get(0).getSjxlYytjod());
					} else {
						conclusion.setRightyytj("");
					}
					conclusion.setRighttg("");
					conclusion.setRightprism(sjxlDOList.get(0).getSjxlSljod());
					conclusion.setRightjd(sjxlDOList.get(0).getSjxlJdod());
					conclusion.setRightAdd("");
					conclusion.setLeftsph(sjxlDOList.get(0).getSjxlSphos());
					conclusion.setLeftcyl(sjxlDOList.get(0).getSjxlCylos());
					conclusion.setLeftzx(sjxlDOList.get(0).getSjxlAxialos());
					if (null != sjxlDOList.get(0).getSjxlYytjos()){
						conclusion.setLeftyytj(sjxlDOList.get(0).getSjxlYytjos());
					} else {
						conclusion.setLeftyytj("");
					}
					conclusion.setLefttg("");
					conclusion.setLeftprism(sjxlDOList.get(0).getSjxlSljos());
					conclusion.setLeftjd(sjxlDOList.get(0).getSjxlJdos());
					conclusion.setLeftAdd("");
				}
			}
		} else {
			model.addAttribute("optometryName",settlementDO.getOptometryName());
			List<Conclusion> conclusionList = salesService.conclusionList(map2);
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

        return "settlement/dingjindan";
    }


		/**
         * 修改
         */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:settlement:edit")
	public R update( SettlementDO settlement){
		//SettlementDO settlementDO = settlementService.get(settlement.getId());
		//settlement.setPayMoney(settlement.getPayMoney() + settlement.getFrontMoney());
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
