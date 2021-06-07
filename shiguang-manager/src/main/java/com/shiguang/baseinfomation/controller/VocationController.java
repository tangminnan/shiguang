package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.VocationDO;
import com.shiguang.baseinfomation.service.VocationService;
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

@Controller
@RequestMapping("/information/vocation")
public class VocationController {
    @Autowired
    private VocationService vocationService;

    @GetMapping()
    @RequiresPermissions("information:vocation:vocation")
    private String Vocation(){
        return "baseinfomation/vocation/vocation";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:vocation:vocation")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<VocationDO> vocationList = vocationService.list(query);
        int total = vocationService.count(query);
        PageUtils pageUtils = new PageUtils(vocationList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:vocation:add")
    String add(){
        return "baseinfomation/vocation/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:vocation:edit")
    String edit(@PathVariable("id") Long id, Model model){
        VocationDO vocation = vocationService.get(id);
        model.addAttribute("vocation", vocation);
        return "baseinfomation/vocation/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:vocation:add")
    public R save(VocationDO vocation){
        if(vocationService.save(vocation)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:vocation:edit")
    public R update( VocationDO vocation){
        vocationService.update(vocation);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:vocation:remove")
    public R remove( Long id){
        if(vocationService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:vocation:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        vocationService.batchRemove(ids);
        return R.ok();
    }
}
