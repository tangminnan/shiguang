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
 * 隐形成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-23 13:35:38
 */

@Controller
@RequestMapping("/product/yxcp")
public class YxcpController {
    @Autowired
    private YxcpService yxcpService;
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
    //抛弃类型分类
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
    String Yxcp(Model model) {
        Map<String, Object> map = new HashMap<>();
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        return "product/yxcp/yxcp";
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

        List<YxcpDO> yxcpList = yxcpService.list(query);
        int total = yxcpService.count(query);
        PageUtils pageUtils = new PageUtils(yxcpList, total);
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
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxcp/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        YxcpDO yxcp = yxcpService.get(id);
        model.addAttribute("yxcp", yxcp);
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
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxcp/edit";
    }

    /**
     * 详情
     */

    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        YxcpDO yxcp = yxcpService.get(id);
        model.addAttribute("yxcp", yxcp);
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
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //隐形类别
        List<InvisibleDO> invisibleDOList = invisibleService.list(map);
        model.addAttribute("invisibleDOList", invisibleDOList);
        //材质
        List<CaizhiDO> caizhiDOList = caizhiService.list(map);
        model.addAttribute("caizhiDOList", caizhiDOList);
        return "product/yxcp/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(YxcpDO yxcp) {
        //判断是否已存在商品代码
        String producNum = yxcp.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<YxcpDO> haveNum=yxcpService.haveNum(map);
        String producName=yxcp.getProducName();
        String sphId=yxcp.getSphId();
        String cylId=yxcp.getCylId();
        String retailPrice=yxcp.getRetailPrice();
        yxcp.setViewGoodName(producName);
        yxcp.setProducName(producName+"-球镜:"+sphId+"-柱镜:"+cylId+"-颜色:"+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
            return R.error("商品代码已存在");
        }
        if (yxcpService.save(yxcp) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(YxcpDO yxcp) {
        String name=yxcp.getBrandname()+"-球镜:"+yxcp.getSphId()+"-柱镜:"+yxcp.getCylId()+"-颜色:"+"-标价:"+yxcp.getRetailPrice();
        yxcp.setProducName(name);
        yxcpService.update(yxcp);
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        yxcpService.batchRemove(ids);
        return R.ok();
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        YxcpDO yxcpDO = new YxcpDO();
        yxcpDO.setId(id);
        yxcpDO.setXsstate(enable);
        yxcpService.update(yxcpDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    public R updateStatus(Long id) {
        YxcpDO yxcpDO = new YxcpDO();
        yxcpDO.setState(0L);
        yxcpDO.setId(id);
        if (yxcpService.updateState(yxcpDO) > 0) {
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
//        if(yxcpService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}


