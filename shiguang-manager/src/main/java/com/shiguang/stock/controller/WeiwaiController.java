package com.shiguang.stock.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.*;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.domain.WorkRecoedDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.JpdzDO;
import com.shiguang.product.domain.YxdzDO;
import com.shiguang.stock.domain.*;
import com.shiguang.stock.service.*;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.Socket;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 委外表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */

@Controller
@RequestMapping("/stock/weiwai")
public class WeiwaiController {
    @Autowired
    private WeiwaiService weiwaiService;
    @Autowired
    private WeiwaishujuService weiwaishujuService;
    @Autowired
    private DepartmentService departmentService;
    //配送
    @Autowired
    private LogStatusService statusService;
    //委外库存
    @Autowired
    private WeiwaikcService weiwaikcService;
    //仓位
    @Autowired
    private PositionService positionService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
	//库存
	@Autowired
	private StockService stockService;
    @Autowired
    UserService userService;

    @Autowired
    private StocklogService stocklogService;

    @GetMapping()
    @RequiresPermissions("stock:weiwai:weiwai")
    String Weiwai() {
        return "stock/weiwai/weiwai";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("stock:weiwai:weiwai")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyid=ShiroUtils.getUser().getCompanyId();
        if(companyid == null){
            String departNumber=ShiroUtils.getUser().getStoreNum();
            query.put("departNumber",departNumber);
        }else if (companyid != null){
            if ("3".equals(companyid)){

                query.put("companyid",null);
            }else {
                query.put("companyid",companyid);
            }
        }
        List<WeiwaiDO> weiwaiList = weiwaiService.list(query);
        int total = weiwaiService.count(query);
        PageUtils pageUtils = new PageUtils(weiwaiList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("stock:weiwai:add")
    String add(Model model) {
        //———生成单据编号————
        Long uuid = GuuidUtil.getUUID();
        String danjuNumber = "OUT" + uuid.toString();
        model.addAttribute("danjuNumber", danjuNumber);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String danjuDay = sdf.format(date);
        model.addAttribute("danjuDay", danjuDay);
        //———获取当前登录用户的名称————
        model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        if (companyId != null) {
            Integer companyid = Integer.valueOf(companyId);
            Map<String, Object> map = new HashMap<>();
            map.put("companyid", companyid);
            map.put("positionOrder", 2);
            DepartmentDO departmentDO = weiwaiService.phoneOrAddres(map);

            String departTel = departmentDO.getDepartTel();
            String departAddress = departmentDO.getDepartAddress();
            Long positionId = departmentDO.getPositionId();
            String positionName = departmentDO.getPositionName();
            model.addAttribute("departTel", departTel);
            model.addAttribute("departAddress", departAddress);
            model.addAttribute("positionId", positionId);
            model.addAttribute("positionName", positionName);
        } else if (companyId == null) {
            model.addAttribute("departTel", "");
            model.addAttribute("departAddress", "");
        }

        return "stock/weiwai/add";
    }

    //委外详情按钮跳转页面
    @GetMapping("/detial/{id}")
    @RequiresPermissions("stock:weiwai:detial")
    String detial(@PathVariable("id") Long id, Model model) {
        WeiwaiDO weiwai = weiwaiService.get(id);
        model.addAttribute("weiwai", weiwai);
        String eyeStyle = weiwai.getEyeStyle();
        if (eyeStyle.equals("3")) {
            model.addAttribute("eyeStyle", "框镜订做");
        } else if (eyeStyle.equals("4")) {
            model.addAttribute("eyeStyle", "隐形订做");
        }
//        String[] saleNumber = weiwai.getSaleNumber().split(",");
//        model.addAttribute("saleNumber", saleNumber);

//        String[] saleNumbers = weiwai.getSaleNumber().split(",");//配镜单号
//        String[] mirrorTimes = weiwai.getMirrorTime().split(",");//取镜时间
//        String[] goodsNames = weiwai.getGoodsName().split(",");//名称
//        String[] styles = weiwai.getStyle().split(",");//委外方式
//        String[] rls = weiwai.getRl().split(",");//镜片类型左右
//        String[] counts = weiwai.getCount().split(",");//数量
//        String[] sphs = weiwai.getSph().split(",");
//        String[] cyls = weiwai.getCyl().split(",");
//        String[] axials = weiwai.getAxial().split(",");
//        String[] lightbelows = weiwai.getLightbelow().split(",");
//        String[] lengjings = weiwai.getLengjing().split(",");
//        String[] diameters = weiwai.getDiameter().split(",");
//        String[] yaoqius = weiwai.getYaoqiu().split(",");
        return "stock/weiwai/detial";
    }
    ///委外采购详情列表
    @ResponseBody
    @RequestMapping(value = "/selectWeiwaiOrder")
    public List<WeiwaiDO> selectWeiwaiOrder(String danjuNumber ,Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
//        map.put("goodsType", goodsType);
        List<WeiwaiDO> weiwaiOrder = weiwaiService.selectWeiwaiOrder(map);
        model.addAttribute("weiwaiOrder", weiwaiOrder);
        return weiwaiOrder;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:weiwai:add")
    public R save(WeiwaiDO weiwai, WeiwaikcDO weiwaikcDO, StockDO stockDO) {
        String danjuNumber = weiwai.getDanjuNumber();
        String danjuDay = weiwai.getDanjuDay();
        String eyeStyle = weiwai.getEyeStyle();
        String zhidanPeople = weiwai.getZhidanPeople();
        String mfrsid = weiwai.getMfrsid();
        String mfrsname = weiwai.getMfrsname();
        Long positionId = weiwai.getPositionId();
        String positionName = weiwai.getPositionName();
        String shouhuoPeople = weiwai.getShouhuoPeople();
        String shouhuoPhone = weiwai.getShouhuoPhone();
        String shouhuoAddress = weiwai.getShouhuoAddress();
        String beizhu = weiwai.getBeizhu();
        String status = weiwai.getStatus();
        String username = weiwai.getUsername();


        String gkname = weiwai.getGkname();
        String hyknum = weiwai.getHyknum();
        String phone = weiwai.getPhone();
        String salenumbery = weiwai.getSalenumbery();

        String saleNumber1 = "";
        String mirrorTime1 = "";
        String goodsName1 = "";
        String num1 = "";
        String code1 = "";
        String style1 = "";
        String rl1 = "";
        String count1 = "";
        String sph1 = "";
        String cyl1 = "";
        String axial1 = "";
        String diameter1 = "";
        String jd1 = "";
        String curvature1 = "";
        String lightbelow1 = "";
        String lengjing1 = "";
        String yaoqiu1 = "";
        String fristgoodsname = weiwai.getGoodsName();
        if (null == fristgoodsname) {

        } else {
            saleNumber1 = weiwai.getSaleNumber();
            mirrorTime1 = weiwai.getMirrorTime();
            goodsName1 = weiwai.getGoodsName();
            num1 = weiwai.getNum();
            code1 = weiwai.getCode();
            style1 = weiwai.getStyle();
            rl1 = weiwai.getRl();
            count1 = weiwai.getCount();
            sph1 = weiwai.getSph();
            cyl1 = weiwai.getCyl();
            axial1 = weiwai.getAxial();
            diameter1 = weiwai.getDiameter();
            if (weiwai.getJd() != null) {
                jd1 = weiwai.getJd();
            }
            if (weiwai.getCurvature() != null) {
                curvature1 = weiwai.getCurvature();
            }
            if (weiwai.getLightbelow() != null) {
                lightbelow1 = weiwai.getLightbelow();
            }
            if (weiwai.getLengjing() != null) {
                lengjing1 = weiwai.getLengjing();
            }
            if (weiwai.getYaoqiu() != null) {
                yaoqiu1 = weiwai.getYaoqiu();
            }
        }
        WeiwaiDO weiwaiDO = new WeiwaiDO();
        weiwaiDO.setDanjuNumber(danjuNumber);
        weiwaiDO.setDanjuDay(danjuDay);
        weiwaiDO.setEyeStyle(eyeStyle);
        weiwaiDO.setZhidanPeople(zhidanPeople);
        weiwaiDO.setMfrsid(mfrsid);
        weiwaiDO.setMfrsname(mfrsname);
        weiwaiDO.setPositionId(positionId);
        weiwaiDO.setPositionName(positionName);
        weiwaiDO.setShouhuoPeople(shouhuoPeople);
        weiwaiDO.setShouhuoPhone(shouhuoPhone);
        weiwaiDO.setShouhuoAddress(shouhuoAddress);
        weiwaiDO.setBeizhu(beizhu);
        weiwaiDO.setStatus(status);
        weiwaiDO.setUsername(username);
        weiwaiDO.setShTime("");
        weiwaiDO.setShstatus("");
        weiwaiDO.setPsname("");

        weiwaiDO.setSalenumbery(salenumbery);
        weiwaiDO.setPstime("");


        weiwaiDO.setGkname(gkname);
        weiwaiDO.setHyknum(hyknum);
        weiwaiDO.setPhone(phone);

        try {
            weiwaiDO.setSaleNumber(saleNumber1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setSaleNumber("");
        }
        try {
            weiwaiDO.setMirrorTime(mirrorTime1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setMirrorTime("");
        }
        try {
            weiwaiDO.setGoodsName(goodsName1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setGoodsName("");
        }
        try {
            weiwaiDO.setNum(num1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setNum("");
        }
        try {
            String[] codes=code1.split(",");
            String codeKc="";
            for (int i=0;i<codes.length;i++){
                codeKc += codes[i]+",";
            }
            weiwaiDO.setCode(codeKc);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setCode("");
        }
        try {
            weiwaiDO.setStyle(style1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setStyle("");
        }
        try {
            weiwaiDO.setRl(rl1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setRl("");
        }

        try {
            weiwaiDO.setCount(count1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setCount("");
        }
        try {
            weiwaiDO.setSph(sph1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setSph("");
        }
        try {
            weiwaiDO.setCyl(cyl1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setCyl("");
        }
        try {
            weiwaiDO.setAxial(axial1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setAxial("");
        }
        try {
            weiwaiDO.setJd(jd1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setJd("");
        }
        try {
            weiwaiDO.setCurvature(curvature1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setCurvature("");
        }
        try {
            weiwaiDO.setDiameter(diameter1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setDiameter("");
        }
        try {
            weiwaiDO.setLightbelow(lightbelow1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setLightbelow("");
        }
        try {
            weiwaiDO.setLengjing(lengjing1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setLengjing("");
        }
        try {
            weiwaiDO.setYaoqiu(yaoqiu1);
        } catch (ArrayIndexOutOfBoundsException e) {
            weiwaiDO.setYaoqiu("");
        }
        //商品代码查询品牌
        String[] numgoods=num1.split(",");
        String goodsbrandnum ;
        String goodsbrandnums="";
        String goodsmfrsid ;
        String goodsmfrsids="" ;
        String goodsbrandname ;
        String goodsbrandnames="";
        for (int i=0;i<numgoods.length;i++){
            String num=numgoods[i];
            if ("3".equals(eyeStyle)){
                JpdzDO jpdzDO=weiwaiService.selectbrandnumjpdz(num);
                goodsmfrsid=jpdzDO.getMfrsid();
                goodsbrandnum=jpdzDO.getBrandnum();
                goodsbrandname=jpdzDO.getBrandname();
                goodsmfrsids+=goodsmfrsid+",";
                goodsbrandnums+=goodsbrandnum+",";
                goodsbrandnames+=goodsbrandname+",";
            }else if ("4".equals(eyeStyle)){
                YxdzDO yxdzDO=weiwaiService.selectbrandnumyxdz(num);
                goodsmfrsid=yxdzDO.getMfrsid();
                goodsbrandnum=yxdzDO.getBrandnum();
                goodsbrandname=yxdzDO.getBrandname();
                goodsmfrsids+=goodsmfrsid+",";
                goodsbrandnums+=goodsbrandnum+",";
                goodsbrandnames+=goodsbrandname+",";
            }

        }

            weiwaiDO.setGoodsmfrsid(goodsmfrsids);
            weiwaiDO.setGoodsbrandnum(goodsbrandnums);
            weiwaiDO.setGoodsbrandname(goodsbrandnames);
        weiwaiService.save(weiwaiDO);


        weiwaikcDO.setPositionId(weiwai.getPositionId().toString());
        weiwaikcDO.setGkname(weiwai.getGkname());
        weiwaikcDO.setHyknum(weiwai.getHyknum());
        weiwaikcDO.setPhone(weiwai.getPhone());
        weiwaikcDO.setDanjuNumber(weiwai.getDanjuNumber());
        weiwaikcDO.setSaleNumber(weiwai.getSaleNumber());
        weiwaikcDO.setMirrorTime(weiwai.getMirrorTime());
        weiwaikcDO.setNum(weiwai.getNum());
        String[] codeskc=weiwai.getCode().split(",");
        String codeKcs="";
        for (int i=0;i<codeskc.length;i++){
            codeKcs += codeskc[i]+",";
        }
        weiwaikcDO.setCode(codeKcs);



        weiwaikcDO.getGoodsName(weiwai.getGoodsName());
        weiwaikcDO.getCount(weiwai.getCount());


        weiwaikcDO.getStatus(weiwai.getStatus());

        weiwaikcDO.setShTime("");
        weiwaikcDO.setShstatus("");
        weiwaikcDO.setPsname("");
        weiwaikcDO.setSalenumbery(salenumbery);
        weiwaikcDO.setPstime("");


        if (weiwaikcService.save(weiwaikcDO) > 0) {
            return R.ok();
        }
        return R.error();

    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("stock:weiwai:edit")
    public R update(WeiwaiDO weiwai) {
        weiwaiService.update(weiwai);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("stock:weiwai:remove")
    public R remove(Long id) {
        WeiwaiDO weiwaiDO=weiwaiService.get(id);
        String[] saleNumbers= weiwaiDO.getSaleNumber().split(",");
        String saleNumber= weiwaiDO.getSaleNumber();
        for (int i=0;i<1;i++){
           String number=saleNumbers[0];
            weiwaishujuService.removes(number);//1个
        }

        weiwaikcService.removes(saleNumber);//2个
        if (weiwaiService.removes(saleNumber) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("stock:weiwai:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        weiwaiService.batchRemove(ids);
        return R.ok();
    }


    //外部配镜单查询
    @GetMapping("/getGoods/{eyeStyle}/{mfrsid}/{mfrsname}/{zhidanPeople}")
    String getGoods(@PathVariable("eyeStyle") Integer eyeStyle, @PathVariable("mfrsid") String mfrsid,
                    @PathVariable("mfrsname") String mfrsname, @PathVariable("zhidanPeople") String zhidanPeople, Model model) {
        //商品类别
        if (eyeStyle == 3) {
            model.addAttribute("eyeStyles", "框镜订做");
            model.addAttribute("eyeStyle", eyeStyle);
        } else if (eyeStyle == 4) {
            model.addAttribute("eyeStyles", "隐形订做");
            model.addAttribute("eyeStyle", eyeStyle);
        }
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("zhidanPeople", zhidanPeople);
        model.addAttribute("mfrsname", mfrsname);
        //———生成单据编号————
        Long uuid = GuuidUtil.getUUID();
        String danjunum = "W" + uuid.toString();
        model.addAttribute("danjunum", danjunum);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("danjuDay", newDate);
        //部门selectOrder
        Map<String, Object> map = new HashMap<>();
        //———获取当前登录用户————
        if (null != ShiroUtils.getUser().getStoreNum()) {
            map.put("departNumber", ShiroUtils.getUser().getStoreNum());
        } else {
            map.put("departNumber", "");
        }
        model.addAttribute("departmentName", ShiroUtils.getUser().getStore());
        return "/stock/weiwaishuju/jpadd";
    }


    @GetMapping("/PeiJing/{eyeStyle}/{mfrsid}/{mfrsname}")
    String PeiJing(@PathVariable("eyeStyle") Integer eyeStyle,@PathVariable("mfrsid") String mfrsid,
                   @PathVariable("mfrsname") String mfrsname, Model model) {
        model.addAttribute("eyeStyle", eyeStyle);
        model.addAttribute("mfrsid", mfrsid);
        model.addAttribute("mfrsname", mfrsname);
        return "/stock/weiwai/yuanPeiJing";
    }

    //销售单
    @ResponseBody
    @RequestMapping("/selectOrder")
    public PageUtils selectOrder(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if ("3".equals(params.get("eyeStyle"))) {
            query.put("classtype", "2");
            query.put("eyeStyles", "框镜");
        } else if ("4".equals(params.get("eyeStyle"))) {
            query.put("classtype", "2");
            query.put("eyeStyles", "隐形");
        }
//		【只能查当前公司的】
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        if (companyId == null) {
            query.put("departNumber", "");
        } else if (companyId != null) {
            query.put("companyId", companyId);
        }

        query.put("saleType", 1);
        List<SalesDO> selectOrder = weiwaiService.selectOrder(query);
		int total = weiwaiService.selectOrderCount(query);
        PageUtils pageUtils = new PageUtils(selectOrder, total);
        return pageUtils;
    }

    /**
     * 收货输入工号
     */
    @GetMapping("/userNum/{danjuNumber}")
    @RequiresPermissions("stock:weiwai:userNum")
    String userNum(@PathVariable("danjuNumber") String danjuNumber, Model model) {
        model.addAttribute("danjuNumber", danjuNumber);
        return "/stock/weiwai/userNum";
    }

    /**
     * 收货状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public R updateEnable(String danjuNumber, String status, String username,StockDO stockDO) {
        //———获取当前登录用户的公司id————
        Map<String, Object> map = new HashMap<>();
        String conpanyId = ShiroUtils.getUser().getCompanyId();
        map.put("conpanyId", conpanyId);
        map.put("userName", username);
        UserDO userDO = userService.getUserName(map);
        if (null == userDO) {
            return R.error("该工号不存在");
        }else {
            WeiwaiDO orderDOS = weiwaiService.weiwaiOrder(danjuNumber);
            String positionName = orderDOS.getPositionName();
            //委外进库存
// 代码 条码 名称 数量 类别 制造商 品牌 单位 价钱 仓位 classtype
            String[] num = orderDOS.getNum().split(",");//代码
            String[] code = orderDOS.getCode().split(",");//代码
            String[] count = orderDOS.getCount().split(",");//数量
            for (int i = 0; i < num.length; i++) {
                StockDO stockDO1 = new StockDO();
                //加库存
                stockDO1.setPositionId(orderDOS.getPositionId().toString());
                stockDO1.setGoodsNum(num[i]);
                stockDO1.setGoodsCode(code[i]);
                StockDO jiaGoodsList = stockService.haveNum(stockDO1);
                if (null != jiaGoodsList) {
                    String gdcount = jiaGoodsList.getGoodsCount();
                    Integer goodsCountNew = Integer.valueOf(count[i]);
                    Integer gdcountNew = Integer.valueOf(gdcount);
                    Integer newGoodsCount = gdcountNew + goodsCountNew;
                    stockDO1.setGoodsCount(String.valueOf(newGoodsCount));
                    stockService.updateGoodsCount(stockDO1);//修改数量

                    WeiwaiDO weiwaiDO = new WeiwaiDO();
                    weiwaiDO.setDanjuNumber(danjuNumber);
                    weiwaiDO.setStatus(status);
                    weiwaiDO.setUsername(username);
                    //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                    Date dates = new Date();
                    String shTime = sdf.format(dates);
                    weiwaiDO.setShTime(shTime);
                    String danjuNumbers = jiaGoodsList.getDanjuNumber();
                    weiwaiDO.setStockorder(danjuNumbers);
                    weiwaiService.updateStatus(weiwaiDO);

                    WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
                    weiwaikcDO.setDanjuNumber(danjuNumber);
                    weiwaikcDO.setStatus(status);
                    weiwaikcDO.setUsername(username);
                    weiwaikcDO.setShTime(shTime);
                    weiwaikcService.updateStatus(weiwaikcDO);

                    StockDO stockDOs = new StockDO();
                    stockDOs.setDanjuNumber(danjuNumber);
                    stockDOs.setStatus(status);
                    stockDOs.setUsername(username);
                    stockService.updateStatus(stockDOs);


                    ///log
                    StocklogDO stocklogDO=new StocklogDO();
                    stocklogDO.setDanjunum(danjuNumber);
                    stocklogDO.setNum(jiaGoodsList.getGoodsNum());
                    stocklogDO.setCode(jiaGoodsList.getGoodsCode());
                    stocklogDO.setName(jiaGoodsList.getGoodsName());
                    stocklogDO.setGoodsid(Integer.valueOf(jiaGoodsList.getGoodsType()));
                    stocklogDO.setMfrsnum(jiaGoodsList.getMfrsid());
                    stocklogDO.setBrandname(jiaGoodsList.getBrandname());
                    stocklogDO.setMoney(jiaGoodsList.getRetailPrice());
                    stocklogDO.setUseday(jiaGoodsList.getUseday());
                    stocklogDO.setBacth(jiaGoodsList.getBatch());
                    stocklogDO.setCounts(String.valueOf(goodsCountNew));
                    stocklogDO.setInpositionId(orderDOS.getPositionId());
                    stocklogDO.setOutpositionId(null);
                    stocklogDO.setZhidanPeople(jiaGoodsList.getZhidanPeople());
//                //———获取当前系统时间—————
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                    Date date = new Date();
//                    String newDate = sdf.format(date);
                    stocklogDO.setDay(shTime);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                    stocklogDO.setWay("委外入库");
                    //———获取当前登录用户的工号————
                    stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                    stocklogService.save(stocklogDO);

                } else {
                    String goodsType = orderDOS.getEyeStyle();//类别
                    if ("3".equals(goodsType)) {
                        StockDO stockDO2 = new StockDO();
                        stockDO2.setGoodsNum(num[i]);
                        StockDO jingpians = stockService.jingpiandzs(stockDO2);
                        // 代码 条码 名称 数量 类别 制造商 品牌 单位 价钱 仓位 classtype ..型号
                        String goodsNums = num[i];
                        String goodsCodes = code[i];
                        String goodsNames = jingpians.getProducName();
                        String counts = count[i];
                        String goodsTypes = orderDOS.getEyeStyle();//类别
                        String mfrsids = jingpians.getMfrsid();
                        String brandnames = jingpians.getBrandname();
                        String unitnames = jingpians.getUnitname();
                        String retailPrices = jingpians.getRetailPrice();
                        stockDO.setPositionId(orderDOS.getPositionId().toString());
                        String classtypes = jingpians.getClasstype();
                        String factorys = jingpians.getProducFactory();

                        stockDO.setGoodsNum(goodsNums);
                        stockDO.setGoodsCode(goodsCodes);
                        stockDO.setGoodsName(goodsNames);
                        stockDO.setGoodsCount(counts);
                        stockDO.setGoodsType(Integer.valueOf(goodsTypes));
                        stockDO.setMfrsid(mfrsids);
                        stockDO.setBrandname(brandnames);
                        stockDO.setUnit(unitnames);
                        stockDO.setRetailPrice(retailPrices);
                        stockDO.setClasstype(classtypes);
                        stockDO.setFactory(factorys);
                        //收货状态
                        //———生成单据编号————
//                    Long uuid = GuuidUtil.getUUID();
                        String danjuNumbers = orderDOS.getDanjuNumber();
                        //———入库时间—————
                        SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String createTimes = createTimenew.format(date);
                        stockDO.setCreateTime(createTimes);
                        stockDO.setDanjuNumber(danjuNumbers);
                        //------制单人------
                        String zhidanPeoples = ShiroUtils.getUser().getName();
                        stockDO.setZhidanPeople(zhidanPeoples);
                        //---单据日期--
                        stockDO.setDanjuDay(createTimes);
                        stockDO.setStatus("1");
                        stockDO.setUsername("未收货");
                        stockDO.setReturnzt("1");

                        ///log
                        StocklogDO stocklogDO=new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsNums);
                        stocklogDO.setCode(goodsCodes);
                        stocklogDO.setName(goodsNames);
                        stocklogDO.setGoodsid(Integer.valueOf(goodsTypes));
                        stocklogDO.setMfrsnum(mfrsids);
                        stocklogDO.setBrandname(brandnames);
                        stocklogDO.setMoney(retailPrices);
                        stocklogDO.setUseday("");
                        stocklogDO.setBacth("");
                        stocklogDO.setCounts(counts);
                        stocklogDO.setInpositionId(orderDOS.getPositionId());
                        stocklogDO.setOutpositionId(null);
                        stocklogDO.setZhidanPeople(zhidanPeoples);
//                //———获取当前系统时间—————
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                    Date date = new Date();
//                    String newDate = sdf.format(date);
                        stocklogDO.setDay(createTimes);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                        stocklogDO.setWay("委外入库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);

                        if (stockService.save(stockDO) > 0) {
                            WeiwaiDO weiwaiDO = new WeiwaiDO();
                            weiwaiDO.setDanjuNumber(danjuNumber);
                            weiwaiDO.setStatus(status);
                            weiwaiDO.setUsername(username);
                            //———获取当前系统时间—————
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date dates = new Date();
                            String shTime = sdf.format(dates);
                            weiwaiDO.setShTime(shTime);
                            weiwaiDO.setStockorder(danjuNumbers);
                            weiwaiService.updateStatus(weiwaiDO);

                            WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
                            weiwaikcDO.setDanjuNumber(danjuNumber);
                            weiwaikcDO.setStatus(status);
                            weiwaikcDO.setUsername(username);
                            weiwaikcDO.setShTime(shTime);
                            weiwaikcService.updateStatus(weiwaikcDO);

                            StockDO stockDOs = new StockDO();
                            stockDOs.setDanjuNumber(danjuNumber);
                            stockDOs.setStatus(status);
                            stockDOs.setUsername(username);
                            stockService.updateStatus(stockDOs);

                        }
                    } else if ("4".equals(goodsType)) {
                        StockDO stockDO2 = new StockDO();
                        stockDO2.setGoodsNum(num[i]);
                        StockDO yinxingdzs = stockService.yinxingdzs(stockDO2);
                        // 代码 条码 名称 数量 类别 制造商 品牌 单位 价钱 仓位 classtype ..型号
                        String goodsNums = num[i];
                        String goodsCodes = code[i];
                        String goodsNames = yinxingdzs.getProducName();
                        String counts = count[i];
                        String goodsTypes = orderDOS.getEyeStyle();//类别

                        String mfrsids = yinxingdzs.getMfrsid();
                        String brandnames = yinxingdzs.getBrandname();
                        String unitnames = yinxingdzs.getUnitname();
                        String retailPrices = yinxingdzs.getRetailPrice();
                        stockDO.setPositionId(orderDOS.getPositionId().toString());
                        String classtypes = yinxingdzs.getClasstype();
                        String factorys = yinxingdzs.getProducFactory();

                        stockDO.setGoodsNum(goodsNums);
                        stockDO.setGoodsCode(goodsCodes);
                        stockDO.setGoodsName(goodsNames);
                        stockDO.setGoodsCount(counts);
                        stockDO.setGoodsType(Integer.valueOf(goodsTypes));
                        stockDO.setMfrsid(mfrsids);
                        stockDO.setBrandname(brandnames);
                        stockDO.setUnit(unitnames);
                        stockDO.setRetailPrice(retailPrices);
                        stockDO.setClasstype(classtypes);
                        stockDO.setFactory(factorys);
                        //收货状态
                        //———生成单据编号————
//                    Long uuid = GuuidUtil.getUUID();
                        String danjuNumbers = orderDOS.getDanjuNumber();
                        //———入库时间—————
                        SimpleDateFormat createTimenew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String createTimes = createTimenew.format(date);
                        stockDO.setCreateTime(createTimes);
                        stockDO.setDanjuNumber(danjuNumbers);
                        //------制单人------
                        String zhidanPeoples = ShiroUtils.getUser().getName();
                        stockDO.setZhidanPeople(zhidanPeoples);
                        //---单据日期--
                        stockDO.setDanjuDay(createTimes);
                        stockDO.setStatus("1");
                        stockDO.setUsername("未收货");
                        stockDO.setReturnzt("1");


                        ///log
                        StocklogDO stocklogDO=new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsNums);
                        stocklogDO.setCode(goodsCodes);
                        stocklogDO.setName(goodsNames);
                        stocklogDO.setGoodsid(Integer.valueOf(goodsTypes));
                        stocklogDO.setMfrsnum(mfrsids);
                        stocklogDO.setBrandname(brandnames);
                        stocklogDO.setMoney(retailPrices);
                        stocklogDO.setUseday("");
                        stocklogDO.setBacth("");
                        stocklogDO.setCounts(counts);
                        stocklogDO.setInpositionId(orderDOS.getPositionId());
                        stocklogDO.setOutpositionId(null);
                        stocklogDO.setZhidanPeople(zhidanPeoples);
//                //———获取当前系统时间—————
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                    Date date = new Date();
//                    String newDate = sdf.format(date);
                        stocklogDO.setDay(createTimes);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                        stocklogDO.setWay("委外入库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);

                        if (stockService.save(stockDO) > 0) {
                            WeiwaiDO weiwaiDO = new WeiwaiDO();
                            weiwaiDO.setDanjuNumber(danjuNumber);
                            weiwaiDO.setStatus(status);
                            weiwaiDO.setUsername(username);
                            //———获取当前系统时间—————
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                            Date dates = new Date();
                            String shTime = sdf.format(dates);
                            weiwaiDO.setShTime(shTime);
                            weiwaiService.updateStatus(weiwaiDO);

                            WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
                            weiwaikcDO.setDanjuNumber(danjuNumber);
                            weiwaikcDO.setStatus(status);
                            weiwaikcDO.setUsername(username);
                            weiwaikcDO.setShTime(shTime);
                            weiwaikcService.updateStatus(weiwaikcDO);

                            StockDO stockDOs = new StockDO();
                            stockDOs.setDanjuNumber(danjuNumber);
                            stockDOs.setStatus(status);
                            stockDOs.setUsername(username);
                            stockService.updateStatus(stockDOs);

                        }
                    }
                }
            }
        }
        return R.ok();
    }

    //打印委外框镜配镜单
    @GetMapping("/jkPeijingdan")
    String jkPeijingdan(String danjuNumber, Model model) {
        WeiwaiDO weiwaiDO = weiwaiService.jkPeijingdan(danjuNumber);
        model.addAttribute("weiwaiDO", weiwaiDO);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String dayinDay = sdf.format(date);
        model.addAttribute("dayinDay", dayinDay);
        return "/stock/weiwai/jkPeijingdan";
    }
    ///打印委外框镜配镜单列表
    @ResponseBody
    @RequestMapping(value = "/jkPeijingdanList")
    public List<WeiwaiDO> selectJKList(String danjuNumber ,Model model ) {
        Map<String, Object> map = new HashMap<>();
//        map.put("danjuNumber", danjuNumber);
        String[] danjuNumbes=danjuNumber.split(",");
        List<WeiwaiDO> weiwaiDOList=new ArrayList<>();
        List<WeiwaiDO> weiwaiDan=new ArrayList<>();
        for (int i=0;i<danjuNumbes.length;i++){
            String danjunum=danjuNumbes[i];
            map.put("danjuNumber",danjunum);
            weiwaiDan = weiwaiService.jkPeijingdanList(map);
            weiwaiDOList.addAll(weiwaiDan);
        }
        return weiwaiDOList;
    }


    //打印委外隐形配镜单
    @GetMapping("/yxPeijingdan")
    String yxPeijingdan(String danjuNumber, Model model) {
        WeiwaiDO weiwaiDO = weiwaiService.yxPeijingdan(danjuNumber);
        model.addAttribute("weiwaiDO", weiwaiDO);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String dayinDay = sdf.format(date);
        model.addAttribute("dayinDay", dayinDay);
        return "/stock/weiwai/yxPeijingdan";
    }
    ///打印委外隐形配镜单列表
    @ResponseBody
    @RequestMapping(value = "/yxPeijingdanList")
    public List<WeiwaiDO> yxPeijingdanList(String danjuNumber ,Model model ) {
        Map<String, Object> map = new HashMap<>();
        map.put("danjuNumber", danjuNumber);
        List<WeiwaiDO> weiwaiDOList = weiwaiService.yxPeijingdanList(map);
        model.addAttribute("weiwaiDOList", weiwaiDOList);
        return weiwaiDOList;
    }


    /**
     * 配送输入工号
     */
    @RequiresPermissions("stock:weiwai:psNum")
    @GetMapping("/psNum/{salenumbery}/{danjuNumber}/{eyeStyle}/{yaoqiu}/{shstatus}")
    String psNum(@PathVariable("salenumbery") String salenumbery,
                     @PathVariable("danjuNumber") String danjuNumber,
                     @PathVariable("eyeStyle") String eyeStyle,
                     @PathVariable("yaoqiu") String yaoqiu,
                     @PathVariable("shstatus") String shstatus,
                       Model model) {
        model.addAttribute("danjuNumber", danjuNumber);
        model.addAttribute("salenumbery", salenumbery);
        model.addAttribute("eyeStyle", eyeStyle);
        model.addAttribute("yaoqiu", yaoqiu);
        model.addAttribute("shstatus", shstatus);
        return "/stock/weiwai/userNumps";
    }

    /**
     * 取镜处收货或者加工检验----配送减库存
     */
    @PostMapping("/editShouhuo")
    @ResponseBody
    public R editShouhuo(String danjuNumber, String salenumbery, String shstatus, String psname, String eyeStyle,
                         String yaoqiu  ) {
        Map<String, Object> map = new HashMap<>();
        String conpanyId = ShiroUtils.getUser().getCompanyId();
        map.put("conpanyId", conpanyId);
        map.put("userName", psname);
        UserDO userDO = userService.getUserName(map);
        if (null == userDO) {
            return R.error("该工号不存在");
        } else {
            LogStatusDO logStatusDO = new LogStatusDO();
//        String[] array = yaoqiu.split(",");
//        boolean flag = false;
//        flag = Arrays.asList(array).contains("委外代加工");
            String str = yaoqiu;
            Integer flag = str.indexOf("委外代加工");  // true
            if ("3".equals(eyeStyle.trim())) {//去除空格
                if (flag != -1) {
                    logStatusDO.setSaleNumber(salenumbery);
                    logStatusDO.setLogisticStatus("配送");
                    WorkRecoedDO workRecoedDO = new WorkRecoedDO();
                    workRecoedDO.setUserName(psname);
                    workRecoedDO.setType("配送");
                    workRecoedDO.setDateTime(new Date());
                    statusService.saveRecord(workRecoedDO);
                    //减库存
                    WeiwaiDO weiwaiOrders = weiwaiService.weiwaiOrder(danjuNumber);
                    String[] mfrsids = weiwaiOrders.getGoodsmfrsid().split(",");
                    String[] brandnames = weiwaiOrders.getGoodsbrandname().split(",");
                    String[] nums = weiwaiOrders.getNum().split(",");
                    String[] codes = weiwaiOrders.getCode().split(",");
                    String[] counts = weiwaiOrders.getCount().split(",");
                    for (int i = 0; i < nums.length; i++) {
                        StockDO stock = new StockDO();
                        //减库存
                        stock.setPositionId(String.valueOf(weiwaiOrders.getPositionId()));
                        String mfrsid = mfrsids[i];
                        stock.setMfrsid(mfrsid);
                        String brandname = brandnames[i];
                        stock.setBrandnum(brandname);
                        String goodsNum = nums[i];
                        stock.setGoodsNum(goodsNum);
                        String goodsCode = codes[i];
                        stock.setGoodsCode(goodsCode);
                        String count = counts[i];
                        stock.setCount(count);
                        StockDO goodsList = stockService.haveNum(stock);
                        if (null != goodsList) {
                            String countStock = goodsList.getGoodsCount();
                            Integer newcount = Integer.valueOf(count);
                            Integer yuancounts = Integer.valueOf(countStock);
                            Integer newCount = yuancounts - newcount;
                            stock.setGoodsCount(String.valueOf(newCount));
                            stockService.updateGoodsCount(stock);//修改数量

                            ///log
                            StocklogDO stocklogDO=new StocklogDO();
                            stocklogDO.setDanjunum(danjuNumber);
                            stocklogDO.setNum(goodsList.getGoodsNum());
                            stocklogDO.setCode(goodsList.getGoodsCode());
                            stocklogDO.setName(goodsList.getGoodsName());
                            stocklogDO.setGoodsid(goodsList.getGoodsType());
                            stocklogDO.setMfrsnum(goodsList.getMfrsid());
                            stocklogDO.setBrandname(goodsList.getBrandname());
                            stocklogDO.setMoney(goodsList.getRetailPrice());
                            stocklogDO.setUseday(goodsList.getUseday());
                            stocklogDO.setBacth(goodsList.getBatch());
                            stocklogDO.setCounts(String.valueOf(newcount));
                            stocklogDO.setInpositionId(null);
                            stocklogDO.setOutpositionId(weiwaiOrders.getPositionId());
                            stocklogDO.setZhidanPeople(psname);
//                //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                    Date date = new Date();
                    String newDate = sdf.format(date);
                            stocklogDO.setDay(newDate);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                            stocklogDO.setWay("委外出库");
                            //———获取当前登录用户的工号————
                            stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                            stocklogService.save(stocklogDO);
                        }
                    }

                } else {
                    logStatusDO.setSaleNumber(salenumbery);
                    logStatusDO.setLogisticStatus("委外完成");
                    WorkRecoedDO workRecoedDO = new WorkRecoedDO();
                    workRecoedDO.setUserName(psname);
                    workRecoedDO.setType("委外完成");
                    workRecoedDO.setDateTime(new Date());
                    statusService.saveRecord(workRecoedDO);
                }

            } else if ("4".equals(eyeStyle.trim())) {//去除空格
                logStatusDO.setSaleNumber(salenumbery);
                logStatusDO.setLogisticStatus("配送");
                WorkRecoedDO workRecoedDO = new WorkRecoedDO();
                workRecoedDO.setUserName(psname);
                workRecoedDO.setType("配送");
                workRecoedDO.setDateTime(new Date());
                statusService.saveRecord(workRecoedDO);


                //减库存
                WeiwaiDO weiwaiOrders = weiwaiService.weiwaiOrder(danjuNumber);
                String[] mfrsids = weiwaiOrders.getGoodsmfrsid().split(",");
                String[] brandnames = weiwaiOrders.getGoodsbrandname().split(",");
                String[] nums = weiwaiOrders.getNum().split(",");
                String[] codes = weiwaiOrders.getCode().split(",");
                String[] counts = weiwaiOrders.getCount().split(",");
                for (int i = 0; i < nums.length; i++) {
                    StockDO stock = new StockDO();
                    //减库存
                    stock.setPositionId(String.valueOf(weiwaiOrders.getPositionId()));
                    String mfrsid = mfrsids[i];
                    stock.setMfrsid(mfrsid);
                    String brandname = brandnames[i];
                    stock.setBrandnum(brandname);
                    String goodsNum = nums[i];
                    stock.setGoodsNum(goodsNum);
                    String goodsCode = codes[i];
                    stock.setGoodsCode(goodsCode);
                    String count = counts[i];
                    stock.setCount(count);
                    StockDO goodsList = stockService.haveNum(stock);
                    if (null != goodsList) {
                        String countStock = goodsList.getGoodsCount();
                        Integer newcount = Integer.valueOf(count);
                        Integer yuancounts = Integer.valueOf(countStock);
                        Integer newCount = yuancounts - newcount;
                        stock.setGoodsCount(String.valueOf(newCount));
                        stockService.updateGoodsCount(stock);//修改数量

                        ///log
                        StocklogDO stocklogDO=new StocklogDO();
                        stocklogDO.setDanjunum(danjuNumber);
                        stocklogDO.setNum(goodsList.getGoodsNum());
                        stocklogDO.setCode(goodsList.getGoodsCode());
                        stocklogDO.setName(goodsList.getGoodsName());
                        stocklogDO.setGoodsid(goodsList.getGoodsType());
                        stocklogDO.setMfrsnum(goodsList.getMfrsid());
                        stocklogDO.setBrandname(goodsList.getBrandname());
                        stocklogDO.setMoney(goodsList.getRetailPrice());
                        stocklogDO.setUseday(goodsList.getUseday());
                        stocklogDO.setBacth(goodsList.getBatch());
                        stocklogDO.setCounts(String.valueOf(newcount));
                        stocklogDO.setInpositionId(null);
                        stocklogDO.setOutpositionId(weiwaiOrders.getPositionId());
                        stocklogDO.setZhidanPeople(psname);
//                //———获取当前系统时间—————
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                        Date date = new Date();
                        String newDate = sdf.format(date);
                        stocklogDO.setDay(newDate);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                        stocklogDO.setWay("委外出库");
                        //———获取当前登录用户的工号————
                        stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                        stocklogService.save(stocklogDO);

                    }
                }


            }

            if (statusService.save(logStatusDO) > 0) {
                WeiwaiDO weiwaiDO = new WeiwaiDO();
                weiwaiDO.setDanjuNumber(danjuNumber);
                weiwaiDO.setShstatus(shstatus);
                weiwaiDO.setPsname(psname);
                //———获取当前系统时间—————
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date date = new Date();
                String newDate = sdf.format(date);
                weiwaiDO.setPstime(newDate);
                weiwaiService.updateStatus(weiwaiDO);


                WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
                weiwaikcDO.setDanjuNumber(danjuNumber);
                weiwaikcDO.setShstatus(shstatus);
                weiwaikcDO.setPsname(psname);
                //———获取当前系统时间—————
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date date1 = new Date();
                String newDate1 = sdf.format(date1);
                weiwaiDO.setPstime(newDate1);
                weiwaikcService.updateStatus(weiwaikcDO);
                return R.ok();
            }
            return R.error();
        }
    }

    /**
     * 退货输入工号
     */
    @GetMapping("/userNumth/{salenumbery}/{danjuNumber}")
    String userNumth(@PathVariable("salenumbery") String salenumbery,
                     @PathVariable("danjuNumber") String danjuNumber, Model model) {
        model.addAttribute("danjuNumber", danjuNumber);
        model.addAttribute("salenumbery", salenumbery);
        return "/stock/weiwai/userNumth";
    }

    /**
     * 取镜处收货
     */
    @PostMapping("/editTuihuo")
    @ResponseBody
    public R editTuihuo(String danjuNumber, String shstatus, String psname) {

        WeiwaiDO weiwaiDO = new WeiwaiDO();
        weiwaiDO.setDanjuNumber(danjuNumber);
        weiwaiDO.setShstatus(shstatus);
        weiwaiDO.setPsname(psname);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        weiwaiDO.setPstime(newDate);

        WeiwaikcDO weiwaikcDO = new WeiwaikcDO();
        weiwaikcDO.setDanjuNumber(danjuNumber);
        weiwaikcDO.setShstatus(shstatus);
        weiwaikcDO.setPsname(psname);
        //———获取当前系统时间—————
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date1 = new Date();
        String newDate1 = sdf.format(date1);
        weiwaiDO.setPstime(newDate1);
        if (weiwaiService.updateStatus(weiwaiDO) > 0) {
            weiwaikcService.updateStatus(weiwaikcDO);
            return R.ok();
        }
        return R.error();
    }



    /**
     * 批量打印
     */
    @GetMapping("/dayinList")
    @RequiresPermissions("stock:weiwai:danyiinList")
    String dayinList(  String[] ids,String[] danjuNumbers, String[] mfrsid,String  mfrsnames,Model model) {
        model.addAttribute("ids",ids);
        String danjuNumber="";
        for (int i=0;i<danjuNumbers.length;i++){
            danjuNumber+=danjuNumbers[i]+",";
        }
        model.addAttribute("danjuNumber",danjuNumber);
        model.addAttribute("mfrsid",mfrsid);
        model.addAttribute("mfrsnames",mfrsnames);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String dayinDay = sdf.format(date);
        model.addAttribute("dayinDay", dayinDay);
        //------制单人------
        String zhidanPeoples = ShiroUtils.getUser().getName();
        model.addAttribute("zhidanPeoples",zhidanPeoples);
        return "/stock/weiwai/dayinList";
    }

//    /**
//     * 浏览器打印二维码
//     */
//    @GetMapping("/code")
//    public String code(String danjuNumber, Model model) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("danjuNumber",danjuNumber);
//        List<OrderDO> orderDOS = orderService.getCode(map);
//        model.addAttribute("orderDOS", orderDOS);
//        for (OrderDO orderDO1 : orderDOS){
//            String code = QRCodeUtil.creatRrCode(orderDO1.getGoodsCode(), 200,200);
//            code = "data:image/png;base64," + code;
//            orderDO1.setQRCode(code);
//        }
//        return "/stock/stock/code";
//    }
    /**
     * 浏览器打印二维码
     */
    @GetMapping("/code")
    @RequiresPermissions("stock:weiwai:code")
    public String code(String danjuNumber, Model model) {

        WeiwaiDO weiwaiDO = weiwaiService.getCode(danjuNumber);
        String[] goodsCodes= weiwaiDO.getCode().split(",");
        String[] goodsCounts= weiwaiDO.getCount().split(",");
        String [] codeAndCounts = new String[goodsCodes.length];
        String codes="";
        String counts="";
        for (int i=0;i<goodsCodes.length;i++) {
            codes = goodsCodes[i];
            counts = goodsCounts[i];
            codeAndCounts[i] = codes + "," + counts;
        }
        model.addAttribute("codeAndCounts",codeAndCounts);

        List<Map<String ,Object>> weiwaiDOList=new ArrayList<>();
        for (int i=0;i<codeAndCounts.length;i++) {
            Map<String,Object> map=new HashMap<>();
            String[] countcode=codeAndCounts[i].split(",");
            map.put("goodsCodes",countcode[0]);
            map.put("goodsCounts",countcode[1]);
            weiwaiDOList.add(map);
        }
//       model.addAttribute("weiwaiDOList", weiwaiDOList);

        List<Map<String ,Object>> weiwaiCode=new ArrayList<>();
        for (int a=0;a<weiwaiDOList.size();a++){
            Map<String,Object> map=new HashMap<>();
            String goodsCode=String.valueOf(weiwaiDOList.get(a).get("goodsCodes"));
            String goodsCount=String.valueOf(weiwaiDOList.get(a).get("goodsCounts"));
            String code = QRCodeUtil.creatRrCode(String.valueOf(goodsCode), 200,200);
            code = "data:image/png;base64," + code;
            map.put("goodsCode",goodsCode);
            map.put("goodsCount",goodsCount);
            map.put("QRCode",code);
            weiwaiCode.add(map);
        }
        model.addAttribute("weiwaiCode", weiwaiCode);
        model.addAttribute("goodsCounts",goodsCounts);
        return "/stock/weiwai/code";
    }

}

