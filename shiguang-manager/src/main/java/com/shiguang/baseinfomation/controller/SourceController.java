package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.SourceDO;
import com.shiguang.baseinfomation.service.SourceService;
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

@Controller("SourceController")
@RequestMapping("/information/source")
public class SourceController {
    @Autowired
    private SourceService sourceService;

    @GetMapping()
    @RequiresPermissions("information:source:source")
    String Source(){
        return "baseinfomation/source/source";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:source:source")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<SourceDO> sourceList = sourceService.list(query);
        int total = sourceService.count(query);
        PageUtils pageUtils = new PageUtils(sourceList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:source:add")
    String add(){
        return "baseinfomation/source/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:source:edit")
    String edit(@PathVariable("id") Long id,Model model){
        SourceDO source = sourceService.get(id);
        model.addAttribute("source", source);
        return "baseinfomation/source/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:source:add")
    public R save( SourceDO source){
        if(sourceService.save(source)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:source:edit")
    public R update( SourceDO source){
        sourceService.update(source);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:source:remove")
    public R remove(Long id){
        if(sourceService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:source:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        sourceService.batchRemove(ids);
        return R.ok();
    }
}
