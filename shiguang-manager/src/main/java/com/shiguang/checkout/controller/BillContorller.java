package com.shiguang.checkout.controller;

import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.settlement.domain.SettlementDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/bill")
public class BillContorller {
    @Autowired
    private CostService costService;
    @GetMapping()
    @RequiresPermissions("information:bill:bill")
    String Cost(){
        return "checkout/bill";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:bill:bill")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//        List<CostDO> costList = costService.list(query);
//        int total = costService.count(query);
//        PageUtils pageUtils = new PageUtils(costList, total);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("createTime",simpleDateFormat.format(new Date()));
        List<CostDO> costDOList = costService.costlist(query);
        if (null != costDOList && costDOList.size() > 0){
            for (CostDO costDO : costDOList){
                if (costDO.getSex() == 0){
                    costDO.setSexx("男");
                } else if (costDO.getSex() == 1){
                    costDO.setSexx("女");
                }
            }
        }
        int total = costService.costcount(query);
        PageUtils pageUtils = new PageUtils(costDOList, total);
        return pageUtils;
    }

    @GetMapping("/detail/{saleNumber}")
    @RequiresPermissions("information:bill:detail")
    String detail(@PathVariable("saleNumber") String saleNumber,Model model){
        List<CostDO> costDOList = costService.getSaleNumber(saleNumber);
         if (null != costDOList && costDOList.size() > 0){
             model.addAttribute("memberNumber",costDOList.get(0).getMemberNumber());
             model.addAttribute("memberName",costDOList.get(0).getMemberName());
         }
        model.addAttribute("costList",costDOList);
        return "checkout/detail";
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:bill:remove")
    public R remove(String saleNumber){
        List<CostDO> costDOList = costService.getSaleNumber(saleNumber);
        if (null != costDOList &&costDOList.size() > 0){
            for (CostDO costDO : costDOList){
                costService.remove(costDO.getId());
            }
            return R.ok();
        }
        return R.error();
    }
}
