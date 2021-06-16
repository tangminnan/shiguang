package com.shiguang.optometry.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ResultDiopterDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    @RequiresPermissions("information:optometry:optometry")
    String Optometry(){
        return "optometry/optometry";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometry:optometry")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:optometry:add")
    String add(){
        return "optometry/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:optometry:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,Model model){
//        OptometryDO optometry = optometryService.get(id);
//        model.addAttribute("optometry", optometry);
        //ResultDiopterDO resultDiopterDO = resultDiopterService.
        model.addAttribute("cardNumber",cardNumber);
        return "optometry/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:optometry:add")
    public R save( OptometryDO optometry){
        if(optometryService.save(optometry)>0){
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
    public R update( OptometryDO optometry){
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:optometry:remove")
    public R remove(Long id){
        if(optometryService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:optometry:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        optometryService.batchRemove(ids);
        return R.ok();
    }
}