package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.jiancha.domain.PharmacyDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.service.PharmacyService;
import com.shiguang.jiancha.service.TryresultsService;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.line.service.OptometryLineService;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.service.OptometryService;
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
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */

@Controller
@RequestMapping("/jiancha/tryresults")
public class TryresultsController {
    @Autowired
    private TryresultsService tryresultsService;
    @Autowired
    private LineService lineService;
    @Autowired
    private OptometryLineService optometryLineService;

    //散瞳用药
    @Autowired
    private PharmacyService pharmacyService;
    //客观验光
    @Autowired
    private OptometryService optometryService;

    @GetMapping()
    @RequiresPermissions("jiancha:tryresults:tryresults")
    String Tryresults() {
        return "jiancha/tryresults/tryresults";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:tryresults:tryresults")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TryresultsDO> tryresultsList = tryresultsService.list(query);
        int total = tryresultsService.count(query);
        PageUtils pageUtils = new PageUtils(tryresultsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:tryresults:add")
    String add() {
        return "jiancha/tryresults/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("jiancha:tryresults:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TryresultsDO tryresults = tryresultsService.get(id);
        model.addAttribute("tryresults", tryresults);
        return "jiancha/tryresults/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:tryresults:add")
    public R save(TryresultsDO tryresults) {
        String newOld=tryresults.getNewOld();
        if (newOld==null || newOld==""){
            tryresults.setNewOld(null);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        LineDO lineDO = new LineDO();
//        lineDO.setMemberNumber(tryresults.getCardNumber());
//        lineDO.setLineDate(simpleDateFormat.format(new Date()));
//        lineDO.setCallStatus("4");
//        lineService.updateByMember(lineDO);
        Map<String,Object> maps = new HashMap<>();
        maps.put("memberNumber",tryresults.getCardNumber());
        maps.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineDO> ygLineDOList = optometryLineService.lineList(maps);
        if (null != ygLineDOList && ygLineDOList.size() > 0){
            YgLineDO ygLineDO = new YgLineDO();
            ygLineDO.setLineDate(simpleDateFormat.format(new Date()));
            ygLineDO.setMemberNumber(tryresults.getCardNumber());
            ygLineDO.setCallStatus("4");
            optometryLineService.updateStatus(ygLineDO);
        }
      String ptometryNumber= tryresults.getPtometryNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber", ptometryNumber);
        List<TryresultsDO> list = tryresultsService.haveYanguangNum(map);

        if ("".equals(tryresults.getSphereRightz())) {
            tryresults.setSphereRightz("0.00");
        }
        if ("".equals(tryresults.getSphereLeftz())) {
            tryresults.setSphereLeftz("0.00");
        }
        if ("".equals(tryresults.getCylinderRightz())) {
            tryresults.setCylinderRightz("-0.00");
        }
        if ("".equals(tryresults.getCylinderLeftz())) {
            tryresults.setCylinderLeftz("-0.00");
        }

        if ("".equals(tryresults.getSphereRighttry())) {
            tryresults.setSphereRighttry("0.00");
        }
        if ("".equals(tryresults.getSphereLefttry())) {
            tryresults.setSphereLefttry("0.00");
        }
        if ("".equals(tryresults.getCylinderRighttry())) {
            tryresults.setCylinderRighttry("-0.00");
        }
        if ("".equals(tryresults.getCylinderLefttry())) {
            tryresults.setCylinderLefttry("-0.00");
        }


        if ("".equals(tryresults.getAddRightz())) {
            tryresults.setAddRightz("0.00");
        }
        if ("".equals(tryresults.getAddLeftz())) {
            tryresults.setAddLeftz("-0.00");
        }


        if ("".equals(tryresults.getAddRighttry())) {
            tryresults.setAddRighttry("0.00");
        }
        if ("".equals(tryresults.getAddLefttry())) {
            tryresults.setAddLefttry("0.00");
        }



        if (list.size() > 0) {
            tryresultsService.updateTry(tryresults);
            return R.ok();
        }else if (tryresultsService.save(tryresults) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:tryresults:edit")
    public R update(TryresultsDO tryresults) {
        tryresultsService.update(tryresults);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/reomveTry")
    @ResponseBody
    public R remove(String ptometryNumber) {
        if (tryresultsService.remove(ptometryNumber) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:tryresults:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tryresultsService.batchRemove(ids);
        return R.ok();
    }

    /**
     * 一个会员所有验光信息
     */
    @ResponseBody
    @GetMapping("/yanguangListShuju")
    public List<TryresultsDO> yanguangListShuju(String cardNumber, Model model) {
        //查询列表数据
        Map<String, Object> map = new HashMap<>();
        map.put("cardNumber", cardNumber);
        List<TryresultsDO> tryresultsDOList = tryresultsService.yanguangListShuju(map);
        model.addAttribute("tryresultsDOList", tryresultsDOList);
        if (null != tryresultsDOList){
            for (TryresultsDO tryresultsDO:tryresultsDOList){
                //是否结算
                String haveid = tryresultsDO.getHaveid();
                if (null !=haveid && "" != haveid){
                    tryresultsDO.setHaveid("0");
                }else {
                    tryresultsDO.setHaveid("1");
                }
            }
        }
        return tryresultsDOList;
    }

    /**
     * 修改所有验光信息详情------[][][]
     */
    @GetMapping("/updateTryshuju/{ptometryNumber}")
    String updateTryshuju(@PathVariable("ptometryNumber") String ptometryNumber, Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber", ptometryNumber);
        //验光数据
        TryresultsDO tryresultsDO = tryresultsService.getTryresult(map);
        if (tryresultsDO.getSex() == 0) {
            tryresultsDO.setSexx("男");
        } else {
            tryresultsDO.setSexx("女");
        }
        SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = tryresultsDO.getCreateTime();
        String newtime = sdftime.format(time);
        model.addAttribute("newtime", newtime);
        //————————————————散瞳用药————————————————————————————————
        List<PharmacyDO> pharmacyDOList = pharmacyService.list(map);
        model.addAttribute("pharmacyDOList", pharmacyDOList);
        model.addAttribute("tryresultsDO", tryresultsDO);
        //———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
//-----------------散瞳后
        List<OptometryDO> optoList = optometryService.optoList(map);
        OptometryDO optometryDO = new OptometryDO();
        if (optoList.size() > 0) {
            optometryDO.setMydriasis(optoList.get(0).getMydriasis());
            optometryDO.setCylinderRight2(optoList.get(0).getCylinderRight2());
            optometryDO.setCylinderLeft2(optoList.get(0).getCylinderLeft2());
            optometryDO.setAxialRight2(optoList.get(0).getAxialRight2());
            optometryDO.setAxialLeft2(optoList.get(0).getAxialLeft2());
            optometryDO.setSphereRight2(optoList.get(0).getSphereRight2());
            optometryDO.setSphereLeft2(optoList.get(0).getSphereLeft2());
        }
        model.addAttribute("optometryDO", optometryDO);
        return "optometryNew/tryedit";
    }

    /**
     * 修改验光数据
     */
    @ResponseBody
    @RequestMapping("/updateTry")
    public R updateTry(TryresultsDO tryresults) {
        if ("".equals(tryresults.getSphereRightz())) {
            tryresults.setSphereRightz("0.00");
        }
        if ("".equals(tryresults.getSphereLeftz())) {
            tryresults.setSphereLeftz("0.00");
        }
        if ("".equals(tryresults.getCylinderRightz())) {
            tryresults.setCylinderRightz("-0.00");
        }
        if ("".equals(tryresults.getCylinderLeftz())) {
            tryresults.setCylinderLeftz("-0.00");
        }

        if ("".equals(tryresults.getSphereRighttry())) {
            tryresults.setSphereRighttry("0.00");
        }
        if ("".equals(tryresults.getSphereLefttry())) {
            tryresults.setSphereLefttry("0.00");
        }
        if ("".equals(tryresults.getCylinderRighttry())) {
            tryresults.setCylinderRighttry("-0.00");
        }
        if ("".equals(tryresults.getCylinderLefttry())) {
            tryresults.setCylinderLefttry("-0.00");
        }


        if ("".equals(tryresults.getAddRightz())) {
            tryresults.setAddRightz("0.00");
        }
        if ("".equals(tryresults.getAddLeftz())) {
            tryresults.setAddLeftz("-0.00");
        }


        if ("".equals(tryresults.getAddRighttry())) {
            tryresults.setAddRighttry("0.00");
        }
        if ("".equals(tryresults.getAddLefttry())) {
            tryresults.setAddLefttry("0.00");
        }


        tryresultsService.updateTry(tryresults);
        return R.ok();
    }
}
