package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.ReadDO;
import com.shiguang.baseinfomation.service.ReadService;
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

/**
 * 读卡器维护
 */
@Controller
@RequestMapping("/information/read")
public class ReadController {
    @Autowired
    private ReadService readService;

    @GetMapping()
    @RequiresPermissions("information:read:read")
    String Read(){
        return "baseinfomation/read/read";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:read:read")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ReadDO> readList = readService.list(query);
        int total = readService.count(query);
        PageUtils pageUtils = new PageUtils(readList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:read:add")
    String add(){
        return "baseinfomation/read/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:read:edit")
    String edit(@PathVariable("id") Long id,Model model){
        ReadDO read = readService.get(id);
        model.addAttribute("read", read);
        return "baseinfomation/read/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:read:add")
    public R save( ReadDO read){
        if(readService.save(read)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:read:edit")
    public R update( ReadDO read){
        readService.update(read);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:read:remove")
    public R remove(Long id){
        if(readService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:read:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        readService.batchRemove(ids);
        return R.ok();
    }
}
