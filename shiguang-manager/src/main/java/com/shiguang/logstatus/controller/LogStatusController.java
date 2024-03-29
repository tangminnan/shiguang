package com.shiguang.logstatus.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.InfoDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.InfoService;
import com.shiguang.storeSales.service.SalesService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.ObjectView;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/information/logstatus")
public class LogStatusController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private StockService stockService;
    @Autowired
    private DepartmentService departmentService;
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
    @Autowired
    private InfoService infoService;

//    @GetMapping()
//    @RequiresPermissions("information:logstatus:logstatus")
//    String Status(){
//        return "logstatus/logstatus";
//    }
//
//    @ResponseBody
//    @GetMapping("/list")
//    @RequiresPermissions("information:logstatus:logstatus")
//    public PageUtils list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//        List<LogStatusDO> statusList = statusService.list(query);
//        int total = statusService.count(query);
//        PageUtils pageUtils = new PageUtils(statusList, total);
//        return pageUtils;
//    }

    /**
     * 发料
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:logstatus:faliao")
    String faliao(){
        return "logstatus/faliao";
    }

    @ResponseBody
    @GetMapping("/faliaolist")
    @RequiresPermissions("information:logstatus:faliao")
    public PageUtils faliaolist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("logisticStatuss","1");
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        //query.put("storeDescribe","镜片");
        if (null != params.get("memberName") && !"".equals(params.get("memberName"))){
            query.put("memberName",String.valueOf(query.get("memberName")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("phone") && !"".equals(params.get("phone"))){
            query.put("phone",String.valueOf(query.get("phone")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            if ("委外完成".equals(salesDO.getLogStatus())){
                salesDO.setClassTypeFL("2");
            }
//            if (null != salesDO.getClasstype()){
//                String[] classArray = salesDO.getClasstype().split(",");
//                boolean result = false;
//                result = Arrays.asList(classArray).contains("2");
//                if (result == true){
//
//                }
//            }
        }
        int total = statusService.findSaleCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/yifaliaolist")
    @RequiresPermissions("information:logstatus:faliao")
    public PageUtils yifaliaolist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        query.put("logisticStatusss","1");
        //query.put("storeDescribe","镜片");
        if (null != params.get("memberName") && !"".equals(params.get("memberName"))){
            query.put("memberName",String.valueOf(query.get("memberName")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("phone") && !"".equals(params.get("phone"))){
            query.put("phone",String.valueOf(query.get("phone")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            salesDO.setClassTypeFL("2");
//            if ("委外完成".equals(salesDO.getLogStatus())){
//                salesDO.setClassTypeFL("2");
//            }
        }
        int total = statusService.findSaleCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:logstatus:add")
    String add(){
        return "logstatus/add";
    }

    @GetMapping("/edit/{saleNumber}")
    @RequiresPermissions("information:logstatus:edit")
    String edit(@PathVariable("saleNumber") String saleNumber,Model model){
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("faliaoName",ShiroUtils.getUser().getName());
        model.addAttribute("faliaoDate",simpleDateFormat.format(new Date()));
        if (null != settlementDO.getPeijingTime()){
            settlementDO.setPeijingDate(simpleDateFormat.format(settlementDO.getPeijingTime()));
        }else {
            settlementDO.setPeijingDate("");
        }
        settlementDO.setMirrorDate(simpleDateFormat.format(settlementDO.getMirrorTime()));
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
                    if (null != n){
                        sb.append(n.replace("'", "\\'")).append(",");
                    }

                }
                if (sb.length()>0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
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
                } else if ("5".equals(paymodel[i])){
                    model.addAttribute("paymodel","银联卡");
                    payModels.append("银联卡:"+moneyPay[i]+",");
                } else if ("6".equals(paymodel[i])){
                    model.addAttribute("paymodel","储值卡");
                    payModels.append("储值卡:"+moneyPay[i]+",");
                } else if ("7".equals(paymodel[i])){
                    model.addAttribute("paymodel",".");
                    payModels.append("储值卡:"+moneyPay[i]+",");
                } else if ("8".equals(paymodel[i])){
                    model.addAttribute("paymodel","..");
                    payModels.append("储值卡:"+moneyPay[i]+",");
                } else if ("9".equals(paymodel[i])){
                    model.addAttribute("paymodel","积分");
                    payModels.append("积分:"+moneyPay[i]+",");
                } else if ("10".equals(paymodel[i])){
                    model.addAttribute("paymodel","微信平台");
                    payModels.append("微信平台:"+moneyPay[i]+",");
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
        map2.put("ptometry_number",settlementDO.getPtometryNumber());
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
            String reciple = settlementDO.getRecipelType();
            if ("近用".equals(reciple)){
                reciple = "1";
            } else if ("远用".equals(reciple)){
                reciple = "2";
            }else if ("渐进/双光".equals(reciple)){
                reciple = "3";
            } else if ("中用".equals(reciple)){
                reciple = "4";
            } else if ("隐形".equals(reciple)){
                reciple = "5";
            } else if ("角膜塑形镜".equals(reciple)){
                reciple = "6";
            } else if ("视觉训练".equals(reciple)){
                reciple = "7";
            } else if ("角膜塑形镜VST".equals(reciple)){
                reciple = "8";
            } else if ("角膜塑形镜CRT".equals(reciple)){
                reciple = "9";
            } else if ("RGP".equals(reciple)){
                reciple = "10";
            }
            List<Conclusion> conclusionList = salesService.conclusionList(map2);
            if (null != conclusionList && conclusionList.size() > 0){
                for (Conclusion conclusion1 : conclusionList) {
                    if (reciple.equals(conclusion1.getChufangType())){
                        conclusion.setRightsph(conclusion1.getRightsph());
                        conclusion.setRightcyl(conclusion1.getRightcyl());
                        conclusion.setRightzx(conclusion1.getRightzx());
                        if (null != conclusion1.getRightva() && !"".equals(conclusion1.getRightva()) ){
                            conclusion.setRightva(conclusion1.getRightva());
                        }else {
                            if(null != conclusion1.getRightqgd() && !"".equals(conclusion1.getRightqgd())){
                                conclusion.setRightva(conclusion1.getRightqgd());
                            }else {
                                conclusion.setRightva("");
                            }

                        }
                        if (null != conclusion1.getRightjyva() && !"".equals(conclusion1.getRightjyva())){
                            conclusion.setRightjyva(conclusion1.getRightjyva());
                        }else{
                            conclusion.setRightjyva("");
                        }
                        if (null != conclusion1.getRightyytj() && !"".equals(conclusion1.getRightyytj())){
                            conclusion.setRightyytj(conclusion1.getRightyytj());
                        } else {
                            conclusion.setRightyytj("");
                        }
                        if (null != conclusion1.getRightjytj() && !"".equals(conclusion1.getRightjytj())){
                            conclusion.setRightjytj(conclusion1.getRightjytj());
                        }else {
                            conclusion.setRightjytj("");
                        }
                        conclusion.setRighttg(conclusion1.getRighttg());
                        conclusion.setRightprism(conclusion1.getRightprism());
                        conclusion.setRightjd(conclusion1.getRightjd());
                        conclusion.setLeftsph(conclusion1.getLeftsph());
                        conclusion.setLeftcyl(conclusion1.getLeftcyl());
                        conclusion.setLeftzx(conclusion1.getLeftzx());
                        if (null != conclusion1.getLeftva() && !"".equals(conclusion1.getLeftva())){
                            conclusion.setLeftva(conclusion1.getLeftva());
                        }else {
                            if (null != conclusion1.getLeftqgd() && !"".equals(conclusion1.getLeftqgd())){
                                conclusion.setLeftva(conclusion1.getLeftqgd());
                            } else {
                                conclusion.setLeftva("");
                            }
                        }
                        if (null != conclusion1.getLeftjyva() && !"".equals(conclusion1.getLeftjyva())){
                            conclusion.setLeftjyva(conclusion1.getLeftjyva());
                        }else {
                            conclusion.setLeftjyva("");
                        }
                        if (null != conclusion1.getLeftyytj() && !"".equals(conclusion1.getLeftyytj())){
                            conclusion.setLeftyytj(conclusion1.getLeftyytj());
                        } else {
                            conclusion.setLeftyytj("");
                        }
                        if (null != conclusion1.getLeftjytj() && !"".equals(conclusion1.getLeftjytj())){
                            conclusion.setLeftjytj(conclusion1.getLeftjytj());
                        }else {
                            conclusion.setLeftjytj("");
                        }
                        conclusion.setLefttg(conclusion1.getLefttg());
                        conclusion.setLeftprism(conclusion1.getLeftprism());
                        conclusion.setLeftjd(conclusion1.getLeftjd());
                    }
                }

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
//        return "logstatus/peijingdan";
        return "logstatus/faliaostatus";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:logstatus:add")
    public R save( LogStatusDO status){
        if(statusService.save(status)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:logstatus:edit")
    public R update( LogStatusDO status){
        LogStatusDO logStatusDO = new LogStatusDO();
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",status.getSaleNumber());
        map.put("jpGoodsCode",status.getGoodsNum());
        List<SalesDO> salesDOList = salesService.list(map);
        if (salesDOList.size() == 0){
            return R.error("检验有误");
        }
        logStatusDO.setSaleNumber(status.getSaleNumber());
        logStatusDO.setLogisticStatus("发料");
        logStatusDO.setFaliaoDate(new Date());
        logStatusDO.setFaliaoName(ShiroUtils.getUser().getName());
        SalesDO salesDO = salesService.getSaleNumber(status.getSaleNumber());
        String storeDesc = salesDO.getStoreDescribe();
        String[] storeDescribe = storeDesc.split(",");
        String[] goodsCode = salesDO.getGoodsCode().split(",");
        String[] storeCount = salesDO.getStoreCount().split(",");
        String companyId = "";
        if (null != ShiroUtils.getUser().getCompanyId()) {
            companyId = ShiroUtils.getUser().getCompanyId();
        }
        PositionDO positionDO = new PositionDO();
        Map<String,Object> maps = new HashMap<>();
        for (int a=0;a<storeDescribe.length;a++){
            if (!"镜架".equals(storeDescribe[a]) && !"自架".equals(storeDescribe[a]) && !"自片".equals(storeDescribe[a]) ){
                if (!"镜片".equals(storeDescribe[a]) && !"隐形".equals(storeDescribe[a])){
                    maps.put("companyId", companyId);
                    if ("3".equals(companyId)){
                        maps.put("departNumber",ShiroUtils.getUser().getStoreNum());
                    }
                    positionDO = stockService.findPosition(maps);
                } else {
                    maps.put("companyId", companyId);
                    //maps.put("departNumber",ShiroUtils.getUser().getStoreNum());
                    if ("3".equals(companyId)){
                        maps.put("positionId","7");
                    }
                    positionDO = stockService.findHegePosition(maps);
                    StockDO stockDOs = new StockDO();
                    stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
                    stockDOs.setGoodsCode(goodsCode[a]);
                    StockDO stockDO = stockService.getProduceCode(stockDOs);
                    if (null != stockDO){
                        Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                        Long count = countGoods - Long.valueOf(storeCount[a]);
                        stockDO.setGoodsCount(String.valueOf(count));
                        stockService.updateGoodsCount(stockDO);
                    }
                }
            }
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("发料");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        InfoDO infoDO = new InfoDO();
        infoDO.setSaleNumber(status.getSaleNumber());
        infoDO.setTrainStatus("配镜发料");
        infoDO.setTrainTime(new Date());
        infoDO.setTrainName(ShiroUtils.getUser().getName());
        infoService.save(infoDO);
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.ok();
    }

    /**
     * 发料
     */
    @PostMapping( "/editFaliao/{saleNumber}")
    @ResponseBody
    @RequiresPermissions("information:logstatus:edit")
    public R editFaliao(@PathVariable("saleNumber") String saleNumber,Model model){
        LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(saleNumber);
        logStatusDO.setLogisticStatus("发料");
        logStatusDO.setFaliaoDate(new Date());
        logStatusDO.setFaliaoName(ShiroUtils.getUser().getName());
        SalesDO salesDO = salesService.getSaleNumber(saleNumber);
        String storeDesc = salesDO.getStoreDescribe();
        String[] storeDescribe = storeDesc.split(",");
        String[] storeCode = salesDO.getGoodsCode().split(",");
        for (int a=0;a<storeDescribe.length;a++){
            if (storeDescribe[a] != "镜架"){
                StockDO stockDO = stockService.getGoodsNum(storeCode[a]);
                Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                Long count = countGoods - 1;
                stockDO.setGoodsCount(String.valueOf(count));
                stockService.updateGoodsCount(stockDO);
            }
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("发料");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
        if(statusService.editFaliao(logStatusDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:logstatus:remove")
    public R remove(Long id){
        if(statusService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        statusService.batchRemove(ids);
        return R.ok();
    }

    /**
     * 批量发料
     */
    @PostMapping( "/batchFaliao")
    @ResponseBody
    @RequiresPermissions("information:logstatus:batchFaliao")
    public R batchFaliao(@RequestParam("ids[]") Long[] ids){
        for (int i=0;i<ids.length;i++){
            SalesDO salesDOs =salesService.get(ids[i]);
            LogStatusDO logStatusDO = new LogStatusDO();
            logStatusDO.setSaleNumber(salesDOs.getSaleNumber());
            logStatusDO.setLogisticStatus("发料");
            logStatusDO.setFaliaoDate(new Date());
            logStatusDO.setFaliaoName(ShiroUtils.getUser().getName());
            SalesDO salesDO = salesService.getSaleNumber(salesDOs.getSaleNumber());
            String storeDesc = salesDO.getStoreDescribe();
            String[] storeDescribe = storeDesc.split(",");
            String[] storeNum = salesDO.getGoodsNum().split(",");
            String[] storeCount = salesDO.getStoreCount().split(",");
            String companyId = "";
            if (null != ShiroUtils.getUser().getCompanyId()) {
                companyId = ShiroUtils.getUser().getCompanyId();
            }
            Map<String,Object> maps = new HashMap<>();
            maps.put("companyId", companyId);
            if("3".equals(ShiroUtils.getUser().getCompanyId())){
                maps.put("positionId","7");
            }
            PositionDO positionDO = stockService.findHegePosition(maps);
            for (int a=0;a<storeDescribe.length;a++){
                if (!"镜架".equals(storeDescribe[a]) && !"自架".equals(storeDescribe[a]) && !"自片".equals(storeDescribe[a]) ){
                    StockDO stockDOs = new StockDO();
                    stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
                    stockDOs.setGoodsNum(storeNum[a]);
                    StockDO stockDO = stockService.getProduceNum(stockDOs);
                    if (null != stockDO){
                        int countGoods = Integer.parseInt(stockDO.getGoodsCount());
                        int count = countGoods - Integer.parseInt(storeCount[a]);
                        stockDO.setGoodsCount(String.valueOf(count));
                        stockService.updateGoodsCount(stockDO);
                    }
                }
            }
            statusService.editFaliao(logStatusDO);
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("批量发料");
        workRecoedDO.setDateTime(new Date());
        statusService.saveRecord(workRecoedDO);
//        Map<String,Object> map = new HashMap<>();
//        map.put("logisticStatus","发料");
//        map.put("faliaoDate",new Date());
//        map.put("faliaoName",ShiroUtils.getUser().getName());
//        statusService.batchFaliao(ids,map);
        return R.ok();
    }
}
