package com.shiguang.settlement.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.DrawbackService;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeCard.domain.CardDO;
import com.shiguang.storeCard.service.CardService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @Autowired
    private SalesService salesService;
    @Autowired
    private StockService stockService;
    @Autowired
    private LogStatusService logStatusService;
    @Autowired
    private CardService cardService;

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
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        List<MemberDO> memberDOList = drawbackService.memberList(query);
        int total = drawbackService.memberCount(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/edit/{cardNumber}/{saleNumber}")
    @RequiresPermissions("information:drawback:edit")
    String detail(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber,Model model){
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        model.addAttribute("memberDO",memberDO);
        Map<String,Object> mapphone = new HashMap<>();
        if (null != memberDO.getPhone1() && !"".equals(memberDO.getPhone1())){
            mapphone.put("phone1",memberDO.getPhone1());
        } else {
            mapphone.put("phone1",memberDO.getPhone2());
        }
        List<MemberDO> memberList = memberService.list(mapphone);
        List<CardDO> cardDOS = new ArrayList<>();
        for (MemberDO memberDO1 : memberList){
            CardDO cardDO = new CardDO();
            cardDO = cardService.getMemberNum(memberDO1.getCardNumber());
            if (null == cardDO){
                cardDO = new CardDO();
                cardDO.setCardNumber("");
                cardDO.setCardMoney("");
            } else {
                cardDO.setCardNumMoney(cardDO.getCardNumber() + "(余额："+ cardDO.getCardMoney() + ")");
                cardDOS.add(cardDO);
            }

        }
        model.addAttribute("cardDOS",cardDOS);
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
        return "drawback/edit";
    }

    /**
     * 退款
     */
    @PostMapping( "/update")
    @ResponseBody
    @RequiresPermissions("information:drawback:edit")
    public R remove(DrawbackDO drawbackDO){
        return drawbackService.saveMoney(drawbackDO);
    }

}
