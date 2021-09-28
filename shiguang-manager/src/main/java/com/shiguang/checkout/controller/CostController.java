package com.shiguang.checkout.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import com.shiguang.common.utils.*;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/cost")
public class CostController {
    @Autowired
    private CostService costService;
    @Autowired
    private MemberService memberService;

    @GetMapping()
    @RequiresPermissions("information:cost:cost")
    String Cost(){
        return "checkout/cost";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:cost:cost")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
//        List<CostDO> costList = costService.list(query);
//        int total = costService.count(query);
//        PageUtils pageUtils = new PageUtils(costList, total);
        query.put("state",1);
        query.put("status","0");
        query.put("companyId",ShiroUtils.getUser().getCompanyId());
        List<MemberDO> memberDOList = memberService.list(query);
        int total = memberService.count(query);
        PageUtils pageUtils = new PageUtils(memberDOList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:cost:add")
    String add(){
        return "information/cost/add";
    }

    @GetMapping("/edit/{cardNumber}")
    @RequiresPermissions("information:cost:edit")
    String edit(@PathVariable("cardNumber") String cardNumber,Model model){
//        CostDO cost = costService.get(id);
//        model.addAttribute("cost", cost);
        model.addAttribute("cardNumber",cardNumber);
        return "checkout/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:cost:add")
    public R save( String cardNumber, String codeall){
        JSONArray json=JSONArray.parseArray(codeall);
        JSONObject jsonOne;
        CostDO cost = new CostDO();
        Long saleNumber =  GuuidUtil.getUUID();
        cost.setSaleNumber("X"+saleNumber);
        for (int i=0;i<json.size();i++) {
            jsonOne = json.getJSONObject(i);
            String key = (String) jsonOne.get("Key");
            String value = (String) jsonOne.get("Value");
            if ("code".equals(key)) {
                cost.setShorthandCode(value);
            }
            if ("costname".equals(key)) {
                cost.setCostName(value);
            }
            if ("costMoney".equals(key)) {
                cost.setMemberNumber(cardNumber);
                cost.setCostMoney(Double.parseDouble(value));
                cost.setCostType(0L);
                cost.setIsSale(0L);
                String username = ShiroUtils.getUser().getUsername();
                cost.setSaleName(username);
                cost.setCreateTime(new Date());
                cost.setType("检查单");
                cost.setStoreNum(ShiroUtils.getUser().getStoreNum());
                cost.setStoreName(ShiroUtils.getUser().getStore());
                costService.save(cost);
                String number = cost.getSaleNumber();
                cost = new CostDO();
                cost.setSaleNumber(number);
            }
        }
//        if(costService.save(cost)>0){
//            return R.ok();
//        }
        return R.ok();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:cost:edit")
    public R update( CostDO cost){
        costService.update(cost);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:cost:remove")
    public R remove( Long id){
        if(costService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:cost:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        costService.batchRemove(ids);
        return R.ok();
    }
}
