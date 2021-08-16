package com.shiguang.optometryNEW.controller;

import com.shiguang.common.utils.*;
import com.shiguang.jiancha.domain.PharmacyDO;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.domain.YizhuDO;
import com.shiguang.jiancha.service.PharmacyService;
import com.shiguang.jiancha.service.SubjectiveService;
import com.shiguang.jiancha.service.TryresultsService;
import com.shiguang.jiancha.service.YizhuService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OcularEyesDO;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.service.OcularEyesService;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.service.HlyService;
import com.shiguang.product.service.ShiguangService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("OptometryNewController")
@RequestMapping("/information/optometryNew")
public class OptometryNewController {
    //客观验光
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private ResultDiopterService resultDiopterService;
    @Autowired
    private MemberService memberService;
    //眼生物
    @Autowired
    private OcularEyesService ocularEyesService;
    //散瞳用药
    @Autowired
    private PharmacyService pharmacyService;
    //主观验光
    @Autowired
    private SubjectiveService subjectiveService;
    //试戴镜
    @Autowired
    private TryresultsService tryresultsService;
    //医嘱
    @Autowired
    private YizhuService yizhuService;
    //护理液
    @Autowired
    private HlyService hlyService;
    //视光-----视觉训练
    @Autowired
    private ShiguangService shiguangService;


