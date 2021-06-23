package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.CardTypeDO;
import com.shiguang.baseinfomation.service.CardTypeService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("CardTypeController")
@RequestMapping("/information/cardType")
public class CardTypeController {
    @Autowired
    private CardTypeService typeService;

    @GetMapping()
    @RequiresPermissions("information:cardType:cardType")
    String Type(){
        return "baseinfomation/cardType/cardType";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:cardType:cardType")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("status",1);
        List<CardTypeDO> typeList = typeService.list(query);
        if (null != typeList && typeList.size() > 0){
            for (CardTypeDO cardTypeDO : typeList){
                cardTypeDO.setIntegerFirst(cardTypeDO.getIntegerFirst() +"～"+cardTypeDO.getIntegerLast());
            }
        }
        int total = typeService.count(query);
        PageUtils pageUtils = new PageUtils(typeList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:cardType:add")
    String add(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        return "baseinfomation/cardType/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:cardType:edit")
    String edit(@PathVariable("id") Long id, Model model){
        CardTypeDO type = typeService.get(id);
        model.addAttribute("type", type);
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        List<CardTypeDO> cardTypeDOList = typeService.list(map);
        model.addAttribute("cardTypeDOList",cardTypeDOList);
        return "baseinfomation/cardType/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:cardType:add")
    public R save(CardTypeDO type){
        String cardName = type.getCardName();
        Map<String,Object> map = new HashMap<>();
        map.put("cardName",cardName);
        List<CardTypeDO> list = typeService.list(map);
        if (list.size() > 0){
            return R.error("会员卡名称已存在");
        }
        type.setStatus(1L);
        if(typeService.save(type)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:cardType:edit")
    public R update( CardTypeDO type){
        typeService.update(type);
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("information:cardType:remove")
    public R updateStatus( Long id){
        CardTypeDO cardTypeDO = new CardTypeDO();
        cardTypeDO.setStatus(0L);
        cardTypeDO.setId(id);
        if(typeService.updateStatus(cardTypeDO)>0){
            return R.ok();
        }
        return R.error();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:cardType:remove")
//    public R remove( Long id){
//        if(typeService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:cardType:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        typeService.batchRemove(ids);
        return R.ok();
    }
}
