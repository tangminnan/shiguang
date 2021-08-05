package com.shiguang.stock.controller;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MaterialDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MaterialService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.TechnologyService;
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
    //仓位
    @Autowired
    private PositionService positionService;
    //工艺类型
    @Autowired
    private TechnologyService technologyService;
    //镜架材质
    @Autowired
    private MaterialService materialService;

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
        map.put("goodstypeName", "隐形");
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
        String str = stock.getGoodsNum();
        String[] name = str.split(",");
        for (int i = 0; i < name.length; i++) {
            StockDO stockDO = new StockDO();
            String goodsNum = name[i];
            stockDO.setGoodsNum(goodsNum);//代码
            String goodsCode = stock.getGoodsCode().split(",")[i];
            stockDO.setGoodsCode(goodsCode);//条码
            String goodsName = stock.getGoodsName().split(",")[i];
            stockDO.setGoodsName(goodsName);//名称
            String goodsCount = stock.getGoodsCount().toString().split(",")[i];
            stockDO.setGoodsCount(goodsCount);//数量
            stockDO.setGoodsType(stock.getGoodsType());//商品类别
            stockDO.setMfrsid(stock.getMfrsid());//制造商id

            String costPrice = stock.getCostPrice().split(",")[i];
            stockDO.setRetailPrice(costPrice);//成本价格costPrice  含税单价
            Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodsCount);
            stockDO.setCostSum(Double.toString(costSum));////成本合计 含税单据*数量

            String wholePrice = stock.getWholePrice().split(",")[i];
            stockDO.setWholePrice(wholePrice);//批发价格
            Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodsCount);
            stockDO.setCostSum(Double.toString(wholeSum));////批发合计 含税单据*数量

//            String transferPrice = stock.getTransferPrice().split(",")[i];
//            stockDO.setTransferPrice(transferPrice);
//            Double transferPricecount = Double.parseDouble(transferPrice) * Double.parseDouble(goodsCount);
//            stockDO.setCostSum(Double.toString(transferPricecount));

            String retailPrice = stock.getRetailPrice().split(",")[i];
            stockDO.setRetailPrice(retailPrice);//标准零售价格
            Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodsCount);
            stockDO.setPriceSum(Double.toString(priceSum));//原价合计  标准*数量

            stockDO.setPositionName(stock.getPositionName());//仓位名称
            stockDO.setCreateTime(stock.getCreateTime());//入库时间
            stockDO.setDanjuNumber(stock.getDanjuNumber());//单据编号
            stockDO.setOrderNumber(stock.getOrderNumber());//订单编号
            stockDO.setYundanNumber(stock.getYundanNumber());//运单号
            stockDO.setZhidanPeople(stock.getZhidanPeople());//制单人
            stockDO.setDanjuDay(stock.getDanjuDay()); //单据日期
            stockDO.setTuihuoNumber(stock.getTuihuoNumber());//退货单号
            stockDO.setFactoryNumber(stock.getFactoryNumber());//厂家订单号
            stockDO.setBeizhu(stock.getBeizhu());//备注
            stockDO.setUnit(stock.getUnit()); //单位

