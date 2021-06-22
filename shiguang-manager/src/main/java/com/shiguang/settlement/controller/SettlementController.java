package com.shiguang.settlement.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
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

	@GetMapping("/edit/{cardNumber}")
	@RequiresPermissions("information:settlement:edit")
	String edit(@PathVariable("cardNumber") String cardNumber,Model model){
		MemberDO memberDO = memberService.getCardNumber(cardNumber);
		model.addAttribute("memberDO",memberDO);
		List<CostDO> costDOList = costService.getMemberNum(cardNumber);
		Double sumMoney =0.00;
		CostDO costDO = new CostDO();
		for (CostDO costDO1 : costDOList){
			sumMoney = sumMoney + costDO1.getCostMoney();
			costDO1.setSumMoney(sumMoney);
			costDO = new CostDO();
			costDO.setId(costDO1.getId());
			costDO.setMemberNumber(costDO1.getMemberNumber());
			costDO.setSaleNumber(costDO1.getSaleNumber());
			costDO.setSumMoney(sumMoney);
			costDO.setSaleName(costDO1.getSaleName());
		}

		model.addAttribute("costDO",costDO);
//		SettlementDO settlement = settlementService.get(id);
//		model.addAttribute("settlement", settlement);
	    return "settlement/edit";
	}

	@GetMapping("/detail/{cardNumber}")
	@RequiresPermissions("information:settlement:detail")
	String detail(@PathVariable("cardNumber") String cardNumber,Model model){
		MemberDO memberDO = memberService.getCardNumber(cardNumber);
		model.addAttribute("memberDO",memberDO);
		List<CostDO> costDOList = costService.getMemberNum(cardNumber);
		Double sumMoney =0.00;
		CostDO costDO = new CostDO();
		for (CostDO costDO1 : costDOList){
			sumMoney = sumMoney + costDO1.getCostMoney();
			costDO1.setSumMoney(sumMoney);
			costDO = new CostDO();
			costDO.setId(costDO1.getId());
			costDO.setMemberNumber(costDO1.getMemberNumber());
			costDO.setSaleNumber(costDO1.getSaleNumber());
			costDO.setSumMoney(sumMoney);
			costDO.setSaleName(costDO1.getSaleName());
		}

		model.addAttribute("costDO",costDO);
		SettlementDO settlement = settlementService.getMember(cardNumber);
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
		costDO.setMemberNumber(settlement.getMemberNumber());
		costDO.setIsSale(1L);
		costService.updateMember(costDO);
		if(settlementService.save(settlement)>0){
			return R.ok();
		}
		return R.error();
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
