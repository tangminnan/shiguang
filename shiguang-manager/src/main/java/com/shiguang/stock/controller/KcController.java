package com.shiguang.stock.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.HcDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public PageUtils list(@RequestParam Map<String, Object> params) {
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

        List<StockDO> stockDOS = stockService.kccxList(query);
        int total = stockService.kccxListCount(query);
        PageUtils pageUtils = new PageUtils(stockDOS, total);
        return pageUtils;
    }

}
