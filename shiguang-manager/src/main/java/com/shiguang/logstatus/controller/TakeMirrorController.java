package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/mirror")
public class TakeMirrorController {
    @Autowired
    private LogStatusService statusService;

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
        query.put("companyid",ShiroUtils.getUser().getCompanyId());
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            salesDO.setFaliaoTime(simpleDateFormat.format(salesDO.getFaliaoDate()));
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
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus("顾客取镜");
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.error();
    }

}
