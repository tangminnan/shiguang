package com.shiguang.report.controller;


import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.product.domain.*;
import com.shiguang.report.service.SaleReportService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/information/saleDoctor")
public class SaleDoctorController {
    @Autowired
    private SaleReportService saleReportService;
    @Autowired
    private CompanyService companyService;
    //商品类别
    @Autowired
    private GoodsService goodsService;

    @GetMapping()
    @RequiresPermissions("information:saleDoctor:saleDoctor")
    String saleDoctor(Model model) {
        Map<String, Object> map = new HashMap<>();
        List<CompanyDO> companyList = companyService.list(map);
        model.addAttribute("companyList", companyList);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        model.addAttribute("companyId", companyId);
        return "saleReport/saleDoctor";
    }

    //跳转制造商
    @GetMapping("/findcompany/{companyId}")
    String findcompany(@PathVariable("companyId") Integer companyId, Model model) {
        if (companyId == 0) {
            model.addAttribute("companyId", "");
        } else {
            model.addAttribute("companyId", companyId);
        }
        return "/baseinfomation/department/choiesDepartment";
    }


    @GetMapping("/findall")
    public String reportList(Integer companyId, String settleDateStart, String settleDateEnd, String departments,String newOld, Model model) {
        Map<String, Object> map = new HashMap<>();
        if (companyId == 0) {
            map.put("companyId", "");
        } else {
            map.put("companyId", companyId);
        }
        map.put("settleDateStart", settleDateStart);
        map.put("settleDateEnd", settleDateEnd);
        map.put("newOld", newOld);

        String[] department = departments.split(",");
        for (int d = 0; d < department.length; d++) {
            map.put("department", department[d]);
            List<SalesDO> doctorPeoples = saleReportService.findDoctorPeople(map);
            model.addAttribute("doctorPeoples", doctorPeoples);
            List<Map<String, Object>> listMoney = new ArrayList<>();
//            if (null != yanguangPeoples && yanguangPeoples.size() > 0) {
            for (SalesDO doctorPeople : doctorPeoples) {
                String username = doctorPeople.getUsername();
                map.put("username", username);


                int cfcount = saleReportService.findCfCount(map);
                //销售金额，价钱，成交
                int usecount = saleReportService.findCfUseCount(map);
                int amountMoney = saleReportService.findCfamountMoney(map);
                double primeMoney;
                List<SalesDO> Goods = saleReportService.findDoctorGoods(map);
                double jjMoney = 0.00;
                double pjMoney = 0.00;
                double jpMoney = 0.00;
                double jpdzMoney = 0.00;
                double yxMoney = 0.00;
                double yxdzMoney = 0.00;
                double hlyMoney = 0.00;
                double tyjMoney = 0.00;
                double lhjMoney = 0.00;
                double hcMoney = 0.00;
                double sgMoney = 0.00;

                for (SalesDO good : Goods) {
                    String[] storeDescribes = null;
                    if (null != good.getStoreDescribe() && !"".equals(good.getStoreDescribe())) {
                        storeDescribes = good.getStoreDescribe().split(",");
                    }
                    String[] classtypes = null;
                    if (null != good.getClasstype() && !"".equals(good.getClasstype())) {
                        classtypes = good.getClasstype().split(",");
                    }
                    String[] storeCounts = null;
                    if (null != good.getStoreCount() && !"".equals(good.getStoreCount())) {
                        storeCounts = good.getStoreCount().split(",");
                    }
                    String[] storeUnits = null;
                    if (null != good.getStoreUnit()) {
                        storeUnits = good.getStoreUnit().split(",");
                    }
                    String[] storeNames = null;
                    if (null != good.getStoreName()) {
                        storeNames = good.getStoreName().split(",");
                    }
                    if (null != storeDescribes) {
                        for (int i = 0; i < storeDescribes.length; i++) {
                            String goodstype = storeDescribes[i];
                            String classtype = classtypes[i];
                            String money = storeUnits[i];
                            String count = storeCounts[i];
                            String name = storeNames[i];
                            if ("镜架".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        jjMoney = jjMoney + 0.00;
                                    } else {
                                        jjMoney = jjMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("配件".equals(goodstype) || "镜架配件".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        pjMoney = pjMoney + 0.00;
                                    } else {
                                        pjMoney = pjMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            }
                            else if ("镜片".equals(goodstype)  && "1".equals(classtype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        jpMoney = jpMoney + 0.00;
                                    } else {
                                        jpMoney = jpMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            }else if ("镜片".equals(goodstype)  && "2".equals(classtype) ) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        jpdzMoney = jpdzMoney + 0.00;
                                    } else {
                                        jpdzMoney = jpdzMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("隐形".equals(goodstype)  && "1".equals(classtype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        yxMoney = yxMoney + 0.00;
                                    } else {
                                        yxMoney = yxMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }

                                }
                            } else if ("隐形".equals(goodstype)  && "2".equals(classtype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        yxdzMoney = yxdzMoney + 0.00;
                                    } else {
                                        yxdzMoney = yxdzMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            }
                            else if ("护理液".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        hlyMoney = hlyMoney + 0.00;
                                    } else {
                                        hlyMoney = hlyMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("太阳镜".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        tyjMoney = tyjMoney + 0.00;
                                    } else {
                                        tyjMoney = tyjMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("老花镜".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        lhjMoney = lhjMoney + 0.00;
                                    } else {
                                        lhjMoney = lhjMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("耗材".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        hcMoney = hcMoney + 0.00;
                                    } else {
                                        hcMoney = hcMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            } else if ("视光".equals(goodstype)) {
                                if (null != storeUnits && null != storeCounts) {
                                    if ("".equals(money)) {
                                        sgMoney = sgMoney + 0.00;
                                    } else {
                                        sgMoney = sgMoney + Double.valueOf(Double.valueOf(money) * Integer.parseInt(count));
                                    }
                                }
                            }
                        }
                    }

                }
                primeMoney = jjMoney + pjMoney + jpMoney + jpdzMoney+ yxMoney + yxdzMoney + hlyMoney + tyjMoney + lhjMoney + hcMoney + sgMoney;

                Map<String, Object> listmap = new HashMap<>();
                listmap.put("jjMoney", new BigDecimal(jjMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("pjMoney", new BigDecimal(pjMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("jpMoney", new BigDecimal(jpMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("jpdzMoney", new BigDecimal(jpdzMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("yxMoney", new BigDecimal(yxMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("yxdzMoney", new BigDecimal(yxdzMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("hlyMoney", new BigDecimal(hlyMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("tyjMoney", new BigDecimal(tyjMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("lhjMoney", new BigDecimal(lhjMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("hcMoney", new BigDecimal(hcMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("sgMoney", new BigDecimal(sgMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("cfcount", new BigDecimal(Integer.valueOf(cfcount)));
                listmap.put("usecount", new BigDecimal(Integer.valueOf(usecount)));
                listmap.put("amountMoney", new BigDecimal(amountMoney).setScale(2, RoundingMode.HALF_UP));
                listmap.put("primeMoney", new BigDecimal(primeMoney).setScale(2, RoundingMode.HALF_UP));
                listMoney.add(listmap);
//                }
            }
            model.addAttribute("listMoney", listMoney);
        }

        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String createTime = sdf.format(date);
        model.addAttribute("createTime", createTime);

        model.addAttribute("settleDateStart", settleDateStart);
        model.addAttribute("settleDateEnd", settleDateEnd);
        model.addAttribute("departments", departments);
        model.addAttribute("newOld", newOld);
        return "saleReport/saleDoctorForm";
    }

@GetMapping("/Brand")
public String Brand(String settleDateStart, String settleDateEnd,
                      String username, String storeDescribe, String selectGoods,  String newOld, Model model) {

    Map<String, Object> map = new HashMap<>();
    map.put("settleDateStart", settleDateStart);
    map.put("settleDateEnd", settleDateEnd);
    map.put("username", username);
    map.put("storeDescribe", storeDescribe);
    map.put("newOld", newOld);

    List<SalesDO> Goods = saleReportService.findDoctorGoods(map);
    List<Map<String, Object>> listBrand = new ArrayList<>();
    for (SalesDO good : Goods) {
        String[] storeDescribes = null;
        if (null != good.getStoreDescribe() && !"".equals(good.getStoreDescribe())) {
            storeDescribes = good.getStoreDescribe().split(",");
        }
        String[] storeCounts = null;
        if (null != good.getStoreCount() && !"".equals(good.getStoreCount())) {
            storeCounts = good.getStoreCount().split(",");
        }
        String[] storeUnits = null;
        if (null != good.getStoreUnit()) {
            storeUnits = good.getStoreUnit().split(",");
        }
        String[] goodsNum = null;
        if (null != good.getGoodsNum()) {
            goodsNum = good.getGoodsNum().split(",");
        }
        String[] classtypes = null;
        if (null != good.getClasstype() && !"".equals(good.getClasstype())) {
            classtypes = good.getClasstype().split(",");
        }
        if (null != storeDescribes) {
            for (int i = 0; i < storeDescribes.length; i++) {
                String goodstype = storeDescribes[i];
                String classtype = classtypes[i];
                if ("镜架".equals(selectGoods)) {
                    if ("镜架".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        ProducaDO producaDO = saleReportService.findJj(goodNum);
                        String goodsBrandNum = producaDO.getBrandnum();
                        String goodsBrandName = producaDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                } else if ("配件".equals(selectGoods)) {
                    if ("配件".equals(goodstype) || "镜架配件".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        PartsDO partsDO = saleReportService.findpj(goodNum);
                        String goodsBrandNum = partsDO.getBrandnum();
                        String goodsBrandName = partsDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                } else if ("镜片成品".equals(selectGoods)) {
                    if ("镜片".equals(goodstype) && "1".equals(classtype) ) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        JpcpDO jpcpDO = saleReportService.findjp(goodNum);
                        String goodsBrandNum = jpcpDO.getBrandnum();
                        String goodsBrandName = jpcpDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                } else if ("镜片订做".equals(selectGoods)) {
                    if ("镜片".equals(goodstype) && "2".equals(classtype) ) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        JpdzDO jpdzDO = saleReportService.findjpdz(goodNum);
                        String goodsBrandNum = jpdzDO.getBrandnum();
                        String goodsBrandName = jpdzDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("隐形成品".equals(selectGoods)) {
                    if ("隐形".equals(goodstype) && "1".equals(classtype) ) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        YxcpDO yxcpDO = saleReportService.findyx(goodNum);
                        String goodsBrandNum = yxcpDO.getBrandnum();
                        String goodsBrandName = yxcpDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("隐形订做".equals(selectGoods)) {
                    if ("隐形".equals(goodstype) && "2".equals(classtype) ) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        YxdzDO yxdzDO = saleReportService.findyxdz(goodNum);
                        String goodsBrandNum = yxdzDO.getBrandnum();
                        String goodsBrandName = yxdzDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("护理液".equals(selectGoods)) {
                    if ("护理液".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        HlyDO hlyDO = saleReportService.findhly(goodNum);
                        String goodsBrandNum = hlyDO.getBrandnum();
                        String goodsBrandName = hlyDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("太阳镜".equals(selectGoods)) {
                    if ("太阳镜".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        TyjDO tyjDO = saleReportService.findtyj(goodNum);
                        String goodsBrandNum = tyjDO.getBrandnum();
                        String goodsBrandName = tyjDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("老花镜".equals(selectGoods)) {
                    if ("老花镜".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        OldlensDO oldlensDO = saleReportService.findlhj(goodNum);
                        String goodsBrandNum = oldlensDO.getBrandnum();
                        String goodsBrandName = oldlensDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("耗材".equals(selectGoods)) {
                    if ("耗材".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        HcDO hcDO = saleReportService.findhc(goodNum);
                        String goodsBrandNum = hcDO.getBrandnum();
                        String goodsBrandName = hcDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }else if ("视光".equals(selectGoods)) {
                    if ("视光".equals(goodstype)) {
                        String money = storeUnits[i];
                        String count = storeCounts[i];
                        String goodNum = goodsNum[i];
                        ShiguangDO shiguangDO = saleReportService.findsg(goodNum);
                        String goodsBrandNum = shiguangDO.getBrandnum();
                        String goodsBrandName = shiguangDO.getBrandname();
                        Map<String, Object> listmap = new HashMap<>();
                        listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                        listmap.put("count", count);
                        listmap.put("goodsBrandNum", goodsBrandNum);
                        listmap.put("goodsBrandName", goodsBrandName);
                        listBrand.add(listmap);
                    }
                }

            }
        }
    }
    // 利用set不允许元素重复的性质去掉相同的元素
    List<Map<String, Object>> listBrandMoney = new ArrayList<>();
    Set<String> checkDuplicates = new HashSet<String>();
    double jjMoney = 0.00;
    int jjCount = 0;
    String jjbrand  ;
    String jjbrandname ;
    for (int a = 0; a < listBrand.size(); a++) {


        Map<String, Object> newlistmap = new HashMap<>();
        String items =   listBrand.get(a).get("goodsBrandNum").toString();
        String goodsBrandName = listBrand.get(a).get("goodsBrandName").toString();
        double money =  Double.valueOf(listBrand.get(a).get("money").toString());
        int count = Integer.valueOf(listBrand.get(a).get("count").toString());
        money=money*count;
        if (!checkDuplicates.add(items+goodsBrandName)) {
            // 重复的元素
            String cfmoney = null;
            String cfcount = null;
            for (int b = 0; b < listBrandMoney.size(); b++) {
                String brandNum = listBrandMoney.get(b).get("jjbrand").toString();
                String brandName = listBrandMoney.get(b).get("jjbrandname").toString();
                if (String.valueOf(brandNum + brandName).equals(items + goodsBrandName)) {
                    cfmoney=listBrandMoney.get(b).get("jjMoney").toString();
                    cfcount=listBrandMoney.get(b).get("jjCount").toString();

                }
            }
            jjMoney =  Double.valueOf(cfmoney) + money;
            jjCount = Integer.valueOf(cfcount)  + count;
            jjbrand=  listBrand.get(a).get("goodsBrandNum").toString();
            jjbrandname =  listBrand.get(a).get("goodsBrandName").toString();
            newlistmap.put("jjMoney", new BigDecimal(jjMoney).setScale(2, RoundingMode.HALF_UP));
            newlistmap.put("jjCount", jjCount);
            newlistmap.put("jjbrand", jjbrand);
            newlistmap.put("jjbrandname", jjbrandname);
//            listBrand.remove(a);
//            listBrand.add(newlistmap);

            for (int i = 0; i < listBrandMoney.size(); i++) {
                String brandNum = listBrandMoney.get(i).get("jjbrand").toString();
                String brandName = listBrandMoney.get(i).get("jjbrandname").toString();
                if (String.valueOf(brandNum + brandName).equals(items + goodsBrandName)) {
                    listBrandMoney.remove(i);
                    listBrandMoney.add(newlistmap);
                }
            }
        }else {
            newlistmap.put("jjMoney", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
            newlistmap.put("jjCount", count);
            newlistmap.put("jjbrand", items);
            newlistmap.put("jjbrandname", goodsBrandName);
            listBrandMoney.add(newlistmap);
        }

    }
    model.addAttribute("listBrandMoney", listBrandMoney);
    model.addAttribute("settleDateStart", settleDateStart);
    model.addAttribute("settleDateEnd", settleDateEnd);
    model.addAttribute("username", username);
    model.addAttribute("storeDescribe", storeDescribe);
    model.addAttribute("selectGoods", selectGoods);
    //———获取当前系统时间—————
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
    Date date = new Date();
    String createTime = sdf.format(date);
    model.addAttribute("createTime", createTime);
    model.addAttribute("newOld", newOld);
    return "saleReport/doctorGoodsBrand";
}

    @GetMapping("/goodsList")
    public String goodsList(String settleDateStart, String settleDateEnd, String brandnum, String brandname,
                            String username, String storeDescribe, String selectGoods, String newOld,  Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("settleDateStart", settleDateStart);
        map.put("settleDateEnd", settleDateEnd);
        map.put("username", username);
        map.put("storeDescribe", storeDescribe);
        map.put("newOld", newOld);

        List<SalesDO> Goods = saleReportService.findDoctorGoods(map);
        List<Map<String, Object>> goodsLists = new ArrayList<>();
        for (SalesDO good : Goods) {
            String[] storeDescribes = null;
            if (null != good.getStoreDescribe() && !"".equals(good.getStoreDescribe())) {
                storeDescribes = good.getStoreDescribe().split(",");
            }

            String[] saleNumbers = null;
            if (null != good.getSaleNumber() && !"".equals(good.getSaleNumber())) {
                saleNumbers = good.getSaleNumber().split(",");
            }
            String[] goodsNums = null;
            if (null != good.getGoodsNum()) {
                goodsNums = good.getGoodsNum().split(",");
            }
            String[] goodsNames = null;
            if (null != good.getStoreName()) {
                goodsNames = good.getStoreName().split(",");
            }

            String[] storeCounts = null;
            if (null != good.getStoreCount() && !"".equals(good.getStoreCount())) {
                storeCounts = good.getStoreCount().split(",");
            }
            String[] storeUnits = null;
            if (null != good.getStoreUnit()) {
                storeUnits = good.getStoreUnit().split(",");
            }

            String[] classtypes = null;
            if (null != good.getClasstype() && !"".equals(good.getClasstype())) {
                classtypes = good.getClasstype().split(",");
            }

            if (null != storeDescribes) {
                for (int i = 0; i < storeDescribes.length; i++) {

                    String goodstype = storeDescribes[i];



                    String classtype = classtypes[i];
                    String saleNumber = saleNumbers[0];//配镜单号
                    String goodNum = goodsNums[i];//商品代码
                    String goodName = goodsNames[i];//商品名称
                    if ("镜架".equals(selectGoods) ) {
                        if("镜架".equals(goodstype) ){
                            ProducaDO producaDO = saleReportService.findJj(goodNum);
                            String goodsBrandNum = producaDO.getBrandnum();
                            String goodsBrandName = producaDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = producaDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];
                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("配件".equals(selectGoods) ) {
                        if("配件".equals(goodstype) || "镜架配件".equals(goodstype) ){
                            PartsDO partsDO = saleReportService.findpj(goodNum);
                            String goodsBrandNum = partsDO.getBrandnum();
                            String goodsBrandName = partsDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = partsDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("镜片成品".equals(selectGoods) ) {
                        if("镜片".equals(goodstype) && "1".equals(classtype) ){
                            JpcpDO jpcpDO = saleReportService.findjp(goodNum);
                            String goodsBrandNum = jpcpDO.getBrandnum();
                            String goodsBrandName = jpcpDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = jpcpDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("镜片订做".equals(selectGoods) ) {
                        if("镜片".equals(goodstype) && "2".equals(classtype) ){
                            JpdzDO jpdzDO = saleReportService.findjpdz(goodNum);
                            String goodsBrandNum = jpdzDO.getBrandnum();
                            String goodsBrandName = jpdzDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = jpdzDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("隐形成品".equals(selectGoods) ) {
                        if("隐形".equals(goodstype) && "1".equals(classtype) ){
                            YxcpDO yxcpDO = saleReportService.findyx(goodNum);
                            String goodsBrandNum = yxcpDO.getBrandnum();
                            String goodsBrandName = yxcpDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = yxcpDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("隐形订做".equals(selectGoods) ) {
                        if("隐形".equals(goodstype) && "2".equals(classtype) ){
                            YxdzDO yxdzDO = saleReportService.findyxdz(goodNum);
                            String goodsBrandNum = yxdzDO.getBrandnum();
                            String goodsBrandName = yxdzDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = yxdzDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("护理液".equals(selectGoods) ) {
                        if("护理液".equals(goodstype) ){
                            HlyDO hlyDO = saleReportService.findhly(goodNum);
                            String goodsBrandNum = hlyDO.getBrandnum();
                            String goodsBrandName = hlyDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = hlyDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("太阳镜".equals(selectGoods) ) {
                        if("太阳镜".equals(goodstype) ){
                            TyjDO tyjDO = saleReportService.findtyj(goodNum);
                            String goodsBrandNum = tyjDO.getBrandnum();
                            String goodsBrandName = tyjDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = tyjDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("老花镜".equals(selectGoods) ) {
                        if("老花镜".equals(goodstype) ){
                            OldlensDO oldlensDO = saleReportService.findlhj(goodNum);
                            String goodsBrandNum = oldlensDO.getBrandnum();
                            String goodsBrandName = oldlensDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = oldlensDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("耗材".equals(selectGoods) ) {
                        if("耗材".equals(goodstype) ){
                            HcDO hcDO = saleReportService.findhc(goodNum);
                            String goodsBrandNum = hcDO.getBrandnum();
                            String goodsBrandName = hcDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = hcDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }else if ("视光".equals(selectGoods) ) {
                        if("视光".equals(goodstype) ){
                            ShiguangDO shiguangDO = saleReportService.findsg(goodNum);
                            String goodsBrandNum = shiguangDO.getBrandnum();
                            String goodsBrandName = shiguangDO.getBrandname();
                            if (brandnum.equals(goodsBrandNum) && brandname.equals(goodsBrandName)) {
                                String viewGoodName = shiguangDO.getViewGoodName();
                                String money = storeUnits[i];
                                String count = storeCounts[i];

                                Map<String, Object> listmap = new HashMap<>();
                                listmap.put("saleNumber", saleNumber);
                                listmap.put("goodNum", goodNum);
                                listmap.put("goodName", viewGoodName);
                                listmap.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                                listmap.put("count", count);
                                goodsLists.add(listmap);
                            }
                        }
                    }
                }
            }
        }



        // 利用set不允许元素重复的性质去掉相同的元素
        List<Map<String, Object>> GoodsList = new ArrayList<>();
        Set<String> checkDuplicates = new HashSet<String>();
        double goodsMoney = 0.00;
        int goodsCount = 0;

        for (int a = 0; a < goodsLists.size(); a++) {
            Map<String, Object> goods = new HashMap<>();
            String saleNumber =   goodsLists.get(a).get("saleNumber").toString();
            String goodNum = goodsLists.get(a).get("goodNum").toString();
            String goodName = goodsLists.get(a).get("goodName").toString();
            double money =  Double.valueOf(goodsLists.get(a).get("money").toString());
            int count = Integer.valueOf(goodsLists.get(a).get("count").toString());
            money=money*count;

            if (!checkDuplicates.add(saleNumber+goodNum)) {
                // 重复的元素
                String cfmoney = null;
                String cfcount = null;
                for (int b = 0; b < GoodsList.size(); b++) {
                    String number = GoodsList.get(b).get("saleNumber").toString();
                    String num = GoodsList.get(b).get("goodNum").toString();
                    if (String.valueOf(number + num).equals(saleNumber + goodNum)) {
                        cfcount=GoodsList.get(b).get("count").toString();
                        cfmoney=GoodsList.get(b).get("money").toString();


                    }
                }
                saleNumber=  goodsLists.get(a).get("saleNumber").toString();
                goodNum=  goodsLists.get(a).get("goodNum").toString();
                goodName=  goodsLists.get(a).get("goodName").toString();

                goodsMoney =  Double.valueOf(cfmoney) + money;
                goodsCount = Integer.valueOf(cfcount)  + count;

                goods.put("saleNumber", saleNumber);
                goods.put("goodNum", goodNum);
                goods.put("goodName", goodName);
                goods.put("money", new BigDecimal(goodsMoney).setScale(2, RoundingMode.HALF_UP));
                goods.put("count", goodsCount);
                for (int i = 0; i < GoodsList.size(); i++) {
                    String saleNumbers = GoodsList.get(i).get("saleNumber").toString();
                    String goodNums = GoodsList.get(i).get("goodNum").toString();
                    if (String.valueOf(saleNumbers + goodNums).equals(saleNumber + goodNum)) {
                        GoodsList.remove(i);
                        GoodsList.add(goods);
                    }
                }
            }else {
                goods.put("saleNumber", saleNumber);
                goods.put("goodNum", goodNum);
                goods.put("goodName", goodName);
                goods.put("money", new BigDecimal(money).setScale(2, RoundingMode.HALF_UP));
                goods.put("count", count);
                GoodsList.add(goods);
            }

        }
        model.addAttribute("GoodsList", GoodsList);

        model.addAttribute("settleDateStart", settleDateStart);
        model.addAttribute("settleDateEnd", settleDateEnd);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String createTime = sdf.format(date);
        model.addAttribute("createTime", createTime);
        return "saleReport/doctorGoods";
    }


    @GetMapping("/Yg")
    public String Yg(String settleDateStart, String settleDateEnd,
                        String username,String newOld, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("settleDateStart", settleDateStart);
        map.put("settleDateEnd", settleDateEnd);
        map.put("username", username);
        map.put("newOld", newOld);
        model.addAttribute("settleDateStart", settleDateStart);
        model.addAttribute("settleDateEnd", settleDateEnd);
        model.addAttribute("username", username);
        List<SalesDO> yg = saleReportService.Yg(map);
        List namelist=new ArrayList();
        for (int i=0;i<yg.size();i++){
            namelist.add(yg.get(i).getYg());
        }
        int count=1;
        List<Map<String, Object>> doctorsCount = new ArrayList<>();

        for (int i=0;i<namelist.size();i++){
            count=1;
            for (int j=i+1;j<namelist.size();j++){
                if (namelist.get(i)!= null && namelist.get(j) !=null){
                    if (namelist.get(i).equals(namelist.get(j))){
                        count++;
                        namelist.remove(j);
                        j--;
                    }
                }

            }
            String  doctors= (String) namelist.get(i);
            Integer counts= count;
            Map<String, Object> ygDoctormap = new HashMap<>();
            ygDoctormap.put("doctors",doctors);
            ygDoctormap.put("counts",counts);
            doctorsCount.add( ygDoctormap);
        }
        model.addAttribute("doctorsCount", doctorsCount);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String createTime = sdf.format(date);
        model.addAttribute("createTime", createTime);
        return "saleReport/yg";
    }


    @GetMapping("/YgUse")
    public String YgUse(String settleDateStart, String settleDateEnd,
                        String username,String newOld, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("settleDateStart", settleDateStart);
        map.put("settleDateEnd", settleDateEnd);
        map.put("username", username);
        map.put("newOld", newOld);
        model.addAttribute("settleDateStart", settleDateStart);
        model.addAttribute("settleDateEnd", settleDateEnd);
        model.addAttribute("username", username);
        List<SalesDO> ygUse = saleReportService.YgUse(map);
        List namelist=new ArrayList();
        for (int i=0;i<ygUse.size();i++){
            namelist.add(ygUse.get(i).getYg());
        }
        int count=1;
        List<Map<String, Object>> doctorsCount = new ArrayList<>();

        for (int i=0;i<namelist.size();i++){
            count=1;
            for (int j=i+1;j<namelist.size();j++){
                if (namelist.get(i)!= null && namelist.get(j) !=null){
                    if (namelist.get(i).equals(namelist.get(j))){
                        count++;
                        namelist.remove(j);
                        j--;
                    }
                }
            }
            String  doctors= (String) namelist.get(i);
            Integer counts= count;
            Map<String, Object> ygDoctormap = new HashMap<>();
            ygDoctormap.put("doctors",doctors);
            ygDoctormap.put("counts",counts);
            doctorsCount.add( ygDoctormap);
        }
        model.addAttribute("doctorsCount", doctorsCount);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String createTime = sdf.format(date);
        model.addAttribute("createTime", createTime);
        return "saleReport/yg";
    }



}
