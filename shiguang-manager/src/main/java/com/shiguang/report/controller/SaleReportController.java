package com.shiguang.report.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.report.service.SaleReportService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.SalesDO;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/information/saleReport")
public class SaleReportController {
    @Autowired
    private SettlementService settlementService;
    @Autowired
    private SaleReportService saleReportService;

    @GetMapping()
    @RequiresPermissions("information:saleReport:saleReport")
    String SaleReport(){
        return "saleReport/saleReport";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:saleReport:saleReport")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        } else {
            query.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //query.put("settleDate",simpleDateFormat.format(date));
        query.put("settleDate","2021-08-25");
        List<SalesDO> list = saleReportService.findSaleReport(query);
        List<Map<String,Object>> saleReportList = new ArrayList<>();
        if (null != list && list.size() > 0){
            for (SalesDO salesDO : list){
                Map<String,Object> map = new HashMap<>();
                String[] describe = salesDO.getStoreDescribe().split(",");
                String[] price = salesDO.getStoreUnit().split(",");
                String[] addPrice = null;
                if (null != salesDO.getAdditionalPrice()){
                    addPrice = salesDO.getAdditionalPrice().split(",");
                }
                int addMoney=0;
                int jpPrice=0;
                int jjPrice=0;
                int tyjPrice=0;
                int jjpjPrice=0;
                int yxpjPrice=0;
                int yxPrice=0;
                int hlyPrice=0;
                int lhjPrice=0;
                int sgPrice=0;
                int hcPrice=0;
                for (int i=0;i<describe.length;i++){
                    if ("镜架".equals(describe[i])){
                        jjPrice = jjPrice + Integer.parseInt(price[i]);
                        map.put("jingjiaPrice",jjPrice);
                    }
                    if ("镜片".equals(describe[i])){
                        jpPrice = jpPrice + Integer.parseInt(price[i]);
                        map.put("jingpianPrice",jpPrice);
                    }
                    if ("太阳镜".equals(describe[i])){
                        tyjPrice = tyjPrice + Integer.parseInt(price[i]);
                        map.put("taiyangjingPrice",tyjPrice);
                    }
                    if ("镜架配件".equals(describe[i])){
                        jjpjPrice = jjpjPrice + Integer.parseInt(price[i]);
                        map.put("jingjiapjPrice",jjpjPrice);
                    }
                    if ("隐形配件".equals(describe[i])){
                        yxpjPrice = yxpjPrice + Integer.parseInt(price[i]);
                        map.put("yxpeijianPrice",yxpjPrice);
                    }
                    if ("隐形".equals(describe[i])){
                        yxPrice = yxPrice + Integer.parseInt(price[i]);
                        map.put("yinxingPrice",yxPrice);
                    }
                    if ("护理液".equals(describe[i])){
                        hlyPrice = hlyPrice + Integer.parseInt(price[i]);
                        map.put("hliPrice",hlyPrice);
                    }
                    if ("老花镜".equals(describe[i])){
                        lhjPrice = lhjPrice + Integer.parseInt(price[i]);
                        map.put("lhjPrice",lhjPrice);
                    }
                    if ("视光".equals(describe[i])){
                        sgPrice = sgPrice + Integer.parseInt(price[i]);
                        map.put("shiguangPrice",sgPrice);
                    }
                    if ("耗材".equals(describe[i])){
                        hcPrice = hcPrice + Integer.parseInt(price[i]);
                        map.put("hcPrice",hcPrice);
                    }
                    if (null != addPrice){
                        addMoney = addMoney + Integer.parseInt(addPrice[i]);
                    }

                }
                Double ysMoney = salesDO.getAmountMoney() - addMoney;
                map.put("goodsYSPrice",ysMoney);
                map.put("addPrice",addMoney);
                map.put("amountMoney",salesDO.getAmountMoney());
                map.put("saleName",salesDO.getSaleName());
                map.put("saleNum",salesDO.getSaleNum());
                saleReportList.add(map);
            }
        }
        if (null != saleReportList && saleReportList.size() > 0){
            for (Map<String,Object> map : saleReportList){
                if (null == map.get("jingjiaPrice")){
                    map.put("jingjiaPrice","0.00");
                }
                if (null == map.get("jingpianPrice")){
                    map.put("jingpianPrice","0.00");
                }
                if (null == map.get("taiyangjingPrice")){
                    map.put("taiyangjingPrice","0.00");
                }
                if (null == map.get("jingjiapjPrice")){
                    map.put("jingjiapjPrice","0.00");
                }
                if (null == map.get("yxpeijianPrice")){
                    map.put("yxpeijianPrice","0.00");
                }
                if (null == map.get("yinxingPrice")){
                    map.put("yinxingPrice","0.00");
                }
                if (null == map.get("hliPrice")){
                    map.put("hliPrice","0.00");
                }
                if (null == map.get("lhjPrice")){
                    map.put("lhjPrice","0.00");
                }
                if (null == map.get("shiguangPrice")){
                    map.put("shiguangPrice","0.00");
                }
                if (null == map.get("hcPrice")){
                    map.put("hcPrice","0.00");
                }
            }
        }
        int total = saleReportService.findSaleReportCount(query);
//        List<MemberDO> memberDOList = memberService.payList(query);
//        int total = memberService.payCount(query);
        PageUtils pageUtils = new PageUtils(saleReportList, total);
        return pageUtils;
    }

