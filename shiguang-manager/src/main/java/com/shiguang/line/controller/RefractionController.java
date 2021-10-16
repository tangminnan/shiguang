package com.shiguang.line.controller;

import com.shiguang.common.utils.R;
import com.shiguang.line.domain.*;
import com.shiguang.line.service.RefractionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/information/refraction")
public class RefractionController {
    @Autowired
    private RefractionService refractionService;

    /**
     * 登录叫号app
     */
    @ResponseBody
    @GetMapping("/save")
    public Map<String,Object> save(String refractionName, String name){
        Map<String,Object> map = new HashMap<>();
        RefractionDO refractionDO = new RefractionDO();
        refractionDO.setRefractionName(refractionName);
        refractionDO.setName(name);
        if(refractionService.save(refractionDO)>0){
            map.put("code",200);
            map.put("message","登录成功");
            return map;
        }
        map.put("code",300);
        map.put("message","登录失败");
        return map;
    }

    /**
     * 叫号
     */
    @ResponseBody
    @GetMapping("/ygcall")
    public Map<String, Object> ygcall(String name){
        Map<String,Object> returnMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("refractionName",name);
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<RefractionLineDO> refractionLineDOList = refractionService.list(map);
        if(null != refractionLineDOList && refractionLineDOList.size() >0){
            Long refrationId = refractionLineDOList.get(0).getId();
            RefractionLineDO refractionLineDO = refractionService.get(refrationId);
            int callStatus = 0;
            if (Integer.parseInt(refractionLineDO.getRefractionStatus())<4){
                callStatus = Integer.parseInt(refractionLineDO.getRefractionStatus()) + 1;
            } else {
                callStatus = 4;
            }
            RefractionLineDO refractionLineDO1 = new RefractionLineDO();
            refractionLineDO1.setRefractionStatus(String.valueOf(callStatus));
            refractionLineDO1.setId(refrationId);
            refractionService.updateLine(refractionLineDO1);
            RefractionLineMemberDO refractionLineMemberDO = new RefractionLineMemberDO();
            refractionLineMemberDO.setMemberName(refractionLineDO.getMemberName());
            refractionLineMemberDO.setRefractionName(refractionLineDO.getRefractionName());
            refractionLineMemberDO.setRefractionTime(new Date());
//            RefractionDO refractionDO = refractionService.getRefraction(refractionLineDO1.getRefractionName());
            refractionLineMemberDO.setRefraction(refractionLineDO.getRefraction());
            if(refractionService.saveLineMember(refractionLineMemberDO)>0){
                returnMap.put("code",200);
                returnMap.put("message","叫号成功");
                return returnMap;
            }
        }
        returnMap.put("code",300);
        returnMap.put("message","叫号失败");
        return returnMap;
    }

    /**
     * 排队叫号列表
     */
    @GetMapping( "/callList")
    @ResponseBody
    public Map<String,Object> callList(){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<RefractionLineDO> lineDOList = refractionService.refrationlinesList(map);
        resultMap.put("lineDOList",lineDOList);
        List<RefractionLineMemberDO> lineMemberDOList = new ArrayList<>();
        List<RefractionLineMemberDO> lineMemberDOS = refractionService.listMember(map);
        RefractionLineMemberDO lineMemberDO = new RefractionLineMemberDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMemberDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMemberDO.setRefraction(lineMemberDOS.get(0).getRefraction());
            lineMemberDO.setId(lineMemberDOS.get(0).getId());
            lineMemberDOList.add(lineMemberDO);
        }
        resultMap.put("lineMemberDOS",lineMemberDOList);
        resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到"+lineMemberDOS.get(0).getRefraction()+"室就诊");
        List<Map<String,Object>> roomList = new ArrayList<>();
        map.put("refractionStatus",4);
        List<RefractionLineDO> lineMemberDOList1 = refractionService.refrationlineList(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (RefractionLineDO lineMemberDOstr : lineMemberDOList1){
                    Map<String,Object> roomMap = new HashMap<>();
                    roomMap.put("id",lineMemberDOstr.getId());
                    roomMap.put("name",lineMemberDOstr.getMemberName());
                    roomMap.put("consultRoom",lineMemberDOstr.getRefraction());
                    roomList.add(roomMap);
            }
        }
        resultMap.put("roomList",roomList);
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
//				LineDO lineDO = new LineDO();
//				lineDO.setMemberNumber(lineMemberDO.getMemberNumber());
//				lineDO.setLineDate(simpleDateFormat.format(new Date()));
//				lineService.removeMember(lineDO);
            refractionService.removeMember(lineMemberDOS.get(0).getId());
        }
        return resultMap;
    }

    /**
     * 退出
     */
    @ResponseBody
    @GetMapping("/loginOut")
    public Map<String,Object> loginOut(String name){
        Map<String,Object> map = new HashMap<>();
        if(refractionService.remove(name)>0){
            map.put("code",200);
            map.put("message","退出成功");
            return map;
        }
        map.put("code",300);
        map.put("message","退出失败");
        return map;
    }
}
