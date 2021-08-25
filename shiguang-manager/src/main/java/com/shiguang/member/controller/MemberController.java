package com.shiguang.member.controller;

import com.shiguang.baseinfomation.domain.*;
import com.shiguang.baseinfomation.service.*;
import com.shiguang.common.utils.*;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private InterestService interestService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @RequiresPermissions("information:member:member")
    String Member(Model model){
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
        return "member/member";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:member:member")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        } else {
            if (null != ShiroUtils.getUser().getStoreNum()){
                query.put("departNumber",ShiroUtils.getUser().getStoreNum());
            }
        }
        if (null != params.get("ageStart") && !"".equals(params.get("ageStart"))){
            query.put("agestart",Long.parseLong(params.get("ageStart").toString()));
            query.put("departNumber","");
            query.put("companyId","");
        }
        if (null != params.get("ageEnd")&& !"".equals(params.get("ageEnd"))){
            query.put("ageend",Long.parseLong(params.get("ageEnd").toString()));
            query.put("departNumber","");
            query.put("companyId","");
        }
        if (null != params.get("sex") && !"".equals(params.get("sex"))){
            query.put("departNumber","");
            query.put("companyId","");
        }
        if (null != params.get("phone1") && !"".equals(params.get("phone1"))){
            query.put("departNumber","");
            query.put("companyId","");
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("departNumber","");
            query.put("companyId","");
        }
        if (null != params.get("cardNumber") && !"".equals(params.get("cardNumber"))){
            query.put("departNumber","");
            query.put("companyId","");
        }
        List<MemberDO> memberList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:member:add")
    String add(Model model){
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
        return "member/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:member:edit")
    String edit(@PathVariable("id") Long id,Model model)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MemberDO member = memberService.get(id);
        Date date = member.getRegisterTime();
        String strDate = sdf.format(date);
        member.setCreateTime(strDate);
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
        return "member/edit";
    }

    @GetMapping("/information/{checkType}")
    @RequiresPermissions("information:member:member")
    public String importtemplate(Model model, @PathVariable("checkType") String checkType) {
        model.addAttribute("checkType", checkType);
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        map.put("state",1);
        model.addAttribute("departmentDOList",departmentDOList);
        if ("PU_TONG".equals(checkType)) {
            return "member/importtemplate";
        }
        return null;
    }

    /**
     * 导入
     */
    @PostMapping("/importMember")
    @ResponseBody
    @RequiresPermissions("information:member:member")
    public R importMember(String departNumber, String checkType, MultipartFile file) {
        return memberService.importMember(departNumber, checkType, file);

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
        String cardNumber = member.getCardNumber();
        Map<String, Object> map = new HashMap<>();
        if (!"".equals(cardNumber)){
            map.put("cardNumber",cardNumber);
            List<MemberDO> list = memberService.list(map);
            if (list.size() > 0){
                return R.error("会员卡号已存在");
            }
        }
        if (member.getMemberOption() == 1){
            member.setCardNumber("H"+GuuidUtil.getUUID());
        }
        member.setStatus(0L);
        member.setState(1L);
        if (null != ShiroUtils.getUser().getStoreNum()){
            member.setDepartNumber(ShiroUtils.getUser().getStoreNum());
        }
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
        MemberDO memberDO = new MemberDO();
        memberDO.setState(0L);
        memberDO.setId(id);
        if(memberService.update(memberDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 浏览器打印二维码
     */
    @GetMapping("/downLoadErWeiMaByMember")
    public String downLoadErWeiMaByMember(Long id, Model model) {
        MemberDO memberDO = Optional.ofNullable(memberService.get(id)).orElseGet(MemberDO::new);
        model.addAttribute("cardMember",memberDO.getCardNumber());
        model.addAttribute("memberName",memberDO.getName());
        model.addAttribute("age",memberDO.getAge());
        if (memberDO.getSex() == 0){
            memberDO.setSexx("男");
        } else if (memberDO.getSex() == 1){
            memberDO.setSexx("女");
        }
        model.addAttribute("sexx",memberDO.getSexx());
        model.addAttribute("memberTel",memberDO.getPhone1());
        String telNumber = memberDO.getPhone1();
        String code = QRCodeUtil.creatRrCode(memberDO.getCardNumber(), 200,200);
        model.addAttribute("QRCode","data:image/png;base64," + code);
        return "member/二维码";
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:member:remove")
//    public R remove(Long id){
//        if(memberService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

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
