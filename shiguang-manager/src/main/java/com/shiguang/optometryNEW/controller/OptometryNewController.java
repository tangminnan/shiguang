package com.shiguang.optometryNEW.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
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

    @GetMapping()
    @RequiresPermissions("information:optometryNew:optometryNew")
    String Optometry(){
        return "optometryNew/optometryNew";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryNew:optometryNew")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state",1);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:optometryNew:add")
    String add(){
        return "optometryNew/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:optometryNew:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,Model model){
//        OptometryDO optometry = optometryService.get(id);
//        model.addAttribute("optometry", optometry);
        //ResultDiopterDO resultDiopterDO = resultDiopterService.
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0){
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO",memberDO);
        Map<String,Object> map = new HashMap<>();
        List<OptometryDO> list = optometryService.optoList(map);
        OptometryDO optometryDO = new OptometryDO();
        if (list.size() > 0){
            optometryDO.setCylinderRight(list.get(0).getCylinderRight());
            optometryDO.setCylinderLeft(list.get(0).getCylinderLeft());
            optometryDO.setAxialRight(list.get(0).getAxialRight());
            optometryDO.setAxialLeft(list.get(0).getAxialLeft());
            optometryDO.setSphereRight(list.get(0).getSphereRight());
            optometryDO.setSphereLeft(list.get(0).getSphereLeft());

        }
        model.addAttribute("optometryDO",optometryDO);
        //OptometryDO optometryDO = optometryService.
        return "optometryNew/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:optometryNew:add")
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
    @RequiresPermissions("information:optometryNew:edit")
    public R update( OptometryDO optometry){
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:optometryNew:remove")
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
    @RequiresPermissions("information:optometryNew:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
