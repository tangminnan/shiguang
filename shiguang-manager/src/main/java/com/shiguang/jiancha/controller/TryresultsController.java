package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.service.TryresultsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */

@Controller
@RequestMapping("/jiancha/tryresults")
public class TryresultsController {
    @Autowired
    private TryresultsService tryresultsService;

    @GetMapping()
    @RequiresPermissions("jiancha:tryresults:tryresults")
    String Tryresults() {
        return "jiancha/tryresults/tryresults";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:tryresults:tryresults")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TryresultsDO> tryresultsList = tryresultsService.list(query);
        int total = tryresultsService.count(query);
        PageUtils pageUtils = new PageUtils(tryresultsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:tryresults:add")
    String add() {
        return "jiancha/tryresults/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("jiancha:tryresults:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TryresultsDO tryresults = tryresultsService.get(id);
        model.addAttribute("tryresults", tryresults);
        return "jiancha/tryresults/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:tryresults:add")
    public R save(TryresultsDO tryresults) {
        if (tryresultsService.save(tryresults) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:tryresults:edit")
    public R update(TryresultsDO tryresults) {
        tryresultsService.update(tryresults);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:tryresults:remove")
    public R remove(Long id) {
        if (tryresultsService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:tryresults:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tryresultsService.batchRemove(ids);
        return R.ok();
    }

}
