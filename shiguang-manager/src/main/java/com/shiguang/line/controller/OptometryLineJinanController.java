package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.*;
import com.shiguang.line.service.OptometryLineService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 验光室叫号
 */
@Controller
@RequestMapping("/information/optometryJinanline")
public class OptometryLineJinanController {
    @Autowired
    private OptometryLineService optometryLineService;
    @Autowired
    UserService userService;
    @GetMapping()
    @RequiresPermissions("information:optometryJinanline:optometryline")
    String Line(){
        return "line/optometryJinanline";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:optometryJinanline:optometryline")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        query.put("storey","4");
        query.put("companyId",ShiroUtils.getUser().getCompanyId());
        List<YgLineJinanDO> lineList = optometryLineService.listJinan(query);
        if (null != lineList && lineList.size() > 0){
            for (YgLineJinanDO lineDO : lineList){
                if (lineDO.getSex() == 0){
                    lineDO.setSexx("男");
                }else if (lineDO.getSex() == 1){
                    lineDO.setSexx("女");
                }
            }
        }
        int total = optometryLineService.countJinan(query);
        PageUtils pageUtils = new PageUtils(lineList, total);
        return pageUtils;
    }

    /**
     * 输入诊室
     * @return
     */
    @GetMapping("/consultRoom")
    @RequiresPermissions("information:optometryJinanline:consultRoom")
    String consultRoom(){
        return "line/consultJinanRoom";
    }

    /**
     * 叫号
     */
    @PostMapping( "/addCall")
    @ResponseBody
    @RequiresPermissions("information:optometryJinanline:addCall")
    public R addCall(String consultRoom){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("consultRoom",consultRoom);
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineJinanDO> lineDOList = optometryLineService.listJinan(map);
        if (null != lineDOList && lineDOList.size() > 0){
            Long lineId = lineDOList.get(0).getId();
            YgLineJinanDO lineDOs = optometryLineService.getJinan(lineId);
            int callStatus = 0;
            if (Integer.parseInt(lineDOs.getCallStatus())<4){
                callStatus = Integer.parseInt(lineDOs.getCallStatus()) + 1;
            } else {
                callStatus = 4;
            }
            YgLineJinanDO lineDO = new YgLineJinanDO();
            lineDO.setId(lineId);
            lineDO.setConsultRoom(consultRoom);
            lineDO.setCallStatus(String.valueOf(callStatus));
            optometryLineService.updateJinan(lineDO);
            YgLineMemberJinanDO lineMemberDO = new YgLineMemberJinanDO();
            lineMemberDO.setConsultRoom(consultRoom);
            lineMemberDO.setMemberNumber(lineDO.getMemberNumber());
            lineMemberDO.setMemberName(lineDOs.getMemberName());
            lineMemberDO.setSex(lineDOs.getSex());
            lineMemberDO.setLineTime(lineDOs.getLineTime());
            if(optometryLineService.saveLineMemberJinan(lineMemberDO)>0){
                return R.ok();
            }
        }
        return R.error();
    }

    /**
     * 济南中心排队级叫号列表
     * @return
     */
    @GetMapping( "/calljinanList")
    @ResponseBody
    public Map<String,Object> calljinanList(){
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put("lineTime",simpleDateFormat.format(new Date()));
        List<YgLineJinanDO> lineDOList = optometryLineService.linesJinanList(map);
        resultMap.put("lineDOList",lineDOList);
        List<YgLineMemberJinanDO> lineMemberDOList = new ArrayList<>();
        List<YgLineMemberJinanDO> lineMemberDOS = optometryLineService.listMemberJinan(map);
        YgLineMemberJinanDO lineMemberDO = new YgLineMemberJinanDO();
        if (null != lineMemberDOS && lineMemberDOS.size() > 0){
            lineMemberDO.setMemberName(lineMemberDOS.get(0).getMemberName());
            lineMemberDO.setMemberNumber(lineMemberDOS.get(0).getMemberNumber());
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
        List<YgLineJinanDO> lineMemberDOList1 = optometryLineService.lineJinanList(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLineJinanDO lineMemberDOstr : lineMemberDOList1){
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
            Map<String,Object> jinanMap = new HashMap<>();
            jinanMap.put("memberNumber",lineMemberDO.getMemberNumber());
            jinanMap.put("lineTime",simpleDateFormat.format(new Date()));
            YgLineMemberJinanDO memberJinanDO = optometryLineService.getMemberNumber(jinanMap);
            optometryLineService.removeMemberjinan(memberJinanDO.getMemberNumber());
        }
        return resultMap;
    }


    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:optometryJinanline:remove")
    public R remove(Long id){
        if(optometryLineService.removejinan(id)>0){
            return R.ok();
        }
        return R.error();
    }

}
