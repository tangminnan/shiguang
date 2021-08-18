package com.shiguang.stock.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.service.OrderService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
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

}
