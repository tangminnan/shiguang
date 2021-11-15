package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.RefractivityService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配件表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */

@Controller
@RequestMapping("/product/parts")
public class PartsController {
    @Autowired
    private PartsService partsService;

    //计量单位
    @Autowired
    private UnitService unitService;
    //折射率
    @Autowired
    private RefractivityService refractivityService;

    @GetMapping()
    String Parts() {
        return "product/parts/parts";
    }

    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());
        if (StringUtils.isNotBlank(params.get("taxPrice").toString()))
            taxPrice = Double.parseDouble(params.get("taxPrice").toString());
        if (StringUtils.isNotBlank(params.get("taxPrice2").toString()))
            taxPrice2 = Double.parseDouble(params.get("taxPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);
        query.put("taxPrice", taxPrice);
        query.put("taxPrice2", taxPrice2);

        List<PartsDO> partsList = partsService.list(query);
        int total = partsService.count(query);
        PageUtils pageUtils = new PageUtils(partsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        /*//制造商
        List<MgDO> mfrsDOList = partsService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);*/
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        return "product/parts/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        PartsDO parts = partsService.get(id);
        model.addAttribute("parts", parts);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        return "product/parts/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        PartsDO parts = partsService.get(id);
        model.addAttribute("parts", parts);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        return "product/parts/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(PartsDO parts) {
        //判断是否已存在商品代码
        String producNum = parts.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<PartsDO> haveNum=partsService.haveNum(map);
        String producName=parts.getProducName();
        String factory=parts.getProducFactory();
        String retailPrice=parts.getRetailPrice();
        parts.setViewGoodName(producName);
        parts.setProducName(producName+"-型号:"+factory+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
        if (partsService.save(parts) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(PartsDO parts) {
        partsService.update(parts);
        return R.ok();
    }


    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        partsService.batchRemove(ids);
        return R.ok();
    }

//    //制造商——商品类别菜单下来选择
//    @ResponseBody
//    @RequestMapping(value = "/choice")
//    List<BrandDO> choice(String mfrsid, String goodsid, Model model) {
//        Map<String, Object> map = new HashMap();
//        map.put("mfrsid", mfrsid);
//        map.put("goodsid", goodsid);
//        map.put("xsstate","0");
//        List<BrandDO> brandDOList = producaService.choice(map);
//        model.addAttribute("brandDOList", brandDOList);
//        return brandDOList;
//    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        PartsDO partsDO = new PartsDO();
        partsDO.setId(id);
        partsDO.setXsstate(enable);
        partsService.update(partsDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R updateStatus(Long id) {
        PartsDO partsDO = new PartsDO();
        partsDO.setState(0L);
        partsDO.setId(id);
        if (partsService.updateState(partsDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

}

