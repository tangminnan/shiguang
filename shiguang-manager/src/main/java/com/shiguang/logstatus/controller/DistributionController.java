package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.storeSales.domain.InfoDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.InfoService;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
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
@RequestMapping("/information/distribution")
public class DistributionController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private UserService userService;
    @Autowired
    private InfoService infoService;

    /**
     * 加工配送
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:distribution:distribution")
    String distribution(){
        return "logstatus/distribution";
    }

    @ResponseBody
    @GetMapping("/distributionlist")
    @RequiresPermissions("information:distribution:distribution")
    public PageUtils distributionlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","加工师检验");
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
            query.put("offset",0);
            query.put("limit",10);
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
    @RequiresPermissions("information:distribution:edit")
    String edit(@PathVariable("saleNumber") String saleNumber, Model model){
        model.addAttribute("saleNumber",saleNumber);
        return "logstatus/distributionedit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:distribution:edit")
    public R update(LogStatusDO status){
        String userName = status.getProcessName();
        Map<String,Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("conpanyId",ShiroUtils.getUser().getCompanyId());
        }
        map.put("userName",userName);
        UserDO userDO = userService.getUserName(map);
        if (null != userDO){
            status.setLogisticStatus("配送");
            statusService.update(status);
            WorkRecoedDO workRecoedDO = new WorkRecoedDO();
            workRecoedDO.setUserName(status.getProcessName());
            workRecoedDO.setType("配送");
            workRecoedDO.setDateTime(new Date());
            statusService.saveRecord(workRecoedDO);
            InfoDO infoDO = new InfoDO();
            infoDO.setSaleNumber(status.getSaleNumber());
            infoDO.setTrainStatus("加工配送");
            infoDO.setTrainTime(new Date());
            infoDO.setTrainName(ShiroUtils.getUser().getName());
            infoService.save(infoDO);
            return R.ok();
        } else {
            return R.error("该工号不存在");
        }

    }

    @GetMapping("/disedit")
    @RequiresPermissions("information:distribution:edit")
    String disedit(Model model){
        return "logstatus/distributioneditpl";
    }


    /**
     * 批量配送
     */
    @PostMapping( "/batchDistribution")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchDistribution")
    public R batchInitial(@RequestParam("ids[]") Long[] ids,String userName) {
        Map<String,Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("conpanyId",ShiroUtils.getUser().getCompanyId());
        }
        map.put("userName",userName);
        UserDO userDO = userService.getUserName(map);
        if (null != userDO){
            for (int i = 0; i < ids.length; i++) {
                SalesDO salesDOs = salesService.get(ids[i]);
                LogStatusDO status = new LogStatusDO();
                status.setSaleNumber(salesDOs.getSaleNumber());
                status.setLogisticStatus("配送");
                statusService.update(status);
                InfoDO infoDO = new InfoDO();
                infoDO.setSaleNumber(status.getSaleNumber());
                infoDO.setTrainStatus("加工配送");
                infoDO.setTrainTime(new Date());
                infoDO.setTrainName(ShiroUtils.getUser().getName());
                infoService.save(infoDO);
            }
            WorkRecoedDO workRecoedDO = new WorkRecoedDO();
            workRecoedDO.setUserName(userName);
            workRecoedDO.setType("配送");
            workRecoedDO.setDateTime(new Date());
            statusService.saveRecord(workRecoedDO);
            return R.ok();
        } else {
            return R.error("该工号不存在");
        }
    }

}
