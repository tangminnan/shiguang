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
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private SalesService salesService;
    @Autowired
    private StockService stockService;
    @Autowired
    private LogStatusService logStatusService;

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
        SalesDO salesDO = salesService.getSaleNumber(saleNumber);
        LogStatusDO logStatusDO = logStatusService.getLogStatusBySaleNum(saleNumber);
        String storeNum = salesDO.getStoreNum();
        String[] count = salesDO.getStoreCount().split(",");
        String[] goodsCode = salesDO.getGoodsCode().split(",");
        String[] storeDescribe = salesDO.getStoreDescribe().split(",");
        Map<String,Object> map = new HashMap<>();
        map.put("departNumber",storeNum);
        PositionDO positionDO = stockService.findPosition(map);
        for (int i=0;i<goodsCode.length;i++){
            StockDO stockDO = new StockDO();
            stockDO.setPositionId(String.valueOf(positionDO.getPositionId()));
            stockDO.setGoodsCode(goodsCode[i]);
            StockDO stockDO1 = stockService.getProduceCode(stockDO);
            if (!"销售完成".equals(logStatusDO.getLogisticStatus())){
                if (null != stockDO1){
                    int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
                    stockDO.setGoodsCount(godsCount + "");
                    stockService.updateGoodsCount(stockDO);
                } else {
                    return R.error("库存中不存在该商品");
                }

            } else if (null != logStatusDO){
                if (!"镜片".equals(storeDescribe[i])){
                    if (null != stockDO1){
                        int godsCount = Integer.parseInt(stockDO1.getGoodsCount()) + Integer.parseInt(count[i]);
                        stockDO.setGoodsCount(godsCount + "");
                        stockService.updateGoodsCount(stockDO);
                    } else {
                        return R.error("库存中不存在该商品");
                    }

                }
            }


        }
        if(drawbackService.save(drawbackDO)>0){
            return R.ok("退款成功");
        }
        return R.error();
    }

}
