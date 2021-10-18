package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.RgpDO;
import com.shiguang.jiancha.service.RgpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * RGP表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */

@Controller
@RequestMapping("/jiancha/rgp")
public class RgpController {
    @Autowired
    private RgpService rgpService;

    @GetMapping()
    @RequiresPermissions("jiancha:rgp:rgp")
    String Rgp() {
        return "jiancha/rgp/rgp";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:rgp:rgp")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RgpDO> rgpList = rgpService.list(query);
        int total = rgpService.count(query);
        PageUtils pageUtils = new PageUtils(rgpList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:rgp:add")
    String add() {
        return "jiancha/rgp/add";
    }

    @GetMapping("/edit/{rgpId}")
    @RequiresPermissions("jiancha:rgp:edit")
    String edit(@PathVariable("rgpId") Long rgpId, Model model) {
        RgpDO rgp = rgpService.get(rgpId);
        model.addAttribute("rgp", rgp);
        return "jiancha/rgp/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:rgp:add")
    public R save(RgpDO rgp) {
        if (rgpService.save(rgp) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:rgp:edit")
    public R update(ResultDO result) {
        rgpService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:rgp:remove")
    public R remove(Long rgpId) {
        if (rgpService.remove(rgpId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:rgp:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] rgpIds) {
        rgpService.batchRemove(rgpIds);
        return R.ok();
    }

}
