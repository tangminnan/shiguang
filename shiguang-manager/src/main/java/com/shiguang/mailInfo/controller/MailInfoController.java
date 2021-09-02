package com.shiguang.mailInfo.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/mailinfo")
public class MailInfoController {
    @Autowired
    private MailInfoService infoService;
    @Autowired
    private SalesService salesService;

    @GetMapping()
    @RequiresPermissions("information:mailinfo:mailinfo")
    String Info(){
        return "mailinfo/mailinfo";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:mailinfo:mailinfo")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<MailInfoDO> infoList = infoService.list(query);
        int total = infoService.count(query);
        PageUtils pageUtils = new PageUtils(infoList, total);
        return pageUtils;
    }

    @GetMapping("/peijingInfo")
    @RequiresPermissions("information:mailinfo:peijingInfo")
    String peijingInfo(){
        return "mailinfo/peijingInfo";
    }

    @ResponseBody
    @GetMapping("/peijinglist")
    @RequiresPermissions("information:mailinfo:peijingInfo")
    public PageUtils peijinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatus","顾客取镜");
        List<SalesDO> infoList = salesService.peijinglist(query);
        int total = salesService.peijingcount(query);
        PageUtils pageUtils = new PageUtils(infoList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:mailinfo:add")
    String add(){
        return "mailinfo/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:mailinfo:edit")
    String edit(@PathVariable("id") Long id,Model model){
        MailInfoDO info = infoService.get(id);
        model.addAttribute("info", info);
        return "mailinfo/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:mailinfo:add")
    public R save( MailInfoDO info){
        info.setEnterName(ShiroUtils.getUser().getName());
        info.setEnterTimr(new Date());
        info.setStatus(0L);
        if(infoService.save(info)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:mailinfo:edit")
    public R update( MailInfoDO info){
        infoService.update(info);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:mailinfo:remove")
    public R remove(Long id){
        if(infoService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:mailinfo:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        infoService.batchRemove(ids);
        return R.ok();
    }
}
