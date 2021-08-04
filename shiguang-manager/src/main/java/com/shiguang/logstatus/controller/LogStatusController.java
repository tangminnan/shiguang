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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/logstatus")
public class LogStatusController {
    @Autowired
    private LogStatusService statusService;

//    @GetMapping()
//    @RequiresPermissions("information:logstatus:logstatus")
//    String Status(){
//        return "logstatus/logstatus";
//    }
//
//    @ResponseBody
//    @GetMapping("/list")
//    @RequiresPermissions("information:logstatus:logstatus")
//    public PageUtils list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//        List<LogStatusDO> statusList = statusService.list(query);
//        int total = statusService.count(query);
//        PageUtils pageUtils = new PageUtils(statusList, total);
//        return pageUtils;
//    }

    /**
     * 发料
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:logstatus:faliao")
    String faliao(){
        return "logstatus/faliao";
    }

    @ResponseBody
    @GetMapping("/faliaolist")
    @RequiresPermissions("information:logstatus:faliao")
    public PageUtils faliaolist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","销售完成");
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
        }
        int total = statusService.findSaleCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:logstatus:add")
    String add(){
        return "logstatus/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:logstatus:edit")
    String edit(@PathVariable("id") Long id,Model model){
        LogStatusDO status = statusService.get(id);
        model.addAttribute("status", status);
        return "logstatus/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:logstatus:add")
    public R save( LogStatusDO status){
        if(statusService.save(status)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:logstatus:edit")
    public R update( LogStatusDO status){
        statusService.update(status);
        return R.ok();
    }

    /**
     * 发料
     */
    @PostMapping( "/editFaliao")
    @ResponseBody
    @RequiresPermissions("information:logstatus:edit")
    public R editFaliao(String saleNumber){
        LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus("发料");
        logStatusDO.setFaliaoDate(new Date());
        logStatusDO.setFaliaoName(ShiroUtils.getUser().getName());
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:logstatus:remove")
    public R remove(Long id){
        if(statusService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        statusService.batchRemove(ids);
        return R.ok();
    }
}
