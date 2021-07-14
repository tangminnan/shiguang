package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ShiliDO;
import com.shiguang.jiancha.service.ShiliService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 10:22:52
 */

@Controller
@RequestMapping("/jiancha/shili")
public class ShiliController {
    @Autowired
    private ShiliService shiliService;

    @GetMapping()
    @RequiresPermissions("jiancha:shili:shili")
    String Shili() {
        return "jiancha/shili/shili";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:shili:shili")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShiliDO> shiliList = shiliService.list(query);
        int total = shiliService.count(query);
        PageUtils pageUtils = new PageUtils(shiliList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:shili:add")
    String add() {
        return "jiancha/shili/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("jiancha:shili:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ShiliDO shili = shiliService.get(id);
        model.addAttribute("shili", shili);
        return "jiancha/shili/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:shili:add")
    public R save(ShiliDO shili) {
        if (shiliService.save(shili) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:shili:edit")
    public R update(ShiliDO shili) {
        shiliService.update(shili);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:shili:remove")
    public R remove(Long id) {
        if (shiliService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:shili:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shiliService.batchRemove(ids);
        return R.ok();
    }

}
