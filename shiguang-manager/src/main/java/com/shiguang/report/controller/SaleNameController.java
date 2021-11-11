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
        return "saleReport/saleNameReport";
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
                double primMoney=0.00;
                double amountMoney=0.00;
                for (SalesDO salesDOs : salesDOList){
                    String[] storeDescribe = salesDOs.getStoreDescribe().split(",");
                    String[] storeCount = salesDOs.getStoreCount().split(",");
                    String[] storeUnit = salesDOs.getStoreUnit().split(",");
                    String[] classType = salesDOs.getClasstype().split(",");
                    if (salesDO.getSaleName().equals(salesDOs.getSaleName())){
                        for (int i=0;i<storeDescribe.length;i++){
                            if ("镜架".equals(storeDescribe[i])){
                                jjcount = jjcount + Integer.parseInt(storeCount[i]);
                                jjMoney = jjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("镜片".equals(storeDescribe[i])){
                                if ("1".equals(classType)){
                                    jpcpcount = jpcpcount + Integer.parseInt(storeCount[i]);
                                    jpcpMoney = jpcpMoney + Double.valueOf(storeUnit[i]);
                                } else if ("2".equals(classType)){
                                    jpdzcount = jpdzcount + Integer.parseInt(storeCount[i]);
                                    jpdzMoney = jpdzMoney + Double.valueOf(storeUnit[i]);
                                }
                            } else if ("配件".equals(storeDescribe[i])){
                                pjcount = pjcount + Integer.parseInt(storeCount[i]);
                                pjMoney = pjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("镜架配件".equals(storeDescribe[i])){
                                jjpjcount = jjpjcount + Integer.parseInt(storeCount[i]);
                                jjpjMoney = jjpjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("隐形".equals(storeDescribe[i])){
                                yxcount = yxcount + Integer.parseInt(storeCount[i]);
                                yxMoney = yxMoney + Double.valueOf(storeUnit[i]);
                            } else if ("护理液".equals(storeDescribe[i])){
                                hlycount = hlycount + Integer.parseInt(storeCount[i]);
                                hlyMoney = hlyMoney + Double.valueOf(storeUnit[i]);
                            } else if ("视光".equals(storeDescribe[i])){
                                sgcount = sgcount + Integer.parseInt(storeCount[i]);
                                sgMoney = sgMoney + Double.valueOf(storeUnit[i]);
                            } else if ("自架".equals(storeDescribe[i])){
                                zjcount = zjcount + Integer.parseInt(storeCount[i]);
                                zjMoney = 0.00;
                            } else if ("太阳镜".equals(storeDescribe[i])){
                                tyjcount = tyjcount + Integer.parseInt(storeCount[i]);
                                tyjMoney = tyjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("老花镜".equals(storeDescribe[i])){
                                lhjcount = lhjcount + Integer.parseInt(storeCount[i]);
                                lhjMoney = lhjMoney + Double.valueOf(storeUnit[i]);
                            } else if ("耗材".equals(storeDescribe[i])){
                                hccount = hccount + Integer.parseInt(storeCount[i]);
                                hcMoney = hcMoney + Double.valueOf(storeUnit[i]);
                            }
                            if (null != salesDOs.getAdditionalPrice()){
                                try {
                                    String[] addPrice = salesDOs.getAdditionalPrice().split(",");
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
                        primMoney = primMoney + Double.valueOf(salesDOs.getPrimeMoney());
                        amountMoney = amountMoney + Double.valueOf(salesDOs.getAmountMoney());
                    }
                }
                Map<String,Object> map = new HashMap<>();
                map.put("saleName",salesDO.getSaleName());
                map.put("saleAccount",salesDO.getSaleAccount());
                map.put("jjcount",jjcount);
                map.put("jjMoney",jjMoney);
                map.put("jpcpcount",jpcpcount);
                map.put("jpcpMoney",jpcpMoney);
                map.put("jpdzcount",jpdzcount);
                map.put("jpdzMoney",jpdzMoney);
                map.put("pjcount",pjcount);
                map.put("pjMoney",pjMoney);
                map.put("jjpjcount",jjpjcount);
                map.put("jjpjMoney",jjpjMoney);
                map.put("yxcount",yxcount);
                map.put("yxMoney",yxMoney);
                map.put("hlycount",hlycount);
                map.put("hlyMoney",hlyMoney);
                map.put("sgcount",sgcount);
                map.put("sgMoney",sgMoney);
                map.put("zjcount",zjcount);
                map.put("zjMoney",zjMoney);
                map.put("tyjcount",tyjcount);
                map.put("tyjMoney",tyjMoney);
                map.put("lhjcount",lhjcount);
                map.put("lhjMoney",lhjMoney);
                map.put("hccount",hccount);
                map.put("hcMoney",hcMoney);
                map.put("addMoney",addMoney);
                map.put("primMoney",primMoney);
                map.put("amountMoney",amountMoney);
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
            totaladdMoney = totaladdMoney + Double.valueOf(maps.get("addMoney").toString());
            totalprimMoney = totalprimMoney + Double.valueOf(maps.get("primMoney").toString());
            totalamountMoney = totalamountMoney + Double.valueOf(maps.get("amountMoney").toString());
        }
        model.addAttribute("totaljjcount",totaljjcount);
        model.addAttribute("totaljjMoney",totaljjMoney);
        model.addAttribute("totaljpcpcount",totaljpcpcount);
        model.addAttribute("totaljpcpMoney",totaljpcpMoney);
        model.addAttribute("totaljpdzcount",totaljpdzcount);
        model.addAttribute("totaljpdzMoney",totaljpdzMoney);
        model.addAttribute("totalzjcount",totalzjcount);
        model.addAttribute("totalzjMoney",totalzjMoney);
        model.addAttribute("totaltyjcount",totaltyjcount);
        model.addAttribute("totaltyjMoney",totaltyjMoney);
        model.addAttribute("totaljjpjcount",totaljjpjcount);
        model.addAttribute("totaljjpjMoney",totaljjpjMoney);
        model.addAttribute("totalpjcount",totalpjcount);
        model.addAttribute("totalpjMoney",totalpjMoney);
        model.addAttribute("totalyxcount",totalyxcount);
        model.addAttribute("totalyxMoney",totalyxMoney);
        model.addAttribute("totalhlycount",totalhlycount);
        model.addAttribute("totalhlyMoney",totalhlyMoney);
        model.addAttribute("totallhjcount",totallhjcount);
        model.addAttribute("totallhjMoney",totallhjMoney);
        model.addAttribute("totalsgcount",totalsgcount);
        model.addAttribute("totalsgMoney",totalsgMoney);
        model.addAttribute("totalhccount",totalhccount);
        model.addAttribute("totalhcMoney",totalhcMoney);
        model.addAttribute("totaladdMoney",totaladdMoney);
        model.addAttribute("totalprimMoney",totalprimMoney);
        model.addAttribute("totalamountMoney",totalamountMoney);
        return "saleReport/saleNameReportForm";
    }
}
