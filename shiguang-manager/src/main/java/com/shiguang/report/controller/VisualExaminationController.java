package com.shiguang.report.controller;

import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.report.service.SaleReportService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/visual")
public class VisualExaminationController {
    @Autowired
    private SaleReportService saleReportService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping()
    @RequiresPermissions("information:visual:visual")
    String VisualExaminationController(Model model){
        return "saleReport/visual";
    }

    @GetMapping("/examinationList")
    public String examinationList(String startDate,String endDate,Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        map.put("yearMonth",startDate.substring(0,7));
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<Map> visitList = saleReportService.vistList(map);
        List<Map> followList = saleReportService.followList(map);
        model.addAttribute("visitCount",visitList.size());
        model.addAttribute("followCount",followList.size());
        model.addAttribute("yearMonth",startDate.substring(0,7));
        model.addAttribute("createTime",sdf.format(new Date()));
        return "saleReport/visualForm";
    }

    /**
     * 初诊明细
     * @param startDate
     * @param endDate
     * @param yearMonth
     * @param model
     * @return
     */
    @GetMapping("/visitDetail")
    public String visitDetail(String startDate, String endDate, String yearMonth, Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        map.put("yearMonth",yearMonth);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<MemberDO> memberDOList = saleReportService.visitDetailList(map);
        for (MemberDO m : memberDOList){
            if (m.getSex() == 0){
                m.setSexx("男");
            } else if (m.getSex() == 1){
                m.setSexx("女");
            }
        }
        model.addAttribute("memberDOList",memberDOList);
        model.addAttribute("createTime",sdf.format(new Date()));
        return "saleReport/visualDetailForm";
    }

    /**
     * 复诊明细
     * @param startDate
     * @param endDate
     * @param yearMonth
     * @param model
     * @return
     */
    @GetMapping("/followDetail")
    public String followDetail(String startDate, String endDate, String yearMonth, Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        map.put("yearMonth",yearMonth);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        List<MemberDO> memberDOList = saleReportService.followDetailList(map);
        for (MemberDO m : memberDOList){
            if (m.getSex() == 0){
                m.setSexx("男");
            } else if (m.getSex() == 1){
                m.setSexx("女");
            }
        }
        model.addAttribute("memberDOList",memberDOList);
        model.addAttribute("createTime",sdf.format(new Date()));
        return "saleReport/followDetailForm";
    }

}
