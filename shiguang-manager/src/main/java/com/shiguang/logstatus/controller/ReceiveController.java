package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.*;
import com.shiguang.line.service.LineMemberService;
import com.shiguang.line.service.LineService;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/receive")
public class ReceiveController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private LineService lineService;

    /**
     * 取镜处收货
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:receive:receive")
    String examine(){
        return "logstatus/receive";
    }

    @ResponseBody
    @GetMapping("/receivelist")
    @RequiresPermissions("information:receive:receive")
    public PageUtils receivelist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","配送");
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
     * 取镜处收货
     */
    @PostMapping( "/editShouhuo")
    @ResponseBody
    @RequiresPermissions("information:receive:edit")
    public R editShouhuo(String saleNumber,String memberName){
        LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus("收货");
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("收货");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        if(statusService.editFaliao(logStatusDO)>0){
            Map<String,Object> map = new HashMap<>();
            map.put("type","取镜");
            map.put("memberName",memberName);
            lineService.callList(map);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量收货
     */
    @PostMapping( "/batchShouhuo")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchShouhuo")
    public R batchShouhuo(@RequestParam("ids[]") Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            SalesDO salesDOs = salesService.get(ids[i]);
            LogStatusDO logStatusDO = new LogStatusDO();
            logStatusDO.setSaleNumber(salesDOs.getSaleNumber());
            logStatusDO.setLogisticStatus("收货");
            statusService.editFaliao(logStatusDO);
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("收货");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        return R.ok();
    }

}
