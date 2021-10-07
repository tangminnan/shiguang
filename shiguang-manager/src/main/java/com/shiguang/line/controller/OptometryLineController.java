package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.LineMemberDO;
import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.domain.YgLineMemberDO;
import com.shiguang.line.service.OptometryLineService;
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
@RequestMapping("/information/optometryline")
public class OptometryLineController {
    @Autowired
    private OptometryLineService optometryLineService;

    @GetMapping()
    @RequiresPermissions("information:optometryline:optometryline")
    String Line(){
        return "line/optometryline";
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
    String consultRoom(){
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
            YgLineMemberDO lineMemberDO = new YgLineMemberDO();
            lineMemberDO.setConsultRoom(consultRoom);
            lineMemberDO.setMemberName(lineDOs.getMemberName());
            lineMemberDO.setSex(lineDOs.getSex());
            lineMemberDO.setLineTime(lineDOs.getLineTime());
            if(optometryLineService.saveLineMember(lineMemberDO)>0){
                return R.ok();
            }
        }
        return R.error();
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
        List<YgLineDO> lineDOList = optometryLineService.lineList(map);
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
        }
        resultMap.put("lineMemberDOS",lineMemberDOList);
        List<Map<String,Object>> roomList = new ArrayList<>();
        List<YgLineDO> lineMemberDOList1 = optometryLineService.lineList(map);
        if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
            for (YgLineDO lineMemberDOstr : lineMemberDOList1){
                if (!"".equals(lineMemberDOstr.getConsultRoom())){
                    Map<String,Object> roomMap = new HashMap<>();
                    roomMap.put("id",lineMemberDOstr.getId());
                    roomMap.put("name",lineMemberDOstr.getMemberName());
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

}
