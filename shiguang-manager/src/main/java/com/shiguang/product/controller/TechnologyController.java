package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.TechnologyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 工艺类型表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-10 14:23:53
 */

@Controller
@RequestMapping("/product/technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @GetMapping()
    @RequiresPermissions("product:technology:technology")
    String Technology() {
        return "product/technology/technology";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:technology:technology")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TechnologyDO> technologyList = technologyService.list(query);
        int total = technologyService.count(query);
        PageUtils pageUtils = new PageUtils(technologyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:technology:add")
    String add() {
        return "product/technology/add";
    }

    @GetMapping("/edit/{technologyId}")
    @RequiresPermissions("product:technology:edit")
    String edit(@PathVariable("technologyId") Long technologyId, Model model) {
        TechnologyDO technology = technologyService.get(technologyId);
        model.addAttribute("technology", technology);
        return "product/technology/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:technology:add")
    public R save(TechnologyDO technology) {
        if (technologyService.save(technology) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:technology:edit")
    public R update(TechnologyDO technology) {
        technologyService.update(technology);
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:technology:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] technologyIds) {
        technologyService.batchRemove(technologyIds);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("product:technology:remove")
    public R updateStatus(Long technologyId) {
        TechnologyDO technologyDO = new TechnologyDO();
        technologyDO.setState(0L);
        technologyDO.setTechnologyId(technologyId);
        if (technologyService.updateState(technologyDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

}
