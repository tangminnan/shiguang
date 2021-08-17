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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
        if (null == salesDO.getIsJp() || null == salesDO.getIsJj()) {
            salesDO.setIsJp(0L);
            salesDO.setIsJj("无");
        }
        if ("镜架".equals(salesDO.getStoreDescribe())
                || "镜片".equals(salesDO.getStoreDescribe())
                || "太阳镜".equals(salesDO.getStoreDescribe())) {
            if (salesDO.getIsJp() < 2 && "无".equals(salesDO.getIsJj())) {
                return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
            }
        }
        Long saleNumber = GuuidUtil.getUUID();
        salesDO.setSaleNumber("X" + saleNumber);
        if (null != salesDO) {
            if (null != salesDO.getAdditionalCost()) {
                salesDO.setAdditionalCost(salesDO.getAdditionalCost().substring(0, salesDO.getAdditionalCost().length() - 1));
            }
            if (null != salesDO.getGiveName()) {
                salesDO.setGiveName(salesDO.getGiveName().substring(0, salesDO.getGiveName().length() - 1));
            }
            if (null != salesDO.getProcessAsk()) {
                salesDO.setProcessAsk(salesDO.getProcessAsk().substring(0, salesDO.getProcessAsk().length() - 1));
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
        if ("2".equals(salesDO.getChufang())) {
            if (salesDO.getRecipelwlType() == 1) {
                KjjyDO kjjyDO = new KjjyDO();
                kjjyDO.setCardNumber(salesDO.getMemberNumber());
                kjjyDO.setKjjyPrescriptionType(salesDO.getRecipelType().toString());
                kjjyDO.setKjjyOptometryName(salesDO.getSaleName());
                kjjyDO.setKjjySphod(salesDO.getRightQJ());
                kjjyDO.setKjjySphos(salesDO.getLeftQJ());
                kjjyDO.setKjjyCylod(salesDO.getRightZJ());
                kjjyDO.setKjjyCylos(salesDO.getLeftZJ());
                kjjyDO.setKjjyAxialod(salesDO.getRightzhouxiang());
                kjjyDO.setKjjyAxialos(salesDO.getLeftzhouxiang());
                kjjyDO.setKjjyPrismod(salesDO.getRightsanlingjing());
                kjjyDO.setKjjyPrismos(salesDO.getLeftsanlingjing());
                kjjyDO.setKjjyJdod(salesDO.getRightjidi());
                kjjyDO.setKjjyJdos(salesDO.getLeftjidi());
                kjjyDO.setKjjyYytjod(salesDO.getRightyuanyongtj());
                kjjyDO.setKjjyYytjos(salesDO.getLeftyuanyongtj());
                kjjyDO.setKjjyTgod(salesDO.getRighttonggao());
                kjjyDO.setKjjyTgos(salesDO.getLefttonggao());
                kjjyDO.setKjjyVaod(salesDO.getRightyuanyongVA());
                kjjyDO.setKjjyVaos(salesDO.getLeftyuanyongVA());
                kjjyService.save(kjjyDO);
            } else if (salesDO.getRecipelwlType() == 2) {
                KjyyDO kjyyDO = new KjyyDO();
                kjyyDO.setCardNumber(salesDO.getMemberNumber());
                kjyyDO.setKjyyPrescriptionType(salesDO.getRecipelType().toString());
                kjyyDO.setKjyyOptometryName(salesDO.getSaleName());
                kjyyDO.setKjyySphod(salesDO.getRightQJ());
                kjyyDO.setKjyySphos(salesDO.getLeftQJ());
                kjyyDO.setKjyyCylod(salesDO.getRightZJ());
                kjyyDO.setKjyyCylos(salesDO.getLeftZJ());
                kjyyDO.setKjyyAxialod(salesDO.getRightzhouxiang());
                kjyyDO.setKjyyAxialos(salesDO.getLeftzhouxiang());
                kjyyDO.setKjyyPrismod(salesDO.getRightsanlingjing());
                kjyyDO.setKjyyPrismos(salesDO.getLeftsanlingjing());
                kjyyDO.setKjyyJdod(salesDO.getRightjidi());
                kjyyDO.setKjyyJdos(salesDO.getLeftjidi());
                kjyyDO.setKjyyYytjod(salesDO.getRightyuanyongtj());
                kjyyDO.setKjyyYytjos(salesDO.getLeftyuanyongtj());
                kjyyDO.setKjyyTgod(salesDO.getRighttonggao());
                kjyyDO.setKjyyTgos(salesDO.getLefttonggao());
                kjyyDO.setKjyyVaod(salesDO.getRightyuanyongVA());
                kjyyDO.setKjyyVaos(salesDO.getLeftyuanyongVA());
                kjyyService.save(kjyyDO);
            } else if (salesDO.getRecipelwlType() == 3) {
                SgjjDO sgjjDO = new SgjjDO();
                sgjjDO.setCardNumber(salesDO.getMemberNumber());
                sgjjDO.setSgjjPrescriptionType(salesDO.getRecipelType().toString());
                sgjjDO.setSgjjOptometryName(salesDO.getSaleName());
                sgjjDO.setSgjjSphod(salesDO.getRightQJ());
                sgjjDO.setSgjjSphos(salesDO.getLeftQJ());
                sgjjDO.setSgjjCylod(salesDO.getRightZJ());
                sgjjDO.setSgjjCylos(salesDO.getLeftZJ());
                sgjjDO.setSgjjAxialod(salesDO.getRightzhouxiang());
                sgjjDO.setSgjjAxialos(salesDO.getLeftzhouxiang());
                sgjjDO.setSgjjYytjod(salesDO.getRightyuanyongtj());
                sgjjDO.setSgjjYytjos(salesDO.getLeftyuanyongtj());
                sgjjDO.setSgjjTgod(salesDO.getRighttonggao());
                sgjjDO.setSgjjTgos(salesDO.getLefttonggao());
                sgjjDO.setSgjjYyvaod(salesDO.getRightyuanyongVA());
                sgjjDO.setSgjjYyvaos(salesDO.getLeftyuanyongVA());
                sgjjService.save(sgjjDO);
            } else if (salesDO.getRecipelwlType() == 4) {
                ZyDO zyDO = new ZyDO();
                zyDO.setCardNumber(salesDO.getMemberNumber());
                zyDO.setZyPrescriptionType(salesDO.getRecipelType().toString());
                zyDO.setZyOptometryName(salesDO.getSaleName());
                zyDO.setZySphod(salesDO.getRightQJ());
                zyDO.setZySphos(salesDO.getLeftQJ());
                zyDO.setZyCylod(salesDO.getRightZJ());
                zyDO.setZyCylos(salesDO.getLeftZJ());
                zyDO.setZyAxialod(salesDO.getRightzhouxiang());
                zyDO.setZyAxialos(salesDO.getLeftzhouxiang());
                zyDO.setZyPrismod(salesDO.getRightsanlingjing());
                zyDO.setZyPrismos(salesDO.getLeftsanlingjing());
                zyDO.setZyJdod(salesDO.getRightjidi());
                zyDO.setZyJdos(salesDO.getLeftjidi());
                zyDO.setZyZytjod(salesDO.getRightyuanyongtj());
                zyDO.setZyZytjos(salesDO.getLeftyuanyongtj());
                zyDO.setZyTgod(salesDO.getRighttonggao());
                zyDO.setZyTgos(salesDO.getLefttonggao());
                zyDO.setZyVaod(salesDO.getRightyuanyongVA());
                zyDO.setZyVaos(salesDO.getLeftyuanyongVA());
                zyService.save(zyDO);
            } else if (salesDO.getRecipelwlType() == 5) {
                RxjmjcjDO rxjmjcjDO = new RxjmjcjDO();
                rxjmjcjDO.setCardNumber(salesDO.getMemberNumber());
                rxjmjcjDO.setRxPrescriptionType(salesDO.getRecipelType().toString());
                rxjmjcjDO.setRxOptometryName(salesDO.getSaleName());
                rxjmjcjDO.setRxSphod(salesDO.getRightQJ());
                rxjmjcjDO.setRxSphos(salesDO.getLeftQJ());
                rxjmjcjDO.setRxCylod(salesDO.getRightZJ());
                rxjmjcjDO.setRxCylos(salesDO.getLeftZJ());
                rxjmjcjDO.setRxAxialod(salesDO.getRightzhouxiang());
                rxjmjcjDO.setRxAxialos(salesDO.getLeftzhouxiang());
                rxjmjcjDO.setRxZjod(salesDO.getRightZJ());
                rxjmjcjDO.setRxZjos(salesDO.getLeftZJ());
                rxjmjcjDO.setRxVaod(salesDO.getRightyuanyongVA());
                rxjmjcjDO.setRxVaos(salesDO.getLeftyuanyongVA());
                rxjmjcjService.save(rxjmjcjDO);
            } else if (salesDO.getRecipelwlType() == 7) {
                SjxlDO sjxlDO = new SjxlDO();
                sjxlDO.setCardNumber(salesDO.getMemberNumber());
                sjxlDO.setSjxlPrescriptionType(salesDO.getRecipelType().toString());
                sjxlDO.setSjxlOptometryName(salesDO.getSaleName());
                sjxlDO.setSjxlSphod(salesDO.getRightQJ());
                sjxlDO.setSjxlSphos(salesDO.getLeftQJ());
                sjxlDO.setSjxlCylod(salesDO.getRightZJ());
                sjxlDO.setSjxlCylos(salesDO.getLeftZJ());
                sjxlDO.setSjxlAxialod(salesDO.getRightzhouxiang());
                sjxlDO.setSjxlAxialos(salesDO.getLeftzhouxiang());
                sjxlDO.setSjxlJdod(salesDO.getRightjidi());
                sjxlDO.setSjxlJdos(salesDO.getLeftjidi());
                sjxlDO.setSjxlYytjod(salesDO.getRightyuanyongtj());
                sjxlDO.setSjxlYytjos(salesDO.getLeftyuanyongtj());
                sjxlDO.setSjxlYyvaod(salesDO.getRightyuanyongVA());
                sjxlDO.setSjxlYyvaos(salesDO.getLeftyuanyongVA());
                sjxlService.save(sjxlDO);
            } else if (salesDO.getRecipelwlType() == 10) {
                RgpDO rgpDO = new RgpDO();
                rgpDO.setCardNumber(salesDO.getMemberNumber());
                rgpDO.setRgpPrescriptionType(salesDO.getRecipelType().toString());
                rgpDO.setRgpOptometryName(salesDO.getSaleName());
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
                rgpService.save(rgpDO);
            } else if (salesDO.getRecipelwlType() == 11) {
                YaopinDO yaopinDO = new YaopinDO();
                yaopinDO.setCardNumber(salesDO.getMemberNumber());
                yaopinDO.setYpPrescriptionType(salesDO.getRecipelType().toString());
                yaopinDO.setYpOptometryName(salesDO.getSaleName());
                yaopinDO.setYpNr(salesDO.getContent());
                yaopinDO.setYpYm(salesDO.getYpName());
                yaopinService.save(yaopinDO);
            }
        }
        CostDO costDO = new CostDO();
        costDO.setIsSale(0L);
        costDO.setMemberNumber(salesDO.getMemberNumber());
        costDO.setSaleNumber(salesDO.getSaleNumber());
        costDO.setCostType(0L);
        costDO.setCostMoney(salesDO.getAmountMoney());
        costDO.setSaleName(salesDO.getSaleName());
        costDO.setIsSale(0L);
        costDO.setCreateTime(new Date());
        costDO.setType("配镜单");
        costService.save(costDO);
        salesDO.setPeijingTime(new Date());
        if (null != salesDO.getGoodsNum()){
            String goodsNum = salesDO.getGoodsNum();
            String storeDesc = salesDO.getStoreDescribe();
            String[] goodsStr = goodsNum.split(",");
            String[] goodsDescribe = storeDesc.split(",");
            for (int e=0;e<goodsDescribe.length;e++){
                if ("镜架".equals(goodsDescribe[e])){
                    StockDO stockDO = stockService.getGoodsNum(goodsStr[e]);
                    Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                    Long count = countGoods - 1;
                    stockDO.setGoodsCount(String.valueOf(count));
                    stockService.updateGoodsCount(stockDO);
                }
            }
        }
        LogStatusDO logStatusDO = new LogStatusDO();
        logStatusDO.setSaleNumber(salesDO.getSaleNumber());
        logStatusDO.setLogisticStatus("销售完成");
        logStatusService.save(logStatusDO);
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
    @GetMapping("/taocanxz/{checkDate}/{check_val}")
    @RequiresPermissions("information:store:taocanxz")
    String taocanxz(@PathVariable("checkDate") String checkDate,@PathVariable("check_val") String check_val, Model model) {
        model.addAttribute("checkVal", checkDate);
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
//        List<PackageInfoDO> packageInfoDOList = packageInfoService.list(query);
//        int total = packageInfoService.count(query);
        String storeNum = ShiroUtils.getUser().getStoreNum();
        query.put("storeNum",storeNum);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
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
                String[] packageStart = packageInfoDO.getPackageStartPrice().split(",");
                String[] packageEnd = packageInfoDO.getPackageEndPrice().split(",");
                map.put("packageStartPrice",packageStart[i]);
                map.put("packageEndPrice",packageEnd[i]);
                String[] saleNumberStr = packageInfoDO.getSaleNumber().split(",");
                map.put("saleNumber",saleNumberStr[i]);
                String[] fullStart = packageInfoDO.getFullStartPrice().split(",");
                String[] fullEnd = packageInfoDO.getFullEndPrice().split(",");
                map.put("fullStartPrice",fullStart[i]);
                map.put("fullEndPrice",fullEnd[i]);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        PageUtils pageUtils = null;
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != departNumber) {
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            String positionName = "";
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
            query.put("positionName", positionName);
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
                maps.put("rightYuanYongQJ", params.get("rightYuanYongQJ"));
                maps.put("rightYuanYongZJ", params.get("rightYuanYongZJ"));
            } else if ("1".equals(params.get("jingpianType").toString())) {
                maps.put("leftYuanYongQJ", params.get("leftYuanYongQJ"));
                maps.put("leftYuanYongZJ", params.get("leftYuanYongZJ"));
            }
            if ("0".equals(dzType)) {
                List<StockDO> jpcpDOList = stockService.listJpcp(maps);
                int total = stockService.countJpcp(query);
                pageUtils = new PageUtils(jpcpDOList, total);
            } else if ("1".equals(dzType)) {
                List<StockDO> jpdzDOList = stockService.listJpdz(maps);
                int total = stockService.countJpdz(query);
                pageUtils = new PageUtils(jpdzDOList, total);
            }
        } else {
            List<StockDO> jpcpDOList = stockService.listJpcp(maps);
            int total = stockService.countJpcp(query);
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
        String positionName = "";
        if(null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);

            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != departNumber) {
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }

        query.put("positionName", positionName);
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
    String yinxing(@PathVariable("rightYuanYongZJ") Double rightYuanYongZJ, @PathVariable("rightYuanYongQJ") Double rightYuanYongQJ, @PathVariable("leftYuanYongQJ") Double leftYuanYongQJ, @PathVariable("leftYuanYongZJ") Double leftYuanYongZJ, @PathVariable("str") String str, Model model) {
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
                query.put("rightYuanYongQJ", params.get("rightYuanYongQJ"));
                query.put("rightYuanYongZJ", params.get("rightYuanYongZJ"));
            } else if ("1".equals(params.get("jingpianType").toString())) {
                query.put("leftYuanYongQJ", params.get("leftYuanYongQJ"));
                query.put("leftYuanYongZJ", params.get("leftYuanYongZJ"));
            }
            if ("0".equals(params.get("yxType"))) {
                List<YxcpDO> yxcpDOList = yxcpService.list(query);
                int total = yxcpService.count(query);
                pageUtils = new PageUtils(yxcpDOList, total);
            } else if ("1".equals(params.get("yxType"))) {
                String departNumber = ShiroUtils.getUser().getStoreNum();
                String positionName = "";
                if (null != departNumber){
                    Map<String, Object> map = new HashMap<>();
                    map.put("departNumber", departNumber);
                    PositionDO positionDO = stockService.findPosition(map);
                    if (null != positionDO) {
                        positionName = positionDO.getPositionName();
                    }
                }
                query.put("positionName", positionName);
                query.put("goodsType",goodsId);
                List<StockDO> yxdzDOList = stockService.listYxdz(query);
                int total = yxdzService.count(query);
                pageUtils = new PageUtils(yxdzDOList, total);
            }
        } else {
            List<YxcpDO> yxcpDOList = yxcpService.list(query);
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
        String positionName = "";
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionName = positionDO.getPositionName();
            }
        }
        query.put("positionName", positionName);
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
        String positionName = "";
        if (null != positionDO) {
            positionName = positionDO.getPositionName();
        }
        query.put("positionName", positionName);
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
