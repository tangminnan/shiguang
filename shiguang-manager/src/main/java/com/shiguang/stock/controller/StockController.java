package com.shiguang.stock.controller;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.OlddegreesService;
import com.shiguang.product.service.ProducaService;
import com.shiguang.product.service.TechnologyService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.OrderService;
import com.shiguang.stock.service.StockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    private Double retailPrice;
    private Double retailPrice2;
    @GetMapping()
    @RequiresPermissions("stock:stock:stock")
    String Stock(Model model) {
        Map<String, Object> map = new HashMap<>();
//        //商品
//        List<GoodsDO> goodsDOList = goodsService.list(map);
//        model.addAttribute("goodsDOList", goodsDOList);
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            if(ShiroUtils.getUser().getCompanyId().equals("3")){
                query.put("companyId","");
            }else {
                query.put("companyId",ShiroUtils.getUser().getCompanyId());
            }


        }
       Object gdname=query.get("goodsid");
        if ("镜架".equals(gdname)){
            query.put("goodsid",1);
            query.put("classtype","1");
        }else if ("配件".equals(gdname)){
            query.put("goodsid",2);
            query.put("classtype","1");
        }else if ("镜片".equals(gdname)){
            query.put("goodsid",3);
            query.put("classtype","1");
        }else if ("订做镜片".equals(gdname)){
            query.put("goodsid",3);
            query.put("classtype","2");
        }else if ("隐形".equals(gdname)){
            query.put("goodsid",4);
            query.put("classtype","1");
        }else if ("订做隐形".equals(gdname)){
            query.put("goodsid",4);
            query.put("classtype","2");
        }else if ("护理液".equals(gdname)){
            query.put("goodsid",5);
            query.put("classtype","1");
        }else if ("太阳镜".equals(gdname)){
            query.put("goodsid",6);
            query.put("classtype","1");
        }else if ("老花镜".equals(gdname)){
            query.put("goodsid",7);
            query.put("classtype","1");
        }else if ("耗材".equals(gdname)){
            query.put("goodsid",8);
            query.put("classtype","1");
        }else if ("视光".equals(gdname)) {
            query.put("goodsid",9);
            query.put("classtype","1");
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        map.put("positionOrder","2");
        map.put("xsstate","0");
        map.put("state","1");
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




///采购详情页面
    @GetMapping("/detial/{id}")
    @RequiresPermissions("stock:stock:detial")
    String detial(@PathVariable("id") Long id, Model model) {
        OrderDO orderDO = orderService.get(id);
        model.addAttribute("orderDO", orderDO);
        String danjuDay = orderDO.getDanjuDay();
        model.addAttribute("danjuDay", danjuDay);
        return "stock/stock/detial";
    }

    ///采购详情列表
    @ResponseBody
    @RequestMapping(value = "/selectOrder")
    public List<OrderDO> selectOrder(String danjuNumber, Integer goodsType,Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("goodsType", goodsType);
        List<OrderDO> orderDOList = orderService.selectOrder(map);
        model.addAttribute("orderDOList", orderDOList);
        return orderDOList;
    }
//    //总数量
    @ResponseBody
    @GetMapping("/countall")
    public Integer countall(
            @RequestParam("goodsType") String goodsType,
            @RequestParam("danjuNumber") String danjuNumber,
            Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsType",goodsType);
        map.put("danjuNumber",danjuNumber);
        int total=orderService.countall(map);
        model.addAttribute("total",total);
        return total;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:stock:add")
    public R save(StockDO stock, OrderDO orderDO) {
        String[] counts =stock.getGoodsCount().split(",");
        String[] num =stock.getGoodsNum().split(",");
        String count;
        for (int i=0; i<num.length;i++){
            try {
                count = counts[i];
            }catch (ArrayIndexOutOfBoundsException e){
                count="";
            }
            if ("".equals(count)){
                return R.error("数量不能为空！");
            }
        }

        String strOrder = stock.getGoodsNum();
        String[] numOrder2 = strOrder.split(",");
        String[] goodsCode2=orderDO.getGoodsCode().split(",");
        String[] goodsName2=orderDO.getGoodsName().split(",");
        String[] brandname2=orderDO.getBrandname().split(",");
        String[] goodsCount2=orderDO.getGoodsCount().split(",");
        String[] costPrice2=orderDO.getCostPrice().split(",");
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
//        String[] goodsxinxiid2=orderDO.getGoodsxinxiid().toString().split(",");
        String[] createTime2=stock.getCreateTime().toString().split(",");
        for (int i = 0; i < numOrder2.length; i++) {
            OrderDO orderDO1 = new OrderDO();
            String goodsNum = numOrder2[i];
            orderDO1.setGoodsNum(goodsNum);

            try {
                String goodsCode = goodsCode2[i];
                orderDO1.setGoodsCode(goodsCode);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setGoodsCode("");
            }
             try {
                 String goodsName = goodsName2[i];
                 orderDO1.setGoodsName(goodsName);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setGoodsName("");
            }
             try {
                 String brandname = brandname2[i];
                 orderDO1.setBrandname(brandname);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setBrandname("");
            }

             try {
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
                 String retailPrice = retailPrice2[i];
                 orderDO1.setRetailPrice(retailPrice);
                 Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodsCount);
                 orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setGoodsCount("");
                orderDO1.setCostPrice("");
                orderDO1.setCostSum("");
                orderDO1.setWholePrice("");
                orderDO1.setWholeSum("");
                orderDO1.setRetailPrice("");
                orderDO1.setPriceSum("");
            }

            orderDO1.setPositionId(orderDO.getPositionId());
            orderDO1.setPositionName(orderDO.getPositionName());
            try {
                String createTime = createTime2[i];
                orderDO1.setCreateTime(createTime);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setCreateTime("");
            }
            orderDO1.setDanjuNumber(orderDO.getDanjuNumber());
            orderDO1.setOrderNumber(orderDO.getOrderNumber());
            orderDO1.setYundanNumber(orderDO.getYundanNumber());
            orderDO1.setZhidanPeople(orderDO.getZhidanPeople());
            orderDO1.setDanjuDay(orderDO.getDanjuDay());
            orderDO1.setTuihuoNumber(orderDO.getTuihuoNumber());
            orderDO1.setFactoryNumber(orderDO.getFactoryNumber());
            orderDO1.setBeizhu(orderDO.getBeizhu());
            orderDO1.setReturnzt(orderDO.getReturnzt());

            try {
                String unit = unit2[i];
                orderDO1.setUnit(unit);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setUnit("");
            }
             try {
                 String useday = useday2[i];
                 orderDO1.setUseday(useday);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setUseday("");
            }
             try {
                 String batch = batch2[i];
                 orderDO1.setBatch(batch);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setBatch("");
            }

           try {
               String zhuceNumber = zhuceNumber2[i];
               orderDO1.setZhuceNumber(zhuceNumber);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setZhuceNumber("");
            }
            try {
                String produceDay = produceDay2[i];
                orderDO1.setProduceDay(produceDay);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setProduceDay("");
            }
            try {
                String status = status2[0];
                orderDO1.setStatus(status);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setStatus("");
            }
            try {
                String username =username2 [0];
                orderDO1.setUsername(username);
            }catch (ArrayIndexOutOfBoundsException e){
                orderDO1.setUsername("");
            }
//            try {
//                String goodsxinxiid =goodsxinxiid2 [i];
//                orderDO1.setGoodsxinxiid(goodsxinxiid);
//            }catch (ArrayIndexOutOfBoundsException e){
//                orderDO1.setGoodsxinxiid("");
//            }

            if(null != orderDO.getClasstype()){
                try {
                    String classtype = classtype2[i];
                    orderDO1.setClasstype(classtype);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setClasstype("");
                }
            }else{
                orderDO1.setClasstype("");
            }

           if(null != orderDO.getFactory()) {
               try {
                   String factory = factory2 [i];
                   orderDO1.setFactory(factory);
               }catch (ArrayIndexOutOfBoundsException e){
                   orderDO1.setFactory("");
               }

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
    @GetMapping("/edit/{id}")
    @RequiresPermissions("stock:stock:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        OrderDO orderDO = orderService.get(id);
        model.addAttribute("orderDO", orderDO);
        String danjuDay = orderDO.getDanjuDay();
        model.addAttribute("danjuDay", danjuDay);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("createTime", newDate);
        return "stock/stock/edit";
    }

    /**
     * 修改保存
     */
    @ResponseBody
    @PostMapping("/editSave")
    public R editSave(StockDO stock, OrderDO orderDO) {
        String[] goodsNums=orderDO.getGoodsNum().split(",");
        String[] goodCounts=orderDO.getGoodsCount().split(",");

        String count;
        for (int i=0; i<goodsNums.length;i++){
            try {
                count = goodCounts[i];
            }catch (ArrayIndexOutOfBoundsException e){
                count="";
            }
            if ("".equals(count)){
                return R.error("数量不能为空！");
            }
        }

        Map<String,Object> editmap=new HashMap<>();
        String danjuNumber=orderDO.getDanjuNumber();
        editmap.put("danjuNumber",danjuNumber);
        List<OrderDO> orderDOList=orderService.haveOrderNum(editmap);
        for (OrderDO orderDO1:orderDOList){
            Long ids=orderDO1.getId();
            orderService.remove(ids);
        }

        OrderDO orderDO1=new OrderDO();
        Integer goodsid=orderDO.getGoodsType();
        orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//1
        orderDO1.setOrderNumber(orderDO.getOrderNumber());
        orderDO1.setYundanNumber(orderDO.getYundanNumber());
        orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//2
        orderDO1.setDanjuDay(orderDO.getDanjuDay());
        orderDO1.setTuihuoNumber(orderDO.getTuihuoNumber());
        orderDO1.setFactoryNumber(orderDO.getFactoryNumber());
        orderDO1.setBeizhu(orderDO.getBeizhu());
        orderDO1.setReturnzt(orderDO.getReturnzt());

        String[] goodsCodes=orderDO.getGoodsCode().split(",");
        String[] goodsNames=orderDO.getGoodsName().split(",");
        String[] usedays=orderDO.getUseday().split(",");
        String[] batchs=orderDO.getBatch().split(",");
        String[] produceDays=orderDO.getProduceDay().split(",");

        String[] createTimes=orderDO.getCreateTime().split(",");

        String styles=orderDO.getStyles();
        if (Integer.valueOf(1).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                   String num=goodsNums[index];
                   StockDO stockDO=new StockDO();
                   stockDO.setGoodsNum(num);
                   StockDO jingjias=  stockService.jingjias(stockDO);
                   String mfrsid=jingjias.getMfrsid();
                   String brandname=jingjias.getBrandname();
                   String unitname=jingjias.getUnitname();
                   String factory=jingjias.getProducFactory();
                   String classtype=jingjias.getClasstype();

                   orderDO1.setPositionId(orderDO.getPositionId());//15
                   orderDO1.setGoodsType(goodsid);//5
                   orderDO1.setGoodsNum(goodsNums[index]);//1
                   orderDO1.setGoodsCode(goodsCodes[index]);//2
                   orderDO1.setGoodsName(goodsNames[index]);//3
                   orderDO1.setBrandname(brandname);//7
                   orderDO1.setUnit(unitname);//8
                   orderDO1.setMfrsid(mfrsid);//6

                   //数量
                   orderDO1.setGoodsCount(goodCounts[index]);//4
                   String retailPrice=jingjias.getRetailPrice();
                   orderDO1.setRetailPrice(retailPrice);//9
                   Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                   orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                   String costPrice = jingjias.getTaxPrice();
                   orderDO1.setCostPrice(costPrice); //成本价格11
                   Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                   orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                   String wholePrice = jingjias.getTradePrice();
                   orderDO1.setWholePrice(wholePrice);//13
                   Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                   orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                   orderDO1.setCreateTime(createTimes[index]);//16
                   orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                   orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                   orderDO1.setDanjuDay(createTimes[index]);//19
                   orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                   orderDO1.setZhuceNumber(jingjias.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                   //类型
                   orderDO1.setClasstype(classtype);
                   //型号
                   orderDO1.setFactory(factory);
                   orderDO1.setStatus(orderDO.getStatus());
                   orderDO1.setUsername(orderDO.getUsername());
                   orderDO1.setReturnzt(orderDO.getReturnzt());
                   orderDO1.setStockorder(orderDO.getStockorder());
                   orderService.save(orderDO1);
               }



        }else if (Integer.valueOf(2).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO peijians=  stockService.peijians(stockDO);
                String mfrsid=peijians.getMfrsid();
                String brandname=peijians.getBrandname();
                String unitname=peijians.getUnitname();
                String factory=peijians.getProducFactory();
                String classtype=peijians.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=peijians.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = peijians.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = peijians.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(peijians.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }else if (Integer.valueOf(3).equals(goodsid)){
            if ("1".equals(styles)){
                for(int index=0;index<goodsNums.length;index++){
                    String num=goodsNums[index];
                    StockDO stockDO=new StockDO();
                    stockDO.setGoodsNum(num);
                    StockDO jingpians=  stockService.jingpians(stockDO);
                    String mfrsid=jingpians.getMfrsid();
                    String brandname=jingpians.getBrandname();
                    String unitname=jingpians.getUnitname();
                    String factory=jingpians.getProducFactory();
                    String classtype=jingpians.getClasstype();

                    orderDO1.setPositionId(orderDO.getPositionId());//15
                    orderDO1.setGoodsType(goodsid);//5
                    orderDO1.setGoodsNum(goodsNums[index]);//1
                    orderDO1.setGoodsCode(goodsCodes[index]);//2
                    orderDO1.setGoodsName(goodsNames[index]);//3
                    orderDO1.setBrandname(brandname);//7
                    orderDO1.setUnit(unitname);//8
                    orderDO1.setMfrsid(mfrsid);//6

                    //数量
                    orderDO1.setGoodsCount(goodCounts[index]);//4
                    String retailPrice=jingpians.getRetailPrice();
                    orderDO1.setRetailPrice(retailPrice);//9
                    Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                    String costPrice = jingpians.getTaxPrice();
                    orderDO1.setCostPrice(costPrice); //成本价格11
                    Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                    String wholePrice = jingpians.getTradePrice();
                    orderDO1.setWholePrice(wholePrice);//13
                    Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                    orderDO1.setCreateTime(createTimes[index]);//16
                    orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                    orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                    orderDO1.setDanjuDay(createTimes[index]);//19
                    orderDO1.setBeizhu(orderDO.getBeizhu());//19

                    try { //20批号
                        String batch = batchs[index];
                        orderDO1.setBatch(batch);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setBatch("");
                    }

                    orderDO1.setZhuceNumber(jingpians.getZhuceNumber());//21注册

                    try {//22生产
                        String produceDay = produceDays[index];
                        orderDO1.setProduceDay(produceDay);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setProduceDay("");
                    }


                    try {//23效期
                        String useday = usedays[index];
                        orderDO1.setUseday(useday);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setUseday("");
                    }

                    //类型
                    orderDO1.setClasstype(classtype);
                    //型号
                    orderDO1.setFactory(factory);
                    orderDO1.setStatus(orderDO.getStatus());
                    orderDO1.setUsername(orderDO.getUsername());
                    orderDO1.setReturnzt(orderDO.getReturnzt());
                    orderDO1.setStockorder(orderDO.getStockorder());
                    orderService.save(orderDO1);
                }
            }else if ("2".equals(styles)){
                for(int index=0;index<goodsNums.length;index++){
                    String num=goodsNums[index];
                    StockDO stockDO=new StockDO();
                    stockDO.setGoodsNum(num);
                    StockDO jingpiandzs=  stockService.jingpiandzs(stockDO);
                    String mfrsid=jingpiandzs.getMfrsid();
                    String brandname=jingpiandzs.getBrandname();
                    String unitname=jingpiandzs.getUnitname();
                    String factory=jingpiandzs.getProducFactory();
                    String classtype=jingpiandzs.getClasstype();

                    orderDO1.setPositionId(orderDO.getPositionId());//15
                    orderDO1.setGoodsType(goodsid);//5
                    orderDO1.setGoodsNum(goodsNums[index]);//1
                    orderDO1.setGoodsCode(goodsCodes[index]);//2
                    orderDO1.setGoodsName(goodsNames[index]);//3
                    orderDO1.setBrandname(brandname);//7
                    orderDO1.setUnit(unitname);//8
                    orderDO1.setMfrsid(mfrsid);//6

                    //数量
                    orderDO1.setGoodsCount(goodCounts[index]);//4
                    String retailPrice=jingpiandzs.getRetailPrice();
                    orderDO1.setRetailPrice(retailPrice);//9
                    Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                    String costPrice = jingpiandzs.getTaxPrice();
                    orderDO1.setCostPrice(costPrice); //成本价格11
                    Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                    String wholePrice = jingpiandzs.getTradePrice();
                    orderDO1.setWholePrice(wholePrice);//13
                    Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                    orderDO1.setCreateTime(createTimes[index]);//16
                    orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                    orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                    orderDO1.setDanjuDay(createTimes[index]);//19
                    orderDO1.setBeizhu(orderDO.getBeizhu());//19

                    try { //20批号
                        String batch = batchs[index];
                        orderDO1.setBatch(batch);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setBatch("");
                    }

                    orderDO1.setZhuceNumber(jingpiandzs.getZhuceNumber());//21注册

                    try {//22生产
                        String produceDay = produceDays[index];
                        orderDO1.setProduceDay(produceDay);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setProduceDay("");
                    }


                    try {//23效期
                        String useday = usedays[index];
                        orderDO1.setUseday(useday);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setUseday("");
                    }

                    //类型
                    orderDO1.setClasstype(classtype);
                    //型号
                    orderDO1.setFactory(factory);
                    orderDO1.setStatus(orderDO.getStatus());
                    orderDO1.setUsername(orderDO.getUsername());
                    orderDO1.setReturnzt(orderDO.getReturnzt());
                    orderDO1.setStockorder(orderDO.getStockorder());
                    orderService.save(orderDO1);
                }
            }

        }else if (Integer.valueOf(4).equals(goodsid)){
            if ("1".equals(styles)){
                for(int index=0;index<goodsNums.length;index++){
                    String num=goodsNums[index];
                    StockDO stockDO=new StockDO();
                    stockDO.setGoodsNum(num);
                    StockDO yinxings=  stockService.yinxings(stockDO);
                    String mfrsid=yinxings.getMfrsid();
                    String brandname=yinxings.getBrandname();
                    String unitname=yinxings.getUnitname();
                    String factory=yinxings.getProducFactory();
                    String classtype=yinxings.getClasstype();

                    orderDO1.setPositionId(orderDO.getPositionId());//15
                    orderDO1.setGoodsType(goodsid);//5
                    orderDO1.setGoodsNum(goodsNums[index]);//1
                    orderDO1.setGoodsCode(goodsCodes[index]);//2
                    orderDO1.setGoodsName(goodsNames[index]);//3
                    orderDO1.setBrandname(brandname);//7
                    orderDO1.setUnit(unitname);//8
                    orderDO1.setMfrsid(mfrsid);//6

                    //数量
                    orderDO1.setGoodsCount(goodCounts[index]);//4
                    String retailPrice=yinxings.getRetailPrice();
                    orderDO1.setRetailPrice(retailPrice);//9
                    Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                    String costPrice = yinxings.getTaxPrice();
                    orderDO1.setCostPrice(costPrice); //成本价格11
                    Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                    String wholePrice = yinxings.getTradePrice();
                    orderDO1.setWholePrice(wholePrice);//13
                    Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                    orderDO1.setCreateTime(createTimes[index]);//16
                    orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                    orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                    orderDO1.setDanjuDay(createTimes[index]);//19
                    orderDO1.setBeizhu(orderDO.getBeizhu());//19

                    try { //20批号
                        String batch = batchs[index];
                        orderDO1.setBatch(batch);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setBatch("");
                    }

                    orderDO1.setZhuceNumber(yinxings.getZhuceNumber());//21注册

                    try {//22生产
                        String produceDay = produceDays[index];
                        orderDO1.setProduceDay(produceDay);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setProduceDay("");
                    }


                    try {//23效期
                        String useday = usedays[index];
                        orderDO1.setUseday(useday);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setUseday("");
                    }

                    //类型
                    orderDO1.setClasstype(classtype);
                    //型号
                    orderDO1.setFactory(factory);
                    orderDO1.setStatus(orderDO.getStatus());
                    orderDO1.setUsername(orderDO.getUsername());
                    orderDO1.setReturnzt(orderDO.getReturnzt());
                    orderDO1.setStockorder(orderDO.getStockorder());
                    orderService.save(orderDO1);
                }
            }else if ("2".equals(styles)){
                for(int index=0;index<goodsNums.length;index++){
                    String num=goodsNums[index];
                    StockDO stockDO=new StockDO();
                    stockDO.setGoodsNum(num);
                    StockDO yinxingdzs=  stockService.yinxingdzs(stockDO);
                    String mfrsid=yinxingdzs.getMfrsid();
                    String brandname=yinxingdzs.getBrandname();
                    String unitname=yinxingdzs.getUnitname();
                    String factory=yinxingdzs.getProducFactory();
                    String classtype=yinxingdzs.getClasstype();

                    orderDO1.setPositionId(orderDO.getPositionId());//15
                    orderDO1.setGoodsType(goodsid);//5
                    orderDO1.setGoodsNum(goodsNums[index]);//1
                    orderDO1.setGoodsCode(goodsCodes[index]);//2
                    orderDO1.setGoodsName(goodsNames[index]);//3
                    orderDO1.setBrandname(brandname);//7
                    orderDO1.setUnit(unitname);//8
                    orderDO1.setMfrsid(mfrsid);//6

                    //数量
                    orderDO1.setGoodsCount(goodCounts[index]);//4
                    String retailPrice=yinxingdzs.getRetailPrice();
                    orderDO1.setRetailPrice(retailPrice);//9
                    Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                    String costPrice = yinxingdzs.getTaxPrice();
                    orderDO1.setCostPrice(costPrice); //成本价格11
                    Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                    String wholePrice = yinxingdzs.getTradePrice();
                    orderDO1.setWholePrice(wholePrice);//13
                    Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                    orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                    orderDO1.setCreateTime(createTimes[index]);//16
                    orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                    orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                    orderDO1.setDanjuDay(createTimes[index]);//19
                    orderDO1.setBeizhu(orderDO.getBeizhu());//19

                    try { //20批号
                        String batch = batchs[index];
                        orderDO1.setBatch(batch);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setBatch("");
                    }

                    orderDO1.setZhuceNumber(yinxingdzs.getZhuceNumber());//21注册

                    try {//22生产
                        String produceDay = produceDays[index];
                        orderDO1.setProduceDay(produceDay);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setProduceDay("");
                    }


                    try {//23效期
                        String useday = usedays[index];
                        orderDO1.setUseday(useday);
                    }catch (ArrayIndexOutOfBoundsException e){
                        orderDO1.setUseday("");
                    }

                    //类型
                    orderDO1.setClasstype(classtype);
                    //型号
                    orderDO1.setFactory(factory);
                    orderDO1.setStatus(orderDO.getStatus());
                    orderDO1.setUsername(orderDO.getUsername());
                    orderDO1.setReturnzt(orderDO.getReturnzt());
                    orderDO1.setStockorder(orderDO.getStockorder());
                    orderService.save(orderDO1);
                }
            }

        }else if (Integer.valueOf(5).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO huliyes=  stockService.huliyes(stockDO);
                String mfrsid=huliyes.getMfrsid();
                String brandname=huliyes.getBrandname();
                String unitname=huliyes.getUnitname();
                String factory=huliyes.getProducFactory();
                String classtype=huliyes.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=huliyes.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = huliyes.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = huliyes.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(huliyes.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }else if (Integer.valueOf(6).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO taiyangjings=  stockService.taiyangjings(stockDO);
                String mfrsid=taiyangjings.getMfrsid();
                String brandname=taiyangjings.getBrandname();
                String unitname=taiyangjings.getUnitname();
                String factory=taiyangjings.getProducFactory();
                String classtype=taiyangjings.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=taiyangjings.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = taiyangjings.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = taiyangjings.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(taiyangjings.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }else if (Integer.valueOf(7).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO laohuajings=  stockService.laohuajings(stockDO);
                String mfrsid=laohuajings.getMfrsid();
                String brandname=laohuajings.getBrandname();
                String unitname=laohuajings.getUnitname();
                String factory=laohuajings.getProducFactory();
                String classtype=laohuajings.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=laohuajings.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = laohuajings.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = laohuajings.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(laohuajings.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }else if (Integer.valueOf(8).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO haocais=  stockService.haocais(stockDO);
                String mfrsid=haocais.getMfrsid();
                String brandname=haocais.getBrandname();
                String unitname=haocais.getUnitname();
                String factory=haocais.getProducFactory();
                String classtype=haocais.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=haocais.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = haocais.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = haocais.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(haocais.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }else if (Integer.valueOf(9).equals(goodsid)){
            for(int index=0;index<goodsNums.length;index++){
                String num=goodsNums[index];
                StockDO stockDO=new StockDO();
                stockDO.setGoodsNum(num);
                StockDO shiguangs=  stockService.shiguangs(stockDO);
                String mfrsid=shiguangs.getMfrsid();
                String brandname=shiguangs.getBrandname();
                String unitname=shiguangs.getUnitname();
                String factory=shiguangs.getProducFactory();
                String classtype=shiguangs.getClasstype();

                orderDO1.setPositionId(orderDO.getPositionId());//15
                orderDO1.setGoodsType(goodsid);//5
                orderDO1.setGoodsNum(goodsNums[index]);//1
                orderDO1.setGoodsCode(goodsCodes[index]);//2
                orderDO1.setGoodsName(goodsNames[index]);//3
                orderDO1.setBrandname(brandname);//7
                orderDO1.setUnit(unitname);//8
                orderDO1.setMfrsid(mfrsid);//6

                //数量
                orderDO1.setGoodsCount(goodCounts[index]);//4
                String retailPrice=shiguangs.getRetailPrice();
                orderDO1.setRetailPrice(retailPrice);//9
                Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setPriceSum(Double.toString(priceSum));  //原价合计10
                String costPrice = shiguangs.getTaxPrice();
                orderDO1.setCostPrice(costPrice); //成本价格11
                Double costSum = Double.parseDouble(costPrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setCostSum(Double.toString(costSum)); //成本合计12
                String wholePrice = shiguangs.getTradePrice();
                orderDO1.setWholePrice(wholePrice);//13
                Double wholeSum = Double.parseDouble(wholePrice) * Double.parseDouble(goodCounts[index]);
                orderDO1.setWholeSum(Double.toString(wholeSum));    //批发合计14
                orderDO1.setCreateTime(createTimes[index]);//16
                orderDO1.setDanjuNumber(orderDO.getDanjuNumber());//17
                orderDO1.setZhidanPeople(orderDO.getZhidanPeople());//18
                orderDO1.setDanjuDay(createTimes[index]);//19
                orderDO1.setBeizhu(orderDO.getBeizhu());//19

                try { //20批号
                    String batch = batchs[index];
                    orderDO1.setBatch(batch);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setBatch("");
                }

                orderDO1.setZhuceNumber(shiguangs.getZhuceNumber());//21注册

                try {//22生产
                    String produceDay = produceDays[index];
                    orderDO1.setProduceDay(produceDay);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setProduceDay("");
                }


                try {//23效期
                    String useday = usedays[index];
                    orderDO1.setUseday(useday);
                }catch (ArrayIndexOutOfBoundsException e){
                    orderDO1.setUseday("");
                }

                //类型
                orderDO1.setClasstype(classtype);
                //型号
                orderDO1.setFactory(factory);
                orderDO1.setStatus(orderDO.getStatus());
                orderDO1.setUsername(orderDO.getUsername());
                orderDO1.setReturnzt(orderDO.getReturnzt());
                orderDO1.setStockorder(orderDO.getStockorder());
                orderService.save(orderDO1);
            }
        }




        return R.ok();
    }






    /**
     * 删除采购订单
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("stock:stock:remove")
    public R remove(Long id ) {
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
       List<OrderDO> orderDOS= orderService.haveOrderNum(map);
        if (orderDOS!=null){
            for (OrderDO orderDO:orderDOS){
                String danjuNumber=orderDO.getDanjuNumber();
                Map<String,Object> map1=new HashMap<>();
                map1.put("danjuNumber",danjuNumber);
                List<OrderDO> orderDOList=orderService.haveOrderNum(map1);
                for (OrderDO orderDO1:orderDOList){
                    Long ids=orderDO1.getId();
                    orderService.remove(ids);
                }
                return R.ok();
            }
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
    String jingjia(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
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
    @RequestMapping("/selectjingjia")
    public PageUtils selectjingjia(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);


        List<ProducaDO> producaDOList = stockService.selectJingjia(query);
        int total = stockService.selectJingjiaCount(query);
        PageUtils pageUtils = new PageUtils(producaDOList, total);
        return pageUtils;
    }






    //跳转配件商品查询
    @GetMapping("/peijian/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:peijian")
    String peijian(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/peijian";
    }

    //配件List
    @ResponseBody
    @RequestMapping("/selectpeijian")
    public PageUtils selectpeijian(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);


        List<PartsDO> partsDOList = stockService.selectPeijian(query);
        int total = stockService.selectPeijianCount(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }
    //跳转镜片商品查询
    @GetMapping("/jingpian/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:jingpian")
    String jingpian(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
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
    //跳转镜片订做商品查询
    @GetMapping("/jpdz/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:jpdz")
    String jpdz(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
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
        return "/stock/stock/jpdz";
    }


    //镜片List-----------成品
    @ResponseBody
    @RequestMapping("/selectJpcp")
    public PageUtils selectJpcp(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);


        List<JpcpDO> jpcpDOList = stockService.selectJpcp(query);
        int total = stockService.selectJpcpCount(query);
        PageUtils pageUtils = new PageUtils(jpcpDOList, total);
        return pageUtils;

    }
   //镜片List-----------定做
    @ResponseBody
    @RequestMapping("/selectJpdz")
    public PageUtils selectJpdz(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<JpdzDO> jpdzDOList = stockService.selectJpdz(query);
        int total = stockService.selectJpdzCount(query);
        PageUtils pageUtils = new PageUtils(jpdzDOList, total);
        return pageUtils;
    }

    //跳转隐形商品查询
    @GetMapping("/yinxing/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:yinxing")
    String yinxing(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
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
    //跳转隐形订做商品查询
    @GetMapping("/yxdz/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:yxdz")
    String yxdz(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        Map<String, Object> map = new HashMap<>();
        //使用类型
        List<UsageDO> usageDOList = usageService.list(map);
        model.addAttribute("usageDOList", usageDOList);
        //抛弃类型分类
        List<TypeDO> typeDOList = typeService.list(map);
        model.addAttribute("typeDOList", typeDOList);
        return "/stock/stock/yxdz";
    }
    //隐形List-----------成品
    @ResponseBody
    @RequestMapping("/selectYxcp")
    public PageUtils selectYxcp(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<YxcpDO> yxcpDOList = stockService.selectYxcp(query);
        int total = stockService.selectYxcpCount(query);
        PageUtils pageUtils = new PageUtils(yxcpDOList, total);
        return pageUtils;
    }
    //隐形List-----------定做
    @ResponseBody
    @RequestMapping("/selectYxdz")
    public PageUtils selectYxdz(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<YxdzDO> yxdzDOList = stockService.selectYxdz(query);
        int total = stockService.selectYxdzCount(query);
        PageUtils pageUtils = new PageUtils(yxdzDOList, total);
        return pageUtils;
    }



    //跳转护理液商品查询
    @GetMapping("/hly/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:hly")
    String hly(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/hly";
    }
    //护理液
    @ResponseBody
    @RequestMapping("/selectHly")
    public PageUtils selectHly(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<HlyDO> hlyDOList = stockService.selectHly(query);
        int total = stockService.selectHlyCount(query);
        PageUtils pageUtils = new PageUtils(hlyDOList, total);
        return pageUtils;
    }


    //跳转太阳镜商品查询
    @GetMapping("/tyj/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:tyj")
    String tyj(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/tyj";
    }

    //太阳镜
    @ResponseBody
    @RequestMapping("/selectTyj")
    public PageUtils selectTyj(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<TyjDO> tyjDOList = stockService.selectTyj(query);
        int total = stockService.selectTyjCount(query);
        PageUtils pageUtils = new PageUtils(tyjDOList, total);
        return pageUtils;
    }



    //跳转老花镜商品查询
    @GetMapping("/lhj/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:lhj")
    String lhj(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
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
    @RequestMapping("/selectLhj")
    public PageUtils selectLhj(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<OldlensDO> oldlensDOS = stockService.selectLhj(query);
        int total = stockService.selectLhjCount(query);
        PageUtils pageUtils = new PageUtils(oldlensDOS, total);
        return pageUtils;
    }


    //跳转耗材商品查询
    @GetMapping("/hc/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:hc")
    String hc(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/hc";
    }

    //耗材
    @ResponseBody
    @RequestMapping("/selectHc")
    public PageUtils selectHc(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<HcDO> hcDOList = stockService.selectHc(query);
        int total = stockService.selectHcCount(query);
        PageUtils pageUtils = new PageUtils(hcDOList, total);
        return pageUtils;
    }

    //跳转视光商品查询
    @GetMapping("/sg/{mfrsid}/{mfrsname}")
    @RequiresPermissions("stock:stock:sg")
    String sg(@PathVariable("mfrsid") String mfrsid, @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/stock/sg";
    }

    //视光
    @ResponseBody
    @RequestMapping("/selectSg")
    public PageUtils selectSg(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        // 钱转换
        if (StringUtils.isNotBlank(params.get("retailPrice").toString()))
            retailPrice = Double.parseDouble(params.get("retailPrice").toString());
        if (StringUtils.isNotBlank(params.get("retailPrice2").toString()))
            retailPrice2 = Double.parseDouble(params.get("retailPrice2").toString());

        query.put("retailPrice", retailPrice);
        query.put("retailPrice2", retailPrice2);

        List<ShiguangDO> shiguangDOS = stockService.selectSg(query);
        int total = stockService.selectSgCount(query);
        PageUtils pageUtils = new PageUtils(shiguangDOS, total);
        return pageUtils;
    }

    /**
     * 浏览器打印二维码
     */
    @GetMapping("/codeJingjia")
    @RequiresPermissions("stock:stock:code")
    public String codeJingjia(String danjuNumber,Integer goodsType, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber",danjuNumber);
        List<OrderDO> orderDOS=null;
        if (goodsType==1){
            orderDOS = orderService.getCode(map);
        }else if (goodsType==6){
            orderDOS = orderService.gettyjCode(map);
        }
        model.addAttribute("orderDOS", orderDOS);
        for (OrderDO orderDO1 : orderDOS){
            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            orderDO1.setQRCode(code);
        }
        return "/stock/stock/codeJingjia";
    }
    /**
     * 浏览器打印二维码
     */
    @GetMapping("/code")
    @RequiresPermissions("stock:stock:code")
    public String code(String danjuNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber",danjuNumber);
        List<OrderDO> orderDOS = orderService.getCode(map);
        model.addAttribute("orderDOS", orderDOS);
        for (OrderDO orderDO1 : orderDOS){
            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            orderDO1.setQRCode(code);
        }
        return "/stock/stock/code";
    }

    /**
     * 浏览器打印二维码一个
     */
    @GetMapping("/codeJingjiaOne")
    public String codeJingjiaOne(String danjuNumber,String codeOne,Integer goodsType, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber",danjuNumber);
        map.put("codeOne",codeOne);
        List<OrderDO> orderDOS=null;
        if (goodsType==1){
            orderDOS = orderService.getCode(map);
        }else if (goodsType==6){
            orderDOS = orderService.gettyjCode(map);
        }
        model.addAttribute("orderDOS", orderDOS);
        for (OrderDO orderDO1 : orderDOS){
            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            orderDO1.setQRCode(code);
        }
        return "/stock/stock/codeJingjiaOne";
    }
    /**
     * 浏览器打印二维码一个
     */
    @GetMapping("/codeOne")
    public String codeOne(String danjuNumber,String codeOne, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber",danjuNumber);
        map.put("codeOne",codeOne);
        List<OrderDO> orderDOS = orderService.getCode(map);
        model.addAttribute("orderDOS", orderDOS);
        for (OrderDO orderDO1 : orderDOS){
            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
            code = "data:image/png;base64," + code;
            orderDO1.setQRCode(code);
        }
        return "/stock/stock/codeOne";
    }
    //打印订单
    @GetMapping("/dayinOrder")
    String dayinOrder(String danjuNumber, Model model) {
        OrderDO getOeder = stockService.getOeder(danjuNumber);
//        SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = getOeder.getDanjuDay();
//        String danjuDay = sdftime.format(time);
        String danjuDay=getOeder.getDanjuDay();
        model.addAttribute("danjuDay", danjuDay);
        model.addAttribute("getOeder", getOeder);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("newDate", newDate);
        return "/stock/stock/dayinOrder";
    }
//打印订单列表
    @ResponseBody
    @RequestMapping(value = "/getOederList")
    public List<OrderDO> getOederList(String danjuNumber, Integer goodsType,Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("goodsType", goodsType);
        List<OrderDO> orderDOList = stockService.getOederList(map);
        model.addAttribute("orderDOList", orderDOList);
        return orderDOList;
    }
    //打印收货
    @GetMapping("/shouhuoOrder")
    String shouhuoOrder(String danjuNumber, Model model) {
        OrderDO getShouhuo = stockService.getShouhuo(danjuNumber);
//        SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = getShouhuo.getDanjuDay();
//        String danjuDay = sdftime.format(time);
        String danjuDay = getShouhuo.getDanjuDay();
        model.addAttribute("danjuDay", danjuDay);
        model.addAttribute("getShouhuo", getShouhuo);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("newDate", newDate);
        return "/stock/stock/shouhuoOrder";
    }

    @ResponseBody
    @RequestMapping(value = "/getShouhuoList")
    public List<OrderDO> getShouhuoList(String danjuNumber, Integer goodsType,Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("goodsType", goodsType);
        List<OrderDO> shouhuoList = stockService.getShouhuoList(map);
        model.addAttribute("shouhuoList", shouhuoList);
        return shouhuoList;
    }





    //进入导入页面
    @GetMapping("/information/{checkType}")
    @RequiresPermissions("stock:stock:information")
    public String importtemplate(Model model, @PathVariable("checkType") String checkType) {
        model.addAttribute("checkType", checkType);
        Map<String, Object> map = new HashMap<>();
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        if (companyId == null) {
            String departNumber = ShiroUtils.getUser().getStoreNum();
            map.put("departNumber", departNumber);
        } else if (companyId != null) {
            map.put("companyId", companyId);
        }
        map.put("status", "0");
        //获取当前公司的所有仓位
        List<PositionDO> positionDOList = positionService.list(map);
        map.put("state", 1);
        model.addAttribute("positionDOList", positionDOList);
        //商品类别
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        if ("PU_TONG".equals(checkType)) {
            return "/stock/stock/importtemplate";
        }
        return null;
    }

    /**
     * 导入
     */
    @PostMapping("/importStock")
    @ResponseBody
//    @RequiresPermissions("information:member:member")
    public R importStock(Integer goodsType, String positionId,String checkType,String dzlx, MultipartFile file) {
        return stockService.importStock(goodsType,positionId, checkType,dzlx, file);

    }


    @GetMapping("/adddz")
    @RequiresPermissions("stock:stock:adddz")
    String adddz(Model model) {
        //———生成单据编号————
        Long uuid = GuuidUtil.getUUID();
        String uuidstr = "PIN" + uuid.toString();
        model.addAttribute("uuidstr", uuidstr);
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //———获取当前登录用户的公司id————
        //仓位
        //———获取当前登录用户的公司id————
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        map.put("positionOrder","2");
        map.put("xsstate","0");
        map.put("state","1");
        List<PositionDO> positionDOList = positionService.list(map);
        model.addAttribute("positionDOList", positionDOList);
        //———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("createTime", newDate);
        return "stock/stock/adddz";
    }
}
