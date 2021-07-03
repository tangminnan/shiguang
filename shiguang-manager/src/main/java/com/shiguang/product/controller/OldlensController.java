package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.OlddegreesDO;
import com.shiguang.product.domain.OldlensDO;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.service.OlddegreesService;
import com.shiguang.product.service.OldlensService;
import com.shiguang.product.service.StyleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 老花镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */

@Controller
@RequestMapping("/product/oldlens")
public class OldlensController {
    @Autowired
    private OldlensService oldlensService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //款式
    @Autowired
    private StyleService styleService;

    //老花镜度数
    @Autowired
    private OlddegreesService olddegreesService;

    @GetMapping()
    @RequiresPermissions("product:oldlens:oldlens")
    String Oldlens() {
        return "product/oldlens/oldlens";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("product:oldlens:oldlens")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OldlensDO> oldlensList = oldlensService.list(query);
        int total = oldlensService.count(query);
        PageUtils pageUtils = new PageUtils(oldlensList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("product:oldlens:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = oldlensService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //老花镜度数
        List<OlddegreesDO> olddegreesDOList = olddegreesService.list(map);
        model.addAttribute("olddegreesDOList", olddegreesDOList);
        return "product/oldlens/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:oldlens:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        OldlensDO oldlens = oldlensService.get(id);
        model.addAttribute("oldlens", oldlens);
        return "product/oldlens/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:oldlens:add")
    public R save(OldlensDO oldlens) {
        if (oldlensService.save(oldlens) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:oldlens:edit")
    public R update(OldlensDO oldlens) {
        oldlensService.update(oldlens);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("product:oldlens:remove")
    public R remove(Long id) {
        if (oldlensService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:oldlens:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        oldlensService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = oldlensService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }
}
