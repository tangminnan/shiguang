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
        String newOld=result.getNewOld();
        if (newOld==null || newOld==""){
            result.setNewOld(null);
        }
        String trynewOld=tryresultsDO.getNewOld();
        if (trynewOld==null || trynewOld==""){
            tryresultsDO.setNewOld(null);
        }
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
        if (resultYgnum.size() > 0) {
            if (resultService.update(result) > 0) {
                tryresultsDO.setStatus("0");


                if ("".equals(tryresultsDO.getSphereRightz())) {
                    tryresultsDO.setSphereRightz("0.00");
                }
                if ("".equals(tryresultsDO.getSphereLeftz())) {
                    tryresultsDO.setSphereLeftz("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderRightz())) {
                    tryresultsDO.setCylinderRightz("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderLeftz())) {
                    tryresultsDO.setCylinderLeftz("0.00");
                }

                if ("".equals(tryresultsDO.getSphereRighttry())) {
                    tryresultsDO.setSphereRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getSphereLefttry())) {
                    tryresultsDO.setSphereLefttry("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderRighttry())) {
                    tryresultsDO.setCylinderRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderLefttry())) {
                    tryresultsDO.setCylinderLefttry("0.00");
                }


                if ("".equals(tryresultsDO.getAddRightz())) {
                    tryresultsDO.setAddRightz("0.00");
                }
                if ("".equals(tryresultsDO.getAddLeftz())) {
                    tryresultsDO.setAddLeftz("0.00");
                }


                if ("".equals(tryresultsDO.getAddRighttry())) {
                    tryresultsDO.setAddRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getAddLefttry())) {
                    tryresultsDO.setAddLefttry("0.00");
                }



                tryresultsService.updateStatus(tryresultsDO);


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
                return R.ok();
            }
            return R.error();
        } else {
            if (resultService.save(result) > 0) {
                tryresultsDO.setStatus("0");

                if ("".equals(tryresultsDO.getSphereRightz())) {
                    tryresultsDO.setSphereRightz("0.00");
                }
                if ("".equals(tryresultsDO.getSphereLeftz())) {
                    tryresultsDO.setSphereLeftz("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderRightz())) {
                    tryresultsDO.setCylinderRightz("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderLeftz())) {
                    tryresultsDO.setCylinderLeftz("0.00");
                }

                if ("".equals(tryresultsDO.getSphereRighttry())) {
                    tryresultsDO.setSphereRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getSphereLefttry())) {
                    tryresultsDO.setSphereLefttry("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderRighttry())) {
                    tryresultsDO.setCylinderRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getCylinderLefttry())) {
                    tryresultsDO.setCylinderLefttry("0.00");
                }


                if ("".equals(tryresultsDO.getAddRightz())) {
                    tryresultsDO.setAddRightz("0.00");
                }
                if ("".equals(tryresultsDO.getAddLeftz())) {
                    tryresultsDO.setAddLeftz("0.00");
                }


                if ("".equals(tryresultsDO.getAddRighttry())) {
                    tryresultsDO.setAddRighttry("0.00");
                }
                if ("".equals(tryresultsDO.getAddLefttry())) {
                    tryresultsDO.setAddLefttry("0.00");
                }


                tryresultsService.updateStatus(tryresultsDO);


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
//        ResultDO resultDO = resultService.getChufangAll(map);


        String status="1";
        KjyyDO kjyyDOList =kjyyServce.chufangall(ptometryNumber,status);
        KjjyDO kjjyDOList = kjjyService.chufangall(ptometryNumber,status);
        SgjjDO sgjjDOList =sgjjService.chufangall(ptometryNumber,status);
        RxjmjcjDO rxjmjcjDOList =rxjmjcjService.chufangall(ptometryNumber,status);
        ZyDO zyDOList =zyService.chufangall(ptometryNumber,status);
        SjxlDO sjxlDOList =sjxlService.chufangall(ptometryNumber,status);
        VstDO vstDOList =vstService.chufangall(ptometryNumber,status);
        CrtDO crtDOList =crtService.chufangall(ptometryNumber,status);
        RgpDO rgpDOList =rgpService.chufangall(ptometryNumber,status);
        YaopinDO yaopinDOList =yaopinService.chufangall(ptometryNumber,status);

//        model.addAttribute("resultDO", resultDO);


        if (null!=kjyyDOList){
            model.addAttribute("remove1", "2");
            model.addAttribute("kjyyDoctor", kjyyDOList.getKjyyDoctor());
            model.addAttribute("kjyyOptometryName", kjyyDOList.getKjyyOptometryName());
            model.addAttribute("kjyySphod", kjyyDOList.getKjyySphod());
            model.addAttribute("kjyyCylod", kjyyDOList.getKjyyCylod());
            model.addAttribute("kjyyAxialod", kjyyDOList.getKjyyAxialod());
            model.addAttribute("kjyyPrismod", kjyyDOList.getKjyyPrismod());
            model.addAttribute("kjyyJdod", kjyyDOList.getKjyyJdod());
            model.addAttribute("kjyyYytjod", kjyyDOList.getKjyyYytjod());
            model.addAttribute("kjyyTgod", kjyyDOList.getKjyyTgod());
            model.addAttribute("kjyyVaod", kjyyDOList.getKjyyVaod());
            model.addAttribute("kjyySphos", kjyyDOList.getKjyySphos());
            model.addAttribute("kjyyCylos", kjyyDOList.getKjyyCylos());
            model.addAttribute("kjyyAxialos", kjyyDOList.getKjyyAxialos());
            model.addAttribute("kjyyPrismos", kjyyDOList.getKjyyPrismos());
            model.addAttribute("kjyyJdos", kjyyDOList.getKjyyJdos());
            model.addAttribute("kjyyYytjos", kjyyDOList.getKjyyYytjos());
            model.addAttribute("kjyyTgos", kjyyDOList.getKjyyTgos());
            model.addAttribute("kjyyVaos", kjyyDOList.getKjyyVaos());
            model.addAttribute("kjyyJpcz", kjyyDOList.getKjyyJpcz());
            model.addAttribute("kjyyClfs", kjyyDOList.getKjyyClfs());
            model.addAttribute("kjyyBeizhu", kjyyDOList.getKjyyBeizhu());
        }else {
            model.addAttribute("remove1", "0");
            model.addAttribute("kjyyDoctor", "");
            model.addAttribute("kjyyOptometryName", "");
            model.addAttribute("kjyySphod", "");
            model.addAttribute("kjyyCylod", "");
            model.addAttribute("kjyyAxialod", "");
            model.addAttribute("kjyyPrismod", "");
            model.addAttribute("kjyyJdod", "");
            model.addAttribute("kjyyYytjod", "");
            model.addAttribute("kjyyTgod", "");
            model.addAttribute("kjyyVaod", "");
            model.addAttribute("kjyySphos", "");
            model.addAttribute("kjyyCylos", "");
            model.addAttribute("kjyyAxialos", "");
            model.addAttribute("kjyyPrismos", "");
            model.addAttribute("kjyyJdos", "");
            model.addAttribute("kjyyYytjos", "");
            model.addAttribute("kjyyTgos", "");
            model.addAttribute("kjyyVaos", "");
            model.addAttribute("kjyyJpcz", "");
            model.addAttribute("kjyyClfs", "");
            model.addAttribute("kjyyBeizhu", "");

        }
        if (null!=kjjyDOList){
            model.addAttribute("remove2", "1");
            model.addAttribute("kjjyDoctor", kjjyDOList.getKjjyDoctor());
            model.addAttribute("kjjyOptometryName", kjjyDOList.getKjjyOptometryName());
            model.addAttribute("kjjySphod", kjjyDOList.getKjjySphod());
            model.addAttribute("kjjyCylod", kjjyDOList.getKjjyCylod());
            model.addAttribute("kjjyAxialod", kjjyDOList.getKjjyAxialod());
            model.addAttribute("kjjyPrismod", kjjyDOList.getKjjyPrismod());
            model.addAttribute("kjjyJdod", kjjyDOList.getKjjyJdod());
            model.addAttribute("kjjyYytjod", kjjyDOList.getKjjyYytjod());
            model.addAttribute("kjjyTgod", kjjyDOList.getKjjyTgod());
            model.addAttribute("kjjyVaod", kjjyDOList.getKjjyVaod());
            model.addAttribute("kjjySphos", kjjyDOList.getKjjySphos());
            model.addAttribute("kjjyCylos", kjjyDOList.getKjjyCylos());
            model.addAttribute("kjjyAxialos", kjjyDOList.getKjjyAxialos());
            model.addAttribute("kjjyPrismos", kjjyDOList.getKjjyPrismos());
            model.addAttribute("kjjyJdos", kjjyDOList.getKjjyJdos());
            model.addAttribute("kjjyYytjos", kjjyDOList.getKjjyYytjos());
            model.addAttribute("kjjyTgos", kjjyDOList.getKjjyTgos());
            model.addAttribute("kjjyVaos", kjjyDOList.getKjjyVaos());
            model.addAttribute("kjjyJpcz", kjjyDOList.getKjjyJpcz());
            model.addAttribute("kjjyClfs", kjjyDOList.getKjjyClfs());
            model.addAttribute("kjjyKjlx", kjjyDOList.getKjjyKjlx());
            model.addAttribute("kjjyText", kjjyDOList.getKjjyText());
            model.addAttribute("kjjyBeizhu", kjjyDOList.getKjjyBeizhu());
        }else {
            model.addAttribute("remove2", "0");
            model.addAttribute("kjjyDoctor", "");
            model.addAttribute("kjjyOptometryName", "");
            model.addAttribute("kjjySphod", "");
            model.addAttribute("kjjyCylod", "");
            model.addAttribute("kjjyAxialod", "");
            model.addAttribute("kjjyPrismod", "");
            model.addAttribute("kjjyJdod", "");
            model.addAttribute("kjjyYytjod", "");
            model.addAttribute("kjjyTgod", "");
            model.addAttribute("kjjyVaod", "");
            model.addAttribute("kjjySphos", "");
            model.addAttribute("kjjyCylos", "");
            model.addAttribute("kjjyAxialos", "");
            model.addAttribute("kjjyPrismos", "");
            model.addAttribute("kjjyJdos", "");
            model.addAttribute("kjjyYytjos", "");
            model.addAttribute("kjjyTgos", "");
            model.addAttribute("kjjyVaos", "");
            model.addAttribute("kjjyJpcz", "");
            model.addAttribute("kjjyClfs", "");
            model.addAttribute("kjjyKjlx", "");
            model.addAttribute("kjjyText", "");
            model.addAttribute("kjjyBeizhu", "");

        }

        if (null!=sgjjDOList){
            model.addAttribute("remove3", "3");
            model.addAttribute("sgjjDoctor", sgjjDOList.getSgjjDoctor());
            model.addAttribute("sgjjOptometryName", sgjjDOList.getSgjjOptometryName());
            model.addAttribute("sgjjSphod", sgjjDOList.getSgjjSphod());
            model.addAttribute("sgjjCylod", sgjjDOList.getSgjjCylod());
            model.addAttribute("sgjjAxialod", sgjjDOList.getSgjjAxialod());
            model.addAttribute("sgjjAddod", sgjjDOList.getSgjjAddod());
            model.addAttribute("sgjjYytjod", sgjjDOList.getSgjjYytjod());
            model.addAttribute("sgjjJytjod", sgjjDOList.getSgjjJytjod());
            model.addAttribute("sgjjTgod", sgjjDOList.getSgjjTgod());
            model.addAttribute("sgjjYyvaod", sgjjDOList.getSgjjYyvaod());
            model.addAttribute("sgjjJyvaod", sgjjDOList.getSgjjJyvaod());

            model.addAttribute("sgjjSphos", sgjjDOList.getSgjjSphos());
            model.addAttribute("sgjjCylos", sgjjDOList.getSgjjCylos());
            model.addAttribute("sgjjAxialos", sgjjDOList.getSgjjAxialos());
            model.addAttribute("sgjjAddos", sgjjDOList.getSgjjAddos());
            model.addAttribute("sgjjYytjos", sgjjDOList.getSgjjYytjos());
            model.addAttribute("sgjjJytjos", sgjjDOList.getSgjjJytjos());
            model.addAttribute("sgjjTgos", sgjjDOList.getSgjjTgos());
            model.addAttribute("sgjjYyvaos", sgjjDOList.getSgjjYyvaos());
            model.addAttribute("sgjjJyvaos", sgjjDOList.getSgjjJyvaos());

            model.addAttribute("sgjjJpcz", sgjjDOList.getSgjjJpcz());
            model.addAttribute("sgjjClfs", sgjjDOList.getSgjjClfs());
            model.addAttribute("sgjjKjlx", sgjjDOList.getSgjjKjlx());
            model.addAttribute("sgjjBeizhu", sgjjDOList.getSgjjBeizhu());

        }else {
            model.addAttribute("remove3", "0");
            model.addAttribute("sgjjDoctor", "");
            model.addAttribute("sgjjOptometryName", "");
            model.addAttribute("sgjjSphod", "");
            model.addAttribute("sgjjCylod", "");
            model.addAttribute("sgjjAxialod", "");
            model.addAttribute("sgjjAddod", "");
            model.addAttribute("sgjjYytjod", "");
            model.addAttribute("sgjjJytjod", "");
            model.addAttribute("sgjjTgod", "");
            model.addAttribute("sgjjYyvaod", "");
            model.addAttribute("sgjjJyvaod", "");

            model.addAttribute("sgjjSphos", "");
            model.addAttribute("sgjjCylos", "");
            model.addAttribute("sgjjAxialos", "");
            model.addAttribute("sgjjAddos", "");
            model.addAttribute("sgjjYytjos", "");
            model.addAttribute("sgjjJytjos", "");
            model.addAttribute("sgjjTgos", "");
            model.addAttribute("sgjjYyvaos", "");
            model.addAttribute("sgjjJyvaos", "");
            model.addAttribute("sgjjJpcz", "");
            model.addAttribute("sgjjClfs", "");
            model.addAttribute("sgjjKjlx", "");
            model.addAttribute("sgjjBeizhu", "");

        }



        if (null!=rxjmjcjDOList){
            model.addAttribute("remove4", "5");
            model.addAttribute("rxDoctor", rxjmjcjDOList.getRxDoctor());
            model.addAttribute("rxOptometryName", rxjmjcjDOList.getRxOptometryName());
            model.addAttribute("rxBcod", rxjmjcjDOList.getRxBcod());
            model.addAttribute("rxSphod", rxjmjcjDOList.getRxSphod());
            model.addAttribute("rxCylod", rxjmjcjDOList.getRxCylod());
            model.addAttribute("rxAxialod", rxjmjcjDOList.getRxAxialod());
            model.addAttribute("rxZjod", rxjmjcjDOList.getRxZjod());
            model.addAttribute("rxVaod", rxjmjcjDOList.getRxVaod());
            model.addAttribute("rxSyjpod", rxjmjcjDOList.getRxSyjpod());
            model.addAttribute("rxUnitod", rxjmjcjDOList.getRxUnitod());

            model.addAttribute("rxBcos", rxjmjcjDOList.getRxBcos());
            model.addAttribute("rxSphos", rxjmjcjDOList.getRxSphos());
            model.addAttribute("rxCylos", rxjmjcjDOList.getRxCylos());
            model.addAttribute("rxAxialos", rxjmjcjDOList.getRxAxialos());
            model.addAttribute("rxZjos", rxjmjcjDOList.getRxZjos());
            model.addAttribute("rxVaos", rxjmjcjDOList.getRxVaos());
            model.addAttribute("rxSyjpos", rxjmjcjDOList.getRxSyjpos());
            model.addAttribute("rxUnitos", rxjmjcjDOList.getRxUnitos());

            model.addAttribute("rxClfs", rxjmjcjDOList.getRxClfs());
            model.addAttribute("rxHlypz", rxjmjcjDOList.getRxHlypz());
            model.addAttribute("rxBeizhu", rxjmjcjDOList.getRxBeizhu());

        }else {
            model.addAttribute("remove4", "0");
            model.addAttribute("rxDoctor", "");
            model.addAttribute("rxOptometryName", "");
            model.addAttribute("rxBcod", "");
            model.addAttribute("rxSphod", "");
            model.addAttribute("rxCylod", "");
            model.addAttribute("rxAxialod", "");
            model.addAttribute("rxZjod", "");
            model.addAttribute("rxVaod", "");
            model.addAttribute("rxSyjpod", "");
            model.addAttribute("rxUnitod", "");

            model.addAttribute("rxBcos", "");
            model.addAttribute("rxSphos", "");
            model.addAttribute("rxCylos", "");
            model.addAttribute("rxAxialos", "");
            model.addAttribute("rxZjos", "");
            model.addAttribute("rxVaos", "");
            model.addAttribute("rxSyjpos", "");
            model.addAttribute("rxUnitos", "");
            model.addAttribute("rxClfs", "");
            model.addAttribute("rxHlypz", "");
            model.addAttribute("rxBeizhu", "");
        }


        if (null!=zyDOList){
            model.addAttribute("remove5", "4");
            model.addAttribute("zyDoctor", zyDOList.getZyDoctor());
            model.addAttribute("zyOptometryName", zyDOList.getZyOptometryName());
            model.addAttribute("zySphod", zyDOList.getZySphod());
            model.addAttribute("zyCylod", zyDOList.getZyCylod());
            model.addAttribute("zyAxialod", zyDOList.getZyAxialod());
            model.addAttribute("zyPrismod", zyDOList.getZyPrismod());
            model.addAttribute("zyJdod", zyDOList.getZyJdod());
            model.addAttribute("zyZytjod", zyDOList.getZyZytjod());
            model.addAttribute("zyTgod", zyDOList.getZyTgod());
            model.addAttribute("zyVaod", zyDOList.getZyVaod());

            model.addAttribute("zySphos", zyDOList.getZySphos());
            model.addAttribute("zyCylos", zyDOList.getZyCylos());
            model.addAttribute("zyAxialos", zyDOList.getZyAxialos());
            model.addAttribute("zyPrismos", zyDOList.getZyPrismos());
            model.addAttribute("zyJdos", zyDOList.getZyJdos());
            model.addAttribute("zyZytjos", zyDOList.getZyZytjos());
            model.addAttribute("zyTgos", zyDOList.getZyTgos());
            model.addAttribute("zyVaos", zyDOList.getZyVaos());

            model.addAttribute("zyJpcz", zyDOList.getZyJpcz());
            model.addAttribute("zyClfs", zyDOList.getZyClfs());
            model.addAttribute("zyJklx", zyDOList.getZyJklx());
            model.addAttribute("zyText", zyDOList.getZyText());
            model.addAttribute("zyBeizhu", zyDOList.getZyBeizhu());

        }else {
            model.addAttribute("remove5", "0");
            model.addAttribute("zyDoctor", "");
            model.addAttribute("zyOptometryName", "");
            model.addAttribute("zySphod", "");
            model.addAttribute("zyCylod", "");
            model.addAttribute("zyAxialod", "");
            model.addAttribute("zyPrismod", "");
            model.addAttribute("zyJdod", "");
            model.addAttribute("zyZytjod", "");
            model.addAttribute("zyTgod", "");
            model.addAttribute("zyVaod", "");

            model.addAttribute("zySphos", "");
            model.addAttribute("zyCylos", "");
            model.addAttribute("zyAxialos", "");
            model.addAttribute("zyPrismos", "");
            model.addAttribute("zyJdos", "");
            model.addAttribute("zyZytjos", "");
            model.addAttribute("zyTgos", "");
            model.addAttribute("zyVaos", "");
            model.addAttribute("zyJpcz", "");
            model.addAttribute("zyClfs", "");
            model.addAttribute("zyJklx", "");
            model.addAttribute("zyText", "");
            model.addAttribute("zyBeizhu", "");

        }

        if (null!=sjxlDOList){
            model.addAttribute("remove6", "7");
            model.addAttribute("sjxlDoctor", sjxlDOList.getSjxlDoctor());
            model.addAttribute("sjxlOptometryName", sjxlDOList.getSjxlOptometryName());
            model.addAttribute("sjxlSphod", sjxlDOList.getSjxlSphod());
            model.addAttribute("sjxlCylod", sjxlDOList.getSjxlCylod());
            model.addAttribute("sjxlAxialod", sjxlDOList.getSjxlAxialod());
            model.addAttribute("sjxlSljod", sjxlDOList.getSjxlSljod());
            model.addAttribute("sjxlJdod", sjxlDOList.getSjxlJdod());
            model.addAttribute("sjxlYytjod", sjxlDOList.getSjxlYytjod());
            model.addAttribute("sjxlJytjod", sjxlDOList.getSjxlJytjod());
            model.addAttribute("sjxlTgod", sjxlDOList.getSjxlTgod());
            model.addAttribute("sjxlYyvaod", sjxlDOList.getSjxlYyvaod());
            model.addAttribute("sjxlJyvaod", sjxlDOList.getSjxlJyvaod());

            model.addAttribute("sjxlSphos", sjxlDOList.getSjxlSphos());
            model.addAttribute("sjxlCylos", sjxlDOList.getSjxlCylos());
            model.addAttribute("sjxlAxialos", sjxlDOList.getSjxlAxialos());
            model.addAttribute("sjxlSljos", sjxlDOList.getSjxlSljos());
            model.addAttribute("sjxlJdos", sjxlDOList.getSjxlJdos());
            model.addAttribute("sjxlYytjos", sjxlDOList.getSjxlYytjos());
            model.addAttribute("sjxlJytjos", sjxlDOList.getSjxlJytjos());
            model.addAttribute("sjxlTgos", sjxlDOList.getSjxlTgos());
            model.addAttribute("sjxlYyvaos", sjxlDOList.getSjxlYyvaos());
            model.addAttribute("sjxlJyvaos", sjxlDOList.getSjxlJyvaos());

            model.addAttribute("sjxlJtxl", sjxlDOList.getSjxlJtxl());
            model.addAttribute("sjxlXlsxl", sjxlDOList.getSjxlXlsxl());
            model.addAttribute("sjxlBeizhu", sjxlDOList.getSjxlBeizhu());


        }else {
            model.addAttribute("remove6", "0");
            model.addAttribute("sjxlDoctor", "");
            model.addAttribute("sjxlOptometryName", "");
            model.addAttribute("sjxlSphod", "");
            model.addAttribute("sjxlCylod", "");
            model.addAttribute("sjxlAxialod", "");
            model.addAttribute("sjxlSljod", "");
            model.addAttribute("sjxlYytjod", "");
            model.addAttribute("sjxlJytjod", "");
            model.addAttribute("sjxlTgod", "");
            model.addAttribute("sjxlYyvaod", "");
            model.addAttribute("sjxlJyvaod", "");

            model.addAttribute("sjxlSphos", "");
            model.addAttribute("sjxlCylos", "");
            model.addAttribute("sjxlAxialos", "");
            model.addAttribute("sjxlSljos", "");
            model.addAttribute("sjxlYytjos", "");
            model.addAttribute("sjxlJytjos", "");
            model.addAttribute("sjxlTgos", "");
            model.addAttribute("sjxlYyvaos", "");
            model.addAttribute("sjxlJyvaos", "");
            model.addAttribute("sjxlJtxl", "");
            model.addAttribute("sjxlXlsxl", "");
            model.addAttribute("sjxlBeizhu", "");
        }

        if (null!=vstDOList){
            model.addAttribute("remove7", "8");
            model.addAttribute("vstDoctor", vstDOList.getVstDoctor());
            model.addAttribute("vstOptometryName", vstDOList.getVstOptometryName());
            model.addAttribute("vstSphod", vstDOList.getVstSphod());
            model.addAttribute("vstCylod", vstDOList.getVstCylod());
            model.addAttribute("vstAxialod", vstDOList.getVstAxialod());
            model.addAttribute("vstSdbhod", vstDOList.getVstSdbhod());
            model.addAttribute("vstFkod", vstDOList.getVstFkod());
            model.addAttribute("vstQlbjod", vstDOList.getVstQlbjod());
            model.addAttribute("vstAcod", vstDOList.getVstAcod());
            model.addAttribute("vstJfod", vstDOList.getVstJfod());
            model.addAttribute("vstDiaod", vstDOList.getVstDiaod());
            model.addAttribute("vstBcod", vstDOList.getVstBcod());
            model.addAttribute("vstCpclyod", vstDOList.getVstCpclyod());
            model.addAttribute("vstEod", vstDOList.getVstEod());
            model.addAttribute("vstVaod", vstDOList.getVstVaod());
            model.addAttribute("vstJpysod", vstDOList.getVstJpysod());
            model.addAttribute("vstSyjpod", vstDOList.getVstSyjpod());

            model.addAttribute("vstSphos", vstDOList.getVstSphos());
            model.addAttribute("vstCylos", vstDOList.getVstCylos());
            model.addAttribute("vstAxialos", vstDOList.getVstAxialos());
            model.addAttribute("vstSdbhos", vstDOList.getVstSdbhos());
            model.addAttribute("vstFkos", vstDOList.getVstFkos());
            model.addAttribute("vstQlbjos", vstDOList.getVstQlbjos());
            model.addAttribute("vstAcos", vstDOList.getVstAcos());
            model.addAttribute("vstJfos", vstDOList.getVstJfos());
            model.addAttribute("vstDiaos", vstDOList.getVstDiaos());
            model.addAttribute("vstBcos", vstDOList.getVstBcos());
            model.addAttribute("vstCpclyos", vstDOList.getVstCpclyos());
            model.addAttribute("vstEos", vstDOList.getVstEos());
            model.addAttribute("vstVaos", vstDOList.getVstVaos());
            model.addAttribute("vstJpysos", vstDOList.getVstJpysos());
            model.addAttribute("vstSyjpos", vstDOList.getVstSyjpos());
            model.addAttribute("vstBeizhu", vstDOList.getVstBeizhu());


        }else {
            model.addAttribute("remove7", "0");
            model.addAttribute("vstDoctor", "");
            model.addAttribute("vstOptometryName", "");
            model.addAttribute("vstSphod", "");
            model.addAttribute("vstCylod", "");
            model.addAttribute("vstAxialod", "");
            model.addAttribute("vstSdbhod", "");
            model.addAttribute("vstFkod", "");
            model.addAttribute("vstQlbjod", "");
            model.addAttribute("vstAcod", "");
            model.addAttribute("vstJfod", "");
            model.addAttribute("vstDiaod", "");
            model.addAttribute("vstBcod", "");
            model.addAttribute("vstCpclyod", "");
            model.addAttribute("vstEod", "");
            model.addAttribute("vstVaod", "");
            model.addAttribute("vstJpysod", "");
            model.addAttribute("vstSyjpod", "");

            model.addAttribute("vstSphos", "");
            model.addAttribute("vstCylos", "");
            model.addAttribute("vstAxialos", "");
            model.addAttribute("vstSdbhos", "");
            model.addAttribute("vstFkos", "");
            model.addAttribute("vstQlbjos", "");
            model.addAttribute("vstAcos", "");
            model.addAttribute("vstJfos", "");
            model.addAttribute("vstDiaos", "");
            model.addAttribute("vstBcos", "");
            model.addAttribute("vstCpclyos", "");
            model.addAttribute("vstEos", "");
            model.addAttribute("vstVaos", "");
            model.addAttribute("vstJpysos", "");
            model.addAttribute("vstSyjpos", "");
            model.addAttribute("vstBeizhu", "");
        }

        if (null!=crtDOList){
            model.addAttribute("remove8", "9");
            model.addAttribute("crtDoctor", crtDOList.getCrtDoctor());
            model.addAttribute("crtOptometryName", crtDOList.getCrtOptometryName());
            model.addAttribute("crtSphod", crtDOList.getCrtSphod());
            model.addAttribute("crtCylod", crtDOList.getCrtCylod());
            model.addAttribute("crtAxialod", crtDOList.getCrtAxialod());
            model.addAttribute("crtSdbhod", crtDOList.getCrtSdbhod());
            model.addAttribute("ctrBcod", crtDOList.getCtrBcod());
            model.addAttribute("crtRzdod", crtDOList.getCrtRzdod());
            model.addAttribute("crtLzaod", crtDOList.getCrtLzaod());
            model.addAttribute("crtRzd2od", crtDOList.getCrtRzd2od());
            model.addAttribute("crtLza2od", crtDOList.getCrtLza2od());
            model.addAttribute("crtJfod", crtDOList.getCrtJfod());
            model.addAttribute("crtDiaod", crtDOList.getCrtDiaod());
            model.addAttribute("crtVaod", crtDOList.getCrtVaod());
            model.addAttribute("crtJpysod", crtDOList.getCrtJpysod());
            model.addAttribute("crtSyjpod", crtDOList.getCrtSyjpod());

            model.addAttribute("crtSphos", crtDOList.getCrtSphos());
            model.addAttribute("crtCylos", crtDOList.getCrtCylos());
            model.addAttribute("crtAxialos", crtDOList.getCrtAxialos());
            model.addAttribute("crtSdbhos", crtDOList.getCrtSdbhos());
            model.addAttribute("ctrBcos", crtDOList.getCrtBcos());
            model.addAttribute("crtRzdos", crtDOList.getCrtRzdos());
            model.addAttribute("crtLzaos", crtDOList.getCrtLzaos());
            model.addAttribute("crtRzd2os", crtDOList.getCrtRzd2os());
            model.addAttribute("crtLza2os", crtDOList.getCrtLza2os());
            model.addAttribute("crtJfos", crtDOList.getCrtJfos());
            model.addAttribute("crtDiaos", crtDOList.getCrtDiaos());
            model.addAttribute("crtVaos", crtDOList.getCrtVaos());
            model.addAttribute("crtJpysos", crtDOList.getCrtJpysos());
            model.addAttribute("crtSyjpos", crtDOList.getCrtSyjpos());

            model.addAttribute("crtBeizhu", crtDOList.getCrtBeizhu());
        }else {
            model.addAttribute("remove8", "0");
            model.addAttribute("crtDoctor", "");
            model.addAttribute("crtOptometryName", "");
            model.addAttribute("crtSphod", "");
            model.addAttribute("crtCylod", "");
            model.addAttribute("crtAxialod", "");
            model.addAttribute("crtSdbhod", "");
            model.addAttribute("ctrBcod", "");
            model.addAttribute("crtRzdod", "");
            model.addAttribute("crtLzaod", "");
            model.addAttribute("crtRzd2od", "");
            model.addAttribute("crtLza2od", "");
            model.addAttribute("crtJfod", "");
            model.addAttribute("crtDiaod", "");
            model.addAttribute("crtVaod", "");
            model.addAttribute("crtSyjpod", "");

            model.addAttribute("crtSphos", "");
            model.addAttribute("crtCylos", "");
            model.addAttribute("crtAxialos", "");
            model.addAttribute("crtSdbhos", "");
            model.addAttribute("ctrBcos", "");
            model.addAttribute("crtRzdos", "");
            model.addAttribute("crtLzaos", "");
            model.addAttribute("crtRzd2os", "");
            model.addAttribute("crtLza2os", "");
            model.addAttribute("crtJfos", "");
            model.addAttribute("crtDiaos", "");
            model.addAttribute("crtVaos", "");
            model.addAttribute("crtSyjpos", "");
            model.addAttribute("crtBeizhu", "");
        }

        if (null!=rgpDOList){
            model.addAttribute("remove9", "10");
            model.addAttribute("rgpDoctor", rgpDOList.getRgpDoctor());
            model.addAttribute("rgpOptometryName", rgpDOList.getRgpOptometryName());
            model.addAttribute("rgpSphod", rgpDOList.getRgpSphod());
            model.addAttribute("rgpCylod", rgpDOList.getRgpCylod());
            model.addAttribute("rgpAxialod", rgpDOList.getRgpAxialod());
            model.addAttribute("rgpQgdod", rgpDOList.getRgpQgdod());
            model.addAttribute("rgpBcod", rgpDOList.getRgpBcod());
            model.addAttribute("rgpDiaod", rgpDOList.getRgpDiaod());
            model.addAttribute("rgpSgod", rgpDOList.getRgpSgod());
            model.addAttribute("rgpJpysod", rgpDOList.getRgpJpysod());
            model.addAttribute("rgpTssjod", rgpDOList.getRgpTssjod());
            model.addAttribute("rgpSyjpod", rgpDOList.getRgpSyjpod());

            model.addAttribute("rgpSphos", rgpDOList.getRgpSphos());
            model.addAttribute("rgpCylos", rgpDOList.getRgpCylos());
            model.addAttribute("rgpAxialos", rgpDOList.getRgpAxialos());
            model.addAttribute("rgpQgdos", rgpDOList.getRgpQgdos());
            model.addAttribute("rgpBcos", rgpDOList.getRgpBcos());
            model.addAttribute("rgpDiaos", rgpDOList.getRgpDiaos());
            model.addAttribute("rgpSgos", rgpDOList.getRgpSgos());
            model.addAttribute("rgpJpysos", rgpDOList.getRgpJpysos());
            model.addAttribute("rgpTssjos", rgpDOList.getRgpTssjos());
            model.addAttribute("rgpSyjpos", rgpDOList.getRgpSyjpos());


            model.addAttribute("rgpBeizhu", rgpDOList.getRgpBeizhu());

        }else {
            model.addAttribute("remove9", "0");
            model.addAttribute("rgpDoctor", "");
            model.addAttribute("rgpOptometryName", "");
            model.addAttribute("rgpSphod", "");
            model.addAttribute("rgpCylod", "");
            model.addAttribute("rgpAxialod", "");
            model.addAttribute("rgpQgdod", "");
            model.addAttribute("rgpBcod", "");
            model.addAttribute("rgpDiaod", "");
            model.addAttribute("rgpSgod", "");
            model.addAttribute("rgpJpysod", "");
            model.addAttribute("rgpTssjod", "");
            model.addAttribute("rgpSyjpod", "");

            model.addAttribute("rgpSphos", "");
            model.addAttribute("rgpCylos", "");
            model.addAttribute("rgpAxialos", "");
            model.addAttribute("rgpQgdos", "");
            model.addAttribute("rgpBcos", "");
            model.addAttribute("rgpDiaos", "");
            model.addAttribute("rgpSgos", "");
            model.addAttribute("rgpJpysos", "");
            model.addAttribute("rgpTssjos", "");
            model.addAttribute("rgpSyjpos", "");

            model.addAttribute("rgpBeizhu", "");

        }

        if (null!=yaopinDOList){
            model.addAttribute("remove10", "11");
            model.addAttribute("ypDoctor", yaopinDOList.getYpDoctor());
            model.addAttribute("ypOptometryName", yaopinDOList.getYpOptometryName());
            model.addAttribute("ypNr", yaopinDOList.getYpNr());
            model.addAttribute("ypYm", yaopinDOList.getYpYm());

        }else {
            model.addAttribute("remove10", "0");
            model.addAttribute("ypDoctor","");
            model.addAttribute("ypOptometryName", "");
            model.addAttribute("ypNr", "");
            model.addAttribute("ypYm", "");
        }



        if (tryresultsDO != null ){
            if (tryresultsDO.getSex() == 0) {
                tryresultsDO.setSexx("男");
            } else {
                tryresultsDO.setSexx("女");
            }
            SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = tryresultsDO.getCreateTime();
            String newtime = sdftime.format(time);
            model.addAttribute("newtime", newtime);
            model.addAttribute("tryresultsDO", tryresultsDO);
        } else {
            ResultDetailDO resultDO1 = resultService.getresult(map);
            if (resultDO1.getSex() == 0) {
                resultDO1.setSexx("男");
            } else {
                resultDO1.setSexx("女");
            }
            model.addAttribute("tryresultsDO", resultDO1);
        }

        //————————————————散瞳用药————————————————————————————————
        List<PharmacyDO> pharmacyDOList = pharmacyService.list(map);
        model.addAttribute("pharmacyDOList", pharmacyDOList);


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
