package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.SphDO;
import com.shiguang.product.service.SphService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 球镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */

@Controller
@RequestMapping("/product/sph")
public class SphController {
    @Autowired
    private SphService sphService;

    @GetMapping()
    @RequiresPermissions("product:sph:sph")
    String Sph() {
        return "product/sph/sph";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:sph:sph")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SphDO> sphList = sphService.list(query);
        int total = sphService.count(query);
        PageUtils pageUtils = new PageUtils(sphList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:sph:add")
    String add() {
        return "product/sph/add";
    }

    @GetMapping("/edit/{sphId}")
    @RequiresPermissions("product:sph:edit")
    String edit(@PathVariable("sphId") Long sphId, Model model) {
        SphDO sph = sphService.get(sphId);
        model.addAttribute("sph", sph);
        return "product/sph/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:sph:add")
    public R save(SphDO sph) {
        if (sphService.save(sph) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:sph:edit")
    public R update(SphDO sph) {
        sphService.update(sph);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:sph:remove")
    public R remove(Long sphId) {
        if (sphService.remove(sphId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:sph:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] sphIds) {
        sphService.batchRemove(sphIds);
        return R.ok();
    }

}
