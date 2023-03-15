package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.*;
import com.shiguang.line.service.OpticianService;
import com.shiguang.line.service.OptometryLineService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 验光室叫号
 */
@Controller
@RequestMapping("/information/optometryline")
public class OptometryLineController {
    @Autowired
    private OptometryLineService optometryLineService;
    @Autowired
    UserService userService;
    @Autowired
    OpticianService opticianService;
    @GetMapping()
    @RequiresPermissions("information:optometryline:optometryline")
    String Line(){
        Long id=ShiroUtils.getUser().getUserId();
        UserDO userDO =  userService.get(id);
        String newOld=userDO.getNewOld();
        if("new".equals(newOld)){
            return "line/optometryline";
        }else {
            return "line/optometrylineold";
        }
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryline:optometryline")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        query.put("storey","4");
        query.put("companyId",ShiroUtils.getUser().getCompanyId());
        List<YgLineDO> lineList = optometryLineService.list(query);
        if (null != lineList && lineList.size() > 0){
            for (YgLineDO lineDO : lineList){
                if (lineDO.getSex() == 0){
                    lineDO.setSexx("男");
                }else if (lineDO.getSex() == 1){
                    lineDO.setSexx("女");
                }
            }
        }
        int total = optometryLineService.count(query);
        PageUtils pageUtils = new PageUtils(lineList, total);
        return pageUtils;
    }

    /**
     * 输入诊室
     * @return
     */
    @GetMapping("/consultRoom")
    @RequiresPermissions("information:optometryline:consultRoom")
    String consultRoom(Model model){
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("createTime",simpleDateFormat.format(new Date()));
        List<OpticianDO> opticianDOList = opticianService.list(map);
        model.addAttribute("opticianDOList",opticianDOList);
        return "line/consultRoom";
    }

    /**
     * 叫号
     */
    @PostMapping( "/addCall")
    @ResponseBody
    @RequiresPermissions("information:optometryline:addCall")
    public R addCall(String consultRoom){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("consultRoom",consultRoom);
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineDO> lineDOList = optometryLineService.list(map);
        if (null != lineDOList && lineDOList.size() > 0){
            Long lineId = lineDOList.get(0).getId();
            YgLineDO lineDOs = optometryLineService.get(lineId);
            int callStatus = 0;
            if (Integer.parseInt(lineDOs.getCallStatus())<4){
                callStatus = Integer.parseInt(lineDOs.getCallStatus()) + 1;
            } else {
                callStatus = 4;
            }
            YgLineDO lineDO = new YgLineDO();
            lineDO.setId(lineId);
            lineDO.setConsultRoom(consultRoom);
            lineDO.setCallStatus(String.valueOf(callStatus));
            optometryLineService.update(lineDO);
            for (int i=0;i<2;i++){
                YgLineMemberDO lineMemberDO = new YgLineMemberDO();
                lineMemberDO.setConsultRoom(consultRoom);
                lineMemberDO.setMemberName(lineDOs.getMemberName());
                lineMemberDO.setSex(lineDOs.getSex());
                lineMemberDO.setLineTime(lineDOs.getLineTime());
                optometryLineService.saveLineMember(lineMemberDO);
//                if(optometryLineService.saveLineMember(lineMemberDO)>0){
//                    return R.ok();
//                }
            }
        }
        return R.ok();
    }

