package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.service.HlyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 隐形护理液表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:08:33
 */

@Controller
@RequestMapping("/product/hly")
public class HlyController {
    @Autowired
    private HlyService hlyService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;

    @GetMapping()
    @RequiresPermissions("product:hly:hly")
    String Hly() {
        return "product/hly/hly";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:hly:hly")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<HlyDO> hlyList = hlyService.list(query);
        int total = hlyService.count(query);
        PageUtils pageUtils = new PageUtils(hlyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:hly:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = hlyService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hly/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:hly:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        HlyDO hly = hlyService.get(id);
        model.addAttribute("hly", hly);
        return "product/hly/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:hly:add")
    public R save(HlyDO hly) {
        if (hlyService.save(hly) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:hly:edit")
    public R update(HlyDO hly) {
        hlyService.update(hly);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:hly:remove")
    public R remove(Long id) {
        if (hlyService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:hly:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        hlyService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = hlyService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

}