    @GetMapping()
    @RequiresPermissions("information:optometryNew:optometryNew")
    String Optometry() {
        return "optometryNew/optometryNew";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryNew:optometryNew")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state", 1);
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:optometryNew:add")
    String add() {
        return "optometryNew/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:optometryNew:edit")
    String edit(@PathVariable("cardNumber") String cardNumber, Model model) {
//————会员信息——————
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO", memberDO);

//—————眼生物学参数———————
        Map<String, Object> map = new HashMap<>();
        List<OcularEyesDO> list = ocularEyesService.list(cardNumber);
        OcularEyesDO ocularEyesDO = new OcularEyesDO();
        if (list.size() > 0) {
            //眼轴
            ocularEyesDO.setAxis(list.get(0).getAxis());
            ocularEyesDO.setAxisLeft(list.get(0).getAxisLeft());
            //k1
            ocularEyesDO.setCornealFirstK1Right(list.get(0).getCornealFirstK1Right());
            ocularEyesDO.setCornealLastK1Right(list.get(0).getCornealLastK1Right());
            ocularEyesDO.setCornealFirstK1Left(list.get(0).getCornealFirstK1Left());
            ocularEyesDO.setCornealLastK1Left(list.get(0).getCornealLastK1Left());
            //k2
            ocularEyesDO.setCornealFirstK2Right(list.get(0).getCornealFirstK2Right());
            ocularEyesDO.setCornealLastK2Right(list.get(0).getCornealLastK2Right());
            ocularEyesDO.setCornealFirstK2Left(list.get(0).getCornealFirstK2Left());
            ocularEyesDO.setCornealLastK2Left(list.get(0).getCornealLastK2Left());
            //眼压
            ocularEyesDO.setIntraocularOd(list.get(0).getIntraocularOd());
            ocularEyesDO.setIntraocularOs(list.get(0).getIntraocularOs());
            //平均K
            ocularEyesDO.setPjkOd(list.get(0).getPjkOd());
            ocularEyesDO.setPjkOs(list.get(0).getPjkOs());
            //瞳距
            ocularEyesDO.setPupilSizeRight(list.get(0).getPupilSizeRight());
            ocularEyesDO.setPupilSizeLeft(list.get(0).getPupilSizeLeft());
        }
        model.addAttribute("ocularEyesDO", ocularEyesDO);
//————————————————散瞳用药————————————————————————————————
        //制造商
        List<PharmacyDO> pharmacyDOList = pharmacyService.list(map);
        model.addAttribute("pharmacyDOList", pharmacyDOList);

//————电脑验光————
        List<OptometryDO> optoList = optometryService.optoList(map);
        OptometryDO optometryDO = new OptometryDO();
        if (optoList.size() > 0) {
            //检影--球镜
            optometryDO.setSphJyod(optoList.get(0).getSphJyod());
            optometryDO.setSphJyos(optoList.get(0).getSphJyos());
            //柱镜
            optometryDO.setCylJyod(optoList.get(0).getCylJyod());
            optometryDO.setCylJyos(optoList.get(0).getCylJyos());
            //轴向
            optometryDO.setAxialJyod(optoList.get(0).getAxialJyod());
            optometryDO.setAxialJyos(optoList.get(0).getAxialJyos());
            //VA
            optometryDO.setVaJyod(optoList.get(0).getVaJyod());
            optometryDO.setVaJyos(optoList.get(0).getVaJyos());
            //瞳距
            optometryDO.setPdJyod(optoList.get(0).getPdJyod());
            optometryDO.setPdJyos(optoList.get(0).getPdJyos());
            //插片--球镜
            optometryDO.setSphCpod(optoList.get(0).getSphCpod());
            optometryDO.setSphCpos(optoList.get(0).getSphCpos());
            //柱镜
            optometryDO.setCylCpod(optoList.get(0).getCylCpod());
            optometryDO.setCylCpos(optoList.get(0).getCylCpos());
            //轴向
            optometryDO.setAxialCpod(optoList.get(0).getAxialCpod());
            optometryDO.setAxialCpos(optoList.get(0).getAxialCpos());
            //DVA
            optometryDO.setDvaCpod(optoList.get(0).getDvaCpod());
            optometryDO.setDvaCpos(optoList.get(0).getDvaCpos());
            //NVA
            optometryDO.setNvaCpod(optoList.get(0).getNvaCpod());
            optometryDO.setNvaCpos(optoList.get(0).getNvaCpos());
            //Add
            optometryDO.setAddCpod(optoList.get(0).getAddCpod());
            optometryDO.setAddCpos(optoList.get(0).getAddCpos());
            //测量距离
            optometryDO.setDistanceOd(optoList.get(0).getDistanceOd());
            optometryDO.setDistanceOs(optoList.get(0).getDistanceOs());

        }
        model.addAttribute("optometryDO", optometryDO);
        //散瞳前
        List<OptometryDO> list1 = optometryService.optoFrontList(cardNumber);
        OptometryDO optometryFrontDO = new OptometryDO();
        if (list1.size() > 0) {
            optometryFrontDO.setCylinderRight(list1.get(0).getCylinderRight());
            optometryFrontDO.setCylinderLeft(list1.get(0).getCylinderLeft());
            optometryFrontDO.setAxialRight(list1.get(0).getAxialRight());
            optometryFrontDO.setAxialLeft(list1.get(0).getAxialLeft());
            optometryFrontDO.setSphereRight(list1.get(0).getSphereRight());
            optometryFrontDO.setSphereLeft(list1.get(0).getSphereLeft());
            //角膜散光
            optometryFrontDO.setCornealAstigmatismOd(list1.get(0).getCornealAstigmatismOd());
            optometryFrontDO.setCornealAstigmatismOs(list1.get(0).getCornealAstigmatismOs());

        }
        model.addAttribute("optometryFrontDO", optometryFrontDO);

        //散瞳后
        List<OptometryDO> list2 = optometryService.optoAfterList(cardNumber);
        OptometryDO optometryAfterDO = new OptometryDO();
        if (list2.size() > 0) {
            optometryAfterDO.setMydriasis(list2.get(0).getMydriasis());
            optometryAfterDO.setCylinderRight(list2.get(0).getCylinderRight());
            optometryAfterDO.setCylinderLeft(list2.get(0).getCylinderLeft());
            optometryAfterDO.setAxialRight(list2.get(0).getAxialRight());
            optometryAfterDO.setAxialLeft(list2.get(0).getAxialLeft());
            optometryAfterDO.setSphereRight(list2.get(0).getSphereRight());
            optometryAfterDO.setSphereLeft(list2.get(0).getSphereLeft());
            //角膜散光
            optometryAfterDO.setCornealAstigmatismOd(list2.get(0).getCornealAstigmatismOd());
            optometryAfterDO.setCornealAstigmatismOs(list2.get(0).getCornealAstigmatismOs());
        }
        model.addAttribute("optometryAfterDO", optometryAfterDO);

//———生成验光号————
        Long uuid = GuuidUtil.getUUID();
        String uuidstr = "Y" + uuid.toString();
        model.addAttribute("uuidstr", uuidstr);
//———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
//———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("createTime", newDate);

        return "optometryNew/edit";
    }

