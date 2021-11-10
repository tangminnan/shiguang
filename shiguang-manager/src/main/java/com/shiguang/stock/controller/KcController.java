package com.shiguang.stock.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.product.service.StyleService;
import com.shiguang.product.service.TechnologyService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.StockService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-06 11:37:17
 */

@Controller
@RequestMapping("/kucun/stock")
public class KcController {
    @Autowired
    private StockService stockService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //仓位
    @Autowired
    private PositionService positionService;

    //制造商
    @Autowired
    private MfrsService mfrsService;
    //支付方式
    @Autowired
    private PayService payService;
    @Autowired
    private  BrandService brandService;


    private Double retailPrice;
    private Double retailPrice2;

    @GetMapping()
    @RequiresPermissions("kucun:stock:stock")
    String Stock(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
//        map.put("goodstypeName", "隐形");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        return "stock/stock/kccx";
    }

    @ResponseBody
    @RequestMapping(value = "/selectPosion")
    public List<PositionDO> positionList(String xsstate, Model model) {
        Map<String, Object> map = new HashMap<>();
        //仓位
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        if (companyId != null) {
            if ("3".equals(companyId)) {
                map.put("companyId",null);
            } else {
                map.put("companyId", companyId);
            }
        } else if (companyId == null) {
            String departNumber = ShiroUtils.getUser().getStoreNum();
            map.put("departNumber", departNumber);
        }
        map.put("xsstate", xsstate);
        List<PositionDO> positionList = positionService.positionList(map);
        model.addAttribute("positionList", positionList);
        return positionList;
    }

    //库存查询
    @ResponseBody
    @RequestMapping("/selectKc")
    public PageUtils list(@RequestParam Map<String, Object> params,Model model) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyid = ShiroUtils.getUser().getCompanyId();
        if (companyid != null) {
            if ("3".equals(companyid)) {
                query.put("companyid", null);
            } else {
                query.put("companyid", companyid);
            }
        } else if (companyid == null) {
            String departNumber = ShiroUtils.getUser().getStoreNum();
            query.put("departNumber", departNumber);
        }
        query.put("status", "0");
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());


        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);
        String kucount=params.get("kccount").toString();
        if (kucount.equals("0")){
            query.put("kccount0",kucount);
        }else if (kucount.equals("1")){
            query.put("kccount1","0");
        }
        List<StockDO> stockDOS = stockService.kccxList(query);

        int total = stockService.kccxListCount(query);
        PageUtils pageUtils = new PageUtils(stockDOS, total);
        return pageUtils;
    }



    /**
     * 选择商品品种
     */
    @GetMapping("/findbrand/{mfrsname}/{goodsid}")
    String findbrand(@PathVariable("mfrsname") String mfrsname,@PathVariable("goodsid") Integer goodsid, Model model) {
        model.addAttribute("mfrsname", mfrsname);
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



//    //库存数量
    @ResponseBody
    @GetMapping("/countall")
    public Integer countall(
            @RequestParam("positionId") String positionId,
            @RequestParam("goodsNum") String goodsNum,
            @RequestParam("goodsCode") String goodsCode,
            @RequestParam("goodsName") String goodsName,
            @RequestParam("goodsType") String goodsType,
            @RequestParam("mfrsname") String mfrsname,
            @RequestParam("brandname") String brandname,
            @RequestParam("kccount") String kccount,
            @RequestParam("retailPrice") String retailPrice,
            @RequestParam("retailPrice2") String retailPrice2,
            @RequestParam("xsstate") String xsstate,
            @RequestParam("classtype") String classtype,
                            Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("positionId",positionId);
        map.put("goodsNum",goodsNum);
        map.put("goodsCode",goodsCode);
        map.put("goodsName",goodsName);
        map.put("goodsType",goodsType);
        map.put("mfrsname",mfrsname);
        map.put("brandname",brandname);
        map.put("kccount",kccount);
        map.put("retailPrice",retailPrice);
        map.put("retailPrice2",retailPrice2);
        map.put("xsstate",xsstate);
        map.put("classtype",classtype);
        int countalls=stockService.countall(map);
        model.addAttribute("countalls",countalls);
//        int countall=Integer.valueOf(countalls);
        return countalls;
    }

}
