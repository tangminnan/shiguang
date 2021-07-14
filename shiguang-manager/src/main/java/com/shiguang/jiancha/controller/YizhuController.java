package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.YizhuDO;
import com.shiguang.jiancha.service.YizhuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 18:47:47
 */

@Controller
@RequestMapping("/jiancha/yizhu")
public class YizhuController {
    @Autowired
    private YizhuService yizhuService;

    @GetMapping()
    @RequiresPermissions("jiancha:yizhu:yizhu")
    String Yizhu() {
        return "jiancha/yizhu/yizhu";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:yizhu:yizhu")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<YizhuDO> yizhuList = yizhuService.findYizhu(query);
        int total = yizhuService.countYizhu(query);
        PageUtils pageUtils = new PageUtils(yizhuList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:yizhu:add")
    String add() {
        return "jiancha/yizhu/add";
    }

    @GetMapping("/edit/{yizhuId}")
    @RequiresPermissions("jiancha:yizhu:edit")
    String edit(@PathVariable("yizhuId") Long yizhuId, Model model) {
        YizhuDO yizhu = yizhuService.get(yizhuId);
        model.addAttribute("yizhu", yizhu);
        return "jiancha/yizhu/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:yizhu:add")
    public R save(YizhuDO yizhu) {
        if (yizhuService.save(yizhu) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:yizhu:edit")
    public R update(YizhuDO yizhu) {
        yizhuService.update(yizhu);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:yizhu:remove")
    public R remove(Long yizhuId) {
        if (yizhuService.remove(yizhuId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:yizhu:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] yizhuIds) {
        yizhuService.batchRemove(yizhuIds);
        return R.ok();
    }

}
