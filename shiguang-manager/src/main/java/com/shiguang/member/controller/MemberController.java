package com.shiguang.member.controller;

import com.shiguang.baseinfomation.domain.*;
import com.shiguang.baseinfomation.service.*;
import com.shiguang.common.utils.*;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
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
    @Autowired
    private KjyyService kjyyService;
    @Autowired
    private KjjyService kjjyService;
    @Autowired
    private RxjmjcjService rxjmjcjService;
    @Autowired
    private SgjjService sgjjService;
    @Autowired
    private SjxlService sjxlService;
    @Autowired
    private VstService vstService;
    @Autowired
    private CrtService crtService;
    @Autowired
    private ZyService zyService;
    @Autowired
    private LogStatusService logStatusService;
    @Autowired
    private ProducaService producaService;

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
            query.put("agestart",Long.parseLong(params.get("ageStart").toString().trim()));
            query.put("companyId","");
        }
        if (null != params.get("ageEnd")&& !"".equals(params.get("ageEnd"))){
            query.put("ageend",Long.parseLong(params.get("ageEnd").toString().trim()));
            query.put("offset",0);
            query.put("limit",10);
            query.put("companyId","");
        }
        if (null != params.get("sex") && !"".equals(params.get("sex"))){
            query.put("companyId","");
        }
        if (null != params.get("phone1") && !"".equals(params.get("phone1"))){
            query.put("phone1",String.valueOf(query.get("phone1")).trim());
            query.put("offset",0);
            query.put("limit",10);
            query.put("companyId","");
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("name",String.valueOf(query.get("name")).trim());
            query.put("offset",0);
            query.put("limit",10);
            query.put("companyId","");
        }
        if (null != params.get("cardNumber") && !"".equals(params.get("cardNumber"))){
            query.put("cardNumber",String.valueOf(query.get("cardNumber")).trim());
            query.put("offset",0);
            query.put("limit",10);
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

    @GetMapping("/information/{checkType}")
    @RequiresPermissions("information:member:member")
    public String importtemplate(Model model, @PathVariable("checkType") String checkType) {
        model.addAttribute("checkType", checkType);
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        map.put("state",1);
        model.addAttribute("departmentDOList",departmentDOList);
        if ("PU_TONG".equals(checkType)) {
            return "member/importtemplate";
        }
        return null;
    }

    /**
     * 导入
     */
    @PostMapping("/importMember")
    @ResponseBody
    @RequiresPermissions("information:member:member")
    public R importMember(String departNumber, String checkType, MultipartFile file) {
        return memberService.importMember(departNumber, checkType, file);

    }

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
                if (!"".equals(salesDO.getRecipelwlType())){
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
                if (null == salesDO.getLogStatus() || "".equals(salesDO.getLogStatus())){
                    if ("辅料".equals(salesDO.getEyeType())){
                        salesDO.setLogStatus("销售完成");
                    } else {
                        salesDO.setLogStatus("委外配送");
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
        if (null != settlementDO.getPeijingTime()){
            settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
        }else {
            settlementDO.setPeijingDate("");
        }
        if (settlementDO.getSex() == 0){
            settlementDO.setSexx("男");
        } else if (settlementDO.getSex() == 1){
            settlementDO.setSexx("女");
        }
        if (null != settlementDO.getJjGoodsName()){
            String[] storeDescribe = settlementDO.getStoreDescribe().split(",");
            String[] goodsNum = settlementDO.getGoodsNum().split(",");
            String[] jjgoodsName = settlementDO.getJjGoodsName().split(",");
            String[] color= new String[jjgoodsName.length];
            int a=0;
            for (int i=0;i<storeDescribe.length;i++){
                if ("镜架".equals(storeDescribe[i])){
                    ProducaDO producaDO = producaService.getJjBygoodNums(goodsNum[i]);
                    if (null != producaDO){
                        color[a] = producaDO.getProducColor();
                        a= a+1;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (null != color && color.length>0){
                for (String n:color){
                    sb.append(n.replace("'", "\\'")).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            settlementDO.setColorSize(sb.toString());
        }
        model.addAttribute("settlementDO",settlementDO);
        model.addAttribute("companyName",ShiroUtils.getUser().getCompany());
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
            model.addAttribute("payMoney",settlementDO1.getPayMoney());
            model.addAttribute("changeMoney",settlementDO1.getChangeMoney());
            model.addAttribute("sellName",settlementDO1.getSaleName());
        } else {
            model.addAttribute("payMoney","");
            model.addAttribute("changeMoney","");
        }

        Map<String,Object> map2 = new HashMap<>();
        Conclusion conclusion = new Conclusion();
        map2.put("cardNumber",settlementDO.getMemberNumber());
        map2.put("saleNumber",settlementDO.getSaleNumber());
        map2.put("ptometryNumber",settlementDO.getPtometryNumber());
        if (!"".equals(settlementDO.getOptometrywlName()) && null != settlementDO.getOptometrywlName()){
            model.addAttribute("optometryName",settlementDO.getOptometrywlName());
            if (1 == settlementDO.getRecipelwlType()){
                List<KjjyDO> kjjyDOList = kjjyService.list(map2);
                if (null != kjjyDOList && kjjyDOList.size() > 0){
                    conclusion.setRightsph(kjjyDOList.get(0).getKjjySphod());
                    conclusion.setRightcyl(kjjyDOList.get(0).getKjjyCylod());
                    conclusion.setRightzx(kjjyDOList.get(0).getKjjyAxialod());
                    if (null != kjjyDOList.get(0).getKjjyYytjod()){
                        conclusion.setRightjytj(kjjyDOList.get(0).getKjjyYytjod());
                    } else {
                        conclusion.setRightjytj("");
                    }
                    conclusion.setRighttg(kjjyDOList.get(0).getKjjyTgod());
                    conclusion.setRightprism(kjjyDOList.get(0).getKjjyPrismod());
                    conclusion.setRightjd(kjjyDOList.get(0).getKjjyJdod());
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(kjjyDOList.get(0).getKjjySphos());
                    conclusion.setLeftcyl(kjjyDOList.get(0).getKjjyCylos());
                    conclusion.setLeftzx(kjjyDOList.get(0).getKjjyAxialos());
                    if (null != kjjyDOList.get(0).getKjjyYytjos()){
                        conclusion.setLeftjytj(kjjyDOList.get(0).getKjjyYytjos());
                    } else {
                        conclusion.setLeftjytj("");
                    }
                    conclusion.setLefttg(kjjyDOList.get(0).getKjjyTgos());
                    conclusion.setLeftprism(kjjyDOList.get(0).getKjjyPrismos());
                    conclusion.setLeftjd(kjjyDOList.get(0).getKjjyJdos());
                    conclusion.setLeftAdd("");
                    if (null != kjjyDOList.get(0).getKjjyVaod()){
                        conclusion.setRightjyva("");
                    } else {
                        conclusion.setRightjyva(kjjyDOList.get(0).getKjjyVaod());
                    }
                    if (null != kjjyDOList.get(0).getKjjyVaos()){
                        conclusion.setLeftjyva(kjjyDOList.get(0).getKjjyVaos());
                    } else {
                        conclusion.setLeftjyva("");
                    }

                }
                settlementDO.setRecipelType("近用");
            } else if (2 == settlementDO.getRecipelwlType()){
                List<KjyyDO> kjyyDOList = kjyyService.list(map2);
                if (null != kjyyDOList && kjyyDOList.size() > 0){
                    conclusion.setRightsph(kjyyDOList.get(0).getKjyySphod());
                    conclusion.setRightcyl(kjyyDOList.get(0).getKjyyCylod());
                    conclusion.setRightzx(kjyyDOList.get(0).getKjyyAxialod());
                    if (null != kjyyDOList.get(0).getKjyyYytjod()){
                        conclusion.setRightyytj(kjyyDOList.get(0).getKjyyYytjod());
                    } else {
                        conclusion.setRightyytj("");
                    }
                    conclusion.setRighttg(kjyyDOList.get(0).getKjyyTgod());
                    conclusion.setRightprism(kjyyDOList.get(0).getKjyyPrismod());
                    conclusion.setRightjd(kjyyDOList.get(0).getKjyyJdod());
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(kjyyDOList.get(0).getKjyySphos());
                    conclusion.setLeftcyl(kjyyDOList.get(0).getKjyyCylos());
                    conclusion.setLeftzx(kjyyDOList.get(0).getKjyyAxialos());
                    if (null != kjyyDOList.get(0).getKjyyYytjos()){
                        conclusion.setLeftyytj(kjyyDOList.get(0).getKjyyYytjos());
                    } else {
                        conclusion.setLeftyytj("");
                    }
                    conclusion.setLefttg(kjyyDOList.get(0).getKjyyTgos());
                    conclusion.setLeftprism(kjyyDOList.get(0).getKjyyPrismos());
                    conclusion.setLeftjd(kjyyDOList.get(0).getKjyyJdos());
                    conclusion.setLeftAdd("");
                    if (null != kjyyDOList.get(0).getKjyyVaod()){
                        conclusion.setRightva(kjyyDOList.get(0).getKjyyVaod());
                    } else {
                        conclusion.setRightva("");
                    }
                    if (null != kjyyDOList.get(0).getKjyyVaos()){
                        conclusion.setLeftva(kjyyDOList.get(0).getKjyyVaos());
                    } else {
                        conclusion.setLeftva("");
                    }
                }
                settlementDO.setRecipelType("远用");
            } else if (3 == settlementDO.getRecipelwlType()){
                List<SgjjDO> sgjjDOList = sgjjService.list(map2);
                if (null != sgjjDOList && sgjjDOList.size() > 0){
                    conclusion.setRightsph(sgjjDOList.get(0).getSgjjSphod());
                    conclusion.setRightcyl(sgjjDOList.get(0).getSgjjCylod());
                    conclusion.setRightzx(sgjjDOList.get(0).getSgjjAxialod());
                    if (null != sgjjDOList.get(0).getSgjjYytjod()){
                        conclusion.setRightyytj(sgjjDOList.get(0).getSgjjYytjod());
                    } else {
                        conclusion.setRightyytj("");
                    }
                    if (null != sgjjDOList.get(0).getSgjjJytjod()){
                        conclusion.setRightjytj(sgjjDOList.get(0).getSgjjJytjod());
                    } else {
                        conclusion.setRightjytj("");
                    }
                    conclusion.setRighttg(sgjjDOList.get(0).getSgjjTgod());
                    conclusion.setRightprism("");
                    conclusion.setRightjd("");
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(sgjjDOList.get(0).getSgjjSphos());
                    conclusion.setLeftcyl(sgjjDOList.get(0).getSgjjCylos());
                    conclusion.setLeftzx(sgjjDOList.get(0).getSgjjAxialos());
                    if (null != sgjjDOList.get(0).getSgjjYytjos()){
                        conclusion.setLeftyytj(sgjjDOList.get(0).getSgjjYytjos());
                    } else {
                        conclusion.setLeftyytj("");
                    }
                    if (null != sgjjDOList.get(0).getSgjjJytjos()){
                        conclusion.setLeftjytj(sgjjDOList.get(0).getSgjjJytjos());
                    } else {
                        conclusion.setLeftjytj("");
                    }
                    conclusion.setLefttg(sgjjDOList.get(0).getSgjjTgos());
                    conclusion.setLeftprism("");
                    conclusion.setLeftjd("");
                    conclusion.setLeftAdd("");
                    if (null != sgjjDOList.get(0).getSgjjJyvaod()){
                        conclusion.setRightjyva(sgjjDOList.get(0).getSgjjJyvaod());
                    } else {
                        conclusion.setRightjyva("");
                    }
                    if (null != sgjjDOList.get(0).getSgjjYyvaod()){
                        conclusion.setRightva(sgjjDOList.get(0).getSgjjYyvaod());
                    } else {
                        conclusion.setRightva("");
                    }
                    if (null != sgjjDOList.get(0).getSgjjJyvaos()){
                        conclusion.setLeftjyva(sgjjDOList.get(0).getSgjjJyvaos());
                    } else {
                        conclusion.setLeftjyva("");
                    }
                    if (null != sgjjDOList.get(0).getSgjjYyvaos()){
                        conclusion.setLeftva(sgjjDOList.get(0).getSgjjYyvaos());
                    } else {
                        conclusion.setLeftva("");
                    }
                }
                settlementDO.setRecipelType("渐进/双光");
            } else if (4 == settlementDO.getRecipelwlType()){
                List<ZyDO> zyDOList = zyService.list(map2);
                if (null != zyDOList && zyDOList.size() > 0){
                    conclusion.setRightsph(zyDOList.get(0).getZySphod());
                    conclusion.setRightcyl(zyDOList.get(0).getZyCylod());
                    conclusion.setRightzx(zyDOList.get(0).getZyAxialod());
                    if (null != zyDOList.get(0).getZyZytjod()){
                        conclusion.setRightyytj(zyDOList.get(0).getZyZytjod());
                    } else {
                        conclusion.setRightyytj("");
                    }
                    conclusion.setRighttg(zyDOList.get(0).getZyTgod());
                    conclusion.setRightprism(zyDOList.get(0).getZyPrismod());
                    conclusion.setRightjd(zyDOList.get(0).getZyJdod());
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(zyDOList.get(0).getZySphos());
                    conclusion.setLeftcyl(zyDOList.get(0).getZyCylos());
                    conclusion.setLeftzx(zyDOList.get(0).getZyAxialos());
                    if (null != zyDOList.get(0).getZyZytjos()){
                        conclusion.setLeftyytj(zyDOList.get(0).getZyZytjos());
                    } else {
                        conclusion.setLeftyytj("");
                    }
                    conclusion.setLefttg(zyDOList.get(0).getZyTgos());
                    conclusion.setLeftprism(zyDOList.get(0).getZyPrismos());
                    conclusion.setLeftjd(zyDOList.get(0).getZyJdos());
                    conclusion.setLeftAdd("");
                }
                settlementDO.setRecipelType("中用");
            } else if (5 == settlementDO.getRecipelwlType()){
                List<RxjmjcjDO> rxjmjcjDOList = rxjmjcjService.list(map2);
                if (null != rxjmjcjDOList && rxjmjcjDOList.size() > 0){
                    conclusion.setRightsph(rxjmjcjDOList.get(0).getRxSphod());
                    conclusion.setRightcyl(rxjmjcjDOList.get(0).getRxCylod());
                    conclusion.setRightzx(rxjmjcjDOList.get(0).getRxAxialod());
                    conclusion.setRightyytj("");
                    conclusion.setRighttg("");
                    conclusion.setRightprism("");
                    conclusion.setRightjd("");
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(rxjmjcjDOList.get(0).getRxSphos());
                    conclusion.setLeftcyl(rxjmjcjDOList.get(0).getRxCylos());
                    conclusion.setLeftzx(rxjmjcjDOList.get(0).getRxAxialos());
                    conclusion.setLeftyytj("");
                    conclusion.setLefttg("");
                    conclusion.setLeftprism("");
                    conclusion.setLeftjd("");
                    conclusion.setLeftAdd("");
                }
                settlementDO.setRecipelType("隐形");
            } else if (7 == settlementDO.getRecipelwlType()){
                List<SjxlDO> sjxlDOList = sjxlService.list(map2);
                if (null != sjxlDOList && sjxlDOList.size() > 0){
                    conclusion.setRightsph(sjxlDOList.get(0).getSjxlSphod());
                    conclusion.setRightcyl(sjxlDOList.get(0).getSjxlCylod());
                    conclusion.setRightzx(sjxlDOList.get(0).getSjxlAxialod());
                    if (null != sjxlDOList.get(0).getSjxlYytjod()){
                        conclusion.setRightyytj(sjxlDOList.get(0).getSjxlYytjod());
                    } else {
                        conclusion.setRightyytj("");
                    }
                    conclusion.setRighttg("");
                    conclusion.setRightprism(sjxlDOList.get(0).getSjxlSljod());
                    conclusion.setRightjd(sjxlDOList.get(0).getSjxlJdod());
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(sjxlDOList.get(0).getSjxlSphos());
                    conclusion.setLeftcyl(sjxlDOList.get(0).getSjxlCylos());
                    conclusion.setLeftzx(sjxlDOList.get(0).getSjxlAxialos());
                    if (null != sjxlDOList.get(0).getSjxlYytjos()){
                        conclusion.setLeftyytj(sjxlDOList.get(0).getSjxlYytjos());
                    } else {
                        conclusion.setLeftyytj("");
                    }
                    conclusion.setLefttg("");
                    conclusion.setLeftprism(sjxlDOList.get(0).getSjxlSljos());
                    conclusion.setLeftjd(sjxlDOList.get(0).getSjxlJdos());
                    conclusion.setLeftAdd("");
                }
                settlementDO.setRecipelType("视觉训练");
            }else if (settlementDO.getRecipelwlType() == 8){
                List<VstDO> vstDOList = vstService.list(map2);
                if (null != vstDOList && vstDOList.size() > 0){
                    conclusion.setRightsph(vstDOList.get(0).getVstSphod());
                    conclusion.setRightcyl(vstDOList.get(0).getVstCylod());
                    conclusion.setRightzx(vstDOList.get(0).getVstAxialod());
                    conclusion.setRightyytj("");
                    conclusion.setRighttg("");
                    conclusion.setRightprism("");
                    conclusion.setRightjd("");
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(vstDOList.get(0).getVstSphos());
                    conclusion.setLeftcyl(vstDOList.get(0).getVstCylos());
                    conclusion.setLeftzx(vstDOList.get(0).getVstAxialos());
                    conclusion.setLeftyytj("");
                    conclusion.setLefttg("");
                    conclusion.setLeftprism("");
                    conclusion.setLeftjd("");
                    conclusion.setLeftAdd("");
                }
                settlementDO.setRecipelType("角膜塑形镜VST");
            } else if (settlementDO.getRecipelwlType() == 9){
                List<CrtDO> crtDOList = crtService.list(map2);
                if (null != crtDOList && crtDOList.size() > 0){
                    conclusion.setRightsph(crtDOList.get(0).getCrtSdbhod());
                    conclusion.setRightcyl(crtDOList.get(0).getCrtCylod());
                    conclusion.setRightzx(crtDOList.get(0).getCrtAxialod());
                    conclusion.setRightyytj("");
                    conclusion.setRighttg("");
                    conclusion.setRightprism("");
                    conclusion.setRightjd("");
                    conclusion.setRightAdd("");
                    conclusion.setLeftsph(crtDOList.get(0).getCrtSphod());
                    conclusion.setLeftcyl(crtDOList.get(0).getCrtCylos());
                    conclusion.setLeftzx(crtDOList.get(0).getCrtAxialos());
                    conclusion.setLeftyytj("");
                    conclusion.setLefttg("");
                    conclusion.setLeftprism("");
                    conclusion.setLeftjd("");
                    conclusion.setLeftAdd("");
                }
                settlementDO.setRecipelType("角膜塑形镜CRT");
            }

        } else {
            model.addAttribute("optometryName",settlementDO.getOptometryName());
            List<Conclusion> conclusionList = salesService.conclusionList(map2);
            if (null != conclusionList && conclusionList.size() > 0){
                conclusion.setRightsph(conclusionList.get(0).getRightsph());
                conclusion.setRightcyl(conclusionList.get(0).getRightcyl());
                conclusion.setRightzx(conclusionList.get(0).getRightzx());
                if (null != conclusionList.get(0).getRightva() && !"".equals(conclusionList.get(0).getRightva()) ){
                    conclusion.setRightva(conclusionList.get(0).getRightva());
                }else {
                    if(null != conclusionList.get(0).getRightqgd() && !"".equals(conclusionList.get(0).getRightqgd())){
                        conclusion.setRightva(conclusionList.get(0).getRightqgd());
                    }else {
                        conclusion.setRightva("");
                    }

                }
                if (null != conclusionList.get(0).getRightjyva() && !"".equals(conclusionList.get(0).getRightjyva())){
                    conclusion.setRightjyva(conclusionList.get(0).getRightjyva());
                }else{
                    conclusion.setRightjyva("");
                }
                if (null != conclusionList.get(0).getRightyytj() && !"".equals(conclusionList.get(0).getRightyytj())){
                    conclusion.setRightyytj(conclusionList.get(0).getRightyytj());
                } else {
                    conclusion.setRightyytj(conclusionList.get(0).getRightjytj());
                }
                if (null != conclusionList.get(0).getRightjytj() && !"".equals(conclusionList.get(0).getRightjytj())){
                    conclusion.setRightjytj(conclusionList.get(0).getRightjytj());
                }else {
                    conclusion.setRightjytj("");
                }
                conclusion.setRighttg(conclusionList.get(0).getRighttg());
                conclusion.setRightprism(conclusionList.get(0).getRightprism());
                conclusion.setRightjd(conclusionList.get(0).getRightjd());
                conclusion.setLeftsph(conclusionList.get(0).getLeftsph());
                conclusion.setLeftcyl(conclusionList.get(0).getLeftcyl());
                conclusion.setLeftzx(conclusionList.get(0).getLeftzx());
                if (null != conclusionList.get(0).getLeftva() && !"".equals(conclusionList.get(0).getLeftva())){
                    conclusion.setLeftva(conclusionList.get(0).getLeftva());
                }else {
                    if (null != conclusionList.get(0).getLeftqgd() && !"".equals(conclusionList.get(0).getLeftqgd())){
                        conclusion.setLeftva(conclusionList.get(0).getLeftqgd());
                    } else {
                        conclusion.setLeftva("");
                    }
                }
                if (null != conclusionList.get(0).getLeftjyva() && !"".equals(conclusionList.get(0).getLeftjyva())){
                    conclusion.setLeftjyva(conclusionList.get(0).getLeftjyva());
                }else {
                    conclusion.setLeftjyva("");
                }
                if (null != conclusionList.get(0).getLeftyytj() && !"".equals(conclusionList.get(0).getLeftyytj())){
                    conclusion.setLeftyytj(conclusionList.get(0).getLeftyytj());
                } else {
                    conclusion.setLeftyytj(conclusionList.get(0).getLeftjytj());
                }
                if (null != conclusionList.get(0).getLeftjytj() && !"".equals(conclusionList.get(0).getLeftjytj())){
                    conclusion.setLeftjytj(conclusionList.get(0).getLeftjytj());
                }else {
                    conclusion.setLeftjytj("");
                }
                conclusion.setLefttg(conclusionList.get(0).getLefttg());
                conclusion.setLeftprism(conclusionList.get(0).getLeftprism());
                conclusion.setLeftjd(conclusionList.get(0).getLeftjd());
            }

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
        if (null != addPrice && !"".equals(addPrice)){
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
            map.put("identityId",member.getIdentityId());
            List<MemberDO> list = memberService.list(map);
            if (list.size() > 0){
                return R.error("该会员已存在");
            }
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
        lineDO.setMemberName(memberDO.getName());
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
