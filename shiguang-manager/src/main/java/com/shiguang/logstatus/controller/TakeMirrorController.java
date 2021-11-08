package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/mirror")
public class TakeMirrorController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private SettlementService settlementService;

    /**
     * 顾客取镜
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:mirror:mirror")
    String examine(){
        return "logstatus/mirror";
    }

    @ResponseBody
    @GetMapping("/mirrorlist")
    @RequiresPermissions("information:mirror:mirror")
    public PageUtils mirrorlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","收货");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            if (null != salesDO.getFaliaoDate()){
                salesDO.setFaliaoTime(simpleDateFormat.format(salesDO.getFaliaoDate()));
            }
        }
        int total = statusService.findSaleCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    /**
     * 顾客取镜
     */
    @PostMapping( "/editQujing")
    @ResponseBody
    @RequiresPermissions("information:mirror:edit")
    public R editQujing(String saleNumber){
        LogStatusDO logStatusDO = new LogStatusDO();
        SettlementDO settlementDO = settlementService.getSaleNumers(saleNumber);
        if (!"全款".equals(settlementDO.getPayWay())){
            return R.error("该会员还有欠款未缴，需缴完欠款才能取镜");
        }
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus("顾客取镜");
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("顾客取镜");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量收货
     */
    @PostMapping( "/batchQujing")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchQujing")
    public R batchQujing(@RequestParam("ids[]") Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            SalesDO salesDOs = salesService.get(ids[i]);
            SettlementDO settlementDO = settlementService.getSaleNumers(salesDOs.getSaleNumber());
            if (!"全款".equals(settlementDO.getPayWay())){
                return R.error("该会员还有欠款未缴，需缴完欠款才能取镜");
            }
            LogStatusDO logStatusDO = new LogStatusDO();
            logStatusDO.setSaleNumber(salesDOs.getSaleNumber());
            logStatusDO.setLogisticStatus("顾客取镜");
            statusService.editFaliao(logStatusDO);
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("顾客取镜");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        return R.ok();
    }

}
