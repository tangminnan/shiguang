package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.*;
import com.shiguang.line.service.OpticianService;
import com.shiguang.line.service.OptometryLineService;
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
@RequestMapping("/information/optometrylinenew")
public class OptometryLinenewController {
    @Autowired
    private OptometryLineService optometryLineService;
    @Autowired
    UserService userService;
    @Autowired
    OpticianService opticianService;
    @GetMapping()
    @RequiresPermissions("information:optometrylinenew:optometryline")
    String Line(){
        return "line/optometrylinenew";

    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometrylinenew:optometryline")
    public PageUtils listold(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        query.put("storey","4");
        List<YgLinenewDO> lineListnew = optometryLineService.listnew(query);
        if (null != lineListnew && lineListnew.size() > 0){
            for (YgLinenewDO ygLinenewDO : lineListnew){
                if (ygLinenewDO.getSex() == 0){
                    ygLinenewDO.setSexx("男");
                }else if (ygLinenewDO.getSex() == 1){
                    ygLinenewDO.setSexx("女");
                }
            }
        }
        int total = optometryLineService.countnew(query);
        PageUtils pageUtils = new PageUtils(lineListnew, total);
        return pageUtils;
    }

    /**
     * 输入诊室
     * @return
     */
    @GetMapping("/consultRoomnew")
    @RequiresPermissions("information:optometrylinenew:consultRoom")
    String consultRoomold(){
        return "line/consultRoomnew";
    }

    /**
     * 叫号
     */
    @PostMapping( "/addCallnew")
    @ResponseBody
    @RequiresPermissions("information:optometrylinenew:addCall")
    public R addCallnew(String consultRoom){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("consultRoom",consultRoom);
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLinenewDO> ygLinenewDOS = optometryLineService.listnew(map);
        if (null != ygLinenewDOS && ygLinenewDOS.size() > 0){
            Long lineId = ygLinenewDOS.get(0).getId();
            YgLinenewDO linenewDO = optometryLineService.getnew(lineId);
            int callStatus = 0;
            if (Integer.parseInt(linenewDO.getCallStatus())<4){
                callStatus = Integer.parseInt(linenewDO.getCallStatus()) + 1;
            } else {
                callStatus = 4;
            }
            YgLinenewDO ygLinenewDO = new YgLinenewDO();
            ygLinenewDO.setId(lineId);
            ygLinenewDO.setConsultRoom(consultRoom);
            ygLinenewDO.setCallStatus(String.valueOf(callStatus));
            optometryLineService.updatenew(ygLinenewDO);
            YgLineMembernewDO lineMembernewDO = new YgLineMembernewDO();
            lineMembernewDO.setConsultRoom(consultRoom);
            lineMembernewDO.setMemberName(linenewDO.getMemberName());
            lineMembernewDO.setSex(linenewDO.getSex());
            lineMembernewDO.setLineTime(linenewDO.getLineTime());
            if(optometryLineService.saveLineMembernew(lineMembernewDO)>0){
                return R.ok();
            }
        }
        return R.error();
    }

    /**
     * 排队级叫号列表
     * @return
     */
    @GetMapping( "/callListnew")
    @ResponseBody
    public Map<String,Object> callListnew(){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLinenewDO> lineDOList = optometryLineService.linesListnew(map);
        resultMap.put("lineDOList",lineDOList);
        List<YgLineMembernewDO> lineMemberDOList = new ArrayList<>();
        List<YgLineMembernewDO> lineMemberDOS = optometryLineService.listMembernew(map);
        YgLineMembernewDO lineMembernewDO = new YgLineMembernewDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMembernewDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMembernewDO.setSex(lineMemberDOS.get(0).getSex());
            lineMembernewDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
            lineMembernewDO.setId(lineMemberDOS.get(0).getId());
            lineMemberDOList.add(lineMembernewDO);
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到"+lineMemberDOS.get(0).getConsultRoom()+"做综合验光检查");
        } else {
            resultMap.put("lineMemberDOS",lineMemberDOList);
            resultMap.put("content","");
        }
        List<Map<String,Object>> roomList = new ArrayList<>();
        List<YgLinenewDO> lineMemberDOList1 = optometryLineService.lineListnew(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLinenewDO lineMemberDOstr : lineMemberDOList1){
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
    @PostMapping( "/removenew")
    @ResponseBody
    @RequiresPermissions("information:optometrylinenew:remove")
    public R removenew(Long id){
        if(optometryLineService.removenew(id)>0){
            return R.ok();
        }
        return R.error();
    }


}
