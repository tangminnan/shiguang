package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.KjjyDO;
import com.shiguang.jiancha.service.KjjyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 框架近用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 17:28:13
 */

@Controller
@RequestMapping("/jiancha/kjjy")
public class KjjyController {
    @Autowired
    private KjjyService kjjyService;

    @GetMapping()
    @RequiresPermissions("jiancha:kjjy:kjjy")
    String Kjjy() {
        return "jiancha/kjjy/kjjy";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:kjjy:kjjy")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<KjjyDO> kjjyList = kjjyService.list(query);
        int total = kjjyService.count(query);
        PageUtils pageUtils = new PageUtils(kjjyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:kjjy:add")
    String add() {
        return "jiancha/kjjy/add";
    }

    @GetMapping("/edit/{kjjyId}")
    @RequiresPermissions("jiancha:kjjy:edit")
    String edit(@PathVariable("kjjyId") Long kjjyId, Model model) {
        KjjyDO kjjy = kjjyService.get(kjjyId);
        model.addAttribute("kjjy", kjjy);
        return "jiancha/kjjy/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:kjjy:add")
    public R save(KjjyDO kjjy) {
        if (kjjyService.save(kjjy) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:kjjy:edit")
    public R update(KjjyDO kjjy) {
        kjjyService.update(kjjy);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:kjjy:remove")
    public R remove(Long kjjyId) {
        if (kjjyService.remove(kjjyId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:kjjy:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] kjjyIds) {
        kjjyService.batchRemove(kjjyIds);
        return R.ok();
    }

}
