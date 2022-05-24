package com.shiguang.mfrs.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品类别表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */

@Controller
@RequestMapping("/mfrs/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping()
    @RequiresPermissions("mfrs:goods:goods")
    String Goods() {
        return "mfrs/goods/goods";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:goods:goods")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<GoodsDO> goodsList = goodsService.list(query);
        int total = goodsService.count(query);
        PageUtils pageUtils = new PageUtils(goodsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:goods:add")
    String add() {
        return "mfrs/goods/add";
    }

    @GetMapping("/edit/{goodsid}")
    @RequiresPermissions("mfrs:goods:edit")
    String edit(@PathVariable("goodsid") Integer goodsid, Model model) {
        GoodsDO goods = goodsService.get(goodsid);
        model.addAttribute("goods", goods);
        return "mfrs/goods/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:goods:add")
    public R save(GoodsDO goods) {
        String goodsnum = goods.getGoodsnum();
        Map<String, Object> map = new HashMap<>();
        map.put("goodsnum", goodsnum);
        List<GoodsDO> list = goodsService.list(map);
        if (list.size() > 0) {
            return R.error("商品代码已存在");
        }
        String goodsNane = goods.getGoodsname();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("goodsname", goodsNane);
        List<GoodsDO> list1 = goodsService.list(map1);
        if (list1.size() > 0) {
            return R.error("商品类别已存在");
        }


        if (goodsService.save(goods) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("mfrs:goods:edit")
    public R update(GoodsDO goods) {
        goodsService.update(goods);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("mfrs:goods:remove")
    public R remove(Integer goodsid) {
        if (goodsService.remove(goodsid) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:goods:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] goodsids) {
        goodsService.batchRemove(goodsids);
        return R.ok();
    }

}
