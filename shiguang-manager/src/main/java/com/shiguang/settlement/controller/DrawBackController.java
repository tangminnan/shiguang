package com.shiguang.settlement.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.DrawbackService;
import com.shiguang.settlement.service.SettlementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/drawback")
public class DrawBackController {
    @Autowired
    private SettlementService settlementService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private DrawbackService drawbackService;
    @Autowired
    private CostService costService;

    @GetMapping()
    @RequiresPermissions("information:drawback:drawback")
    String Settlement(){
        return "drawback/drawback";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:drawback:drawback")
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
        List<MemberDO> memberDOList = memberService.payList(query);
        int total = memberService.payCount(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    /**
     * 退款
     */
    @PostMapping( "/tuikuan")
    @ResponseBody
    @RequiresPermissions("information:drawback:tuikuan")
    public R remove(String cardNumber,String saleNumber){
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        DrawbackDO drawbackDO = new DrawbackDO();
        drawbackDO.setDrawbackNumber(String.valueOf(GuuidUtil.getUUID()));
        drawbackDO.setCreaterName(ShiroUtils.getUser().getName());
        drawbackDO.setCreateTime(new Date());
        drawbackDO.setDrawbackName(memberDO.getName());
        SettlementDO settlementDO = settlementService.getSaleNumers(saleNumber);
        if ("定金".equals(settlementDO.getPayWay())){
            drawbackDO.setDrawbackMoney(String.valueOf(settlementDO.getPayMoney()));
        } else {
            drawbackDO.setDrawbackMoney(String.valueOf(settlementDO.getActualMoney()));
        }
        CostDO costDO = new CostDO();
        costDO.setId(settlementDO.getCostId());
        costDO.setIsSale(2L);
        costService.update(costDO);
        if(drawbackService.save(drawbackDO)>0){
            return R.ok();
        }
        return R.error();
    }

}
