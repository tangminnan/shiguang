package com.shiguang.stock.controller;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.OlddegreesService;
import com.shiguang.product.service.ProducaService;
import com.shiguang.product.service.TechnologyService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.OrderService;
import com.shiguang.stock.service.StockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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
    private ProducaService producaService;
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
    //采购订单
    @Autowired
    private OrderService orderService;


    //材料分类
    @Autowired
    private LensService lensService;
    //折射率
    @Autowired
    private RefractivityService refractivityService;
    //光度分类
    @Autowired
    private LightService lightService;
    //镜片功能
    @Autowired
    private FunctionService functionService;
    //渐进片分类
    @Autowired
    private GradualService gradualService;

    //使用类型
    @Autowired
    private UsageService usageService;
    //抛弃类型分类
    @Autowired
    private TypeService typeService;
    //老花镜度数
    @Autowired
    private OlddegreesService olddegreesService;


    @GetMapping()
    @RequiresPermissions("stock:stock:stock")
    String Stock() {
        return "stock/stock/stock";
    }

    /**
     * 采购列表
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("stock:stock:stock")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyid=ShiroUtils.getUser().getCompanyId();
        if(companyid == null){
            String departNumber=ShiroUtils.getUser().getStoreNum();
            query.put("departNumber",departNumber);
        }else if (companyid != null){
            query.put("companyid",companyid);
        }
        List<OrderDO> orderDOList = orderService.list(query);
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(orderDOList, total);
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
//        map.put("goodstypeName", "隐形");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //仓位
        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if(companyId == null){
            String departNumber=ShiroUtils.getUser().getStoreNum();
            map.put("departNumber",departNumber);
        }else if (companyId != null){
            map.put("companyId",companyId);
        }
        map.put("positionOrder","2");
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
    public R save(StockDO stock, OrderDO orderDO) {
        String positionName=stock.getPositionName();
        String str = stock.getGoodsNum();
        String[] name = str.split(",");
        String[] goodsCode1=stock.getGoodsCode().split(",");
        String[] goodsName1= stock.getGoodsName().split(",");
        String[] brandname1= stock.getBrandname().split(",");
        String[] goodCount1= stock.getGoodsCount().toString().split(",");
        String[] costPrice1 =stock.getCostPrice().split(",");
        String[] wholePrice1=stock.getWholePrice().split(",");
        String[] retailPrice1= stock.getRetailPrice().split(",");
        String[] unit1=stock.getUnit().split(",");
        String[] useday1=stock.getUseday().split(",");
        String[] batch1=stock.getBatch().split(",");
        String[] zhuceNumber1=stock.getZhuceNumber().split(",");
        String[] produceDay1=stock.getProduceDay().split(",");
        String[] status1=stock.getStatus().split(",");
        String[] username1=stock.getUsername().split(",");
        String[] classtype1=stock.getClasstype().split(",");
        String[] factory1=stock.getFactory().split(",");
        String[] goodsxinxiid1=stock.getGoodsxinxiid().toString().split(",");

        for (int i = 0; i < name.length; i++) {
            StockDO stockDO = new StockDO();
            String goodsNum = name[i];
            stockDO.setGoodsNum(goodsNum);
            String goodsCode = goodsCode1[i];
            stockDO.setGoodsCode(goodsCode);
            String goodsName = goodsName1[i];
            stockDO.setGoodsName(goodsName);
            String brandname = brandname1[i];
            stockDO.setBrandname(brandname);
            String goodsCount = goodCount1[i];

            //判断是否已存在商品
            stockDO.setGoodsNum(goodsNum);
            stockDO.setPositionId(stock.getPositionId());
            stockDO.setPositionName(positionName);
            StockDO goodsNumList = stockService.haveNum(stockDO);
            if (null != goodsNumList) {
                String gdcount = goodsNumList.getGoodsCount();
                Integer goodsCountNew = Integer.valueOf(goodsCount);
                Integer gdcountNew = Integer.valueOf(gdcount);
                Integer newGoodsCount = goodsCountNew + gdcountNew;
                stockDO.setGoodsCount(String.valueOf(newGoodsCount));

                stockService.updateGoodsCount(stockDO);//修改数量
            } else {
                stockDO.setGoodsCount(goodsCount);//数量
                stockDO.setGoodsType(stock.getGoodsType());
                stockDO.setMfrsid(stock.getMfrsid());

                String costPrice = costPrice1[i];
                stockDO.setCostPrice(costPrice);

                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodsCount);
                stockDO.setCostSum(Double.toString(costSum));

                String wholePrice = wholePrice1[i];
                stockDO.setWholePrice(wholePrice);
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodsCount);
                stockDO.setWholeSum(Double.toString(wholeSum));

//            String transferPrice = stock.getTransferPrice().split(",")[i];
//            stockDO.setTransferPrice(transferPrice);
//            Double transferPricecount = Double.parseDouble(transferPrice) * Double.parseDouble(goodsCount);
//            stockDO.setCostSum(Double.toString(transferPricecount));

                String retailPrice =retailPrice1 [i];
                stockDO.setRetailPrice(retailPrice);
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodsCount);
                stockDO.setPriceSum(Double.toString(priceSum));


                stockDO.setPositionName(stock.getPositionName());
                stockDO.setCreateTime(stock.getCreateTime());
                stockDO.setDanjuNumber(stock.getDanjuNumber());
                stockDO.setOrderNumber(stock.getOrderNumber());
                stockDO.setYundanNumber(stock.getYundanNumber());
                stockDO.setZhidanPeople(stock.getZhidanPeople());
                stockDO.setDanjuDay(stock.getDanjuDay());
                stockDO.setTuihuoNumber(stock.getTuihuoNumber());
                stockDO.setFactoryNumber(stock.getFactoryNumber());
                stockDO.setBeizhu(stock.getBeizhu());
                stockDO.setReturnzt(stock.getReturnzt());
                String unit = unit1[i];
                stockDO.setUnit(unit);
                String useday = useday1[i];
                stockDO.setUseday(useday);
                String batch = batch1[i];
                stockDO.setBatch(batch);
                String zhuceNumber =zhuceNumber1 [i];
                stockDO.setZhuceNumber(zhuceNumber);
                String produceDay = produceDay1[i];
                stockDO.setProduceDay(produceDay);
                String status = status1[i];
                stockDO.setStatus(status);
                String username =username1 [i];
                stockDO.setUsername(username);
                String goodsxinxiid =goodsxinxiid1 [i];
                stockDO.setGoodsxinxiid(Long.valueOf(goodsxinxiid));

                if(null != stock.getClasstype()){
                    String classtype = classtype1[i];
                    stockDO.setClasstype(classtype);
                }else{
                    stockDO.setClasstype("");
                }
                if(null != stock.getFactory()) {
                    String factory = factory1[i];
                    stockDO.setFactory(factory);
                }else {
                    stockDO.setFactory("");
                }


                if (stockService.save(stockDO) < 0) {
                    return R.error();
                }
            }

        }
        String strOrder = stock.getGoodsNum();
        String[] namesOrder2 = strOrder.split(",");
        String[] goodsCode2=orderDO.getGoodsCode().split(",");
        String[] goodsName2=orderDO.getGoodsName().split(",");
        String[] brandname2=orderDO.getBrandname().split(",");
        String[] goodsCount2=orderDO.getGoodsCount().split(",");
        String[] costPrice2=orderDO.getGoodsCount().split(",");
        String[] wholePrice2=stock.getWholePrice().split(",");
        String[] retailPrice2=stock.getRetailPrice().split(",");
        String[] unit2=orderDO.getUnit().split(",");
        String[] useday2=orderDO.getUseday().split(",");
        String[] batch2=orderDO.getBatch().split(",");
        String[] zhuceNumber2=orderDO.getZhuceNumber().split(",");
        String[] produceDay2=orderDO.getProduceDay().split(",");
        String[] status2=orderDO.getStatus().split(",");
        String[] username2=orderDO.getUsername().split(",");
        String[] classtype2=orderDO.getClasstype().split(",");
        String[] factory2=orderDO.getFactory().split(",");
        String[] goodsxinxiid2=orderDO.getGoodsxinxiid().toString().split(",");

        for (int i = 0; i < namesOrder2.length; i++) {
            OrderDO orderDO1 = new OrderDO();
            String goodsNum = name[i];
            orderDO1.setGoodsNum(goodsNum);
            String goodsCode = goodsCode2[i];
            orderDO1.setGoodsCode(goodsCode);
            String goodsName = goodsName2[i];
            orderDO1.setGoodsName(goodsName);
            String brandname = brandname2[i];
            orderDO1.setBrandname(brandname);
            String goodsCount = goodsCount2[i];
            orderDO1.setGoodsCount(goodsCount);
            orderDO1.setGoodsType(orderDO.getGoodsType());
            orderDO1.setMfrsid(orderDO.getMfrsid());
            String costPrice = costPrice2[i];
            orderDO1.setCostPrice(costPrice); //成本价格

            Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodsCount);
            orderDO1.setCostSum(Double.toString(costSum)); //成本合计

            String wholePrice = wholePrice2[i];
            orderDO1.setWholePrice(wholePrice);
            Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodsCount);
            orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计

//            String transferPrice = stock.getTransferPrice().split(",")[i];
//            stockDO.setTransferPrice(transferPrice);
//            Double transferPricecount = Double.parseDouble(transferPrice) * Double.parseDouble(goodsCount);
//            stockDO.setCostSum(Double.toString(transferPricecount));

            String retailPrice = retailPrice2[i];
            orderDO1.setRetailPrice(retailPrice);
            Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodsCount);
            orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计

            orderDO1.setPositionId(orderDO.getPositionId());
            orderDO1.setPositionName(orderDO.getPositionName());
            orderDO1.setCreateTime(orderDO.getCreateTime());
            orderDO1.setDanjuNumber(orderDO.getDanjuNumber());
            orderDO1.setOrderNumber(orderDO.getOrderNumber());
            orderDO1.setYundanNumber(orderDO.getYundanNumber());
            orderDO1.setZhidanPeople(orderDO.getZhidanPeople());
            orderDO1.setDanjuDay(orderDO.getDanjuDay());
            orderDO1.setTuihuoNumber(orderDO.getTuihuoNumber());
            orderDO1.setFactoryNumber(orderDO.getFactoryNumber());
            orderDO1.setBeizhu(orderDO.getBeizhu());
            orderDO1.setReturnzt(orderDO.getReturnzt());
            String unit = unit2[i];
            orderDO1.setUnit(unit);
            String useday = useday2[i];
            orderDO1.setUseday(useday);
            String batch = batch2[i];
            orderDO1.setBatch(batch);
            String zhuceNumber = zhuceNumber2[i];
            orderDO1.setZhuceNumber(zhuceNumber);
            String produceDay = produceDay2[i];
            orderDO1.setProduceDay(produceDay);
            String status = status2[i];
            orderDO1.setStatus(status);
            String username =username2 [i];
            orderDO1.setUsername(username);
            String goodsxinxiid11 =goodsxinxiid1 [i];
            orderDO1.setGoodsxinxiid(Long.valueOf(goodsxinxiid11));
            if(null != orderDO.getClasstype()){
                String classtype = classtype2[i];
                orderDO1.setClasstype(classtype);
            }else{
                orderDO1.setClasstype("");
            }
           if(null != orderDO.getFactory()) {
               String factory = factory2 [i];
               orderDO1.setFactory(factory);
           }else {
               orderDO1.setFactory("");
           }

            orderService.save(orderDO1);
        }
        return R.ok();
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

        //商品类别
        Map<String, Object> map = new HashMap<>();
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        model.addAttribute("goodsid", goodsid);
        return "/mfrs/mfrs/stockGetMfrs";
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
                                         Integer mfrsid, Integer brandid,String brandname,
                                         String producFactorycolor, String size, Integer materialid,
                                         Integer technologyId, String producFactory, String factory,
                                         String retailPrice, String retailPrice2,
                                         Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactorycolor", producFactorycolor);
        map.put("sizes", size);
        map.put("materialid", materialid);
        map.put("technologyId", technologyId);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
                                       Integer mfrsid, Integer brandid,String brandname,
                                       String partsStyle, String producFactory, String factory,
                                       String retailPrice, String retailPrice2,
                                       Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("partsStyle", partsStyle);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
        Map<String, Object> map = new HashMap<>();
        //材料分类
        List<LensDO> lensDOList = lensService.list(map);
        model.addAttribute("lensDOList", lensDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //渐进片分类
        List<GradualDO> gradualDOList = gradualService.list(map);
        model.addAttribute("gradualDOList", gradualDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);


        return "/stock/stock/jingpian";
    }

    //镜片List-----------成品
    @ResponseBody
    @RequestMapping(value = "/selectJpcp")
    public List<JpcpDO> selectJpcp(Integer mfrsid,String producNum, String producCode, String producName,
                                   Integer brandid,String brandname, Integer lensId,Integer refractivityid,Integer gradualId,
                                   Integer lightId,Integer functionId, String factory,String retailPrice,String retailPrice2,
                                   Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("lensId", lensId);
        map.put("refractivityid", refractivityid);
        map.put("lightId", lightId);
        map.put("functionId", functionId);
        map.put("gradualId", gradualId);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        List<JpcpDO> jpcpDOList = stockService.selectJpcp(map);
        model.addAttribute("jpcpDOList", jpcpDOList);
        return jpcpDOList;
    }

    //镜片List-----------定做
    @ResponseBody
    @RequestMapping(value = "/selectJpdz")
    public List<JpdzDO> selectJpdz(Integer mfrsid,String producNum, String producCode, String producName,
                                   Integer brandid,String brandname, Integer lensId,Integer refractivityid,Integer gradualId,
                                   Integer lightId,Integer functionId, String factory,String retailPrice,String retailPrice2,
                                   Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("lensId", lensId);
        map.put("refractivityid", refractivityid);
        map.put("lightId", lightId);
        map.put("functionId", functionId);
        map.put("gradualId", gradualId);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        List<JpdzDO> jpdzDOList = stockService.selectJpdz(map);
        model.addAttribute("jpdzDOList", jpdzDOList);
        return jpdzDOList;
    }
    //跳转隐形商品查询
    @GetMapping("/yinxing/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:yinxing")
    String yinxing(@PathVariable("mfrsid") Integer mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        Map<String, Object> map = new HashMap<>();
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        return "/stock/stock/yinxing";
    }

    //隐形List-----------成品
    @ResponseBody
    @RequestMapping(value = "/selectYxcp")
    public List<YxcpDO> selectYxcp(Integer mfrsid,String producNum, String producCode, String producName,
                                   Integer brandid,String brandname,String producFactory,String factory,
                                   String retailPrice,String retailPrice2,Integer usageId,Integer typeId,
                                   Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        map.put("usageId", usageId);
        map.put("typeId", typeId);
        List<YxcpDO> yxcpDOList = stockService.selectYxcp(map);
        model.addAttribute("yxcpDOList", yxcpDOList);
        return yxcpDOList;
    }

    //隐形List-----------定做
    @ResponseBody
    @RequestMapping(value = "/selectYxdz")
    public List<YxdzDO> selectYxdz(Integer mfrsid,String producNum, String producCode, String producName,
                                   Integer brandid,String brandname,String producFactory,String factory,
                                   String retailPrice,String retailPrice2,Integer usageId,Integer typeId,
                                   Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        map.put("usageId", usageId);
        map.put("typeId", typeId);
        List<YxdzDO> yxdzDOList = stockService.selectYxdz(map);
        model.addAttribute("yxdzDOList", yxdzDOList);
        return yxdzDOList;
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
    public List<HlyDO> selectHly(String producNum, String producCode, String producName,String brandname,
                                 Integer mfrsid, Integer brandid, String mainCapacity, String secondCapacity,
                                 String producFactory, String factory,String retailPrice,String retailPrice2,
                                 Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("mainCapacity", mainCapacity);
        map.put("secondCapacity", secondCapacity);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
                                 String brandname, Integer mfrsid, Integer brandid, String producFactorycolor, String size,
                                 String producFactory, String factory,String retailPrice,String retailPrice2,
                                 Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactorycolor", producFactorycolor);
        map.put("size", size);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
        //老花镜度数
        Map<String, Object> map = new HashMap<>();
        List<OlddegreesDO> olddegreesDOList = olddegreesService.list(map);
        model.addAttribute("olddegreesDOList", olddegreesDOList);
        return "/stock/stock/lhj";
    }

    //老花镜
    @ResponseBody
    @RequestMapping(value = "/selectLhj")
    public List<OldlensDO> selectLhj(String producNum, String producCode, String producName,
                                     Integer mfrsid, Integer brandid,String brandname,
                                     String producFactorycolor, String size,Integer oldId,
                                     String producFactory, String factory,String retailPrice,String retailPrice2,
                                     Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactorycolor", producFactorycolor);
        map.put("size", size);
        map.put("oldId", oldId);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
    public List<HcDO> selectHc(String producNum, String producCode, String producName,
                               Integer mfrsid, Integer brandid,String brandname,String retailPrice,String retailPrice2,
                               String producFactory, String factory, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
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
    public List<ShiguangDO> selectSg(String producNum, String producCode, String producName,
                                     Integer mfrsid, Integer brandid,String brandname,String retailPrice,String retailPrice2,
                                     String producFactory, String factory, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("producNum", producNum);
        map.put("producCode", producCode);
        map.put("producName", producName);
        map.put("mfrsid", mfrsid);
        map.put("brandid", brandid);
        map.put("brandname", brandname);
        map.put("producFactory", producFactory);
        map.put("factory", factory);
        map.put("retailPrice", retailPrice);
        map.put("retailPrice2", retailPrice2);
        List<ShiguangDO> shiguangDOS = stockService.selectSg(map);
        model.addAttribute("shiguangDOS", shiguangDOS);
        return shiguangDOS;
    }


    /**
     * 浏览器打印二维码
     */
    @GetMapping("/code")
    public String code(String danjuNumber, Model model) {
//        OrderDO  orderDO = Optional.ofNullable(orderService.getCode(danjuNumber)).orElseGet(OrderDO::new);
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber",danjuNumber);
        List<OrderDO> orderDOS = orderService.getCode(map);
        model.addAttribute("orderDOS", orderDOS);
        for (OrderDO orderDO1 : orderDOS){
//            String code = BarCodeUtils.generateBarCode128(orderDO1.getGoodsCode(), 10.0, 0.3, true, true);//条形码
            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            orderDO1.setQRCode(code);
        }
        // model.addAttribute("QRCode", "data:image/png;base64," + code);
        return "/stock/stock/code";
    }

}
