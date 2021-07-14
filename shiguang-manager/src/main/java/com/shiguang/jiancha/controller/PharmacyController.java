package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.PharmacyDO;
import com.shiguang.jiancha.service.PharmacyService;
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
 * @date 2021-07-13 09:51:54
 */

@Controller
@RequestMapping("/jiancha/pharmacy")
public class PharmacyController {
    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping()
    @RequiresPermissions("jiancha:pharmacy:pharmacy")
    String Pharmacy() {
        return "jiancha/pharmacy/pharmacy";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:pharmacy:pharmacy")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PharmacyDO> pharmacyList = pharmacyService.list(query);
        int total = pharmacyService.count(query);
        PageUtils pageUtils = new PageUtils(pharmacyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:pharmacy:add")
    String add() {
        return "jiancha/pharmacy/add";
    }

    @GetMapping("/edit/{pharmacyId}")
    @RequiresPermissions("jiancha:pharmacy:edit")
    String edit(@PathVariable("pharmacyId") Long pharmacyId, Model model) {
        PharmacyDO pharmacy = pharmacyService.get(pharmacyId);
        model.addAttribute("pharmacy", pharmacy);
        return "jiancha/pharmacy/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:pharmacy:add")
    public R save(PharmacyDO pharmacy) {
        if (pharmacyService.save(pharmacy) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:pharmacy:edit")
    public R update(PharmacyDO pharmacy) {
        pharmacyService.update(pharmacy);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:pharmacy:remove")
    public R remove(Long pharmacyId) {
        if (pharmacyService.remove(pharmacyId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:pharmacy:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] pharmacyIds) {
        pharmacyService.batchRemove(pharmacyIds);
        return R.ok();
    }

}
