package com.shiguang.report.controller;

import com.shiguang.report.service.SaleReportService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/information/saleName")
public class SaleNameController {
    @Autowired
    private SaleReportService saleReportService;

    @GetMapping()
    @RequiresPermissions("information:saleName:saleName")
    String SaleGoods(){
        return "saleName/saleName";
    }

    @GetMapping("/salenameList")
    public String salenameList(String settleDateStart,String settleDateEnd,Model model) {
        Map<String,Object> query = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        if (!"".equals(settleDateStart)){
            query.put("settleDateStart",settleDateStart);
        } else {
            query.put("settleDateStart",simpleDateFormat.format(date));
        }
        if (!"".equals(settleDateEnd)){
            query.put("settleDateEnd",settleDateEnd);
        } else {
            query.put("settleDateEnd",simpleDateFormat.format(date));
        }
        List<SalesDO> salesDOList = saleReportService.findGoodsList(query);
        List<SalesDO> saleNameList = saleReportService.findSaleNameList(query);
        List<Map<String,Object>> list = new ArrayList<>();
        //String salename="";
        if (null != salesDOList && salesDOList.size() > 0){
            for (SalesDO salesDO : saleNameList){
                int jjcount=0;
                double jjMoney=0.00;
                int jpcount=0;
                double jpMoney=0.00;
                int pjcount=0;
                double pjMoney=0.00;
                int yxcount=0;
                double yxMoney=0.00;
                int hlycount=0;
                double hlyMoney=0.00;
                int sgcount=0;
                double sgMoney=0.00;
                for (SalesDO salesDOs : salesDOList){
                    String[] storeDescribe = salesDOs.getStoreDescribe().split(",");
                    String[] storeCount = salesDOs.getStoreCount().split(",");
                    String[] storeUnit = salesDOs.getStoreUnit().split(",");
                    if (salesDO.getSaleName().equals(salesDOs.getSaleName())){
                        for (int i=0;i<storeDescribe.length;i++){
                            if ("镜架".equals(storeDescribe[i])){
                                jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                jjMoney = jjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("镜片".equals(storeDescribe[i])){
                                jpcount = jpcount + Integer.parseInt(storeCount[i]);
                                jpMoney = jpMoney + Double.valueOf(storeUnit[i]);
                            } else if ("配件".equals(storeDescribe[i])){
                                pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                pjMoney = pjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("隐形".equals(storeDescribe[i])){
                                yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                yxMoney = yxMoney + Double.valueOf(storeUnit[i]);
                            } else if ("护理液".equals(storeDescribe[i])){
                                hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                hlyMoney = hlyMoney + Double.valueOf(storeUnit[i]);
                            } else if ("视光".equals(storeDescribe[i])){
                                sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                sgMoney = sgMoney + Double.valueOf(storeUnit[i]);
                            }
                        }
                    }
                }
                Map<String,Object> map = new HashMap<>();
                map.put("saleName",salesDO.getSaleName());
                map.put("jjcount",jjcount);
                map.put("jjMoney",jjMoney);
                map.put("jpcount",jpcount);
                map.put("jpMoney",jpMoney);
                map.put("pjcount",pjcount);
                map.put("pjMoney",pjMoney);
                map.put("yxcount",yxcount);
                map.put("yxMoney",yxMoney);
                map.put("hlycount",hlycount);
                map.put("hlyMoney",hlyMoney);
                map.put("sgcount",sgcount);
                map.put("sgMoney",sgMoney);
                list.add(map);
            }

        }
        model.addAttribute("list",list);
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "";
    }
}
