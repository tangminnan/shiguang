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
 * 隐形成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */

@Controller
@RequestMapping("/product/yxcp")
public class YxcpController {
    @Autowired
    private YxcpService yxcpService;
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
    //抛弃类型分类
    @Autowired
    private TypeService typeService;
    //隐形类别
    @Autowired
    private InvisibleService invisibleService;
    //材质
    @Autowired
    private CaizhiService caizhiService;

    @GetMapping()
    @RequiresPermissions("product:yxcp:yxcp")
    String Yxcp() {
        return "product/yxcp/yxcp";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:yxcp:yxcp")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<YxcpDO> yxcpList = yxcpService.list(query);
        int total = yxcpService.count(query);
        PageUtils pageUtils = new PageUtils(yxcpList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:yxcp:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = yxcpService.mglist(map);
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
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxcp/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:yxcp:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        YxcpDO yxcp = yxcpService.get(id);
        model.addAttribute("yxcp", yxcp);
        return "product/yxcp/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:yxcp:add")
    public R save(YxcpDO yxcp) {
        if (yxcpService.save(yxcp) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:yxcp:edit")
    public R update(YxcpDO yxcp) {
        yxcpService.update(yxcp);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:yxcp:remove")
    public R remove(Long id) {
        if (yxcpService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:yxcp:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        yxcpService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = yxcpService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:yxcp:findmfrs")
    String findmfrs() {
        return "/mfrs/mfrs/findYxcpMfrs";
    }
}
