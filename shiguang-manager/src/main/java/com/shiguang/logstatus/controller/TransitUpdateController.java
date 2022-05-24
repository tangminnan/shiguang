package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/transit")
public class TransitUpdateController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;

    /**
     * 更改在途状态
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:transit:transit")
    String transit(){
        return "logstatus/transit";
    }

    @ResponseBody
    @GetMapping("/transitlist")
    @RequiresPermissions("information:transit:transit")
    public PageUtils peijinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        if (null != ShiroUtils.getUser().getCompanyId()){
            if (!"3".equals(ShiroUtils.getUser().getCompanyId())){
                query.put("companyid",ShiroUtils.getUser().getCompanyId());
            }
        }
        List<SalesDO> salesDOList = statusService.findSalePeijingAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
        }
        int total = statusService.findSalePeijingCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @ResponseBody
    @RequestMapping(value = "/findSale")
    LogStatusDO findSale(String saleNumber, Model model) {
        LogStatusDO logStatusDO = statusService.getLogStatusBySaleNum(saleNumber);
        model.addAttribute("logStatusDO", logStatusDO);
        return logStatusDO;
    }

    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    Map<String,Object> updateStatus(String saleNumber,String logstatus, Model model) {
        Map<String,Object> map = new HashMap<>();
        LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus(logstatus);
        if (statusService.update(logStatusDO) > 0){
            map.put("code","200");
            map.put("message","修改成功");
        }
        return map;
    }

    @GetMapping("/edit/{saleNumber}")
    @RequiresPermissions("information:transit:edit")
    String edit(@PathVariable("saleNumber") String saleNumber, Model model){
        SalesDO salesDO = salesService.getSaleNumber(saleNumber);
        model.addAttribute("salesDO",salesDO);
        return "logstatus/transitedit";
    }

    /**
     * 更改在途状态
     */
    @PostMapping( "/editTransit")
    @ResponseBody
    @RequiresPermissions("information:transit:edit")
    public R editTransit(LogStatusDO logStatusDO){
        //LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(logStatusDO.getSaleNumber());
        logStatusDO.setLogisticStatus(logStatusDO.getLogisticStatus());
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType(logStatusDO.getLogisticStatus());
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.error();
    }

}
