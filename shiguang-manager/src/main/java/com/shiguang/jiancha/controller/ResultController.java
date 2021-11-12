package com.shiguang.jiancha.controller;

import com.shiguang.common.utils.R;
import com.shiguang.common.utils.StringUtils;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    private ZyService zyService;
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
    public R save(ResultDO result, TryresultsDO tryresultsDO) {

//        先判断删除处方后在修改有没有保存最后的结果和处方【是否有保存这个验光号数据】
        String ptometryNumber = result.getPtometryNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber", ptometryNumber);
        List<ResultDO> kjyyYgnum = kjyyServce.haveYanguangNum(map);
        List<ResultDO> kjjyYgnum = kjjyService.haveYanguangNum(map);
        List<ResultDO> sgjjYgnum = sgjjService.haveYanguangNum(map);
        List<ResultDO> rxjmjcjYgnum = rxjmjcjService.haveYanguangNum(map);
        List<ResultDO> zyYgnum = zyService.haveYanguangNum(map);
        List<ResultDO> sjxlYgnum = sjxlService.haveYanguangNum(map);
        List<ResultDO> vstYgnum = vstService.haveYanguangNum(map);
        List<ResultDO> crtYgnum = crtService.haveYanguangNum(map);
        List<ResultDO> rgpYgnum = rgpService.haveYanguangNum(map);
        List<ResultDO> yaopinYgnum = yaopinService.haveYanguangNum(map);
        List<ResultDO> resultYgnum = resultService.haveYanguangNum(map);

//        处方类型所有数据保存
        if (result.getKjyyPrescriptionType() != null && result.getKjyyPrescriptionType() != "") {
            if (result.getKjyyDoctor() == "" || result.getKjyyOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {
                if ("".equals(result.getKjyySphod())) {
                    result.setKjyySphod("0.00");
                }
                if ("".equals(result.getKjyySphos())) {
                    result.setKjyySphos("0.00");
                }
                if ("".equals(result.getKjyyCylod())) {
                    result.setKjyyCylod("0.00");
                }
                if ("".equals(result.getKjyyCylos())) {
                    result.setKjyyCylos("0.00");
                }
                if (kjyyYgnum.size() > 0) {
                    kjyyServce.update(result);
                } else {
                    kjyyServce.savekjyy(result);
                }

            }
        }


        if (result.getKjjyPrescriptionType() != null && result.getKjjyPrescriptionType() != "") {
            if (result.getKjjyDoctor() == "" || result.getKjjyOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {


                if ("".equals(result.getKjjySphod())) {
                    result.setKjjySphod("0.00");
                }
                if ("".equals(result.getKjjySphos())) {
                    result.setKjjySphos("0.00");
                }
                if ("".equals(result.getKjjyCylod())) {
                    result.setKjjyCylod("0.00");
                }
                if ("".equals(result.getKjjyCylos())) {
                    result.setKjjyCylos("0.00");
                }
                if (kjjyYgnum.size() > 0) {
                    kjjyService.update(result);
                } else {
                    kjjyService.savekjjy(result);
                }

            }
        }

        if (result.getSgjjPrescriptionType() != null && result.getSgjjPrescriptionType() != "") {
            if (result.getSgjjDoctor() == "" || result.getSgjjOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {

                if ("".equals(result.getSgjjSphod())) {
                    result.setSgjjSphod("0.00");
                }
                if ("".equals(result.getSgjjSphos())) {
                    result.setSgjjSphos("0.00");
                }
                if ("".equals(result.getSgjjCylod())) {
                    result.setSgjjCylod("0.00");
                }
                if ("".equals(result.getSgjjCylos())) {
                    result.setSgjjCylos("0.00");
                }

                if (sgjjYgnum.size() > 0) {
                    sgjjService.update(result);
                } else {
                    sgjjService.savesgjj(result);
                }

            }
        }

        if (result.getRxPrescriptionType() != null && result.getRxPrescriptionType() != "") {
            if (result.getRxDoctor() == "" || result.getRxOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {


                if ("".equals(result.getRxSphod())) {
                    result.setRxSphod("0.00");
                }
                if ("".equals(result.getRxSphos())) {
                    result.setRxSphos("0.00");
                }
                if ("".equals(result.getRxCylod())) {
                    result.setRxCylod("0.00");
                }
                if ("".equals(result.getRxCylos())) {
                    result.setRxCylos("0.00");
                }
                if (rxjmjcjYgnum.size() > 0) {
                    rxjmjcjService.update(result);
                } else {
                    rxjmjcjService.saveRxjmjcj(result);
                }

            }
        }


        if (result.getZyPrescriptionType() != null && result.getZyPrescriptionType() != "") {
            if (result.getZyDoctor() == "" || result.getZyOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {


                if ("".equals(result.getZySphod())) {
                    result.setZySphod("0.00");
                }
                if ("".equals(result.getZySphos())) {
                    result.setZySphos("0.00");
                }
                if ("".equals(result.getZyCylod())) {
                    result.setZyCylod("0.00");
                }
                if ("".equals(result.getZyCylos())) {
                    result.setZyCylos("0.00");
                }
                if (zyYgnum.size() > 0) {
                    zyService.update(result);
                } else {
                    zyService.saveZY(result);
                }

            }
        }

        if (result.getSjxlPrescriptionType() != null && result.getSjxlPrescriptionType() != "") {
            if (result.getSjxlDoctor() == "" || result.getSjxlOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {


                if ("".equals(result.getSjxlSphod())) {
                    result.setSjxlSphod("0.00");
                }
                if ("".equals(result.getSjxlSphos())) {
                    result.setSjxlSphos("0.00");
                }
                if ("".equals(result.getSjxlCylod())) {
                    result.setSjxlCylod("0.00");
                }
                if ("".equals(result.getSjxlCylos())) {
                    result.setSjxlCylos("0.00");
                }
                if (sjxlYgnum.size() > 0) {
                    sjxlService.update(result);
                } else {
                    sjxlService.saveSjxl(result);
                }

            }
        }


        if (result.getVstPrescriptionType() != null && result.getVstPrescriptionType() != "") {
            if (result.getVstDoctor() == "" || result.getVstOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {


                if ("".equals(result.getVstSphod())) {
                    result.setVstSphod("0.00");
                }
                if ("".equals(result.getVstSphos())) {
                    result.setVstSphos("0.00");
                }
                if ("".equals(result.getVstCylod())) {
                    result.setVstCylod("0.00");
                }
                if ("".equals(result.getVstCylos())) {
                    result.setVstCylos("0.00");
                }
                if (vstYgnum.size() > 0) {
                    vstService.update(result);
                } else {
                    vstService.saveVst(result);
                }

            }
        }


        if (result.getCrtPrescriptionType() != null && result.getCrtPrescriptionType() != "") {
            if (result.getCrtDoctor() == "" || result.getCrtOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {

                if ("".equals(result.getCrtSphod())) {
                    result.setCrtSphod("0.00");
                }
                if ("".equals(result.getCrtSphos())) {
                    result.setCrtSphos("0.00");
                }
                if ("".equals(result.getCrtCylod())) {
                    result.setCrtCylod("0.00");
                }
                if ("".equals(result.getCrtCylos())) {
                    result.setCrtCylos("0.00");
                }
                if (crtYgnum.size() > 0) {
                    crtService.update(result);
                } else {
                    crtService.saveCrt(result);
                }

            }
        }


        if (result.getRgpPrescriptionType() != null && result.getRgpPrescriptionType() != "") {
            if (result.getRgpDoctor() == "" || result.getRgpOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {

                if ("".equals(result.getRgpSphod())) {
                    result.setRgpSphod("0.00");
                }
                if ("".equals(result.getRgpSphos())) {
                    result.setRgpSphos("0.00");
                }
                if ("".equals(result.getRgpCylod())) {
                    result.setRgpCylod("0.00");
                }
                if ("".equals(result.getRgpCylos())) {
                    result.setRgpCylos("0.00");
                }
                if (rgpYgnum.size() > 0) {
                    rgpService.update(result);
                } else {
                    rgpService.saveRgp(result);
                }

            }
        }


        if (result.getYpPrescriptionType() != null && result.getYpPrescriptionType() != "") {
            if (result.getYpDoctor() == "" || result.getYpOptometryName() == "") {
                return R.error("请选择医生或验光师");
            } else {
                if (yaopinYgnum.size() > 0) {
                    yaopinService.update(result);
                } else {
                    yaopinService.saveYaopin(result);
                }

            }
        }

        if (resultYgnum.size() > 0) {
            if (resultService.update(result) > 0) {
                tryresultsDO.setStatus("0");
                tryresultsService.updateStatus(tryresultsDO);
                return R.ok();
            }
            return R.error();
        } else {
            if (resultService.save(result) > 0) {
                tryresultsDO.setStatus("0");
                tryresultsService.updateStatus(tryresultsDO);
                return R.ok();
            }
            return R.error();
        }

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
//    @RequiresPermissions("jiancha:result:upremove")
    public R upremove(String ptometryNumber) {
        ResultDO resultDO = new ResultDO();
//        resultDO.setStatus("0");
        resultDO.setPtometryNumber(ptometryNumber);
        CrtDO crtDO = new CrtDO();
//        crtDO.setStatus("0");
        crtDO.setPtometryNumber(ptometryNumber);
        KjjyDO kjjyDO = new KjjyDO();
//        kjjyDO.setStatus("0");
        kjjyDO.setPtometryNumber(ptometryNumber);
        KjyyDO kjyyDO = new KjyyDO();
//        kjyyDO.setStatus("0");
        kjyyDO.setPtometryNumber(ptometryNumber);
        RgpDO rgpDO = new RgpDO();
//        rgpDO.setStatus("0");
        rgpDO.setPtometryNumber(ptometryNumber);
        RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
//        rxjmjcjDO.setStatus("0");
        rxjmjcjDO.setPtometryNumber(ptometryNumber);
        SgjjDO sgjjDO = new SgjjDO();
//        sgjjDO.setStatus("0");
        sgjjDO.setPtometryNumber(ptometryNumber);
        SjxlDO sjxlDO = new SjxlDO();
//        sjxlDO.setStatus("0");
        sjxlDO.setPtometryNumber(ptometryNumber);
        VstDO vstDO = new VstDO();
//        vstDO.setStatus("0");
        vstDO.setPtometryNumber(ptometryNumber);
        YaopinDO yaopinDO = new YaopinDO();
//        yaopinDO.setStatus("0");
        yaopinDO.setPtometryNumber(ptometryNumber);
        ZyDO zyDO = new ZyDO();
//        zyDO.setStatus("0");
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
    public List<ResultDO> shujulist(String cardNumber, Model model) {
        //查询列表数据
        Map<String, Object> map = new HashMap<>();
        map.put("cardNumber", cardNumber);
        map.put("status", "1");
        List<ResultDO> resultList = resultService.shujulist(map);
        model.addAttribute("resultList", resultList);
        if (null != resultList) {
            for (ResultDO resultDO : resultList) {
                //是否结算
                String haveid = resultDO.getHaveid();
                if (null != haveid && "" != haveid) {
                    resultDO.setHaveid("0");
                } else {
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
    String chufangall(@PathVariable("ptometryNumber") String ptometryNumber, Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber", ptometryNumber);
        //验光数据
        TryresultsDO tryresultsDO = tryresultsService.getTryresult(map);
        //所有处方【未删除】
        ResultDO resultDO = resultService.getChufangAll(map);
//        KjyyDO kjyyDOList =kjyyServce.chufangall(ptometryNumber,status);
//        KjjyDO kjjyDOList = kjjyService.chufangall(ptometryNumber,status);
//        SgjjDO sgjjDOList =sgjjService.chufangall(ptometryNumber,status);
//        RxjmjcjDO rxjmjcjDOList =rxjmjcjService.chufangall(ptometryNumber,status);
//        ZyDO zyDOList =zyService.chufangall(ptometryNumber,status);
//        SjxlDO sjxlDOList =sjxlService.chufangall(ptometryNumber,status);
//        VstDO vstDOList =vstService.chufangall(ptometryNumber,status);
//        CrtDO crtDOList =crtService.chufangall(ptometryNumber,status);
//        RgpDO rgpDOList =rgpService.chufangall(ptometryNumber,status);
//        YaopinDO yaopinDOList =yaopinService.chufangall(ptometryNumber,status);
//
        model.addAttribute("resultDO", resultDO);
//        model.addAttribute("kjyyDOList", kjyyDOList);
//        model.addAttribute("kjjyDOList", kjjyDOList);
//        model.addAttribute("sgjjDOList", sgjjDOList);
//        model.addAttribute("rxjmjcjDOList", rxjmjcjDOList);
//        model.addAttribute("zyDOList", zyDOList);
//        model.addAttribute("sjxlDOList", sjxlDOList);
//        model.addAttribute("vstDOList", vstDOList);
//        model.addAttribute("crtDOList", crtDOList);
//        model.addAttribute("rgpDOList", rgpDOList);
//        model.addAttribute("yaopinDOList", yaopinDOList);
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

        return "optometryNew/chufangall";
    }


    /**
     * 修改所有验光信息详情
     */
    @GetMapping("/updateShuju/{ptometryNumber}")
    String updateShuju(@PathVariable("ptometryNumber") String ptometryNumber, Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("ptometryNumber", ptometryNumber);
        //验光数据
        TryresultsDO tryresultsDO = tryresultsService.getTryresult(map);
        //所有处方
        ResultDO resultDO = resultService.getChufangAll(map);
        model.addAttribute("resultDO", resultDO);
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

        return "optometryNew/chufangalledit";
    }


}
