package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.CrtDO;
import com.shiguang.jiancha.service.CrtService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜CRT
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:00:46
 */

@Controller
@RequestMapping("/jiancha/crt")
public class CrtController {
    @Autowired
    private CrtService crtService;

    @GetMapping()
    @RequiresPermissions("jiancha:crt:crt")
    String Crt() {
        return "jiancha/crt/crt";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:crt:crt")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<CrtDO> crtList = crtService.list(query);
        int total = crtService.count(query);
        PageUtils pageUtils = new PageUtils(crtList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:crt:add")
    String add() {
        return "jiancha/crt/add";
    }

    @GetMapping("/edit/{crtId}")
    @RequiresPermissions("jiancha:crt:edit")
    String edit(@PathVariable("crtId") Long crtId, Model model) {
        CrtDO crt = crtService.get(crtId);
        model.addAttribute("crt", crt);
        return "jiancha/crt/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:crt:add")
    public R save(CrtDO crt) {
        if (crtService.save(crt) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:crt:edit")
    public R update(CrtDO crt) {
        crtService.update(crt);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:crt:remove")
    public R remove(Long crtId) {
        if (crtService.remove(crtId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:crt:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] crtIds) {
        crtService.batchRemove(crtIds);
        return R.ok();
    }

}