    //检查结论
    @GetMapping("/jianchajielun/{cardNumber}")
    String jianchajielun(@PathVariable("cardNumber") String cardNumber, Model model,HttpServletRequest request) {
         request.getParameter("cardNumber");

        //————会员信息——————
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO", memberDO);
        //————试戴镜结论————
        //根据人查相对应的验光号医生时间等信息
        List<TryresultsDO> trylist = tryresultsService.listUser(cardNumber);
        TryresultsDO tryresultsDO = new TryresultsDO();
        if (trylist.size() > 0) {
            for (int i = 0; i < trylist.size(); i++) {
                //验光信息
                tryresultsDO.setPtometryNumber(trylist.get(0).getPtometryNumber());
                tryresultsDO.setOptometryName(trylist.get(0).getOptometryName());
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = trylist.get(0).getCreateTime();
                String newtime = sdftime.format(time);
                model.addAttribute("newtime", newtime);
                tryresultsDO.setSphereRighttry(trylist.get(0).getSphereRighttry());
                tryresultsDO.setSphereLefttry(trylist.get(0).getSphereLefttry());

                tryresultsDO.setCylinderRighttry(trylist.get(0).getCylinderRighttry());
                tryresultsDO.setCylinderLefttry(trylist.get(0).getCylinderLefttry());

                tryresultsDO.setAxialRighttry(trylist.get(0).getAxialRighttry());
                tryresultsDO.setAxialLefttry(trylist.get(0).getAxialLefttry());

                tryresultsDO.setDvaRighttry(trylist.get(0).getDvaRighttry());
                tryresultsDO.setDvaLefttry(trylist.get(0).getDvaLefttry());

                tryresultsDO.setNvaRighttry(trylist.get(0).getNvaRighttry());
                tryresultsDO.setNvaLefttry(trylist.get(0).getNvaLefttry());

                tryresultsDO.setPrismRighttry(trylist.get(0).getPrismRighttry());
                tryresultsDO.setPrismLefttry(trylist.get(0).getPrismLefttry());

                tryresultsDO.setJdrTry(trylist.get(0).getJdrTry());
                tryresultsDO.setJdlTry(trylist.get(0).getJdlTry());

                tryresultsDO.setHeightRighttry(trylist.get(0).getHeightRighttry());
                tryresultsDO.setHeightLefttry(trylist.get(0).getHeightLefttry());

                tryresultsDO.setAddRighttry(trylist.get(0).getAddRighttry());
                tryresultsDO.setAddLefttry(trylist.get(0).getAddLefttry());

                tryresultsDO.setYuanRrty(trylist.get(0).getYuanRrty());
                tryresultsDO.setYuanLrty(trylist.get(0).getYuanLrty());

                tryresultsDO.setNearRighttry(trylist.get(0).getNearRighttry());
                tryresultsDO.setNearLefttry(trylist.get(0).getNearLefttry());


            }
        }

        model.addAttribute("tryresultsDO", tryresultsDO);
        return "optometryNew/jianchajielun";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:optometryNew:add")
    public R save(OptometryDO optometry) {
//视力shiliService;//眼生物ocularEyesService;//主观验光subjectiveService;//试戴镜tryresultsService;
        if (optometryService.save(optometry) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:optometryNew:edit")
    public R update(OptometryDO optometry) {
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:optometryNew:remove")
    public R remove(Long id) {
        if (optometryService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:optometryNew:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        optometryService.batchRemove(ids);
        return R.ok();
    }

    //跳转医嘱页面
    @GetMapping("/yizhu")
    @RequiresPermissions("information:optometryNew:yizhu")
    String yizhu() {
        return "jiancha/yizhu/yizhu";
    }

    /**
     * 选择医嘱
     */
    @ResponseBody
    @GetMapping("/yizhulist")
    @RequiresPermissions("information:optometryNew:yizhu")
    public PageUtils yizhulist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<YizhuDO> yizhulist = yizhuService.findYizhu(query);
        int total = yizhuService.countYizhu(query);
        PageUtils pageUtils = new PageUtils(yizhulist, total);
        return pageUtils;
    }

    //跳转护理液
    @GetMapping("/hly")
    @RequiresPermissions("information:optometryNew:hly")
    String hly() {
        return "product/hly/gethly";
    }

    //选择护理液
    @ResponseBody
    @GetMapping("/hlylist")
    @RequiresPermissions("information:optometryNew:hly")
    public PageUtils hlylist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<HlyDO> hlylist = hlyService.gethly(query);
        int total = hlyService.count(query);
        PageUtils pageUtils = new PageUtils(hlylist, total);
        return pageUtils;
    }

    //跳转视光---视觉训练
    @GetMapping("/shiguang")
    @RequiresPermissions("information:optometryNew:shiguang")
    String shiguang() {
        return "product/shiguang/getshiguang";
    }

    //选择视光---视觉训练
    @ResponseBody
    @GetMapping("/shiguanglist")
    @RequiresPermissions("information:optometryNew:hly")
    public PageUtils shiguanglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShiguangDO> shiguanglist = shiguangService.getshiguang(query);
        int total = shiguangService.count(query);
        PageUtils pageUtils = new PageUtils(shiguanglist, total);
        return pageUtils;
    }

}
