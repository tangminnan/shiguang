package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import com.shiguang.unqualiffed.service.UnqualiffedService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/initial")
public class InitialController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private UnqualiffedService unqualiffedService;
    @Autowired
    private SalesService salesService;

    /**
     * 加工师初检
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:initial:initial")
    String initial(){
        return "logstatus/initial";
    }

    @ResponseBody
    @GetMapping("/initiallist")
    @RequiresPermissions("information:initial:initial")
    public PageUtils examinelist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","发料");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        if (null != params.get("memberName") && !"".equals(params.get("memberName"))){
            query.put("memberName",String.valueOf(query.get("memberName")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("phone") && !"".equals(params.get("phone"))){
            query.put("phone",String.valueOf(query.get("phone")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
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

    @GetMapping("/edit/{saleNumber}")
    @RequiresPermissions("information:initial:edit")
    String edit(@PathVariable("saleNumber") String saleNumber,Model model){
        model.addAttribute("saleNumber",saleNumber);
        return "logstatus/initialedit";
    }

    /**
     * 修改
     */
    @PostMapping( "/update")
    @ResponseBody
    @RequiresPermissions("information:initial:edit")
    public R update(LogStatusDO status){
        if ("2".equals(status.getInitial())){
            UnqualiffedDO unqualiffedDO = new UnqualiffedDO();
            unqualiffedDO.setBillNumber(String.valueOf(GuuidUtil.getUUID()));
            unqualiffedDO.setSaleNumber(status.getSaleNumber());
            unqualiffedDO.setPreparedName(ShiroUtils.getUser().getName());
            unqualiffedDO.setResponsibleName(ShiroUtils.getUser().getName());
            unqualiffedDO.setBillDate(new Date());
            unqualiffedService.save(unqualiffedDO);
        } else {
            status.setLogisticStatus("加工初检");
            statusService.update(status);
        }

        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("初检");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        return R.ok();
    }

    @GetMapping("/initialpl")
    @RequiresPermissions("information:initial:edit")
    String initialpl(Model model){
        return "logstatus/initialpl";
    }

    /**
     * 批量初检
     */
    @PostMapping( "/batchInitial")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchInitial")
    public R batchInitial(@RequestParam("ids[]") Long[] ids,String initial) {
        for (int i = 0; i < ids.length; i++) {
            SalesDO salesDOs = salesService.get(ids[i]);
            LogStatusDO logStatusDO = new LogStatusDO();
            if ("2".equals(initial)) {
                UnqualiffedDO unqualiffedDO = new UnqualiffedDO();
                unqualiffedDO.setBillNumber(String.valueOf(GuuidUtil.getUUID()));
                unqualiffedDO.setSaleNumber(salesDOs.getSaleNumber());
                unqualiffedDO.setPreparedName(ShiroUtils.getUser().getName());
                unqualiffedDO.setResponsibleName(ShiroUtils.getUser().getName());
                unqualiffedDO.setBillDate(new Date());
                unqualiffedService.save(unqualiffedDO);
            } else {
                logStatusDO.setSaleNumber(salesDOs.getSaleNumber());
                logStatusDO.setLogisticStatus("加工初检");
                statusService.update(logStatusDO);
            }
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("初检");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        return R.ok();
    }
}
