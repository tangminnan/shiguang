package com.shiguang.optometryNEW.controller;

import com.shiguang.common.utils.*;
import com.shiguang.jiancha.domain.PharmacyDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.domain.YizhuDO;
import com.shiguang.jiancha.service.*;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.*;
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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("OptometryNewController")
@RequestMapping("/information/optometryNew")
public class OptometryNewController {
    //客观验光
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private MemberService memberService;
    //眼生物
    @Autowired
    private OcularEyesService ocularEyesService;
    //散瞳用药
    @Autowired
    private PharmacyService pharmacyService;


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
    //查询会员
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryNew:optometryNew")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if (query.get("cardNumber") != "" || query.get("name") !="" || query.get("phone1") != ""){
            query.put("companyId","");
        }else  {
            query.put("companyId",companyId);
        }
        query.put("status", 0);
        query.put("state", 1);
        List<MemberDO> memberDOList = memberService.yanguangList(query);
        int total = memberService.yanguangCount(query);
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
//———生成验光号————
        Long uuid = GuuidUtil.getUUID();
        String uuidstr = "Y" + uuid.toString();
        model.addAttribute("uuidstr", uuidstr);
//———获取当前登录用户的名称————
        model.addAttribute("optometryName", ShiroUtils.getUser().getName());
        //———获取当前登录用户的名称————
        model.addAttribute("companyId", ShiroUtils.getUser().getCompanyId());
//———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("createTime", newDate);

//—————眼生物学参数———————
        Map<String, Object> map = new HashMap<>();
        map.put("cardNumber",cardNumber);
        //时间
        Calendar now = Calendar.getInstance();
        Integer year= now.get(Calendar.YEAR);
        Integer month= now.get(Calendar.MONTH)+1;
        Integer day= now.get(Calendar.DAY_OF_MONTH);
        String createTime= String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
        map.put("createTime",createTime);
        List<OcularEyesDO> list = ocularEyesService.list(map);
        OcularEyesDO ocularEyesDO = new OcularEyesDO();
        if (list.size() > 0) {
            //眼轴
            ocularEyesDO.setAxis(list.get(0).getAxis());
            ocularEyesDO.setAxisLeft(list.get(0).getAxisLeft());
            //k1
            Double k1OD1=list.get(0).getCornealFirstK1Right();//角膜曲率K1OD1
            ocularEyesDO.setCornealFirstK1Right(k1OD1);

            Double k1OD2=list.get(0).getCornealLastK1Right();//角膜曲率K1OD2
            ocularEyesDO.setCornealLastK1Right(k1OD2);

            Double k1OS1 =list.get(0).getCornealFirstK1Left();//角膜曲率K1OS1
            ocularEyesDO.setCornealFirstK1Left(k1OS1);

            Double k1OS2=list.get(0).getCornealLastK1Left();//角膜曲率K1OS2
            ocularEyesDO.setCornealLastK1Left(k1OS2);
            //k2
            Double k2OD1=list.get(0).getCornealFirstK2Right(); //角膜曲率K2OD1
            ocularEyesDO.setCornealFirstK2Right(k2OD1);

            Double k2OD2 = list.get(0).getCornealLastK2Right(); //角膜曲率K2OD2
            ocularEyesDO.setCornealLastK2Right(k2OD2);

            Double k2OS1 = list.get(0).getCornealFirstK2Left();//角膜曲率K2OS1
            ocularEyesDO.setCornealFirstK2Left(k2OS1);

            Double k2OS2 = list.get(0).getCornealLastK2Left(); //角膜曲率K2OS2
            ocularEyesDO.setCornealLastK2Left(k2OS2);
            //眼压
            ocularEyesDO.setIntraocularOd(list.get(0).getIntraocularOd());
            ocularEyesDO.setIntraocularOs(list.get(0).getIntraocularOs());
            //平均K
//            ocularEyesDO.setPjkOd(list.get(0).getPjkOd());
//            ocularEyesDO.setPjkOs(list.get(0).getPjkOs());
            Double pjkOD = (k1OD1+k2OD1)/2;
            ocularEyesDO.setPjkOd(pjkOD);
            Double pjkOS = (k1OD2+k2OD2)/2;
            ocularEyesDO.setPjkOd2(pjkOS);

            Double pjkod2= (k1OS1+k2OS1)/2;
            ocularEyesDO.setPjkOs(pjkod2);
            Double pjkos2 = (k1OS2+k2OS2)/2;
            ocularEyesDO.setPjkOs2(pjkos2);
            //瞳距
            ocularEyesDO.setPupilSizeRight(list.get(0).getPupilSizeRight());
            ocularEyesDO.setPupilSizeLeft(list.get(0).getPupilSizeLeft());
        }
        model.addAttribute("ocularEyesDO", ocularEyesDO);
