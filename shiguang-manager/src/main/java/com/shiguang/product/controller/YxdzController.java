package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 隐形定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:02:16
 */

@Controller
@RequestMapping("/product/yxdz")
public class YxdzController {
    @Autowired
    private YxdzService yxdzService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //折射率
    @Autowired
    private RefractivityService refractivityService;
    //球镜
    @Autowired
    private SphService sphService;
    //柱镜
    @Autowired
    private CylService cylService;
    //跨度
    @Autowired
    private SpanService spanService;
    //下加光
    @Autowired
    private LightbelowService lightbelowService;
    //材料分类
    @Autowired
    private LensService lensService;
    //使用类型
    @Autowired
    private UsageService usageService;
    //抛弃类型
    @Autowired
    private TypeService typeService;
    //隐形类别
    @Autowired
    private InvisibleService invisibleService;
    //材质
    @Autowired
    private CaizhiService caizhiService;

    @GetMapping()
    @RequiresPermissions("product:yxdz:yxdz")
    String Yxdz() {
        return "product/yxdz/yxdz";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:yxdz:yxdz")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<YxdzDO> yxdzList = yxdzService.list(query);
        int total = yxdzService.count(query);
        PageUtils pageUtils = new PageUtils(yxdzList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:yxdz:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = yxdzService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //球镜
        List<SphDO> sphDOList = sphService.list(map);
        model.addAttribute("sphDOList", sphDOList);
        //柱镜
        List<CylDO> cylDOList = cylService.list(map);
        model.addAttribute("cylDOList", cylDOList);
        //跨度
        List<SpanDO> spanDOList = spanService.list(map);
        model.addAttribute("spanDOList", spanDOList);
        //下加光
        List<LightbelowDO> lightbelowDOList = lightbelowService.list(map);
        model.addAttribute("lightbelowDOList", lightbelowDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:yxdz:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        YxdzDO yxdz = yxdzService.get(id);
        model.addAttribute("yxdz", yxdz);
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = yxdzService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //球镜
        List<SphDO> sphDOList = sphService.list(map);
        model.addAttribute("sphDOList", sphDOList);
        //柱镜
        List<CylDO> cylDOList = cylService.list(map);
        model.addAttribute("cylDOList", cylDOList);
        //跨度
        List<SpanDO> spanDOList = spanService.list(map);
        model.addAttribute("spanDOList", spanDOList);
        //下加光
        List<LightbelowDO> lightbelowDOList = lightbelowService.list(map);
        model.addAttribute("lightbelowDOList", lightbelowDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("product:yxdz:detail")
    String detail(@PathVariable("id") Long id, Model model) {
        YxdzDO yxdz = yxdzService.get(id);
        model.addAttribute("yxdz", yxdz);
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = yxdzService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //球镜
        List<SphDO> sphDOList = sphService.list(map);
        model.addAttribute("sphDOList", sphDOList);
        //柱镜
        List<CylDO> cylDOList = cylService.list(map);
        model.addAttribute("cylDOList", cylDOList);
        //跨度
        List<SpanDO> spanDOList = spanService.list(map);
        model.addAttribute("spanDOList", spanDOList);
        //下加光
        List<LightbelowDO> lightbelowDOList = lightbelowService.list(map);
        model.addAttribute("lightbelowDOList", lightbelowDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:yxdz:add")
    public R save(YxdzDO yxdz) {
        if (yxdzService.save(yxdz) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:yxdz:edit")
    public R update(YxdzDO yxdz) {
        yxdzService.update(yxdz);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:yxdz:remove")
    public R remove(Long id) {
        if (yxdzService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:yxdz:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        yxdzService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = yxdzService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:yxdz:findmfrs")
    String findmfrs() {
        return "/mfrs/mfrs/findYxdzMfrs";
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        YxdzDO yxdzDO = new YxdzDO();
        yxdzDO.setId(id);
        yxdzDO.setStatus(enable);
        yxdzService.update(yxdzDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Long id) {
        YxdzDO yxdzDO = new YxdzDO();
        yxdzDO.setState(0L);
        yxdzDO.setId(id);
        if (yxdzService.updateState(yxdzDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
}