//            stockService.save(stockDO);
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
    @GetMapping("/jingjia/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:jingjia")
    String jingjia(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        Map<String, Object> map = new HashMap<>();
        //工艺类型
        List<TechnologyDO> technologyDOList = technologyService.list(map);
        model.addAttribute("technologyDOList", technologyDOList);
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        return "/stock/stock/jingjia";
    }

    //镜架List
    @ResponseBody
    @RequestMapping(value = "/selectjingjia")
    public List<ProducaDO> selectjingjia(String producNum, String producCode, String producName,
                                         Integer mfrsid, Integer brandid,
                                         String producFactorycolor, String size, Integer materialid,
                                         Integer technologyId, String producFactory, String factory,
                                         Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("producFactorycolor", producFactorycolor);
        map.put("sizes", size);
        map.put("materialid", materialid);
        map.put("technologyId", technologyId);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<ProducaDO> producaDOList = stockService.selectJingjia(map);
        model.addAttribute("producaDOList", producaDOList);
        return producaDOList;
    }

    //跳转配件商品查询
    @GetMapping("/peijian/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:peijian")
    String peijian(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/peijian";
    }

    //配件List
    @ResponseBody
    @RequestMapping(value = "/selectpeijian")
    public List<PartsDO> selectpeijian(String producNum, String producCode, String producName,
                                       Integer mfrsid, Integer brandid,
                                       String partsStyle, String producFactory, String factory,
                                       Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("partsStyle", partsStyle);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<PartsDO> partsDOList = stockService.selectPeijian(map);
        model.addAttribute("partsDOList", partsDOList);
        return partsDOList;
    }

    //跳转镜片商品查询
    @GetMapping("/jingpian/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:jingpian")
    String jingpian(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/jingpian";
    }

    //镜片List-----------成品
    @ResponseBody
    @RequestMapping(value = "/selectJpcp")
    public List<JpcpDO> selectJpcp(Integer mfrsid, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        List<JpcpDO> jpcpDOList = stockService.selectJpcp(map);
        model.addAttribute("jpcpDOList", jpcpDOList);
        return jpcpDOList;
    }

    //镜片List-----------定做
    @ResponseBody
    @RequestMapping(value = "/selectJpdz")
    public List<JpdzDO> selectJpdz(Integer mfrsid, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        List<JpdzDO> jpdzDOList = stockService.selectJpdz(map);
        model.addAttribute("jpdzDOList", jpdzDOList);
        return jpdzDOList;
    }

    //跳转护理液商品查询
    @GetMapping("/hly/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:hly")
    String hly(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/hly";
    }

    //护理液
    @ResponseBody
    @RequestMapping(value = "/selectHly")
    public List<HlyDO> selectHly(String producNum, String producCode, String producName,
                                 Integer mfrsid, Integer brandid,
                                 String mainCapacity, String secondCapacity,
                                 String producFactory, String factory,
                                 Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("mainCapacity", mainCapacity);
        map.put("secondCapacity", secondCapacity);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<HlyDO> hlyDOList = stockService.selectHly(map);
        model.addAttribute("hlyDOList", hlyDOList);
        return hlyDOList;
    }

    //跳转太阳镜商品查询
    @GetMapping("/tyj/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:tyj")
    String tyj(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/tyj";
    }

    //太阳镜
    @ResponseBody
    @RequestMapping(value = "/selectTyj")
    public List<TyjDO> selectTyj(String producNum, String producCode, String producName,
                                 Integer mfrsid, Integer brandid,
                                 String mainCapacity, String secondCapacity,
                                 String producFactory, String factory,
                                 Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("mainCapacity", mainCapacity);
        map.put("secondCapacity", secondCapacity);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<TyjDO> tyjDOList = stockService.selectTyj(map);
        model.addAttribute("tyjDOList", tyjDOList);
        return tyjDOList;
    }


    //跳转老花镜商品查询
    @GetMapping("/lhj/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:lhj")
    String lhj(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/lhj";
    }

    //老花镜
    @ResponseBody
    @RequestMapping(value = "/selectLhj")
    public List<OldlensDO> selectLhj(String producNum, String producCode, String producName,
                                     Integer mfrsid, Integer brandid,
                                     String producFactorycolor, String size,
                                     String producFactory, String factory,
                                     Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("producFactorycolor", producFactorycolor);
        map.put("size", size);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<OldlensDO> oldlensDOS = stockService.selectLhj(map);
        model.addAttribute("oldlensDOS", oldlensDOS);
        return oldlensDOS;
    }

    //跳转耗材商品查询
    @GetMapping("/hc/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:hc")
    String hc(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/hc";
    }

    //耗材
    @ResponseBody
    @RequestMapping(value = "/selectHc")
    public List<HcDO> selectHc(String producNum, String producCode, String producName, Integer mfrsid, Integer brandid,
                               String producFactory, String factory, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<HcDO> hcDOList = stockService.selectHc(map);
        model.addAttribute("hcDOList", hcDOList);
        return hcDOList;
    }

    //跳转视光商品查询
    @GetMapping("/sg/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:sg")
    String sg(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/sg";
    }

    //视光
    @ResponseBody
    @RequestMapping(value = "/selectSg")
    public List<ShiguangDO> selectSg(String producNum, String producCode, String producName, Integer mfrsid, Integer brandid,
                                     String producFactory, String factory, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        List<ShiguangDO> shiguangDOS = stockService.selectSg(map);
        model.addAttribute("shiguangDOS", shiguangDOS);
        return shiguangDOS;
    }
}
