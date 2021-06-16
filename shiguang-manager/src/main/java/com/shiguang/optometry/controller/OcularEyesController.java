package com.shiguang.optometry.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OcularEyesDO;
import com.shiguang.optometry.service.OcularEyesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

@Controller("OcularEyesController")
@RequestMapping("/information/ocular")
public class OcularEyesController {
    @Autowired
    private OcularEyesService eyesService;
    @Autowired
    private MemberService memberService;

    @GetMapping()
    @RequiresPermissions("information:ocular:ocular")
    String Eyes(){
        return "ocular/ocular";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:ocular:ocular")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
//        List<OcularEyesDO> eyesList = eyesService.list(query);
//        int total = eyesService.count(query);
//        PageUtils pageUtils = new PageUtils(eyesList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:ocular:add")
    String add(){
        return "ocular/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:ocular:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,Model model){
//        OcularEyesDO eyes = eyesService.get(id);
//        model.addAttribute("eyes", eyes);
        return "ocular/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:eyes:add")
    public R save( OcularEyesDO eyes){
        if(eyesService.save(eyes)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:eyes:edit")
    public R update( OcularEyesDO eyes){
        eyesService.update(eyes);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:eyes:remove")
    public R remove(Long id){
        if(eyesService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:eyes:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        eyesService.batchRemove(ids);
        return R.ok();
    }
}
