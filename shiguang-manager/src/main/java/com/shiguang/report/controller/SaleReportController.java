package com.shiguang.report.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.report.service.SaleReportService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.SalesDO;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @RequiresPermissions("information:saleReport:saleReport")
    String SaleReport(Model model){
        Map<String, Object> map = new HashMap<>();

        map.put("state",1);
        if (null != ShiroUtils.getUser().getStoreNum()){
            map.put("departNumber",ShiroUtils.getUser().getStoreNum());
//            if ("3".equals(ShiroUtils.getUser().getCompanyId())){
//                map.put("departNumber",ShiroUtils.getUser().getStoreNum());
//            } else {
//                map.put("departType","销售门店");
//            }

        }
        map.put("companyId",ShiroUtils.getUser().getCompanyId());
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
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
        if (null != params.get("departNumber") && !"".equals(params.get("departNumber"))){
            DepartmentDO departmentDO = departmentService.getDepartName(params.get("departNumber")+"");
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
    public String reportList(String settleDateStart,String settleDateEnd,String departNumber,Model model) {
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        Map<String,Object> query = new HashMap<>();
        Map<String,Object> maps = new HashMap<>();
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
        if (!"".equals(departNumber)){
            DepartmentDO departmentDO = departmentService.getDepartName(departNumber);
            model.addAttribute("departmentName",departmentDO.getDepartName());
            query.put("departNumber",departNumber);
            maps.put("departNumber",departNumber);
        } else {
            query.put("departType","销售门店");
            query.put("departNumber",ShiroUtils.getUser().getStoreNum());
            maps.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
//        if (!"".equals(saleNum)){
//            query.put("saleNum",saleNum);
//        }
        //query.put("settleDate","2021-08-25");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        List<SettlementDO> list = saleReportService.findSaleReportForms(query);
        List<SettlementDO> drawList = saleReportService.drawckMoney(query);

        if (null != ShiroUtils.getUser().getCompanyId()){
            maps.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        maps.put("departType","销售门店");
        maps.put("state",1);
        List<DepartmentDO> departmentDOList = departmentService.list(maps);

        List<Map<String,Object>> resultList = new ArrayList<>();
        if (null != list && list.size() > 0){
            for (DepartmentDO departmentDO : departmentDOList){
                double weixinMoney = 0;
                double zfbMoney = 0;
                double xianjinMoney = 0;
                double yikatongoney = 0;
                double yyshoufeichuMoney = 0;
                double yinliankamoney = 0;
                double chuzhikamoney = 0;
                double dianmoney = 0;
                double diandianmoney = 0;
                double jifenmoney = 0;
                double qtsubTotal = 0;
                double weixinpt = 0;
                //double tkMoney = 0;
                double shihsouTotal = 0;
                for (SettlementDO settlementDO : list){
                    if (departmentDO.getDepartName().equals(settlementDO.getDepartmentName())){
                        String[] payModel = settlementDO.getPayModel().split(",");
                        String[] modelMoney = settlementDO.getModelMoney().split(",");
                        for (int i=0;i<payModel.length;i++){
                            if ("0".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                weixinMoney = weixinMoney + Double.valueOf(modelMoney[i]);
                            } else if ("1".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                zfbMoney = zfbMoney + Double.valueOf(modelMoney[i]);
                            } else if ("4".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                xianjinMoney = xianjinMoney + Double.valueOf(modelMoney[i]);
                            } else if ("2".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yyshoufeichuMoney = yyshoufeichuMoney + Double.valueOf(modelMoney[i]);
                            } else if ("3".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yikatongoney = yikatongoney + Double.valueOf(modelMoney[i]);
                            } else if ("5".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yinliankamoney = yinliankamoney + Double.valueOf(modelMoney[i]);
                            } else if ("6".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                chuzhikamoney = chuzhikamoney + Double.valueOf(modelMoney[i]);
                            } else if ("7".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                dianmoney = dianmoney + Double.valueOf(modelMoney[i]);
                            } else if ("8".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                diandianmoney = diandianmoney + Double.valueOf(modelMoney[i]);
                            } else if ("9".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                jifenmoney = jifenmoney + Double.valueOf(modelMoney[i]);
                            } else if ("10".equals(settlementDO.getDrawBackWay())){
                                weixinpt = weixinpt - Double.valueOf(settlementDO.getDrawBackMoney());
                            }
                        }
                        if (null != settlementDO.getChangeMoney()){
                            xianjinMoney = xianjinMoney - settlementDO.getChangeMoney();
                        }
                        if (null != settlementDO.getJifen() && !"".equals(settlementDO.getJifen())){
                            jifenmoney = jifenmoney + Double.valueOf(settlementDO.getJifen());
                        }
                    }

                }
                if (null != drawList && drawList.size() > 0){
                    for (SettlementDO settlementDO : drawList){
                        String[] drackbackWay = settlementDO.getDrawBackWay().split(",");
                        String[] drackMoney = settlementDO.getDrawBackMoney().split(",");
                        for (int a=0;a<drackbackWay.length;a++){
                            if ("0".equals(drackbackWay[a])){
                                weixinMoney = weixinMoney-Double.valueOf(drackMoney[a]);
                            } else if ("1".equals(drackbackWay[a])){
                                zfbMoney = zfbMoney - Double.valueOf(drackMoney[a]);
                            } else if ("2".equals(drackbackWay[a])){
                                yyshoufeichuMoney = yyshoufeichuMoney - Double.valueOf(drackMoney[a]);
                            } else if ("3".equals(drackbackWay[a])){
                                yikatongoney = yikatongoney - Double.valueOf(drackMoney[a]);
                            } else if ("4".equals(drackbackWay[a])){
                                xianjinMoney = xianjinMoney - Double.valueOf(drackMoney[a]);
                            } else if ("5".equals(drackbackWay[a])){
                                yinliankamoney = yinliankamoney - Double.valueOf(drackMoney[a]);
                            } else if ("6".equals(drackbackWay[a])){
                                chuzhikamoney = chuzhikamoney - Double.valueOf(drackMoney[a]);
                            } else if ("7".equals(drackbackWay[a])){
                                dianmoney = dianmoney - Double.valueOf(drackMoney[a]);
                            } else if ("8".equals(drackbackWay[a])){
                                diandianmoney = diandianmoney - Double.valueOf(drackMoney[a]);
                            } else if ("9".equals(drackbackWay[a])){
                                jifenmoney = jifenmoney - Double.valueOf(drackMoney[a]);
                            } else if ("10".equals(drackbackWay[a])){
                                weixinpt = weixinpt - Double.valueOf(drackMoney[a]);
                            }
                        }

                    }
                }
                qtsubTotal = weixinMoney + zfbMoney;
                if (xianjinMoney < 0){
                    shihsouTotal = weixinMoney + zfbMoney +xianjinMoney + yyshoufeichuMoney + yikatongoney + yinliankamoney + diandianmoney + dianmoney + weixinpt;
                } else {
                    shihsouTotal = weixinMoney + zfbMoney +xianjinMoney + yyshoufeichuMoney + yikatongoney + yinliankamoney + diandianmoney + dianmoney + weixinpt;
                }
                Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("weixinMoney",new BigDecimal(weixinMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("zfbMoney",new BigDecimal(zfbMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("xianjinMoney",new BigDecimal(xianjinMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yyshoufeichuMoney",new BigDecimal(yyshoufeichuMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yikatongoney",new BigDecimal(yikatongoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yinliankamoney",new BigDecimal(yinliankamoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("chuzhikamoney",new BigDecimal(chuzhikamoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("diandianmoney",new BigDecimal(diandianmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("dianmoney",new BigDecimal(dianmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("jifenmoney",new BigDecimal(jifenmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("weixinptmoney",new BigDecimal(weixinpt).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("qtsubTotal",new BigDecimal(qtsubTotal).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("shihsouTotal",new BigDecimal(shihsouTotal).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("departmentName",departmentDO.getDepartName());
                resultMap.put("departmentNum",departmentDO.getDepartNumber());
                resultList.add(resultMap);
//                model.addAttribute("yyshoufeichuMoney",new BigDecimal(yyshoufeichuMoney).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("yikatongoney",new BigDecimal(yikatongoney).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("qtsubTotal",new BigDecimal(qtsubTotal).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("shihsouTotal",new BigDecimal(shihsouTotal).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("date", simpleDateFormat.format(new Date()));
            }

        }
        model.addAttribute("resultList",resultList);
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleReportForm";
    }

    /**
     * 收银员明细报表打印
     * @param
     * @param model
     * @return
     */
    @GetMapping("/reportDetailList")
    public String reportDetailList(String settleDateStart,String settleDateEnd,String departmentNum,Model model) {
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            if(!"".equals(ShiroUtils.getUser().getCompanyId()) && null != ShiroUtils.getUser().getCompanyId()){
                query.put("companyid",ShiroUtils.getUser().getCompanyId());
            }
        }
        query.put("departNumber",departmentNum);
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
                                String changesMoney = "0.00";
                                if (null != salesDOs.getChangeMoney()){
                                    changesMoney=salesDOs.getChangeMoney();
                                }
                                for (int s=0;s<modelsMoney.length;s++){
                                    amountMoney = amountMoney + Double.valueOf(modelsMoney[s]);
                                    amountMoney = amountMoney - Double.valueOf(changesMoney);
                                }
                            }
                        }
                        if (null != salesDOs.getAdditionalPrice()){
                            String[] addPrice = salesDOs.getAdditionalPrice().split(",");
                            for (int s=0;s<addPrice.length;s++){
                                if (!"".equals(addPrice[s]) && null != addPrice[s]){
                                    addMoney = addMoney + Double.valueOf(addPrice[s]);
                                }

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

    /**
     * 收银员个人明细报表打印
     * @param
     * @param model
     * @return
     */
    @GetMapping("/reportNameDetailList")
    public String reportNameDetailList(String settleDateStart,String settleDateEnd,String saleAccount,Model model) {
//		List<SettlementDO> settlementList = settlementService.list(query);
//		int total = settlementService.count(query);
//		PageUtils pageUtils = new PageUtils(settlementList, total);
        Map<String,Object> query = new HashMap<>();
        Map<String,Object> maps = new HashMap<>();
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
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        query.put("saleAccount",saleAccount);
        List<SettlementDO> list = saleReportService.findSaleReportForms(query);
        List<SettlementDO> drawList = saleReportService.drawckMoney(query);

        if (null != ShiroUtils.getUser().getCompanyId()){
            maps.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
//        maps.put("departType","销售门店");
        maps.put("state",1);
//        List<DepartmentDO> departmentDOList = departmentService.list(maps);

        List<Map<String,Object>> resultList = new ArrayList<>();
        if (null != list && list.size() > 0){
//            for (DepartmentDO departmentDO : departmentDOList){
                double weixinMoney = 0;
                double zfbMoney = 0;
                double xianjinMoney = 0;
                double yikatongoney = 0;
                double yyshoufeichuMoney = 0;
                double yinliankamoney = 0;
                double chuzhikamoney = 0;
                double dianmoney = 0;
                double diandianmoney = 0;
                double jifenmoney = 0;
                double qtsubTotal = 0;
                double weixinpt = 0;
                //double tkMoney = 0;
                double shihsouTotal = 0;
                String salesAccount = "";
                String saleName = "";
                for (SettlementDO settlementDO : list){
                    salesAccount = settlementDO.getSaleAcount();
                    saleName = settlementDO.getSaleName();
//                    if (departmentDO.getDepartName().equals(settlementDO.getDepartmentName())){
                        String[] payModel = settlementDO.getPayModel().split(",");
                        String[] modelMoney = settlementDO.getModelMoney().split(",");
                        for (int i=0;i<payModel.length;i++){
                            if ("0".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                weixinMoney = weixinMoney + Double.valueOf(modelMoney[i]);
                            } else if ("1".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                zfbMoney = zfbMoney + Double.valueOf(modelMoney[i]);
                            } else if ("4".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                xianjinMoney = xianjinMoney + Double.valueOf(modelMoney[i]);
                            } else if ("2".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yyshoufeichuMoney = yyshoufeichuMoney + Double.valueOf(modelMoney[i]);
                            } else if ("3".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yikatongoney = yikatongoney + Double.valueOf(modelMoney[i]);
                            } else if ("5".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                yinliankamoney = yinliankamoney + Double.valueOf(modelMoney[i]);
                            } else if ("6".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                chuzhikamoney = chuzhikamoney + Double.valueOf(modelMoney[i]);
                            } else if ("7".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                dianmoney = dianmoney + Double.valueOf(modelMoney[i]);
                            } else if ("8".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                diandianmoney = diandianmoney + Double.valueOf(modelMoney[i]);
                            } else if ("9".equals(payModel[i]) && null == settlementDO.getDrawBackMoney()){
                                jifenmoney = jifenmoney + Double.valueOf(modelMoney[i]);
                            } else if ("10".equals(settlementDO.getDrawBackWay())){
                                weixinpt = weixinpt - Double.valueOf(settlementDO.getDrawBackMoney());
                            }
                        }
                        if (null != settlementDO.getChangeMoney()){
                            xianjinMoney = xianjinMoney - settlementDO.getChangeMoney();
                        }

//                    }

                }
            if (null != drawList && drawList.size() > 0){
                for (SettlementDO settlementDO : drawList){
                    String[] drackbackWay = settlementDO.getDrawBackWay().split(",");
                    String[] drackMoney = settlementDO.getDrawBackMoney().split(",");
                    for (int a=0;a<drackbackWay.length;a++){
                        if ("0".equals(drackbackWay[a])){
                            weixinMoney = weixinMoney-Double.valueOf(drackMoney[a]);
                        } else if ("1".equals(drackbackWay[a])){
                            zfbMoney = zfbMoney - Double.valueOf(drackMoney[a]);
                        } else if ("2".equals(drackbackWay[a])){
                            yyshoufeichuMoney = yyshoufeichuMoney - Double.valueOf(drackMoney[a]);
                        } else if ("3".equals(drackbackWay[a])){
                            yikatongoney = yikatongoney - Double.valueOf(drackMoney[a]);
                        } else if ("4".equals(drackbackWay[a])){
                            xianjinMoney = xianjinMoney - Double.valueOf(drackMoney[a]);
                        } else if ("5".equals(drackbackWay[a])){
                            yinliankamoney = yinliankamoney - Double.valueOf(drackMoney[a]);
                        } else if ("6".equals(drackbackWay[a])){
                            chuzhikamoney = chuzhikamoney - Double.valueOf(drackMoney[a]);
                        } else if ("7".equals(drackbackWay[a])){
                            dianmoney = dianmoney - Double.valueOf(drackMoney[a]);
                        } else if ("8".equals(drackbackWay[a])){
                            diandianmoney = diandianmoney - Double.valueOf(drackMoney[a]);
                        } else if ("9".equals(drackbackWay[a])){
                            jifenmoney = jifenmoney - Double.valueOf(drackMoney[a]);
                        } else if ("10".equals(drackbackWay[a])){
                            weixinpt = weixinpt - Double.valueOf(drackMoney[a]);
                        }
                    }

                }
            }
                qtsubTotal = weixinMoney + zfbMoney;
                if (xianjinMoney < 0){
                    shihsouTotal = weixinMoney + zfbMoney +xianjinMoney + yyshoufeichuMoney + yikatongoney + yinliankamoney + diandianmoney + dianmoney + weixinpt;
                } else {
                    shihsouTotal = weixinMoney + zfbMoney +xianjinMoney + yyshoufeichuMoney + yikatongoney + yinliankamoney + diandianmoney + dianmoney + weixinpt;
                }
                Map<String,Object> resultMap = new HashMap<>();
                resultMap.put("saleAccount",salesAccount);
                resultMap.put("saleName",saleName);
                resultMap.put("weixinMoney",new BigDecimal(weixinMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("zfbMoney",new BigDecimal(zfbMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("xianjinMoney",new BigDecimal(xianjinMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yyshoufeichuMoney",new BigDecimal(yyshoufeichuMoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yikatongoney",new BigDecimal(yikatongoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("yinliankamoney",new BigDecimal(yinliankamoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("chuzhikamoney",new BigDecimal(chuzhikamoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("diandianmoney",new BigDecimal(diandianmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("dianmoney",new BigDecimal(dianmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("jifenmoney",new BigDecimal(jifenmoney).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("weixinptmoney",new BigDecimal(weixinpt).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("qtsubTotal",new BigDecimal(qtsubTotal).setScale(2,RoundingMode.HALF_UP));
                resultMap.put("shihsouTotal",new BigDecimal(shihsouTotal).setScale(2,RoundingMode.HALF_UP));
                //resultMap.put("departmentName",departmentDO.getDepartName());
                resultList.add(resultMap);
//                model.addAttribute("yyshoufeichuMoney",new BigDecimal(yyshoufeichuMoney).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("yikatongoney",new BigDecimal(yikatongoney).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("qtsubTotal",new BigDecimal(qtsubTotal).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("shihsouTotal",new BigDecimal(shihsouTotal).setScale(2,RoundingMode.HALF_UP));
//                model.addAttribute("date", simpleDateFormat.format(new Date()));
//            }

        }
        model.addAttribute("resultList",resultList);
        model.addAttribute("date",simpleDateFormat.format(new Date()));
        return "saleReport/saleNameDetailReport";
    }


}
