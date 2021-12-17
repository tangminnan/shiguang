package com.shiguang.storeSales.controller;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.ResultService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.EyesWay;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
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

@Controller("StoreSalesNewController")
@RequestMapping("/information/storenew")
public class StoreSalesNewController {
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdditionalService additionalService;
    @Autowired
    private GiveawayService giveawayService;
    @Autowired
    private ResultService resultService;

    @GetMapping()
    @RequiresPermissions("information:storenew:storeSalesnew")
    String Optometry() {
        return "storeSales/storeSalesnew";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:storenew:storeSalesnew")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state", 1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("name",String.valueOf(query.get("name")).trim());
        }
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/edits/{cardNumber}")
    @RequiresPermissions("information:storenew:edit")
    String edits(@PathVariable("cardNumber") String cardNumber, Model model) {
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO", memberDO);
        //通过验光师手动输入数据
        Map<String, Object> maps = new HashMap<>();
        maps.put("memberInumber", cardNumber);
        List<OptometryDO> list = optometryService.optoList(maps);
        OptometryDO optometryDO = new OptometryDO();
        if (null != list && list.size() > 0) {
            optometryDO.setCylinderRight(list.get(0).getCylinderRight());
            optometryDO.setCylinderLeft(list.get(0).getCylinderLeft());
            optometryDO.setAxialRight(list.get(0).getAxialRight());
            optometryDO.setAxialLeft(list.get(0).getAxialLeft());
            optometryDO.setSphereRight(list.get(0).getSphereRight());
            optometryDO.setSphereLeft(list.get(0).getSphereLeft());
        }
        model.addAttribute("optometryDO", optometryDO);
        Map<String, Object> map = new HashMap<>();
        map.put("roleType", 1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        List<UserDO> userDOList = userService.getRoleList(map);
        model.addAttribute("userDOList", userDOList);
        map.put("roleType", 2);
        List<UserDO> yanguangDOList = userService.getRoleList(map);
        model.addAttribute("yanguangDOList", yanguangDOList);
        List<ProcessAskDO> proList = optometryService.processlist(map);
        model.addAttribute("proList", proList);
        List<EyesWay> eyesWayList = salesService.findWay(map);
        model.addAttribute("eyesWayList", eyesWayList);
        List<AdditionalDO> addlist = additionalService.list(map);
        model.addAttribute("addlist", addlist);
        UserDO userDO = ShiroUtils.getUser();
        String storeName = userDO.getStore();
        model.addAttribute("storeName", storeName);
        String saleName = ShiroUtils.getUser().getName();
        model.addAttribute("saleName", saleName);
        String storeNum = userDO.getStoreNum();
        model.addAttribute("storeNum",storeNum);
        String store = ShiroUtils.getUser().getStore();
        map.put("stores", store);
        List<GiveawayDO> giveawayDOList = giveawayService.list(map);
        model.addAttribute("giveawayDOList", giveawayDOList);
        //处方
        Map<String, Object> map1 = new HashMap<>();
        map1.put("cardNumber", cardNumber);
        List<ResultDO> resultDOList = resultService.list(map1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = sdf.format(date);
        datetime = datetime + " 00:00:00";
        Map<String, Object> map2 = new HashMap<>();
        map2.put("cardNumber", cardNumber);
        List<Conclusion> conclusionList = salesService.conclusionList(map2);
        model.addAttribute("conclusionList", conclusionList);
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (null != conclusionList) {
            for (Conclusion c : conclusionList) {
                //String ygtime = sdfs.format(c.getCreateTime());
                if (null != c.getCreateTime()){
                    c.setYanguangTime(sdfs.format(c.getCreateTime()));
                } else {
                    c.setYanguangTime(sdfs.format(new Date()));
                }
                if (null == c.getYangsName() || "".equals(c.getYangsName())){
                    c.setYangsName(c.getYanguangName());
                }
                if ("1".equals(c.getChufangType())) {
                    c.setChufang("近用");
                } else if ("2".equals(c.getChufangType())) {
                    c.setChufang("远用");
                } else if ("3".equals(c.getChufangType())) {
                    c.setChufang("渐进/双光");
                } else if ("4".equals(c.getChufangType())) {
                    c.setChufang("中用");
                } else if ("5".equals(c.getChufangType())) {
                    c.setChufang("隐形");
                } else if ("6".equals(c.getChufangType())) {
                    c.setChufang("角膜塑形镜");
                } else if ("7".equals(c.getChufangType())) {
                    c.setChufang("视觉训练");
                } else if ("8".equals(c.getChufangType())) {
                    c.setChufang("角膜塑形镜VST");
                } else if ("9".equals(c.getChufangType())) {
                    c.setChufang("角膜塑形镜CRT");
                } else if ("10".equals(c.getChufangType())) {
                    c.setChufang("RGP");
                } else if ("11".equals(c.getChufangType())) {
                    c.setChufang("药品");
                }
            }
        }
        return "storeSales/edits";
    }



}
