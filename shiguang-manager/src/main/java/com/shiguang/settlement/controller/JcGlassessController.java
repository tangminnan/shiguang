package com.shiguang.settlement.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
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
@RequestMapping("/information/jcglassess")
public class JcGlassessController {
    @Autowired
    private SettlementService settlementService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CostService costService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private MailInfoService mailInfoService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @RequiresPermissions("information:jcglassess:jcglassess")
    String Settlement(){
        return "glassess/jcglassess";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:jcglassess:jcglassess")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
        query.put("type","检查单");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("cardNumber") && !"".equals(params.get("cardNumber"))){
            query.put("cardNumber",String.valueOf(query.get("cardNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("name",String.valueOf(query.get("name")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("phone1") && !"".equals(params.get("phone1"))){
            query.put("phone1",String.valueOf(query.get("phone1")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        List<SettlementDO> settlementDOList = settlementService.findJcGlassesData(query);
        if (null != settlementDOList && settlementDOList.size() > 0){
            for (SettlementDO settlementDO : settlementDOList){
                if ("定金".equals(settlementDO.getPayWay())){
                    Double arrearMoney = settlementDO.getActualMoney() - settlementDO.getPayMoney();
                    settlementDO.setArrearsMoney(arrearMoney);
                }
            }
        }
        //List<MemberDO> memberDOList = memberService.payList(query);
        int total = settlementService.findJcGlassesDataCount(query);
        PageUtils pageUtils = new PageUtils(settlementDOList, total);
        return pageUtils;
    }

    /**
     * 检查单打印
     * @param saleNumber
     * @param model
     * @return
     */
    @GetMapping("/jianchadayin")
    public String jianchadayin(String saleNumber, Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
        List<CostDO> costDOList = costService.list(map);
        model.addAttribute("costDOList",costDOList);
        Double sumMoney =0.00;
        String jianchaDate="";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (CostDO costDO : costDOList){
            sumMoney =sumMoney+costDO.getCostMoney();
        }
        model.addAttribute("sumMoney",sumMoney);
        model.addAttribute("jianchaTime",simpleDateFormat.format(costDOList.get(0).getCreateTime()));
        return "settlement/jianchadan";
    }

}
