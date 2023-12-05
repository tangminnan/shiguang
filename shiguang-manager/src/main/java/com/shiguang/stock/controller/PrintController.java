package com.shiguang.stock.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.QRCodeUtil;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.RefractivityService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/print/print")
public class PrintController {
    @Autowired
    private StockService stockService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RefractivityService refractivityService;

    @GetMapping()
    @RequiresPermissions("print:print:print")
    String Print(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
//        map.put("goodstypeName", "隐形");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        return "stock/print/print";
    }

    //批量打印
    @ResponseBody
    @RequestMapping("/batchCode")
    @RequiresPermissions("print:print:print")
    public PageUtils batchCode(@RequestParam Map<String, Object> params, Model model){
        //查询列表数据
        Query query = new Query(params);
        List<StockDO> stockDOS = stockService.kccxList(query);
        int total = stockService.kccxListCount(query);
        PageUtils pageUtils = new PageUtils(stockDOS, total);
        return pageUtils;
    }

    @GetMapping("/selectCode")
    @RequiresPermissions("print:print:selectCode")
    public String selectCode(String[] goodsNum, Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("goodsNum",goodsNum);
        List<StockDO> stockDOList = stockService.codeBatch(map);
        for (StockDO stockDO : stockDOList){
            String code = QRCodeUtil.creatRrCode(stockDO.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            stockDO.setQRCode(code);
        }
        model.addAttribute("stockDOList", stockDOList);
        return "/stock/print/code";
    }
}
