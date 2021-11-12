package com.shiguang.report.controller;

import com.shiguang.report.service.SaleReportService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.NumberFormat;
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
        String jjpercen = "";
        double jjMoney = 0.00;
        int zjcount = 0;
        String zjpercen = "";
        double zjMoney = 0.00;
        int zpcount = 0;
        String zppercen = "";
        double zpMoney = 0.00;
        int pjcount=0;
        String pjpercen = "";
        double pjMoney = 0.00;
        int jpcount = 0;
        String jppercen = "";
        double jpMoney = 0.00;
        int yxcount = 0;
        String yxpercen = "";
        double yxMoney = 0.00;
        int hlycount = 0;
        String hlypercen = "";
        double hlyMoney = 0.00;
        int sgcount = 0;
        String sgpercen = "";
        double sgMoney = 0.00;
        double addMoney = 0.00;
        if (null != salesDOList && salesDOList.size() > 0){
            for (SalesDO salesDO : salesDOList){
                String[] storeDescribe = null;
                String[] storeCount = null;
                String[] storeMoney = null;
                if (null != salesDO.getStoreDescribe()){
                    storeDescribe = salesDO.getStoreDescribe().split(",");
                }
                if (null != salesDO.getStoreCount()){
                    storeCount = salesDO.getStoreCount().split(",");
                }
                if (null != salesDO.getStoreUnit()){
                    storeMoney = salesDO.getStoreUnit().split(",");
                }
//                String[] addPrice = null;
//                if (null != salesDO.getAdditionalPrice()){
//                     addPrice = salesDO.getAdditionalPrice().split(",");
//                     for (int a =0; a<addPrice.length;a++){
//                         addMoney = addMoney + Double.valueOf(addPrice[a]);
//                     }
//                }
                if (null != storeDescribe){
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
                            } else if ("自架".equals(goodsType)){
                                if ("自架".equals(storeDescribe[i])){
                                    zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                    zjMoney = zjMoney + Double.valueOf(storeMoney[i]);
                                }
                            } else if ("自片".equals(goodsType)){
                                if ("自片".equals(storeDescribe[i])){
                                    zpcount = zpcount + Integer.parseInt(storeCount[i]);
                                    zpMoney = zpMoney +Double.valueOf(storeMoney[i]);
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
                            }  else if ("自架".equals(goodsType)){
                                if ("自架".equals(storeDescribe[i])){
                                    zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                    zjMoney = 0.00;
                                }
                            } else if ("自片".equals(goodsType)){
                                if ("自片".equals(storeDescribe[i])){
                                    zpcount = zpcount + Integer.parseInt(storeCount[i]);
                                    zpMoney = 0.00;
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
                    }
                }else {
                    if (null != salesDO.getAdditionalPrice()){
                        try {
                            String[] addPrice = salesDO.getAdditionalPrice().split(",");
                            if (addPrice.length > 0){
                                for (int w=0;w<addPrice.length;w++){
                                    addMoney = addMoney + Double.valueOf(addPrice[w]);
                                }

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
        int totalCount  = jjcount + jpcount + pjcount + yxcount + hlycount + sgcount + zjcount + zpcount;
        double totalMoney = jjMoney + jpMoney + pjMoney + yxMoney + hlyMoney + sgMoney;
        java.text.NumberFormat numberformat=java.text.NumberFormat.getInstance();
        numberformat.setMaximumFractionDigits(2);
        if (!"".equals(goodsType) && null != goodsType){
            if ("镜架".equals(goodsType)){
                model.addAttribute("jjcount",jjcount);
                model.addAttribute("jjMoney",jjMoney);
                jjpercen = numberformat.format((float)jjMoney/(float)totalMoney*100);
                model.addAttribute("jjpercen",jjpercen+"%");
            } else if ("镜片".equals(goodsType)){
                model.addAttribute("jpcount",jpcount);
                model.addAttribute("jpMoney",jpMoney);
                jppercen = numberformat.format((float)jpMoney/(float)totalMoney*100);
                model.addAttribute("jppercen",jppercen+"%");
            } else if ("配件".equals(goodsType)){
                model.addAttribute("pjcount",pjcount);
                model.addAttribute("pjMoney",pjMoney);
                pjpercen = numberformat.format((float)pjMoney/(float)totalMoney*100);
                model.addAttribute("pjpercen",pjpercen+"%");
            } else if ("隐形".equals(goodsType)){
                model.addAttribute("yxcount",yxcount);
                model.addAttribute("yxMoney",yxMoney);
                yxpercen = numberformat.format((float)yxMoney/(float)totalMoney*100);
                model.addAttribute("yxpercen",yxpercen+"%");
            } else if ("护理液".equals(goodsType)){
                model.addAttribute("hlycount",hlycount);
                model.addAttribute("hlyMoney",hlyMoney);
                hlypercen = numberformat.format((float)hlyMoney/(float)totalMoney*100);
                model.addAttribute("hlypercen",hlypercen+"%");
            } else if ("视光".equals(goodsType)){
                model.addAttribute("sgcount",sgcount);
                model.addAttribute("sgMoney",sgMoney);
                sgpercen = numberformat.format((float)sgMoney/(float)totalMoney*100);
                model.addAttribute("sgpercen",sgpercen+"%");
            } else if ("自架".equals(goodsType)){
                model.addAttribute("zjcount",zjcount);
                model.addAttribute("zjMoney",zjMoney);
                model.addAttribute("zjpercen",zjpercen);
            } else if ("自片".equals(goodsType)){
                model.addAttribute("zpcount",zpcount);
                model.addAttribute("zpMoney",zpMoney);
                model.addAttribute("zppercen",zppercen);
            }
        } else {
            model.addAttribute("jjcount",jjcount);
            jjpercen = numberformat.format((float)jjMoney/(float)totalMoney*100);
            model.addAttribute("jjpercen",jjpercen+"%");
            model.addAttribute("jjMoney",jjMoney);
            model.addAttribute("zjpercen",zjpercen);
            model.addAttribute("zjcount",zjcount);
            model.addAttribute("zjMoney",zjMoney);
            model.addAttribute("zppercen",zppercen);
            model.addAttribute("zpcount",zpcount);
            model.addAttribute("zpMoney",zpMoney);
            jppercen = numberformat.format((float)jpMoney/(float)totalMoney*100);
            model.addAttribute("jppercen",jppercen+"%");
            model.addAttribute("jpcount",jpcount);
            model.addAttribute("jpMoney",jpMoney);
            pjpercen = numberformat.format((float)pjMoney/(float)totalMoney*100);
            model.addAttribute("pjpercen",pjpercen+"%");
            model.addAttribute("pjcount",pjcount);
            model.addAttribute("pjMoney",pjMoney);
            yxpercen = numberformat.format((float)yxMoney/(float)totalMoney*100);
            model.addAttribute("yxpercen",yxpercen+"%");
            model.addAttribute("yxcount",yxcount);
            model.addAttribute("yxMoney",yxMoney);
            hlypercen = numberformat.format((float)hlyMoney/(float)totalMoney*100);
            model.addAttribute("hlypercen",hlypercen+"%");
            model.addAttribute("hlycount",hlycount);
            model.addAttribute("hlyMoney",hlyMoney);
            sgpercen = numberformat.format((float)sgMoney/(float)totalMoney*100);
            model.addAttribute("sgpercen",sgpercen+"%");
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
