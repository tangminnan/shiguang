package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.baseinfomation.service.impl.DepartmentServiceImpl;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.product.domain.*;
import com.shiguang.stock.domain.*;
import com.shiguang.stock.service.StockService;
import com.shiguang.stock.service.StocklogService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.stock.service.PidiaoService;

/**
 * 批调表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */

@Controller
@RequestMapping("/stock/pidiao")
public class PidiaoController {
    @Autowired
    private PidiaoService pidiaoService;
    //部门
    @Autowired
    private DepartmentService departmentService;
    //公司
    @Autowired
    private CompanyService companyService;
    //商品类别
    @Autowired
    private GoodsService goodsService;
    //仓位
    @Autowired
    private PositionService positionService;
    //库存
    @Autowired
    private StockService stockService;
    @Autowired
    private StocklogService stocklogService;

    @GetMapping()
    @RequiresPermissions("stock:pidiao:pidiao")
    String Pidiao() {
        return "stock/pidiao/pidiao";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("stock:pidiao:pidiao")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyId = "";
        String departNumber = "";
        if (null != ShiroUtils.getUser().getCompanyId()) {
            companyId = ShiroUtils.getUser().getCompanyId();
            query.put("companyId", companyId);
        } else if (null != ShiroUtils.getUser().getStoreNum()) {
            departNumber = ShiroUtils.getUser().getStoreNum();
            query.put("departNumber", departNumber);
        }


        List<PidiaoDO> pidiaoList = pidiaoService.list(query);
        for (PidiaoDO pidiaoDO : pidiaoList) {
            if (companyId != "") {
                if (companyId.equals(pidiaoDO.getInCompanyid())) {
                    pidiaoDO.setFlags("0");
                } else {
                    pidiaoDO.setFlags("1");
                }
            }
            else {
                pidiaoDO.setFlags("0");
            }

            if (departNumber.equals(pidiaoDO.getOutDepartmentid())) {
                pidiaoDO.setFlags("1");//发出部门

            }
            if (departNumber.equals(pidiaoDO.getInDepartmentid())) {
                pidiaoDO.setFlags("0");//接收部门
            }


        }
        int total = pidiaoService.count(query);
//        int total = pidiaoList.size();
        PageUtils pageUtils = new PageUtils(pidiaoList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("stock:pidiao:add")
    String add(Model model) {
        //———生成单据编号————
        Long uuid = GuuidUtil.getUUID();
        String pidiaoNum = "PD" + uuid.toString();
        model.addAttribute("pidiaoNum", pidiaoNum);
        //部门
        Map<String, Object> map = new HashMap<>();
        //———获取当前登录用户的公司id————
        String companyId = ShiroUtils.getUser().getCompanyId();
        if (companyId == null) {
            String departNumber = ShiroUtils.getUser().getStoreNum();
            map.put("departNumber", departNumber);
        } else if (companyId != null) {
            map.put("companyId", companyId);
        }
        map.put("status", "0");
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList", departmentDOList);

        map.put("xsstate", 0);
        List<CompanyDO> companyList = companyService.list(map);
        model.addAttribute("companyList", companyList);
        //———获取当前登录用户的名称————
        model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("danjuDay", newDate);
        return "stock/pidiao/add";
    }

    //发出仓位
    @ResponseBody
    @RequestMapping(value = "/outposion")
    public List<PidiaoDO> outposion(String outDepartment, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("outDepartment", outDepartment);
        List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
        model.addAttribute("outPositiion", outPositiion);
        return outPositiion;
    }

    //接收部门
    @ResponseBody
    @RequestMapping(value = "/indepartment")
    public List<PidiaoDO> indepartment(String inCompany, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("inCompany", inCompany);
        List<PidiaoDO> indepartment = pidiaoService.indepartment(map);
        model.addAttribute("indepartment", indepartment);
        return indepartment;
    }

    //接收仓位
    @ResponseBody
    @RequestMapping(value = "/inposion")
    public List<PidiaoDO> inposion(String inDepartment, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("inDepartment", inDepartment);
        List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
        model.addAttribute("outPositiion", outPositiion);
        return outPositiion;
    }

    //跳转库存查询
    @GetMapping("/selextkc/{outPosition}")
    String selextkc(@PathVariable("outPosition") String outPosition, Model model) {
        Map<String, Object> map = new HashMap<>();
        //商品
        List<GoodsDO> goodsDOList = goodsService.list(map);
        model.addAttribute("goodsDOList", goodsDOList);
        //仓位
        map.put("xsstate", 0);
        List<PositionDO> positionList = positionService.positionList(map);
        model.addAttribute("positionList", positionList);
        model.addAttribute("outPosition", outPosition);
        return "/stock/pidiao/selectGoods";
    }


    @GetMapping("/detials/{id}")
    @RequiresPermissions("stock:pidiao:detial")
    String detials(@PathVariable("id") Long id, Model model) {
        PidiaoDO pidiao = pidiaoService.get(id);
//		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = pidiao.getDanjuDay();
//		String danjuDay = sdftime.format(time);
        model.addAttribute("danjuDay", time);
        model.addAttribute("pidiao", pidiao);
        return "stock/pidiao/detial";
    }

    @ResponseBody
    @RequestMapping(value = "/selectPidiao")
    public List<PidiaoDO> selectPidiao(String pidiaoNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        List<PidiaoDO> pidiaoDOList = pidiaoService.selectPidiao(map);
        model.addAttribute("pidiaoDOList", pidiaoDOList);
        return pidiaoDOList;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("stock:pidiao:add")
    public R save(PidiaoDO pidiao, StockDO stockDO, Model model) {
        String[] usecounts = pidiao.getUseCount().split(",");
        String[] num = pidiao.getGoodsNum().split(",");
        String[] kyshuliangs = pidiao.getGoodsCount().split(",");
        String usecount;
        String kyshuliang = null;
        for (int i = 0; i < num.length; i++) {
            try {
                usecount = usecounts[i];
                kyshuliang = kyshuliangs[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                usecount = "";
            }
            if ("".equals(usecount)) {
                return R.error("数量不能为空！");
            } else if (Integer.valueOf(usecount) > Integer.valueOf(kyshuliang)) {
                return R.error("数量不能大于可用库存！");
            }
        }
        String pidiaoNumber = pidiao.getPidiaoNumber();
        String zhidanPeople = pidiao.getZhidanPeople();
        String danjuDay = pidiao.getDanjuDay();
        String outDepartment = pidiao.getOutDepartment();
        String outPosition = pidiao.getOutPosition();
        String inCompany = pidiao.getInCompany();
        String inDepartment = pidiao.getInDepartment();
        String inPosition = pidiao.getInPosition();
        String beizhu = pidiao.getBeizhu();
        String status = pidiao.getStatus();
        String shTime = pidiao.getShTime();
        String retyrnzt = pidiao.getReturnzt();


        String str = pidiao.getGoodsNum();
        String[] name = str.split(",");
        String[] goodsName1 = pidiao.getGoodsName().split(",");
        String[] factory1 = pidiao.getFactory().split(",");
        String[] goodsCount1 = pidiao.getGoodsCount().split(",");
        String[] useCount1 = pidiao.getUseCount().split(",");
        String[] goodsCode1 = pidiao.getGoodsCode().split(",");
        String[] useday1 = pidiao.getUseday().split(",");
        String[] batch1 = pidiao.getBatch().split(",");
        String[] zhuceNumber1 = pidiao.getZhuceNumber().split(",");
        String[] produceDay1 = pidiao.getProduceDay().split(",");
        String[] classtype1 = pidiao.getClasstype().split(",");

        String[] goods1 = pidiao.getGoods().split(",");


        String[] mfrsid1 = pidiao.getMfrsid().split(",");
        String[] brandname1 = pidiao.getBrandname().split(",");
        String[] unit1 = pidiao.getUnit().split(",");
        String[] money1 = pidiao.getMoney().split(",");
//        String[] goodsxinxiid1 = pidiao.getGoodsxinxiid().split(",");
        String[] stockorder1 = pidiao.getStockorder().split(",");

        for (int i = 0; i < name.length; i++) {
            PidiaoDO pidiaoDO = new PidiaoDO();
            pidiaoDO.setPidiaoNumber(pidiaoNumber);
            pidiaoDO.setZhidanPeople(zhidanPeople);
            pidiaoDO.setDanjuDay(danjuDay);
            pidiaoDO.setOutDepartmentid(outDepartment);
            pidiaoDO.setOutPositionid(outPosition);
            pidiaoDO.setInCompanyid(inCompany);
            pidiaoDO.setInDepartmentid(inDepartment);
            pidiaoDO.setInPositionid(inPosition);
            pidiaoDO.setBeizhu(beizhu);
            pidiaoDO.setStatus(status);
            pidiaoDO.setShTime(shTime);
            pidiaoDO.setReturnzt(retyrnzt);


            String goodsNum = name[i];
            pidiaoDO.setGoodsNum(goodsNum);
            String goodsName = goodsName1[i];
            pidiaoDO.setGoodsName(goodsName);

            try {
                String factory = factory1[i];
                pidiaoDO.setFactory(factory);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setFactory("");
            }

            String goodsCount = goodsCount1[i];
            pidiaoDO.setGoodsCount(goodsCount);
            String useCount = useCount1[i];
            pidiaoDO.setUseCount(useCount);

            String goodsCode = goodsCode1[i];
            pidiaoDO.setGoodsCode(goodsCode);
            String useday = "";
            try {
                useday = useday1[i];
                pidiaoDO.setUseday(useday);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setUseday("");
            }
            try {
                String batch = batch1[i];
                pidiaoDO.setBatch(batch);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setBatch("");
            }
            try {
                String zhuceNumber = zhuceNumber1[i];
                pidiaoDO.setZhuceNumber(zhuceNumber);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setZhuceNumber("");
            }
            try {
                String produceDay = produceDay1[i];
                pidiaoDO.setProduceDay(produceDay);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setProduceDay("");
            }


            if (null != pidiao.getClasstype()) {
                try {
                    String classtype = classtype1[i];
                    pidiaoDO.setClasstype(classtype);
                } catch (ArrayIndexOutOfBoundsException e) {
                    pidiaoDO.setClasstype("");
                }
            } else {
                pidiaoDO.setClasstype("");
            }


            String goods = goods1[i];
            pidiaoDO.setGoods(goods);


            String mfrsid = mfrsid1[i];
            pidiaoDO.setMfrsid(mfrsid);
            String brandname = brandname1[i];
            pidiaoDO.setBrandname(brandname);
            String unit = unit1[i];
            pidiaoDO.setUnit(unit);
            String money = money1[i];
            pidiaoDO.setMoney(money);


//            try {
//                String goodsxinxiid = goodsxinxiid1[i];
//                pidiaoDO.setGoodsxinxiid(goodsxinxiid);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setGoodsxinxiid("");
//            }
            try {
                String stockorder = stockorder1[i];
                pidiaoDO.setStockorder(stockorder);
            } catch (ArrayIndexOutOfBoundsException e) {
                pidiaoDO.setStockorder("");
            }


            //减库存
            StockDO stockDOjiankucun = new StockDO();
            stockDOjiankucun.setPositionId(pidiao.getOutPosition());
            stockDOjiankucun.setGoodsNum(goodsNum);
            stockDOjiankucun.setGoodsCode(goodsCode);
            stockDOjiankucun.setMfrsid(mfrsid);
            stockDOjiankucun.setBrandname(brandname);
            StockDO jianJJGoodsList = stockService.haveNum(stockDOjiankucun);
            if (null != jianJJGoodsList) {
                String gdcount = jianJJGoodsList.getGoodsCount();
                Integer goodsCountNew = Integer.valueOf(useCount);
                Integer gdcountNew = Integer.valueOf(gdcount);
                Integer newGoodsCount = gdcountNew - goodsCountNew;
                stockDOjiankucun.setGoodsCount(String.valueOf(newGoodsCount));
                stockService.updateGoodsCount(stockDOjiankucun);//修改数量

                ///log
                StocklogDO stocklogDO = new StocklogDO();
                stocklogDO.setDanjunum(pidiaoNumber);
                stocklogDO.setNum(pidiaoDO.getGoodsNum());
                stocklogDO.setCode(pidiaoDO.getGoodsCode());
                stocklogDO.setName(pidiaoDO.getGoodsName());
                stocklogDO.setGoodsid(Integer.valueOf(pidiaoDO.getGoods()));
                stocklogDO.setMfrsnum(pidiaoDO.getMfrsid());
                stocklogDO.setBrandname(pidiaoDO.getBrandname());
                stocklogDO.setMoney(pidiaoDO.getMoney());
                stocklogDO.setUseday(pidiaoDO.getUseday());
                stocklogDO.setBacth(pidiaoDO.getBatch());
                stocklogDO.setCounts(String.valueOf(goodsCountNew));
                stocklogDO.setInpositionId(Long.valueOf(pidiaoDO.getInPositionid()));
                stocklogDO.setOutpositionId(Long.valueOf(pidiaoDO.getOutPositionid()));
                stocklogDO.setZhidanPeople(pidiaoDO.getZhidanPeople());
//                //———获取当前系统时间—————
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date date = new Date();
                String newDate = sdf.format(date);
                stocklogDO.setDay(newDate);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                stocklogDO.setWay("批调出库");
                //———获取当前登录用户的工号————
                stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                stocklogService.save(stocklogDO);
            }
//			批调单保存
            pidiaoService.save(pidiaoDO);
        }
        return R.ok();
    }


//    @GetMapping("/edit/{id}")
//    @RequiresPermissions("stock:pidiao:edit")
//    String edit(@PathVariable("id") Long id, Model model) {
//        PidiaoDO pidiao = pidiaoService.get(id);
////		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = pidiao.getDanjuDay();
////		String danjuDay = sdftime.format(time);
//        model.addAttribute("danjuDay", time);
//        model.addAttribute("pidiao", pidiao);
//        return "stock/pidiao/edit";
//    }
//    /**
//     * 修改保存
//     */
//    @ResponseBody
//    @PostMapping("/editSave")
//    @RequiresPermissions("stock:pidiao:add")
//    public R editSave(PidiaoDO pidiao, StockDO stockDO,Model model) {
//       String[] usecounts =pidiao.getUseCount().split(",");
//       String[] num =pidiao.getGoodsNum().split(",");
//       String[] kyshuliangs =pidiao.getGoodsCount().split(",");
//       String usecount;
//        String kyshuliang = null;
//       for (int i=0; i<num.length;i++){
//           try {
//                 usecount = usecounts[i];
//               kyshuliang = kyshuliangs[i];
//           }catch (ArrayIndexOutOfBoundsException e){
//               usecount="";
//           }
//           if ("".equals(usecount)){
//               return R.error("数量不能为空！");
//           }else if(Integer.valueOf(usecount) > Integer.valueOf(kyshuliang)){
//               return R.error("数量不能大于可用库存！");
//           }
//       }
//        Map<String,Object> editmap=new HashMap<>();
//        String pidiaonum=pidiao.getPidiaoNumber();
//        editmap.put("pidiaonum",pidiaonum);
//        List<PidiaoDO> orderDOList=pidiaoService.haveOrderNum(editmap);
//        for (PidiaoDO orderDO1:orderDOList){
//            Long ids=orderDO1.getId();
//            pidiaoService.remove(ids);
//        }
//        String pidiaoNumber = pidiao.getPidiaoNumber();
//        String zhidanPeople = pidiao.getZhidanPeople();
//        String danjuDay = pidiao.getDanjuDay();
//        String outDepartment = pidiao.getOutDepartment();
//        String outPosition = pidiao.getOutPosition();
//        String inCompany = pidiao.getInCompany();
//        String inDepartment = pidiao.getInDepartment();
//        String inPosition = pidiao.getInPosition();
//        String beizhu = pidiao.getBeizhu();
//        String status = pidiao.getStatus();
//        String shTime = pidiao.getShTime();
//        String retyrnzt = pidiao.getReturnzt();
//
//
//        String str = pidiao.getGoodsNum();
//        String[] name = str.split(",");
//        String[] goodsName1 = pidiao.getGoodsName().split(",");
//        String[] factory1 = pidiao.getFactory().split(",");
//        String[] goodsCount1 = pidiao.getGoodsCount().split(",");
//        String[] useCount1 = pidiao.getUseCount().split(",");
//        String[] goodsCode1 = pidiao.getGoodsCode().split(",");
//        String[] useday1 = pidiao.getUseday().split(",");
//        String[] batch1 = pidiao.getBatch().split(",");
//        String[] zhuceNumber1 = pidiao.getZhuceNumber().split(",");
//        String[] produceDay1 = pidiao.getProduceDay().split(",");
//        String[] classtype1 = pidiao.getClasstype().split(",");
//
//        String[] goods1 = pidiao.getGoods().split(",");
//
//
//        String[] mfrsid1 = pidiao.getMfrsid().split(",");
//        String[] brandname1 = pidiao.getBrandname().split(",");
//        String[] unit1 = pidiao.getUnit().split(",");
//        String[] money1 = pidiao.getMoney().split(",");
//        String[] goodsxinxiid1 = pidiao.getGoodsxinxiid().split(",");
//        String[] stockorder1 = pidiao.getStockorder().split(",");
//
//        for (int i = 0; i < name.length; i++) {
//            PidiaoDO pidiaoDO = new PidiaoDO();
//            pidiaoDO.setPidiaoNumber(pidiaoNumber);
//            pidiaoDO.setZhidanPeople(zhidanPeople);
//            pidiaoDO.setDanjuDay(danjuDay);
//            pidiaoDO.setOutDepartmentid(outDepartment);
//            pidiaoDO.setOutPositionid(outPosition);
//            pidiaoDO.setInCompanyid(inCompany);
//            pidiaoDO.setInDepartmentid(inDepartment);
//            pidiaoDO.setInPositionid(inPosition);
//            pidiaoDO.setBeizhu(beizhu);
//            pidiaoDO.setStatus(status);
//            pidiaoDO.setShTime(shTime);
//            pidiaoDO.setReturnzt(retyrnzt);
//
//
//            String goodsNum = name[i];
//            pidiaoDO.setGoodsNum(goodsNum);
//            String goodsName = goodsName1[i];
//            pidiaoDO.setGoodsName(goodsName);
//
//            try {
//                String factory = factory1[i];
//                pidiaoDO.setFactory(factory);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setFactory("");
//            }
//
//            String goodsCount = goodsCount1[i];
//            pidiaoDO.setGoodsCount(goodsCount);
//            String useCount = useCount1[i];
//            pidiaoDO.setUseCount(useCount);
//
//            String goodsCode = goodsCode1[i];
//            pidiaoDO.setGoodsCode(goodsCode);
//            String useday = "";
//            try {
//                useday = useday1[i];
//                pidiaoDO.setUseday(useday);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setUseday("");
//            }
//            try {
//                String batch = batch1[i];
//                pidiaoDO.setBatch(batch);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setBatch("");
//            }
//            try {
//                String zhuceNumber = zhuceNumber1[i];
//                pidiaoDO.setZhuceNumber(zhuceNumber);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setZhuceNumber("");
//            }
//            try {
//                String produceDay = produceDay1[i];
//                pidiaoDO.setProduceDay(produceDay);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setProduceDay("");
//            }
//
//
//            if (null != pidiao.getClasstype()) {
//                try {
//                    String classtype = classtype1[i];
//                    pidiaoDO.setClasstype(classtype);
//                } catch (ArrayIndexOutOfBoundsException e) {
//                    pidiaoDO.setClasstype("");
//                }
//            } else {
//                pidiaoDO.setClasstype("");
//            }
//
//
//            String goods = goods1[i];
//            pidiaoDO.setGoods(goods);
//
//
//            String mfrsid = mfrsid1[i];
//            pidiaoDO.setMfrsid(mfrsid);
//            String brandname = brandname1[i];
//            pidiaoDO.setBrandname(brandname);
//            String unit = unit1[i];
//            pidiaoDO.setUnit(unit);
//            String money = money1[i];
//            pidiaoDO.setMoney(money);
//
//
//            try {
//                String goodsxinxiid = goodsxinxiid1[i];
//                pidiaoDO.setGoodsxinxiid(goodsxinxiid);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setGoodsxinxiid("");
//            }
//            try {
//                String stockorder = stockorder1[i];
//                pidiaoDO.setStockorder(stockorder);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                pidiaoDO.setStockorder("");
//            }
//
//
//
//            //减库存
//            StockDO stockDOjiankucun = new StockDO();
//            stockDOjiankucun.setPositionId(pidiao.getOutPosition());
//            stockDOjiankucun.setGoodsNum(goodsNum);
//            stockDOjiankucun.setGoodsCode(goodsCode);
//            stockDOjiankucun.setMfrsid(mfrsid);
//            stockDOjiankucun.setBrandname(brandname);
//            StockDO jianJJGoodsList = stockService.haveNum(stockDOjiankucun);
//            if (null != jianJJGoodsList) {
//                String gdcount = jianJJGoodsList.getGoodsCount();
//                Integer goodsCountNew = Integer.valueOf(useCount);
//                Integer gdcountNew = Integer.valueOf(gdcount);
//                Integer newGoodsCount = gdcountNew - goodsCountNew;
//                stockDOjiankucun.setGoodsCount(String.valueOf(newGoodsCount));
//                stockService.updateGoodsCount(stockDOjiankucun);//修改数量
//
//                ///log
//                StocklogDO stocklogDO=new StocklogDO();
//                stocklogDO.setDanjunum(pidiaoNumber);
//                stocklogDO.setNum(pidiaoDO.getGoodsNum());
//                stocklogDO.setCode(pidiaoDO.getGoodsCode());
//                stocklogDO.setName(pidiaoDO.getGoodsName());
//                stocklogDO.setGoodsid(Integer.valueOf(pidiaoDO.getGoods()));
//                stocklogDO.setMfrsnum(pidiaoDO.getMfrsid());
//                stocklogDO.setBrandname(pidiaoDO.getBrandname());
//                stocklogDO.setMoney(pidiaoDO.getMoney());
//                stocklogDO.setUseday(pidiaoDO.getUseday());
//                stocklogDO.setBacth(pidiaoDO.getBatch());
//                stocklogDO.setCounts(String.valueOf(goodsCountNew));
//                stocklogDO.setInpositionId(Long.valueOf(pidiaoDO.getInPositionid()));
//                stocklogDO.setOutpositionId(Long.valueOf(pidiaoDO.getOutPositionid()));
//                stocklogDO.setZhidanPeople(pidiaoDO.getZhidanPeople());
////                //———获取当前系统时间—————
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                Date date = new Date();
//                String newDate = sdf.format(date);
//                stocklogDO.setDay(newDate);
////                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
//                stocklogDO.setWay("批调出库");
//                //———获取当前登录用户的工号————
//                stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
//                stocklogService.save(stocklogDO);
//            }
////			批调单保存
//            pidiaoService.save(pidiaoDO);
//        }
//        return R.ok();
//    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("stock:pidiao:edit")
    public R update(PidiaoDO pidiao) {
        pidiaoService.update(pidiao);
        return R.ok();
    }

    /**
     * 退回
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("stock:pidiao:remove")
    public R remove(String pidiaoNumber) {
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        List<PidiaoDO> returnList = pidiaoService.returnList(map);
        for (PidiaoDO pidiaoDO : returnList) {

            StockDO stockDO = new StockDO();
            String goodsNum = pidiaoDO.getGoodsNum();
            stockDO.setGoodsNum(goodsNum);
            String positionId = pidiaoDO.getOutPositionid();
            stockDO.setPositionId(positionId);
            String useCount = pidiaoDO.getUseCount();//退回数量
            StockDO returnJia = stockService.haveNum(stockDO);
            if (null != returnJia) {
                String kcCount = returnJia.getGoodsCount();
                Integer returnCount = Integer.valueOf(useCount);
                Integer kccountall = Integer.valueOf(kcCount);
                Integer newCount = kccountall + returnCount;
                stockDO.setGoodsCount(String.valueOf(newCount));
                stockDO.setReturnzt("0");
                //———退货号————
                String tuihuoNumber = pidiaoDO.getPidiaoNumber();
                stockDO.setTuihuoNumber(tuihuoNumber);
                stockDO.setUsername(ShiroUtils.getUser().getUsername());
                stockService.updateGoodsCount(stockDO);//修改数量


                pidiaoDO.setReturnzt("0");
                pidiaoDO.setUsername(ShiroUtils.getUser().getUsername());
                //———获取当前系统时间—————
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date date = new Date();
                String newDate = sdf.format(date);
                pidiaoDO.setShTime(newDate);
                pidiaoService.updatereturnzt(pidiaoDO);


                ///log
                StocklogDO stocklogDO = new StocklogDO();
                stocklogDO.setDanjunum(pidiaoNumber);
                stocklogDO.setNum(pidiaoDO.getGoodsNum());
                stocklogDO.setCode(pidiaoDO.getGoodsCode());
                stocklogDO.setName(pidiaoDO.getGoodsName());
                stocklogDO.setGoodsid(Integer.valueOf(pidiaoDO.getGoods()));
                stocklogDO.setMfrsnum(pidiaoDO.getMfrsid());
                stocklogDO.setBrandname(pidiaoDO.getBrandname());
                stocklogDO.setMoney(pidiaoDO.getMoney());
                stocklogDO.setUseday(pidiaoDO.getUseday());
                stocklogDO.setBacth(pidiaoDO.getBatch());
                stocklogDO.setCounts(String.valueOf(useCount));
                stocklogDO.setInpositionId(Long.valueOf(pidiaoDO.getInPositionid()));
                stocklogDO.setOutpositionId(Long.valueOf(pidiaoDO.getOutPositionid()));
                stocklogDO.setZhidanPeople(pidiaoDO.getZhidanPeople());
                stocklogDO.setDay(newDate);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                stocklogDO.setWay("批调退回");
                stocklogDO.setUsername(ShiroUtils.getUser().getUsername());
                stocklogService.save(stocklogDO);

            }
//            一定会有才会批调
//            else {
//                String goodsCode = pidiaoDO.getGoodsCode();
//                stockDO.setGoodsCode(goodsCode);
//                String goodsName = pidiaoDO.getGoodsName();
//                stockDO.setGoodsName(goodsName);
//                stockDO.setGoodsCount(useCount);
//                String goodsType = pidiaoDO.getGoodsType();
//                stockDO.setGoodsType(Integer.valueOf(goodsType));
//                String mfrsid = pidiaoDO.getMfrsid();
//                stockDO.setMfrsid(mfrsid);
//                String brandname = pidiaoDO.getBrandname();
//                stockDO.setBrandname(brandname);
//                String unit = pidiaoDO.getUnit();
//                stockDO.setUnit(unit);
//                String retailPrice = pidiaoDO.getRetailPrice();
//                stockDO.setRetailPrice(retailPrice);
//                String createTime = pidiaoDO.getCreateTime();
//                stockDO.setCreateTime(createTime);
//                String danjuNumber = pidiaoDO.getPidiaoNumber();
//                stockDO.setDanjuNumber(danjuNumber);
//                String zhidanPeople = pidiaoDO.getZhidanPeople();
//                stockDO.setZhidanPeople(zhidanPeople);
//                String danjuDay = pidiaoDO.getCreateTime();
//                stockDO.setDanjuDay(danjuDay);
//                String zhuceNumber = pidiaoDO.getZhuceNumber();
//                stockDO.setZhuceNumber(zhuceNumber);
//                String classtype = pidiaoDO.getClasstype();
//                stockDO.setClasstype(classtype);
//                String factory = pidiaoDO.getFactory();
//                stockDO.setFactory(factory);
//                stockDO.setStatus("0");
//                stockDO.setReturnzt("0");
//                //———退货号————
//                String tuihuoNumber = pidiaoDO.getPidiaoNumber();
//                stockDO.setTuihuoNumber(tuihuoNumber);
//                String username = pidiaoDO.getUsername();
//                stockDO.setUsername(username);
//                if (stockService.save(stockDO) < 0) {
//                    return R.error();
//                }
//                pidiaoDO.setReturnzt("0");
//                pidiaoService.updatereturnzt(pidiaoDO);
//            }

        }
        return R.ok();
    }

    //打印
    @GetMapping("/pidiaodan")
    @RequiresPermissions("stock:pidiao:pidiaodan")
    String pidiaodan(String pidiaoNumber, Model model) {
        PidiaoDO getpidiao = pidiaoService.getpidiao(pidiaoNumber);
//		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = getpidiao.getDanjuDay();
//		String danjuDay = sdftime.format(time);
        model.addAttribute("danjuDay", time);
        model.addAttribute("getpidiao", getpidiao);
        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newday = sdf.format(date);
        model.addAttribute("newday", newday);
        return "/stock/pidiao/pidiaodan";
    }

    //打印List
    @ResponseBody
    @RequestMapping(value = "/getpidiaoList")
    public List<PidiaoDO> getpidiaoList(String pidiaoNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        List<PidiaoDO> pidiaoDOList = pidiaoService.getpidiaoList(map);
        model.addAttribute("pidiaoDOList", pidiaoDOList);
        return pidiaoDOList;
    }

    /**
     * 工号
     */
    @GetMapping("/userNum/{pidiaoNumber}")
    String userNum(@PathVariable("pidiaoNumber") String pidiaoNumber, Model model) {
        model.addAttribute("pidiaoNumber", pidiaoNumber);
        return "/stock/pidiao/userNum";
    }

    /**
     * 收货添加库存
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public R updateEnable(String pidiaoNumber, String status, String username, StockDO stockDO) {
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        List<PidiaoDO> pidiaodan = pidiaoService.pidiaodan(map);
        for (PidiaoDO pidiaoDO : pidiaodan) {
            String goodsCount = pidiaoDO.getUseCount();//批调数量
            //加库存
            stockDO.setPositionId(String.valueOf(pidiaoDO.getInPositionid()));
            stockDO.setGoodsNum(pidiaoDO.getGoodsNum());
            stockDO.setGoodsCode(pidiaoDO.getGoodsCode());
            stockDO.setMfrsid(pidiaoDO.getMfrsid());
            stockDO.setBrandname(pidiaoDO.getBrandname());
            stockDO.setUseday(pidiaoDO.getUseday());
            StockDO jiaGoodsList = stockService.haveNum(stockDO);
            if (null != jiaGoodsList) {

                String gdcount = jiaGoodsList.getGoodsCount();
                Integer goodsCountNew = Integer.valueOf(goodsCount);
                Integer gdcountNew = Integer.valueOf(gdcount);
                Integer newGoodsCount = gdcountNew + goodsCountNew;
                stockDO.setGoodsCount(String.valueOf(newGoodsCount));
                stockService.updateGoodsCount(stockDO);//修改数量


                PidiaoDO pidiaoDO1 = new PidiaoDO();
                pidiaoDO1.setPidiaoNumber(pidiaoNumber);
                pidiaoDO1.setStatus(status);
                pidiaoDO1.setUsername(username);
                //———获取当前系统时间—————
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date date = new Date();
                String shTime = sdf.format(date);
                pidiaoDO1.setShTime(shTime);

                pidiaoDO1.setStockorder(jiaGoodsList.getDanjuNumber());
                pidiaoService.updateStatus(pidiaoDO1);

                StockDO stockDO1 = new StockDO();
                stockDO1.setDanjuNumber(pidiaoNumber);
                stockDO1.setStatus(status);
                stockDO1.setUsername(username);
                stockDO1.setZhidanPeople(pidiaoDO.getZhidanPeople());
                stockService.updateStatus(stockDO1);

                ///log
                StocklogDO stocklogDO = new StocklogDO();
                stocklogDO.setDanjunum(pidiaoNumber);
                stocklogDO.setNum(pidiaoDO.getGoodsNum());
                stocklogDO.setCode(pidiaoDO.getGoodsCode());
                stocklogDO.setName(pidiaoDO.getGoodsName());
                stocklogDO.setGoodsid(Integer.valueOf(pidiaoDO.getGoods()));
                stocklogDO.setMfrsnum(pidiaoDO.getMfrsid());
                stocklogDO.setBrandname(pidiaoDO.getBrandname());
                stocklogDO.setMoney(pidiaoDO.getMoney());
                stocklogDO.setUseday(pidiaoDO.getUseday());
                stocklogDO.setBacth(pidiaoDO.getBatch());
                stocklogDO.setCounts(String.valueOf(goodsCount));
                stocklogDO.setInpositionId(Long.valueOf(pidiaoDO.getInPositionid()));
                stocklogDO.setOutpositionId(Long.valueOf(pidiaoDO.getOutPositionid()));
                stocklogDO.setZhidanPeople(pidiaoDO.getZhidanPeople());
//                //———获取当前系统时间—————
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
//                Date date = new Date();
//                String newDate = sdf.format(date);
                stocklogDO.setDay(shTime);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                stocklogDO.setWay("批调收货");
                stocklogDO.setUsername(username);
                stocklogService.save(stocklogDO);
            } else {
                stockDO.setGoodsCode(pidiaoDO.getGoodsCode());
                stockDO.setGoodsName(pidiaoDO.getGoodsName());
                stockDO.setGoodsCount(goodsCount);
                stockDO.setGoodsType(Integer.valueOf(pidiaoDO.getGoods()));

                stockDO.setMfrsid(pidiaoDO.getMfrsid());
                stockDO.setBrandname(pidiaoDO.getBrandname());
                stockDO.setUnit(pidiaoDO.getUnit());
                stockDO.setRetailPrice(pidiaoDO.getMoney());
                stockDO.setStatus(pidiaoDO.getStatus());
                stockDO.setReturnzt(pidiaoDO.getReturnzt());
                stockDO.setDanjuNumber(pidiaoNumber);
                stockDO.setCreateTime(pidiaoDO.getDanjuDay());
                stockDO.setDanjuDay(pidiaoDO.getDanjuDay());

                try {
                    stockDO.setUseday(pidiaoDO.getUseday());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setUseday("");
                }
                try {
                    stockDO.setBatch(pidiaoDO.getBatch());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setBatch("");
                }
                try {
                    stockDO.setZhuceNumber(pidiaoDO.getZhuceNumber());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setZhuceNumber("");
                }
                try {
                    stockDO.setProduceDay(pidiaoDO.getProduceDay());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setProduceDay("");
                }
                try {
                    stockDO.setClasstype(pidiaoDO.getClasstype());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setClasstype("");
                }


                try {
                    stockDO.setFactory(pidiaoDO.getFactory());
                } catch (ArrayIndexOutOfBoundsException e) {
                    stockDO.setFactory("");
                }
                stockDO.setGoodsxinxiid(pidiaoDO.getGoodsxinxiid());
                ///log
                StocklogDO stocklogDO = new StocklogDO();
                stocklogDO.setDanjunum(pidiaoNumber);
                stocklogDO.setNum(pidiaoDO.getGoodsNum());
                stocklogDO.setCode(pidiaoDO.getGoodsCode());
                stocklogDO.setName(pidiaoDO.getGoodsName());
                stocklogDO.setGoodsid(Integer.valueOf(pidiaoDO.getGoods()));
                stocklogDO.setMfrsnum(pidiaoDO.getMfrsid());
                stocklogDO.setBrandname(pidiaoDO.getBrandname());
                stocklogDO.setMoney(pidiaoDO.getMoney());
                stocklogDO.setUseday(pidiaoDO.getUseday());
                stocklogDO.setBacth(pidiaoDO.getBatch());
                stocklogDO.setCounts(goodsCount);
                stocklogDO.setInpositionId(Long.valueOf(pidiaoDO.getInPositionid()));
                stocklogDO.setOutpositionId(Long.valueOf(pidiaoDO.getOutPositionid()));
                stocklogDO.setZhidanPeople(pidiaoDO.getZhidanPeople());
//                //———获取当前系统时间—————
                SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                Date dates = new Date();
                String newDate = sdfs.format(dates);
                stocklogDO.setDay(newDate);
//                    stocklogDO.setWay(orderkc.getZhidanPeople()+"批调"+orderkc.getGoodsCount()+"个"+orderkc.getGoodsName());
                stocklogDO.setWay("批调收货");
                stocklogDO.setUsername(username);
                stocklogService.save(stocklogDO);
                if (stockService.save(stockDO) > 0) {
                    PidiaoDO pidiaoDO1 = new PidiaoDO();
                    pidiaoDO1.setPidiaoNumber(pidiaoNumber);
                    pidiaoDO1.setStatus(status);
                    pidiaoDO1.setUsername(username);
                    //———获取当前系统时间—————
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
                    Date date = new Date();
                    String shTime = sdf.format(date);
                    pidiaoDO1.setShTime(shTime);
                    if ("".equals(jiaGoodsList)) {
                        pidiaoDO1.setStockorder(pidiaoDO.getDanjuNumber());
                    } else {
                        pidiaoDO1.setStockorder(pidiaoDO.getDanjuNumber());
                    }
                    pidiaoService.updateStatus(pidiaoDO1);

                    StockDO stockDO1 = new StockDO();
                    stockDO1.setDanjuNumber(pidiaoNumber);
                    stockDO1.setStatus(status);
                    stockDO1.setUsername(username);
                    stockDO1.setZhidanPeople(pidiaoDO.getZhidanPeople());
                    stockService.updateStatus(stockDO1);

                }
            }
        }
        return R.ok();
    }

    //    //总数量
    @ResponseBody
    @GetMapping("/countall")
    public Integer countall(
            @RequestParam("pidiaoNumber") String pidiaoNumber, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        int total = pidiaoService.countall(map);
        model.addAttribute("total", total);
        return total;
    }


    /**
     * 浏览器打印二维码一个
     */
    @GetMapping("/codeOne")
    public String codeOne(String pidiaoNumber, String codeOne, Model model) {
        String goods = codeOne.substring(0, 1);
        Map<String, Object> map = new HashMap<>();
        map.put("pidiaoNumber", pidiaoNumber);
        map.put("codeOne", codeOne);
        List<PidiaoDO> pidiaoDOS = pidiaoService.getCode(map);
        model.addAttribute("pidiaoDOS", pidiaoDOS);
        for (PidiaoDO pidiaoDO : pidiaoDOS) {
            String code = QRCodeUtil.creatRrCode(pidiaoDO.getGoodsCode(), 200, 200);
            code = "data:image/png;base64," + code;
            pidiaoDO.setQRCode(code);
        }
//        for (int i =0;i<1;i++) {
//            PidiaoDO pidiao=pidiaoDOS.get(i);
//            String code = QRCodeUtil.creatRrCode(pidiao.getGoodsCode(), 200, 200);
//            code = "data:image/png;base64," + code;
//            pidiao.setQRCode(code);
//        }

        if ("1".equals(goods)) {
            return "/stock/pidiao/codeJingjiaOne";
        } else {
            return "/stock/pidiao/codeOne";
        }
    }

    /**
     * 条码扫描
     */
    @GetMapping("/barcode/{outPosition}")
    String barcode(@PathVariable("outPosition") String outPosition,
                       Model model){
        model.addAttribute("outPosition",outPosition);

        return "stock/pidiao/barcode";
    }

    @ResponseBody
    @RequestMapping(value = "/codeList")
    List<?> codeList(String outPosition,String goodsCode,  Model model) {
        Map<String,Object> map = new HashMap<>();
        map.put("outPosition",outPosition);
        map.put("goodsCode",goodsCode);
        List<StockDO> stockDOS = stockService.kccxList(map);
        return stockDOS;
    }
}


