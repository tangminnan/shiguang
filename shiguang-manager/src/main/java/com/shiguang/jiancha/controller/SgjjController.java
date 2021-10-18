package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SgjjDO;
import com.shiguang.jiancha.service.SgjjService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 框架双光/渐进表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 10:03:39
 */

@Controller
@RequestMapping("/jiancha/sgjj")
public class SgjjController {
    @Autowired
    private SgjjService sgjjService;

    @GetMapping()
    @RequiresPermissions("jiancha:sgjj:sgjj")
    String Sgjj() {
        return "jiancha/sgjj/sgjj";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:sgjj:sgjj")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SgjjDO> sgjjList = sgjjService.list(query);
        int total = sgjjService.count(query);
        PageUtils pageUtils = new PageUtils(sgjjList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:sgjj:add")
    String add() {
        return "jiancha/sgjj/add";
    }

    @GetMapping("/edit/{sgjjId}")
    @RequiresPermissions("jiancha:sgjj:edit")
    String edit(@PathVariable("sgjjId") Long sgjjId, Model model) {
        SgjjDO sgjj = sgjjService.get(sgjjId);
        model.addAttribute("sgjj", sgjj);
        return "jiancha/sgjj/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:sgjj:add")
    public R save(SgjjDO sgjj) {
        if (sgjjService.save(sgjj) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:sgjj:edit")
    public R update(ResultDO result) {
        sgjjService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:sgjj:remove")
    public R remove(Long sgjjId) {
        if (sgjjService.remove(sgjjId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:sgjj:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] sgjjIds) {
        sgjjService.batchRemove(sgjjIds);
        return R.ok();
    }

}
