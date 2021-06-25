package com.shiguang.mfrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.domain.VocationDO;
import com.shiguang.member.domain.MemberDO;
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
    //制造商商品表
    @Autowired
    private MgService mgService;


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
//        Query query = new Query(params);
//        List<MfrsDO> mfrsList = mfrsService.list(query);
//        int total = mfrsService.count(query);
//        PageUtils pageUtils = new PageUtils(mfrsList, total);
//        return pageUtils;
        Query query = new Query(params);
        List<MfrsDO> mfrsDOList = mfrsService.mglist(query);
        int total = mfrsService.mgcount(query);
        PageUtils pageUtils = new PageUtils(mfrsDOList,total);
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

//    /**
//     * 详情
//     */
//    @GetMapping("/detail/{mfrsid}")
//    @RequiresPermissions("mfrs:mfrs:detail")
//    String detail(@PathVariable("mfrsid") Integer mfrsid, Model model) {
//        MfrsDO mfrs = mfrsService.get(mfrsid);
//        model.addAttribute("mfrs", mfrs);
//        Map<String, Object> map = new HashMap<>();
//        //商品
//        List<GoodsDO> goodsDOList = goodsService.list(map);
//        model.addAttribute("goodsDOList", goodsDOList);
//        //支付
//        List<PayDO> payDOList = payService.list(map);
//        model.addAttribute("payDOList", payDOList);
//        //开票
//        List<InvoiceDO> invoiceDOList = invoiceService.list(map);
//        model.addAttribute("invoiceDOList", invoiceDOList);
//        return "mfrs/mfrs/detail";
//    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:mfrs:add")
    public R save(MfrsDO mfrs) {
        if (null == mfrs.getGoodsid()){
            return R.error("商品类别不能为空");
        }
        //判断是否已存在
        String mfrsnum = mfrs.getMfrsnum();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsnum",mfrsnum);
        List<MfrsDO> list = mfrsService.list(map);
        if (list.size() > 0){
            return R.error("制造商代码已存在");
        }
        if (mfrsService.save(mfrs) > 0) {
            //获取制造商中的商品id,依次循环遍历，保存到关系表中，走两个保存方法
            String[] str = mfrs.getGoodsid().split(",");
            for (int i=0; i<str.length;i++){
                MgDO mgDO = new MgDO();
                mgDO.setMfrsid(mfrs.getMfrsid());
                mgDO.setGoodsid(Integer.parseInt(str[i]));
                mgService.save(mgDO);
            }

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
        if (null == mfrs.getGoodsid()){
            return R.error("商品类别不能为空");
        }
        //判断是否已存在商品
        Integer mfrsid = mfrs.getMfrsid();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid",mfrsid);
        List<MgDO> list = mgService.mglist(map);
        if (list.size() > 0){
            mgService.remove(mfrsid);
        }
            String[] str = mfrs.getGoodsid().split(",");
            for (int i=0; i<str.length;i++){
                MgDO mgDO = new MgDO();
                mgDO.setMfrsid(mfrs.getMfrsid());
                mgDO.setGoodsid(Integer.parseInt(str[i]));
                mgService.save(mgDO);
            }
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

    /**
     * 批量停用或启用
     */
    @PostMapping( "/stop")
    @ResponseBody
    @RequiresPermissions("mfrs:mfrs:stop")
    public R stop(@RequestParam("ids[]") Integer[] ids,@RequestParam("status") Long status){
        mfrsService.stop(ids,status);
        return R.ok();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value="/updateEnable")
    public R updateEnable(Integer id,Long enable) {
        MfrsDO mfrsDO=new MfrsDO();
        mfrsDO.setMfrsid(id);
        mfrsDO.setStatus(enable);
        mfrsService.updateStatus(mfrsDO);
        return R.ok();
    }
}