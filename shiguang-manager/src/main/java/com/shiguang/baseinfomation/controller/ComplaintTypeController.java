package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.ComplaintTypeDO;
import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.service.ComplaintTypeService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.TypeDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("ComplaintTypeController")
@RequestMapping("/information/complaint")
public class ComplaintTypeController {
    @Autowired
    private ComplaintTypeService complaintTypeService;

    @GetMapping()
    @RequiresPermissions("information:complaint:complaint")
    String complaint(){
        return "baseinfomation/complaint/complaint";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:complaint:complaint")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        query.put("status",1);
        List<ComplaintTypeDO> typeList = complaintTypeService.list(query);
        int total = complaintTypeService.count(query);
        PageUtils pageUtils = new PageUtils(typeList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:complaint:add")
    String add(){
        return "baseinfomation/complaint/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:complaint:edit")
    String edit(@PathVariable("id") Long id,Model model){
        ComplaintTypeDO type = complaintTypeService.get(id);
        model.addAttribute("type", type);
        return "baseinfomation/complaint/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:complaint:add")
    public R save( ComplaintTypeDO type){
        String complaintCode = type.getComplaintCode();
        Map<String, Object> map = new HashMap<>();
        map.put("complaintCode",complaintCode);
        List<ComplaintTypeDO> list = complaintTypeService.list(map);
        if (list.size() > 0){
            return R.error("投诉编码已存在");
        }
        type.setStatus(1L);
        if(complaintTypeService.save(type)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:complaint:edit")
    public R update( ComplaintTypeDO type){
        complaintTypeService.update(type);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:complaint:remove")
    public R updateStatus( Long id){
        ComplaintTypeDO complaintTypeDO = new ComplaintTypeDO();
        complaintTypeDO.setStatus(0L);
        complaintTypeDO.setId(id);
        if(complaintTypeService.updateStatus(complaintTypeDO)>0){
            return R.ok();
        }
        return R.error();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:complaint:remove")
//    public R remove(Long id){
//        if(complaintTypeService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:complaint:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        complaintTypeService.batchRemove(ids);
        return R.ok();
    }
}
