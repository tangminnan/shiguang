package com.shiguang.jiekou.controller;

import com.alibaba.fastjson.JSONObject;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.jiekou.domain.*;
import com.shiguang.jiekou.service.JianchaJKService;
import com.shiguang.jiekou.service.MemberJKService;
import com.shiguang.jiekou.service.SettlementJKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 检查结论表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-16 15:03:42
 */

@Controller
@RequestMapping("/informationJK")
public class JKController {
    @Autowired
    private MemberJKService memberJkService;
    @Autowired
    private JianchaJKService jianchaJKService;
    @Autowired
    private SettlementJKService settlementJKService;


    @ResponseBody
    @PostMapping("/member/savehis")
    public Map<String,Object> savehis(@RequestBody JSONObject obj){
        MemberJKDO member = new MemberJKDO();
        Map<String,Object> map=new HashMap<>();
        member.setName(obj.getString("name"));
        if(obj.getString("cardNumber").equals("")){
            member.setCardNumber("H"+ GuuidUtil.getUUID());
        }else{
            member.setCardNumber(obj.getString("cardNumber"));
        }
        member.setSex(obj.getLong("sex"));
        member.setCompanyId(obj.getString("companyId"));
        member.setAge(obj.getLong("age"));
        member.setPhone1(obj.getString("phone1"));
        member.setPhone2(obj.getString("phone2"));
        member.setPhone3(obj.getString("phone3"));
        member.setPostalCode(obj.getLong("provinceCode"));
        member.setProvinceName(obj.getString("provinceName"));
        member.setCityCode(obj.getString("cityCode"));
        member.setCityName(obj.getString("cityName"));
        member.setAreaCode(obj.getString("areaCode"));
        member.setAreaName(obj.getString("areaName"));
        member.setCardType(obj.getString("cardType"));
        member.setMasterCard(obj.getString("masterCard"));
        member.setMinorName(obj.getString("minorName"));
        member.setCrowdType(obj.getString("crowdType"));
        member.setExclusiveCustomer(obj.getString("exclusiveCustomer"));
        member.setExclusiveCustomerId(obj.getLong("exclusiveCustomerId"));
        member.setIdentityType(obj.getString("identityType"));
        member.setIdentityId(obj.getString("identityId"));
        member.setVocation(obj.getString("vocation"));
        member.setSchool(obj.getString("school"));
        member.setQqNumber(obj.getLong("qqNumber"));
        member.setEmail(obj.getString("email"));
        member.setAddress(obj.getString("address"));
        member.setPostalCode(obj.getLong("postalCode"));
        member.setInterest(obj.getString("interest"));
        member.setSource(obj.getString("source"));
        member.setIntegralPasd(obj.getLong("integralPasd"));
        member.setRemark(obj.getString("remark"));
        member.setRegisterTime(obj.getDate("registerTime"));
        member.setStatus(obj.getLong("status"));
        member.setState(obj.getLong("state"));

        Date birthdayDay=obj.getDate("birthdayDay");
        if(birthdayDay!=null){
            SimpleDateFormat sdfYear=new SimpleDateFormat("yyyy");
            String sdfYearString=sdfYear.format(birthdayDay);
            member.setBirthdayYear(Long.valueOf(sdfYearString));

            SimpleDateFormat sdfMonth=new SimpleDateFormat("MM");
            String sdfMonthString=sdfYear.format(sdfMonth);
            member.setBirthdayYear(Long.valueOf(sdfMonthString));

            SimpleDateFormat sdfDay=new SimpleDateFormat("dd");
            String sdfDayString=sdfYear.format(sdfDay);
            member.setBirthdayYear(Long.valueOf(sdfDayString));
        }


        Map<String, Object> map1 = new HashMap<>();
        map1.put("cardsNumber",member.getCardNumber());
        List<MemberJKDO> list = memberJkService.list(map1);
        if (list.size() > 0){
            map.put("msg","会员卡号已存在");
            map.put("code",1);
        }else if(memberJkService.save(member)>0){
            map.put("msg","保存数据成功");
            map.put("code",0);
        }else{
            map.put("msg","保存数据失败");
            map.put("code",1);
        }
        return map;
    }

