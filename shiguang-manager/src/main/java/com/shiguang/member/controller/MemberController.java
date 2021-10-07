package com.shiguang.member.controller;

import com.shiguang.baseinfomation.domain.*;
import com.shiguang.baseinfomation.service.*;
import com.shiguang.common.utils.*;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.service.ResultService;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller("MemberController")
@RequestMapping("/information/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private CardTypeService typeService;
    @Autowired
    private PersonSortService personSortService;
    @Autowired
    private VocationService vocationService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private InterestService interestService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private LineService lineService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailInfoService mailInfoService;
    @Autowired
    private SettlementService settlementService;

    @GetMapping()
    @RequiresPermissions("information:member:member")
    String Member(Model model){
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
        return "member/member";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:member:member")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        if (null != params.get("ageStart") && !"".equals(params.get("ageStart"))){
            query.put("agestart",Long.parseLong(params.get("ageStart").toString()));
            query.put("companyId","");
        }
        if (null != params.get("ageEnd")&& !"".equals(params.get("ageEnd"))){
            query.put("ageend",Long.parseLong(params.get("ageEnd").toString()));
            query.put("companyId","");
        }
        if (null != params.get("sex") && !"".equals(params.get("sex"))){
            query.put("companyId","");
        }
        if (null != params.get("phone1") && !"".equals(params.get("phone1"))){
            query.put("companyId","");
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("companyId","");
        }
        if (null != params.get("cardNumber") && !"".equals(params.get("cardNumber"))){
            query.put("companyId","");
        }
        List<MemberDO> memberList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:member:add")
    String add(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(map);
        model.addAttribute("interestDOList",interestDOList);
        return "member/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:member:edit")
    String edit(@PathVariable("id") Long id,Model model)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MemberDO member = memberService.get(id);
        Date date = member.getRegisterTime();
        String strDate = sdf.format(date);
        member.setCreateTime(strDate);
        model.addAttribute("member", member);
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(map);
        model.addAttribute("interestDOList",interestDOList);
        return "member/edit";
    }

