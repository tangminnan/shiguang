package com.shiguang.member.controller;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.domain.SourceDO;
import com.shiguang.baseinfomation.domain.VocationDO;
import com.shiguang.baseinfomation.service.CardTypeService;
import com.shiguang.baseinfomation.service.PersonSortService;
import com.shiguang.baseinfomation.service.SourceService;
import com.shiguang.baseinfomation.service.VocationService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("MemberController")
@RequestMapping("/information/member")
public class MemberController {
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

    @GetMapping()
    @RequiresPermissions("information:member:member")
    String Member(){
        return "member/member";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:member:member")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<MemberDO> memberList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:member:add")
    String add(Model model){
        Map<String,Object> map = new HashMap<>();
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        return "member/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:member:edit")
    String edit(@PathVariable("id") Long id,Model model){
        MemberDO member = memberService.get(id);
        model.addAttribute("member", member);
        Map<String,Object> map = new HashMap<>();
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        return "member/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:member:add")
    public R save( MemberDO member){
        member.setRegisterTime(new Date());
        member.setProvinceName(member.getProvinceName().substring(0,member.getProvinceName().length() -1));
        member.setCityName(member.getCityName().substring(0,member.getCityName().length()-1));
        member.setAreaName(member.getAreaName().substring(0,member.getAreaName().length()-1));
        if(memberService.save(member)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:member:edit")
    public R update( MemberDO member){
        memberService.update(member);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:member:remove")
    public R remove(Long id){
        if(memberService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量停用或启用
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:member:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids,@RequestParam("status") Long status){
        memberService.batchRemove(ids,status);
        return R.ok();
    }
    /**
     * 修改
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
