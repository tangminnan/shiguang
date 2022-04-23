package com.shiguang.settlement.controller;

import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.jiancha.service.ResultService;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.JieKuanMoneyDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/method")
public class SettlementMethodController {
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
    @RequiresPermissions("information:method:method")
    String Settlement(){
        return "method/method";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:method:method")
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
        List<JieKuanMoneyDO> memberDOList = memberService.payList(query);
        int total = memberService.payCount(query);
        PageUtils pageUtils = new PageUtils(memberDOList, memberDOList.size());
        return pageUtils;
    }

    @GetMapping("/edit/{cardNumber}/{saleNumber}")
    @RequiresPermissions("information:method:edit")
    String detail(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber,Model model){
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        model.addAttribute("memberDO",memberDO);
//		CostDO costDO = costService.get(costId);
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
//        List<CostDO> costDOList = costService.list(map);
//        Double sumMoney =0.00;
//        CostDO costDO = new CostDO();
//        for (CostDO costDO1 : costDOList){
//            if (null != costDO1.getCostMoney()){
//                if (null != costDO1.getCostMoney()){
//                    sumMoney = sumMoney + costDO1.getCostMoney();
//                    costDO1.setSumMoney(sumMoney);
//                    costDO = new CostDO();
//                    costDO.setId(costDO1.getId());
//                    costDO.setMemberNumber(costDO1.getMemberNumber());
//                    costDO.setSaleNumber(costDO1.getSaleNumber());
//                    costDO.setSumMoney(sumMoney);
//                    costDO.setSaleName(costDO1.getSaleName());
//                    costDO.setOriginalPrice(costDO1.getOriginalPrice());
//                }
//            }
//        }
//		if (null != costDO.getCostMoney()) {
//			if (null != costDO.getCostMoney()){
//				sumMoney = sumMoney + costDO.getCostMoney();
//				costDO.setSumMoney(sumMoney);
//			}
//		}
//        model.addAttribute("costDO",costDO);
        //SettlementDO settlement = settlementService.getCostId(costId);
        //List<SettlementDO> settlement = settlementService.list(map);
        SettlementDO settlement = settlementService.getSaleNumers(saleNumber);
        SalesDO salesDO = salesService.getSaleNumber(saleNumber);
        model.addAttribute("settlement", settlement);
        model.addAttribute("salesDO",salesDO);
        return "method/editMethod";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:method:edit")
    public R update(SettlementDO settlement){
        //SettlementDO settlementDO = settlementService.get(settlement.getId());
        //settlement.setPayMoney(settlement.getPayMoney() + settlement.getFrontMoney());
        settlement.setSaleName(ShiroUtils.getUser().getName());
        settlement.setSaleAcount(ShiroUtils.getUser().getUsername());
        if (null != settlement.getPayGgModel() && !"".equals(settlement.getPayGgModel())){
            settlement.setPayModel(settlement.getPayGgModel());
            settlement.setModelMoney(settlement.getModelGgMoney());
        }
        settlementService.updateMethod(settlement);
        return R.ok();
    }

}