//    @GetMapping("/information/{checkType}")
//    @RequiresPermissions("information:member:member")
//    public String importtemplate(Model model, @PathVariable("checkType") String checkType) {
//        model.addAttribute("checkType", checkType);
//        Map<String, Object> map = new HashMap<>();
//        List<DepartmentDO> departmentDOList = departmentService.list(map);
//        map.put("state",1);
//        model.addAttribute("departmentDOList",departmentDOList);
//        if ("PU_TONG".equals(checkType)) {
//            return "member/importtemplate";
//        }
//        return null;
//    }
//
//    /**
//     * 导入
//     */
//    @PostMapping("/importMember")
//    @ResponseBody
//    @RequiresPermissions("information:member:member")
//    public R importMember(String departNumber, String checkType, MultipartFile file) {
//        return memberService.importMember(departNumber, checkType, file);
//
//    }

    @GetMapping("/detail/{id}")
    @RequiresPermissions("information:member:detail")
    String detail(@PathVariable("id") Long id,Model model){
        MemberDO member = memberService.get(id);
        if (member.getSex() == 0){
            member.setSexx("男");
        } else if (member.getSex() == 1){
            member.setSexx("女");
        }
        if (member.getProvinceName() ==null){
            member.setProvinceName("0");
        }
        model.addAttribute("member", member);
        Map<String,Object> map = new HashMap<>();
        map.put("state",1);
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        List<PersonSortDO> personSortDOList = personSortService.list(map);
        model.addAttribute("personSortDOList",personSortDOList);
        List<VocationDO> vocationDOList = vocationService.list(map);
        model.addAttribute("vocationDOList",vocationDOList);
        List<SourceDO> sourceDOList = sourceService.list(map);
        model.addAttribute("sourceDOList",sourceDOList);
        List<InterestDO> interestDOList = interestService.list(map);
        model.addAttribute("interestDOList",interestDOList);
        return "member/detail";
    }

    @ResponseBody
    @GetMapping("/binglilist")
    @RequiresPermissions("information:member:member")
    public PageUtils binglilist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("status","1");
        List<ResultDO> resultList = resultService.shujulist(query);
        int total = resultService.shujulistcount(query);
        PageUtils pageUtils = new PageUtils(resultList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/salelist")
    @RequiresPermissions("information:member:member")
    public PageUtils salelist(@RequestParam Map<String, Object> params){
        //查询列表数据
        List<SalesDO> salesDOList = new ArrayList<>();
        PageUtils pageUtils = null;
        Long userId = ShiroUtils.getUser().getUserId();
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        List<UserDO> userDOList = userService.getRoleList(map);
        if (null != userDOList && userDOList.size() > 0){
            for (UserDO userDO : userDOList){
                if ("验光师".equals(userDO.getRoleName())){
                    return pageUtils;
                }
            }
        }
        Query query = new Query(params);
        query.put("status","1");
        query.put("memberNumber",query.get("cardNumber"));
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        salesDOList = salesService.salelist(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (null != salesDOList){
            for (SalesDO salesDO : salesDOList){
                if (!"".equals(salesDO.getOptometrywlName())){
                    if ("1".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("近用");
                    }else if ("2".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("远用");
                    } else if ("3".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("渐进/双光");
                    } else if ("4".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("中用");
                    } else if ("5".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("隐形");
                    } else if ("6".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("角膜塑形镜");
                    } else if ("7".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("视觉训练");
                    } else if ("8".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("角膜塑形镜VST");
                    } else if ("9".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("角膜塑形镜CRT");
                    } else if ("10".equals(salesDO.getRecipelwlType())){
                        salesDO.setRecipelType("RGP");
                    }
                }
                if (null != salesDO.getSettleDate()){
                    salesDO.setSettleTime(simpleDateFormat.format(salesDO.getSettleDate()));
                }
            }
        }
        int total = salesService.salecount(query);
        pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @GetMapping("/editSale/{saleNumber}")
    @RequiresPermissions("information:member:edit")
    String editSale(@PathVariable("saleNumber") String saleNumber,Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
//		List<CostDO> costDOList = costService.list(map);
//		model.addAttribute("costDOList",costDOList);
//		Double sumMoney =0.00;
//		String jianchaDate="";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		for (CostDO costDO : costDOList){
//			sumMoney =sumMoney+costDO.getCostMoney();
//		}
//		model.addAttribute("sumMoney",sumMoney);
//		model.addAttribute("jianchaTime",simpleDateFormat.format(new Date()));
        SalesDO settlementDO = salesService.getSaleNumber(saleNumber);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
        if (settlementDO.getSex() == 0){
            settlementDO.setSexx("男");
        } else if (settlementDO.getSex() == 1){
            settlementDO.setSexx("女");
        }
        model.addAttribute("settlementDO",settlementDO);
        DepartmentDO departmentDO = departmentService.getDepartName(settlementDO.getStoreNum());
        if (null != departmentDO){
            model.addAttribute("departmentDO",departmentDO);
        } else {
            DepartmentDO departmentDO1 = new DepartmentDO();
            departmentDO1.setDepartAddress("");
            departmentDO1.setDepartTel("");
            model.addAttribute("departmentDO",departmentDO1);
        }
        Map<String,Object> mailMap = new HashMap<>();
        String dateNow = simpleDateFormat.format(new Date());
        mailMap.put("cardNumber",settlementDO.getMemberNumber());
        mailMap.put("dateNow",dateNow);
        mailMap.put("state",0);
        MailInfoDO mailInfoDO = mailInfoService.getMailAddress(settlementDO.getSaleNumber());
        if (null != mailInfoDO){
            model.addAttribute("address",mailInfoDO.getAddress());
        } else {
            List<MailInfoDO> mailInfoDOS = mailInfoService.getMailAddressByMember(mailMap);
            if (null != mailInfoDOS && mailInfoDOS.size() > 0){
                model.addAttribute("address",mailInfoDOS.get(0).getAddress());
            }else {
                model.addAttribute("address","");
            }
        }
        SettlementDO settlementDO1 = settlementService.getSaleNumers(saleNumber);
        if (null != settlementDO1){
            StringBuffer payModels = new StringBuffer();
            String[] paymodel = settlementDO1.getPayModel().split(",");
            String[] moneyPay = settlementDO1.getModelMoney().split(",");
            for (int i=0;i<paymodel.length;i++){
                if ("0".equals(paymodel[i])){
                    model.addAttribute("paymodel","微信");
                    payModels.append("微信:"+moneyPay[i]+",");
                    //payModels[i]="微信";
                } else if ("1".equals(paymodel[i])){
                    model.addAttribute("paymodel","支付宝");
                    payModels.append("支付宝:"+moneyPay[i]+",");
                } else if ("2".equals(paymodel[i])){
                    model.addAttribute("paymodel","医院收费处");
                    payModels.append("医院收费处:"+moneyPay[i]+",");
                } else if ("3".equals(paymodel[i])){
                    model.addAttribute("paymodel","一卡通");
                    payModels.append("一卡通:"+moneyPay[i]+",");
                } else if ("4".equals(paymodel[i])){
                    model.addAttribute("paymodel","现金");
                    payModels.append("现金:"+moneyPay[i]+",");
                }
            }
            model.addAttribute("payModels",payModels.deleteCharAt(payModels.length()-1));

        }
        model.addAttribute("settlementDO1",settlementDO1);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("cardNumber",settlementDO.getMemberNumber());
        List<Conclusion> conclusionList = salesService.conclusionList(map2);
        Conclusion conclusion = new Conclusion();
        if (null != conclusionList && conclusionList.size() > 0){
            conclusion.setRightsph(conclusionList.get(0).getRightsph());
            conclusion.setRightcyl(conclusionList.get(0).getRightcyl());
            conclusion.setRightzx(conclusionList.get(0).getRightzx());
            if (null != conclusionList.get(0).getRightyytj()){
                conclusion.setRightyytj(conclusionList.get(0).getRightyytj());
            } else {
                conclusion.setRightyytj(conclusionList.get(0).getRightjytj());
            }
            conclusion.setRighttg(conclusionList.get(0).getRighttg());
            conclusion.setRightprism(conclusionList.get(0).getRightprism());
            conclusion.setRightjd(conclusionList.get(0).getRightjd());
            conclusion.setLeftsph(conclusionList.get(0).getLeftsph());
            conclusion.setLeftcyl(conclusionList.get(0).getLeftcyl());
            conclusion.setLeftzx(conclusionList.get(0).getLeftzx());
            if (null != conclusionList.get(0).getLeftyytj()){
                conclusion.setLeftyytj(conclusionList.get(0).getLeftyytj());
            } else {
                conclusion.setLeftyytj(conclusionList.get(0).getLeftjytj());
            }
            conclusion.setLefttg(conclusionList.get(0).getLefttg());
            conclusion.setLeftprism(conclusionList.get(0).getLeftprism());
            conclusion.setLeftjd(conclusionList.get(0).getLeftjd());
        }
        model.addAttribute("conclusion",conclusion);
//		String goodsName = settlementDO.getStoreName();
//		String unit = settlementDO.getUnit();
//		String storeCount = settlementDO.getStoreCount();
//		String storeUnit = settlementDO.getStoreUnit();
//		String[] unitastr = unit.split(",");
//		String[] goods = goodsName.split(",");
//		String[] countstr = storeCount.split(",");
//		String[] storeUnitstr = storeUnit.split(",");
//		List<String> goodsNameList = new ArrayList<>();
//		for (int i=0;i<goods.length;i++){
//			goodsNameList.add(goods[i]);
//		}
//		model.addAttribute("goodsNameList",goodsNameList);
        //ResultDO resultDO = resultService.
        List<String> processList = new ArrayList<>();
        String processAsk = settlementDO.getProcessAsk();
        if (null != processAsk){
            String[] processStr = processAsk.split(",");
            for (int i=0;i<processStr.length;i++){
                processList.add(processStr[i]);
            }
            model.addAttribute("processList",processList);
        } else {
            model.addAttribute("processList","");
        }

        List<String> additionalCostList = new ArrayList<>();
        String additionalCost = settlementDO.getAdditionalCost();
        if (null != additionalCost){
            String[] addCostStr = additionalCost.split(",");
            for (int l=0;l<addCostStr.length;l++){
                additionalCostList.add(addCostStr[l]);
            }
            model.addAttribute("additionalCostList",additionalCostList);
        } else {
            model.addAttribute("additionalCostList","");
        }


        String addPrice = settlementDO.getAdditionalPrice();
        Double priceSum = 0.00;
        if (null != addPrice){
            String[] addPriceStr = addPrice.split(",");
            for (int d=0;d<addPriceStr.length;d++){
                String price = addPriceStr[d];
                priceSum = priceSum+Double.parseDouble(price);
            }
            model.addAttribute("priceSum",priceSum);
        } else {
            model.addAttribute("priceSum","");
        }
        String addCount = settlementDO.getAdditionalCount();
        Integer countSum=0;
        if (null != addCount){
            String[] addCountStr = addCount.split(",");
            for (int f=0;f<addCountStr.length;f++){
                String count = addCountStr[f];
                countSum = countSum + Integer.parseInt(count);
            }
            model.addAttribute("countSum",countSum);
        } else {
            model.addAttribute("countSum","");
        }
        return "member/peijingdan";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:member:add")
    public R save( MemberDO member){
        member.setRegisterTime(new Date());
        member.setProvinceName(member.getProvinceName().substring(0,member.getProvinceName().length() -1));
        member.setCityName(member.getCityName().substring(0,member.getCityName().length()-1));
        member.setAreaName(member.getAreaName().substring(0,member.getAreaName().length()-1));
        String cardNumber = member.getCardNumber();
        Map<String, Object> map = new HashMap<>();
        if (!"".equals(cardNumber)){
            map.put("cardNumber",cardNumber);
            List<MemberDO> list = memberService.list(map);
            if (list.size() > 0){
                return R.error("会员卡号已存在");
            }
        } else {
            member.setCardNumber("H"+GuuidUtil.getUUID());
        }
        if ("".equals(member.getCardType())){
            member.setCardType("普通卡");
        }
//        if (member.getMemberOption() == 1){
//            member.setCardNumber("H"+GuuidUtil.getUUID());
//        }
        member.setStatus(0L);
        member.setState(1L);
        if (null != ShiroUtils.getUser().getStoreNum()){
            member.setDepartNumber(ShiroUtils.getUser().getStoreNum());
        }
        member.setCompanyId(ShiroUtils.getUser().getCompanyId());
        if(memberService.save(member)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:member:edit")
    public R update( MemberDO member){
        memberService.update(member);
        return R.ok();
    }

    /**
     * 排队
     */
    @PostMapping( "/line")
    @ResponseBody
    @RequiresPermissions("information:member:line")
    public R line(Long id){
        MemberDO memberDO = memberService.get(id);
        LineDO lineDO = new LineDO();
        lineDO.setMemberNumber(memberDO.getCardNumber());
        lineDO.setName(memberDO.getName());
        lineDO.setSex(memberDO.getSex());
        lineDO.setCallStatus("0");
        lineDO.setLineTime(new Date());
        if(lineService.save(lineDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:member:remove")
    public R remove(Long id){
        MemberDO memberDO = new MemberDO();
        memberDO.setState(0L);
        memberDO.setId(id);
        if(memberService.update(memberDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 浏览器打印二维码
     */
    @GetMapping("/downLoadErWeiMaByMember")
    public String downLoadErWeiMaByMember(Long id, Model model) {
        MemberDO memberDO = Optional.ofNullable(memberService.get(id)).orElseGet(MemberDO::new);
        model.addAttribute("cardMember",memberDO.getCardNumber());
        model.addAttribute("memberName",memberDO.getName());
        model.addAttribute("age",memberDO.getAge());
        if (memberDO.getSex() == 0){
            memberDO.setSexx("男");
        } else if (memberDO.getSex() == 1){
            memberDO.setSexx("女");
        }
        model.addAttribute("sexx",memberDO.getSexx());
        model.addAttribute("memberTel",memberDO.getPhone1());
        String telNumber = memberDO.getPhone1();
        String code = QRCodeUtil.creatRrCode(memberDO.getCardNumber(), 200,200);
        model.addAttribute("QRCode","data:image/png;base64," + code);
        return "member/二维码";
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:member:remove")
//    public R remove(Long id){
//        if(memberService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 批量停用或启用
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:member:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids,@RequestParam("status") Long status){
        memberService.batchRemove(ids,status);
        return R.ok();
    }
    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping(value="/updateEnable")
    public R updateEnable(Long id,Long enable) {
        MemberDO memberDO = new MemberDO();
        memberDO.setId(id);
        memberDO.setStatus(enable);
        memberService.updateStatus(memberDO);
        return R.ok();
    }
}
