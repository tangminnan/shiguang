package com.shiguang.logstatus.controller;

import com.shiguang.common.utils.ExcelExportUtil4DIY;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.logstatus.service.LogStatusService;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.optometry.domain.ResultCornealDO;
import com.shiguang.optometry.domain.ResultDiopterDO;
import com.shiguang.optometry.domain.ResultOptometryDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller("PeiJingSingleController")
@RequestMapping("/information/peijing")
public class PeiJingSingleController {
    @Autowired
    private LogStatusService statusService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private MfrsService mfrsService;

    /**
     * 配镜单
     * @return
     */
    @GetMapping()
    @RequiresPermissions("information:peijing:peijing")
    String faliao(){
        return "logstatus/peijing";
    }

    @ResponseBody
    @GetMapping("/peijinglist")
    @RequiresPermissions("information:peijing:peijing")
    public PageUtils peijinglist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        if (!"".equals(ShiroUtils.getUser().getCompanyId()) && null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyid",ShiroUtils.getUser().getCompanyId());
        }
        if (null != params.get("name") && !"".equals(params.get("name"))){
            query.put("name",String.valueOf(query.get("name")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("saleNumber") && !"".equals(params.get("saleNumber"))){
            query.put("saleNumber",String.valueOf(query.get("saleNumber")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("phone1") && !"".equals(params.get("phone1"))){
            query.put("phone1",String.valueOf(query.get("phone1")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        }
        if (null != params.get("mfrsName") && !"".equals(params.get("mfrsName"))){
            query.put("mfrsNum",String.valueOf(query.get("mfrsNum")).trim());
//            query.put("offset",0);
//            query.put("limit",10);
        } else {
            query.put("mfrsNum","");
//            query.put("offset",0);
//            query.put("limit",10);
        }
        List<SalesDO> salesDOList = statusService.findSalePeijingAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            if (null == salesDO.getLogStatus() || "".equals(salesDO.getLogStatus())){
                if ("辅料".equals(salesDO.getEyeType()) || "隐形(成品)".equals(salesDO.getEyeType())){
                    salesDO.setLogStatus("销售完成");
                } else {
                    salesDO.setLogStatus("委外配送");
                }
            }
            if ("1".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已缴费");
            }else if ("3".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已退款");
            }else if ("0".equals(salesDO.getSaleType())){
                salesDO.setSaleType("未缴费");
            } else if ("2".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已付定金");
            }
        }
        int total = statusService.findSalePeijingCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/peijingCeshilist")
    public PageUtils peijingCeshilist(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("companyid","1");
        List<SalesDO> salesDOList = statusService.findSalePeijingAll(query);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SalesDO salesDO : salesDOList){
            salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
            salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
            if (null == salesDO.getLogStatus() || "".equals(salesDO.getLogStatus())){
                if ("辅料".equals(salesDO.getEyeType()) || "隐形(成品)".equals(salesDO.getEyeType())){
                    salesDO.setLogStatus("销售完成");
                } else {
                    salesDO.setLogStatus("委外配送");
                }
            }
            if ("1".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已缴费");
            }else if ("3".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已退款");
            }else if ("0".equals(salesDO.getSaleType())){
                salesDO.setSaleType("未缴费");
            } else if ("2".equals(salesDO.getSaleType())){
                salesDO.setSaleType("已付定金");
            }
        }
        int total = statusService.findSalePeijingCount(query);
        PageUtils pageUtils = new PageUtils(salesDOList, total);
        return pageUtils;
    }

    /**
     * 制造商
     */
    @GetMapping("/mfrs")
    @RequiresPermissions("information:peijing:mfrs")
    String mfrs(Model model) {
        return "logstatus/mfrs";
    }

    //查询制造商
    @ResponseBody
    @GetMapping("/mfrsList")
    public PageUtils mfrsList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        if (null != query.get("goodsids") && !"".equals(query.get("goodsids"))) {
            query.put("goodsIds", Integer.parseInt(query.get("goodsids").toString()));
        }
        query.put("xsstate","0");
        List<MfrsDO> mfrsDOList = mfrsService.findMfrs(query);
        int total = mfrsService.findMfrscount(query);
        PageUtils pageUtils = new PageUtils(mfrsDOList, total);
        return pageUtils;
    }

    /**
     * 导出
     * @throws IOException
     */
    @GetMapping("/shujudaochu")
    public void shujudaochu(Long[] ids, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> mapP = new HashMap<String,Object>();
        List<Map<String,Object>> bb = new ArrayList<Map<String,Object>>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Long id : ids) {
            Map<String,Object> resultMap = new LinkedHashMap<>();
            SalesDO salesStrDO = salesService.get(id);
            SalesDO salesDO = salesService.getSaleNumber(salesStrDO.getSaleNumber());
            if (null != salesDO){
                resultMap.put("配镜单号",salesDO.getSaleNumber());
                resultMap.put("配镜类型",salesDO.getEyeType());
                resultMap.put("销售门店", salesDO.getMirorAddress());
                resultMap.put("取镜地点", salesDO.getMirorAddress());
                resultMap.put("顾客姓名", salesDO.getMemberName());
                resultMap.put("配镜日期", simpleDateFormat.format(salesDO.getPeijingTime()));
                resultMap.put("取镜日期", simpleDateFormat.format(salesDO.getMirrorTime()));
                if (null == salesDO.getLogStatus() || "".equals(salesDO.getLogStatus())){
                    if ("辅料".equals(salesDO.getEyeType())){
                        salesDO.setLogStatus("销售完成");
                    } else {
                        salesDO.setLogStatus("委外配送");
                    }

                }
                resultMap.put("在途状态", salesDO.getLogStatus());
                resultMap.put("加工要求", salesDO.getProcessAsk()==null?"":salesDO.getProcessAsk());
                resultMap.put("加急状态", salesDO.getUrgentStatus()==null?"":salesDO.getUrgentStatus());
                resultMap.put("缴费金额", salesDO.getAmountMoney());
                bb.add(resultMap);
            }

        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String filename = "配镜单明细"+format.format(new Date().getTime())+".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
		/*
		Cookie status = new Cookie("status","success");
	    status.setMaxAge(600);
	    response.addCookie(status);
		*/
        OutputStream out = response.getOutputStream();

        try {
            ExcelExportUtil4DIY.exportToFile(bb,out);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.close();
        }

    }

}
