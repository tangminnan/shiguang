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
import com.shiguang.product.domain.OlddegreesDO;
import com.shiguang.product.domain.OldlensDO;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.service.OlddegreesService;
import com.shiguang.product.service.OldlensService;
import com.shiguang.product.service.StyleService;
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
    //计量单位
    @Autowired
    private UnitService unitService;
    //款式
    @Autowired
    private StyleService styleService;

    //老花镜度数
    @Autowired
    private OlddegreesService olddegreesService;


    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Oldlens() {
        return "product/oldlens/oldlens";
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

        List<OldlensDO> oldlensList = oldlensService.list(query);
        int total = oldlensService.count(query);
        PageUtils pageUtils = new PageUtils(oldlensList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
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
    String edit(@PathVariable("id") Long id, Model model) {
        OldlensDO oldlens = oldlensService.get(id);
        model.addAttribute("oldlens", oldlens);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //老花镜度数
        List<OlddegreesDO> olddegreesDOList = olddegreesService.list(map);
        model.addAttribute("olddegreesDOList", olddegreesDOList);
        return "product/oldlens/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        OldlensDO oldlens = oldlensService.get(id);
        model.addAttribute("oldlens", oldlens);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //老花镜度数
        List<OlddegreesDO> olddegreesDOList = olddegreesService.list(map);
        model.addAttribute("olddegreesDOList", olddegreesDOList);
        return "product/oldlens/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(OldlensDO oldlens) {
        //判断是否已存在商品代码
        String producNum = oldlens.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<OldlensDO> haveNum=oldlensService.haveNum(map);
//成品花镜-球镜：+3.75-型号：0-标价：88.00
        String producName=oldlens.getProducName();
        String oldId=oldlens.getOldId();
        String factory=oldlens.getProducFactory();
        String retailPrice=oldlens.getRetailPrice();
        oldlens.setViewGoodName(producName);
        oldlens.setProducName(producName+"-球镜:"+oldId+"-型号:"+factory+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
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
    public R update(OldlensDO oldlens) {
        String name=oldlens.getBrandname() +"-球镜:"+oldlens.getOldId()+"-型号:"+oldlens.getFactory()+"-标价:"+oldlens.getRetailPrice();
        oldlens.setProducName(name);
        oldlensService.update(oldlens);
        return R.ok();
    }


    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        oldlensService.batchRemove(ids);
        return R.ok();
    }




    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        OldlensDO oldlensDO = new OldlensDO();
        oldlensDO.setId(id);
        oldlensDO.setXsstate(enable);
        oldlensService.update(oldlensDO);
        return R.ok();
    }
//
//    /**
//     * 删除修改状态
//     */
//    @ResponseBody
//    @RequestMapping("/remove")
//    public R updateStatus(Long id) {
//        OldlensDO oldlensDO = new OldlensDO();
//        oldlensDO.setState(0L);
//        oldlensDO.setId(id);
//        if (oldlensService.updateState(oldlensDO) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }
    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R remove(Long id) {
        if(oldlensService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }
}
