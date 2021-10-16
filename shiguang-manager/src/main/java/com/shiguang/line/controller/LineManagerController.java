package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineMemberService;
import com.shiguang.line.service.LineService;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/lineManager")
public class LineManagerController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private LineService lineService;
    @Autowired
    private LineMemberService lineMemberService;

    @GetMapping()
    @RequiresPermissions("information:lineManager:lineManager")
    String Line(){
        return "lineManager/lineManager";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:lineManager:lineManager")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        }
        PageUtils pageUtils = null;
        if (null != query.get("phone1") && !"".equals(query.get("phone1"))){
            List<MemberDO> memberList = memberService.list(query);
            int total = memberService.count(query);
            pageUtils = new PageUtils(memberList, total);
        }

        return pageUtils;
    }

    /**
     * 排队
     */
    @PostMapping( "/line")
    @ResponseBody
    @RequiresPermissions("information:lineManager:lineManager")
    public R line(Long id){
        MemberDO memberDO = memberService.get(id);
        LineDO lineDO = new LineDO();
        lineDO.setMemberNumber(memberDO.getCardNumber());
        lineDO.setMemberName(memberDO.getName());
        lineDO.setSex(memberDO.getSex());
        lineDO.setCallStatus("0");
        lineDO.setStorey("4");
        lineDO.setLineTime(new Date());
        if(lineService.save(lineDO)>0){
            return R.ok();
        }
        return R.error();
    }

}
