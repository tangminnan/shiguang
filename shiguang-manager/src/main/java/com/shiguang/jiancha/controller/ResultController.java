package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 检查结论表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-16 15:03:42
 */

@Controller
@RequestMapping("/jiancha/result")
public class ResultController {
    @Autowired
    private ResultService resultService;
    //1 框架--远用
    @Autowired
    private KjyyService kjyyServce;
    //2 框架--近用
    @Autowired
    private KjjyService kjjyService;
    //双光/渐进
    @Autowired
    private SgjjService sgjjService;
    //软性角膜接触镜
    @Autowired
    private RxjmjcjService rxjmjcjService;
    //中用
    @Autowired
    private  ZyService zyService;
    //视觉训练
    @Autowired
    private SjxlService sjxlService;
    //角膜VST
    @Autowired
    private VstService vstService;
    //角膜CRT
    @Autowired
    private CrtService crtService;
    //RGP
    @Autowired
    private RgpService rgpService;
    //药品
    @Autowired
    private YaopinService yaopinService;

    @GetMapping()
    @RequiresPermissions("jiancha:result:result")
    String Result() {
        return "jiancha/result/result";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jiancha:result:result")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ResultDO> resultList = resultService.list(query);
        int total = resultService.count(query);
        PageUtils pageUtils = new PageUtils(resultList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("jiancha:result:add")
    String add() {
        return "jiancha/result/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("jiancha:result:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ResultDO result = resultService.get(id);
        model.addAttribute("result", result);
        return "jiancha/result/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("jiancha:result:add")
    public R save(ResultDO result) {
//        处方类型所有数据保存
        if (result.getKjyyPrescriptionType() != null && result.getKjyyPrescriptionType() != "") {
            kjyyServce.savekjyy(result);
        }
        if (result.getKjjyPrescriptionType() != null && result.getKjjyPrescriptionType() != "") {
            kjjyService.savekjjy(result);
        }
        if (result.getSgjjPrescriptionType() != null && result.getSgjjPrescriptionType() != "") {
            sgjjService.savesgjj(result);
        }
        if (result.getRxPrescriptionType() != null && result.getRxPrescriptionType() != "") {
            rxjmjcjService.saveRxjmjcj(result);
        }
        if (result.getZyPrescriptionType() != null && result.getZyPrescriptionType() != ""){
            zyService.saveZY(result);
        }

        if (result.getSjxlPrescriptionType() != null && result.getSjxlPrescriptionType() != "") {
            sjxlService.saveSjxl(result);
        }
        if (result.getVstPrescriptionType() != null  && result.getVstPrescriptionType() != "") {
            vstService.saveVst(result);
        }
        if (result.getCrtPrescriptionType() != null  && result.getCrtPrescriptionType() != "") {
            crtService.saveCrt(result);
        }
        if (result.getRgpPrescriptionType() != null  && result.getRgpPrescriptionType() != "") {
            rgpService.saveRgp(result);
        }
        if (result.getYpPrescriptionType() != null  && result.getYpPrescriptionType() != "") {
            yaopinService.saveYaopin(result);
        }
        if (resultService.save(result) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("jiancha:result:edit")
    public R update(ResultDO result) {
        resultService.update(result);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("jiancha:result:remove")
    public R remove(Long id) {
        if (resultService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("jiancha:result:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        resultService.batchRemove(ids);
        return R.ok();
    }

}
