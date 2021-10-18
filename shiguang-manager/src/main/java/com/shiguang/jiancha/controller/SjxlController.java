package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SjxlDO;
import com.shiguang.jiancha.service.SjxlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 视觉训练表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 14:02:19
 */

@Controller
@RequestMapping("/jiancha/sjxl")
public class SjxlController {
    @Autowired
    private SjxlService sjxlService;

    @GetMapping()
    @RequiresPermissions("jiancha:sjxl:sjxl")
    String Sjxl() {
        return "jiancha/sjxl/sjxl";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:sjxl:sjxl")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SjxlDO> sjxlList = sjxlService.list(query);
        int total = sjxlService.count(query);
        PageUtils pageUtils = new PageUtils(sjxlList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:sjxl:add")
    String add() {
        return "jiancha/sjxl/add";
    }

    @GetMapping("/edit/{sjxlId}")
    @RequiresPermissions("jiancha:sjxl:edit")
    String edit(@PathVariable("sjxlId") Long sjxlId, Model model) {
        SjxlDO sjxl = sjxlService.get(sjxlId);
        model.addAttribute("sjxl", sjxl);
        return "jiancha/sjxl/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:sjxl:add")
    public R save(SjxlDO sjxl) {
        if (sjxlService.save(sjxl) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:sjxl:edit")
    public R update(ResultDO result) {
        sjxlService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:sjxl:remove")
    public R remove(Long sjxlId) {
        if (sjxlService.remove(sjxlId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:sjxl:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] sjxlIds) {
        sjxlService.batchRemove(sjxlIds);
        return R.ok();
    }

}
