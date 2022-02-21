package com.shiguang.retailprice.controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private PidiaoService pidiaoService;
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
    //打印订单
    @GetMapping("/summary")
    String summary(Integer positionId, String settleDateStart,String settleDateEnd,String way,
                   String goods,String classtype,
                   String mfrsid, String brandname,String producName,String producNum, String status, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("positionId",positionId);
        map.put("settleDateStart",settleDateStart);
        map.put("settleDateEnd",settleDateEnd);
        map.put("way",way);
        map.put("goods",goods);
        map.put("classtype",classtype);
        map.put("mfrsid",mfrsid);
        map.put("brandname",brandname);
        map.put("producName",producName);
        map.put("producNum",producNum);
        map.put("status",status);
        if (goods.equals(1)){
           List<PidiaoDO> summary= pidiaoService.jingjiaSummary(map);
           model.addAttribute("summary",summary);
        }else if (goods.equals(2)){

        }else if (goods.equals(3) && classtype.equals(1)){

        }else if (goods.equals(3) && classtype.equals(2)){

        }else if (goods.equals(4) && classtype.equals(1)){

        }else if (goods.equals(4) && classtype.equals(2)){

        }else if (goods.equals(5)){

        }else if (goods.equals(6)){

        }else if (goods.equals(7)){

        }else if (goods.equals(8)){

        }else if (goods.equals(9)){

        }

        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("newDate", newDate);
        return "/retailprice/stockPidiaoAll/summary";
    }
}
