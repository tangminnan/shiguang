package com.shiguang.storeSales.controller;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.integral.domain.IntegralDO;
import com.shiguang.integral.service.IntegralService;
import com.shiguang.jiancha.domain.*;
import com.shiguang.jiancha.service.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.domain.PackageInfoDO;
import com.shiguang.packageManager.service.PackageInfoService;
import com.shiguang.packageManager.service.PackageService;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxcpDO;
import com.shiguang.product.service.*;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.domain.WeiwaishujuDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.WeiwaiService;
import com.shiguang.stock.service.WeiwaishujuService;
import com.shiguang.storeCard.domain.CardDO;
import com.shiguang.storeCard.service.CardService;
import com.shiguang.storeSales.domain.*;
import com.shiguang.storeSales.service.InfoService;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import io.swagger.models.auth.In;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
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
    @Autowired
    private WeiwaishujuService weiwaishujuService;
    @Autowired
    private WeiwaiService weiwaiService;
    @Autowired
    private MfrsService mfrsService;
    @Autowired
    private CardService cardService;
    @Autowired
    private IntegralService integralService;
    @Autowired
    private InfoService infoService;

    @GetMapping()
    @RequiresPermissions("information:store:storeSales")
    String Optometry() {
        return "storeSales/storeSales";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:store:storeSales")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //??????????????????
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

    /**
     * ????????????
     * @param saleNumber
     * @param model
     * @return
     */
    @GetMapping("/train/{saleNumber}")
    @RequiresPermissions("information:store:train")
    String train(@PathVariable("saleNumber") String saleNumber, Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> map = new HashMap<>();
        map.put("saleNumber",saleNumber);
        List<InfoDO> infoDOList = infoService.list(map);
        for (InfoDO infoDO : infoDOList){
            infoDO.setTrainDate(simpleDateFormat.format(infoDO.getTrainTime()));
        }
        model.addAttribute("infoDOList",infoDOList);
        SalesDO salesDO = salesService.getSaleNumber(saleNumber);
        salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
        model.addAttribute("salesDO",salesDO);

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> map1 = new HashMap<String, String>();
        Map<String,String> map2 = new HashMap<String, String>();
        Map<String,String> map3 = new HashMap<String, String>();
        Map<String,String> map4 = new HashMap<String, String>();
        Map<String,String> map5 = new HashMap<String, String>();
        Map<String,String> map6 = new HashMap<String, String>();
        Map<String,String> map7 = new HashMap<String, String>();
        Map<String,String> map8 = new HashMap<String, String>();
        Map<String,String> map9 = new HashMap<String, String>();
        Map<String,String> map10 = new HashMap<String, String>();
        Map<String,String> map11 = new HashMap<String, String>();
        map1.put("id","1");
        map1.put("name","????????????");
        map3.put("id","3");
        map3.put("name","????????????");
        for (InfoDO infoDO : infoDOList){
            if (infoDO.getTrainStatus().equals("????????????")){
                map11.put("id","4");
                map11.put("name","????????????");
                list.add(map11);
                map2.put("id","2");
                map2.put("name","????????????");
                list.add(map2);
            }
        }

        map4.put("id","5");
        map4.put("name","????????????");
        map5.put("id","6");
        map5.put("name","????????????");
        map6.put("id","7");
        map6.put("name","???????????????");
        map7.put("id","8");
        map7.put("name","????????????");
        map8.put("id","9");
        map8.put("name","????????????");
        map9.put("id","10");
        map9.put("name","???????????????");
        map10.put("id","11");
        map10.put("name","????????????");
        list.add(map1);list.add(map3);list.add(map4);list.add(map5);
        list.add(map10);list.add(map9);list.add(map8);list.add(map7);list.add(map6);
        Collections.sort(list,new Comparator<Map<String,String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                // TODO Auto-generated method stub
                Integer name1 = Integer.valueOf(o1.get("id")) ;//name1?????????list????????????????????????
                Integer name2 = Integer.valueOf(o2.get("id")) ; //name1?????????list???????????????????????????name
                return name1.compareTo(name2);
            }
        });

        model.addAttribute("list",list);
        return "storeSales/train";
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
            memberDO.setSexx("???");
        } else {
            memberDO.setSexx("???");
        }
        model.addAttribute("memberDO", memberDO);
        //?????????
        Map<String,Object> mapphone = new HashMap<>();
        if (null != memberDO.getPhone1() && !"".equals(memberDO.getPhone1())){
            mapphone.put("phone1",memberDO.getPhone1());
        } else {
            mapphone.put("phone1",memberDO.getPhone2());
        }
        List<MemberDO> memberList = memberService.list(mapphone);
        List<CardDO> cardDOS = new ArrayList<>();
        for (MemberDO memberDO1 : memberList){
            CardDO cardDO = new CardDO();
            cardDO = cardService.getMemberNum(memberDO1.getCardNumber());
            if (null == cardDO){
                cardDO = new CardDO();
                cardDO.setCardNumber("");
                cardDO.setCardMoney("");
            } else {
                cardDO.setCardNumMoney(cardDO.getCardNumber() + "(?????????"+ cardDO.getCardMoney() + ")");
                cardDOS.add(cardDO);
            }

        }
        model.addAttribute("cardDOS",cardDOS);
        //?????????????????????????????????
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
        map.put("roleTypes2", 7);
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        List<UserDO> userDOList = userService.getRoleNumList(map);
        model.addAttribute("userDOList", userDOList);
        map.put("roleType1", 1);
        map.put("roleType2", 2);
        map.put("roleType3", 6);
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
        String saleName = ShiroUtils.getUser().getUsername();
        model.addAttribute("saleName", saleName);
        String storeNum = userDO.getStoreNum();
        model.addAttribute("storeNum",storeNum);
        String store = ShiroUtils.getUser().getStore();
        map.put("stores", store);
        List<GiveawayDO> giveawayDOList = giveawayService.list(map);
        model.addAttribute("giveawayDOList", giveawayDOList);
        //??????
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
        SimpleDateFormat sdfss = new SimpleDateFormat("yyyy-MM-dd");
        if (null != conclusionList) {
            for (Conclusion c : conclusionList) {
                //String ygtime = sdfs.format(c.getCreateTime());
                if (null != c.getCreateTime()){
                    c.setYanguangTime(sdfs.format(c.getCreateTime()));
                    c.setYanguangDate(sdfss.format(c.getCreateTime()));
                } else {
                    c.setYanguangTime(sdfs.format(new Date()));
                    c.setYanguangDate(sdfss.format(new Date()));
                }
                if (null == c.getYangsName() || "".equals(c.getYangsName())){
                    c.setYangsName(c.getYanguangName());
                }
                if ("1".equals(c.getChufangType())) {
                    c.setChufang("??????");
                } else if ("2".equals(c.getChufangType())) {
                    c.setChufang("??????");
                } else if ("3".equals(c.getChufangType())) {
                    c.setChufang("??????/??????");
                } else if ("4".equals(c.getChufangType())) {
                    c.setChufang("??????");
                } else if ("5".equals(c.getChufangType())) {
                    c.setChufang("??????");
                } else if ("6".equals(c.getChufangType())) {
                    c.setChufang("???????????????");
                } else if ("7".equals(c.getChufangType())) {
                    c.setChufang("????????????");
                } else if ("8".equals(c.getChufangType())) {
                    c.setChufang("???????????????VST");
                } else if ("9".equals(c.getChufangType())) {
                    c.setChufang("???????????????CRT");
                } else if ("10".equals(c.getChufangType())) {
                    c.setChufang("RGP");
                } else if ("11".equals(c.getChufangType())) {
                    c.setChufang("??????");
                }
            }
        }
        Long id=ShiroUtils.getUser().getUserId();
        UserDO userDOs =  userService.get(id);
        String newOld=userDOs.getNewOld();
        if("new".equals(newOld)){
            model.addAttribute("newOlds","?????????");
        }else if("old".equals(newOld)){
            model.addAttribute("newOlds","?????????");
        }
        model.addAttribute("newOld",newOld);
        return "storeSales/edit";
    }

    /**
     * ??????
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:store:add")
    public R save(SalesDO salesDO) {
        return salesService.saleSave(salesDO);
    }

    /**
     * ????????????
     */
    @GetMapping("/youji/{cardNumber}")
    @RequiresPermissions("information:store:youji")
    String youji(@PathVariable("cardNumber") String cardNumber, Model model) {
        MemberDO memberDO = memberService.getCardNumber(cardNumber);
        if (memberDO.getSex() == 0) {
            memberDO.setSexx("???");
        } else {
            memberDO.setSexx("???");
        }
        model.addAttribute("memberDO", memberDO);
        return "storeSales/youji";
    }

    /**
     * ??????
     */
    @GetMapping("/taocan")
    @RequiresPermissions("information:store:taocan")
    String taocan(Model model) {
        return "storeSales/taocan";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taocanlist")
    @RequiresPermissions("information:store:taocan")
    public PageUtils taocanlist(@RequestParam Map<String, Object> params) {
        //??????????????????
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
     * ????????????
     */
    @GetMapping("/taocanxz/{checkDate}/{retailCountPrice}/{check_val}")
    @RequiresPermissions("information:store:taocanxz")
    String taocanxz(@PathVariable("checkDate") String checkDate,@PathVariable("retailCountPrice") String retailCountPrice,@PathVariable("check_val") String check_val, Model model) {
        model.addAttribute("checkVal", checkDate);
        model.addAttribute("retailCountPrice",retailCountPrice);
        return "storeSales/taocanxz";
    }

    /**
     * ??????????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taocanxzlist")
    @RequiresPermissions("information:store:taocanxz")
    public PageUtils taocanxzlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        if (null != params.get("checkVal")){
            String[] goodscodestr = params.get("checkVal").toString().substring(0,params.get("checkVal").toString().length()-1).split(",");
            query.put("goodsCode", goodscodestr[0]);
        } else {
            query.put("goodsCode", params.get("checkVal"));
        }

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
     * ????????????
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
     * ??????????????????
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
            return R.error("???????????????????????????");
        }
        return R.ok();
    }

    /**
     * ??????
     */
    @GetMapping("/jingjia")
    @RequiresPermissions("information:store:jingjia")
    String jingjia(Model model) {
        return "storeSales/jingjia";
    }

    /**
     * ????????????
     *
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjialist")
    @RequiresPermissions("information:store:jingjia")
    public PageUtils jingjialist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
//        List<ProducaDO> producaDOList = producaService.listmateria(query);
//        int total = producaService.countmateria(query);
        //query.put("goodsType","??????");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        Long positionId = null;
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
//        query.put("goodsType","1");
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ??????
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
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingpianlist")
    @RequiresPermissions("information:store:jingpian")
    public PageUtils jingpianlist(@RequestParam Map<String, Object> params) {
        //??????????????????
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        if (null != departNumber) {
            map.put("departNumber", departNumber);
            if("3".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("positionId","7");
            }
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
            if ("??????".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        maps.put("goodsType",goodsId +"");
        if (null != params.get("dzType")) {
            String dzType = params.get("dzType").toString();
            if ("0".equals(params.get("jingpianType").toString())) {
                if ("0".equals(params.get("rightYuanYongQJ").toString().trim())){
                    maps.put("rightYuanYongQJ", "0.00");
                } else {
                    maps.put("rightYuanYongQJ", params.get("rightYuanYongQJ").toString().trim());
                }
                if ("0".equals(params.get("rightYuanYongZJ").toString().trim())){
                    maps.put("rightYuanYongZJ", "0.00");
                } else {
                    maps.put("rightYuanYongZJ", params.get("rightYuanYongZJ").toString().trim());
                }
            } else if ("1".equals(params.get("jingpianType").toString())) {
                if ("0".equals(params.get("leftYuanYongQJ").toString().trim())){
                    maps.put("leftYuanYongQJ", "0.00");
                }else {
                    maps.put("leftYuanYongQJ", params.get("leftYuanYongQJ").toString().trim());
                }
                if ("0".equals(params.get("leftYuanYongZJ").toString().trim())){
                    maps.put("leftYuanYongZJ", "0.00");
                } else {
                    maps.put("leftYuanYongZJ", params.get("leftYuanYongZJ").toString().trim());
                }
            }
            if ("0".equals(dzType)) {
                maps.put("limit",query.getLimit());
                maps.put("offset",query.getOffset());
                List<StockDO> jpcpDOList = stockService.listJpcp(maps);
                if (null != jpcpDOList && jpcpDOList.size() > 0){
                    for (StockDO stockDO : jpcpDOList){
                        if ("0".equals(params.get("jingpianType").toString())) {
                            stockDO.setLeftRight("???");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("???");
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
                            stockDO.setLeftRight("???");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("???");
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
                                if (rightqj < stockSphUp || rightqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                rightqj = Double.parseDouble(params.get("rightYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (rightqj > stockSphUp || rightqj < stockSphDown){
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
                                if (rightzj < stockCylUp || rightzj > stockCylDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("rightYuanYongZJ").toString().contains("+") && stockDO.getCylUp().contains("+") && stockDO.getCylDown().contains("+")){
                                rightzj = Double.parseDouble(params.get("rightYuanYongZJ").toString());
                                stockCylUp = Double.parseDouble(stockDO.getCylUp());
                                stockCylDown = Double.parseDouble(stockDO.getCylDown());
                                if (rightzj > stockCylUp || rightzj < stockCylDown){
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
                                if (leftqj < stockSphUp || leftqj > stockSphDown){
                                    stockDO.setGoodsCode("1");
                                }
                            } else if (params.get("leftYuanYongQJ").toString().contains("+") && stockDO.getSphUp().contains("+") && stockDO.getSphDown().contains("+")){
                                leftqj = Double.parseDouble(params.get("leftYuanYongQJ").toString());
                                stockSphUp = Double.parseDouble(stockDO.getSphUp());
                                stockSphDown = Double.parseDouble(stockDO.getSphDown());
                                if (leftqj > stockSphUp || leftqj < stockSphDown){
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
                pageUtils = new PageUtils(newJpdzList, newJpdzList.size());
            }
        } else {
            List<StockDO> jpcpDOList = stockService.listJpcp(maps);
            int total = stockService.countJpcp(maps);
            pageUtils = new PageUtils(jpcpDOList, total);
        }
        return pageUtils;

    }

    /**
     * ????????????
     */
    @GetMapping("/jingjiapj")
    @RequiresPermissions("information:store:jingjiapj")
    String jingjiapj(Model model) {
        return "storeSales/jingjiapj";
    }

    /**
     * ??????????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjiapjlist")
    @RequiresPermissions("information:store:jingjiapj")
    public PageUtils jingjiapjlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        query.put("partsStyle", "??????");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if(null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ?????????
     */
    @GetMapping("/taiyangjing")
    @RequiresPermissions("information:store:taiyangjing")
    String taiyangjing(Model model) {
        return "storeSales/taiyangjing";
    }

    /**
     * ???????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taiyangjinglist")
    @RequiresPermissions("information:store:taiyangjing")
    public PageUtils taiyangjinglist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("?????????".equals(goodsDO.getGoodsname())){
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
     * ??????
     */
    @GetMapping("/haocai")
    @RequiresPermissions("information:store:haocai")
    String haocai(Model model) {
        return "storeSales/haocai";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/haocailist")
    @RequiresPermissions("information:store:haocai")
    public PageUtils haocailist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ?????????
     */
    @GetMapping("/laohuajing")
    @RequiresPermissions("information:store:laohuajing")
    String laohuajing(Model model) {
        return "storeSales/laohuajing";
    }

    /**
     * ???????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/laohuajinglist")
    @RequiresPermissions("information:store:laohuajing")
    public PageUtils laohuajinglist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);

            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("?????????".equals(goodsDO.getGoodsname())){
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
     * ??????
     */
    @GetMapping("/shiguang")
    @RequiresPermissions("information:store:shiguang")
    String shiguang(Model model) {
        return "storeSales/shiguang";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/shiguanglist")
    @RequiresPermissions("information:store:shiguang")
    public PageUtils shiguanglist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ????????????
     */
    @GetMapping("/shiguangdz")
    @RequiresPermissions("information:store:shiguangdz")
    String shiguangdz(Model model) {
        return "storeSales/shiguangdz";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/shiguangdzlist")
    @RequiresPermissions("information:store:shiguangdz")
    public PageUtils shiguangdzlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("????????????".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        query.put("goodsType",goodsId);
        List<StockDO> shiguangdzDOList = stockService.listShiguangdz(query);
        int total = stockService.countShiguangdz(query);
        PageUtils pageUtils = new PageUtils(shiguangdzDOList, total);
        return pageUtils;
    }

    /**
     * ?????????
     */
    @GetMapping("/huliye")
    @RequiresPermissions("information:store:huliye")
    String huliye(Model model) {
        return "storeSales/huliye";
    }

    /**
     * ???????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/huliyelist")
    @RequiresPermissions("information:store:huliye")
    public PageUtils huliyelist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("?????????".equals(goodsDO.getGoodsname())){
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
     * ??????
     */
    @GetMapping("/peijian")
    @RequiresPermissions("information:store:peijian")
    String peijian(Model model) {
        return "storeSales/peijian";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/peijianlist")
    @RequiresPermissions("information:store:peijian")
    public PageUtils peijianlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
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
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ??????
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
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxinglist")
    @RequiresPermissions("information:store:yinxing")
    public PageUtils yinxinglist(@RequestParam Map<String, Object> params) {
        //??????????????????
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
            if ("??????".equals(goodsDO.getGoodsname())){
                goodsId = goodsDO.getGoodsid();
            }
        }
        if (null != params.get("yxType")) {
            if ("0".equals(params.get("jingpianType").toString())) {
                if("0".equals(params.get("rightYuanYongQJ").toString().trim())){
                    maps.put("rightYuanYongQJ","0.00");
                } else {
                    maps.put("rightYuanYongQJ",params.get("rightYuanYongQJ").toString().trim());
                }
               if ("0".equals(params.get("rightYuanYongZJ").toString().trim())){
                   maps.put("rightYuanYongZJ", "0.00");
               } else {
                   maps.put("rightYuanYongZJ", params.get("rightYuanYongZJ").toString().trim());
               }
            } else if ("1".equals(params.get("jingpianType").toString())) {
                if ("0".equals(params.get("leftYuanYongQJ").toString().trim())){
                    maps.put("leftYuanYongQJ", "0.00");
                } else {
                    maps.put("leftYuanYongQJ", params.get("leftYuanYongQJ").toString().trim());
                }
                if ("0".equals(params.get("leftYuanYongZJ").toString().trim())){
                    maps.put("leftYuanYongZJ", "0.00");
                } else {
                    maps.put("leftYuanYongZJ", params.get("leftYuanYongZJ").toString().trim());
                }

            }
            if ("0".equals(params.get("yxType"))) {
                String departNumber = ShiroUtils.getUser().getStoreNum();
                Long positionId = null;
                if (null != departNumber){
                    Map<String, Object> map = new HashMap<>();
                    map.put("companyId", ShiroUtils.getUser().getCompanyId());
                    map.put("departNumber",departNumber);
                    PositionDO positionDO = stockService.findPosition(map);
                    if (null != positionDO) {
                        positionId = positionDO.getPositionId();
                    }
                }
                maps.put("positionId",positionId);
                maps.put("goodsType",goodsId+"");
                List<StockDO> yxcpDOList = stockService.listYxcp(maps);
                if (null != yxcpDOList && yxcpDOList.size() > 0){
                    for (StockDO stockDO : yxcpDOList){
                        if ("0".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("???");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("???");
                        }
                    }
                }
                int total = stockService.countYxcp(maps);
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
                            stockDO.setLeftRight("???");
                        } else if ("1".equals(params.get("jingpianType").toString())){
                            stockDO.setLeftRight("???");
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
                pageUtils = new PageUtils(newyxdzList, newyxdzList.size());
            }
        } else {
            List<StockDO> yxcpDOList = stockService.listYxcp(query);
            if (null != yxcpDOList && yxcpDOList.size() > 0){
                for (StockDO stockDO : yxcpDOList){
                    if ("0".equals(params.get("jingpianType").toString())){
                        stockDO.setLeftRight("???");
                    } else if ("1".equals(params.get("jingpianType").toString())){
                        stockDO.setLeftRight("???");
                    }
                }
            }
            int total = yxcpService.count(query);
            pageUtils = new PageUtils(yxcpDOList, yxcpDOList.size());
        }
        return pageUtils;
    }

    /**
     * ????????????
     */
    @GetMapping("/yinxingpj")
    @RequiresPermissions("information:store:yinxingpj")
    String yinxingpj(Model model) {
        return "storeSales/yinxingpj";
    }

    /**
     * ??????????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxingpjlist")
    @RequiresPermissions("information:store:yinxingpj")
    public PageUtils yinxingpjlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        query.put("partsStyle", "??????");
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        Long positionId = null;
        if (null != departNumber){
            map.put("departNumber", departNumber);
            PositionDO positionDO = stockService.findPosition(map);
            if (null != positionDO) {
                positionId = positionDO.getPositionId();
            }
        }else {
            if ("1".equals(ShiroUtils.getUser().getCompanyId())){
                map.put("departNumber", "01");
                PositionDO positionDO = stockService.findPosition(map);
                if (null != positionDO) {
                    positionId = positionDO.getPositionId();
                }
            }
        }
        query.put("positionId", positionId);
        List<GoodsDO> goodsDOList = goodsService.list(map);
        Integer goodsId=null;
        for (GoodsDO goodsDO : goodsDOList){
            if ("??????".equals(goodsDO.getGoodsname())){
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
     * ??????
     */
    @GetMapping("/zengpin")
    @RequiresPermissions("information:store:zengpin")
    String zengpin(Model model) {
        return "storeSales/zengpin";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zengpinlist")
    @RequiresPermissions("information:store:zengpin")
    public PageUtils zengpinlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        String store = ShiroUtils.getUser().getStore();
        query.put("stores", store);
        String departNumber = ShiroUtils.getUser().getStoreNum();
        Map<String, Object> map = new HashMap<>();
        map.put("departNumber", departNumber);
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
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
     * ??????
     */
    @GetMapping("/zipian")
    @RequiresPermissions("information:store:zipian")
    String zipian(Model model) {
        return "storeSales/zipian";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zipianlist")
    @RequiresPermissions("information:store:zipian")
    public PageUtils zipianlist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        List<ZipianDO> zipianDOList = salesService.findZpian(query);
        int total = salesService.countZpian(query);
        PageUtils pageUtils = new PageUtils(zipianDOList, total);
        return pageUtils;
    }

    /**
     * ??????
     */
    @GetMapping("/zijia")
    @RequiresPermissions("information:store:zijia")
    String zijia(Model model) {
        return "storeSales/zijia";
    }

    /**
     * ????????????
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zijialist")
    @RequiresPermissions("information:store:zijia")
    public PageUtils zijialist(@RequestParam Map<String, Object> params) {
        //??????????????????
        Query query = new Query(params);
        List<ZijiaDO> zijiaDOList = salesService.findZjia(query);
        int total = salesService.countZjia(query);
        PageUtils pageUtils = new PageUtils(zijiaDOList, total);
        return pageUtils;
    }

    /**
     * ????????????
     */
    @ResponseBody
    @RequestMapping(value = "/select")
    public MemberDO remove(String cardMember) {
        MemberDO memberDO = memberService.getCardNumber(cardMember);
        if (null != memberDO) {
            if (memberDO.getSex() == 0) {
                memberDO.setSexx("???");
            } else {
                memberDO.setSexx("???");
            }
        }

        //model.addAttribute("memberDO",memberDO);
        return memberDO;
    }

    /**
     * ??????
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:store:edit")
    public R update(OptometryDO optometry) {
        optometryService.update(optometry);
        return R.ok();
    }

    /**
     * ??????
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
     * ??????
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:store:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        optometryService.batchRemove(ids);
        return R.ok();
    }
}
