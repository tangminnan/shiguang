package com.shiguang.mfrs.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MfrsDO;
//import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.domain.PayDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MfrsService;
//import com.shiguang.mfrs.service.MgService;
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
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PayService payService;


    @GetMapping()
    @RequiresPermissions("mfrs:mfrs:mfrs")
    String Mfrs(Model model) {
        Map<String, Object> map = new HashMap<>();
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        return "mfrs/mfrs/mfrs";
    }

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
        List<MfrsDO> mfrsDOList = mfrsService.list(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);

        return "mfrs/mfrs/add";
    }

    @GetMapping("/edit/{mfrsid}")
    @RequiresPermissions("mfrs:mfrs:edit")
    String edit(@PathVariable("mfrsid") Integer mfrsid, Model model) {
        MfrsDO mfrs = mfrsService.get(mfrsid);
        model.addAttribute("mfrs", mfrs);
        Map<String, Object> map = new HashMap<>();
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);

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
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        List<PayDO> payDOList = payService.list(map);
        model.addAttribute("payDOList", payDOList);
        return "mfrs/mfrs/detail";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:mfrs:add")
    public R save(MfrsDO mfrs) {
        String mfrsnum = mfrs.getMfrsnum();
        Map<String, Object> map = new HashMap<>();
        map.put("mfrsnum", mfrsnum);
        List<MfrsDO> list = mfrsService.haveNum(map);
        if (list.size() > 0) {
            return R.error("制造商代码已存在");
        }
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



    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Integer mfrsid, Long enable) {
        MfrsDO mfrsDO = new MfrsDO();
        mfrsDO.setMfrsid(mfrsid);
        mfrsDO.setXsstate(enable);
        mfrsService.update(mfrsDO);
        return R.ok();
    }


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


}