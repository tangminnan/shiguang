package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.RxjmjcjDO;
import com.shiguang.jiancha.service.RxjmjcjService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 框架近用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 11:18:47
 */

@Controller
@RequestMapping("/jiancha/rxjmjcj")
public class RxjmjcjController {
    @Autowired
    private RxjmjcjService rxjmjcjService;

    @GetMapping()
    @RequiresPermissions("jiancha:rxjmjcj:rxjmjcj")
    String Rxjmjcj() {
        return "jiancha/rxjmjcj/rxjmjcj";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:rxjmjcj:rxjmjcj")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RxjmjcjDO> rxjmjcjList = rxjmjcjService.list(query);
        int total = rxjmjcjService.count(query);
        PageUtils pageUtils = new PageUtils(rxjmjcjList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:rxjmjcj:add")
    String add() {
        return "jiancha/rxjmjcj/add";
    }

    @GetMapping("/edit/{rxId}")
    @RequiresPermissions("jiancha:rxjmjcj:edit")
    String edit(@PathVariable("rxId") Long rxId, Model model) {
        RxjmjcjDO rxjmjcj = rxjmjcjService.get(rxId);
        model.addAttribute("rxjmjcj", rxjmjcj);
        return "jiancha/rxjmjcj/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:rxjmjcj:add")
    public R save(RxjmjcjDO rxjmjcj) {
        if (rxjmjcjService.save(rxjmjcj) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:rxjmjcj:edit")
    public R update(RxjmjcjDO rxjmjcj) {
        rxjmjcjService.update(rxjmjcj);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:rxjmjcj:remove")
    public R remove(Long rxId) {
        if (rxjmjcjService.remove(rxId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:rxjmjcj:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] rxIds) {
        rxjmjcjService.batchRemove(rxIds);
        return R.ok();
    }

}