    /**
     * 收银员报表打印
     * @param
     * @param model
     * @return
     */
    @GetMapping("/reportList")
    public String reportList(Model model) {
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        Map<String,Object> query = new HashMap<>();
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        } else {
            query.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        query.put("settleDate",simpleDateFormat.format(date));
        //query.put("settleDate","2021-08-25");
        List<SalesDO> list = saleReportService.findSaleReport(query);
        List<Map<String,Object>> saleReportList = new ArrayList<>();
        if (null != list && list.size() > 0){
            for (SalesDO salesDO : list){
                Map<String,Object> map = new HashMap<>();
                String[] describe = null;
                String[] price = null;
                if (null != salesDO.getStoreDescribe()){
                    describe = salesDO.getStoreDescribe().split(",");
                }
                if (null != salesDO.getStoreUnit()){
                    price = salesDO.getStoreUnit().split(",");
                }
                String[] addPrice = null;
                if (null != salesDO.getAdditionalPrice()){
                    addPrice = salesDO.getAdditionalPrice().split(",");
                }
                double addMoney=0.00;
                double jpPrice=0.00;
                double jjPrice=0.00;
                double tyjPrice=0.00;
                double jjpjPrice=0.00;
                double yxpjPrice=0.00;
                double yxPrice=0.00;
                double hlyPrice=0.00;
                double lhjPrice=0.00;
                double sgPrice=0.00;
                double hcPrice=0.00;
                if (salesDO.getIsSale() == 2){
                    for (int i=0;i<describe.length;i++){
                        if ("镜架".equals(describe[i])){
                            jjPrice = jjPrice + Double.valueOf(price[i]);
                            map.put("jingjiaPrice","-"+jjPrice);
                        }
                        if ("镜片".equals(describe[i])){
                            jpPrice = jpPrice + Double.valueOf(price[i]);
                            map.put("jingpianPrice","-"+jpPrice);
                        }
                        if ("太阳镜".equals(describe[i])){
                            tyjPrice = tyjPrice + Double.valueOf(price[i]);
                            map.put("taiyangjingPrice","-"+tyjPrice);
                        }
                        if ("镜架配件".equals(describe[i])){
                            jjpjPrice = jjpjPrice + Double.valueOf(price[i]);
                            map.put("jingjiapjPrice","-"+jjpjPrice);
                        }
                        if ("隐形配件".equals(describe[i])){
                            yxpjPrice = yxpjPrice + Double.valueOf(price[i]);
                            map.put("yxpeijianPrice","-"+yxpjPrice);
                        }
                        if ("隐形".equals(describe[i])){
                            yxPrice = yxPrice + Double.valueOf(price[i]);
                            map.put("yinxingPrice","-"+yxPrice);
                        }
                        if ("护理液".equals(describe[i])){
                            hlyPrice = hlyPrice + Double.valueOf(price[i]);
                            map.put("hlyPrice","-"+hlyPrice);
                        }
                        if ("老花镜".equals(describe[i])){
                            lhjPrice = lhjPrice + Double.valueOf(price[i]);
                            map.put("lhjPrice","-"+lhjPrice);
                        }
                        if ("视光".equals(describe[i])){
                            sgPrice = sgPrice + Double.valueOf(price[i]);
                            map.put("shiguangPrice","-"+sgPrice);
                        }
                        if ("耗材".equals(describe[i])){
                            hcPrice = hcPrice + Double.valueOf(price[i]);
                            map.put("hcPrice","-"+hcPrice);
                        }
                        if (null != addPrice){
                            addMoney = addMoney + Double.valueOf(addPrice[i]);
                        }

                    }
                    Double ysMoney = salesDO.getAmountMoney() - addMoney;
                    map.put("goodsYSPrice","-"+ysMoney);
                    if (addMoney == 0){
                        map.put("addPrice",addMoney);
                    }else {
                        map.put("addPrice","-"+addMoney);
                    }
                    map.put("amountMoney","-"+salesDO.getAmountMoney());
                    map.put("payMoney","-"+salesDO.getPayMoney());
                } else {
                    for (int i=0;i<describe.length;i++){
                        if ("镜架".equals(describe[i])){
                            jjPrice = jjPrice + Double.valueOf(price[i]);
                            map.put("jingjiaPrice",jjPrice);
                        }
                        if ("镜片".equals(describe[i])){
                            jpPrice = jpPrice + Double.valueOf(price[i]);
                            map.put("jingpianPrice",jpPrice);
                        }
                        if ("太阳镜".equals(describe[i])){
                            tyjPrice = tyjPrice + Double.valueOf(price[i]);
                            map.put("taiyangjingPrice",tyjPrice);
                        }
                        if ("镜架配件".equals(describe[i])){
                            jjpjPrice = jjpjPrice + Double.valueOf(price[i]);
                            map.put("jingjiapjPrice",jjpjPrice);
                        }
                        if ("隐形配件".equals(describe[i])){
                            yxpjPrice = yxpjPrice + Double.valueOf(price[i]);
                            map.put("yxpeijianPrice",yxpjPrice);
                        }
                        if ("隐形".equals(describe[i])){
                            yxPrice = yxPrice + Double.valueOf(price[i]);
                            map.put("yinxingPrice",yxPrice);
                        }
                        if ("护理液".equals(describe[i])){
                            hlyPrice = hlyPrice + Double.valueOf(price[i]);
                            map.put("hlyPrice",hlyPrice);
                        }
                        if ("老花镜".equals(describe[i])){
                            lhjPrice = lhjPrice + Double.valueOf(price[i]);
                            map.put("lhjPrice",lhjPrice);
                        }
                        if ("视光".equals(describe[i])){
                            sgPrice = sgPrice + Double.valueOf(price[i]);
                            map.put("shiguangPrice",sgPrice);
                        }
                        if ("耗材".equals(describe[i])){
                            hcPrice = hcPrice + Double.valueOf(price[i]);
                            map.put("hcPrice",hcPrice);
                        }
                        if (null != addPrice && !"".equals(addPrice[i])){
                            addMoney = addMoney + Double.valueOf(addPrice[i]);
                        }

                    }
                    Double ysMoney = salesDO.getAmountMoney() - addMoney;
                    map.put("goodsYSPrice",ysMoney);
                    map.put("addPrice",addMoney);
                    map.put("amountMoney",salesDO.getAmountMoney());
                    map.put("payMoney",salesDO.getPayMoney());
                }

                map.put("saleName",salesDO.getSaleName());
                map.put("saleNum",salesDO.getSaleNum());
                Map<String,Object> costMap = new HashMap<>();
                costMap.put("saleNumber",salesDO.getSaleNumber());
                SaleReportDO saleReportDO = saleReportService.findCostList(costMap);
                if (null != saleReportDO){
                    if (saleReportDO.getIsSale() == 2){
                        map.put("checkCount","-"+saleReportDO.getCheckCount());
                        map.put("checkMoney","-"+saleReportDO.getCheckMoney());
                    } else {
                        map.put("checkCount",saleReportDO.getCheckCount());
                        map.put("checkMoney",saleReportDO.getCheckMoney());
                    }
                } else {
                    map.put("checkCount","0.00");
                    map.put("checkMoney","0.00");
                }

                saleReportList.add(map);
            }
        }
        if (null != saleReportList && saleReportList.size() > 0){
            for (Map<String,Object> map : saleReportList){
                if (null == map.get("jingjiaPrice")){
                    map.put("jingjiaPrice","0.00");
                }
                if (null == map.get("jingpianPrice")){
                    map.put("jingpianPrice","0.00");
                }
                if (null == map.get("taiyangjingPrice")){
                    map.put("taiyangjingPrice","0.00");
                }
                if (null == map.get("jingjiapjPrice")){
                    map.put("jingjiapjPrice","0.00");
                }
                if (null == map.get("yxpeijianPrice")){
                    map.put("yxpeijianPrice","0.00");
                }
                if (null == map.get("yinxingPrice")){
                    map.put("yinxingPrice","0.00");
                }
                if (null == map.get("hlyPrice")){
                    map.put("hlyPrice","0.00");
                }
                if (null == map.get("lhjPrice")){
                    map.put("lhjPrice","0.00");
                }
                if (null == map.get("shiguangPrice")){
                    map.put("shiguangPrice","0.00");
                }
                if (null == map.get("hcPrice")){
                    map.put("hcPrice","0.00");
                }
            }
        }
        int total = saleReportService.findSaleReportCount(query);
        double jjcount=0.00;
        double jpcount=0.00;
        double tyjcount=0.00;
        double jjpjcount=0.00;
        double yxpjcount=0.00;
        double yxcount=0.00;
        double hlycount=0.00;
        double lhjcount=0.00;
        double sgcount=0.00;
        double hccount=0.00;
        double spyscount=0.00;
        double fjfcount=0.00;
        double pjyscount=0.00;
        double jccount=0.00;
        double jcfcount=0.00;
        int pjcount=0;
        int wxfcount=0;
        int yscount=0;
        double sscount=0.00;
        for (Map<String,Object> map : saleReportList){
            jjcount = jjcount + Double.valueOf(map.get("jingjiaPrice").toString());
            jpcount = jpcount + Double.valueOf(map.get("jingpianPrice").toString());
            tyjcount = tyjcount + Double.valueOf(map.get("taiyangjingPrice").toString());
            jjpjcount = jjpjcount + Double.valueOf(map.get("jingjiapjPrice").toString());
            yxpjcount = yxpjcount + Double.valueOf(map.get("yxpeijianPrice").toString());
            yxcount = yxcount + Double.valueOf(map.get("yinxingPrice").toString());
            hlycount = hlycount + Double.valueOf(map.get("hlyPrice").toString());
            lhjcount = lhjcount + Double.valueOf(map.get("lhjPrice").toString());
            sgcount = sgcount + Double.valueOf(map.get("shiguangPrice").toString());
            hccount = hccount + Double.valueOf(map.get("hcPrice").toString());
            spyscount = spyscount + Double.valueOf(map.get("goodsYSPrice").toString());
            fjfcount = fjfcount + Double.valueOf(map.get("addPrice").toString());
            pjyscount = pjyscount + Double.valueOf(map.get("amountMoney").toString());
            jccount = jccount + Double.valueOf(map.get("checkCount").toString());
            jcfcount = jcfcount + Double.valueOf(map.get("checkMoney").toString());
            sscount = sscount + Double.valueOf(map.get("payMoney").toString());
        }
        model.addAttribute("saleReportList",saleReportList);
        model.addAttribute("total",list.size());
        model.addAttribute("dyDate",simpleDateFormat.format(date));
        model.addAttribute("jjcount",jjcount);
        model.addAttribute("jpcount",jpcount);
        model.addAttribute("tyjcount",tyjcount);
        model.addAttribute("jjpjcount",jjpjcount);
        model.addAttribute("yxpjcount",yxpjcount);
        model.addAttribute("yxcount",yxcount);
        model.addAttribute("hlycount",hlycount);
        model.addAttribute("lhjcount",lhjcount);
        model.addAttribute("sgcount",sgcount);
        model.addAttribute("hccount",hccount);
        model.addAttribute("spyscount",spyscount);
        model.addAttribute("fjfcount",fjfcount);
        model.addAttribute("pjyscount",pjyscount);
        model.addAttribute("jccount",jccount);
        model.addAttribute("jcfcount",jcfcount);
        model.addAttribute("sscount",sscount);
        return "saleReport/saleReportdy";
    }
}
