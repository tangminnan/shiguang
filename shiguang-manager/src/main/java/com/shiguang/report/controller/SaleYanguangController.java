package com.shiguang.report.controller;


import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.report.domain.SaleReportDO;
import com.shiguang.report.service.SaleReportService;

import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/information/saleYanguang")
public class SaleYanguangController {
    @Autowired
    private SaleReportService saleReportService;
    @Autowired
    private CompanyService companyService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    @GetMapping()
    @RequiresPermissions("information:saleYanguang:saleYanguang")
    String saleYanguang(Model model){
        Map<String, Object> map = new HashMap<>();
        List<CompanyDO> companyList = companyService.list(map);
        model.addAttribute("companyList", companyList);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        return "saleReport/saleYanguang";
    }

    //跳转制造商
    @GetMapping("/findcompany/{companyId}")
//    @RequiresPermissions("information:saleYanguang:findcompany")
    String findcompany(@PathVariable("companyId") Integer companyId, Model model) {
        if (companyId==0){
            model.addAttribute("companyId", "");
        }else {
            model.addAttribute("companyId", companyId);
        }
        return "/baseinfomation/department/choiesDepartment";
    }



    @GetMapping("/findall")
    public String reportList(Integer companyId,String settleDateStart,String settleDateEnd,
                             String department,Integer goodsid,String mfrsname,String brandname,Model model) {
        model.addAttribute("department",department);
        Map<String,Object> map = new HashMap<>();
        List<SalesDO> saleReportDOS=saleReportService.findYanguangPeople(map);
        model.addAttribute("saleReportDOS",saleReportDOS);
        return "saleReport/saleYanguangForm";
    }

}
