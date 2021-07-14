package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.KjyyDO;
import com.shiguang.jiancha.service.KjyyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 框架远用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 17:28:13
 */

@Controller
@RequestMapping("/jiancha/kjyy")
public class KjyyController {
    @Autowired
    private KjyyService kjyyService;

    @GetMapping()
    @RequiresPermissions("jiancha:kjyy:kjyy")
    String Kjyy() {
        return "jiancha/kjyy/kjyy";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:kjyy:kjyy")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<KjyyDO> kjyyList = kjyyService.list(query);
        int total = kjyyService.count(query);
        PageUtils pageUtils = new PageUtils(kjyyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:kjyy:add")
    String add() {
        return "jiancha/kjyy/add";
    }

    @GetMapping("/edit/{kjyyId}")
    @RequiresPermissions("jiancha:kjyy:edit")
    String edit(@PathVariable("kjyyId") Long kjyyId, Model model) {
        KjyyDO kjyy = kjyyService.get(kjyyId);
        model.addAttribute("kjyy", kjyy);
        return "jiancha/kjyy/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:kjyy:add")
    public R save(KjyyDO kjyy) {
        if (kjyyService.save(kjyy) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:kjyy:edit")
    public R update(KjyyDO kjyy) {
        kjyyService.update(kjyy);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:kjyy:remove")
    public R remove(Long kjyyId) {
        if (kjyyService.remove(kjyyId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:kjyy:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] kjyyIds) {
        kjyyService.batchRemove(kjyyIds);
        return R.ok();
    }

}
