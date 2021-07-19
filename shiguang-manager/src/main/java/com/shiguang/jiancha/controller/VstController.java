package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.VstDO;
import com.shiguang.jiancha.service.VstService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜VST
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 16:38:36
 */

@Controller
@RequestMapping("/jiancha/vst")
public class VstController {
    @Autowired
    private VstService vstService;

    @GetMapping()
    @RequiresPermissions("jiancha:vst:vst")
    String Vst() {
        return "jiancha/vst/vst";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:vst:vst")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<VstDO> vstList = vstService.list(query);
        int total = vstService.count(query);
        PageUtils pageUtils = new PageUtils(vstList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:vst:add")
    String add() {
        return "jiancha/vst/add";
    }

    @GetMapping("/edit/{vstId}")
    @RequiresPermissions("jiancha:vst:edit")
    String edit(@PathVariable("vstId") Long vstId, Model model) {
        VstDO vst = vstService.get(vstId);
        model.addAttribute("vst", vst);
        return "jiancha/vst/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:vst:add")
    public R save(VstDO vst) {
        if (vstService.save(vst) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:vst:edit")
    public R update(VstDO vst) {
        vstService.update(vst);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:vst:remove")
    public R remove(Long vstId) {
        if (vstService.remove(vstId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:vst:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] vstIds) {
        vstService.batchRemove(vstIds);
        return R.ok();
    }

}