    @ResponseBody
    @PostMapping("/member/findMemberHis")
    public Map<String,Object> findMemberHis(@RequestBody JSONObject obj){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("cardNumber",obj.getString("cardNumber"));
        map1.put("name",obj.getString("name"));
        map1.put("phone1",obj.getString("phone1"));
        map1.put("startTime",obj.getString("startTime"));
        map1.put("endTime",obj.getString("endTime"));
        if(obj.getLong("offset")==null){
            map1.put("offset",0);
        }else {
            map1.put("offset",obj.getLong("offset"));
        }
        if(obj.getLong("limit")==null){
            map1.put("limit",10);
        }else {
            map1.put("limit",obj.getLong("limit"));
        }

        List<MemberJKDO> MemberJKDOS = memberJkService.list(map1);
        List<Map> list= new ArrayList<>();
        for(MemberJKDO mem:MemberJKDOS){
            Map<String,Object> map2=new HashMap<>();
            map2.put("id",mem.getId());
            map2.put("name",mem.getName());
            map2.put("cardNumber",mem.getCardNumber());
            map2.put("sex",mem.getSex());
            map2.put("companyId",mem.getCompanyId());
            map2.put("age",mem.getAge());
            map2.put("phone1",mem.getPhone1());
            String birthdayDayString=mem.getBirthdayYear()+"-"+mem.getBirthdayMonth()+"-"+mem.getBirthdayDay();
            Date birthday = new Date();
            try {
                birthday=sdf.parse(birthdayDayString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            map2.put("birthdayDay",birthday);
            list.add(map2);
        }
        map.put("error_code",0);
        map.put("date",list);
        return map;
    }

    @ResponseBody
    @PostMapping("/member/detailMemberHis")
    public Map<String,Object> detailMemberHis(@RequestBody JSONObject obj){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map=new HashMap<>();
        MemberJKDO MemberJKDO = memberJkService.getCardNumber(obj.getString("cardNumber"));

        String birthdayDayString=MemberJKDO.getBirthdayYear()+"-"+MemberJKDO.getBirthdayMonth()+"-"+MemberJKDO.getBirthdayDay();
        Date birthdayDay = new Date();
        try {
            birthdayDay=sdf.parse(birthdayDayString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MemberJKDO.setBirthday(birthdayDay);
        map.put("error_code",0);
        map.put("date",MemberJKDO);
        return map;
    }

    @ResponseBody
    @PostMapping("/optometryNew/optometryHis")
    public Map<String,Object> optometryHis(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        String cardNumber=obj.getString("cardNumber");
        String ptometryNumber=obj.getString("ptometryNumber");
        map1.put("cardNumber",cardNumber);
        map1.put("ptometryNumber",ptometryNumber);
        List<TryresultJKDO> tryresultsDOList = jianchaJKService.yanguangListShuju(map1);
        map.put("error_code",0);
        map.put("date",tryresultsDOList);
        return map;
    }

    @ResponseBody
    @PostMapping("/optometryNew/prescriptionHis")
    public Map<String,Object> prescriptionHis(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        String cardNumber=obj.getString("cardNumber");
        String ptometryNumber=obj.getString("ptometryNumber");
        map1.put("cardNumber",cardNumber);
        map1.put("ptometryNumber",ptometryNumber);
        List<KjyyJKDO> KjyyJKDOList = jianchaJKService.KjyyListShuju(map1);
        List<KjjyJKDO> KjjyJKDOList = jianchaJKService.KjjyListShuju(map1);
        List<SgjjJKDO> SgjjJKDOList = jianchaJKService.SgjjListShuju(map1);
        List<RxjmjcjJKDO> RxjmjcjJKDOList = jianchaJKService.RxjmjcjListShuju(map1);
        List<ZyJKDO> ZyJKDOList = jianchaJKService.ZyListShuju(map1);
        List<SjxlJKDO> SjxlJKDOList = jianchaJKService.SjxlListShuju(map1);
        List<VstJKDO> VstJKDOList = jianchaJKService.VstListShuju(map1);
        List<CrtJKDO> CrtJKDOList = jianchaJKService.CrtListShuju(map1);
        List<RgpJKDO> RgpJKDOList = jianchaJKService.RgpListShuju(map1);
        Map<String,Object> map2=new HashMap<>();
        map2.put("KjyyDO",KjyyJKDOList);
        map2.put("KjjyDO",KjjyJKDOList);
        map2.put("SgjjDO",SgjjJKDOList);
        map2.put("RxjmjcjDO",RxjmjcjJKDOList);
        map2.put("ZyDO",ZyJKDOList);
        map2.put("SjxlDO",SjxlJKDOList);
        map2.put("VstDO",VstJKDOList);
        map2.put("CrtDO",CrtJKDOList);
        map2.put("RgpDO",RgpJKDOList);
        map.put("data",map2);
        map.put("error_code",0);
        return map;
    }

    @ResponseBody
    @PostMapping("/optometryline/lineHis")
    public Map<String,Object> lineHis(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        YgLineJKDO ygLineJKDO=new YgLineJKDO();
        ygLineJKDO.setMemberName(obj.getString("memberName"));
        ygLineJKDO.setMemberNumber(obj.getString("cardNumber"));
        ygLineJKDO.setSex(obj.getLong("sex"));
        ygLineJKDO.setCallStatus("0");
        ygLineJKDO.setLineTime(new Date());
        int lineJKSave=jianchaJKService.lineJKSave(ygLineJKDO);
        if (lineJKSave>0){
            map.put("msg","排队成功");
            map.put("code",0);
        }else{
            map.put("msg","排队失败");
            map.put("code",1);
        }
        return map;
    }

//    @ResponseBody
//    @PostMapping("/optometryNew/inspectHis")
//    public Map<String,Object> inspectHis(@RequestBody JSONObject obj){
//        Map<String,Object> map=new HashMap<>();
//        String cardNumber=obj.getString("cardNumber");
//        List<lastResultJKDO> lastResultJKDOList = jianchaJKService.getYanguangLast(cardNumber);
//        map.put("error_code",0);
//        map.put("data",lastResultJKDOList);
//        return map;
//    }

    @ResponseBody
    @PostMapping("/settlement/collectionHis")
    public Map<String,Object> collectionHis(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        String cardNumber=obj.getString("cardNumber");
        String saleNumber=obj.getString("saleNumber");


        map1.put("cardNumber",cardNumber);
        map1.put("saleNumber",saleNumber);
        map1.put("startTime",obj.getString("startTime"));
        map1.put("endTime",obj.getString("endTime"));
        List<SettlementJKDO> SettlementJKDOList = settlementJKService.list(map1);

        map.put("data",SettlementJKDOList);
        map.put("error_code",0);
        return map;
    }


}
