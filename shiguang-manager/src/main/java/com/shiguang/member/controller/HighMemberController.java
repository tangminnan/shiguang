package com.shiguang.member.controller;

import com.shiguang.baseinfomation.domain.*;
import com.shiguang.baseinfomation.service.*;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("HighMemberController")
@RequestMapping("/information/highmember")
public class HighMemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private CardTypeService typeService;
    @Autowired
    private PersonSortService personSortService;
    @Autowired
    private VocationService vocationService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private InterestService interestService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @RequiresPermissions("information:highmember:highmember")
    String Member(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("departType","销售门店");
        map.put("state",1);
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
        Map<String, Object> maps = new HashMap<>();
        maps.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(maps);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(maps);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(maps);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(maps);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(maps);
        model.addAttribute("interestDOList",interestDOList);
        return "highmember/highmember";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:highmember:highmember")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
//        if (null != ShiroUtils.getUser().getCompanyId()){
//            query.put("companyId",ShiroUtils.getUser().getCompanyId());
//        } else {
//            if (null != ShiroUtils.getUser().getStoreNum()){
//                query.put("departNumber",ShiroUtils.getUser().getStoreNum());
//            }
//        }
        List<MemberDO> memberList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberList, total);
        return pageUtils;
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:highmember:edit")
    String edit(@PathVariable("id") Long id,Model model){
        MemberDO member = memberService.get(id);
        model.addAttribute("member", member);
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(map);
        model.addAttribute("interestDOList",interestDOList);
        return "highmember/edit";
    }

    @GetMapping("/detail/{id}")
    @RequiresPermissions("information:highmember:detail")
    String detail(@PathVariable("id") Long id,Model model){
        MemberDO member = memberService.get(id);
        if (member.getSex() == 0){
            member.setSexx("男");
        } else if (member.getSex() == 1){
            member.setSexx("女");
        }
        if (member.getProvinceName() ==null){
            member.setProvinceName("0");
        }
        model.addAttribute("member", member);
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(map);
        model.addAttribute("interestDOList",interestDOList);
        return "highmember/detail";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:highmember:edit")
    public R update( MemberDO member){
        memberService.update(member);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:highmember:remove")
    public R remove(Long id){
        MemberDO memberDO = new MemberDO();
        memberDO.setState(0L);
        memberDO.setId(id);
        if(memberService.update(memberDO)>0){
            return R.ok();
        }
        return R.error();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:highmember:remove")
//    public R remove(Long id){
//        if(memberService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping(value="/updateEnable")
    public R updateEnable(Long id,Long enable) {
        MemberDO memberDO = new MemberDO();
        memberDO.setId(id);
        memberDO.setStatus(enable);
        memberService.updateStatus(memberDO);
        return R.ok();
    }

}
