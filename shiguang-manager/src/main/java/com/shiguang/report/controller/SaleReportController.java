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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = new Date();
        //query.put("settleDate",simpleDateFormat.format(date));
        //query.put("settleDate",simpleDateFormat.format(query.get("saleDate")));
        List<SettlementDO> list = saleReportService.findSaleReportForms(query);
//        List<Map<String,Object>> saleReportList = new ArrayList<>();
//        if (null != list && list.size() > 0){
//            for (SalesDO salesDO : list){
//                Map<String,Object> map = new HashMap<>();
//                String[] describe = salesDO.getStoreDescribe().split(",");
//                String[] price = salesDO.getStoreUnit().split(",");
//                String[] addPrice = null;
//                if (null != salesDO.getAdditionalPrice()){
//                    addPrice = salesDO.getAdditionalPrice().split(",");
//                }
//                int addMoney=0;
//                int jpPrice=0;
//                int jjPrice=0;
//                int tyjPrice=0;
//                int jjpjPrice=0;
//                int yxpjPrice=0;
//                int yxPrice=0;
//                int hlyPrice=0;
//                int lhjPrice=0;
//                int sgPrice=0;
//                int hcPrice=0;
//                for (int i=0;i<describe.length;i++){
//                    if ("镜架".equals(describe[i])){
//                        jjPrice = jjPrice + Integer.parseInt(price[i]);
//                        map.put("jingjiaPrice",jjPrice);
//                    }
//                    if ("镜片".equals(describe[i])){
//                        jpPrice = jpPrice + Integer.parseInt(price[i]);
//                        map.put("jingpianPrice",jpPrice);
//                    }
//                    if ("太阳镜".equals(describe[i])){
//                        tyjPrice = tyjPrice + Integer.parseInt(price[i]);
//                        map.put("taiyangjingPrice",tyjPrice);
//                    }
//                    if ("镜架配件".equals(describe[i])){
//                        jjpjPrice = jjpjPrice + Integer.parseInt(price[i]);
//                        map.put("jingjiapjPrice",jjpjPrice);
//                    }
//                    if ("隐形配件".equals(describe[i])){
//                        yxpjPrice = yxpjPrice + Integer.parseInt(price[i]);
//                        map.put("yxpeijianPrice",yxpjPrice);
//                    }
//                    if ("隐形".equals(describe[i])){
//                        yxPrice = yxPrice + Integer.parseInt(price[i]);
//                        map.put("yinxingPrice",yxPrice);
//                    }
//                    if ("护理液".equals(describe[i])){
//                        hlyPrice = hlyPrice + Integer.parseInt(price[i]);
//                        map.put("hliPrice",hlyPrice);
//                    }
//                    if ("老花镜".equals(describe[i])){
//                        lhjPrice = lhjPrice + Integer.parseInt(price[i]);
//                        map.put("lhjPrice",lhjPrice);
//                    }
//                    if ("视光".equals(describe[i])){
//                        sgPrice = sgPrice + Integer.parseInt(price[i]);
//                        map.put("shiguangPrice",sgPrice);
//                    }
//                    if ("耗材".equals(describe[i])){
//                        hcPrice = hcPrice + Integer.parseInt(price[i]);
//                        map.put("hcPrice",hcPrice);
//                    }
//                    if (null != addPrice){
//                        addMoney = addMoney + Integer.parseInt(addPrice[i]);
//                    }
//
//                }
//                Double ysMoney = salesDO.getAmountMoney() - addMoney;
//                map.put("goodsYSPrice",ysMoney);
//                map.put("addPrice",addMoney);
//                map.put("amountMoney",salesDO.getAmountMoney());
//                map.put("saleName",salesDO.getSaleName());
//                map.put("saleNum",salesDO.getSaleNum());
//                saleReportList.add(map);
//            }
//        }
//        if (null != saleReportList && saleReportList.size() > 0){
//            for (Map<String,Object> map : saleReportList){
//                if (null == map.get("jingjiaPrice")){
//                    map.put("jingjiaPrice","0.00");
//                }
//                if (null == map.get("jingpianPrice")){
//                    map.put("jingpianPrice","0.00");
//                }
//                if (null == map.get("taiyangjingPrice")){
//                    map.put("taiyangjingPrice","0.00");
//                }
//                if (null == map.get("jingjiapjPrice")){
//                    map.put("jingjiapjPrice","0.00");
//                }
//                if (null == map.get("yxpeijianPrice")){
//                    map.put("yxpeijianPrice","0.00");
//                }
//                if (null == map.get("yinxingPrice")){
//                    map.put("yinxingPrice","0.00");
//                }
//                if (null == map.get("hliPrice")){
//                    map.put("hliPrice","0.00");
//                }
//                if (null == map.get("lhjPrice")){
//                    map.put("lhjPrice","0.00");
//                }
//                if (null == map.get("shiguangPrice")){
//                    map.put("shiguangPrice","0.00");
//                }
//                if (null == map.get("hcPrice")){
//                    map.put("hcPrice","0.00");
//                }
//            }
//        }
        int total = saleReportService.findSaleReportFormsCount(query);
