package com.shiguang.stock.controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping()
    @RequiresPermissions("kucun:stock:stock")
    String Stock(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
//        map.put("goodstypeName", "隐形");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //仓位
        map.put("xsstate", 0);
        List<PositionDO> positionList = positionService.stockList(map);
        model.addAttribute("positionList", positionList);
        return "stock/stock/kccx";
    }

    @ResponseBody
    @RequestMapping(value = "/selectPosion")
    public List<PositionDO> positionList(Long xsstate, Model model) {
        Map<String, Object> map = new HashMap<>();
        //仓位
        map.put("xsstate", xsstate);
        List<PositionDO> positionList = positionService.stockList(map);
        model.addAttribute("positionList", positionList);
        return positionList;
    }

    //    库存查询
    @ResponseBody
    @RequestMapping(value = "/selectKc")
    public List<StockDO> selectSg(String goodsNum, String goodsCode, String goodsName,
                                  Integer goodsType, String mfrsname,String brandname,String retailPrice, String retailPrice2,
                                  Long xsstate, String positionName, Model model) {
        Map<String, Object> map = new HashMap<>();

        //———获取当前登录所在部门编码————
        String storeNum =  ShiroUtils.getUser().getStoreNum();
        map.put("storeNum", storeNum);
        map.put("goodsNum", goodsNum);
        map.put("goodsCode", goodsCode);
        map.put("goodsName", goodsName);
        map.put("goodsType", goodsType);
        map.put("mfrsname", mfrsname);
        map.put("brandname", brandname);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        map.put("xsstate", xsstate);
        map.put("positionName", positionName);
        List<StockDO> stockDOS = stockService.kccxList(map);
        model.addAttribute("stockDOS", stockDOS);
        return stockDOS;
    }

}
