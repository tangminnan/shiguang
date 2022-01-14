package com.shiguang.retailprice.controller;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 采购统计表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
 
@Controller
@RequestMapping("/stockOrderAll/stockOrderAll")
public class StockOrderAllController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private GoodsService goodsService;
@GetMapping()
@RequiresPermissions("stockOrderAll:stockOrderAll:stockOrderAll")
String stockOrderAll(Model model) {
    Map<String, Object> map = new HashMap<>();
    List<CompanyDO> companyList = companyService.list(map);
    model.addAttribute("companyList",companyList);
    List<GoodsDO> goodsList = goodsService.list(map);
    model.addAttribute("goodsList", goodsList);
    return "retailprice/stockOrderAll/stockOrderAll";
}

}
