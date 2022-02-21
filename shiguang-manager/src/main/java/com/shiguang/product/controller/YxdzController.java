package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 隐形定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:02:16
 */

@Controller
@RequestMapping("/product/yxdz")
public class YxdzController {
    @Autowired
    private YxdzService yxdzService;
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
    //抛弃类型
    @Autowired
    private TypeService typeService;
    //隐形类别
    @Autowired
    private InvisibleService invisibleService;
    //材质
    @Autowired
    private CaizhiService caizhiService;

    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Yxdz(Model model) {
        Map<String, Object> map = new HashMap<>();
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        return "product/yxdz/yxdz";
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

        List<YxdzDO> yxdzList = yxdzService.list(query);
        int total = yxdzService.count(query);
        PageUtils pageUtils = new PageUtils(yxdzList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
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
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        YxdzDO yxdz = yxdzService.get(id);
        model.addAttribute("yxdz", yxdz);
//        String name=yxdz.getViewGoodName()+"-球镜:"+yxdz.getSphUp()+"/"+yxdz.getSphDown()+"-柱镜:"+yxdz.getCylUp()+"/"+yxdz.getCylDown()+"-标价:"+yxdz.getRetailPrice();
//        model.addAttribute("name", name);
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
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        YxdzDO yxdz = yxdzService.get(id);
        model.addAttribute("yxdz", yxdz);
//        String name=yxdz.getViewGoodName()+"-球镜:"+yxdz.getSphUp()+"/"+yxdz.getSphDown()+"-柱镜:"+yxdz.getCylUp()+"/"+yxdz.getCylDown()+"-标价:"+yxdz.getRetailPrice();
//        model.addAttribute("name", name);
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
        //使用类型分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxdz/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(YxdzDO yxdz) {
        //判断是否已存在商品代码
        String producNum = yxdz.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<YxdzDO> haveNum=yxdzService.haveNum(map);
        String producName=yxdz.getProducName();
        String cylUp=yxdz.getCylUp();
        String cylDown=yxdz.getCylDown();
        String sphUp=yxdz.getSphUp();
        String sphDown=yxdz.getSphDown();
        String retailPrice=yxdz.getRetailPrice();
        yxdz.setViewGoodName(producName);
        yxdz.setProducName(producName+"-球镜:"+sphUp+"/"+sphDown+"-柱镜:"+cylUp+"/"+cylDown +"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
//            return R.error("商品代码已存在");
            yxdzService.update(yxdz);
            return R.ok();
        }
        if (yxdzService.save(yxdz) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(YxdzDO yxdz) {
//        String name=yxdz.getBrandname()+"-球镜:"+yxdz.getSphUp()+"/"+yxdz.getSphDown()+"-柱镜:"+yxdz.getCylUp()+"/"+yxdz.getCylDown()+"-颜色:"+"-标价:"+yxdz.getRetailPrice();
//        yxdz.setProducName(name);
        yxdzService.update(yxdz);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        yxdzService.batchRemove(ids);
        return R.ok();
    }



    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        YxdzDO yxdzDO = new YxdzDO();
        yxdzDO.setId(id);
        yxdzDO.setXsstate(enable);
        yxdzService.update(yxdzDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R updateStatus(Long id) {
        YxdzDO yxdzDO = new YxdzDO();
        yxdzDO.setState(0L);
        yxdzDO.setId(id);
        if (yxdzService.updateState(yxdzDO) > 0) {
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
//        if(yxdzService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}
