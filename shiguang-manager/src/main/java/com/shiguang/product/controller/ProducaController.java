package com.shiguang.product.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.product.service.StyleService;
import com.shiguang.product.service.TechnologyService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.SalesDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 镜架新增表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */

@Controller
@RequestMapping("/product/produca")
public class
ProducaController {
    @Autowired
    private ProducaService producaService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
    //计量单位
    @Autowired
    private UnitService unitService;
    //款式
    @Autowired
    private StyleService styleService;
    //工艺类型
    @Autowired
    private TechnologyService technologyService;
    //镜架材质
    @Autowired
    private MaterialService materialService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //支付方式
    @Autowired
    private PayService payService;
    @Autowired
    private  BrandService brandService;
    @Autowired
    private StockService stockService;


    private Double retailPrice;
    private Double retailPrice2;
    private Double taxPrice;
    private Double taxPrice2;
    @GetMapping()
    String Produca(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        return "product/produca/produca";
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

        List<ProducaDO> producaList = producaService.list(query);
        int total = producaService.count(query);
        PageUtils pageUtils = new PageUtils(producaList, total);
        return pageUtils;
    }


    @GetMapping("/add")
    @RequiresPermissions("product:produca:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        return "product/produca/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("product:produca:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        //修改时显示制造商和商品品种名称
        ProducaDO produca = producaService.get(id);
        model.addAttribute("produca", produca);
//        String name=produca.getViewGoodName()+"-型号:"+produca.getProducFactory()+"-色号:"+produca.getProducFactorycolor()+"-标价:"+produca.getRetailPrice();
//        model.addAttribute("name", name);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        return "product/produca/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("product:produca:detail")
    String detial(@PathVariable("id") Long id, Model model) {
        //修改时显示制造商和商品品种名称
        ProducaDO produca = producaService.get(id);
        model.addAttribute("produca", produca);
//        String name=produca.getViewGoodName()+"-型号:"+produca.getProducFactory()+"-色号:"+produca.getProducFactorycolor()+"-标价:"+produca.getRetailPrice();
//        model.addAttribute("name", name);
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //款式
        List<StyleDO> styleDOList = styleService.list(map);
        model.addAttribute("styleDOList", styleDOList);
        return "product/produca/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("product:produca:add")
    public R save(ProducaDO produca) {
        //判断是否已存在商品代码
        String producNum = produca.getProducNum();
        Map<String, Object> map = new HashMap<>();
        map.put("producNum",producNum);
        List<ProducaDO> haveNum=producaService.haveNum(map);
        String producName=produca.getProducName();
        String factory=produca.getProducFactory();
        String producColor=produca.getProducColor();
        String retailPrice=produca.getRetailPrice();
        produca.setViewGoodName(producName);
        produca.setProducName(producName+"-型号:"+factory+"-色号:"+producColor+"-标价:"+retailPrice);
        if (haveNum.size() > 0) {
//            return R.error("商品代码已存在");
            producaService.update(produca);
            StockDO stockDO=new StockDO();
            stockDO.setGoodsNum(producNum);
            stockDO.setGoodsName(producName+"-型号:"+factory+"-色号:"+producColor+"-标价:"+retailPrice);
            stockDO.setRetailPrice(retailPrice);
            stockDO.setFactory(factory);
            stockService.update(stockDO);
            return R.ok();
        }
            if (producaService.save(produca) > 0) {
                return R.ok();
            }

        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("product:produca:edit")
    public R update(ProducaDO produca) {
//       String name= produca.getBrandname()+"-型号:"+produca.getFactory()+"-色号:"+produca.getProducColor()+"-标价:"+produca.getRetailPrice();
//        produca.setProducName(name);
        producaService.update(produca);
        return R.ok();
    }
    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("product:produca:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        producaService.batchRemove(ids);
        return R.ok();
    }

    //制造商——商品类别菜单下来选择
    @ResponseBody
    @RequestMapping(value = "/choice")
    List<BrandDO> choice(String mfrsid, String goodsid, Model model) {
        Map<String, Object> map = new HashMap();
        map.put("mfrsid", mfrsid);
        map.put("goodsid", goodsid);
        map.put("xsstate","0");
        List<BrandDO> brandDOList = producaService.choice(map);
        model.addAttribute("brandDOList", brandDOList);
        return brandDOList;
    }


    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long id, Long enable) {
        ProducaDO producaDO = new ProducaDO();
        producaDO.setId(id);
        producaDO.setXsstate(enable);
        producaService.update(producaDO);
        return R.ok();
    }

    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("product:produca:remove")
    public R updateStatus(Long id) {
        ProducaDO producaDO = new ProducaDO();
        producaDO.setState(0L);
        producaDO.setId(id);
        if (producaService.updateState(producaDO) > 0) {
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
//        if(producaService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
    //跳转制造商
    @GetMapping("/findmfrs/{goodsid}")
    @RequiresPermissions("product:produca:findmfrs")
    String findmfrs(@PathVariable("goodsid") Integer goodsid, Model model) {
        model.addAttribute("goodsid", goodsid);
        return "/mfrs/mfrs/findMfrs";
    }
    /**
     * 选择商品品种
     */
    @GetMapping("/findbrand/{mfrsid}/{goodsid}")
    @RequiresPermissions("product:produca:findbrand")
    String findbrand(@PathVariable("mfrsid") String mfrsid,@PathVariable("goodsid") Integer goodsid, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("goodsid", goodsid);
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
        return "/product/produca/findBrand";

    }

    @GetMapping("/addall")
    @RequiresPermissions("product:produca:add")
    String addall(Model model) {
        Map<String, Object> map = new HashMap<>();
        //计量单位
        List<UnitDO> unitDOList = unitService.list(map);
        model.addAttribute("unitDOList", unitDOList);
        return "product/produca/addAll";
    }

    /**
     * 导入
     */
    @PostMapping("/importStock")
    @ResponseBody
    public R importStock(String goodsType,String mfrsid,String brandnum,String brandname,Integer unitid,String year,String tax,String taxPrice,
                         String tradePrice,String transferPrice,String classtype,Long xsstate,Long state,
                         MultipartFile file) {
        return producaService.importStock(goodsType,mfrsid,brandnum,brandname,unitid,year,tax,taxPrice,tradePrice,transferPrice,classtype,xsstate,state, file);
    }

    /**
     * 导出
     *
     * @throws IOException
     */
    @GetMapping("/out")
    public void out(  HttpServletRequest request, HttpServletResponse response) throws IOException {
        producaService.jjOut(request, response);
    }
}
