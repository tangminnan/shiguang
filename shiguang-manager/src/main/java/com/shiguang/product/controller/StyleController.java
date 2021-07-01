package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.service.StyleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 款式表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */

@Controller
@RequestMapping("/product/style")
public class StyleController {
    @Autowired
    private StyleService styleService;

    @GetMapping()
    @RequiresPermissions("product:style:style")
    String Style() {
        return "product/style/style";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:style:style")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<StyleDO> styleList = styleService.list(query);
        int total = styleService.count(query);
        PageUtils pageUtils = new PageUtils(styleList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:style:add")
    String add() {
        return "product/style/add";
    }

    @GetMapping("/edit/{styleId}")
    @RequiresPermissions("product:style:edit")
    String edit(@PathVariable("styleId") Long styleId, Model model) {
        StyleDO style = styleService.get(styleId);
        model.addAttribute("style", style);
        return "product/style/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:style:add")
    public R save(StyleDO style) {
        if (styleService.save(style) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:style:edit")
    public R update(StyleDO style) {
        styleService.update(style);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:style:remove")
    public R remove(Long styleId) {
        if (styleService.remove(styleId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:style:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] styleIds) {
        styleService.batchRemove(styleIds);
        return R.ok();
    }

}
