package com.shiguang.report.controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.report.service.SaleReportService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        return "saleReport/saleNameReport";
    }

    @GetMapping("/salenameList")
    public String salenameList(String settleDateStart,String settleDateEnd,String departNumber,Model model) {
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
        if (!"".equals(departNumber)){
            query.put("departNumber",departNumber);
        }else {
            query.put("departNumber", ShiroUtils.getUser().getStoreNum());
        }
        List<SalesDO> salesDOList = saleReportService.findGoodsList(query);
        List<SalesDO> saleNameList = saleReportService.findSaleNameList(query);
        List<Map<String,Object>> list = new ArrayList<>();
        //String salename="";
        if (null != salesDOList && salesDOList.size() > 0){
            for (SalesDO salesDO : saleNameList){
                int jjcount=0;
                double jjMoney=0.00;
                int jpcpcount=0;
                double jpcpMoney=0.00;
                int jpdzcount=0;
                double jpdzMoney=0.00;
                int pjcount=0;
                double pjMoney=0.00;
                int jjpjcount=0;
                double jjpjMoney=0.00;
                int zjcount=0;
                double zjMoney = 0.00;
                int zpcount=0;
                double zpMoney = 0.00;
                int yxcount=0;
                double yxMoney=0.00;
                int tyjcount= 0;
                double tyjMoney = 0.00;
                int lhjcount=0;
                double lhjMoney = 0.00;
                int hccount=0;
                double hcMoney=0.00;
                double addMoney = 0.00;
                int hlycount=0;
                double hlyMoney=0.00;
                int sgcount=0;
                double sgMoney=0.00;
                int sgdzcount=0;
                double sgdzMoney=0.00;
                double primMoney=0.00;
                double amountMoney=0.00;
                for (SalesDO salesDOs : salesDOList){
                    String[] storeDescribe = null;
                    String[] storeCount = null;
                    String[] storeUnit = null;
                    String[] classType = null;
                    if (null != salesDOs.getStoreDescribe() && !"".equals(salesDOs.getStoreDescribe())){
                        storeDescribe = salesDOs.getStoreDescribe().split(",");
                    }
                    if (null != salesDOs.getStoreCount() && !"".equals(salesDOs.getStoreCount())){
                        storeCount = salesDOs.getStoreCount().split(",");
                    }

                    if (null != salesDOs.getStoreUnit() && !"".equals(salesDOs.getStoreUnit())){
                        storeUnit = salesDOs.getStoreUnit().split(",");
                    }

                    if (null != salesDOs.getClasstype() && !"".equals(salesDOs.getClasstype())){
                        classType = salesDOs.getClasstype().split(",");
                    }
                    if (salesDO.getSaleName().equals(salesDOs.getSaleName())){
                        if (null != storeDescribe){
                            for (int i=0;i<storeDescribe.length;i++){
                                if ("镜架".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                        }

                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                jjMoney = jjMoney + Double.valueOf((Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i])));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                jjMoney = jjMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }
                                    }

                                } else if ("镜片".equals(storeDescribe[i])){
                                    if (null != classType){
                                        if (null != classType[i] && !"".equals(classType[i])) {
                                            if ("1".equals(classType[i])) {
                                                if (null != storeCount && !"".equals(storeCount)) {
                                                    if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                                        jpcpcount = jpcpcount + Integer.parseInt(storeCount[i]);
                                                    }
                                                }
                                                if (null != storeUnit && !"".equals(storeUnit)) {
                                                    if (null != storeCount && !"".equals(storeCount)) {
                                                        if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                            jpcpMoney = jpcpMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                                        }
                                                        } else {
                                                        if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                            jpcpMoney = jpcpMoney + Double.valueOf(storeUnit[i]);
                                                        }
                                                    }

                                                }
                                            } else if ("2".equals(classType[i])) {
                                                if (null != storeCount && !"".equals(storeCount)) {
                                                    if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                                        jpdzcount = jpdzcount + Integer.parseInt(storeCount[i]);
                                                    }
                                                }
                                                if (null != storeUnit && !"".equals(storeUnit)) {
                                                    if (null != storeCount && !"".equals(storeCount)) {
                                                        if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                            jpdzMoney = jpdzMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                                        }
                                                        } else {
                                                        if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                            jpdzMoney = jpdzMoney + Double.valueOf(storeUnit[i]);
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }

                                } else if ("配件".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                pjMoney = pjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                pjMoney = pjMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("镜架配件".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            jjpjcount = jjpjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                jjpjMoney = jjpjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                jjpjMoney = jjpjMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("隐形".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                yxMoney = yxMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                yxMoney = yxMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("护理液".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeUnit[i] && !"".equals(storeUnit[i])){
                                            if (null != storeCount && !"".equals(storeCount)){
                                                if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                    hlyMoney = hlyMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                                }
                                            } else {
                                                if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                    hlyMoney = hlyMoney + Double.valueOf(storeUnit[i]);
                                                }
                                            }
                                        }
                                    }

                                } else if ("视光".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                sgMoney = sgMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                sgMoney = sgMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("视光订做".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            sgdzcount = sgdzcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                sgdzMoney = sgdzMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                sgdzMoney = sgdzMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("自架".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    zjMoney = 0.00;
                                } else if ("自片".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            zpcount = zpcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    zpMoney = 0.00;
                                } else if ("太阳镜".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            tyjcount = tyjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                tyjMoney = tyjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                tyjMoney = tyjMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                } else if ("老花镜".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            lhjcount = lhjcount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                lhjMoney = lhjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                lhjMoney = lhjMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }
                                    }
                                } else if ("耗材".equals(storeDescribe[i])){
                                    if (null != storeCount && !"".equals(storeCount)){
                                        if (null != storeCount[i] && !"".equals(storeCount[i])) {
                                            hccount = hccount + Integer.parseInt(storeCount[i]);
                                        }
                                    }
                                    if (null != storeUnit && !"".equals(storeUnit)){
                                        if (null != storeCount && !"".equals(storeCount)){
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                hcMoney = hcMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                            }
                                        } else {
                                            if (null != storeUnit[i] && !"".equals(storeUnit[i])) {
                                                hcMoney = hcMoney + Double.valueOf(storeUnit[i]);
                                            }
                                        }

                                    }
                                }
                                if (null != salesDOs.getAdditionalPrice()){
                                    try {
                                        String[] addPrice = salesDOs.getAdditionalPrice().split(",");
                                        if (addPrice.length > 0){
                                            if(null != addPrice[i] && !"".equals(addPrice[i])){
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
                            if (null != salesDOs.getAdditionalPrice()){
                                try {
                                    String[] addPrice = salesDOs.getAdditionalPrice().split(",");
                                    if (addPrice.length > 0){
                                        for (int t=0;t<addPrice.length;t++){
                                            addMoney = addMoney + Double.valueOf(addPrice[t]);
                                        }
                                    } else {
                                        addMoney = addMoney + 0.00;
                                    }
                                }catch (ArrayIndexOutOfBoundsException e) {
                                    addMoney = addMoney + 0.00;
                                }
                            }
                        }
                        if (null != salesDOs.getPrimeMoney()){
                            primMoney = primMoney + Double.valueOf(salesDOs.getPrimeMoney());
                        }
                        if (null != salesDOs.getAmountMoney()){
                            amountMoney = amountMoney + Double.valueOf(salesDOs.getAmountMoney());
                        }

                    }
                }
                Map<String,Object> map = new HashMap<>();
                map.put("saleName",salesDO.getSaleName());
                map.put("saleAccount",salesDO.getUsername());
                map.put("jjcount",jjcount);
                map.put("jjMoney",new BigDecimal(jjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("jpcpcount",jpcpcount);
                map.put("jpcpMoney",new BigDecimal(jpcpMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("jpdzcount",jpdzcount);
                map.put("jpdzMoney",new BigDecimal(jpdzMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("pjcount",pjcount);
                map.put("pjMoney",new BigDecimal(pjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("jjpjcount",jjpjcount);
                map.put("jjpjMoney",new BigDecimal(jjpjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("yxcount",yxcount);
                map.put("yxMoney",new BigDecimal(yxMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("hlycount",hlycount);
                map.put("hlyMoney",new BigDecimal(hlyMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("sgcount",sgcount);
                map.put("sgMoney",new BigDecimal(sgMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("sgdzcount",sgdzcount);
                map.put("sgdzMoney",new BigDecimal(sgdzMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("zjcount",zjcount);
                map.put("zjMoney",zjMoney);
                map.put("zpcount",zpcount);
                map.put("zpMoney",zpMoney);
                map.put("tyjcount",tyjcount);
                map.put("tyjMoney",new BigDecimal(tyjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("lhjcount",lhjcount);
                map.put("lhjMoney",new BigDecimal(lhjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("hccount",hccount);
                map.put("hcMoney",new BigDecimal(hcMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("addMoney",new BigDecimal(addMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("primMoney",new BigDecimal(primMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("amountMoney",new BigDecimal(amountMoney).setScale(2,RoundingMode.HALF_UP));
                list.add(map);
            }
        }
        model.addAttribute("list",list);
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        int totaljjcount = 0;
        double totaljjMoney = 0.00;
        int totaljpcpcount=0;
        double totaljpcpMoney=0.00;
        int totaljpdzcount=0;
        double totaljpdzMoney=0.00;
        int totalpjcount=0;
        double totalpjMoney=0.00;
        int totaljjpjcount=0;
        double totaljjpjMoney=0.00;
        int totalzjcount=0;
        double totalzjMoney = 0.00;
        int totalzpcount=0;
        double totalzpMoney = 0.00;
        int totalyxcount=0;
        double totalyxMoney=0.00;
        int totaltyjcount= 0;
        double totaltyjMoney = 0.00;
        int totallhjcount=0;
        double totallhjMoney = 0.00;
        int totalhccount=0;
        double totalhcMoney=0.00;
        double totaladdMoney = 0.00;
        int totalhlycount=0;
        double totalhlyMoney=0.00;
        int totalsgcount=0;
        double totalsgMoney=0.00;
        int totalsgdzcount=0;
        double totalsgdzMoney=0.00;
        double totalprimMoney=0.00;
        double totalamountMoney=0.00;
        for (Map<String,Object> maps : list){
            totaljjcount = totaljjcount + Integer.parseInt(maps.get("jjcount").toString());
            totaljjMoney = totaljjMoney + Double.valueOf(maps.get("jjMoney").toString());
            totaljpcpcount = totaljpcpcount + Integer.parseInt(maps.get("jpcpcount").toString());
            totaljpcpMoney = totaljpcpMoney + Double.valueOf(maps.get("jpcpMoney").toString());
            totaljpdzcount = totaljpdzcount + Integer.parseInt(maps.get("jpdzcount").toString());
            totaljpdzMoney = totaljpdzMoney + Double.valueOf(maps.get("jpdzMoney").toString());
            totaljjpjcount = totaljjpjcount + Integer.parseInt(maps.get("jjpjcount").toString());
            totaljjpjMoney = totaljjpjMoney + Double.valueOf(maps.get("jjpjMoney").toString());
            totalpjcount = totalpjcount + Integer.parseInt(maps.get("pjcount").toString());
            totalpjMoney = totalpjMoney + Double.valueOf(maps.get("pjMoney").toString());
            totalzjcount = totalzjcount + Integer.parseInt(maps.get("zjcount").toString());
            totalzjMoney = totalzjMoney + Double.valueOf(maps.get("zjMoney").toString());
            totalzpcount = totalzpcount + Integer.parseInt(maps.get("zpcount").toString());
            totalzpMoney = totalzpMoney + Double.valueOf(maps.get("zpMoney").toString());
            totalyxcount = totalyxcount + Integer.parseInt(maps.get("yxcount").toString());
            totalyxMoney = totalyxMoney + Double.valueOf(maps.get("yxMoney").toString());
            totaltyjcount = totaltyjcount + Integer.parseInt(maps.get("tyjcount").toString());
            totaltyjMoney = totaltyjMoney + Double.valueOf(maps.get("tyjMoney").toString());
            totallhjcount = totallhjcount + Integer.parseInt(maps.get("lhjcount").toString());
            totallhjMoney = totallhjMoney + Double.valueOf(maps.get("lhjMoney").toString());
            totalhccount = totalhccount + Integer.parseInt(maps.get("hccount").toString());
            totalhcMoney = totalhcMoney + Double.valueOf(maps.get("hcMoney").toString());
            totalhlycount = totalhlycount + Integer.parseInt(maps.get("hlycount").toString());
            totalhlyMoney = totalhlyMoney + Double.valueOf(maps.get("hlyMoney").toString());
            totalsgcount = totalsgcount + Integer.parseInt(maps.get("sgcount").toString());
            totalsgMoney = totalsgMoney + Double.valueOf(maps.get("sgMoney").toString());
            totalsgdzcount = totalsgdzcount + Integer.parseInt(maps.get("sgdzcount").toString());
            totalsgdzMoney = totalsgdzMoney + Double.valueOf(maps.get("sgdzMoney").toString());
            totaladdMoney = totaladdMoney + Double.valueOf(maps.get("addMoney").toString());
            totalprimMoney = totalprimMoney + Double.valueOf(maps.get("primMoney").toString());
            totalamountMoney = totalamountMoney + Double.valueOf(maps.get("amountMoney").toString());
        }
        model.addAttribute("totaljjcount",totaljjcount);
        model.addAttribute("totaljjMoney",new BigDecimal(totaljjMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totaljpcpcount",totaljpcpcount);
        model.addAttribute("totaljpcpMoney",new BigDecimal(totaljpcpMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totaljpdzcount",totaljpdzcount);
        model.addAttribute("totaljpdzMoney",new BigDecimal(totaljpdzMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalzjcount",totalzjcount);
        model.addAttribute("totalzjMoney",totalzjMoney);
        model.addAttribute("totalzpcount",totalzpcount);
        model.addAttribute("totalzpMoney",totalzpMoney);
        model.addAttribute("totaltyjcount",totaltyjcount);
        model.addAttribute("totaltyjMoney",new BigDecimal(totaltyjMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totaljjpjcount",totaljjpjcount);
        model.addAttribute("totaljjpjMoney",new BigDecimal(totaljjpjMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalpjcount",totalpjcount);
        model.addAttribute("totalpjMoney",new BigDecimal(totalpjMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalyxcount",totalyxcount);
        model.addAttribute("totalyxMoney",new BigDecimal(totalyxMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalhlycount",totalhlycount);
        model.addAttribute("totalhlyMoney",new BigDecimal(totalhlyMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totallhjcount",totallhjcount);
        model.addAttribute("totallhjMoney",new BigDecimal(totallhjMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalsgcount",totalsgcount);
        model.addAttribute("totalsgMoney",new BigDecimal(totalsgMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalsgdzcount",totalsgdzcount);
        model.addAttribute("totalsgdzMoney",new BigDecimal(totalsgdzMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalhccount",totalhccount);
        model.addAttribute("totalhcMoney",new BigDecimal(totalhcMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totaladdMoney",new BigDecimal(totaladdMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalprimMoney",new BigDecimal(totalprimMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("totalamountMoney",new BigDecimal(totalamountMoney).setScale(2,RoundingMode.HALF_UP));
        return "saleReport/saleNameReportForm";
    }
}
