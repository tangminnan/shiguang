package com.shiguang.optometry.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.logstatus.domain.LensMeterDO;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.OptometryInfoDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("OptometryController")
@RequestMapping("/information/optometry")
public class OptometryController {
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private ResultDiopterService resultDiopterService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CostService costService;
    @Autowired
    private SettlementService settlementService;
    @Autowired
    private LineService lineService;

    @GetMapping()
    @RequiresPermissions("information:optometry:optometry")
    String Optometry() {
        return "optometry/optometry";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometry:optometry")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state", 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateNow = simpleDateFormat.format(new Date());
//        query.put("dateNow",dateNow);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        List<MemberDO> memberDOList = optometryService.findOptoList(query);
        int total = optometryService.findOptoCount(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:optometry:add")
    String add() {
        return "optometry/add";
    }

    @GetMapping("/edit/{cardNumber}/{saleNumber}")
    @RequiresPermissions("information:optometry:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,@PathVariable("saleNumber") String saleNumber, Model model) {
//        OptometryDO optometry = optometryService.get(id);
//        model.addAttribute("optometry", optometry);
        //ResultDiopterDO resultDiopterDO = resultDiopterService.
//        try {
//            Method method = Chuank.class.getMethod("main",
//                    String[].class);
//            method.invoke(null,
//                    (Object) new String[2]);
        try {
            Method method = ChuankOptometry.class.getMethod("main",
                    String[].class);
            method.invoke(null,
                    (Object) new String[2]);
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
            MemberDO memberDO = memberService.getCardNumber(cardNumber);
            if (memberDO.getSex() == 0) {
                memberDO.setSexx("男");
            } else {
                memberDO.setSexx("女");
            }
            model.addAttribute("memberDO", memberDO);
            model.addAttribute("saleNumber",saleNumber);
//        CostDO costDO = costService.getSaleNumByMemNum(cardNumber);
//        SettlementDO settlement = settlementService.getCostId(costDO.getId());
//        model.addAttribute("settlement",settlement);

//        } catch (Exception e) {
//            Throwable cause = e.getCause();
//            if (cause.getLocalizedMessage().contains("被占用")) {
//                return "被占用";
//            } else if (cause.getLocalizedMessage().contains("成功")) {
//                return "";
//            }
//            return "";
//        }
        return "optometry/edit";
    }

    /**
     * 读取数据
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOptometry")
    OptometryDO getOptometry(String cardNumber, Model model) {
        OptometryDO optometryDO = new OptometryDO();
        Long id = Long.valueOf(ShiroUtils.getUser().getCompanyId() + ShiroUtils.getUser().getUsername());
        OptometryInfoDO jdjInfomationDO = optometryService.getOptoInfomation(id);
        if (null != jdjInfomationDO) {
            String jdjInfoDOS = jdjInfomationDO.getRemark1() + jdjInfomationDO.getRemark2();
            if (null != jdjInfomationDO.getRemark3() && !"".equals(jdjInfomationDO.getRemark3())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark3();
            }
            if (null != jdjInfomationDO.getRemark4() && !"".equals(jdjInfomationDO.getRemark4())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark4();
            }
            if (null != jdjInfomationDO.getRemark5() && !"".equals(jdjInfomationDO.getRemark5())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark5();
            }
            if (null != jdjInfomationDO.getRemark6() && !"".equals(jdjInfomationDO.getRemark6())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark6();
            }
            if (null != jdjInfomationDO.getRemark7() && !"".equals(jdjInfomationDO.getRemark7())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark7();
            }

            if (null != jdjInfomationDO.getRemark8() && !"".equals(jdjInfomationDO.getRemark8())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark8();
            }
            if (null != jdjInfomationDO.getRemark9() && !"".equals(jdjInfomationDO.getRemark9())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark9();
            }
            if (null != jdjInfomationDO.getRemark10() && !"".equals(jdjInfomationDO.getRemark10())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark10();
            }
            if (null != jdjInfomationDO.getRemark11() && !"".equals(jdjInfomationDO.getRemark11())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark11();
            }
            if (null != jdjInfomationDO.getRemark12() && !"".equals(jdjInfomationDO.getRemark12())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark12();
            }
            if (null != jdjInfomationDO.getRemark13() && !"".equals(jdjInfomationDO.getRemark13())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark13();
            }
            if (null != jdjInfomationDO.getRemark14() && !"".equals(jdjInfomationDO.getRemark14())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark14();
            }
            if (null != jdjInfomationDO.getRemark15() && !"".equals(jdjInfomationDO.getRemark15())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark15();
            }
            if (null != jdjInfomationDO.getRemark16() && !"".equals(jdjInfomationDO.getRemark16())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark17();
            }
            if (null != jdjInfomationDO.getRemark17() && !"".equals(jdjInfomationDO.getRemark17())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark17();
            }
            if (null != jdjInfomationDO.getRemark18() && !"".equals(jdjInfomationDO.getRemark18())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark18();
            }
            if (null != jdjInfomationDO.getRemark19() && !"".equals(jdjInfomationDO.getRemark19())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark19();
            }
            if (null != jdjInfomationDO.getRemark20() && !"".equals(jdjInfomationDO.getRemark20())) {
                jdjInfoDOS = jdjInfoDOS + jdjInfomationDO.getRemark20();
            }

            String dataSerial = SerialPortUtils.hexStringToString(jdjInfoDOS);
            dataSerial = dataSerial.substring(dataSerial.indexOf("DRM"));
            System.out.println("数据="+dataSerial);
            String left = SpringUtil.getStringData(dataSerial,"OL",2,"OR");
            String zfsphleft = left.substring(0,1);
            String leftSph = zfsphleft + left.substring(2,6);
            String zfcylleft = left.substring(6,7);
            String leftCyl = zfcylleft + left.substring(8,12);
            String leftzx = left.substring(12,15);
            if ("0".equals(leftzx.substring(0,1))){
                leftzx = left.substring(13,15);
            }
            if ("0".equals(leftzx.substring(0,1))){
                leftzx = left.substring(14,15);
            }
            String right = SpringUtil.getStringData(dataSerial,"OR",2,"DKM");
            String zfsphright = right.substring(0,1);
            String rightsph = zfsphright + right.substring(2,6);
            String zfcylright = right.substring(6,7);
            String rightcyl = zfcylright + right.substring(8,12);
            String rightzx = right.substring(12,15);
            if ("0".equals(rightzx.substring(0,1))){
                rightzx = right.substring(13,15);
            }
            if ("0".equals(rightzx.substring(0,1))){
                rightzx = right.substring(14,15);
            }
            optometryDO.setSphereLeft(leftSph);
            optometryDO.setCylinderLeft(leftCyl);
            optometryDO.setAxialLeft(leftzx);
            optometryDO.setSphereRight(rightsph);
            optometryDO.setCylinderRight(rightcyl);
            optometryDO.setAxialRight(rightzx);
            optometryService.deleteOptoInfomation(id);
        }
        try {
            Method method = ChuankOptometry.class.getMethod("main",
                    String[].class);
            method.invoke(null,
                    (Object) new String[4]);
        } catch (Exception e) {
            Throwable cause = e.getCause();
        }
        model.addAttribute("optometryDO", optometryDO);
        return optometryDO;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:optometry:add")
    public R save(OptometryDO optometry) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //保存创建时间
        optometry.setCreateTime(new Date());
//        LineDO lineDO = new LineDO();
//        lineDO.setMemberNumber(optometry.getCardNumber());
//        lineDO.setLineDate(simpleDateFormat.format(new Date()));
//        lineDO.setCallStatus("4");
//        lineService.updateByMember(lineDO);
        if (optometry.getMydriasis() == 0){
            if (optometryService.save(optometry) > 0) {
                return R.ok();
            }
        } else if (optometry.getMydriasis() == 1){
            optometry.setCreateDate(simpleDateFormat.format(new Date()));
            optometryService.update(optometry);
            return R.ok();
        }


        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:optometry:edit")
    public R update(OptometryDO optometry) {

        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 查询会员是否开单或者缴费
     */
    @ResponseBody
    @PostMapping("/getMember")
    @RequiresPermissions("information:ocular:ocular")
    public R getMember( String cardMember){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<CostDO> costDOList = costService.getMemberNum(cardMember);
        if (null != costDOList && costDOList.size() > 0){
            String createDate = simpleDateFormat.format(costDOList.get(0).getCreateTime());
            String datenow = simpleDateFormat.format(new Date());
            if (!createDate.equals(datenow)){
                return R.ok("该会员还未开检查单");
            }
            if (costDOList.get(0).getIsSale() == 0){
                return R.ok("该会员还未缴费");
            }
        } else {
            return R.ok("该会员还未开检查单");
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:optometry:remove")
    public R remove(Long id) {
        if (optometryService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:optometry:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
