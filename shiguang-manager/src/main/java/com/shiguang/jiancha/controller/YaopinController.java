package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.YaopinDO;
import com.shiguang.jiancha.service.YaopinService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * jc药品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */

@Controller
@RequestMapping("/jiancha/yaopin")
public class YaopinController {
    @Autowired
    private YaopinService yaopinService;

    @GetMapping()
    @RequiresPermissions("jiancha:yaopin:yaopin")
    String Yaopin() {
        return "jiancha/yaopin/yaopin";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:yaopin:yaopin")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<YaopinDO> yaopinList = yaopinService.list(query);
        int total = yaopinService.count(query);
        PageUtils pageUtils = new PageUtils(yaopinList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:yaopin:add")
    String add() {
        return "jiancha/yaopin/add";
    }

    @GetMapping("/edit/{ypId}")
    @RequiresPermissions("jiancha:yaopin:edit")
    String edit(@PathVariable("ypId") Long ypId, Model model) {
        YaopinDO yaopin = yaopinService.get(ypId);
        model.addAttribute("yaopin", yaopin);
        return "jiancha/yaopin/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:yaopin:add")
    public R save(YaopinDO yaopin) {
        if (yaopinService.save(yaopin) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:yaopin:edit")
    public R update(ResultDO result) {
        yaopinService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:yaopin:remove")
    public R remove(Long ypId) {
        if (yaopinService.remove(ypId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:yaopin:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ypIds) {
        yaopinService.batchRemove(ypIds);
        return R.ok();
    }

}
