package com.shiguang.stock.controller;

import com.shiguang.common.utils.*;
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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-29 11:43:50
 */

@Controller
@RequestMapping("/stock/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //    仓位
    @Autowired
    private PositionService positionService;

    @GetMapping()
    @RequiresPermissions("stock:stock:stock")
    String Stock() {
        return "stock/stock/stock";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("stock:stock:stock")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<StockDO> stockList = stockService.list(query);
        int total = stockService.count(query);
        PageUtils pageUtils = new PageUtils(stockList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("stock:stock:add")
    String add(Model model) {
        //———生成单据编号————
        Long uuid = GuuidUtil.getUUID();
        String uuidstr = "PIN" + uuid.toString();
        model.addAttribute("uuidstr", uuidstr);
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //仓位
        List<PositionDO> positionDOList = positionService.list(map);
        model.addAttribute("positionDOList", positionDOList);
        //———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
//———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("createTime", newDate);
        return "stock/stock/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("stock:stock:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        StockDO stock = stockService.get(id);
        model.addAttribute("stock", stock);
        return "stock/stock/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:stock:add")
    public R save(StockDO stock) {
        if (stockService.save(stock) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("stock:stock:edit")
    public R update(StockDO stock) {
        stockService.update(stock);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("stock:stock:remove")
    public R remove(Long id) {
        if (stockService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("stock:stock:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        stockService.batchRemove(ids);
        return R.ok();
    }

    //跳转制造商
    @GetMapping("/findmfrs/{goodsid}")
    @RequiresPermissions("stock:stock:findmfrs")
    String findmfrs(@PathVariable("goodsid") Integer goodsid, Model model) {
        model.addAttribute("goodsid", goodsid);
        return "/mfrs/mfrs/findMfrs";
    }

    //跳转镜架商品查询
    @GetMapping("/jingjia")
    @RequiresPermissions("stock:stock:jingjia")
    String jingjia() {
        return "stock/stock/jingjia";
    }

    //跳转配件商品查询
    @GetMapping("/peijian/{mfrsid}")
    @RequiresPermissions("stock:stock:peijian")
    String peijian(@PathVariable("mfrsid") Integer mfrsid, Model model) {

        return "/stock/stock/peijian";
    }

    //跳转镜片商品查询
    @GetMapping("/jingpian")
    @RequiresPermissions("stock:stock:jingpian")
    String jingpian() {
        return "/stock/stock/jingpian";
    }

    //跳转隐形镜片商品查询
    @GetMapping("/yinxing")
    @RequiresPermissions("stock:stock:yinxing")
    String yinxing() {
        return "/stock/stock/yinxing";
    }

    //跳转隐形护理液商品查询
    @GetMapping("/hly")
    @RequiresPermissions("stock:stock:hly")
    String hly() {
        return "/stock/stock/hly";
    }

    //跳转太阳镜商品查询
    @GetMapping("/tyj")
    @RequiresPermissions("stock:stock:tyj")
    String tyj() {
        return "/stock/stock/tyj";
    }

    //跳转耗材商品查询
    @GetMapping("/hc")
    @RequiresPermissions("stock:stock:hc")
    String hc() {
        return "/stock/stock/hc";
    }

    //跳转视光商品查询
    @GetMapping("/sg")
    @RequiresPermissions("stock:stock:sg")
    String sg() {
        return "/stock/stock/sg";
    }

}
