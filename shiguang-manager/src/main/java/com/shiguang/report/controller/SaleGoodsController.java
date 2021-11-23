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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                        }

                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            jjMoney = jjMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("镜片".equals(goodsType)){
                                if ("镜片".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            jpcount = jpcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            jpMoney = jpMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("配件".equals(goodsType)){
                                if ("配件".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            pjMoney = pjMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("隐形".equals(goodsType)){
                                if ("隐形".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            yxMoney = yxMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("护理液".equals(goodsType)){
                                if ("护理液".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            hlyMoney = hlyMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("视光".equals(goodsType)){
                                if ("视光".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            sgMoney = sgMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                            } else if ("自架".equals(goodsType)){
                                if ("自架".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                    }
                                    zjMoney = 0.00;
                                }
                            } else if ("自片".equals(goodsType)){
                                if ("自片".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        zpcount = zpcount + Integer.parseInt(storeCount[i]);
                                    }
                                    zpMoney = 0.00;
                                }
                            }
                            if (null != salesDO.getAdditionalPrice()){
                                try {
                                    String[] addPrice = salesDO.getAdditionalPrice().split(",");
                                    if (addPrice.length > 0){
                                        if (null != addPrice[i] && !"".equals(addPrice[i])){
                                            addMoney = addMoney + Double.valueOf(addPrice[i]);
                                        }

                                    } else {
                                        addMoney = addMoney + 0.00;
                                    }
                                }catch (ArrayIndexOutOfBoundsException e) {
                                    addMoney = addMoney + 0.00;
                                }
                            }
                        }
                    } else {
                        for (int i=0;i<storeDescribe.length;i++){
                                if ("镜架".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                        }

                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            jjMoney = jjMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("镜片".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            jpcount = jpcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            jpMoney = jpMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("配件".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            pjMoney = pjMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("隐形".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if(null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            yxMoney = yxMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("护理液".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            hlyMoney = hlyMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("视光".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])) {
                                            sgMoney = sgMoney + Double.valueOf(Double.valueOf(storeMoney[i])*Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                }
                                if ("自架".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                    }
                                    zjMoney = 0.00;
                                }
                                if ("自片".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        zpcount = zpcount + Integer.parseInt(storeCount[i]);
                                    }
                                    zpMoney = 0.00;
                                }
                            if (null != salesDO.getAdditionalPrice()){
                                try {
                                    String[] addPrice = salesDO.getAdditionalPrice().split(",");
                                    if (addPrice.length > 0){
                                        if (null != addPrice[i] && !"".equals(addPrice[i])){
                                            addMoney = addMoney + Double.valueOf(addPrice[i]);
                                        }

                                    } else {
                                        addMoney = addMoney + 0.00;
                                    }
                                }catch (ArrayIndexOutOfBoundsException e) {
                                    addMoney = addMoney + 0.00;
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
                                addMoney = addMoney + 0.00;
                            }
                        }catch (ArrayIndexOutOfBoundsException e) {
                            addMoney = addMoney + 0.00;
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
                model.addAttribute("jjMoney",new BigDecimal(jjMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("jjpercen",0.0);
                } else {
                    jjpercen = numberformat.format((float)jjMoney/(float)totalMoney*100);
                    model.addAttribute("jjpercen",jjpercen+"%");
                }
            } else if ("镜片".equals(goodsType)){
                model.addAttribute("jpcount",jpcount);
                model.addAttribute("jpMoney",new BigDecimal(jpMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("jppercen",0.0);
                } else {
                    jppercen = numberformat.format((float)jpMoney/(float)totalMoney*100);
                    model.addAttribute("jppercen",jppercen+"%");
                }
            } else if ("配件".equals(goodsType)){
                model.addAttribute("pjcount",pjcount);
                model.addAttribute("pjMoney",new BigDecimal(pjMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("pjpercen",0.0);
                } else {
                    pjpercen = numberformat.format((float)pjMoney/(float)totalMoney*100);
                    model.addAttribute("pjpercen",pjpercen+"%");
                }
            } else if ("隐形".equals(goodsType)){
                model.addAttribute("yxcount",yxcount);
                model.addAttribute("yxMoney",new BigDecimal(yxMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("yxpercen",0.0);
                }else {
                    yxpercen = numberformat.format((float)yxMoney/(float)totalMoney*100);
                    model.addAttribute("yxpercen",yxpercen+"%");
                }
            } else if ("护理液".equals(goodsType)){
                model.addAttribute("hlycount",hlycount);
                model.addAttribute("hlyMoney",new BigDecimal(hlyMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("hlypercen",0.0);
                } else {
                    hlypercen = numberformat.format((float)hlyMoney/(float)totalMoney*100);
                    model.addAttribute("hlypercen",hlypercen+"%");
                }
            } else if ("视光".equals(goodsType)){
                model.addAttribute("sgcount",sgcount);
                model.addAttribute("sgMoney",new BigDecimal(sgMoney).setScale(2,RoundingMode.HALF_UP));
                if (totalMoney == 0.0){
                    model.addAttribute("sgpercen",0.0);
                } else {
                    sgpercen = numberformat.format((float)sgMoney/(float)totalMoney*100);
                    model.addAttribute("sgpercen",sgpercen+"%");
                }
            } else if ("自架".equals(goodsType)){
                model.addAttribute("zjcount",zjcount);
                model.addAttribute("zjMoney",zjMoney);
                model.addAttribute("zjpercen",0.0);
            } else if ("自片".equals(goodsType)){
                model.addAttribute("zpcount",zpcount);
                model.addAttribute("zpMoney",zpMoney);
                model.addAttribute("zppercen",0.00);
            }
        } else {
            model.addAttribute("jjcount",jjcount);
            if(totalMoney == 0.0){
                model.addAttribute("jjpercen",0.0);
                model.addAttribute("jppercen",0.0);
                model.addAttribute("pjpercen",0.0);
                model.addAttribute("yxpercen",0.0);
                model.addAttribute("hlypercen",0.0);
                model.addAttribute("sgpercen",0.0);
            } else {
                jjpercen = numberformat.format((float)jjMoney/(float)totalMoney*100);
                model.addAttribute("jjpercen",jjpercen+"%");
                jppercen = numberformat.format((float)jpMoney/(float)totalMoney*100);
                model.addAttribute("jppercen",jppercen+"%");
                pjpercen = numberformat.format((float)pjMoney/(float)totalMoney*100);
                model.addAttribute("pjpercen",pjpercen+"%");
                yxpercen = numberformat.format((float)yxMoney/(float)totalMoney*100);
                model.addAttribute("yxpercen",yxpercen+"%");
                hlypercen = numberformat.format((float)hlyMoney/(float)totalMoney*100);
                model.addAttribute("hlypercen",hlypercen+"%");
                sgpercen = numberformat.format((float)sgMoney/(float)totalMoney*100);
                model.addAttribute("sgpercen",sgpercen+"%");
            }
            model.addAttribute("jjMoney",new BigDecimal(jjMoney).setScale(2,RoundingMode.HALF_UP));
            model.addAttribute("zjpercen",0.0);
            model.addAttribute("zjcount",zjcount);
            model.addAttribute("zjMoney",zjMoney);
            model.addAttribute("zppercen",0.0);
            model.addAttribute("zpcount",zpcount);
            model.addAttribute("zpMoney",zpMoney);
            model.addAttribute("jpcount",jpcount);
            model.addAttribute("jpMoney",new BigDecimal(jpMoney).setScale(2,RoundingMode.HALF_UP));
            model.addAttribute("pjcount",pjcount);
            model.addAttribute("pjMoney",new BigDecimal(pjMoney).setScale(2,RoundingMode.HALF_UP));
            model.addAttribute("yxcount",yxcount);
            model.addAttribute("yxMoney",new BigDecimal(yxMoney).setScale(2,RoundingMode.HALF_UP));
            model.addAttribute("hlycount",hlycount);
            model.addAttribute("hlyMoney",new BigDecimal(hlyMoney).setScale(2,RoundingMode.HALF_UP));
            model.addAttribute("sgcount",sgcount);
            model.addAttribute("sgMoney",new BigDecimal(sgMoney).setScale(2,RoundingMode.HALF_UP));
        }
        model.addAttribute("goodsType",goodsType);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalMoney",new BigDecimal(totalMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("addMoney",new BigDecimal(addMoney).setScale(2,RoundingMode.HALF_UP));
        //SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleGoodReportForm";
    }

    @GetMapping("/salegoodsNameList")
    public String salegoodNamesList(String settleDateStart,String settleDateEnd,String goodsType,Model model) {
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
        double sumMoney = 0.00;
        List<Map<String,Object>> list = new ArrayList<>();
        if (null != salesDOList && salesDOList.size() > 0){
            for (SalesDO salesDO : salesDOList){
                String[] storeDescribe = null;
                String[] storeCount = null;
                String[] storeMoney = null;
                String[] goodsNum = null;
                String[] storeName = null;
                if (null != salesDO.getStoreName() && !"".equals(salesDO.getStoreName())){
                    storeName = salesDO.getStoreName().split(",");
                }
                if (null != salesDO.getGoodsNum() && !"".equals(salesDO.getGoodsNum())){
                    goodsNum = salesDO.getGoodsNum().split(",");
                }
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
                        for (int i=0;i<storeDescribe.length;i++){
                            Map<String,Object> map = new HashMap<>();
                            if ("镜架".equals(goodsType)){
                                if ("镜架".equals(storeDescribe[i])){
                                    //jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                    //jjMoney = jjMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
                                }
                            } else if ("镜片".equals(goodsType)){
                                if ("镜片".equals(storeDescribe[i])){
                                    //jpcount = jpcount + Integer.parseInt(storeCount[i]);
                                    //jpMoney = jpMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
                                }
                            } else if ("配件".equals(goodsType)){
                                if ("配件".equals(storeDescribe[i])){
                                    //pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                    //pjMoney = pjMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
                                }
                            } else if ("隐形".equals(goodsType)){
                                if ("隐形".equals(storeDescribe[i])){
                                    //yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                    //yxMoney = yxMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
                                }
                            } else if ("护理液".equals(goodsType)){
                                if ("护理液".equals(storeDescribe[i])){
                                    //hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                    //hlyMoney = hlyMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
                                }
                            } else if ("视光".equals(goodsType)){
                                if ("视光".equals(storeDescribe[i])){
                                    //sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                    //sgMoney = sgMoney + Double.valueOf(storeMoney[i]);
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            sumMoney = sumMoney + Double.valueOf(storeMoney[i]);
                                        }
                                    }
                                    if (null != goodsNum && !"".equals(goodsNum)){
                                        if (null != goodsNum[i] && !"".equals(goodsNum[i])){
                                            map.put("goodsNum",goodsNum[i]);
                                        } else {
                                            map.put("goodsNum","");
                                        }
                                    } else {
                                        map.put("goodsNum","");
                                    }
                                    if (null != storeName && !"".equals(storeName)){
                                        if (null != storeName[i] && !"".equals(storeName[i])){
                                            map.put("name",storeName[i]);
                                        } else {
                                            map.put("name","");
                                        }
                                    } else {
                                        map.put("name","");
                                    }
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])){
                                            map.put("count",storeCount[i]);
                                        } else {
                                            map.put("count",0);
                                        }
                                    } else {
                                        map.put("count",0);
                                    }
                                    if (null != storeMoney && !"".equals(storeMoney)){
                                        if (null != storeMoney[i] && !"".equals(storeMoney[i])){
                                            map.put("money",storeMoney[i]);
                                        } else {
                                            map.put("money",0.00);
                                        }
                                    } else {
                                        map.put("money",0.00);
                                    }
                                    list.add(map);
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
                                        if (null != addPrice[i] && !"".equals(addPrice[i])){
                                            addMoney = addMoney + Double.valueOf(addPrice[i]);
                                        }
                                    } else {
                                        addMoney = addMoney + 0.00;
                                    }
                                }catch (ArrayIndexOutOfBoundsException e) {
                                    addMoney = addMoney + 0.00;
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
                                addMoney = addMoney + 0.00;
                            }
                        }catch (ArrayIndexOutOfBoundsException e) {
                            addMoney = addMoney + 0.00;
                        }
                    }
                }

            }
        }
        //int totalCount  = jjcount + jpcount + pjcount + yxcount + hlycount + sgcount + zjcount + zpcount;
        //double totalMoney = jjMoney + jpMoney + pjMoney + yxMoney + hlyMoney + sgMoney;
        java.text.NumberFormat numberformat=java.text.NumberFormat.getInstance();
        numberformat.setMaximumFractionDigits(2);
        List<Map<String,Object>> lists = new ArrayList<>();
        String ss="";
        int totalCount = 0;
        int a=-1;
        for (int i=0;i<list.size();i++){
            Map<String,Object> map = new HashMap<>();
            totalCount = totalCount + Integer.parseInt(list.get(i).get("count").toString());
            if (ss.equals(list.get(i).get("goodsNum"))){
                for (int j=0;j<lists.size();j++){
                    map.put("goodsNum",list.get(i).get("goodsNum"));
                    map.put("name",list.get(i).get("name"));
                    map.put("count",Integer.parseInt(list.get(i).get("count").toString())
                            + Integer.parseInt(lists.get(j).get("count").toString()));
                    map.put("money",Double.valueOf(list.get(i).get("money").toString())
                            + Double.valueOf(lists.get(j).get("money").toString()));
                    double money = Double.valueOf(map.get("money")+"");
                    map.put("percent",numberformat.format((float)money/(float)sumMoney*100)+"%");
                }
                lists.remove(a);
            } else {
                a=a+1;
                ss = list.get(i).get("goodsNum").toString();
                map.put("goodsNum",list.get(i).get("goodsNum"));
                map.put("name",list.get(i).get("name"));
                map.put("count",list.get(i).get("count"));
                map.put("money",list.get(i).get("money"));
                double money = Double.valueOf(map.get("money")+"");
                map.put("percent",numberformat.format((float)money/(float)sumMoney*100)+"%");
            }
            lists.add(map);
        }
        model.addAttribute("lists",lists);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalMoney",new BigDecimal(sumMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("addMoney",new BigDecimal(addMoney).setScale(2,RoundingMode.HALF_UP));
        //SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleGoodNameReportForm";
    }
}
