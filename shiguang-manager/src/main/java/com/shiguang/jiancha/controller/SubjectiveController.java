package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.SubjectiveDO;
import com.shiguang.jiancha.service.SubjectiveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 主观验光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-03 17:10:26
 */

@Controller
@RequestMapping("/jiancha/subjective")
public class SubjectiveController {
    @Autowired
    private SubjectiveService subjectiveService;

    @GetMapping()
    @RequiresPermissions("jiancha:subjective:subjective")
    String Subjective() {
        return "jiancha/subjective/subjective";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:subjective:subjective")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SubjectiveDO> subjectiveList = subjectiveService.list(query);
        int total = subjectiveService.count(query);
        PageUtils pageUtils = new PageUtils(subjectiveList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:subjective:add")
    String add() {
        return "jiancha/subjective/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("jiancha:subjective:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        SubjectiveDO subjective = subjectiveService.get(id);
        model.addAttribute("subjective", subjective);
        return "jiancha/subjective/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:subjective:add")
    public R save(SubjectiveDO subjective) {
        if (subjectiveService.save(subjective) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:subjective:edit")
    public R update(SubjectiveDO subjective) {
        subjectiveService.update(subjective);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:subjective:remove")
    public R remove(Long id) {
        if (subjectiveService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:subjective:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        subjectiveService.batchRemove(ids);
        return R.ok();
    }

}
