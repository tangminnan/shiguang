package com.shiguang.logstatus.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.domain.LogStatusDO;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mailInfo.domain.MailInfoDO;
import com.shiguang.mailInfo.service.MailInfoService;
import com.shiguang.settlement.domain.SettlementDO;
import com.shiguang.settlement.service.SettlementService;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import com.shiguang.storeSales.domain.Conclusion;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        query.put("logisticStatus","销售完成");
        List<SalesDO> salesDOList = statusService.findSaleAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
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
        MailInfoDO mailInfoDO = mailInfoService.getMailAddress(settlementDO.getSaleNumber());
        if (null != mailInfoDO){
            model.addAttribute("address",mailInfoDO.getAddress());
        } else {
            model.addAttribute("address","");
        }
        SettlementDO settlementDO1 = settlementService.getSaleNumers(saleNumber);
        if (null != settlementDO1){
            if (settlementDO1.getPayModel() == 0){
                model.addAttribute("paymodel","微信");
            } else if (settlementDO1.getPayModel() == 1){
                model.addAttribute("paymodel","支付宝");
            } else if (settlementDO1.getPayModel() == 2){
                model.addAttribute("paymodel","医院收费处");
            } else if (settlementDO1.getPayModel() == 3){
                model.addAttribute("paymodel","一卡通");
            }
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
        return "logstatus/peijingdan";
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
        logStatusDO.setSaleNumber(status.getSaleNumber());
        logStatusDO.setLogisticStatus("发料");
        logStatusDO.setFaliaoDate(new Date());
        logStatusDO.setFaliaoName(ShiroUtils.getUser().getName());
        SalesDO salesDO = salesService.getSaleNumber(status.getSaleNumber());
        String storeDesc = salesDO.getStoreDescribe();
        String[] storeDescribe = storeDesc.split(",");
        String[] goodsNum = salesDO.getGoodsNum().split(",");
        for (int a=0;a<storeDescribe.length;a++){
            if (!"镜架".equals(storeDescribe[a])){
                StockDO stockDO = stockService.getGoodsNum(goodsNum[a]);
                Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                Long count = countGoods - 1;
                stockDO.setGoodsCount(String.valueOf(count));
                stockService.updateGoodsCount(stockDO);
            }
        }
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
        for (int a=0;a<storeDescribe.length;a++){
            if (storeDescribe[a] != "镜架"){
                StockDO stockDO = stockService.getGoodsNum(storeDescribe[a]);
                Long countGoods = Long.parseLong(stockDO.getGoodsCount());
                Long count = countGoods - 1;
                stockDO.setGoodsCount(String.valueOf(count));
                stockService.updateGoodsCount(stockDO);
            }
        }
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
}