package com.shiguang.retailprice.controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;
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


/**
 * 排队叫号汇总表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
 
@Controller
@RequestMapping("/YgLineAll/YgLineAll")
public class YgLineAllController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private LineService lineService;


    @GetMapping()
    @RequiresPermissions("YgLineAll:YgLineAll:YgLineAll")
    String stockPidiaoAll(Model model) {
        Map<String, Object> map = new HashMap<>();
        List<CompanyDO> companyList = companyService.list(map);
        model.addAttribute("companyList", companyList);
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        model.addAttribute("companyId", companyId);
        return "retailprice/ygLine/Ygline";
    }



    @GetMapping("/findall")
    public String reportList(Integer companyId, String settleDateStart, String settleDateEnd,String newOld, Model model) {
        List<LineDO> lineDOS = new ArrayList<>();
        if ("new".equals(newOld)){
            Map<String, Object> map = new HashMap<>();
            map.put("companyId",companyId);
            map.put("settleDateStart",settleDateStart);
            map.put("settleDateEnd",settleDateEnd);
            map.put("callStatus","4");
            lineDOS  =  lineService.newList(map);
        }else if ("old".equals(newOld)){
            Map<String, Object> map = new HashMap<>();
            map.put("companyId",companyId);
            map.put("settleDateStart",settleDateStart);
            map.put("settleDateEnd",settleDateEnd);
            map.put("callStatus","4");
             lineDOS  =  lineService.oldList(map);
        }
        model.addAttribute("lineDOS",lineDOS);
        return "retailprice/ygLine/newoldLine";
    }


}
