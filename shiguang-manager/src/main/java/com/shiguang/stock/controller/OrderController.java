package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.StocklogDO;
import com.shiguang.stock.domain.StockqualifyDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.StocklogService;
import com.shiguang.stock.service.StockqualifyService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.service.OrderService;
import com.shiguang.common.utils.R;

/**
 * 采购订单表

 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-14 11:27:22
 */

@Controller
@RequestMapping("/stock/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockService stockService;
    @Autowired
    UserService userService;
    @Autowired
    private StocklogService stocklogService;
    @Autowired
    private StockqualifyService stockqualifyService;
    @GetMapping()
    @RequiresPermissions("stock:order:order")
    String Order(){
        return "stock/order/order";
    }


    @GetMapping("/add")
    @RequiresPermissions("stock:order:add")
    String add(){
        return "stock/order/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("stock:order:edit")
    String edit(@PathVariable("id") Long id,Model model){
        OrderDO order = orderService.get(id);
        model.addAttribute("order", order);
        return "stock/order/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:order:add")
    public R save(OrderDO order){
        if(orderService.save(order)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("stock:order:edit")
    public R update( OrderDO order){
        orderService.update(order);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("stock:order:remove")
    public R remove( Long id){
        if(orderService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("stock:order:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        orderService.batchRemove(ids);
        return R.ok();
    }

    @GetMapping("/userNum/{danjuNumber}")
    String userNum(@PathVariable("danjuNumber") String danjuNumber ,Model model) {
        model.addAttribute("danjuNumber",danjuNumber);
        return "/stock/stock/userNum";
    }

    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public R updateEnable(String danjuNumber, String status ,String username,StockDO stockDO) {

        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        map.put("userName", username);
        //———获取当前登录用户的公司id————
        String conpanyId = ShiroUtils.getUser().getCompanyId();
        map.put("conpanyId", conpanyId);
        UserDO userDO = userService.getUserName(map);
        if (null == userDO) {
            return R.error("该工号不存在");
        } else {

            List<OrderDO> orderDOS = orderService.orderdingdan(map);
            for (OrderDO orderkc : orderDOS) {
                String goodsCount = orderkc.getGoodsCount();//采购数量
                //判断是否已存在商品
                String goodsNum = orderkc.getGoodsNum();
                String goodsCode = orderkc.getGoodsCode();
                stockDO.setGoodsNum(goodsNum);
                stockDO.setGoodsCode(goodsCode);
                stockDO.setPositionId(orderkc.getPositionId());
                stockDO.setPositionName(orderkc.getPositionName());

                try {
                    String useday = orderkc.getUseday();
                    stockDO.setUseday(useday);
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setUseday("");
                }
                StockDO goodsNumList = stockService.haveNum(stockDO);
                if (null != goodsNumList) {
                    String gdcount = goodsNumList.getGoodsCount();
                    Integer goodsCountNew = Integer.valueOf(goodsCount);
                    Integer gdcountNew = Integer.valueOf(gdcount);
                    Integer newGoodsCount = goodsCountNew + gdcountNew;
                    stockDO.setGoodsCount(String.valueOf(newGoodsCount));
                    stockService.updateGoodsCount(stockDO);
                    StocklogDO stocklogDO=new StocklogDO();
                    stocklogDO.setDanjunum(orderkc.getDanjuNumber());
                    stocklogDO.setNum(orderkc.getGoodsNum());
                    stocklogDO.setCode(orderkc.getGoodsCode());
                    stocklogDO.setName(orderkc.getGoodsName());
                    stocklogDO.setGoodsid(orderkc.getGoodsType());
                    stocklogDO.setMfrsnum(orderkc.getMfrsid());
                    stocklogDO.setBrandname(orderkc.getBrandname());
                    stocklogDO.setMoney(orderkc.getRetailPrice());
                    stocklogDO.setUseday(orderkc.getUseday());
                    stocklogDO.setBacth(orderkc.getBatch());
                    stocklogDO.setCounts(orderkc.getGoodsCount());
                    stocklogDO.setInpositionId(Long.valueOf(orderkc.getPositionId()));
                    stocklogDO.setOutpositionId(null);
                    stocklogDO.setZhidanPeople(orderkc.getZhidanPeople());
                    //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String newDate = sdf.format(date);
                    stocklogDO.setDay(newDate);
                    stocklogDO.setWay("采购入库");
                    stocklogDO.setUsername(username);
                    stocklogService.save(stocklogDO);
                    OrderDO orderDO1 = new OrderDO();
                    StockDO stockDO1 = new StockDO();
                    orderDO1.setDanjuNumber(danjuNumber);
                    orderDO1.setStatus(status);
                    orderDO1.setUsername(username);
                    orderDO1.setStockorder(goodsNumList.getDanjuNumber());
                    stockDO1.setDanjuNumber(goodsNumList.getDanjuNumber());
                    stockDO1.setStatus(status);
                    stockDO1.setUsername(username);
                    orderService.updateStatus(orderDO1);
                    stockService.updateStatus(stockDO1);
                } else {
                    stockDO.setGoodsCount(goodsCount);
                    stockDO.setGoodsType(orderkc.getGoodsType());
                    stockDO.setMfrsid(orderkc.getMfrsid());
                    stockDO.setGoodsName(orderkc.getGoodsName());
                    stockDO.setBrandname(orderkc.getBrandname());
                    try {
                        String retailPrice = orderkc.getRetailPrice();
                        stockDO.setRetailPrice(retailPrice);
                        Double priceSum = Double.parseDouble(retailPrice) * Double.parseDouble(goodsCount);
                        stockDO.setPriceSum(Double.toString(priceSum));

                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setRetailPrice("");
                        stockDO.setPriceSum("");
                    }

                    stockDO.setPositionName(orderkc.getPositionName());
                    try {
                        String createTime = orderkc.getCreateTime();
                        stockDO.setCreateTime(createTime);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setCreateTime("");
                    }

                    stockDO.setDanjuNumber(orderkc.getDanjuNumber());
                    stockDO.setOrderNumber(orderkc.getOrderNumber());
                    stockDO.setYundanNumber(orderkc.getYundanNumber());
                    stockDO.setZhidanPeople(orderkc.getZhidanPeople());
                    stockDO.setDanjuDay(orderkc.getDanjuDay());
                    stockDO.setTuihuoNumber(orderkc.getTuihuoNumber());
                    stockDO.setFactoryNumber(orderkc.getFactoryNumber());
                    stockDO.setBeizhu(orderkc.getBeizhu());
                    stockDO.setReturnzt(orderkc.getReturnzt());
                    try {
                        String unit = orderkc.getUnit();
                        stockDO.setUnit(unit);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setUnit("");
                    }

                    try {
                        String batch = orderkc.getBatch();
                        stockDO.setBatch(batch);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setBatch("");
                    }
                    try {
                        String zhuceNumber = orderkc.getZhuceNumber();
                        stockDO.setZhuceNumber(zhuceNumber);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setZhuceNumber("");
                    }
                    try {
                        String produceDay = orderkc.getProduceDay();
                        stockDO.setProduceDay(produceDay);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setProduceDay("");
                    }
                    try {
                        String status1 = orderkc.getStatus();
                        stockDO.setStatus(status1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setStatus("");
                    }
                    try {
                        String username1 = orderkc.getUsername();
                        stockDO.setUsername(username1);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stockDO.setUsername("");
                    }
//                    try {
//                        String goodsxinxiid = orderkc.getGoodsxinxiid();
//                        stockDO.setGoodsxinxiid(goodsxinxiid);
//                    } catch (ArrayIndexOutOfBoundsException e) {
//                        stockDO.setGoodsxinxiid("");
//                    }


                    if (null != orderkc.getClasstype()) {
                        try {
                            String classtype = orderkc.getClasstype();
                            stockDO.setClasstype(classtype);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            stockDO.setClasstype("");
                        }
                    } else {
                        stockDO.setClasstype("");
                    }


                    if (null != orderkc.getFactory()) {
                        try {
                            String factory = orderkc.getFactory();
                            stockDO.setFactory(factory);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            stockDO.setFactory("");
                        }
                    } else {
                        stockDO.setFactory("");
                    }
                    StocklogDO stocklogDO=new StocklogDO();
                    stocklogDO.setDanjunum(orderkc.getDanjuNumber());
                    stocklogDO.setNum(orderkc.getGoodsNum());
                    stocklogDO.setCode(orderkc.getGoodsCode());
                    stocklogDO.setName(orderkc.getGoodsName());
                    stocklogDO.setGoodsid(orderkc.getGoodsType());
                    stocklogDO.setMfrsnum(orderkc.getMfrsid());
                    stocklogDO.setBrandname(orderkc.getBrandname());
                    stocklogDO.setMoney(orderkc.getRetailPrice());
                    stocklogDO.setUseday(orderkc.getUseday());
                    stocklogDO.setBacth(orderkc.getBatch());
                    stocklogDO.setCounts(orderkc.getGoodsCount());
                    stocklogDO.setInpositionId(Long.valueOf(orderkc.getPositionId()));
                    stocklogDO.setOutpositionId(null);
                    stocklogDO.setZhidanPeople(orderkc.getZhidanPeople());
                    //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String newDate = sdf.format(date);
                    stocklogDO.setDay(newDate);
                    stocklogDO.setWay("采购入库");
                    stocklogDO.setUsername(username);
                    stocklogService.save(stocklogDO);
                    if (stockService.save(stockDO) > 0) {
                        OrderDO orderDO1 = new OrderDO();
                        StockDO stockDO1 = new StockDO();
                        orderDO1.setDanjuNumber(danjuNumber);
                        orderDO1.setStatus(status);
                        orderDO1.setUsername(username);
                        if ("".equals(goodsNumList)) {
                            orderDO1.setStockorder(orderkc.getDanjuNumber());
                        } else {
                            orderDO1.setStockorder(orderkc.getDanjuNumber());
                        }
                        stockDO1.setDanjuNumber(danjuNumber);
                        stockDO1.setStatus(status);
                        stockDO1.setUsername(username);
                        orderService.updateStatus(orderDO1);
                        stockService.updateStatus(stockDO1);
                    }
                }

            }
            return R.ok();

        }
    }
}
