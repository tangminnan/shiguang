package com.shiguang.mfrs.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.PayDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.MgService;
import com.shiguang.mfrs.service.PayService;
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
        return "mfrs/mfrs/mfrs";
    }

    //【制造商页面List】
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:mfrs:mfrs")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MfrsDO> mfrsDOList = mfrsService.list(query);
        int total = mfrsService.count(query);
        PageUtils pageUtils = new PageUtils(mfrsDOList, total);
        return pageUtils;
    }

    //查询制造商
    @ResponseBody
    @GetMapping("/mfrsList")
    public PageUtils mfrsList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if (null != query.get("goodsids")) {
            query.put("goodsIds", Integer.parseInt(query.get("goodsids").toString()));
        }
        query.put("xsstate","0");
        List<MfrsDO> mfrsDOList = mfrsService.findMfrs(query);
        int total = mfrsService.findMfrscount(query);
        PageUtils pageUtils = new PageUtils(mfrsDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:mfrs:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        //制造商
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
////———获取当前系统时间—————
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//        Date date = new Date();
//        String newDate = sdf.format(date);
//        model.addAttribute("createTime", newDate);

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
//------------修改时转换日期格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //统一社会信用代码效期
//        Date stime = mfrs.getCreditcodeday();
//        String str = sdf.format(stime);
//        mfrs.setCreditcodedays(str);
//        //医疗器械经营许可证有效期
//        Date stime2 = mfrs.getMedicinecodeday();
//        String str2 = sdf.format(stime2);
//        mfrs.setMedicinecodedays(str2);
//        //全国工业品生产许可证有效期
//        Date stime3 = mfrs.getProductscodeday();
//        String str3 = sdf.format(stime3);
//        mfrs.setProductscodedays(str3);
        return "mfrs/mfrs/edit";
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{mfrsid}")
    @RequiresPermissions("mfrs:mfrs:detail")
    String detail(@PathVariable("mfrsid") Integer mfrsid, Model model) {
        MfrsDO mfrs = mfrsService.get(mfrsid);
        model.addAttribute("mfrs", mfrs);
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //支付
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);

//        //------------修改时转换日期格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        //统一社会信用代码效期
//        Date stime = mfrs.getCreditcodeday();
//        String str = sdf.format(stime);
//        mfrs.setCreditcodedays(str);
//        //医疗器械经营许可证有效期
//        Date stime2 = mfrs.getMedicinecodeday();
//        String str2 = sdf.format(stime2);
//        mfrs.setMedicinecodedays(str2);
//        //全国工业品生产许可证有效期
//        Date stime3 = mfrs.getProductscodeday();
//        String str3 = sdf.format(stime3);
//        mfrs.setProductscodedays(str3);

        return "mfrs/mfrs/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:mfrs:add")
    public R save(MfrsDO mfrs) {
        //判断是否已存在
        String mfrsnum = mfrs.getMfrsnum();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsnum", mfrsnum);
        List<MfrsDO> list = mfrsService.haveNum(map);
        if (list.size() > 0) {
            return R.error("制造商代码已存在");
        }
        if (mfrsService.save(mfrs) > 0) {
            //获取制造商中的商品id,依次循环遍历，保存到关系表中，走两个保存方法
//            String[] str = mfrs.getGoodsid().split(",");
//            for (int i = 0; i < str.length; i++) {
//                MgDO mgDO = new MgDO();
//                mgDO.setMfrsid(mfrs.getMfrsid());
//                mgDO.setGoodsid(Integer.parseInt(str[i]));
//                mgService.save(mgDO);
//            }

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
        if (null == mfrs.getGoodsid()) {
            return R.error("商品类别不能为空");
        }
        //判断是否已存在商品
        Integer mfrsid = mfrs.getMfrsid();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsid", mfrsid);
        List<MgDO> list = mgService.mglist(map);
        if (list.size() > 0) {
            mgService.remove(mfrsid);
        }
        String[] str = mfrs.getGoodsid().split(",");
        for (int i = 0; i < str.length; i++) {
            MgDO mgDO = new MgDO();
            mgDO.setMfrsid(mfrs.getMfrsid());
            mgDO.setGoodsid(Integer.parseInt(str[i]));
            mgService.save(mgDO);
        }
        mfrsService.update(mfrs);
        return R.ok();
    }


    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Integer mfrsid, Long enable) {
        MfrsDO mfrsDO = new MfrsDO();
        mfrsDO.setMfrsid(mfrsid);
        mfrsDO.setXsstate(enable);
        mfrsService.update(mfrsDO);
        return R.ok();
    }


    /**
     * 删除修改状态
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:mfrs:remove")
    public R updateStatus(Integer mfrsid) {
        MfrsDO mfrsDO = new MfrsDO();
        mfrsDO.setState(0L);
        mfrsDO.setMfrsid(mfrsid);
        if (mfrsService.updateState(mfrsDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("mfrs:mfrs:remove")
//    public R remove( Integer mfrsid){
//        if(mfrsService.remove(mfrsid)>0){
//            return R.ok();
//        }
//        return R.error();
//    }
}