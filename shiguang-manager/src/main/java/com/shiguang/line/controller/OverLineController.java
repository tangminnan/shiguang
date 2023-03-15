package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.line.domain.YgLineDO;
import com.shiguang.line.service.OptometryLineService;
import com.shiguang.system.domain.UserDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/overline")
public class OverLineController {
    @Autowired
    private OptometryLineService optometryLineService;

    @GetMapping()
    @RequiresPermissions("information:overline:overline")
    String Line(){
        return "line/overline";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:overline:overline")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        query.put("companyId",ShiroUtils.getUser().getCompanyId());
        List<YgLineDO> lineList = optometryLineService.overList(query);
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

    @PostMapping( "/reoverLine")
    @ResponseBody
    @RequiresPermissions("information:overline:reoverLine")
    public R overLine(Long id){
        YgLineDO ygLineDO = new YgLineDO();
        ygLineDO.setId(id);
        ygLineDO.setCallStatus("0");
        optometryLineService.update(ygLineDO);
        return R.ok();
    }


    
}
