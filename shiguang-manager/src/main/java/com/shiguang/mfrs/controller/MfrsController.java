package com.shiguang.mfrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.domain.VocationDO;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
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

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 制造商维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:19:50
 */

@Controller
@RequestMapping("/mfrs/mfrs")
public class MfrsController {
    @Autowired
    private MfrsService mfrsService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //支付方式
    @Autowired
    private PayService payService;
    //开票状态
    @Autowired
    private InvoiceService invoiceService;


    @GetMapping()
    @RequiresPermissions("mfrs:mfrs:mfrs")
    String Mfrs(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //开票状态
        List<InvoiceDO> invoiceDOList = invoiceService.list(map);
        model.addAttribute("invoiceDOList",invoiceDOList);

        return "mfrs/mfrs/mfrs";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:mfrs:mfrs")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MfrsDO> mfrsList = mfrsService.list(query);
        int total = mfrsService.count(query);
        PageUtils pageUtils = new PageUtils(mfrsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:mfrs:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        //开票
        List<InvoiceDO> invoiceDOList = invoiceService.list(map);
        model.addAttribute("invoiceDOList", invoiceDOList);
        return "mfrs/mfrs/add";
    }

    @GetMapping("/edit/{mfrsid}")
    @RequiresPermissions("mfrs:mfrs:edit")
    String edit(@PathVariable("mfrsid") Integer mfrsid, Model model) {
        MfrsDO mfrs = mfrsService.get(mfrsid);
        model.addAttribute("mfrs", mfrs);
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        //开票
        List<InvoiceDO> invoiceDOList = invoiceService.list(map);
        model.addAttribute("invoiceDOList", invoiceDOList);
        return "mfrs/mfrs/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:mfrs:add")
    public R save(MfrsDO mfrs) {

//     mfrs.getGoodsid();
//
//		for (){
//			MfrsGoodsDO mfrsGoodsDO = new MfrsGoodsDO();
//			mfrsGoodsDO.setMfrsid(mfrs.getMfrsid());
//			mfrsGoodsDO.setGoodsid();
//			mfrsGoodsService.save(mfrsGoodsDO);
//		}
        if (mfrsService.save(mfrs) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("mfrs:mfrs:edit")
    public R update(MfrsDO mfrs) {
        mfrsService.update(mfrs);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("mfrs:mfrs:remove")
    public R remove(Integer mfrsid) {
        if (mfrsService.remove(mfrsid) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:mfrs:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] mfrsids) {
        mfrsService.batchRemove(mfrsids);
        return R.ok();
    }

}
