package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.service.ShiguangService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */

@Controller
@RequestMapping("/product/shiguang")
public class ShiguangController {
    @Autowired
    private ShiguangService shiguangService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;


    @GetMapping()
    @RequiresPermissions("product:shiguang:shiguang")
    String Shiguang() {
        return "product/shiguang/shiguang";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:shiguang:shiguang")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShiguangDO> shiguangList = shiguangService.list(query);
        int total = shiguangService.count(query);
        PageUtils pageUtils = new PageUtils(shiguangList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:shiguang:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = shiguangService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:shiguang:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ShiguangDO shiguang = shiguangService.get(id);
        model.addAttribute("shiguang", shiguang);
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = shiguangService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("product:shiguang:detail")
    String detail(@PathVariable("id") Long id, Model model) {
        ShiguangDO shiguang = shiguangService.get(id);
        model.addAttribute("shiguang", shiguang);
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = shiguangService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:shiguang:add")
    public R save(ShiguangDO shiguang) {
        if (shiguangService.save(shiguang) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:shiguang:edit")
    public R update(ShiguangDO shiguang) {
        shiguangService.update(shiguang);
        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @PostMapping("/remove")
//    @ResponseBody
//    @RequiresPermissions("product:shiguang:remove")
//    public R remove(Long id) {
//        if (shiguangService.remove(id) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:shiguang:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shiguangService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = shiguangService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:shiguang:findmfrs")
    String findmfrs() {
        return "/mfrs/mfrs/findShiguangMfrs";
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        ShiguangDO shiguangDO = new ShiguangDO();
        shiguangDO.setId(id);
        shiguangDO.setStatus(enable);
        shiguangService.update(shiguangDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Long id) {
        ShiguangDO shiguangDO = new ShiguangDO();
        shiguangDO.setState(0L);
        shiguangDO.setId(id);
        if (shiguangService.updateState(shiguangDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
