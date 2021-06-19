package com.shiguang.mfrs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

import javax.servlet.http.HttpServletResponse;

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
    //计量单位
    @Autowired
    private UnitService unitService;
    //支付方式
    @Autowired
    private PayService payService;
    //制造商商品表
    @Autowired
    private MgService mgService;

    @GetMapping()
    @RequiresPermissions("mfrs:brand:brand")
    String Brand() {
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

    @GetMapping("/add")
    @RequiresPermissions("mfrs:brand:add")
    String add(Model model, BrandDO brand,HttpServletResponse resp) {
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
        BrandDO brand = brandService.get(brandid);
        model.addAttribute("brand", brand);

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
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        return "mfrs/brand/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:brand:add")
    public R save(BrandDO brand) {
        //获取制造商中的商品id,依次循环遍历，保存到关系表中，走两个保存方法

//     mfrs.getGoodsid();
//
//		for (){
//			MfrsGoodsDO mfrsGoodsDO = new MfrsGoodsDO();
//			mfrsGoodsDO.setMfrsid(mfrs.getMfrsid());
//			mfrsGoodsDO.setGoodsid();
//			mfrsGoodsService.save(mfrsGoodsDO);
//		}
//		String[] str = brand.getGoodsid().split(",");
//		for (int i=0; i<=str.length;i++){
//			MgDO mgDO = new MgDO();
//			mgDO.setMfrsid(brand.getMfrsid());
//			mgDO.setGoodsid();
//			mgService.save(mgDO);
//		}

        //判断是否已存在
        String brandnum = brand.getBrandnum();
        Map<String, Object> map = new HashMap<>();
        map.put("brandnum", brandnum);
        List<BrandDO> list = brandService.list(map);
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
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("mfrs:brand:remove")
    public R remove(Integer brandid) {
        if (brandService.remove(brandid) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:brand:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] brandids) {
        brandService.batchRemove(brandids);
        return R.ok();
    }

    @ResponseBody
    @RequestMapping(value="/caidan")
    List<GoodsDO> caidan(Integer mfrsid,Model model) {
        List<GoodsDO> goodsDOList = brandService.caidan(mfrsid);
        model.addAttribute("goodsDOList",goodsDOList);
        return goodsDOList;
    }

}
