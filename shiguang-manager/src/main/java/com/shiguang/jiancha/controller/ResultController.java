package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.mfrs.domain.BrandDO;
import com.sun.mail.imap.protocol.ID;
import javafx.scene.control.Alert;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.plugin.javascript.navig4.Layer;

import java.text.SimpleDateFormat;
import java.util.*;

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

    //试戴镜
    @Autowired
    private TryresultsService tryresultsService;
    //散瞳用药
    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping()
    @RequiresPermissions("jiancha:result:result")
    String Result() {
        return "jiancha/result/result";
    }

//    @ResponseBody
//    @GetMapping("/list")
//    @RequiresPermissions("jiancha:result:result")
//    public PageUtils list(@RequestParam Map<String, Object> params) {
//        //查询列表数据
//        Query query = new Query(params);
//        List<ResultDO> resultList = resultService.list(query);
//        int total = resultService.count(query);
//        PageUtils pageUtils = new PageUtils(resultList, total);
//        return pageUtils;
//    }

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
             if (result.getKjyyDoctor() == "" || result.getKjyyOptometryName() == "") {
                 return R.error("请选择医生或验光师");
             } else {
                 kjyyServce.savekjyy(result);
             }
         }


         if (result.getKjjyPrescriptionType() != null && result.getKjjyPrescriptionType() != "") {
             if (result.getKjjyDoctor() == "" || result.getKjjyOptometryName() == "") {
                 return R.error("请选择医生或验光师");
             } else {
                 kjjyService.savekjjy(result);
             }
         }

        if (result.getSgjjPrescriptionType() != null && result.getSgjjPrescriptionType() != "") {
            if (result.getSgjjDoctor() == "" || result.getSgjjOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {
                sgjjService.savesgjj(result);
            }
        }

       if (result.getRxPrescriptionType() != null && result.getRxPrescriptionType() != "") {
           if (result.getRxDoctor() == "" || result.getRxOptometryName() == "") {
               return R.error("请选择医生或验光师");
           } else {
               rxjmjcjService.saveRxjmjcj(result);
           }
       }


        if (result.getZyPrescriptionType() != null && result.getZyPrescriptionType() != "") {
            if (result.getZyDoctor() == "" || result.getZyOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {
                zyService.saveZY(result);
            }
        }

        if (result.getSjxlPrescriptionType() != null && result.getSjxlPrescriptionType() != "") {
            if (result.getSjxlDoctor() == "" || result.getSjxlOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {
                sjxlService.saveSjxl(result);
            }
        }


         if (result.getVstPrescriptionType() != null  && result.getVstPrescriptionType() != "") {
             if (result.getVstDoctor() == "" ||  result.getVstOptometryName() == ""){
                 return R.error("请选择医生或验光师");
             } else {
                 vstService.saveVst(result);
             }
        }


       if (result.getCrtPrescriptionType() != null  && result.getCrtPrescriptionType() != "") {
           if (result.getCrtDoctor() == "" ||  result.getCrtOptometryName() == ""){
               return R.error("请选择医生或验光师");
           } else {
               crtService.saveCrt(result);
           }
        }


         if (result.getRgpPrescriptionType() != null  && result.getRgpPrescriptionType() != "") {
             if (result.getRgpDoctor() == "" || result.getRgpOptometryName() == "") {
                 return R.error("请选择医生或验光师");
             } else {
                 rgpService.saveRgp(result);
             }
         }


        if (result.getYpPrescriptionType() != null  && result.getYpPrescriptionType() != "") {
            if (result.getYpDoctor() == "" || result.getYpOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {

                yaopinService.saveYaopin(result);
            }
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
     * 修改删除相对应信息状态
     */
    @ResponseBody
    @RequestMapping("/upremove")
    @RequiresPermissions("jiancha:result:upremove")
    public R upremove(String  ptometryNumber) {
        ResultDO resultDO = new ResultDO();
        resultDO.setStatus("0");
        resultDO.setPtometryNumber(ptometryNumber);
        CrtDO crtDO = new CrtDO();
        crtDO.setStatus("0");
        crtDO.setPtometryNumber(ptometryNumber);
        KjjyDO kjjyDO = new KjjyDO();
        kjjyDO.setStatus("0");
        kjjyDO.setPtometryNumber(ptometryNumber);
        KjyyDO kjyyDO = new KjyyDO();
        kjyyDO.setStatus("0");
        kjyyDO.setPtometryNumber(ptometryNumber);
        RgpDO rgpDO = new RgpDO();
        rgpDO.setStatus("0");
        rgpDO.setPtometryNumber(ptometryNumber);
        RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
        rxjmjcjDO.setStatus("0");
        rxjmjcjDO.setPtometryNumber(ptometryNumber);
        SgjjDO sgjjDO = new SgjjDO();
        sgjjDO.setStatus("0");
        sgjjDO.setPtometryNumber(ptometryNumber);
        SjxlDO sjxlDO = new SjxlDO();
        sjxlDO.setStatus("0");
        sjxlDO.setPtometryNumber(ptometryNumber);
        VstDO vstDO = new VstDO();
        vstDO.setStatus("0");
        vstDO.setPtometryNumber(ptometryNumber);
        YaopinDO yaopinDO = new YaopinDO();
        yaopinDO.setStatus("0");
        yaopinDO.setPtometryNumber(ptometryNumber);
        ZyDO zyDO  = new ZyDO();
        zyDO.setStatus("0");
        zyDO.setPtometryNumber(ptometryNumber);
            resultService.upremove(resultDO);
            kjyyServce.upremove(kjyyDO);
            kjjyService.upremove(kjjyDO);
            sgjjService.upremove(sgjjDO);
            rxjmjcjService.upremove(rxjmjcjDO);
            zyService.upremove(zyDO);
            sjxlService.upremove(sjxlDO);
            vstService.upremove(vstDO);
            crtService.upremove(crtDO);
            rgpService.upremove(rgpDO);
            yaopinService.upremove(yaopinDO);
            return R.ok();
    }



    /**
     * 所有验光信息
     */
    @ResponseBody
    @GetMapping("/shujulist")
    public List<ResultDO> shujulist(String cardNumber,Model model) {
        //查询列表数据
        Map<String, Object> map = new HashMap<>();
        map.put("cardNumber",cardNumber);
        map.put("status","1");
        List<ResultDO> resultList = resultService.shujulist(map);
        model.addAttribute("resultList",resultList);
        if (null != resultList){
            for (ResultDO resultDO:resultList){
                String haveid = resultDO.getHaveid();
                if (null !=haveid && "" != haveid){
                    resultDO.setHaveid("0");
                }else {
                    resultDO.setHaveid("1");
                }
            }
        }

        return resultList;
    }
 /**
     * 所有验光信息详情
     */
    @GetMapping("/chufangall/{ptometryNumber}")
    @RequiresPermissions("jiancha:result:chufangall")
    String  chufangall(@PathVariable("ptometryNumber") String ptometryNumber,Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber",ptometryNumber);
        //验光数据
        TryresultsDO tryresultsDO =tryresultsService.getTryresult(map);
        //所有处方
        ResultDO resultDO= resultService.getChufangAll(map);
        model.addAttribute("resultDO",resultDO);
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
        model.addAttribute("tryresultsDO",tryresultsDO);

        return "optometryNew/chufangall";
    }




}
