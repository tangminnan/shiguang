package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LensMeterDO;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LensMeterService;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/examine")
public class ExamineController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private LensMeterService lensMeterService;
    SerialPortUtils serialPort = new SerialPortUtils();

    /**
     * 加工师检验
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:examine:examine")
    String examine(){
        return "logstatus/examine";
    }

    @ResponseBody
    @GetMapping("/examinelist")
    @RequiresPermissions("information:examine:examine")
    public PageUtils examinelist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","加工师加工");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
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
    @RequiresPermissions("information:examine:edit")
    String edit(@PathVariable("saleNumber") String saleNumber, Model model){
        try {
            Method method = Chuank.class.getMethod("main",
                    String[].class);
            method.invoke(null,
                    (Object) new String[2]);
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
        SalesDO status = statusService.getLogSaleNumber(saleNumber);
        if (null != status.getJpGoodsName()){
            String jpName = status.getJpGoodsName();
            try {
                String[] jpStr = jpName.split(",");
                if (jpStr.length > 0){
                    status.setRightjp(jpStr[0]);
                } else {
                    status.setRightjp("");
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                status.setRightjp("");
            }
            try {
                String[] jpStr = jpName.split(",");
                if (jpStr.length > 1){
                    status.setLeftjp(jpStr[1]);
                } else {
                    status.setLeftjp("");
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                status.setLeftjp("");
            }
        }else {
            status.setRightjp("");
            status.setLeftjp("");
        }
        model.addAttribute("status", status);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("cardNumber",status.getMemberNumber());
        List<Conclusion> conclusionList = salesService.conclusionList(map2);
        Conclusion conclusion = new Conclusion();
        if (null != conclusionList && conclusionList.size() > 0){
            conclusion.setRightsph(conclusionList.get(0).getRightsph());
            conclusion.setRightcyl(conclusionList.get(0).getRightcyl());
            conclusion.setRightzx(conclusionList.get(0).getRightzx());
            if (null != conclusionList.get(0).getRightyytj()){
                conclusion.setRightyytj(conclusionList.get(0).getRightyytj());
            } else {
                conclusion.setRightyytj(conclusionList.get(0).getRightjytj());
            }
            conclusion.setRighttg(conclusionList.get(0).getRighttg());
            conclusion.setRightprism(conclusionList.get(0).getRightprism());
            conclusion.setRightjd(conclusionList.get(0).getRightjd());
            conclusion.setLeftsph(conclusionList.get(0).getLeftsph());
            conclusion.setLeftcyl(conclusionList.get(0).getLeftcyl());
            conclusion.setLeftzx(conclusionList.get(0).getLeftzx());
            if (null != conclusionList.get(0).getLeftyytj()){
                conclusion.setLeftyytj(conclusionList.get(0).getLeftyytj());
            } else {
                conclusion.setLeftyytj(conclusionList.get(0).getLeftjytj());
            }
            conclusion.setLefttg(conclusionList.get(0).getLefttg());
            conclusion.setLeftprism(conclusionList.get(0).getLeftprism());
            conclusion.setLeftjd(conclusionList.get(0).getLeftjd());
        } else {
            conclusion.setRightsph("");
            conclusion.setRightcyl("");
            conclusion.setRightzx("");
            conclusion.setRightyytj("");
            conclusion.setRighttg("");
            conclusion.setRightprism("");
            conclusion.setRightjd("");
            conclusion.setLeftsph("");
            conclusion.setLeftcyl("");
            conclusion.setLeftzx("");
            conclusion.setLeftyytj("");
            conclusion.setLefttg("");
            conclusion.setLeftprism("");
            conclusion.setLeftjd("");
        }
        model.addAttribute("conclusion",conclusion);
        model.addAttribute("examineName",ShiroUtils.getUser().getName());
        return "logstatus/edit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:examine:edit")
    public R update(LogStatusDO status){
        status.setLogisticStatus("加工师检验");
        statusService.update(status);
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("检验");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        lensMeterService.remove(status.getLensMeterId());
        return R.ok();
    }

    @ResponseBody
    @RequestMapping(value = "/jiaoduji")
    LensMeterDO jiaoduji(Model model) {
        Map<String,Object> map = new HashMap<>();
        LensMeterDO lensMeterDO = new LensMeterDO();
        //serialPort.sendToData();
        List<LensMeterDO> lensMeterDOList = lensMeterService.list(map);
        if (null != lensMeterDOList && lensMeterDOList.size() > 0){
            lensMeterDO.setId(lensMeterDOList.get(0).getId());
            lensMeterDO.setRightSph(lensMeterDOList.get(0).getRightSph());
            lensMeterDO.setRightCyl(lensMeterDOList.get(0).getRightCyl());
            lensMeterDO.setRightZx(lensMeterDOList.get(0).getRightZx());
            lensMeterDO.setLeftSph(lensMeterDOList.get(0).getLeftSph());
            lensMeterDO.setLeftCyl(lensMeterDOList.get(0).getLeftCyl());
            lensMeterDO.setLeftZx(lensMeterDOList.get(0).getLeftZx());
        }
        model.addAttribute("lensMeterDO",lensMeterDO);
        return lensMeterDO;
    }

}
