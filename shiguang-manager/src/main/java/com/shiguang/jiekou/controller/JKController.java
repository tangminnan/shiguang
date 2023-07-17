package com.shiguang.jiekou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.R;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiekou.domain.*;
import com.shiguang.jiekou.service.JianchaJKService;
import com.shiguang.jiekou.service.MemberJKService;
import com.shiguang.jiekou.service.SettlementJKService;
import com.shiguang.member.domain.MemberDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RestTemplate restTemplate;

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
        if(obj.getString("identityType").equals("1")){
            member.setIdentityType("居民身份证");
        }else if(obj.getString("identityType").equals("2")){
            member.setIdentityType("机动车驾驶证");
        }else if(obj.getString("identityType").equals("3")){
            member.setIdentityType("台湾居民来往大陆通行证");
        }else if(obj.getString("identityType").equals("4")){
            member.setIdentityType("中国人民解放军军人证");
        }else if(obj.getString("identityType").equals("5")){
            member.setIdentityType("中国人民武装警察身份证");
        }else if(obj.getString("identityType").equals("6")){
            member.setIdentityType("护照");
        }else if(obj.getString("identityType").equals("7")){
            member.setIdentityType("户口本");
        }
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

        member.setDepartNumber("01");
        member.setMemberOption(Long.valueOf("0"));

        Date birthdayDay=obj.getDate("birthdayDay");
        if(birthdayDay!=null){
            SimpleDateFormat sdfYear=new SimpleDateFormat("yyyy");
            String sdfYearString=sdfYear.format(birthdayDay);
            member.setBirthdayYear(Long.valueOf(sdfYearString));

            SimpleDateFormat sdfMonth=new SimpleDateFormat("MM");
            String sdfMonthString=sdfMonth.format(birthdayDay);
            member.setBirthdayMonth(Long.valueOf(sdfMonthString));

            SimpleDateFormat sdfDay=new SimpleDateFormat("dd");
            String sdfDayString=sdfDay.format(birthdayDay);
            member.setBirthdayDay(Long.valueOf(sdfDayString));
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> map1 = new HashMap<>();
//        map1.put("cardsNumber",member.getCardNumber());
        map1.put("identityId",member.getIdentityId());
        map1.put("name",member.getName());
        List<MemberJKDO> list = memberJkService.list(map1);
        if (list.size() > 0){
            map.put("msg","会员已存在");
            map.put("code",1);
        }else if(memberJkService.save(member)>0){
            List<MemberJKDO> memberJKDOList = new ArrayList<>();
            memberJKDOList.add(member);
            HttpEntity<List<MemberJKDO>> entity = new HttpEntity<>(memberJKDOList, httpHeaders);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity("/http://111.41.199.127:8066/jiekou/saveMember", entity, String.class);
            String response = responseEntity.getBody();
            Map returnMap = JSON.parseObject(response, Map.class);
            System.out.println("接口返回数据："+returnMap);
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
            map2.put("registerTime",mem.getRegisterTime());
            String birthdayDayString=mem.getBirthdayYear()+"-"+mem.getBirthdayMonth()+"-"+mem.getBirthdayDay();
            Date birthday = new Date();
            try {
                if(mem.getBirthdayYear()!=null&&mem.getBirthdayMonth()!=null&&mem.getBirthdayDay()!=null)
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
        Map<String,Object> map1=new HashMap<>();
        map1.put("cardNumber",obj.getString("cardNumber"));
        map1.put("name",obj.getString("name"));
        map1.put("phone1",obj.getString("phone1"));
        map1.put("startTime",obj.getString("startTime"));
        map1.put("endTime",obj.getString("endTime"));

        List<MemberJKDO> MemberJKDOs = memberJkService.getCardNumber(map1);
        for(MemberJKDO memberJKDO:MemberJKDOs){
            String birthdayDayString=memberJKDO.getBirthdayYear()+"-"+memberJKDO.getBirthdayMonth()+"-"+memberJKDO.getBirthdayDay();
            Date birthdayDay = new Date();
            try {
                if(memberJKDO.getBirthdayYear()!=null&&memberJKDO.getBirthdayMonth()!=null&&memberJKDO.getBirthdayDay()!=null)
                birthdayDay=sdf.parse(birthdayDayString);
                memberJKDO.setBirthday(birthdayDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        map.put("error_code",0);
        map.put("date",MemberJKDOs);

        return map;
    }

    @ResponseBody
    @PostMapping("/optometryNew/optometryHis")
    public Map<String,Object> optometryHis(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        String cardNumber=obj.getString("cardNumber");
        String ptometryNumber=obj.getString("ptometryNumber");
        String startTime=obj.getString("startTime");
        String endTime=obj.getString("endTime");
        map1.put("cardNumber",cardNumber);
        map1.put("ptometryNumber",ptometryNumber);
        map1.put("startTime",startTime);
        map1.put("endTime",endTime);
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
        String startTime=obj.getString("startTime");
        String endTime=obj.getString("endTime");
        map1.put("cardNumber",cardNumber);
        map1.put("ptometryNumber",ptometryNumber);
        map1.put("startTime",startTime);
        map1.put("endTime",endTime);
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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdfHour=new SimpleDateFormat("yyyy-MM-dd HH");
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> tiaojian=new HashMap<>();
//        tiaojian.put("date",sdfHour.format(new Date()));
        YgLineJKDO ygLineJKDO=new YgLineJKDO();
        String memberName=obj.getString("memberName");
        String cardNumber=obj.getString("cardNumber");
        Long sex=obj.getLong("sex");
        String HISZS=obj.getString("HISZS");
        //获取当日验光室开放信息
        List<String> ygRooms=jianchaJKService.getygRoom(sdf.format(new Date()));
        String yyygRoom="";
        int num=10000;
        for(String ygRoom:ygRooms){
            tiaojian.put("ygRoom",ygRoom);
            int roomNum=jianchaJKService.getRoomNUM(tiaojian);
            if(roomNum<num){
                num=roomNum;
                yyygRoom=ygRoom;
            }
        }
        if(memberName.equals("")||cardNumber.equals("")||sex==null){
            map.put("msg","排队失败");
            map.put("code",1);
        }else{
            List<String> jinyongRoom=jianchaJKService.getjyRoom();

            if(jinyongRoom.contains(HISZS)){
                String jinyongWeek=jianchaJKService.getjyWeek(HISZS);
                if(jinyongWeek.indexOf(getWeekOfDate(new Date()))!=-1){
                    ygLineJKDO.setMemberName(memberName);
                    ygLineJKDO.setMemberNumber(cardNumber);
                    ygLineJKDO.setSex(sex);
                    ygLineJKDO.setConsultRoom(HISZS);
                    ygLineJKDO.setCallStatus("44");
                    ygLineJKDO.setCompanyId("1");
                    ygLineJKDO.setLineTime(new Date());
                    int lineJKSave=jianchaJKService.lineJKSave(ygLineJKDO);
                    if (lineJKSave>0){
                        map.put("msg","排队成功");
                        map.put("code",0);
                    }else{
                        map.put("msg","排队失败");
                        map.put("code",1);
                    }
                }else{
                    ygLineJKDO.setMemberName(memberName);
                    ygLineJKDO.setMemberNumber(cardNumber);
                    ygLineJKDO.setSex(sex);
                    ygLineJKDO.setConsultRoom(yyygRoom);
                    ygLineJKDO.setCallStatus("55");
                    ygLineJKDO.setCompanyId("1");
                    ygLineJKDO.setLineTime(new Date());
                    int lineJKSave=jianchaJKService.lineJKSave(ygLineJKDO);
                    if (lineJKSave>0){
                        map.put("msg","排队成功");
                        map.put("code",0);
                    }else{
                        map.put("msg","排队失败");
                        map.put("code",1);
                    }
                }

            }else{
                ygLineJKDO.setMemberName(memberName);
                ygLineJKDO.setMemberNumber(cardNumber);
                ygLineJKDO.setSex(sex);
                ygLineJKDO.setConsultRoom(yyygRoom);
                ygLineJKDO.setCallStatus("55");
                ygLineJKDO.setCompanyId("1");
                ygLineJKDO.setLineTime(new Date());
                int lineJKSave=jianchaJKService.lineJKSave(ygLineJKDO);
                if (lineJKSave>0){
                    map.put("msg","排队成功");
                    map.put("code",0);
                }else{
                    map.put("msg","排队失败");
                    map.put("code",1);
                }
            }
        }
        return map;
    }

    /**
     * 获取指定日期是星期几<br>
     *
     * @param date
     * @return 指定日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
        //String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    @ResponseBody
    @PostMapping("/optometryline/lineHisOld")
    public Map<String,Object> lineHisOld(@RequestBody JSONObject obj){
        Map<String,Object> map=new HashMap<>();
        YgLineJKDO ygLineJKDO=new YgLineJKDO();
        String memberName=obj.getString("memberName");
        String cardNumber=obj.getString("cardNumber");
        Long sex=obj.getLong("sex");
        if(memberName.equals("")||cardNumber.equals("")||sex==null){
            map.put("msg","排队失败");
            map.put("code",1);
        }else{
            ygLineJKDO.setMemberName(memberName);
            ygLineJKDO.setMemberNumber(cardNumber);
            ygLineJKDO.setSex(sex);
            ygLineJKDO.setCallStatus("0");
            ygLineJKDO.setCompanyId("1");
            ygLineJKDO.setLineTime(new Date());
            int lineJKSave=jianchaJKService.lineJKSaveOld(ygLineJKDO);
            if (lineJKSave>0){
                map.put("msg","排队成功");
                map.put("code",0);
            }else{
                map.put("msg","排队失败");
                map.put("code",1);
            }
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

    @ResponseBody
    @PostMapping("/shaicha/getshaicha")
    public Map<String,Object> getshaicha(@RequestBody JSONObject obj){
        HttpHeaders httpHeadersR = new HttpHeaders();
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> data=new HashMap<>();
        String startTime=obj.getString("startTime");
        String endTime=obj.getString("endTime");
        data.put("startTime",startTime);
        data.put("endTime",endTime);

        httpHeadersR.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map<String, Object>> entityR = new HttpEntity<>(data, httpHeadersR);
        ResponseEntity<String> responseEntityR = restTemplate.postForEntity("http://111.41.199.127:8066/jiekou/getshaicha", entityR, String.class);
        String responseR = responseEntityR.getBody();
        List<Map<String,Object>> AllData = JSON.parseObject(responseR, List.class);
        map.put("data",AllData);
        map.put("error_code",0);
        return map;
    }

    /**
     * 综合验光室排队确认到场
     * @param
     * @return
     */
    @GetMapping("/member/confirmArrival")
    public String confirmArrival(Model model){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());
        List<Map> lines=memberJkService.getLine(now);
        model.addAttribute("lines",lines);
        return "jiekou/confirmArrival";
    }

    /**
     * 综合验光室排队确认到场更新
     * @param
     * @return
     */
    @PostMapping("/member/updateLine")
    @ResponseBody
    public R updateLine(String liner){
        memberJkService.updateLine(liner);
        return R.ok();
    }

}
