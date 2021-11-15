package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.HcService;
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
    //计量单位
    @Autowired
    private UnitService unitService;

    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Hc() {
        return "product/hc/hc";
    }

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

        List<HcDO> hcList = hcService.list(query);
        int total = hcService.count(query);
        PageUtils pageUtils = new PageUtils(hcList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hc/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        HcDO hc = hcService.get(id);
        model.addAttribute("hc", hc);
        String sm = hc.getSmall();
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hc/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        HcDO hc = hcService.get(id);
        model.addAttribute("hc", hc);
        Map<String, Object> map = new HashMap<>();
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
    public R save(HcDO hc) {
        //判断是否已存在商品代码
        String producNum = hc.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<HcDO> haveNum=hcService.haveNum(map);

        String producName=hc.getProducName();
        String factory=hc.getProducFactory();
        String retailPrice=hc.getRetailPrice();
        hc.setViewGoodName(producName);
        hc.setProducName(producName+"-型号:"+factory+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
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
    public R update(HcDO hc) {
        hcService.update(hc);
        return R.ok();
    }


    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        hcService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(String mfrsid, Model model) {
        List<BrandDO> brandDOList = hcService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        HcDO hcDO = new HcDO();
        hcDO.setId(id);
        hcDO.setXsstate(enable);
        hcService.update(hcDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
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
