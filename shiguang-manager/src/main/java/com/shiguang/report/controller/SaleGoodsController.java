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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/saleGoods")
public class SaleGoodsController {
    @Autowired
    private SaleReportService saleReportService;

    @GetMapping()
    @RequiresPermissions("information:saleGoods:saleGoods")
    String SaleGoods(){
        return "saleReport/saleGoodReport";
    }

    @GetMapping("/salegoodsList")
    public String salegoodsList(String settleDateStart,String settleDateEnd,String goodsType,Model model) {
        Map<String,Object> query = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        if (!"".equals(settleDateStart)){
            query.put("settleDateStart",settleDateStart);
            model.addAttribute("settleDateStart",settleDateStart);
        } else {
            query.put("settleDateStart",simpleDateFormat.format(date));
            model.addAttribute("settleDateStart",simpleDateFormat.format(date));
        }
        if (!"".equals(settleDateEnd)){
            query.put("settleDateEnd",settleDateEnd);
            model.addAttribute("settleDateEnd",settleDateEnd);
        } else {
            query.put("settleDateEnd",simpleDateFormat.format(date));
            model.addAttribute("settleDateEnd",simpleDateFormat.format(date));
        }
        List<SalesDO> salesDOList = saleReportService.findGoodsList(query);
        int jjcount = 0;
        double jjMoney = 0.00;
        int pjcount=0;
        double pjMoney = 0.00;
        int jpcount = 0;
        double jpMoney = 0.00;
        int yxcount = 0;
        double yxMoney = 0.00;
        int hlycount = 0;
        double hlyMoney = 0.00;
        int sgcount = 0;
        double sgMoney = 0.00;
        double addMoney = 0.00;
        if (null != salesDOList && salesDOList.size() > 0){
            for (SalesDO salesDO : salesDOList){
                String[] storeDescribe = salesDO.getStoreDescribe().split(",");
                String[] storeCount = salesDO.getStoreCount().split(",");
                String[] storeMoney = salesDO.getStoreUnit().split(",");
//                String[] addPrice = null;
//                if (null != salesDO.getAdditionalPrice()){
//                     addPrice = salesDO.getAdditionalPrice().split(",");
//                     for (int a =0; a<addPrice.length;a++){
//                         addMoney = addMoney + Double.valueOf(addPrice[a]);
//                     }
//                }
                if (!"".equals(goodsType) && null != goodsType){
                    for (int i=0;i<storeDescribe.length;i++){
                        if ("镜架".equals(goodsType)){
                            if ("镜架".equals(storeDescribe[i])){
                                jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                jjMoney = jjMoney + Double.valueOf(storeMoney[i]);
                            }
                        } else if ("镜片".equals(goodsType)){
                            if ("镜片".equals(storeDescribe[i])){
                                jpcount = jpcount + Integer.parseInt(storeCount[i]);
                                jpMoney = jpMoney + Double.valueOf(storeMoney[i]);
                            }
                        } else if ("配件".equals(goodsType)){
                            if ("配件".equals(storeDescribe[i])){
                                pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                pjMoney = pjMoney + Double.valueOf(storeMoney[i]);
                            }
                        } else if ("隐形".equals(goodsType)){
                            if ("隐形".equals(storeDescribe[i])){
                                yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                yxMoney = yxMoney + Double.valueOf(storeMoney[i]);
                            }
                        } else if ("护理液".equals(goodsType)){
                            if ("护理液".equals(storeDescribe[i])){
                                hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                hlyMoney = hlyMoney + Double.valueOf(storeMoney[i]);
                            }
                        } else if ("视光".equals(goodsType)){
                            if ("视光".equals(storeDescribe[i])){
                                sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                sgMoney = sgMoney + Double.valueOf(storeMoney[i]);
                            }
                        }
                        if (null != salesDO.getAdditionalPrice()){
                            try {
                                String[] addPrice = salesDO.getAdditionalPrice().split(",");
                                if (addPrice.length > 0){
                                    addMoney = addMoney + Double.valueOf(addPrice[i]);
                                } else {
                                    addMoney = 0.00;
                                }
                            }catch (ArrayIndexOutOfBoundsException e) {
                                addMoney = 0.00;
                            }
                        }
                    }
                } else {
                    for (int i=0;i<storeDescribe.length;i++){
                        if ("镜架".equals(storeDescribe[i])){
                            jjcount = jjcount + Integer.parseInt(storeCount[i]);
                            jjMoney = jjMoney + Double.valueOf(storeMoney[i]);
                        }
                        if ("配件".equals(storeDescribe[i])){
                            pjcount = pjcount + Integer.parseInt(storeCount[i]);
                            pjMoney = pjMoney + Double.valueOf(storeMoney[i]);
                        }
                        if ("镜片".equals(storeDescribe[i])){
                            jpcount = jpcount + Integer.parseInt(storeCount[i]);
                            jpMoney = jpMoney + Double.valueOf(storeMoney[i]);
                        }
                        if ("隐形".equals(storeDescribe[i])){
                            yxcount = yxcount + Integer.parseInt(storeCount[i]);
                            yxMoney = yxMoney + Double.valueOf(storeMoney[i]);
                        }
                        if ("护理液".equals(storeDescribe[i])){
                            hlycount = hlycount + Integer.parseInt(storeCount[i]);
                            hlyMoney = hlyMoney + Double.valueOf(storeMoney[i]);
                        }
                        if ("视光".equals(storeDescribe[i])){
                            sgcount = sgcount + Integer.parseInt(storeCount[i]);
                            sgMoney = sgMoney + Double.valueOf(storeMoney[i]);
                        }
                        if (null != salesDO.getAdditionalPrice()){
                            try {
                                String[] addPrice = salesDO.getAdditionalPrice().split(",");
                                if (addPrice.length > 0){
                                    addMoney = addMoney + Double.valueOf(addPrice[i]);
                                } else {
                                    addMoney = 0.00;
                                }
                            }catch (ArrayIndexOutOfBoundsException e) {
                                addMoney = 0.00;
                            }
                        }
                    }
                }
            }
        }
        int totalCount  = jjcount + jpcount + pjcount + yxcount + hlycount + sgcount;
        double totalMoney = jjMoney + jpMoney + pjMoney + yxMoney + hlyMoney + sgMoney;
        if (!"".equals(goodsType) && null != goodsType){
            if ("镜架".equals(goodsType)){
                model.addAttribute("jjcount",jjcount);
                model.addAttribute("jjMoney",jjMoney);
            } else if ("镜片".equals(goodsType)){
                model.addAttribute("jpcount",jpcount);
                model.addAttribute("jpMoney",jpMoney);
            } else if ("配件".equals(goodsType)){
                model.addAttribute("pjcount",pjcount);
                model.addAttribute("pjMoney",pjMoney);
            } else if ("隐形".equals(goodsType)){
                model.addAttribute("yxcount",yxcount);
                model.addAttribute("yxMoney",yxMoney);
            } else if ("护理液".equals(goodsType)){
                model.addAttribute("hlycount",hlycount);
                model.addAttribute("hlyMoney",hlyMoney);
            } else if ("视光".equals(goodsType)){
                model.addAttribute("sgcount",sgcount);
                model.addAttribute("sgMoney",sgMoney);
            }
        } else {
            model.addAttribute("jjcount",jjcount);
            model.addAttribute("jjMoney",jjMoney);
            model.addAttribute("jpcount",jpcount);
            model.addAttribute("jpMoney",jpMoney);
            model.addAttribute("pjcount",pjcount);
            model.addAttribute("pjMoney",pjMoney);
            model.addAttribute("yxcount",yxcount);
            model.addAttribute("yxMoney",yxMoney);
            model.addAttribute("hlycount",hlycount);
            model.addAttribute("hlyMoney",hlyMoney);
            model.addAttribute("sgcount",sgcount);
            model.addAttribute("sgMoney",sgMoney);
        }
        model.addAttribute("goodsType",goodsType);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("addMoney",addMoney);
        //SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleGoodReportForm";
    }
}
