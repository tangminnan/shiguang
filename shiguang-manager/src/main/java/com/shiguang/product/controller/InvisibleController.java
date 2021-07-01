package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.InvisibleDO;
import com.shiguang.product.service.InvisibleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 隐形类别表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */

@Controller
@RequestMapping("/product/invisible")
public class InvisibleController {
    @Autowired
    private InvisibleService invisibleService;

    @GetMapping()
    @RequiresPermissions("product:invisible:invisible")
    String Invisible() {
        return "product/invisible/invisible";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:invisible:invisible")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<InvisibleDO> invisibleList = invisibleService.list(query);
        int total = invisibleService.count(query);
        PageUtils pageUtils = new PageUtils(invisibleList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:invisible:add")
    String add() {
        return "product/invisible/add";
    }

    @GetMapping("/edit/{invisibleId}")
    @RequiresPermissions("product:invisible:edit")
    String edit(@PathVariable("invisibleId") Long invisibleId, Model model) {
        InvisibleDO invisible = invisibleService.get(invisibleId);
        model.addAttribute("invisible", invisible);
        return "product/invisible/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:invisible:add")
    public R save(InvisibleDO invisible) {
        if (invisibleService.save(invisible) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:invisible:edit")
    public R update(InvisibleDO invisible) {
        invisibleService.update(invisible);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:invisible:remove")
    public R remove(Long invisibleId) {
        if (invisibleService.remove(invisibleId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:invisible:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] invisibleIds) {
        invisibleService.batchRemove(invisibleIds);
        return R.ok();
    }

}
