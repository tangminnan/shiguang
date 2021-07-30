package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.service.HcService;
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
 * @date 2021-07-01 17:14:05
 */

@Controller
@RequestMapping("/product/hc")
public class HcController {
    @Autowired
    private HcService hcService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;

    @GetMapping()
    @RequiresPermissions("product:hc:hc")
    String Hc() {
        return "product/hc/hc";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:hc:hc")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<HcDO> hcList = hcService.list(query);
        int total = hcService.count(query);
        PageUtils pageUtils = new PageUtils(hcList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:hc:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = hcService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hc/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:hc:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        HcDO hc = hcService.get(id);
        model.addAttribute("hc", hc);
        String sm = hc.getSmall();
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = hcService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hc/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("product:hc:detail")
    String detail(@PathVariable("id") Long id, Model model) {
        HcDO hc = hcService.get(id);
        model.addAttribute("hc", hc);
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = hcService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hc/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:hc:add")
    public R save(HcDO hc) {
        if (hcService.save(hc) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:hc:edit")
    public R update(HcDO hc) {
        hcService.update(hc);
        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @PostMapping("/remove")
//    @ResponseBody
//    @RequiresPermissions("product:hc:remove")
//    public R remove(Long id) {
//        if (hcService.remove(id) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:hc:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        hcService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = hcService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:hc:findmfrs")
    String findmfrs() {
        return "/mfrs/mfrs/findHcMfrs";
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        HcDO hcDO = new HcDO();
        hcDO.setId(id);
        hcDO.setStatus(enable);
        hcService.update(hcDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Long id) {
        HcDO hcDO = new HcDO();
        hcDO.setState(0L);
        hcDO.setId(id);
        if (hcService.updateState(hcDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
