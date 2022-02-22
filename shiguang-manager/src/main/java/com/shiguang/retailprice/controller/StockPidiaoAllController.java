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
import java.util.*;


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
                   String goods,String classtype, String mfrsid, String brandname,String producName,
//                   String producNum,
                   String status, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("positionId",positionId);
        map.put("settleDateStart",settleDateStart);
        map.put("settleDateEnd",settleDateEnd);
        map.put("goods",goods);
        map.put("classtype",classtype);
        map.put("mfrsid",mfrsid);
        map.put("brandname",brandname);
        map.put("producName",producName);
//        map.put("producNum",producNum);
        map.put("status",status);
//        List<Map<String, Object>> summary = new ArrayList<>();
        List<PidiaoDO> summary = new ArrayList<>();
        if (goods.equals("1")){
            summary= pidiaoService.jingjiaSummary(map);
//            List<PidiaoDO> jingjiaSummary= pidiaoService.jingjiaSummary(map);
//            for (PidiaoDO pidiaoDO:jingjiaSummary){
//                Map<String, Object> jingjiamap = new HashMap<>();
//                jingjiamap.put("goods", pidiaoDO.getGoods());
//                jingjiamap.put("mfrsid", pidiaoDO.getMfrsid());
//                jingjiamap.put("brandnum", pidiaoDO.getBrandnum());
//                jingjiamap.put("viewGoodName", pidiaoDO.getViewGoodName());
//                jingjiamap.put("unit", pidiaoDO.getUnit());
//                jingjiamap.put("needCount", pidiaoDO.getNeedCount());
//                jingjiamap.put("useCount", pidiaoDO.getUseCount());
//                jingjiamap.put("money", pidiaoDO.getMoney());
//                summary.add(jingjiamap);
//            }
        }else if (goods.equals("2")){
            summary= pidiaoService.peijianSummary(map);
        }else if (goods.equals("3") && classtype.equals("1")){
            summary= pidiaoService.jpcpSummary(map);
        }else if (goods.equals("3") && classtype.equals("2")){
            summary= pidiaoService.jpdzSummary(map);
        }else if (goods.equals("4") && classtype.equals("1")){
            summary= pidiaoService.yxcpSummary(map);
        }else if (goods.equals("4") && classtype.equals("2")){
            summary= pidiaoService.yxdzSummary(map);
        }else if (goods.equals("5")){
            summary= pidiaoService.hlySummary(map);
        }else if (goods.equals("6")){
            summary= pidiaoService.tyjSummary(map);
        }else if (goods.equals("7")){
            summary= pidiaoService.lhjSummary(map);
        }else if (goods.equals("8")){
            summary= pidiaoService.hcSummary(map);
        }else if (goods.equals("9")){
            summary= pidiaoService.sgSummary(map);
        }

        //———获取当前系统时间—————
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
        Date date = new Date();
        String newDate = sdf.format(date);
        model.addAttribute("newDate", newDate);
        model.addAttribute("summary",summary);
        if (way.equals("1")){
            return "/retailprice/stockPidiaoAll/summary";

        }else {
            return "/retailprice/stockPidiaoAll/detialed";
        }
    }
}
