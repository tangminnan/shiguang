package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller("PeiJingSingleController")
@RequestMapping("/information/peijing")
public class PeiJingSingleController {
    @Autowired
    private LogStatusService statusService;

    /**
     * 配镜单
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:peijing:peijing")
    String faliao(){
        return "logstatus/peijing";
    }

    @ResponseBody
    @GetMapping("/peijinglist")
    @RequiresPermissions("information:peijing:peijing")
    public PageUtils peijinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
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
}
