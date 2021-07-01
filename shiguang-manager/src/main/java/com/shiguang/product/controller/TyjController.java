package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.domain.TyjDO;
import com.shiguang.product.service.StyleService;
import com.shiguang.product.service.TyjService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 太阳镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:45:54
 */

@Controller
@RequestMapping("/product/tyj")
public class TyjController {
    @Autowired
    private TyjService tyjService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //款式
    @Autowired
    private StyleService styleService;

    @GetMapping()
    @RequiresPermissions("product:tyj:tyj")
    String Tyj() {
        return "product/tyj/tyj";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:tyj:tyj")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TyjDO> tyjList = tyjService.list(query);
        int total = tyjService.count(query);
        PageUtils pageUtils = new PageUtils(tyjList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:tyj:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = tyjService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        return "product/tyj/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:tyj:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TyjDO tyj = tyjService.get(id);
        model.addAttribute("tyj", tyj);
        return "product/tyj/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:tyj:add")
    public R save(TyjDO tyj) {
        if (tyjService.save(tyj) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:tyj:edit")
    public R update(TyjDO tyj) {
        tyjService.update(tyj);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:tyj:remove")
    public R remove(Long id) {
        if (tyjService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:tyj:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tyjService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = tyjService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

}
