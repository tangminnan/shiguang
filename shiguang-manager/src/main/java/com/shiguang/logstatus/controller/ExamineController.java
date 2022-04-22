package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.*;
import com.shiguang.logstatus.service.LensMeterService;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.apache.bcel.generic.LineNumberGen;
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
    //@Autowired
    private SerialPortUtils serialPort;

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
        if (null != params.get("memberName") && !"".equals(params.get("memberName"))){
            query.put("memberName",String.valueOf(query.get("memberName")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
            query.put("offset",0);
            query.put("limit",10);
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
            if (null != salesDO.getFaliaoDate()){
                salesDO.setFaliaoTime(simpleDateFormat.format(salesDO.getFaliaoDate()));
            }

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
            if (!"".equals(conclusionList.get(0).getRightzx()) && null != conclusionList.get(0).getRightzx()){
                conclusion.setRightzx(conclusionList.get(0).getRightzx());
            } else {
                conclusion.setRightzx("0");
            }

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
            if (null != conclusionList.get(0).getLeftzx() && !"".equals(conclusionList.get(0).getLeftzx())){
                conclusion.setLeftzx(conclusionList.get(0).getLeftzx());
            } else {
                conclusion.setLeftzx("0");
            }
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
        try {
            Method method = Chuank.class.getMethod("main",
                    String[].class);
            method.invoke(null,
                    (Object) new String[4]);
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping(value = "/jiaoduji")
    LensMeterDO jiaoduji(Model model) {
        Map<String,Object> map = new HashMap<>();
        LensMeterDO lensMeterDO = new LensMeterDO();
        //serialPort.sendToData();
        Long id = Long.valueOf(ShiroUtils.getUser().getCompanyId() + ShiroUtils.getUser().getUserId());
        //List<JDJInfoDO> jdjInfoDOS = lensMeterService.jdjList(map);
        JdjInfomationDO jdjInfomationDO = lensMeterService.getJdjInfomation(id);
        if (null != jdjInfomationDO){
            String jdjInfoDOS = jdjInfomationDO.getRemark1() + jdjInfomationDO.getRemark2();
            if (null != jdjInfomationDO.getRemark3() && !"".equals(jdjInfomationDO.getRemark3())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark3();
            }
            if (null != jdjInfomationDO.getRemark4() && !"".equals(jdjInfomationDO.getRemark4())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark4();
            }
            if (null != jdjInfomationDO.getRemark5() && !"".equals(jdjInfomationDO.getRemark5())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark5();
            }
            if (null != jdjInfomationDO.getRemark6() && !"".equals(jdjInfomationDO.getRemark6())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark6();
            }
            if (null != jdjInfomationDO.getRemark7() && !"".equals(jdjInfomationDO.getRemark7())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark7();
            }

            if (null != jdjInfomationDO.getRemark8() && !"".equals(jdjInfomationDO.getRemark8())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark8();
            }
            if (null != jdjInfomationDO.getRemark9() && !"".equals(jdjInfomationDO.getRemark9())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark9();
            }
            if (null != jdjInfomationDO.getRemark10() && !"".equals(jdjInfomationDO.getRemark10())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark10();
            }
            if (null != jdjInfomationDO.getRemark11() && !"".equals(jdjInfomationDO.getRemark11())){
                jdjInfoDOS =  jdjInfoDOS + jdjInfomationDO.getRemark11();
            }
            String dataSerial = SerialPortUtils.hexStringToString(jdjInfoDOS);
                    //String dataSerial = jdjInfoDOS.get(0).getJdjInfo();
            String right = SpringUtil.getStringData(dataSerial," R",2,"PR");
            //Long id = jdjInfoDOS.get(0).getId();
            String zifuRightSph = right.substring(0,1);
            String rightsph = zifuRightSph + right.substring(2,6);
            String zifuRightCyl = right.substring(6,7);
            String rightcyl = zifuRightCyl + right.substring(8, 12);
            String rightzx = right.substring(12, 15);
            if ("0".equals(rightzx.substring(0,1))){
                rightzx =  right.substring(13, 15);
            }
            if ("0".equals(rightzx.substring(0,1))){
                rightzx =  right.substring(14, 15);
            }
            String left = SpringUtil.getStringData(dataSerial," L",2,"PL");
            String zifuLeftSph = left.substring(0, 1);
            String leftsph = zifuLeftSph + left.substring(2, 6);
            String zifuLeftCyl = left.substring(6, 7);
            String leftcyl = zifuLeftCyl + left.substring(8, 12);
            String leftzx = left.substring(12, 15);
            if ("0".equals(leftzx.substring(0,1))){
                leftzx =  left.substring(13, 15);
            }
            if ("0".equals(leftzx.substring(0,1))){
                leftzx =  left.substring(14, 15);
            }
            LensMeterDO lensMeterDOs = new LensMeterDO();
            //lensMeterDO.setId(lensMeterDOList.get(0).getId());
            lensMeterDO.setRightSph(rightsph);
            lensMeterDO.setRightCyl(rightcyl);
            lensMeterDO.setRightZx(rightzx);
            lensMeterDO.setLeftSph(leftsph);
            lensMeterDO.setLeftCyl(leftcyl);
            lensMeterDO.setLeftZx(leftzx);
            lensMeterService.deleteJdjInfomation(id);
//            lensMeterDOs.setRightSph(rightsph);
//            lensMeterDOs.setRightCyl(rightcyl);
//            lensMeterDOs.setRightZx(rightzx);
//            lensMeterDOs.setLeftSph(leftsph);
//            lensMeterDOs.setLeftCyl(leftcyl);
//            lensMeterDOs.setLeftZx(leftzx);
//            lensMeterService.save(lensMeterDOs);
//            lensMeterService.deleteJdj(id);
//            List<LensMeterDO> lensMeterDOList = lensMeterService.list(map);
//            if (null != lensMeterDOList && lensMeterDOList.size() > 0){
//                lensMeterDO.setId(lensMeterDOList.get(0).getId());
//                lensMeterDO.setRightSph(lensMeterDOList.get(0).getRightSph());
//                lensMeterDO.setRightCyl(lensMeterDOList.get(0).getRightCyl());
//                lensMeterDO.setRightZx(lensMeterDOList.get(0).getRightZx());
//                lensMeterDO.setLeftSph(lensMeterDOList.get(0).getLeftSph());
//                lensMeterDO.setLeftCyl(lensMeterDOList.get(0).getLeftCyl());
//                lensMeterDO.setLeftZx(lensMeterDOList.get(0).getLeftZx());
//            }
        }
        model.addAttribute("lensMeterDO",lensMeterDO);
        try {
            Method method = Chuank.class.getMethod("main",
                    String[].class);
            method.invoke(null,
                    (Object) new String[4]);
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
        return lensMeterDO;
    }

}
