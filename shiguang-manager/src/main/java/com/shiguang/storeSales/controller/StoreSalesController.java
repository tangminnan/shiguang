package com.shiguang.storeSales.controller;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.domain.PackageInfoDO;
import com.shiguang.packageManager.service.PackageInfoService;
import com.shiguang.packageManager.service.PackageService;
import com.shiguang.product.domain.YxcpDO;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.*;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.xmlgraphics.xmp.schemas.DublinCoreAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.metal.MetalTheme;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

@Controller("StoreSalesController")
@RequestMapping("/information/store")
public class StoreSalesController {
    @Autowired
    private OptometryService optometryService;
    @Autowired
    private ResultDiopterService resultDiopterService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdditionalService additionalService;
    @Autowired
    private ProducaService producaService;
    @Autowired
    private JpcpService jpcpService;
    @Autowired
    private JpdzService jpdzService;
    @Autowired
    private TyjService tyjService;
    @Autowired
    private PartsService partsService;
    @Autowired
    private HcService hcService;
    @Autowired
    private OldlensService oldlensService;
    @Autowired
    private ShiguangService shiguangService;
    @Autowired
    private HlyService hlyService;
    @Autowired
    private YxcpService yxcpService;
    @Autowired
    private YxdzService yxdzService;
    @Autowired
    private GiveawayService giveawayService;
    @Autowired
    private StockService stockService;
    @Autowired
    private CostService costService;
    @Autowired
    private PackageService packageService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private KjjyService kjjyService;
    @Autowired
    private KjyyService kjyyService;
    @Autowired
    private SgjjService sgjjService;
    @Autowired
    private ZyService zyService;
    @Autowired
    private RxjmjcjService rxjmjcjService;
    @Autowired
    private SjxlService sjxlService;
    @Autowired
    private VstService vstService;
    @Autowired
    private CrtService crtService;
    @Autowired
    private RgpService rgpService;
    @Autowired
    private YaopinService yaopinService;
    @Autowired
    private PackageInfoService packageInfoService;
    @Autowired
    private LogStatusService logStatusService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping()
    @RequiresPermissions("information:store:storeSales")
    String Optometry() {
        return "storeSales/storeSales";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:store:storeSales")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<OptometryDO> optometryList = optometryService.list(query);
//        int total = optometryService.count(query);
        query.put("state", 1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:store:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleType", 1);
        List<UserDO> userDOList = userService.getRoleList(map);
        model.addAttribute("userDOList", userDOList);
        return "storeSales/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:store:edit")
    String edit(@PathVariable("cardNumber") String cardNumber, Model model) {
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
                c.setYanguangTime(sdfs.format(c.getCreateTime()));
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
        return "storeSales/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:store:add")
    public R save(SalesDO salesDO) {
        if (!"辅料".equals(salesDO.getEyeType())){
            if (null == salesDO.getIsJp() || null == salesDO.getIsJj()) {
                salesDO.setIsJp(0L);
                salesDO.setIsJj("无");
            }
            if (!salesDO.getStoreDescribe().contains("隐形")){
                if ("镜架".equals(salesDO.getStoreDescribe())
                        || "镜片".equals(salesDO.getStoreDescribe())) {
                    if (salesDO.getIsJp() < 2 && "无".equals(salesDO.getIsJj())) {
                        return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
                    }
                }
                if (salesDO.getIsJp() < 2 ) {
                    return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
                }
            }
               String[] leftRight = salesDO.getLeftRight().split(",");
                boolean resultRight = false;
                boolean resultLeft = false;
                resultRight = Arrays.asList(leftRight).contains("右");
                resultLeft = Arrays.asList(leftRight).contains("左");
                if (!"隐形".equals(salesDO.getEyeType())){
                    if (resultRight == false || resultLeft == false){
                        return R.error("镜片选择左右眼重复，请重新选择！");
                    }
                }

        }
        Long saleNumber = GuuidUtil.getUUID();
        salesDO.setSaleNumber("X" + saleNumber);
        if (null != salesDO) {
            if (null != salesDO.getAdditionalCost()) {
                salesDO.setAdditionalCost(salesDO.getAdditionalCost());
            }
            if (null != salesDO.getGiveName()) {
                salesDO.setGiveName(salesDO.getGiveName().substring(0, salesDO.getGiveName().length() - 1));
            }
            if (null != salesDO.getProcessAsk()) {
                salesDO.setProcessAsk(salesDO.getProcessAsk());
            }
            if (null != salesDO.getPtometryNumber()){
                try {
                    String[] pto = salesDO.getPtometryNumber().split(",");
                    if (pto.length > 0){
                        salesDO.setPtometryNumber(pto[0]);
                    } else {
                        salesDO.setPtometryNumber("");
                    }
                }catch (ArrayIndexOutOfBoundsException e) {
                    salesDO.setPtometryNumber("");
                }
            } else {
                salesDO.setPtometryNumber("Y"+GuuidUtil.getUUID());
            }
//            if (null != salesDO.getStoreName()){
//                salesDO.setStoreName(salesDO.getStoreName().substring(0,salesDO.getStoreName().length()-3));
//            }
//            if (null != salesDO.getStoreUnit()){
//                salesDO.setStoreUnit(salesDO.getStoreUnit().substring(0,salesDO.getStoreUnit().length()-3));
//            }
//            if (null != salesDO.getStoreCount()){
//                salesDO.setStoreCount(salesDO.getStoreCount().substring(0,salesDO.getStoreCount().length()-2));
//            }
        }
        //Model model=null;
        //保存瞳高
        if (!"".equals(salesDO.getRecipelType()) && null != salesDO.getRecipelType()){
            if ("远用".equals(salesDO.getRecipelType())){
                salesDO.setRighttg(salesDO.getRighttonggaoyy());
                salesDO.setLefttg(salesDO.getLefttonggaoyy());
            } else if ("近用".equals(salesDO.getRecipelType())){
                salesDO.setRighttg(salesDO.getRighttonggaojy());
                salesDO.setLefttg(salesDO.getLefttonggaojy());
            } else if ("渐进/双光".equals(salesDO.getRecipelType())){
                salesDO.setRighttg(salesDO.getRighttonggaosg());
                salesDO.setLefttg(salesDO.getLefttonggaosg());
            } else if ("中用".equals(salesDO.getRecipelType())){
                salesDO.setRighttg(salesDO.getRighttonggaozy());
                salesDO.setLefttg(salesDO.getLefttonggaozy());
            }
        } else if (null != salesDO.getRecipelwlType() && !"".equals(salesDO.getRecipelwlType())){
            if (salesDO.getRecipelwlType() == 2){
                salesDO.setRighttg(salesDO.getRighttonggaoyy());
                salesDO.setLefttg(salesDO.getLefttonggaoyy());
            } else if (salesDO.getRecipelwlType() == 1){
                salesDO.setRighttg(salesDO.getRighttonggaojy());
                salesDO.setLefttg(salesDO.getLefttonggaojy());
            } else if (salesDO.getRecipelwlType() == 3){
                salesDO.setRighttg(salesDO.getRighttonggaosg());
                salesDO.setLefttg(salesDO.getLefttonggaosg());
            } else if (salesDO.getRecipelwlType() == 4){
                salesDO.setRighttg(salesDO.getRighttonggaozy());
                salesDO.setLefttg(salesDO.getLefttonggaozy());
            }
        }


        if ("2".equals(salesDO.getChufang())) {
            if (salesDO.getRecipelwlType() == 1) {
                KjjyDO kjjyDO = new KjjyDO();
                kjjyDO.setPtometryNumber(salesDO.getPtometryNumber());
                kjjyDO.setCardNumber(salesDO.getMemberNumber());
                kjjyDO.setSaleNumber(salesDO.getSaleNumber());
                kjjyDO.setKjjyPrescriptionType(salesDO.getRecipelwlType().toString());
                kjjyDO.setKjjyOptometryName(salesDO.getOptometrywlName());
                kjjyDO.setKjjySphod(salesDO.getRightQJjy());
                kjjyDO.setKjjySphos(salesDO.getLeftQJjy());
                if ("".equals(salesDO.getRightZJjy()) || null == salesDO.getRightZJjy()){
                    kjjyDO.setKjjyCylod("0.00");
                }else {
                    kjjyDO.setKjjyCylod(salesDO.getRightZJjy());
                }
                if ("".equals(salesDO.getLeftZJjy()) || null == salesDO.getLeftZJjy()){
                    kjjyDO.setKjjyCylos("0.00");
                }else {
                    kjjyDO.setKjjyCylos(salesDO.getLeftZJjy());
                }
                kjjyDO.setKjjyAxialod(salesDO.getRightzhouxiangjy());
                kjjyDO.setKjjyAxialos(salesDO.getLeftzhouxiangjy());
                kjjyDO.setKjjyPrismod(salesDO.getRightsanlingjingjy());
                kjjyDO.setKjjyPrismos(salesDO.getLeftsanlingjingjy());
                kjjyDO.setKjjyJdod(salesDO.getRightjidijy());
                kjjyDO.setKjjyJdos(salesDO.getLeftjidijy());
                kjjyDO.setKjjyYytjod(salesDO.getRightyuanyongtjjy());
                kjjyDO.setKjjyYytjos(salesDO.getLeftyuanyongtjjy());
                kjjyDO.setKjjyTgod(salesDO.getRighttonggaojy());
                kjjyDO.setKjjyTgos(salesDO.getLefttonggaojy());
                kjjyDO.setKjjyVaod(salesDO.getRightyuanyongVAjy());
                kjjyDO.setKjjyVaos(salesDO.getLeftyuanyongVAjy());
                kjjyDO.setStatus("1");
                kjjyService.save(kjjyDO);
            } else if (salesDO.getRecipelwlType() == 2) {
                KjyyDO kjyyDO = new KjyyDO();
                kjyyDO.setPtometryNumber(salesDO.getPtometryNumber());
                kjyyDO.setCardNumber(salesDO.getMemberNumber());
                kjyyDO.setSaleNumber(salesDO.getSaleNumber());
                kjyyDO.setKjyyPrescriptionType(salesDO.getRecipelwlType().toString());
                kjyyDO.setKjyyOptometryName(salesDO.getOptometrywlName());
                kjyyDO.setKjyySphod(salesDO.getRightQJyy());
                kjyyDO.setKjyySphos(salesDO.getLeftQJyy());
                if ("".equals(salesDO.getRightZJyy()) || null == salesDO.getRightZJyy()){
                    kjyyDO.setKjyyCylod("0.00");
                } else {
                    kjyyDO.setKjyyCylod(salesDO.getRightZJyy());
                }
                if ("".equals(salesDO.getLeftZJyy()) || null == salesDO.getLeftZJyy()){
                    kjyyDO.setKjyyCylos("0.00");
                } else {
                    kjyyDO.setKjyyCylos(salesDO.getLeftZJyy());
                }

                kjyyDO.setKjyyAxialod(salesDO.getRightzhouxiangyy());
                kjyyDO.setKjyyAxialos(salesDO.getLeftzhouxiangyy());
                kjyyDO.setKjyyPrismod(salesDO.getRightsanlingjingyy());
                kjyyDO.setKjyyPrismos(salesDO.getLeftsanlingjingyy());
                kjyyDO.setKjyyJdod(salesDO.getRightjidiyy());
                kjyyDO.setKjyyJdos(salesDO.getLeftjidiyy());
                kjyyDO.setKjyyYytjod(salesDO.getRightyuanyongtjyy());
                kjyyDO.setKjyyYytjos(salesDO.getLeftyuanyongtjyy());
                kjyyDO.setKjyyTgod(salesDO.getRighttonggaoyy());
                kjyyDO.setKjyyTgos(salesDO.getLefttonggaoyy());
                kjyyDO.setKjyyVaod(salesDO.getRightyuanyongVAyy());
                kjyyDO.setKjyyVaos(salesDO.getLeftyuanyongVAyy());
                kjyyDO.setStatus("1");
                kjyyService.save(kjyyDO);
            } else if (salesDO.getRecipelwlType() == 3) {
                SgjjDO sgjjDO = new SgjjDO();
                sgjjDO.setPtometryNumber(salesDO.getPtometryNumber());
                sgjjDO.setCardNumber(salesDO.getMemberNumber());
                sgjjDO.setSaleNumber(salesDO.getSaleNumber());
                sgjjDO.setSgjjPrescriptionType(salesDO.getRecipelwlType().toString());
                sgjjDO.setSgjjOptometryName(salesDO.getOptometrywlName());
                sgjjDO.setSgjjSphod(salesDO.getRightQJsg());
                sgjjDO.setSgjjSphos(salesDO.getLeftQJsg());
                if ("".equals(salesDO.getRightZJsg()) || null == salesDO.getRightZJsg()){
                    sgjjDO.setSgjjCylod("0.00");
                }else {
                    sgjjDO.setSgjjCylod(salesDO.getRightZJsg());
                }
                if ("".equals(salesDO.getLeftZJsg()) || null == salesDO.getLeftZJsg()){
                    sgjjDO.setSgjjCylos("0.00");
                }else {
                    sgjjDO.setSgjjCylos(salesDO.getLeftZJsg());
                }

                sgjjDO.setSgjjAxialod(salesDO.getRightzhouxiangsg());
                sgjjDO.setSgjjAxialos(salesDO.getLeftzhouxiangsg());
                sgjjDO.setSgjjYytjod(salesDO.getRightyuanyongtjsg());
                sgjjDO.setSgjjYytjos(salesDO.getLeftyuanyongtjsg());
                sgjjDO.setSgjjJytjod(salesDO.getRightjinyongtjsg());
                sgjjDO.setSgjjJytjos(salesDO.getLeftjinyongtjsg());
                sgjjDO.setSgjjTgod(salesDO.getRighttonggaosg());
                sgjjDO.setSgjjTgos(salesDO.getLefttonggaosg());
                sgjjDO.setSgjjYyvaod(salesDO.getRightyuanyongVAsg());
                sgjjDO.setSgjjYyvaos(salesDO.getLeftyuanyongVAsg());
                sgjjDO.setSgjjJyvaod(salesDO.getRightjinyongVAsg());
                sgjjDO.setSgjjJyvaos(salesDO.getLeftjinyongVAsg());
                sgjjDO.setStatus("1");
                sgjjService.save(sgjjDO);
            } else if (salesDO.getRecipelwlType() == 4) {
                ZyDO zyDO = new ZyDO();
                zyDO.setPtometryNumber(salesDO.getPtometryNumber());
                zyDO.setCardNumber(salesDO.getMemberNumber());
                zyDO.setSaleNumber(salesDO.getSaleNumber());
                zyDO.setZyPrescriptionType(salesDO.getRecipelwlType().toString());
                zyDO.setZyOptometryName(salesDO.getOptometrywlName());
                zyDO.setZySphod(salesDO.getRightQJzy());
                zyDO.setZySphos(salesDO.getLeftQJzy());
                if ("".equals(salesDO.getRightZJzy()) || null == salesDO.getRightZJzy()){
                    zyDO.setZyCylod("0.00");
                } else {
                    zyDO.setZyCylod(salesDO.getRightZJzy());
                }
                if ("".equals(salesDO.getLeftZJzy()) || null == salesDO.getLeftZJzy()){
                    zyDO.setZyCylos("0.00");
                } else {
                    zyDO.setZyCylos(salesDO.getLeftZJzy());
                }
                zyDO.setZyAxialod(salesDO.getRightzhouxiangzy());
                zyDO.setZyAxialos(salesDO.getLeftzhouxiangzy());
                zyDO.setZyPrismod(salesDO.getRightsanlingjingzy());
                zyDO.setZyPrismos(salesDO.getLeftsanlingjingzy());
                zyDO.setZyJdod(salesDO.getRightjidizy());
                zyDO.setZyJdos(salesDO.getLeftjidizy());
                zyDO.setZyZytjod(salesDO.getRightyuanyongtjzy());
                zyDO.setZyZytjos(salesDO.getLeftyuanyongtjzy());
                zyDO.setZyTgod(salesDO.getRighttonggaozy());
                zyDO.setZyTgos(salesDO.getLefttonggaozy());
                zyDO.setZyVaod(salesDO.getRightyuanyongVAzy());
                zyDO.setZyVaos(salesDO.getLeftyuanyongVAzy());
                zyDO.setStatus("1");
                zyService.save(zyDO);
            } else if (salesDO.getRecipelwlType() == 5) {
                RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
                rxjmjcjDO.setPtometryNumber(salesDO.getPtometryNumber());
                rxjmjcjDO.setCardNumber(salesDO.getMemberNumber());
                rxjmjcjDO.setSaleNumber(salesDO.getSaleNumber());
                rxjmjcjDO.setRxPrescriptionType(salesDO.getRecipelwlType().toString());
                rxjmjcjDO.setRxOptometryName(salesDO.getOptometrywlName());
                rxjmjcjDO.setRxSphod(salesDO.getRightQJyx());
                rxjmjcjDO.setRxSphos(salesDO.getLeftQJyx());
                if ("".equals(salesDO.getRightZJyx()) || null == salesDO.getRightZJyx()){
                    rxjmjcjDO.setRxCylod("0.00");
                } else {
                    rxjmjcjDO.setRxCylod(salesDO.getRightZJyx());
                }
                if ("".equals(salesDO.getLeftZJyx()) || null == salesDO.getLeftZJyx()){
                    rxjmjcjDO.setRxCylos("0.00");
                } else {
                    rxjmjcjDO.setRxCylos(salesDO.getLeftZJyx());
                }
                rxjmjcjDO.setRxAxialod(salesDO.getRightzhouxiangyx());
                rxjmjcjDO.setRxAxialos(salesDO.getLeftzhouxiangyx());
                rxjmjcjDO.setRxZjod(salesDO.getRightzhijingyx());
                rxjmjcjDO.setRxZjos(salesDO.getLeftzhijingyx());
                rxjmjcjDO.setRxVaod(salesDO.getRightYingXingVAyx());
                rxjmjcjDO.setRxVaos(salesDO.getLeftYingXingVAyx());
                rxjmjcjDO.setStatus("1");
                rxjmjcjService.save(rxjmjcjDO);
            } else if (salesDO.getRecipelwlType() == 7) {
                SjxlDO sjxlDO = new SjxlDO();
                sjxlDO.setPtometryNumber(salesDO.getPtometryNumber());
                sjxlDO.setCardNumber(salesDO.getMemberNumber());
                sjxlDO.setSaleNumber(salesDO.getSaleNumber());
                sjxlDO.setSjxlPrescriptionType(salesDO.getRecipelwlType().toString());
                sjxlDO.setSjxlOptometryName(salesDO.getOptometrywlName());
                sjxlDO.setSjxlSphod(salesDO.getRightQJxl());
                sjxlDO.setSjxlSphos(salesDO.getLeftQJxl());
                if ("".equals(salesDO.getRightZJxl()) || null == salesDO.getRightZJxl()){
                    sjxlDO.setSjxlCylod("0.00");
                } else {
                    sjxlDO.setSjxlCylod(salesDO.getRightZJxl());
                }
                if ("".equals(salesDO.getLeftZJxl()) || null == salesDO.getLeftZJxl()){
                    sjxlDO.setSjxlCylos("0.00");
                } else {
                    sjxlDO.setSjxlCylos(salesDO.getLeftZJxl());
                }

                sjxlDO.setSjxlAxialod(salesDO.getRightzhouxiangxl());
                sjxlDO.setSjxlAxialos(salesDO.getLeftzhouxiangxl());
                sjxlDO.setSjxlJdod(salesDO.getRightjidixl());
                sjxlDO.setSjxlJdos(salesDO.getLeftjidixl());
                sjxlDO.setSjxlYytjod(salesDO.getRightSJXLyytj());
                sjxlDO.setSjxlYytjos(salesDO.getLeftSJXLyytj());
                sjxlDO.setSjxlYyvaod(salesDO.getRightSJXLyyva());
                sjxlDO.setSjxlYyvaos(salesDO.getLeftSJXLyyva());
                sjxlDO.setStatus("1");
                sjxlService.save(sjxlDO);
            }else if (salesDO.getRecipelwlType() == 8){
                VstDO vstDO = new VstDO();
                vstDO.setPtometryNumber(salesDO.getPtometryNumber());
                vstDO.setVstPrescriptionType(salesDO.getRecipelwlType().toString());
                vstDO.setCardNumber(salesDO.getMemberNumber());
                vstDO.setVstSphod(salesDO.getRightQJvst());
                vstDO.setVstSphos(salesDO.getLeftQJvst());
                if ("".equals(salesDO.getRightZJvst()) || null == salesDO.getRightZJvst()){
                    vstDO.setVstCylod("0.00");
                } else {
                    vstDO.setVstCylod(salesDO.getRightZJvst());
                }
                if ("".equals(salesDO.getLeftZJvst()) || null == salesDO.getLeftZJvst()){
                    vstDO.setVstCylos("0.00");
                } else {
                    vstDO.setVstCylos(salesDO.getLeftZJvst());
                }
                vstDO.setVstAxialod(salesDO.getRightzhouxiangvst());
                vstDO.setVstAxialos(salesDO.getLeftzhouxiangvst());
                vstDO.setVstSdbhod(salesDO.getRightVstSdjbh());
                vstDO.setVstSdbhos(salesDO.getLeftVstSdjbh());
                vstDO.setVstFkod(salesDO.getRightVstFK());
                vstDO.setVstFkos(salesDO.getLeftVstFK());
                vstDO.setVstQlbjod(salesDO.getRightVstQlbj());
                vstDO.setVstQlbjos(salesDO.getLeftVstQlbj());
                vstDO.setVstAcod(salesDO.getRightVstAC());
                vstDO.setVstAcos(salesDO.getLeftVstAC());
                vstDO.setVstJfod(salesDO.getRightVstJF());
                vstDO.setVstJfos(salesDO.getLeftVstJF());
                vstDO.setVstDiaod(salesDO.getRightVstDIA());
                vstDO.setVstDiaos(salesDO.getLeftVstDIA());
                vstDO.setVstBcod(salesDO.getRightVstBC());
                vstDO.setVstBcos(salesDO.getLeftVstBC());
                vstDO.setVstCpclyod(salesDO.getRightVstCPCLY());
                vstDO.setVstCpclyod(salesDO.getLeftVstCPCLY());
                vstDO.setVstEod(salesDO.getRightVstE());
                vstDO.setVstEos(salesDO.getLeftVstE());
                vstDO.setVstVaod(salesDO.getRightVstVA());
                vstDO.setVstVaos(salesDO.getLeftVstVA());
                vstDO.setStatus("1");
                vstService.save(vstDO);
            } else if (salesDO.getRecipelwlType() == 9){
                CrtDO crtDO = new CrtDO();
                crtDO.setPtometryNumber(salesDO.getPtometryNumber());
                crtDO.setCardNumber(salesDO.getMemberNumber());
                crtDO.setCrtPrescriptionType(salesDO.getRecipelwlType().toString());
                crtDO.setStatus("1");
                crtDO.setCrtSphod(salesDO.getRightQjcrt());
                crtDO.setCrtSphos(salesDO.getLeftQjcrt());
                if ("".equals(crtDO.getCrtCylod()) || null == crtDO.getCrtCylod()){
                    crtDO.setCrtCylod("0.00");
                } else {
                    crtDO.setCrtCylod(salesDO.getRightZjcrt());
                }
                if ("".equals(crtDO.getCrtCylos()) || null == crtDO.getCrtCylos()){
                    crtDO.setCrtCylos("0.00");
                } else {
                    crtDO.setCrtCylos(salesDO.getLeftZjcrt());
                }
                crtDO.setCrtAxialod(salesDO.getRightZhouxiangcrt());
                crtDO.setCrtAxialos(salesDO.getLeftZhouxiangcrt());
                crtDO.setCrtSdbhod(salesDO.getRightSdjbhcrt());
                crtDO.setCrtSdbhos(salesDO.getLeftSdjbhcrt());
                crtDO.setCtrBcod(salesDO.getRightBCcrt());
                crtDO.setCrtBcos(salesDO.getLeftBCcrt());
                crtDO.setCrtRzdod(salesDO.getRightRZDcrt());
                crtDO.setCrtRzdos(salesDO.getLeftRZDcrt());
                crtDO.setCrtLzaod(salesDO.getRightLZAcrt());
                crtDO.setCrtLzaos(salesDO.getLeftLZAcrt());
                crtDO.setCrtRzd2od(salesDO.getRightRZD2crt());
                crtDO.setCrtRzd2os(salesDO.getLeftRZD2crt());
                crtDO.setCrtLza2od(salesDO.getRightLZA2crt());
                crtDO.setCrtLza2os(salesDO.getLeftLZA2crt());
                crtDO.setCrtJfod(salesDO.getRightJFcrt());
                crtDO.setCrtJfos(salesDO.getLeftJFcrt());
                crtDO.setCrtDiaod(salesDO.getRightDIAcrt());
                crtDO.setCrtDiaos(salesDO.getLeftDIAcrt());
                crtDO.setCrtVaod(salesDO.getRightVAcrt());
                crtDO.setCrtVaos(salesDO.getLeftVAcrt());
                crtService.save(crtDO);
            } else if (salesDO.getRecipelwlType() == 10) {
                RgpDO rgpDO = new RgpDO();
                rgpDO.setPtometryNumber(salesDO.getPtometryNumber());
                rgpDO.setCardNumber(salesDO.getMemberNumber());
                rgpDO.setRgpPrescriptionType(salesDO.getRecipelwlType().toString());
                rgpDO.setRgpOptometryName(salesDO.getOptometrywlName());
                rgpDO.setRgpQgdod(salesDO.getRightRgpgd());
                rgpDO.setRgpQgdos(salesDO.getLeftRgpgd());
                rgpDO.setRgpBcod(salesDO.getRightBC());
                rgpDO.setRgpBcos(salesDO.getLeftBC());
                rgpDO.setRgpDiaod(salesDO.getRightDIA());
                rgpDO.setRgpDiaos(salesDO.getLeftDIA());
                rgpDO.setRgpSgod(salesDO.getRightsg());
                rgpDO.setRgpSgos(salesDO.getLeftsg());
                rgpDO.setRgpJpysod(salesDO.getRightJPColor());
                rgpDO.setRgpJpysos(salesDO.getLeftJPColor());
                rgpDO.setRgpTssjod(salesDO.getRightTssj());
                rgpDO.setRgpTssjos(salesDO.getLeftTssj());
                rgpDO.setRgpSyjpod(salesDO.getRightPinpai());
                rgpDO.setRgpSyjpos(salesDO.getLeftPinpai());
                rgpDO.setStatus("1");
                rgpService.save(rgpDO);
            } else if (salesDO.getRecipelwlType() == 11) {
                YaopinDO yaopinDO = new YaopinDO();
                yaopinDO.setPtometryNumber(salesDO.getPtometryNumber());
                yaopinDO.setCardNumber(salesDO.getMemberNumber());
                yaopinDO.setYpPrescriptionType(salesDO.getRecipelwlType().toString());
                yaopinDO.setYpOptometryName(salesDO.getOptometrywlName());
                yaopinDO.setYpNr(salesDO.getContent());
                yaopinDO.setYpYm(salesDO.getYpName());
                yaopinDO.setStatus("1");
                yaopinService.save(yaopinDO);
            }
        } else {
            if ("近用".equals(salesDO.getRecipelType())) {
                KjjyDO kjjyDO = new KjjyDO();
                kjjyDO.setPtometryNumber(salesDO.getPtometryNumber());
                kjjyDO.setKjjyAxialod(salesDO.getRightzhouxiangjy());
                kjjyDO.setKjjyAxialos(salesDO.getLeftzhouxiangjy());
                kjjyDO.setKjjyPrismod(salesDO.getRightsanlingjingjy());
                kjjyDO.setKjjyPrismos(salesDO.getLeftsanlingjingjy());
                kjjyDO.setKjjyJdod(salesDO.getRightjidijy());
                kjjyDO.setKjjyJdos(salesDO.getLeftjidijy());
                kjjyDO.setKjjyYytjod(salesDO.getRightyuanyongtjjy());
                kjjyDO.setKjjyYytjos(salesDO.getLeftyuanyongtjjy());
                kjjyDO.setKjjyTgod(salesDO.getRighttonggaojy());
                kjjyDO.setKjjyTgos(salesDO.getLefttonggaojy());
                kjjyDO.setKjjyVaod(salesDO.getRightyuanyongVAjy());
                kjjyDO.setKjjyVaos(salesDO.getLeftyuanyongVAjy());
                kjjyService.updatekjjy(kjjyDO);
            } else if ("远用".equals(salesDO.getRecipelType())) {
                KjyyDO kjyyDO = new KjyyDO();
                kjyyDO.setPtometryNumber(salesDO.getPtometryNumber());
                kjyyDO.setKjyyPrismod(salesDO.getRightsanlingjingyy());
                kjyyDO.setKjyyPrismos(salesDO.getLeftsanlingjingyy());
                kjyyDO.setKjyyJdod(salesDO.getRightjidiyy());
                kjyyDO.setKjyyJdos(salesDO.getLeftjidiyy());
                kjyyDO.setKjyyYytjod(salesDO.getRightyuanyongtjyy());
                kjyyDO.setKjyyYytjos(salesDO.getLeftyuanyongtjyy());
                kjyyDO.setKjyyTgod(salesDO.getRighttonggaoyy());
                kjyyDO.setKjyyTgos(salesDO.getLefttonggaoyy());
                kjyyDO.setKjyyVaod(salesDO.getRightyuanyongVAyy());
                kjyyDO.setKjyyVaos(salesDO.getLeftyuanyongVAyy());
                kjyyService.updatekjyy(kjyyDO);
            } else if ("渐进/双光".equals(salesDO.getRecipelType())) {
                SgjjDO sgjjDO = new SgjjDO();
                sgjjDO.setPtometryNumber(salesDO.getPtometryNumber());
                sgjjDO.setSgjjYytjod(salesDO.getRightyuanyongtjsg());
                sgjjDO.setSgjjYytjos(salesDO.getLeftyuanyongtjsg());
                sgjjDO.setSgjjJytjod(salesDO.getRightjinyongtjsg());
                sgjjDO.setSgjjJytjos(salesDO.getLeftjinyongtjsg());
                sgjjDO.setSgjjTgod(salesDO.getRighttonggaosg());
                sgjjDO.setSgjjTgos(salesDO.getLefttonggaosg());
                sgjjDO.setSgjjYyvaod(salesDO.getRightyuanyongVAsg());
                sgjjDO.setSgjjYyvaos(salesDO.getLeftyuanyongVAsg());
                sgjjDO.setSgjjJyvaod(salesDO.getRightjinyongVAsg());
                sgjjDO.setSgjjJyvaos(salesDO.getLeftjinyongVAsg());
                sgjjService.updatesgjj(sgjjDO);
            } else if ("中用".equals(salesDO.getRecipelType())) {
                ZyDO zyDO = new ZyDO();
                zyDO.setPtometryNumber(salesDO.getPtometryNumber());
                zyDO.setZyPrismod(salesDO.getRightsanlingjingzy());
                zyDO.setZyPrismos(salesDO.getLeftsanlingjingzy());
                zyDO.setZyJdod(salesDO.getRightjidizy());
                zyDO.setZyJdos(salesDO.getLeftjidizy());
                zyDO.setZyZytjod(salesDO.getRightyuanyongtjzy());
                zyDO.setZyZytjos(salesDO.getLeftyuanyongtjzy());
                zyDO.setZyTgod(salesDO.getRighttonggaozy());
                zyDO.setZyTgos(salesDO.getLefttonggaozy());
                zyDO.setZyVaod(salesDO.getRightyuanyongVAzy());
                zyDO.setZyVaos(salesDO.getLeftyuanyongVAzy());
                zyService.updatezy(zyDO);
            } else if ("隐形".equals(salesDO.getRecipelType())) {
                RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
                rxjmjcjDO.setPtometryNumber(salesDO.getPtometryNumber());
                rxjmjcjDO.setRxZjod(salesDO.getRightzhijingyx());
                rxjmjcjDO.setRxZjos(salesDO.getLeftzhijingyx());
                rxjmjcjDO.setRxVaod(salesDO.getRightYingXingVAyx());
                rxjmjcjDO.setRxVaos(salesDO.getLeftYingXingVAyx());
                rxjmjcjService.updaterxjmjcj(rxjmjcjDO);
            }else if ("角膜塑形镜VST".equals(salesDO.getRecipelType())){
                VstDO vstDO = new VstDO();
                vstDO.setPtometryNumber(salesDO.getPtometryNumber());
                vstDO.setVstSdbhod(salesDO.getRightVstSdjbh());
                vstDO.setVstSdbhos(salesDO.getLeftVstSdjbh());
                vstDO.setVstFkod(salesDO.getRightVstFK());
                vstDO.setVstFkos(salesDO.getLeftVstFK());
                vstDO.setVstQlbjod(salesDO.getRightVstQlbj());
                vstDO.setVstQlbjos(salesDO.getLeftVstQlbj());
                vstDO.setVstAcod(salesDO.getRightVstAC());
                vstDO.setVstAcos(salesDO.getLeftVstAC());
                vstDO.setVstJfod(salesDO.getRightVstJF());
                vstDO.setVstJfos(salesDO.getLeftVstJF());
                vstDO.setVstDiaod(salesDO.getRightVstDIA());
                vstDO.setVstDiaos(salesDO.getLeftVstDIA());
                vstDO.setVstBcod(salesDO.getRightVstBC());
                vstDO.setVstBcos(salesDO.getLeftVstBC());
                vstDO.setVstCpclyod(salesDO.getRightVstCPCLY());
                vstDO.setVstCpclyod(salesDO.getLeftVstCPCLY());
                vstDO.setVstEod(salesDO.getRightVstE());
                vstDO.setVstEos(salesDO.getLeftVstE());
                vstDO.setVstVaod(salesDO.getRightVstVA());
                vstDO.setVstVaos(salesDO.getLeftVstVA());
                vstService.updatevst(vstDO);
            } else if ("角膜塑形镜CRT".equals(salesDO.getRecipelType())){
                CrtDO crtDO = new CrtDO();
                crtDO.setPtometryNumber(salesDO.getPtometryNumber());
                crtDO.setCrtSdbhod(salesDO.getRightSdjbhcrt());
                crtDO.setCrtSdbhos(salesDO.getLeftSdjbhcrt());
                crtDO.setCtrBcod(salesDO.getRightBCcrt());
                crtDO.setCrtBcos(salesDO.getLeftBCcrt());
                crtDO.setCrtRzdod(salesDO.getRightRZDcrt());
                crtDO.setCrtRzdos(salesDO.getLeftRZDcrt());
                crtDO.setCrtLzaod(salesDO.getRightLZAcrt());
                crtDO.setCrtLzaos(salesDO.getLeftLZAcrt());
                crtDO.setCrtRzd2od(salesDO.getRightRZD2crt());
                crtDO.setCrtRzd2os(salesDO.getLeftRZD2crt());
                crtDO.setCrtLza2od(salesDO.getRightLZA2crt());
                crtDO.setCrtLza2os(salesDO.getLeftLZA2crt());
                crtDO.setCrtJfod(salesDO.getRightJFcrt());
                crtDO.setCrtJfos(salesDO.getLeftJFcrt());
                crtDO.setCrtDiaod(salesDO.getRightDIAcrt());
                crtDO.setCrtDiaos(salesDO.getLeftDIAcrt());
                crtDO.setCrtVaod(salesDO.getRightVAcrt());
                crtDO.setCrtVaos(salesDO.getLeftVAcrt());
                crtService.updatecrt(crtDO);
            }
        }
        CostDO costDO = new CostDO();
        costDO.setIsSale(0L);
        costDO.setMemberNumber(salesDO.getMemberNumber());
        costDO.setSaleNumber(salesDO.getSaleNumber());
        costDO.setCostType(0L);
        costDO.setCostMoney(salesDO.getAmountMoney());
        costDO.setOriginalPrice(salesDO.getPrimeMoney());
        costDO.setSaleName(salesDO.getSaleName());
        costDO.setIsSale(0L);
        costDO.setCreateTime(new Date());
        costDO.setType("配镜单");
        costDO.setStoreName(ShiroUtils.getUser().getStore());
        costDO.setStoreNum(ShiroUtils.getUser().getStore());
        costService.save(costDO);
        salesDO.setPeijingTime(new Date());
        salesDO.setSaleType("0");
        if (null != salesDO.getGoodsNum()){
            String goodsCode = salesDO.getGoodsCode();
            String storeDesc = salesDO.getStoreDescribe();
            String[] goodsStr = goodsCode.split(",");
            String[] goodsDescribe = storeDesc.split(",");
            String[] goodsCount = salesDO.getStoreCount().split(",");
            String companyId = "";
            PositionDO positionDO = null;
            if (null != ShiroUtils.getUser().getCompanyId()) {
                companyId = ShiroUtils.getUser().getCompanyId();
                Map<String,Object> map = new HashMap<>();
                map.put("companyId", companyId);
                positionDO = stockService.findPosition(map);
            }
            for (int e=0;e<goodsDescribe.length;e++){
                if (!"镜片".equals(goodsDescribe[e]) && !"隐形".equals(goodsDescribe[e]) && !"自架".equals(goodsDescribe[e])
                        && !"自片".equals(goodsDescribe[e]) && !"赠品".equals(goodsDescribe[e])){
                    StockDO stockDOs = new StockDO();
                    if (null != positionDO){
                        stockDOs.setPositionId(String.valueOf(positionDO.getPositionId()));
                    } else {
                        stockDOs.setPositionId("");
                    }
                    stockDOs.setGoodsCode(goodsStr[e]);
                    StockDO stockDO = stockService.getProduceCode(stockDOs);
                    Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                    Long count = countGoods - Long.valueOf(goodsCount[e]);
                    stockDO.setGoodsCount(String.valueOf(count));
                    stockService.updateGoodsCount(stockDO);
                }
            }
        }
        WorkRecoedDO workRecoedDO = new WorkRecoedDO();
        workRecoedDO.setUserName(ShiroUtils.getUser().getUsername());
        workRecoedDO.setType("销售");
        workRecoedDO.setDateTime(new Date());
        logStatusService.saveRecord(workRecoedDO);
        if (salesService.save(salesDO) > 0) {
            //this.editsetle(salesDO,model);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 邮寄信息
     */
    @GetMapping("/youji/{cardNumber}")
    @RequiresPermissions("information:store:youji")
    String youji(@PathVariable("cardNumber") String cardNumber, Model model) {
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("男");
        } else {
            memberDO.setSexx("女");
        }
        model.addAttribute("memberDO", memberDO);
        return "storeSales/youji";
    }

    /**
     * 套餐
     */
    @GetMapping("/taocan")
    @RequiresPermissions("information:store:taocan")
    String taocan(Model model) {
        return "storeSales/taocan";
    }

    /**
     * 查询套餐
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taocanlist")
    @RequiresPermissions("information:store:taocan")
    public PageUtils taocanlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String storeNum = ShiroUtils.getUser().getStoreNum();
        query.put("storeNum",storeNum);
//        query.put("packageType",params.get("packageType"));
        List<PackageDO> packageDOList = packageService.list(query);
        if (null != packageDOList && packageDOList.size() > 0) {
            for (PackageDO packageDO : packageDOList) {
                if (currentTime.compareTo(packageDO.getExpiryDate()) > 0) {
                    packageDO.setLose(0L);
                } else {
                    packageDO.setLose(1L);
                }
                packageDO.setPackageDate(simpleDateFormat.format(packageDO.getPackageTime()));
                packageDO.setEffectiveTime(simpleDateFormat.format(packageDO.getEffectiveDate()));
                packageDO.setExpiryTime(simpleDateFormat.format(packageDO.getExpiryDate()));
            }
        }
        int total = packageService.count(query);
        PageUtils pageUtils = new PageUtils(packageDOList, total);
        return pageUtils;
    }

    /**
     * 套餐选择
     */
    @GetMapping("/taocanxz/{checkDate}/{retailCountPrice}/{check_val}")
    @RequiresPermissions("information:store:taocanxz")
    String taocanxz(@PathVariable("checkDate") String checkDate,@PathVariable("retailCountPrice") String retailCountPrice,@PathVariable("check_val") String check_val, Model model) {
        model.addAttribute("checkVal", checkDate);
        model.addAttribute("retailCountPrice",retailCountPrice);
        return "storeSales/taocanxz";
    }

    /**
     * 查询套餐选择
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taocanxzlist")
    @RequiresPermissions("information:store:taocanxz")
    public PageUtils taocanxzlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        query.put("goodsCode", params.get("checkVal"));
        params.put("retailCountPrice",params.get("retailCountPrice"));
//        List<PackageInfoDO> packageInfoDOList = packageInfoService.list(query);
//        int total = packageInfoService.count(query);
        String storeNum = ShiroUtils.getUser().getStoreNum();
        query.put("storeNum",storeNum);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        String departNumber = ShiroUtils.getUser().getStoreNum();
        List<PackageDO> packageDOList = packageService.list(query);
        if (null != packageDOList){
            for (PackageDO packageDO : packageDOList){
                if (currentTime.compareTo(packageDO.getExpiryDate()) > 0) {
                    packageDO.setLose(0L);
                } else {
                    packageDO.setLose(1L);
                }
                packageDO.setPackageDate(simpleDateFormat.format(packageDO.getPackageTime()));
                packageDO.setEffectiveTime(simpleDateFormat.format(packageDO.getEffectiveDate()));
                packageDO.setExpiryTime(simpleDateFormat.format(packageDO.getExpiryDate()));
            }
        }
        int total = packageService.count(query);
        PageUtils pageUtils = new PageUtils(packageDOList, total);
        return pageUtils;
    }

    /**
     * 套餐详情
     * @param packageId
     * @param model
     * @return
     */
    @GetMapping("/taocanxzdetail/{packageId}")
    @RequiresPermissions("information:store:taocanxzdetail")
    String detail(@PathVariable("packageId") String packageId,Model model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PackageDO packageDO = packageService.getPackageInfoId(packageId);
        packageDO.setPackageDate(simpleDateFormat.format(packageDO.getPackageTime()));
        packageDO.setEffectiveTime(simpleDateFormat.format(packageDO.getEffectiveDate()));
        packageDO.setExpiryTime(simpleDateFormat.format(packageDO.getExpiryDate()));
        model.addAttribute("package",packageDO);
        PackageInfoDO packageInfoDO = packageInfoService.findSelectPackId(packageDO.getPackageId());
        List<Map<String,Object>> packList = new ArrayList<>();
        if (null != packageInfoDO.getGoodsType()){
            String[] goodsType = packageInfoDO.getGoodsType().split(",");
            for (int i=0;i<goodsType.length;i++){
                Map<String,Object> map = new HashMap<>();
                map.put("goodsType",goodsType[i]);
                String[] goosName = packageInfoDO.getGoodsName().split(",");
                map.put("goodsName",goosName[i]);
                String[] orginalStart = packageInfoDO.getOriginalStartPrice().split(",");
                String[] orginalEnd = packageInfoDO.getOriginalEndPrice().split(",");
                map.put("originalStartPrice",orginalStart[i]);
                map.put("originalEndPrice",orginalEnd[i]);
                if (null != packageInfoDO.getPackageStartPrice()){
                    String[] packageStart = packageInfoDO.getPackageStartPrice().split(",");
                    map.put("packageStartPrice",packageStart[i]);
                }
                if (null != packageInfoDO.getPackageEndPrice()){
                    String[] packageEnd = packageInfoDO.getPackageEndPrice().split(",");
                    map.put("packageEndPrice",packageEnd[i]);
                }

                String[] saleNumberStr = packageInfoDO.getSaleNumber().split(",");
                map.put("saleNumber",saleNumberStr[i]);
                if (null != packageInfoDO.getFullStartPrice()){
                    String[] fullStart = packageInfoDO.getFullStartPrice().split(",");
                    map.put("fullStartPrice",fullStart[i]);
                }
                if (null != packageInfoDO.getFullEndPrice()){
                    String[] fullEnd = packageInfoDO.getFullEndPrice().split(",");
                    map.put("fullEndPrice",fullEnd[i]);
                }
                if (null != packageInfoDO.getPreferentialWay()){
                    String[] preferWay = packageInfoDO.getPreferentialWay().split(",");
                    map.put("preferentialWay",preferWay[i]);
                }
                if (null != packageInfoDO.getUnitPrice()){
                    String[] unitPriceStr = packageInfoDO.getUnitPrice().split(",");
                    if (unitPriceStr.length > 0){
                        map.put("unitPrice",unitPriceStr[i]);
                    } else {
                        map.put("unitPrice","");
                    }
                }
                if (null != packageInfoDO.getSpecialPrice()){
                    try {
                        String[] specialPriceStr = packageInfoDO.getSpecialPrice().split(",");
                        if (specialPriceStr.length > 0){
                            map.put("specialPrice",specialPriceStr[i]);
                        } else {
                            map.put("specialPrice","");
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        map.put("specialPrice","");
                    }
                }
                if (null != packageInfoDO.getPreferentialPrice()){
                    try {
                        String[] preferentialPriceStr = packageInfoDO.getPreferentialPrice().split(",");
                        if (preferentialPriceStr.length >0){
                            if (null != preferentialPriceStr[i]){
                                map.put("preferentialPrice",preferentialPriceStr[i]);
                            } else {
                                map.put("preferentialPrice","");
                            }
                        }
                        else{
                            map.put("preferentialPrice","");
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        map.put("preferentialPrice","");
                    }
                }
                if (null != packageInfoDO.getPreferentialRebate()){
                    try {
                        String[] preferentialRebateStr = packageInfoDO.getPreferentialRebate().split(",");
                        if (preferentialRebateStr.length > 0){
                            map.put("preferentialRebate",preferentialRebateStr[i]);
                        } else {
                            map.put("preferentialRebate","");
                        }
                    }catch (ArrayIndexOutOfBoundsException e) {
                        map.put("preferentialRebate","");
                    }
                }
                packList.add(map);
            }
            model.addAttribute("packList",packList);
        } else {
            model.addAttribute("packageInfoDO","");
        }

        return "storeSales/detail";
    }

    /**
     * 员工打折权限
     */
    @GetMapping("/getDiscount")
    @RequiresPermissions("information:store:getDiscount")
    String getDiscount(Model model) {
        return "storeSales/discount";
    }


    @ResponseBody
    @PostMapping("/saveDiscount")
    @RequiresPermissions("information:store:getDiscount")
    public R saveDiscount(String saleAccount){
        //String userName = ShiroUtils.getUser().getUsername();
        if (!saleAccount.equals("001")){
            return R.error("该员工没有打折权限");
        }
        return R.ok();
    }

    /**
     * 镜架
     */
    @GetMapping("/jingjia")
    @RequiresPermissions("information:store:jingjia")
    String jingjia(Model model) {
        return "storeSales/jingjia";
    }

    /**
     * 查询镜架
     *
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjialist")
    @RequiresPermissions("information:store:jingjia")
    public PageUtils jingjialist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
//        List<ProducaDO> producaDOList = producaService.listmateria(query);
//        int total = producaService.countmateria(query);
        //query.put("goodsType","镜架");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
//        query.put("goodsType","1");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("镜架".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> stockDOList = stockService.listJiajia(query);
        int total = stockService.countJiajia(query);
        PageUtils pageUtils = new PageUtils(stockDOList, total);
        return pageUtils;
    }

    /**
     * 镜片
     */
    @GetMapping("/jingpian/{rightYuanYongZJ}/{rightYuanYongQJ}/{leftYuanYongQJ}/{leftYuanYongZJ}/{str}")
    @RequiresPermissions("information:store:jingpian")
    String jingpian(@PathVariable("rightYuanYongZJ") String rightYuanYongZJ, @PathVariable("rightYuanYongQJ") String rightYuanYongQJ, @PathVariable("leftYuanYongQJ") String leftYuanYongQJ, @PathVariable("leftYuanYongZJ") String leftYuanYongZJ, @PathVariable("str") String str, Model model) {
        model.addAttribute("rightYuanYongQJ", rightYuanYongQJ);
        model.addAttribute("rightYuanYongZJ", rightYuanYongZJ);
        model.addAttribute("leftYuanYongQJ", leftYuanYongQJ);
        model.addAttribute("leftYuanYongZJ", leftYuanYongZJ);
        return "storeSales/jingpian";
    }

    /**
     * 查询镜片
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingpianlist")
    @RequiresPermissions("information:store:jingpian")
    public PageUtils jingpianlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        Map<String,Object> maps = new HashMap<>();
        if (null != params.get("goodsName") && !"".equals(params.get("goodsName"))){
            maps.put("goodsName",params.get("goodsName"));
        }
        if (null != params.get("goodsNum") && !"".equals(params.get("goodsNum"))){
            maps.put("goodsNum",params.get("goodsNum"));
        }
        if (null != params.get("retailPriceStart") && !"".equals(params.get("retailPriceStart"))){
            maps.put("retailPriceStart",params.get("retailPriceStart"));
        }
        if (null != params.get("retailPriceEnd") && !"".equals(params.get("retailPriceEnd"))){
            maps.put("retailPriceEnd",params.get("retailPriceEnd"));
        }
        PageUtils pageUtils = null;
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != departNumber) {
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findHegePosition(map);
            Long positionId = null;
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
            maps.put("positionId", positionId);
        }
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("镜片".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        maps.put("goodsType",goodsId);
        if (null != params.get("dzType")) {
            String dzType = params.get("dzType").toString();
            if ("0".equals(params.get("jingpianType").toString())) {
                if ("0".equals(params.get("rightYuanYongQJ"))){
                    maps.put("rightYuanYongQJ", "0.00");
                } else {
                    maps.put("rightYuanYongQJ", params.get("rightYuanYongQJ"));
                }
                if ("0".equals(params.get("rightYuanYongZJ"))){
                    maps.put("rightYuanYongZJ", "0.00");
                } else {
                    maps.put("rightYuanYongZJ", params.get("rightYuanYongZJ"));
                }
            } else if ("1".equals(params.get("jingpianType").toString())) {
                if ("0".equals(params.get("leftYuanYongQJ"))){
                    maps.put("leftYuanYongQJ", "0.00");
                }else {
                    maps.put("leftYuanYongQJ", params.get("leftYuanYongQJ"));
                }
                if ("0".equals(params.get("leftYuanYongZJ"))){
                    maps.put("leftYuanYongZJ", "0.00");
                } else {
                    maps.put("leftYuanYongZJ", params.get("leftYuanYongZJ"));
                }
            }
            if ("0".equals(dzType)) {
                List<StockDO> jpcpDOList = stockService.listJpcp(maps);
                if (null != jpcpDOList && jpcpDOList.size() > 0){
                    for (StockDO stockDO : jpcpDOList){
                        if ("0".equals(params.get("jingpianType").toString())) {
                            stockDO.setLeftRight("右");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("左");
                        }
                    }
                }
                int total = stockService.countJpcp(maps);
                pageUtils = new PageUtils(jpcpDOList, total);
            } else if ("1".equals(dzType)) {
                List<StockDO> newJpdzList = new ArrayList<>();
                List<StockDO> jpdzDOList = stockService.listJpdz(maps);
                if (null != jpdzDOList && jpdzDOList.size() > 0){
                    for (StockDO stockDO : jpdzDOList){
                        if ("0".equals(params.get("jingpianType").toString())) {
                            stockDO.setLeftRight("右");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("左");
                        }
                        if ("0.00".equals(stockDO.getSphUp())){
                            stockDO.setSphUp("+"+stockDO.getSphUp());
                        }
                        if ("0.00".equals(stockDO.getSphDown())){
                            stockDO.setSphDown("+"+stockDO.getSphDown());
                        }
                        if ("0.00".equals(stockDO.getCylUp())){
                            stockDO.setCylUp("+"+stockDO.getCylUp());
                        }
                        if ("0.00".equals(stockDO.getCylDown())){
                            stockDO.setCylDown("+"+stockDO.getCylDown());
                        }
                        Double stockSphUp=null;
                        Double stockSphDown=null;
                        Double stockCylUp=null;
                        Double stockCylDown=null;
                        Double rightqj = null;
                        Double rightzj = null;
                        Double leftqj = null;
                        Double leftzj = null;
                        if ("0".equals(params.get("jingpianType").toString())){
                            if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                rightqj = Math.abs(Double.parseDouble(params.get("rightYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                stockSphDown = Math.abs(Double.parseDouble(stockDO.getSphDown()));
                                if (rightqj > stockSphUp || rightqj < stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                rightqj = Double.parseDouble(params.get("rightYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (rightqj < stockSphUp || rightqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                rightqj = Math.abs(Double.parseDouble(params.get("rightYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                if (rightqj > stockSphUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                rightqj = Double.parseDouble(params.get("rightYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if(rightqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                            if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                rightzj = Math.abs(Double.parseDouble(params.get("rightYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                stockCylDown = Math.abs(Double.parseDouble(stockDO.getCylDown()));
                                if (rightzj > stockCylUp || rightzj < stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                rightzj = Double.parseDouble(params.get("rightYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if (rightzj < stockCylUp || rightqj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                rightzj = Math.abs(Double.parseDouble(params.get("rightYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                if (rightzj > stockCylUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                rightzj = Double.parseDouble(params.get("rightYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if(rightzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                leftqj = Math.abs(Double.parseDouble(params.get("leftYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                stockSphDown = Math.abs(Double.parseDouble(stockDO.getSphDown()));
                                if (leftqj > stockSphUp || leftqj < stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                leftqj = Double.parseDouble(params.get("leftYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (leftqj < stockSphUp || leftqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                leftqj = Math.abs(Double.parseDouble(params.get("leftYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                if (leftqj > stockSphUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                leftqj = Double.parseDouble(params.get("leftYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if(leftqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                            if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                leftzj = Math.abs(Double.parseDouble(params.get("leftYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                stockCylDown = Math.abs(Double.parseDouble(stockDO.getCylDown()));
                                if (leftzj > stockCylUp || leftzj < stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                leftzj = Double.parseDouble(params.get("leftYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if (leftzj < stockCylUp || leftzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                leftzj = Math.abs(Double.parseDouble(params.get("leftYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                if (leftzj > stockCylUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                leftzj = Double.parseDouble(params.get("leftYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if(leftzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                        }
                    }
                }
                for (StockDO stockDO : jpdzDOList){
                    if (!"1".equals(stockDO.getGoodsCode())){
                        newJpdzList.add(stockDO);
                    }
                }
                int total = 10000000;
                pageUtils = new PageUtils(newJpdzList, total);
            }
        } else {
            List<StockDO> jpcpDOList = stockService.listJpcp(maps);
            int total = stockService.countJpcp(maps);
            pageUtils = new PageUtils(jpcpDOList, total);
        }
        return pageUtils;

    }

    /**
     * 镜架配件
     */
    @GetMapping("/jingjiapj")
    @RequiresPermissions("information:store:jingjiapj")
    String jingjiapj(Model model) {
        return "storeSales/jingjiapj";
    }

    /**
     * 查询镜架配件
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjiapjlist")
    @RequiresPermissions("information:store:jingjiapj")
    public PageUtils jingjiapjlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        query.put("partsStyle", "框镜");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if(null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("配件".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> partsDOList = stockService.listJiajiapj(query);
        int total = stockService.countJiajiapj(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 太阳镜
     */
    @GetMapping("/taiyangjing")
    @RequiresPermissions("information:store:taiyangjing")
    String taiyangjing(Model model) {
        return "storeSales/taiyangjing";
    }

    /**
     * 查询太阳镜
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taiyangjinglist")
    @RequiresPermissions("information:store:taiyangjing")
    public PageUtils taiyangjinglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("太阳镜".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> tyjDOList = stockService.listTaiyj(query);
        int total = stockService.countTaiyj(query);
        PageUtils pageUtils = new PageUtils(tyjDOList, total);
        return pageUtils;
    }

    /**
     * 耗材
     */
    @GetMapping("/haocai")
    @RequiresPermissions("information:store:haocai")
    String haocai(Model model) {
        return "storeSales/haocai";
    }

    /**
     * 查询耗材
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/haocailist")
    @RequiresPermissions("information:store:haocai")
    public PageUtils haocailist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("耗材".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> hcDOList = stockService.listHaocai(query);
        int total = stockService.countHaocai(query);
        PageUtils pageUtils = new PageUtils(hcDOList, total);
        return pageUtils;
    }

    /**
     * 老花镜
     */
    @GetMapping("/laohuajing")
    @RequiresPermissions("information:store:laohuajing")
    String laohuajing(Model model) {
        return "storeSales/laohuajing";
    }

    /**
     * 查询老花镜
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/laohuajinglist")
    @RequiresPermissions("information:store:laohuajing")
    public PageUtils laohuajinglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);

            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("老花镜".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> oldlensDOList = stockService.listLaohj(query);
        int total = stockService.countLaohj(query);
        PageUtils pageUtils = new PageUtils(oldlensDOList, total);
        return pageUtils;
    }

    /**
     * 视光
     */
    @GetMapping("/shiguang")
    @RequiresPermissions("information:store:shiguang")
    String shiguang(Model model) {
        return "storeSales/shiguang";
    }

    /**
     * 查询视光
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/shiguanglist")
    @RequiresPermissions("information:store:shiguang")
    public PageUtils shiguanglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("视光".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> shiguangDOList = stockService.listShiguang(query);
        int total = stockService.countShiguang(query);
        PageUtils pageUtils = new PageUtils(shiguangDOList, total);
        return pageUtils;
    }

    /**
     * 护理液
     */
    @GetMapping("/huliye")
    @RequiresPermissions("information:store:huliye")
    String huliye(Model model) {
        return "storeSales/huliye";
    }

    /**
     * 查询护理液
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/huliyelist")
    @RequiresPermissions("information:store:huliye")
    public PageUtils huliyelist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("护理液".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> hlyDOList = stockService.listHuly(query);
        int total = stockService.countHuly(query);
        PageUtils pageUtils = new PageUtils(hlyDOList, total);
        return pageUtils;
    }

    /**
     * 配件
     */
    @GetMapping("/peijian")
    @RequiresPermissions("information:store:peijian")
    String peijian(Model model) {
        return "storeSales/peijian";
    }

    /**
     * 查询配件
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/peijianlist")
    @RequiresPermissions("information:store:peijian")
    public PageUtils peijianlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber) {
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }

        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("配件".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> partsDOList = stockService.listJiajiapj(query);
        int total = stockService.countJiajiapj(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 隐形
     */
    @GetMapping("/yinxing/{rightYuanYongZJ}/{rightYuanYongQJ}/{leftYuanYongQJ}/{leftYuanYongZJ}/{str}")
    @RequiresPermissions("information:store:yinxing")
    String yinxing(@PathVariable("rightYuanYongZJ") String rightYuanYongZJ, @PathVariable("rightYuanYongQJ") String rightYuanYongQJ, @PathVariable("leftYuanYongQJ") String leftYuanYongQJ, @PathVariable("leftYuanYongZJ") String leftYuanYongZJ, @PathVariable("str") String str, Model model) {
        model.addAttribute("rightYuanYongQJ", rightYuanYongQJ);
        model.addAttribute("rightYuanYongZJ", rightYuanYongZJ);
        model.addAttribute("leftYuanYongQJ", leftYuanYongQJ);
        model.addAttribute("leftYuanYongZJ", leftYuanYongZJ);
        return "storeSales/yinxing";
    }

    /**
     * 查询隐形
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxinglist")
    @RequiresPermissions("information:store:yinxing")
    public PageUtils yinxinglist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        Map<String,Object> maps = new HashMap<>();
        if (null != params.get("goodsName") && !"".equals(params.get("goodsName"))){
            maps.put("goodsName",params.get("goodsName"));
        }
        if (null != params.get("goodsNum") && !"".equals(params.get("goodsNum"))){
            maps.put("goodsNum",params.get("goodsNum"));
        }
        if (null != params.get("retailPriceStart") && !"".equals(params.get("retailPriceStart"))){
            maps.put("retailPriceStart",params.get("retailPriceStart"));
        }
        if (null != params.get("retailPriceEnd") && !"".equals(params.get("retailPriceEnd"))){
            maps.put("retailPriceEnd",params.get("retailPriceEnd"));
        }
        PageUtils pageUtils = null;
        Map<String,Object> mapstr = new HashMap<>();
        List<GoodsDO> goodsDOList = goodsService.list(mapstr);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("隐形".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        if (null != params.get("yxType")) {
            if ("0".equals(params.get("jingpianType").toString())) {
                maps.put("rightYuanYongQJ",params.get("rightYuanYongQJ"));
                maps.put("rightYuanYongZJ", params.get("rightYuanYongZJ"));
            } else if ("1".equals(params.get("jingpianType").toString())) {
                maps.put("leftYuanYongQJ", params.get("leftYuanYongQJ"));
                maps.put("leftYuanYongZJ", params.get("leftYuanYongZJ"));
            }
            if ("0".equals(params.get("yxType"))) {
                String departNumber = ShiroUtils.getUser().getStoreNum();
                Long positionId = null;
                if (null != departNumber){
                    Map<String, Object> map = new HashMap<>();
                    map.put("companyId", ShiroUtils.getUser().getCompanyId());
                    PositionDO positionDO = stockService.findHegePosition(map);
                    if (null != positionDO) {
                        positionId = positionDO.getPositionId();
                    }
                }
                query.put("positionId",positionId);
                query.put("goodsType",goodsId);
                List<StockDO> yxcpDOList = stockService.listYxcp(query);
                if (null != yxcpDOList && yxcpDOList.size() > 0){
                    for (StockDO stockDO : yxcpDOList){
                        if ("0".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("右");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("左");
                        }
                    }
                }
                int total = stockService.countYxcp(query);
                pageUtils = new PageUtils(yxcpDOList, total);
            } else if ("1".equals(params.get("yxType"))) {
                String departNumber = ShiroUtils.getUser().getStoreNum();
                if (null != departNumber){
                    Map<String, Object> map = new HashMap<>();
                    map.put("departNumber", departNumber);
                }
                maps.put("goodsType",goodsId);
//                if (params.get("rightYuanYongQJ").toString().contains("-")){
//                    maps.put("fuhao",Double.parseDouble("-"));
//                    maps.put("rightYuanYongQJF",Double.parseDouble(params.get("rightYuanYongQJ").toString().substring(0,1)));
//                } else if (params.get("rightYuanYongQJ").toString().contains("+")){
//                    maps.put("fuhao",Double.parseDouble("+"));
//                    maps.put("rightYuanYongQJZ", Double.parseDouble(params.get("rightYuanYongQJ").toString().substring(0,1)));
//                }
//                if (params.get("rightYuanYongZJ").toString().contains("-")){
//                    maps.put("fuhao",Double.parseDouble("-"));
//                    maps.put("rightYuanYongZJF", Double.parseDouble(params.get("rightYuanYongZJ").toString().substring(0,1)));
//                } else if (params.get("rightYuanYongZJ").toString().contains("+")){
//                    maps.put("fuhao",Double.parseDouble("+"));
//                    maps.put("rightYuanYongZJZ", Double.parseDouble(params.get("rightYuanYongZJ").toString().substring(0,1)));
//                }
//                if (params.get("leftYuanYongQJ").toString().contains("-")){
//                    maps.put("leftYuanYongQJF",params.get("leftYuanYongQJ"));
//                } else if (params.get("leftYuanYongQJ").toString().contains("+")){
//                    maps.put("leftYuanYongQJZ", params.get("leftYuanYongQJ"));
//                }
//                if (params.get("leftYuanYongZJ").toString().contains("-")){
//                    maps.put("leftYuanYongZJF", params.get("leftYuanYongZJ"));
//                } else if (params.get("leftYuanYongZJ").toString().contains("+")){
//                    maps.put("leftYuanYongZJZ", params.get("leftYuanYongZJ"));
//                }
                List<StockDO> yxdzDOList = stockService.listYxdz(maps);
                List<StockDO> newyxdzList = new ArrayList<>();
                if (null != yxdzDOList && yxdzDOList.size() > 0){
                    for (StockDO stockDO : yxdzDOList){
                        if ("0".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("右");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("左");
                        }
                        if ("0.00".equals(stockDO.getSphUp())){
                            stockDO.setSphUp("+"+stockDO.getSphUp());
                        }
                        if ("0.00".equals(stockDO.getSphDown())){
                            stockDO.setSphDown("+"+stockDO.getSphDown());
                        }
                        if ("0.00".equals(stockDO.getCylUp())){
                            stockDO.setCylUp("+"+stockDO.getCylUp());
                        }
                        if ("0.00".equals(stockDO.getCylDown())){
                            stockDO.setCylDown("+"+stockDO.getCylDown());
                        }
                        Double stockSphUp=null;
                        Double stockSphDown=null;
                        Double stockCylUp=null;
                        Double stockCylDown=null;
                        Double rightqj = null;
                        Double rightzj = null;
                        Double leftqj = null;
                        Double leftzj = null;
                        if ("0".equals(params.get("jingpianType").toString())){
                            if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                rightqj = Math.abs(Double.parseDouble(params.get("rightYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                stockSphDown = Math.abs(Double.parseDouble(stockDO.getSphDown()));
                                if (rightqj > stockSphUp || rightqj < stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                rightqj = Double.parseDouble(params.get("rightYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (rightqj < stockSphUp || rightqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                rightqj = Math.abs(Double.parseDouble(params.get("rightYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                if (rightqj > stockSphUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                rightqj = Double.parseDouble(params.get("rightYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if(rightqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                            if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                rightzj = Math.abs(Double.parseDouble(params.get("rightYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                stockCylDown = Math.abs(Double.parseDouble(stockDO.getCylDown()));
                                if (rightzj > stockCylUp || rightzj < stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                rightzj = Double.parseDouble(params.get("rightYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if (rightzj < stockCylUp || rightzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("rightYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                rightzj = Math.abs(Double.parseDouble(params.get("rightYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                if (rightzj > stockCylUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                rightzj = Double.parseDouble(params.get("rightYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if(rightzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                leftqj = Math.abs(Double.parseDouble(params.get("leftYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                stockSphDown = Math.abs(Double.parseDouble(stockDO.getSphDown()));
                                if (leftqj > stockSphUp || leftqj < stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                leftqj = Double.parseDouble(params.get("leftYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (leftqj < stockSphUp || leftqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongQJ").toString().contains("-") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                leftqj = Math.abs(Double.parseDouble(params.get("leftYuanYongQJ").toString()));
                                stockSphUp = Math.abs(Double.parseDouble(stockDO.getSphUp()));
                                if (leftqj > stockSphUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("-") && stockDO.getSphDown().contains("+")){
                                leftqj = Double.parseDouble(params.get("leftYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if(leftqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                            if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                leftzj = Math.abs(Double.parseDouble(params.get("leftYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                stockCylDown = Math.abs(Double.parseDouble(stockDO.getCylDown()));
                                if (leftzj > stockCylUp || leftzj < stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                leftzj = Double.parseDouble(params.get("leftYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if (leftzj < stockCylUp || leftzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("-")){
                                stockDO.setGoodsCode("1");
                            } else if (params.get("leftYuanYongZJ").toString().contains("-") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                leftzj = Math.abs(Double.parseDouble(params.get("leftYuanYongZJ").toString()));
                                stockCylUp = Math.abs(Double.parseDouble(stockDO.getCylUp()));
                                if (leftzj > stockCylUp){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("-") && stockDO.getCylDown().contains("+")){
                                leftzj = Double.parseDouble(params.get("leftYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if(leftzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            }
                        }

                    }
                }
                for (StockDO stockDO : yxdzDOList){
                    if (!"1".equals(stockDO.getGoodsCode())){
                        newyxdzList.add(stockDO);
                    }
                }
                //int total = stockService.countYxdz(maps);
                int total = 10000000;
                pageUtils = new PageUtils(newyxdzList, total);
            }
        } else {
            List<StockDO> yxcpDOList = stockService.listYxcp(query);
            if (null != yxcpDOList && yxcpDOList.size() > 0){
                for (StockDO stockDO : yxcpDOList){
                    if ("0".equals(params.get("jingpianType").toString())){
                        stockDO.setLeftRight("右");
                    } else if ("1".equals(params.get("jingpianType").toString())){
                        stockDO.setLeftRight("左");
                    }
                }
            }
            int total = yxcpService.count(query);
            pageUtils = new PageUtils(yxcpDOList, total);
        }
        return pageUtils;
    }

    /**
     * 隐形配件
     */
    @GetMapping("/yinxingpj")
    @RequiresPermissions("information:store:yinxingpj")
    String yinxingpj(Model model) {
        return "storeSales/yinxingpj";
    }

    /**
     * 查询隐形配件
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxingpjlist")
    @RequiresPermissions("information:store:yinxingpj")
    public PageUtils yinxingpjlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        query.put("partsStyle", "隐形");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("配件".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> partsDOList = stockService.listJiajiapj(query);
        int total = stockService.countJiajiapj(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 赠品
     */
    @GetMapping("/zengpin")
    @RequiresPermissions("information:store:zengpin")
    String zengpin(Model model) {
        return "storeSales/zengpin";
    }

    /**
     * 查询赠品
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zengpinlist")
    @RequiresPermissions("information:store:zengpin")
    public PageUtils zengpinlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String store = ShiroUtils.getUser().getStore();
        query.put("stores", store);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        map.put("departNumber", departNumber);
        PositionDO positionDO = stockService.findPosition(map);
        Long positionId = null;
        if (null != positionDO) {
            positionId = positionDO.getPositionId();
        }
        query.put("positionId", positionId);
        List<StockDO> giveawayDOList = stockService.listZengpin(query);
        int total = stockService.countZengpin(query);
        PageUtils pageUtils = new PageUtils(giveawayDOList, total);
        return pageUtils;
    }

    /**
     * 自片
     */
    @GetMapping("/zipian")
    @RequiresPermissions("information:store:zipian")
    String zipian(Model model) {
        return "storeSales/zipian";
    }

    /**
     * 查询自片
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zipianlist")
    @RequiresPermissions("information:store:zipian")
    public PageUtils zipianlist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ZipianDO> zipianDOList = salesService.findZpian(query);
        int total = salesService.countZpian(query);
        PageUtils pageUtils = new PageUtils(zipianDOList, total);
        return pageUtils;
    }

    /**
     * 自架
     */
    @GetMapping("/zijia")
    @RequiresPermissions("information:store:zijia")
    String zijia(Model model) {
        return "storeSales/zijia";
    }

    /**
     * 查询自架
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zijialist")
    @RequiresPermissions("information:store:zijia")
    public PageUtils zijialist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ZijiaDO> zijiaDOList = salesService.findZjia(query);
        int total = salesService.countZjia(query);
        PageUtils pageUtils = new PageUtils(zijiaDOList, total);
        return pageUtils;
    }

    /**
     * 查询会员
     */
    @ResponseBody
    @RequestMapping(value = "/select")
    public MemberDO remove(String cardMember) {
        MemberDO memberDO = memberService.getCardNumber(cardMember);
        if (null != memberDO) {
            if (memberDO.getSex() == 0) {
                memberDO.setSexx("男");
            } else {
                memberDO.setSexx("女");
            }
        }

        //model.addAttribute("memberDO",memberDO);
        return memberDO;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:store:edit")
    public R update(OptometryDO optometry) {
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:store:remove")
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
    @RequiresPermissions("information:store:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
