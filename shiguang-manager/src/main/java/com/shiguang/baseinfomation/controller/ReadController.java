package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.PersonSortDO;
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

import java.util.HashMap;
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
        query.put("status",1);
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
        String cardId = read.getCardId();
        Map<String, Object> map = new HashMap<>();
        map.put("cardId",cardId);
        List<ReadDO> list = readService.list(map);
        if (list.size() > 0){
            return R.error("读卡方式id已存在");
        }
        read.setStatus(1L);
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
    public R updateStatus(Long id){
        ReadDO readDO = new ReadDO();
        readDO.setStatus(0L);
        readDO.setId(id);
        if(readService.updateStatus(readDO)>0){
            return R.ok();
        }
        return R.error();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:read:remove")
//    public R remove(Long id){
//        if(readService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

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
