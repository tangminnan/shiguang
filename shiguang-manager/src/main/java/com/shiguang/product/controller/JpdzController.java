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
 * 镜片定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */

@Controller
@RequestMapping("/product/jpdz")
public class JpdzController {
    @Autowired
    private JpdzService jpdzService;
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
    //光度分类
    @Autowired
    private LightService lightService;
    //镜片功能
    @Autowired
    private FunctionService functionService;
    //渐进片分类
    @Autowired
    private GradualService gradualService;

    @GetMapping()
    @RequiresPermissions("product:jpdz:jpdz")
    String Jpdz() {
        return "product/jpdz/jpdz";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:jpdz:jpdz")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<JpdzDO> jpdzList = jpdzService.listDz(query);
        int total = jpdzService.countDz(query);
        PageUtils pageUtils = new PageUtils(jpdzList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:jpdz:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = jpdzService.mglist(map);
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
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        return "product/jpdz/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:jpdz:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        JpdzDO jpdz = jpdzService.get(id);
        model.addAttribute("jpdz", jpdz);
        Map<String, Object> map = new HashMap<>();
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
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        return "product/jpdz/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:jpdz:add")
    public R save(JpdzDO jpdz) {
        if (jpdzService.save(jpdz) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:jpdz:edit")
    public R update(JpdzDO jpdz) {
        jpdzService.update(jpdz);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:jpdz:remove")
    public R remove(Long id) {
        if (jpdzService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:jpdz:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        jpdzService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = jpdzService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:jpdz:findmfrs")
    String findmfrs() {
        return "/mfrs/mfrs/findJpcpMfrs";
    }
}
