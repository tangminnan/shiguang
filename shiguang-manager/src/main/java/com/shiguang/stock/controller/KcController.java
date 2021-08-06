package com.shiguang.stock.controller;

import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.GoodsService;
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

    @GetMapping()
    @RequiresPermissions("kucun:stock:stock")
    String Stock(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
        map.put("goodstypeName", "隐形");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        return "stock/stock/kccx";
    }

    //    库存查询
    @ResponseBody
    @RequestMapping(value = "/selectKc")
    public List<StockDO> selectSg(String goodsNum, String goodsCode, String goodsName,
                                  Integer goodsType, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsNum", goodsNum);
        map.put("goodsCode", goodsCode);
        map.put("goodsName", goodsName);
        map.put("goodsType", goodsType);
        List<StockDO> stockDOS = stockService.kccxList(map);
        model.addAttribute("stockDOS", stockDOS);
        return stockDOS;
    }

}
