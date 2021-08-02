package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MaterialDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MaterialService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.product.service.StyleService;
import com.shiguang.product.service.TechnologyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 镜架新增表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */

@Controller
@RequestMapping("/product/produca")
public class ProducaController {
    @Autowired
    private ProducaService producaService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //款式
    @Autowired
    private StyleService styleService;
    //工艺类型
    @Autowired
    private TechnologyService technologyService;
    //镜架材质
    @Autowired
    private MaterialService materialService;

    @GetMapping()
    @RequiresPermissions("product:produca:produca")
    String Produca(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        return "product/produca/produca";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:produca:produca")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ProducaDO> producaList = producaService.list(query);
        int total = producaService.count(query);
        PageUtils pageUtils = new PageUtils(producaList, total);
        return pageUtils;
    }


    @GetMapping("/add")
    @RequiresPermissions("product:produca:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        return "product/produca/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:produca:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        //修改时显示制造商和商品品种名称
        ProducaDO produca = producaService.get(id);
        model.addAttribute("produca", produca);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        return "product/produca/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("product:produca:detail")
    String detial(@PathVariable("id") Long id, Model model) {
        //修改时显示制造商和商品品种名称
        ProducaDO produca = producaService.get(id);
        model.addAttribute("produca", produca);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        return "product/produca/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:produca:add")
    public R save(ProducaDO produca) {
        if (producaService.save(produca) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:produca:edit")
    public R update(ProducaDO produca) {
        producaService.update(produca);
        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @PostMapping("/remove")
//    @ResponseBody
//    @RequiresPermissions("product:produca:remove")
//    public R remove(Long id) {
//        if (producaService.remove(id) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:produca:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        producaService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, String goodsid, Model model) {
        Map<String, Object> map = new HashMap();
        map.put("mfrsid", mfrsid);
        map.put("goodsid", goodsid);
        List<BrandDO> brandDOList = producaService.choice(map);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    //跳转制造商
    @GetMapping("/findmfrs")
    @RequiresPermissions("product:produca:findmfrs")
    String findmfrs() {
        return "mfrs/mfrs/findProducaMfrs";
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        ProducaDO producaDO = new ProducaDO();
        producaDO.setId(id);
        producaDO.setStatus(enable);
        producaService.update(producaDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Long id) {
        ProducaDO producaDO = new ProducaDO();
        producaDO.setState(0L);
        producaDO.setId(id);
        if (producaService.updateState(producaDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

}
