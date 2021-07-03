package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.OlddegreesDO;
import com.shiguang.product.service.OlddegreesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 老花镜度数表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 16:19:35
 */

@Controller
@RequestMapping("/product/olddegrees")
public class OlddegreesController {
    @Autowired
    private OlddegreesService olddegreesService;

    @GetMapping()
    @RequiresPermissions("product:olddegrees:olddegrees")
    String Olddegrees() {
        return "product/olddegrees/olddegrees";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:olddegrees:olddegrees")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OlddegreesDO> olddegreesList = olddegreesService.list(query);
        int total = olddegreesService.count(query);
        PageUtils pageUtils = new PageUtils(olddegreesList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:olddegrees:add")
    String add() {
        return "product/olddegrees/add";
    }

    @GetMapping("/edit/{oldId}")
    @RequiresPermissions("product:olddegrees:edit")
    String edit(@PathVariable("oldId") Long oldId, Model model) {
        OlddegreesDO olddegrees = olddegreesService.get(oldId);
        model.addAttribute("olddegrees", olddegrees);
        return "product/olddegrees/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:olddegrees:add")
    public R save(OlddegreesDO olddegrees) {
        if (olddegreesService.save(olddegrees) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:olddegrees:edit")
    public R update(OlddegreesDO olddegrees) {
        olddegreesService.update(olddegrees);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:olddegrees:remove")
    public R remove(Long oldId) {
        if (olddegreesService.remove(oldId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:olddegrees:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] oldIds) {
        olddegreesService.batchRemove(oldIds);
        return R.ok();
    }

}