//————————————————散瞳用药————————————————————————————————
        List<PharmacyDO> pharmacyDOList = pharmacyService.list(map);
        model.addAttribute("pharmacyDOList", pharmacyDOList);

//————电脑验光————
        List<OptometryDO> optoList = optometryService.optoList(map);
        OptometryDO optometryDO = new OptometryDO();
        if (optoList.size() > 0) {
            optometryDO.setMydriasis(optoList.get(0).getMydriasis());
            optometryDO.setCylinderRight(optoList.get(0).getCylinderRight());
            optometryDO.setCylinderLeft(optoList.get(0).getCylinderLeft());
            optometryDO.setAxialRight(optoList.get(0).getAxialRight());
            optometryDO.setAxialLeft(optoList.get(0).getAxialLeft());
            optometryDO.setSphereRight(optoList.get(0).getSphereRight());
            optometryDO.setSphereLeft(optoList.get(0).getSphereLeft());

            optometryDO.setCylinderRight2(optoList.get(0).getCylinderRight2());
            optometryDO.setCylinderLeft2(optoList.get(0).getCylinderLeft2());
            optometryDO.setAxialRight2(optoList.get(0).getAxialRight2());
            optometryDO.setAxialLeft2(optoList.get(0).getAxialLeft2());
            optometryDO.setSphereRight2(optoList.get(0).getSphereRight2());
            optometryDO.setSphereLeft2(optoList.get(0).getSphereLeft2());
            //角膜散光
            optometryDO.setCornealAstigmatismOd(optoList.get(0).getCornealAstigmatismOd());
            optometryDO.setCornealAstigmatismOs(optoList.get(0).getCornealAstigmatismOs());


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
//        //散瞳前
//        List<OptometryDO> list1 = optometryService.optoFrontList(cardNumber);
//        OptometryDO optometryFrontDO = new OptometryDO();
//        if (list1.size() > 0) {
//            optometryFrontDO.setCylinderRight(list1.get(0).getCylinderRight());
//            optometryFrontDO.setCylinderLeft(list1.get(0).getCylinderLeft());
//            optometryFrontDO.setAxialRight(list1.get(0).getAxialRight());
//            optometryFrontDO.setAxialLeft(list1.get(0).getAxialLeft());
//            optometryFrontDO.setSphereRight(list1.get(0).getSphereRight());
//            optometryFrontDO.setSphereLeft(list1.get(0).getSphereLeft());
//            //角膜散光
//            optometryFrontDO.setCornealAstigmatismOd(list1.get(0).getCornealAstigmatismOd());
//            optometryFrontDO.setCornealAstigmatismOs(list1.get(0).getCornealAstigmatismOs());
//
//        }
//        model.addAttribute("optometryFrontDO", optometryFrontDO);
//
//        //散瞳后
//        List<OptometryDO> list2 = optometryService.optoAfterList(cardNumber);
//        OptometryDO optometryAfterDO = new OptometryDO();
//        if (list2.size() > 0) {
//            optometryAfterDO.setMydriasis(list2.get(0).getMydriasis());
//            optometryAfterDO.setCylinderRight(list2.get(0).getCylinderRight());
//            optometryAfterDO.setCylinderLeft(list2.get(0).getCylinderLeft());
//            optometryAfterDO.setAxialRight(list2.get(0).getAxialRight());
//            optometryAfterDO.setAxialLeft(list2.get(0).getAxialLeft());
//            optometryAfterDO.setSphereRight(list2.get(0).getSphereRight());
//            optometryAfterDO.setSphereLeft(list2.get(0).getSphereLeft());
//            //角膜散光
//            optometryAfterDO.setCornealAstigmatismOd(list2.get(0).getCornealAstigmatismOd());
//            optometryAfterDO.setCornealAstigmatismOs(list2.get(0).getCornealAstigmatismOs());
//        }
//        model.addAttribute("optometryAfterDO", optometryAfterDO);
        return "optometryNew/edit";
    }

    //检查结论
    @GetMapping("/jianchajielun/{cardNumber}")
    String jianchajielun(@PathVariable("cardNumber") String cardNumber, Model model,HttpServletRequest request) {
//         request.getParameter("cardNumber");

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
                tryresultsDO.setNewOld(trylist.get(0).getNewOld());
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

                String addod=trylist.get(0).getAddRighttry();
                if ("".equals(addod)){
                    addod="0";
                }
                tryresultsDO.setAddRighttry(addod);
                String addos=trylist.get(0).getAddLefttry();
                if ("".equals(addos)){
                    addos="0";
                }
                tryresultsDO.setAddLefttry(addos);


                tryresultsDO.setYuanRrty(trylist.get(0).getYuanRrty());
                tryresultsDO.setYuanLrty(trylist.get(0).getYuanLrty());

                tryresultsDO.setNearRighttry(trylist.get(0).getNearRighttry());
                tryresultsDO.setNearLefttry(trylist.get(0).getNearLefttry());


            }
        }

        model.addAttribute("tryresultsDO", tryresultsDO);
        //医生
        Map<String,Object> map=new HashMap<>();
        map.put("roleName","医生");
        List<TryresultsDO> listDoctor = tryresultsService.listDoctor(map);
        model.addAttribute("listDoctor",listDoctor);
        map.put("YangguangName","验光师");
        List<TryresultsDO> listYanguang = tryresultsService.listYanguang(map);
        model.addAttribute("listYanguang",listYanguang);

        return "optometryNew/jianchajielun";
    }
    /**
     * 最后一次详情
     */