    /**
     * 排队级叫号列表
     * @return
     */
    @GetMapping( "/callList")
    @ResponseBody
    public Map<String,Object> callList(){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineDO> lineDOList = optometryLineService.linesList(map);
        //排队的
        for (YgLineDO ygLineDO : lineDOList){
            if ("0".equals(ygLineDO.getCallStatus())){
                ygLineDO.setCallStatus("排队中");
            } else if ("6".equals(ygLineDO.getCallStatus())){
                ygLineDO.setCallStatus("已过号");
            }
        }
        resultMap.put("lineDOList",lineDOList);
        List<YgLineMemberDO> lineMemberDOList = new ArrayList<>();
        List<YgLineMemberDO> lineMemberDOS = optometryLineService.listMember(map);
        YgLineMemberDO lineMemberDO = new YgLineMemberDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMemberDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMemberDO.setSex(lineMemberDOS.get(0).getSex());
            lineMemberDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
            lineMemberDO.setId(lineMemberDOS.get(0).getId());
            lineMemberDOList.add(lineMemberDO);
            //被叫号的
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到"+lineMemberDOS.get(0).getConsultRoom()+"做综合验光检查");
        } else {
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","");
        }
        List<Map<String,Object>> roomList = new ArrayList<>();
        List<YgLineDO> lineMemberDOList1 = optometryLineService.lineList(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLineDO lineMemberDOstr : lineMemberDOList1){
                if (!"".equals(lineMemberDOstr.getConsultRoom())){
                    Map<String,Object> roomMap = new HashMap<>();
                    roomMap.put("id",lineMemberDOstr.getId());
                    roomMap.put("memberName",lineMemberDOstr.getMemberName());
                    roomMap.put("sex",lineMemberDOstr.getSex());
                    roomMap.put("consultRoom",lineMemberDOstr.getConsultRoom());
                    roomList.add(roomMap);
                }
            }
        }
        //正在就诊的
        resultMap.put("roomList",roomList);
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
//				LineDO lineDO = new LineDO();
//				lineDO.setMemberNumber(lineMemberDO.getMemberNumber());
//				lineDO.setLineDate(simpleDateFormat.format(new Date()));
//				lineService.removeMember(lineDO);
            optometryLineService.removeMember(lineMemberDOS.get(0).getId());
        }
        return resultMap;
    }

    /**
     * 患者已过号
     * @param id
     * @return
     */
    @PostMapping( "/overLine")
    @ResponseBody
    @RequiresPermissions("information:optometryline:overLine")
    public R overLine(Long id){
        YgLineDO ygLineDO = new YgLineDO();
        ygLineDO.setId(id);
        ygLineDO.setCallStatus("6");
        optometryLineService.update(ygLineDO);
        return R.ok();
    }

    /**
     * 查询排队情况
     */
    @GetMapping("/listLine")
    @ResponseBody
    public Map<String,Object> listLine(Integer offset,Integer limit){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> pagemap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        if(offset == 0){
            map.put("offset",offset);
        } else {
            map.put("offset",offset * 8);
        }

        map.put("limit",limit);
        List<YgLineDO> lineDOList = optometryLineService.linesList(map);
        pagemap.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineDO> lineDOPageList = optometryLineService.linesList(pagemap);
        //排队的人员信息
        int i=0;
        for (YgLineDO ygLineDO : lineDOList){
            ygLineDO.setNum(i+1);
            if ("0".equals(ygLineDO.getCallStatus())){
                ygLineDO.setCallStatus("排队中");
            } else if ("6".equals(ygLineDO.getCallStatus())){
                ygLineDO.setCallStatus("已过号");
            }
        }
        int size = lineDOPageList.size();
        int pages = size / 8 + (size % 8 != 0 ? 1 : 0);
        resultMap.put("lineDOList",lineDOList);
        resultMap.put("pages",pages ==0?1:pages);
        return resultMap;
    }


    /**
     * 济南中心排队级叫号列表
     * @return
     */
    @GetMapping( "/calljinanList")
    @ResponseBody
    public Map<String,Object> calljinanList(String type){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        if("jinan".equals(type)){
            map.put("companyId",'3');
        }
        List<YgLineDO> lineDOList = optometryLineService.linesList(map);
        resultMap.put("lineDOList",lineDOList);
        List<YgLineMemberDO> lineMemberDOList = new ArrayList<>();
        List<YgLineMemberDO> lineMemberDOS = optometryLineService.listMember(map);
        YgLineMemberDO lineMemberDO = new YgLineMemberDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMemberDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMemberDO.setSex(lineMemberDOS.get(0).getSex());
            lineMemberDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
            lineMemberDO.setId(lineMemberDOS.get(0).getId());
            lineMemberDOList.add(lineMemberDO);
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到"+lineMemberDOS.get(0).getConsultRoom());
        } else {
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","");
        }
        List<Map<String,Object>> roomList = new ArrayList<>();
        List<YgLineDO> lineMemberDOList1 = optometryLineService.lineList(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLineDO lineMemberDOstr : lineMemberDOList1){
                if (!"".equals(lineMemberDOstr.getConsultRoom())){
                    Map<String,Object> roomMap = new HashMap<>();
                    roomMap.put("id",lineMemberDOstr.getId());
                    roomMap.put("memberName",lineMemberDOstr.getMemberName());
                    roomMap.put("sex",lineMemberDOstr.getSex());
                    roomMap.put("consultRoom",lineMemberDOstr.getConsultRoom());
                    roomList.add(roomMap);
                }
            }
        }
        resultMap.put("roomList",roomList);
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
//				LineDO lineDO = new LineDO();
//				lineDO.setMemberNumber(lineMemberDO.getMemberNumber());
//				lineDO.setLineDate(simpleDateFormat.format(new Date()));
//				lineService.removeMember(lineDO);
            optometryLineService.removeMember(lineMemberDOS.get(0).getId());
        }
        return resultMap;
    }


    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:optometryline:remove")
    public R remove(Long id){
        if(optometryLineService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

//-------------------------
//    @GetMapping()
////    @RequiresPermissions("information:optometryline:optometryline")
//    String Lineold(){
//        return "line/optometrylineold";
//    }

    @ResponseBody
    @GetMapping("/listold")
//    @RequiresPermissions("information:optometryline:optometryline")
    public PageUtils listold(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        query.put("storey","4");
        List<YgLineoldDO> lineListold = optometryLineService.listold(query);
        if (null != lineListold && lineListold.size() > 0){
            for (YgLineoldDO ygLineoldDO : lineListold){
                if (ygLineoldDO.getSex() == 0){
                    ygLineoldDO.setSexx("男");
                }else if (ygLineoldDO.getSex() == 1){
                    ygLineoldDO.setSexx("女");
                }
            }
        }
        int total = optometryLineService.countold(query);
        PageUtils pageUtils = new PageUtils(lineListold, total);
        return pageUtils;
    }

    /**
     * 输入诊室
     * @return
     */
    @GetMapping("/consultRoomold")
//    @RequiresPermissions("information:optometryline:consultRoom")
    String consultRoomold(){
        return "line/consultRoomold";
    }

    /**
     * 叫号
     */
    @PostMapping( "/addCallold")
    @ResponseBody
//    @RequiresPermissions("information:optometryline:addCall")
    public R addCallold(String consultRoom){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("consultRoom",consultRoom);
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineoldDO> ygLineoldDOS = optometryLineService.listold(map);
        if (null != ygLineoldDOS && ygLineoldDOS.size() > 0){
            Long lineId = ygLineoldDOS.get(0).getId();
            YgLineoldDO lineoldDO = optometryLineService.getold(lineId);
            int callStatus = 0;
            if (Integer.parseInt(lineoldDO.getCallStatus())<4){
                callStatus = Integer.parseInt(lineoldDO.getCallStatus()) + 1;
            } else {
                callStatus = 4;
            }
            YgLineoldDO ygLineoldDO = new YgLineoldDO();
            ygLineoldDO.setId(lineId);
            ygLineoldDO.setConsultRoom(consultRoom);
            ygLineoldDO.setCallStatus(String.valueOf(callStatus));
            optometryLineService.updateold(ygLineoldDO);
            YgLineMemberoldDO lineMemberoldDO = new YgLineMemberoldDO();
            lineMemberoldDO.setConsultRoom(consultRoom);
            lineMemberoldDO.setMemberName(lineoldDO.getMemberName());
            lineMemberoldDO.setSex(lineoldDO.getSex());
            lineMemberoldDO.setLineTime(lineoldDO.getLineTime());
            if(optometryLineService.saveLineMemberold(lineMemberoldDO)>0){
                return R.ok();
            }
        }
        return R.error();
    }

    /**
     * 排队级叫号列表
     * @return
     */
    @GetMapping( "/callListold")
    @ResponseBody
    public Map<String,Object> callListold(){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineoldDO> lineDOList = optometryLineService.linesListold(map);
        resultMap.put("lineDOList",lineDOList);
        List<YgLineMemberoldDO> lineMemberDOList = new ArrayList<>();
        List<YgLineMemberoldDO> lineMemberDOS = optometryLineService.listMemberold(map);
        YgLineMemberoldDO lineMemberoldDO = new YgLineMemberoldDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMemberoldDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMemberoldDO.setSex(lineMemberDOS.get(0).getSex());
            lineMemberoldDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
            lineMemberoldDO.setId(lineMemberDOS.get(0).getId());
            lineMemberDOList.add(lineMemberoldDO);
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到"+lineMemberDOS.get(0).getConsultRoom()+"做综合验光检查");
        } else {
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","");
        }
        List<Map<String,Object>> roomList = new ArrayList<>();
        List<YgLineoldDO> lineMemberDOList1 = optometryLineService.lineListold(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLineoldDO lineMemberDOstr : lineMemberDOList1){
                if (!"".equals(lineMemberDOstr.getConsultRoom())){
                    Map<String,Object> roomMap = new HashMap<>();
                    roomMap.put("id",lineMemberDOstr.getId());
                    roomMap.put("memberName",lineMemberDOstr.getMemberName());
                    roomMap.put("sex",lineMemberDOstr.getSex());
                    roomMap.put("consultRoom",lineMemberDOstr.getConsultRoom());
                    roomList.add(roomMap);
                }
            }
        }
        resultMap.put("roomList",roomList);
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
//				LineDO lineDO = new LineDO();
//				lineDO.setMemberNumber(lineMemberDO.getMemberNumber());
//				lineDO.setLineDate(simpleDateFormat.format(new Date()));
//				lineService.removeMember(lineDO);
            optometryLineService.removeold(lineMemberDOS.get(0).getId());
        }
        return resultMap;
    }

    /**
     * 删除
     */
    @PostMapping( "/removeold")
    @ResponseBody
//    @RequiresPermissions("information:optometryline:remove")
    public R removeold(Long id){
        if(optometryLineService.removeold(id)>0){
            return R.ok();
        }
        return R.error();
    }


}
