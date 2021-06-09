package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.InterestDO;
import com.shiguang.baseinfomation.service.InterestService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("InterestController")
@RequestMapping("/information/interest")
public class InterestController {
    @Autowired
    private InterestService interestService;

    @GetMapping()
    @RequiresPermissions("information:interest:interest")
    String Interest(){
        return "baseinfomation/interest/interest";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:interest:interest")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<InterestDO> interestList = interestService.list(query);
        int total = interestService.count(query);
        PageUtils pageUtils = new PageUtils(interestList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:interest:add")
    String add(){
        return "baseinfomation/interest/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:interest:edit")
    String edit(@PathVariable("id") Long id,Model model){
        InterestDO interest = interestService.get(id);
        model.addAttribute("interest", interest);
        return "baseinfomation/interest/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:interest:add")
    public R save( InterestDO interest){
        if(interestService.save(interest)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:interest:edit")
    public R update( InterestDO interest){
        interestService.update(interest);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:interest:remove")
    public R remove(Long id){
        if(interestService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:interest:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        interestService.batchRemove(ids);
        return R.ok();
    }
}
