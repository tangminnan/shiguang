package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.ZyDO;
import com.shiguang.jiancha.service.ZyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 框架中用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:50:32
 */

@Controller
@RequestMapping("/jiancha/zy")
public class ZyController {
    @Autowired
    private ZyService zyService;

    @GetMapping()
    @RequiresPermissions("jiancha:zy:zy")
    String Zy() {
        return "jiancha/zy/zy";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:zy:zy")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ZyDO> zyList = zyService.list(query);
        int total = zyService.count(query);
        PageUtils pageUtils = new PageUtils(zyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:zy:add")
    String add() {
        return "jiancha/zy/add";
    }

    @GetMapping("/edit/{zyId}")
    @RequiresPermissions("jiancha:zy:edit")
    String edit(@PathVariable("zyId") Long zyId, Model model) {
        ZyDO zy = zyService.get(zyId);
        model.addAttribute("zy", zy);
        return "jiancha/zy/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:zy:add")
    public R save(ZyDO zy) {
        if (zyService.save(zy) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:zy:edit")
    public R update(ResultDO result) {
        zyService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:zy:remove")
    public R remove(Long zyId) {
        if (zyService.remove(zyId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:zy:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] zyIds) {
        zyService.batchRemove(zyIds);
        return R.ok();
    }

}