//        @GetMapping("/detail/{cardNumber}")
//        @RequiresPermissions("information:optometryNew:detail")
//        String detail(@PathVariable("cardNumber") String cardNumber, Model model) {
//            Map<String, Object> map = new HashMap<>();
//            List<PharmacyDO> pharmacyDOList = pharmacyService.list(map);
//            model.addAttribute("pharmacyDOList", pharmacyDOList);
//
//            //————会员信息——————
//            MemberDO memberDO = memberService.getCardNumber(cardNumber);
//            if (memberDO.getSex() == 0) {
//                memberDO.setSexx("男");
//            } else {
//                memberDO.setSexx("女");
//            }
//            model.addAttribute("memberDO", memberDO);
//            map.put("cardNumber",cardNumber);
//            List<TryresultsDO>  tryall =tryresultsService.getTryresult(map);
//            TryresultsDO tryresultsDO = new TryresultsDO();
//            if (tryall.size() > 0) {
//                tryresultsDO.setPtometryNumber(tryall.get(0).getPtometryNumber());
//                tryresultsDO.setOptometryName(tryall.get(0).getOptometryName());
//                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date time = tryall.get(0).getCreateTime();
//                String newtime = sdftime.format(time);
//                model.addAttribute("newtime", newtime);
//                tryresultsDO.setReferralDoctor(tryall.get(0).getReferralDoctor());
//                tryresultsDO.setChiefComplaint(tryall.get(0).getChiefComplaint());
//                tryresultsDO.setFarLyou(tryall.get(0).getFarLyou());
//                tryresultsDO.setFarLyod(tryall.get(0).getFarLyod());
//                tryresultsDO.setFarLyos(tryall.get(0).getFarLyos());
//
//                tryresultsDO.setFarYjou(tryall.get(0).getFarYjou());
//                tryresultsDO.setFarYjod(tryall.get(0).getFarYjod());
//                tryresultsDO.setFarYjos(tryall.get(0).getFarYjos());
//
//                tryresultsDO.setNearLyou(tryall.get(0).getNearLyou());
//                tryresultsDO.setNearLyod(tryall.get(0).getNearLyod());
//                tryresultsDO.setNearLyos(tryall.get(0).getNearLyos());
//
//                tryresultsDO.setNearYjou(tryall.get(0).getNearYjou());
//                tryresultsDO.setNearYjod(tryall.get(0).getNearYjod());
//                tryresultsDO.setNearYjos(tryall.get(0).getNearYjos());
//
//                tryresultsDO.setFarXkou(tryall.get(0).getFarXkou());
//                tryresultsDO.setFarXkod(tryall.get(0).getFarXkod());
//                tryresultsDO.setFarXkos(tryall.get(0).getFarXkos());
//
//                tryresultsDO.setNearXkou(tryall.get(0).getNearXkou());
//                tryresultsDO.setNearXkod(tryall.get(0).getNearXkod());
//                tryresultsDO.setNearXkos(tryall.get(0).getNearXkos());
//
//                tryresultsDO.setSgnCiss(tryall.get(0).getSgnCiss());
//                tryresultsDO.setSgnAc(tryall.get(0).getSgnAc());
//                tryresultsDO.setSgnFarsp1(tryall.get(0).getSgnFarsp1());
//                tryresultsDO.setSgnNearsp1(tryall.get(0).getSgnNearsp1());
//                tryresultsDO.setSgnFarcz1(tryall.get(0).getSgnFarcz1());
//                tryresultsDO.setSgnVgfarsp1(tryall.get(0).getSgnVgfarsp1());
//                tryresultsDO.setSgnVgfarsp2(tryall.get(0).getSgnVgfarsp2());
//                tryresultsDO.setSgnVgfarcz1(tryall.get(0).getSgnVgfarcz1());
//                tryresultsDO.setSgnVgfarcz2(tryall.get(0).getSgnVgfarcz2());
//                tryresultsDO.setSgnVgnearsp1(tryall.get(0).getSgnVgnearsp1());
//                tryresultsDO.setSgnVgnearsp2(tryall.get(0).getSgnVgnearsp2());
//                tryresultsDO.setSgnVgnearcz1(tryall.get(0).getSgnVgnearcz1());
//                tryresultsDO.setSgnVgnearcz2(tryall.get(0).getSgnVgnearcz2());
//                tryresultsDO.setSgnAllygytj1(tryall.get(0).getSgnAllygytj1());
//                tryresultsDO.setSgnAllygytj2(tryall.get(0).getSgnAllygytj2());
//                tryresultsDO.setSgnTjfyou(tryall.get(0).getSgnTjfyou());
//                tryresultsDO.setSgnTjfyod(tryall.get(0).getSgnTjfyod());
//                tryresultsDO.setSgnTjfyos(tryall.get(0).getSgnTjfyos());
//                tryresultsDO.setSgnPra(tryall.get(0).getSgnPra());
//                tryresultsDO.setSgnNra(tryall.get(0).getSgnNra());
//                tryresultsDO.setSgnNra(tryall.get(0).getSgnNra());
//
//
//                tryresultsDO.setAxis(tryall.get(0).getAxis());
//                tryresultsDO.setCornealFirstK1Right(tryall.get(0).getCornealFirstK1Right());
//                tryresultsDO.setCornealLastK1Right(tryall.get(0).getCornealLastK1Right());
//                tryresultsDO.setCornealFirstK2Right(tryall.get(0).getCornealFirstK2Right());
//                tryresultsDO.setCornealLastK2Right(tryall.get(0).getCornealLastK2Right());
//                tryresultsDO.setIntraocularOd(tryall.get(0).getIntraocularOd());
//                tryresultsDO.setAxisLeft(tryall.get(0).getAxisLeft());
//                tryresultsDO.setCornealFirstK1Left(tryall.get(0).getCornealFirstK1Left());
//                tryresultsDO.setCornealLastK1Left(tryall.get(0).getCornealLastK1Left());
//                tryresultsDO.setCornealFirstK2Left(tryall.get(0).getCornealFirstK2Left());
//                tryresultsDO.setCornealLastK2Left(tryall.get(0).getCornealLastK2Left());
//                tryresultsDO.setIntraocularOs(tryall.get(0).getIntraocularOs());
//
//                tryresultsDO.setSphereRight(tryall.get(0).getSphereRight());
//                tryresultsDO.setCylinderRight(tryall.get(0).getCylinderRight());
//                tryresultsDO.setAxialRight(tryall.get(0).getAxialRight());
//                tryresultsDO.setSphereRight2(tryall.get(0).getSphereRight2());
//                tryresultsDO.setCylinderRight2(tryall.get(0).getCylinderRight2());
//                tryresultsDO.setAxialRight2(tryall.get(0).getAxialRight2());
//                tryresultsDO.setSphereLeft(tryall.get(0).getSphereLeft());
//                tryresultsDO.setCylinderLeft(tryall.get(0).getCylinderLeft());
//                tryresultsDO.setAxialLeft(tryall.get(0).getAxialLeft());
//                tryresultsDO.setSphereLeft2(tryall.get(0).getSphereLeft2());
//                tryresultsDO.setCylinderLeft2(tryall.get(0).getCylinderLeft2());
//                tryresultsDO.setAxialLeft2(tryall.get(0).getAxialLeft2());
//                tryresultsDO.setPkod(tryall.get(0).getPkod());
//                tryresultsDO.setPk1od(tryall.get(0).getPk1od());
//                tryresultsDO.setDkod(tryall.get(0).getDkod());
//                tryresultsDO.setDk1od(tryall.get(0).getDk1od());
//                tryresultsDO.setPjkOd(tryall.get(0).getPjkOd());
//                tryresultsDO.setPjkOd2(tryall.get(0).getPjkOd2());
//                tryresultsDO.setCornealAstigmatismOd(tryall.get(0).getCornealAstigmatismOd());
//                tryresultsDO.setTjod(tryall.get(0).getTjod());
//                tryresultsDO.setTjos(tryall.get(0).getTjos());
//
//                tryresultsDO.setPkos(tryall.get(0).getPkos());
//                tryresultsDO.setPk1os(tryall.get(0).getPk1os());
//                tryresultsDO.setDkos(tryall.get(0).getDkos());
//                tryresultsDO.setDk1os(tryall.get(0).getDk1os());
//                tryresultsDO.setPjkOs(tryall.get(0).getPjkOs());
//                tryresultsDO.setPjkOs2(tryall.get(0).getPjkOs2());
//                tryresultsDO.setCornealAstigmatismOs(tryall.get(0).getCornealAstigmatismOs());
//                tryresultsDO.setTjos(tryall.get(0).getTjos());
//                tryresultsDO.setSphJyod(tryall.get(0).getSphJyod());
//                tryresultsDO.setCylJyod(tryall.get(0).getCylJyod());
//                tryresultsDO.setAxialJyod(tryall.get(0).getAxialJyod());
//                tryresultsDO.setVaJyod(tryall.get(0).getVaJyod());
//                tryresultsDO.setPdJyod(tryall.get(0).getPdJyod());
//                tryresultsDO.setSphJyos(tryall.get(0).getSphJyos());
//                tryresultsDO.setCylJyos(tryall.get(0).getCylJyos());
//                tryresultsDO.setAxialJyos(tryall.get(0).getAxialJyos());
//                tryresultsDO.setVaJyos(tryall.get(0).getVaJyos());
//                tryresultsDO.setPdJyos(tryall.get(0).getPdJyos());
//                tryresultsDO.setSphCpod(tryall.get(0).getSphCpod());
//                tryresultsDO.setCylCpod(tryall.get(0).getCylCpod());
//                tryresultsDO.setAxialCpod(tryall.get(0).getAxialCpod());
//                tryresultsDO.setDvaCpod(tryall.get(0).getDvaCpod());
//                tryresultsDO.setNvaCpod(tryall.get(0).getNvaCpod());
//                tryresultsDO.setAddCpod(tryall.get(0).getAddCpod());
//                tryresultsDO.setDistanceOd(tryall.get(0).getDistanceOd());
//                tryresultsDO.setSphCpos(tryall.get(0).getSphCpos());
//                tryresultsDO.setCylCpos(tryall.get(0).getCylCpos());
//                tryresultsDO.setAxialCpos(tryall.get(0).getAxialCpos());
//                tryresultsDO.setDvaCpos(tryall.get(0).getDvaCpos());
//                tryresultsDO.setNvaCpos(tryall.get(0).getNvaCpos());
//                tryresultsDO.setAddCpos(tryall.get(0).getAddCpos());
//                tryresultsDO.setDistanceOs(tryall.get(0).getDistanceOs());
//                tryresultsDO.setSphereRightz(tryall.get(0).getSphereRightz());
//                tryresultsDO.setCylinderRightz(tryall.get(0).getCylinderRightz());
//                tryresultsDO.setAxialRightz(tryall.get(0).getAxialRightz());
//                tryresultsDO.setDvaRightz(tryall.get(0).getDvaRightz());
//                tryresultsDO.setNvaRightz(tryall.get(0).getNvaRightz());
//                tryresultsDO.setPrismRightz(tryall.get(0).getPrismRightz());
//                tryresultsDO.setAddRightz(tryall.get(0).getAddRightz());
//                tryresultsDO.setYuanRz(tryall.get(0).getYuanRz());
//                tryresultsDO.setNearRightz(tryall.get(0).getNearRightz());
//                tryresultsDO.setSphereLeftz(tryall.get(0).getSphereLeftz());
//                tryresultsDO.setCylinderLeftz(tryall.get(0).getCylinderLeftz());
//                tryresultsDO.setAxialLeftz(tryall.get(0).getAxialLeftz());
//                tryresultsDO.setDvaLeftz(tryall.get(0).getDvaLeftz());
//                tryresultsDO.setNvaLeftz(tryall.get(0).getNvaLeftz());
//                tryresultsDO.setPrismLeftz(tryall.get(0).getPrismLeftz());
//                tryresultsDO.setAddLeftz(tryall.get(0).getAddLeftz());
//                tryresultsDO.setYuanLz(tryall.get(0).getYuanLz());
//                tryresultsDO.setNearLeftz(tryall.get(0).getNearLeftz());
//                tryresultsDO.setSphereRighttry(tryall.get(0).getSphereRighttry());
//                tryresultsDO.setCylinderRighttry(tryall.get(0).getCylinderRighttry());
//                tryresultsDO.setAxialRighttry(tryall.get(0).getAxialRighttry());
//                tryresultsDO.setDvaRighttry(tryall.get(0).getDvaRighttry());
//                tryresultsDO.setNvaRighttry(tryall.get(0).getNvaRighttry());
//                tryresultsDO.setPrismRighttry(tryall.get(0).getPrismRighttry());
//                tryresultsDO.setHeightRighttry(tryall.get(0).getHeightRighttry());
//                tryresultsDO.setAddRighttry(tryall.get(0).getAddRighttry());
//                tryresultsDO.setYuanRrty(tryall.get(0).getYuanRrty());
//                tryresultsDO.setSphereLefttry(tryall.get(0).getSphereLefttry());
//                tryresultsDO.setCylinderLefttry(tryall.get(0).getCylinderLefttry());
//                tryresultsDO.setAxialLefttry(tryall.get(0).getAxialLefttry());
//                tryresultsDO.setDvaLefttry(tryall.get(0).getDvaLefttry());
//                tryresultsDO.setNvaLefttry(tryall.get(0).getNvaLefttry());
//                tryresultsDO.setPrismLefttry(tryall.get(0).getPrismLefttry());
//                tryresultsDO.setHeightLefttry(tryall.get(0).getHeightLefttry());
//                tryresultsDO.setAddLefttry(tryall.get(0).getAddLefttry());
//                tryresultsDO.setYuanLrty(tryall.get(0).getYuanLrty());
//                tryresultsDO.setRemarks(tryall.get(0).getRemarks());
//
//
//
//                tryresultsDO.setDominantEye(tryall.get(0).getDominantEye());
//                tryresultsDO.setSgnReason(tryall.get(0).getSgnReason());
//                tryresultsDO.setSgnFardot(tryall.get(0).getSgnFardot());
//                tryresultsDO.setSgnNeardot(tryall.get(0).getSgnNeardot());
//                tryresultsDO.setSgnNearsp2(tryall.get(0).getSgnNearsp2());
//                tryresultsDO.setSgnFarcz2(tryall.get(0).getSgnFarcz2());
//                tryresultsDO.setSgnNearcz2(tryall.get(0).getSgnNearcz2());
//                tryresultsDO.setPharmacy(tryall.get(0).getPharmacy());
//                tryresultsDO.setJdrZ(tryall.get(0).getJdrZ());
//                tryresultsDO.setJdlZ(tryall.get(0).getJdlZ());
//                tryresultsDO.setJdrTry(tryall.get(0).getJdrTry());
//                tryresultsDO.setJdlTry(tryall.get(0).getJdlTry());
//
//                tryresultsDO.setPharmacy(tryall.get(0).getPharmacy());
//                tryresultsDO.setSgnSf(tryall.get(0).getSgnSf());
//                tryresultsDO.setSgnAcway(tryall.get(0).getSgnAcway());
//                tryresultsDO.setSgnTjfy(tryall.get(0).getSgnTjfy());
//                tryresultsDO.setSgnZfsf(tryall.get(0).getSgnZfsf());
//                tryresultsDO.setMydriasis(tryall.get(0).getMydriasis());
//            }
//            model.addAttribute("tryresultsDO",tryresultsDO);
//        return "optometryNew/detial";
//    }
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
        int total = yizhuService.findYizhucount(query);
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
        query.put("xsstate",0);
        List<HlyDO> hlylist = hlyService.gethly(query);
        int total = hlyService.gethlycount(query);
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
    @RequiresPermissions("information:optometryNew:shiguang")
    public PageUtils shiguanglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ShiguangDO> shiguanglist = shiguangService.getshiguang(query);
        int total = shiguangService.getshiguangcount(query);
        PageUtils pageUtils = new PageUtils(shiguanglist, total);
        return pageUtils;
    }

}