//        List<MemberDO> memberDOList = memberService.payList(query);
//        int total = memberService.payCount(query);
        PageUtils pageUtils = new PageUtils(list, total);
        return pageUtils;
    }

    /**
     * 收银员报表打印
     * @param
     * @param model
     * @return
     */
    @GetMapping("/reportList")
    public String reportList(String settleDateStart,String settleDateEnd,Model model) {
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        Map<String,Object> query = new HashMap<>();
        query.put("state",1);
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
//        if (!"".equals(saleNum)){
//            query.put("saleNum",saleNum);
//        }
        //query.put("settleDate","2021-08-25");
        if (null != ShiroUtils.getUser().getCompanyId()){
            if(!"3".equals(ShiroUtils.getUser().getCompanyId())){
                query.put("companyid",ShiroUtils.getUser().getCompanyId());
            }
        }
        List<SettlementDO> list = saleReportService.findSaleReportForms(query);
        double weixinMoney = 0;
        double zfbMoney = 0;
        double xianjinMoney = 0;
        double yikatongoney = 0;
        double yyshoufeichuMoney = 0;
        double qtsubTotal = 0;
        double tkMoney = 0;
        double shihsouTotal = 0;
        if (null != list && list.size() > 0){
            for (SettlementDO settlementDO : list){
                if (null != settlementDO.getDrawBackMoney()){
                    tkMoney = tkMoney + Double.valueOf(settlementDO.getDrawBackMoney());
                }
                String[] payModel = settlementDO.getPayModel().split(",");
                String[] modelMoney = settlementDO.getModelMoney().split(",");
                for (int i=0;i<payModel.length;i++){
                    if ("0".equals(payModel[i])){
                        weixinMoney = weixinMoney + Double.valueOf(modelMoney[i]);
                    } else if ("1".equals(payModel[i])){
                        zfbMoney = zfbMoney + Double.valueOf(modelMoney[i]);
                    } else if ("4".equals(payModel[i])){
                        xianjinMoney = xianjinMoney + Double.valueOf(modelMoney[i]);
                    } else if ("2".equals(payModel[i])){
                        yyshoufeichuMoney = yyshoufeichuMoney + Double.valueOf(modelMoney[i]);
                    } else if ("3".equals(payModel[i])){
                        yikatongoney = yikatongoney + Double.valueOf(modelMoney[i]);
                    }
                }
                xianjinMoney = xianjinMoney - settlementDO.getChangeMoney();

                if ("0".equals(settlementDO.getDrawBackWay())){
                    weixinMoney = weixinMoney-Double.valueOf(settlementDO.getDrawBackMoney());
                } else if ("1".equals(settlementDO.getDrawBackWay())){
                    zfbMoney = zfbMoney - Double.valueOf(settlementDO.getDrawBackMoney());
                } else if ("2".equals(settlementDO.getDrawBackWay())){
                    yyshoufeichuMoney = yyshoufeichuMoney - Double.valueOf(settlementDO.getDrawBackMoney());
                } else if ("3".equals(settlementDO.getDrawBackWay())){
                    yikatongoney = yikatongoney - Double.valueOf(settlementDO.getDrawBackMoney());
                } else if ("4".equals(settlementDO.getDrawBackWay())){
                    xianjinMoney = xianjinMoney - Double.valueOf(settlementDO.getDrawBackMoney());
                }
            }
        }
        qtsubTotal = weixinMoney + zfbMoney;
        shihsouTotal = weixinMoney + zfbMoney +xianjinMoney + yyshoufeichuMoney + yikatongoney;
        model.addAttribute("weixinMoney",new BigDecimal(weixinMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("zfbMoney",new BigDecimal(zfbMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("xianjinMoney",new BigDecimal(xianjinMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("yyshoufeichuMoney",new BigDecimal(yyshoufeichuMoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("yikatongoney",new BigDecimal(yikatongoney).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("qtsubTotal",new BigDecimal(qtsubTotal).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("shihsouTotal",new BigDecimal(shihsouTotal).setScale(2,RoundingMode.HALF_UP));
        model.addAttribute("date", simpleDateFormat.format(new Date()));
        return "saleReport/saleReportForm";
    }

    /**
     * 收银员明细报表打印
     * @param
     * @param model
     * @return
     */
    @GetMapping("/reportDetailList")
    public String reportDetailList(String settleDateStart,String settleDateEnd,Model model) {
        Map<String,Object> query = new HashMap<>();
        query.put("state",1);
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            if(!"3".equals(ShiroUtils.getUser().getCompanyId())){
                query.put("companyid",ShiroUtils.getUser().getCompanyId());
            }
        }
        List<SalesDO> salesDOList = saleReportService.findSaleReportDetailForms(query);
        List<SettlementDO> saleNameList = saleReportService.findSaleNameSettleList(query);
        List<Map<String,Object>> list = new ArrayList<>();
        if (null != salesDOList && salesDOList.size() >0){
            for (SettlementDO salesDO : saleNameList){
                double jjMoney=0.00;
                double jpMoney=0.00;
                double jjpjMoney=0.00;
                double pjMoney=0.00;
                double tyjMoney=0.00;
                double lhjMoney=0.00;
                double yxMoney=0.00;
                double hlyMoney=0.00;
                double sgMoney=0.00;
                double addMoney=0.00;
                double hcMoney=0.00;
                double amountMoney=0.00;
                double primMoney=0.00;
                double qianfeiMoney=0.00;
                double dingjinMoney=0.00;
                for (SalesDO salesDOs : salesDOList){
                    String[] storeDescribe = null;
                    if (null != salesDOs.getStoreDescribe() && !"".equals(salesDOs.getStoreDescribe())){
                        storeDescribe = salesDOs.getStoreDescribe().split(",");
                    }
                    String[] storeCount = null;
                    if (null != salesDOs.getStoreCount() && !"".equals(salesDOs.getStoreCount())){
                        storeCount = salesDOs.getStoreCount().split(",");
                    }
                    String[] storeUnit = null;
                    if (null != salesDOs.getStoreUnit()){
                        storeUnit = salesDOs.getStoreUnit().split(",");
                    }

                    if (salesDO.getSaleName().equals(salesDOs.getSaleName())){
                        if (null != storeDescribe){
                            for (int i=0;i<storeDescribe.length;i++){
                                if ("镜架".equals(storeDescribe[i])){
                                    if (null != storeUnit && null != storeCount){
                                        if ("".equals(storeUnit[i])){
                                            jjMoney = jjMoney + 0.00;
                                        } else {
                                            jjMoney = jjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }
                                } else if ("镜片".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            jpMoney = jpMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("配件".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            pjMoney = pjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("镜架配件".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            jjpjMoney = jjpjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("隐形".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            yxMoney = yxMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("护理液".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]){
                                            hlyMoney = hlyMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }

                                    }

                                } else if ("视光".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            sgMoney = sgMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("太阳镜".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            tyjMoney = tyjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("老花镜".equals(storeDescribe[i])){
                                    if (null != storeUnit && !"".equals(storeUnit) && null != storeCount && !"".equals(storeCount)){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            lhjMoney = lhjMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                } else if ("耗材".equals(storeDescribe[i])){
                                    if (null != storeUnit && null != storeCount){
                                        if (!"".equals(storeUnit[i]) && null != storeUnit[i] && !"".equals(storeCount[i]) && null != storeCount[i]) {
                                            hcMoney = hcMoney + Double.valueOf(Double.valueOf(storeUnit[i]) * Integer.parseInt(storeCount[i]));
                                        }
                                    }

                                }
                            }
                            primMoney = primMoney + Double.valueOf(salesDOs.getPrimeMoney());
                            if ("2".equals(salesDOs.getSaleType())){
                                String dingjin = salesDOs.getModelMoney().toString();
                                dingjin = dingjin.substring(0,dingjin.length()-1);
                                dingjinMoney = dingjinMoney + Double.valueOf(dingjin);
                                String qianfei = salesDOs.getChangeMoney().substring(1);
                                qianfeiMoney = qianfeiMoney + Double.valueOf(qianfei);
                                amountMoney = amountMoney + Double.valueOf(dingjin);
                            } else {
                                String[] modelsMoney = salesDOs.getModelMoney().split(",");
                                String changesMoney=salesDOs.getChangeMoney();
                                for (int s=0;s<modelsMoney.length;s++){
                                    amountMoney = amountMoney + Double.valueOf(modelsMoney[s]);
                                    amountMoney = amountMoney - Double.valueOf(changesMoney);
                                }
                            }
                        }
                        if (null != salesDOs.getAdditionalPrice()){
                            String[] addPrice = salesDOs.getAdditionalPrice().split(",");
                            for (int s=0;s<addPrice.length;s++){
                                addMoney = addMoney + Double.valueOf(addPrice[s]);
                            }
//                            try {
//                                String[] addPrice = salesDOs.getAdditionalPrice().split(",");
//                                if (addPrice.length > 0){
//                                    if (null != addPrice[i] && !"".equals(addPrice[i])){
//                                        addMoney = addMoney + Double.valueOf(addPrice[i]);
//                                    }
//                                } else {
//                                    addMoney = addMoney +  0.00;
//                                }
//                            }catch (ArrayIndexOutOfBoundsException e) {
//                                addMoney = addMoney +  0.00;
//                            }
                        }
                    }
                }
                Map<String,Object> map = new HashMap<>();
                map.put("jjMoney",new BigDecimal(jjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("jpMoney",new BigDecimal(jpMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("pjMoney",new BigDecimal(pjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("jjpjMoney",new BigDecimal(jjpjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("tyjMoney",new BigDecimal(tyjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("lhjMoney",new BigDecimal(lhjMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("yxMoney",new BigDecimal(yxMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("hlyMoney",new BigDecimal(hlyMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("sgMoney",new BigDecimal(sgMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("hcMoney",new BigDecimal(hcMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("saleName",salesDO.getSaleName());
                map.put("saleAccount",salesDO.getSaleAcount());
                map.put("addMoney",addMoney);
                map.put("amountMoney",new BigDecimal(amountMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("primMoney",new BigDecimal(primMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("dingjinMoney",new BigDecimal(dingjinMoney).setScale(2,RoundingMode.HALF_UP));
                map.put("qianfeiMoney",new BigDecimal(qianfeiMoney).setScale(2,RoundingMode.HALF_UP));
                list.add(map);
            }
        }
        model.addAttribute("list",list);
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleReportDetailForm";
    }


}
