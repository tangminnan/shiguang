package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.SpanDO;
import com.shiguang.product.service.SpanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 跨度表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 10:48:53
 */

@Controller
@RequestMapping("/product/span")
public class SpanController {
    @Autowired
    private SpanService spanService;

    @GetMapping()
    @RequiresPermissions("product:span:span")
    String Span() {
        return "product/span/span";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:span:span")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SpanDO> spanList = spanService.list(query);
        int total = spanService.count(query);
        PageUtils pageUtils = new PageUtils(spanList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:span:add")
    String add() {
        return "product/span/add";
    }

    @GetMapping("/edit/{spanId}")
    @RequiresPermissions("product:span:edit")
    String edit(@PathVariable("spanId") Long spanId, Model model) {
        SpanDO span = spanService.get(spanId);
        model.addAttribute("span", span);
        return "product/span/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:span:add")
    public R save(SpanDO span) {
        if (spanService.save(span) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:span:edit")
    public R update(SpanDO span) {
        spanService.update(span);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:span:remove")
    public R remove(Long spanId) {
        if (spanService.remove(spanId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:span:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] spanIds) {
        spanService.batchRemove(spanIds);
        return R.ok();
    }

}
