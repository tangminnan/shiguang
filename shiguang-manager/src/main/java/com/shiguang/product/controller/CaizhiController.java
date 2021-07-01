package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.CaizhiDO;
import com.shiguang.product.service.CaizhiService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 材质表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */

@Controller
@RequestMapping("/product/caizhi")
public class CaizhiController {
    @Autowired
    private CaizhiService caizhiService;

    @GetMapping()
    @RequiresPermissions("product:caizhi:caizhi")
    String Caizhi() {
        return "product/caizhi/caizhi";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:caizhi:caizhi")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<CaizhiDO> caizhiList = caizhiService.list(query);
        int total = caizhiService.count(query);
        PageUtils pageUtils = new PageUtils(caizhiList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:caizhi:add")
    String add() {
        return "product/caizhi/add";
    }

    @GetMapping("/edit/{caizhiId}")
    @RequiresPermissions("product:caizhi:edit")
    String edit(@PathVariable("caizhiId") Long caizhiId, Model model) {
        CaizhiDO caizhi = caizhiService.get(caizhiId);
        model.addAttribute("caizhi", caizhi);
        return "product/caizhi/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:caizhi:add")
    public R save(CaizhiDO caizhi) {
        if (caizhiService.save(caizhi) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:caizhi:edit")
    public R update(CaizhiDO caizhi) {
        caizhiService.update(caizhi);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:caizhi:remove")
    public R remove(Long caizhiId) {
        if (caizhiService.remove(caizhiId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:caizhi:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] caizhiIds) {
        caizhiService.batchRemove(caizhiIds);
        return R.ok();
    }

}
