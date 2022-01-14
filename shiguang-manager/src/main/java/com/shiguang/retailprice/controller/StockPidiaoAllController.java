package com.shiguang.retailprice.controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 批调统计表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
 
@Controller
@RequestMapping("/stockPidiaoAll/stockPidiaoAll")
public class StockPidiaoAllController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PositionService positionService;
@GetMapping()
@RequiresPermissions("stockPidiaoAll:stockPidiaoAll:stockPidiaoAll")
String stockPidiaoAll(Model model) {
    Map<String, Object> map = new HashMap<>();
    //商品
    List<GoodsDO> goodsDOList = goodsService.list(map);
    model.addAttribute("goodsDOList", goodsDOList);
    //仓位
    //———获取当前登录用户的公司id————
    String companyId= ShiroUtils.getUser().getCompanyId();
    if(companyId == null){
        String departNumber=ShiroUtils.getUser().getStoreNum();
        map.put("departNumber",departNumber);
    }else if (companyId != null){
        map.put("companyId",companyId);
    }
    List<PositionDO> positionDOList = positionService.list(map);
    model.addAttribute("positionDOList", positionDOList);
    return "retailprice/stockPidiaoAll/stockPidiaoAll";
}
}
