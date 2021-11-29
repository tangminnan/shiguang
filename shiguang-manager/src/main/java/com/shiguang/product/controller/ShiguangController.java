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
import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.service.ShiguangService;
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
@RequestMapping("/product/shiguang")
public class ShiguangController {
    @Autowired
    private ShiguangService shiguangService;
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
    String Shiguang() {
        return "product/shiguang/shiguang";
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

        List<ShiguangDO> shiguangList = shiguangService.list(query);
        int total = shiguangService.count(query);
        PageUtils pageUtils = new PageUtils(shiguangList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        ShiguangDO shiguang = shiguangService.get(id);
        model.addAttribute("shiguang", shiguang);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        ShiguangDO shiguang = shiguangService.get(id);
        model.addAttribute("shiguang", shiguang);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/shiguang/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(ShiguangDO shiguang) {
        //判断是否已存在商品代码
        String producNum = shiguang.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);

        String producName=shiguang.getProducName();
        String factory=shiguang.getProducFactory();
        String retailPrice=shiguang.getRetailPrice();
        shiguang.setViewGoodName(producName);
        shiguang.setProducName(producName+"-型号:"+factory+"-标价:"+retailPrice);
        List<ShiguangDO> haveNum=shiguangService.haveNum(map);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
        if (shiguangService.save(shiguang) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(ShiguangDO shiguang) {
        shiguangService.update(shiguang);
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        shiguangService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(Integer mfrsid, Model model) {
        List<BrandDO> brandDOList = shiguangService.choice(mfrsid);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        ShiguangDO shiguangDO = new ShiguangDO();
        shiguangDO.setId(id);
        shiguangDO.setXsstate(enable);
        shiguangService.update(shiguangDO);
        return R.ok();
    }

//    /**
//     * 删除修改状态
//     */
//    @ResponseBody
//    @RequestMapping("/remove")
//    public R updateStatus(Long id) {
//        ShiguangDO shiguangDO = new ShiguangDO();
//        shiguangDO.setState(0L);
//        shiguangDO.setId(id);
//        if (shiguangService.updateState(shiguangDO) > 0) {
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
        if(shiguangService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }
}
