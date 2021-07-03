package com.shiguang.optometryNEW.controller;

import com.shiguang.common.utils.*;
import com.shiguang.jiancha.service.SubjectiveService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("OptometryNewController")
@RequestMapping("/information/optometryNew")
public class OptometryNewController {
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private ResultDiopterService resultDiopterService;
    @Autowired
    private MemberService memberService;
    //检查主观验光
    @Autowired
    private SubjectiveService subjectiveService;

    @GetMapping()
    @RequiresPermissions("information:optometryNew:optometryNew")
    String Optometry() {
        return "optometryNew/optometryNew";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryNew:optometryNew")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state", 1);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:optometryNew:add")
    String add() {
        return "optometryNew/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:optometryNew:edit")
    String edit(@PathVariable("cardNumber") String cardNumber, Model model) {
//————会员信息——————
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO", memberDO);
//————电脑验光————
        Map<String, Object> map = new HashMap<>();
        //散瞳前
        List<OptometryDO> list1 = optometryService.optoFrontList(map);
        OptometryDO optometryFrontDO = new OptometryDO();
        if (list1.size() > 0) {
            optometryFrontDO.setCylinderRight(list1.get(0).getCylinderRight());
            optometryFrontDO.setCylinderLeft(list1.get(0).getCylinderLeft());
            optometryFrontDO.setAxialRight(list1.get(0).getAxialRight());
            optometryFrontDO.setAxialLeft(list1.get(0).getAxialLeft());
            optometryFrontDO.setSphereRight(list1.get(0).getSphereRight());
            optometryFrontDO.setSphereLeft(list1.get(0).getSphereLeft());
            optometryFrontDO.setOptometryName(list1.get(0).getOptometryName());
            optometryFrontDO.setPtometryNumber(list1.get(0).getPtometryNumber());

        }
        model.addAttribute("optometryFrontDO", optometryFrontDO);

        //散瞳后
        List<OptometryDO> list2 = optometryService.optoAfterList(map);
        OptometryDO optometryAfterDO = new OptometryDO();
        if (list2.size() > 0) {
            optometryAfterDO.setMydriasis(list2.get(0).getMydriasis());
            optometryAfterDO.setCylinderRight(list2.get(0).getCylinderRight());
            optometryAfterDO.setCylinderLeft(list2.get(0).getCylinderLeft());
            optometryAfterDO.setAxialRight(list2.get(0).getAxialRight());
            optometryAfterDO.setAxialLeft(list2.get(0).getAxialLeft());
            optometryAfterDO.setSphereRight(list2.get(0).getSphereRight());
            optometryAfterDO.setSphereLeft(list2.get(0).getSphereLeft());
            optometryAfterDO.setOptometryName(list2.get(0).getOptometryName());
            optometryAfterDO.setPtometryNumber(list2.get(0).getPtometryNumber());

        }
        model.addAttribute("optometryAfterDO", optometryAfterDO);

//———生成验光号————
        Long uuid = GuuidUtil.getUUID();
        String uuidstr = "Y" + uuid.toString();
        model.addAttribute("uuidstr", uuidstr);
//———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
//———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("creatTime", newDate);

        return "optometryNew/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:optometryNew:add")
    public R save(OptometryDO optometry) {

        if (optometryService.save(optometry) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:optometryNew:edit")
    public R update(OptometryDO optometry) {
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:optometryNew:remove")
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
    @RequiresPermissions("information:optometryNew:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
