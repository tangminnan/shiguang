package com.shiguang.settlement.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.DrawbackService;
import com.shiguang.settlement.service.SettlementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/arrears")
public class ArrearsController {
    @Autowired
    private SettlementService settlementService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DrawbackService drawbackService;
    @Autowired
    private CostService costService;

    @GetMapping()
    @RequiresPermissions("information:arrears:arrears")
    String Settlement(){
        return "arrears/arrears";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:arrears:arrears")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        query.put("state",1);
        query.put("isSale",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        } else {
            query.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
        query.put("payWay","定金");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<SettlementDO> settlementDOList = settlementService.findArrearsData(query);
        if (null != settlementDOList && settlementDOList.size() > 0) {
            for (SettlementDO settlementDO : settlementDOList) {
                if ("定金".equals(settlementDO.getPayWay())) {
                    Double arrearMoney = settlementDO.getActualMoney() - settlementDO.getPayMoney();
                    settlementDO.setArrearsMoney(arrearMoney);
                    settlementDO.setSettleTime(simpleDateFormat.format(settlementDO.getSettleDate()));
                }
            }
        }
        int total = settlementService.findArrearsDataCount(query);
        PageUtils pageUtils = new PageUtils(settlementDOList, total);
        return pageUtils;
    }

    @GetMapping("/edit/{cardNumber}/{saleNumber}")
    @RequiresPermissions("information:arrears:edit")
    String edit(@PathVariable("cardNumber") String cardNumber, @PathVariable("saleNumber") String saleNumber, Model model){
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        model.addAttribute("memberDO",memberDO);
        //List<CostDO> costDOList = costService.getMemberNum(cardNumber);
        //CostDO costDO = costService.get(costId);
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SettlementDO settlementDO = settlementService.getSaleNumersByNum(saleNumber);
        Double arrearMoney = settlementDO.getActualMoney() - settlementDO.getPayMoney();
        settlementDO.setArrearsMoney(arrearMoney);
        settlementDO.setSettleTime(simpleDateFormat.format(settlementDO.getSettleDate()));
        model.addAttribute("settleDO",settlementDO);
        return "arrears/edit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:arrears:edit")
    public R update(SettlementDO settlement){
        settlement.setPayWay("全款");
        SettlementDO settlementDO = settlementService.get(settlement.getId());
        settlement.setPayMoney(settlementDO.getPayMoney() + settlement.getPayMoney());
        settlementService.update(settlement);
        CostDO costDO = costService.get(settlementDO.getCostId());
        if ("定金单".equals(costDO.getType())){
            costDO.setType("配镜单");
            costService.update(costDO);
        }
        return R.ok();
    }

}
