package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.HlyService;
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

    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Hly() {
        return "product/hly/hly";
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

        List<HlyDO> hlyList = hlyService.list(query);
        int total = hlyService.count(query);
        PageUtils pageUtils = new PageUtils(hlyList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hly/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        HlyDO hly = hlyService.get(id);
        model.addAttribute("hly", hly);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hly/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        HlyDO hly = hlyService.get(id);
        model.addAttribute("hly", hly);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/hly/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(HlyDO hly) {
        //判断是否已存在商品代码
        String producNum = hly.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<HlyDO> haveNum=hlyService.haveNum(map);

        String producName=hly.getProducName();
        String factory=hly.getProducFactory();
        String retailPrice=hly.getRetailPrice();
        hly.setViewGoodName(producName);
        hly.setProducName(producName+"-型号:"+factory+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
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
    public R update(HlyDO hly) {
        String name=hly.getBrandname()+"-型号:"+hly.getFactory()+"-标价:"+hly.getRetailPrice();
        hly.setProducName(name);
        hlyService.update(hly);
        return R.ok();
    }


    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        hlyService.batchRemove(ids);
        return R.ok();
    }




    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        HlyDO hlyDO = new HlyDO();
        hlyDO.setId(id);
        hlyDO.setXsstate(enable);
        hlyService.update(hlyDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R updateStatus(Long id) {
        HlyDO hlyDO = new HlyDO();
        hlyDO.setState(0L);
        hlyDO.setId(id);
        if (hlyService.updateState(hlyDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
//    /**
//     * 删除
//     */
//    @ResponseBody
//    @RequestMapping("/remove")
//    public R remove(Long id) {
//        if(hlyService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}

