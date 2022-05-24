package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.domain.ShiguangdzDO;
import com.shiguang.product.service.ShiguangService;
import com.shiguang.product.service.ShiguangdzService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
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
 * @date 2021-07-01 15:52:32
 */

@Controller
@RequestMapping("/product/shiguangdz")
public class ShiguangdzController {
    @Autowired
    private ShiguangdzService shiguangdzService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    @Autowired
    private StockService stockService;

    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Shiguangdz() {
        return "product/shiguangdz/shiguangdz";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        // 钱转换
//        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
//            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
//        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
//            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());
//        if (StringUtils.isNotBlank(params.get("taxPrice").toString()))
//            taxPrice = Double.parseDouble(params.get("taxPrice").toString());
//        if (StringUtils.isNotBlank(params.get("taxPrice2").toString()))
//            taxPrice2 = Double.parseDouble(params.get("taxPrice2").toString());
//
//        query.put("retailPrice", retailPrice);
//        query.put("retailPrice2", retailPrice2);
//        query.put("taxPrice", taxPrice);
//        query.put("taxPrice2", taxPrice2);

        List<ShiguangdzDO> shiguangList = shiguangdzService.list(query);
        int total = shiguangdzService.count(query);
        PageUtils pageUtils = new PageUtils(shiguangList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguangdz/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        ShiguangdzDO shiguang = shiguangdzService.get(id);
        model.addAttribute("shiguang", shiguang);
//        String name=shiguang.getViewGoodName()+"-型号:"+shiguang.getProducFactory()+"-标价:"+shiguang.getRetailPrice();
//        model.addAttribute("name", name);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguangdz/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        ShiguangdzDO shiguang = shiguangdzService.get(id);
        model.addAttribute("shiguang", shiguang);
//        String name=shiguang.getViewGoodName()+"-型号:"+shiguang.getProducFactory()+"-标价:"+shiguang.getRetailPrice();
//        model.addAttribute("name", name);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguangdz/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(ShiguangdzDO shiguang) {
        //判断是否已存在商品代码
        String producNum = shiguang.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);

        String producName=shiguang.getProducName();
        String factory=shiguang.getProducFactory();
        String retailPrice=shiguang.getRetailPrice();
        shiguang.setViewGoodName(producName);
        shiguang.setProducName(producName+"-型号:"+factory+"-标价:"+retailPrice);
        List<ShiguangdzDO> haveNum=shiguangdzService.haveNum(map);
        if (haveNum.size() > 0) {
//            return R.error("商品代码已存在");
            shiguangdzService.update(shiguang);
            StockDO stockDO=new StockDO();
            stockDO.setGoodsNum(producNum);
            stockDO.setGoodsName(producName+"-型号:"+factory+"-标价:"+retailPrice);
            stockDO.setRetailPrice(retailPrice);
            stockDO.setFactory(factory);
            stockService.update(stockDO);
            return R.ok();
        }

        if (shiguangdzService.save(shiguang) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(ShiguangdzDO shiguang) {
//        String name=shiguang.getBrandname()+"-型号:"+shiguang.getFactory()+"-标价:"+shiguang.getRetailPrice();
//        shiguang.setProducName(name);
        shiguangdzService.update(shiguang);
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shiguangdzService.batchRemove(ids);
        return R.ok();
    }



    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        ShiguangdzDO shiguangDO = new ShiguangdzDO();
        shiguangDO.setId(id);
        shiguangDO.setXsstate(enable);
        shiguangdzService.update(shiguangDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R updateStatus(Long id) {
        ShiguangdzDO shiguangDO = new ShiguangdzDO();
        shiguangDO.setState(0L);
        shiguangDO.setId(id);
        if (shiguangdzService.updateState(shiguangDO) > 0) {
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
//        if(shiguangService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}
