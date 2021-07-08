package com.shiguang.storeSales.controller;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.common.utils.*;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;
import com.shiguang.optometry.service.OptometryService;
import com.shiguang.optometry.service.ResultDiopterService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import com.shiguang.storeSales.domain.EyesWay;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.domain.ZijiaDO;
import com.shiguang.storeSales.domain.ZipianDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<ProcessAskDO> proList = optometryService.processlist(map);
        model.addAttribute("proList", proList);
        List<EyesWay> eyesWayList = salesService.findWay(map);
        model.addAttribute("eyesWayList",eyesWayList);
        List<AdditionalDO> addlist = additionalService.list(map);
        model.addAttribute("addlist", addlist);
        UserDO userDO = ShiroUtils.getUser();
        String storeName = userDO.getStore();
        model.addAttribute("storeName", storeName);
        String saleName = ShiroUtils.getUser().getName();
        model.addAttribute("saleName",saleName);
        String store = ShiroUtils.getUser().getStore();
        map.put("stores",store);
        List<GiveawayDO> giveawayDOList = giveawayService.list(map);
        model.addAttribute("giveawayDOList",giveawayDOList);
        return "storeSales/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:store:add")
    public R save(SalesDO salesDO) {
        if (null == salesDO.getIsJp() || null == salesDO.getIsJj()){
            salesDO.setIsJp(0L);
            salesDO.setIsJj("无");
        }
        if ("镜架".equals(salesDO.getStoreDescribe())
                || "镜片".equals(salesDO.getStoreDescribe())
                || "太阳镜".equals(salesDO.getStoreDescribe())){
            if (salesDO.getIsJp() < 2 && "无".equals(salesDO.getIsJj())) {
                return R.error("镜片数量不足（框镜销售至少包含 镜架*1 镜片*2）！");
            }
        }
        Long saleNumber =  GuuidUtil.getUUID();
        salesDO.setSaleNumber("X"+saleNumber);
        if(null != salesDO){
            if (null != salesDO.getAdditionalCost()){
                salesDO.setAdditionalCost(salesDO.getAdditionalCost().substring(0,salesDO.getAdditionalCost().length()-1));
            }
            if (null != salesDO.getGiveName()){
                salesDO.setGiveName(salesDO.getGiveName().substring(0,salesDO.getGiveName().length()-1));
            }
            if (null != salesDO.getProcessAsk()){
                salesDO.setProcessAsk(salesDO.getProcessAsk().substring(0,salesDO.getProcessAsk().length()-1));
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
        if (salesService.save(salesDO) > 0){
            //this.editsetle(salesDO,model);
            return R.ok();
        }
        return R.error();
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
        List<ProducaDO> producaDOList = producaService.listmateria(query);
        int total = producaService.countmateria(query);
        PageUtils pageUtils = new PageUtils(producaDOList, total);
        return pageUtils;
    }

    /**
     * 镜片
     */
    @GetMapping("/jingpian")
    @RequiresPermissions("information:store:jingpian")
    String jingpian(Model model) {
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
        PageUtils pageUtils = null;
        if (null != params.get("dzType")) {
            String dzType = params.get("dzType").toString();
            if ("0".equals(dzType)) {
                List<JpcpDO> jpcpDOList = jpcpService.listCp(query);
                int total = jpcpService.countCp(query);
                pageUtils = new PageUtils(jpcpDOList, total);
            } else if ("1".equals(dzType)) {
                List<JpdzDO> jpdzDOList = jpdzService.listDz(query);
                int total = jpdzService.countDz(query);
                pageUtils = new PageUtils(jpdzDOList, total);
            }
        } else {
            List<JpcpDO> jpcpDOList = jpcpService.listCp(query);
            int total = jpcpService.countCp(query);
            pageUtils = new PageUtils(jpcpDOList, total);
        }
        return pageUtils;

    }

    /**
     * 镜架配件
     */
    @GetMapping("/jingjiapj")
    @RequiresPermissions("information:store:jingjiapj")
    String jingjiapj(Model model){
        return "storeSales/jingjiapj";
    }

    /**
     * 查询镜架配件
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/jingjiapjlist")
    @RequiresPermissions("information:store:jingjiapj")
    public PageUtils jingjiapjlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("partsStyle","框镜");
        List<PartsDO> partsDOList = partsService.list(query);
        int total = partsService.count(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 太阳镜
     */
    @GetMapping("/taiyangjing")
    @RequiresPermissions("information:store:taiyangjing")
    String taiyangjing(Model model){
        return "storeSales/taiyangjing";
    }

    /**
     * 查询太阳镜
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/taiyangjinglist")
    @RequiresPermissions("information:store:taiyangjing")
    public PageUtils taiyangjinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<TyjDO> tyjDOList = tyjService.list(query);
        int total = tyjService.count(query);
        PageUtils pageUtils = new PageUtils(tyjDOList, total);
        return pageUtils;
    }

    /**
     * 耗材
     */
    @GetMapping("/haocai")
    @RequiresPermissions("information:store:haocai")
    String haocai(Model model){
        return "storeSales/haocai";
    }

    /**
     * 查询耗材
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/haocailist")
    @RequiresPermissions("information:store:haocai")
    public PageUtils haocailist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<HcDO> hcDOList = hcService.list(query);
        int total = hcService.count(query);
        PageUtils pageUtils = new PageUtils(hcDOList, total);
        return pageUtils;
    }

    /**
     * 老花镜
     */
    @GetMapping("/laohuajing")
    @RequiresPermissions("information:store:laohuajing")
    String laohuajing(Model model){
        return "storeSales/laohuajing";
    }

    /**
     * 查询老花镜
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/laohuajinglist")
    @RequiresPermissions("information:store:laohuajing")
    public PageUtils laohuajinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<OldlensDO> oldlensDOList = oldlensService.list(query);
        int total = oldlensService.count(query);
        PageUtils pageUtils = new PageUtils(oldlensDOList, total);
        return pageUtils;
    }

    /**
     * 视光
     */
    @GetMapping("/shiguang")
    @RequiresPermissions("information:store:shiguang")
    String shiguang(Model model){
        return "storeSales/shiguang";
    }

    /**
     * 查询视光
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/shiguanglist")
    @RequiresPermissions("information:store:shiguang")
    public PageUtils shiguanglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ShiguangDO> shiguangDOList = shiguangService.list(query);
        int total = shiguangService.count(query);
        PageUtils pageUtils = new PageUtils(shiguangDOList, total);
        return pageUtils;
    }

    /**
     * 护理液
     */
    @GetMapping("/huliye")
    @RequiresPermissions("information:store:huliye")
    String huliye(Model model){
        return "storeSales/huliye";
    }

    /**
     * 查询护理液
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/huliyelist")
    @RequiresPermissions("information:store:huliye")
    public PageUtils huliyelist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<HlyDO> hlyDOList = hlyService.list(query);
        int total = hlyService.count(query);
        PageUtils pageUtils = new PageUtils(hlyDOList, total);
        return pageUtils;
    }

    /**
     * 配件
     */
    @GetMapping("/peijian")
    @RequiresPermissions("information:store:peijian")
    String peijian(Model model){
        return "storeSales/peijian";
    }

    /**
     * 查询配件
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/peijianlist")
    @RequiresPermissions("information:store:peijian")
    public PageUtils peijianlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<PartsDO> partsDOList = partsService.list(query);
        int total = partsService.count(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 隐形
     */
    @GetMapping("/yinxing")
    @RequiresPermissions("information:store:yinxing")
    String yinxing(Model model){
        return "storeSales/yinxing";
    }

    /**
     * 查询隐形
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxinglist")
    @RequiresPermissions("information:store:yinxing")
    public PageUtils yinxinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        PageUtils pageUtils = null;
        if (null != params.get("yxType")){
            if ("0".equals(params.get("yxType"))){
                List<YxcpDO> yxcpDOList = yxcpService.list(query);
                int total = yxcpService.count(query);
                pageUtils = new PageUtils(yxcpDOList, total);
            } else if ("1".equals(params.get("yxType"))){
                List<YxdzDO> yxdzDOList = yxdzService.listYxDz(query);
                int total = yxdzService.countYxDz(query);
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
    String yinxingpj(Model model){
        return "storeSales/yinxingpj";
    }

    /**
     * 查询配件
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/yinxingpjlist")
    @RequiresPermissions("information:store:yinxingpj")
    public PageUtils yinxingpjlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("partsStyle","隐形");
        List<PartsDO> partsDOList = partsService.list(query);
        int total = partsService.count(query);
        PageUtils pageUtils = new PageUtils(partsDOList, total);
        return pageUtils;
    }

    /**
     * 赠品
     */
    @GetMapping("/zengpin")
    @RequiresPermissions("information:store:zengpin")
    String zengpin(Model model){
        return "storeSales/zengpin";
    }

    /**
     * 查询赠品
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zengpinlist")
    @RequiresPermissions("information:store:zengpin")
    public PageUtils zengpinlist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        String store = ShiroUtils.getUser().getStore();
        query.put("stores",store);
        List<GiveawayDO> giveawayDOList = giveawayService.list(query);
        int total = giveawayService.count(query);
        PageUtils pageUtils = new PageUtils(giveawayDOList, total);
        return pageUtils;
    }

    /**
     * 自片
     */
    @GetMapping("/zipian")
    @RequiresPermissions("information:store:zipian")
    String zipian(Model model){
        return "storeSales/zipian";
    }

    /**
     * 查询自片
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zipianlist")
    @RequiresPermissions("information:store:zipian")
    public PageUtils zipianlist(@RequestParam Map<String, Object> params){
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
    String zijia(Model model){
        return "storeSales/zijia";
    }

    /**
     * 查询自架
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/zijialist")
    @RequiresPermissions("information:store:zijia")
    public PageUtils zijialist(@RequestParam Map<String, Object> params){
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
