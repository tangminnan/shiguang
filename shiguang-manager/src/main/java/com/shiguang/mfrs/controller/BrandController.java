package com.shiguang.mfrs.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 品牌维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 11:47:52
 */

@Controller
@RequestMapping("/mfrs/brand")
public class BrandController {


    @Autowired
    private BrandService brandService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //镜架材质
    @Autowired
    private MaterialService materialService;
    //材料分类
    @Autowired
    private LensService lensService;
    //光度分类
    @Autowired
    private LightService lightService;
    //折射率
    @Autowired
    private RefractivityService refractivityService;
    //镜片功能
    @Autowired
    private FunctionService functionService;
    //渐进片分类
    @Autowired
    private GradualService gradualService;
    //使用类型
    @Autowired
    private UsageService usageService;
    //抛弃型分类
    @Autowired
    private TypeService typeService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //支付方式
    @Autowired
    private PayService payService;

    @GetMapping()
    @RequiresPermissions("mfrs:brand:brand")
    String Brand(Model model) {
        Map<String, Object> map = new HashMap<>();
        //品牌
        List<BrandDO> brandDOList = brandService.list(map);
        model.addAttribute("brandDOList", brandDOList);
        //商品类别
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);

        return "mfrs/brand/brand";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:brand:brand")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<BrandDO> brandList = brandService.list(query);
        int total = brandService.count(query);
        PageUtils pageUtils = new PageUtils(brandList, total);
        return pageUtils;
    }
    //查询商品品种
    @ResponseBody
    @GetMapping("/findbrandList")
    public PageUtils findbrandList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        query.put("xsstate","0");
        List<BrandDO> brandDOList = brandService.finfBrand(query);
        int total = brandService.finfBrandcount(query);
        PageUtils pageUtils = new PageUtils(brandDOList, total);
        return pageUtils;
    }
    @GetMapping("/add")
    @RequiresPermissions("mfrs:brand:add")
    String add(Model model, BrandDO brand, HttpServletResponse resp) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //使用分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);


        return "mfrs/brand/add";
    }

    @GetMapping("/edit/{brandid}")
    @RequiresPermissions("mfrs:brand:edit")
    String edit(@PathVariable("brandid") Integer brandid, Model model) {

        ////关联所有品牌维护所需表
        BrandDO brand = brandService.getall(brandid);
        model.addAttribute("brand", brand);

        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //使用分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        return "mfrs/brand/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{brandid}")
    @RequiresPermissions("mfrs:brand:detail")
    String detail(@PathVariable("brandid") Integer brandid, Model model) {

        ////关联所有品牌维护所需表
        BrandDO brand = brandService.getall(brandid);
        model.addAttribute("brand", brand);

        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //使用分类
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        return "mfrs/brand/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:brand:add")
    public R save(BrandDO brand) {
        if (null == brand.getGoodsid()) {
            return R.error("商品类别不能为空");
        }
        //判断是否已存在
        String mfrsid = brand.getMfrsid();
        String brandnum = brand.getBrandnum();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        map.put("brandnum", brandnum);
        List<BrandDO> list = brandService.haveNum(map);
        if (list.size() > 0) {
            return R.error("品牌代码已存在");
        }
        if (brandService.save(brand) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("mfrs:brand:edit")
    public R update(BrandDO brand) {
        brandService.update(brand);
        return R.ok();
    }


    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:brand:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] brandids) {
        brandService.batchRemove(brandids);
        return R.ok();
    }

    //跳转制造商
    @GetMapping("/findmfrs/{goodsids}")
    String findmfrs(@PathVariable("goodsids") Integer goodsids, Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        model.addAttribute("goodsids", goodsids);
        return "mfrs/brand/findmfrs";
    }



    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/caidan")
    List<GoodsDO> caidan(Integer mfrsid, Model model) {
        List<GoodsDO> goodsDOList = brandService.caidan(mfrsid);
        model.addAttribute("goodsDOList", goodsDOList);
        return goodsDOList;
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Integer brandid, Long enable) {
        BrandDO brandDO = new BrandDO();
        brandDO.setBrandid(brandid);
        brandDO.setXsstate(enable);
        brandService.update(brandDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Integer brandid) {
        BrandDO brandDO = new BrandDO();
        brandDO.setState(0L);
        brandDO.setBrandid(brandid);
        if (brandService.updateState(brandDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
//    /**
//     * 删除
//     */
//    @ResponseBody
//    @RequestMapping("/remove")
//    @RequiresPermissions("mfrs:brand:remove")
//    public R remove(Integer brandid) {
//        if(brandService.remove(brandid)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}
