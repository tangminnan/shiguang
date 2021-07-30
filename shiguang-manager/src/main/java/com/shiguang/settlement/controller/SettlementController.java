package com.shiguang.settlement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.ResultService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
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
		costDO.setId(settlement.getCostId());
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
		String ptometryNumber = settlementDO.getPtometryNumber();
		//ResultDO resultDO = resultService.
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
