package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.LightbelowDO;
import com.shiguang.product.service.LightbelowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 下加光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */

@Controller
@RequestMapping("/product/lightbelow")
public class LightbelowController {
    @Autowired
    private LightbelowService lightbelowService;

    @GetMapping()
    @RequiresPermissions("product:lightbelow:lightbelow")
    String Lightbelow() {
        return "product/lightbelow/lightbelow";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:lightbelow:lightbelow")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<LightbelowDO> lightbelowList = lightbelowService.list(query);
        int total = lightbelowService.count(query);
        PageUtils pageUtils = new PageUtils(lightbelowList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:lightbelow:add")
    String add() {
        return "product/lightbelow/add";
    }

    @GetMapping("/edit/{lightbelowId}")
    @RequiresPermissions("product:lightbelow:edit")
    String edit(@PathVariable("lightbelowId") Long lightbelowId, Model model) {
        LightbelowDO lightbelow = lightbelowService.get(lightbelowId);
        model.addAttribute("lightbelow", lightbelow);
        return "product/lightbelow/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:lightbelow:add")
    public R save(LightbelowDO lightbelow) {
        if (lightbelowService.save(lightbelow) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:lightbelow:edit")
    public R update(LightbelowDO lightbelow) {
        lightbelowService.update(lightbelow);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:lightbelow:remove")
    public R remove(Long lightbelowId) {
        if (lightbelowService.remove(lightbelowId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:lightbelow:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] lightbelowIds) {
        lightbelowService.batchRemove(lightbelowIds);
        return R.ok();
    }

}
