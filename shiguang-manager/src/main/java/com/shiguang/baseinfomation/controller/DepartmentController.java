package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    @RequiresPermissions("information:department:department")
    String Department(){
        return "baseinfomation/department/department";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:department:department")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<DepartmentDO> departmentList = departmentService.list(query);
        int total = departmentService.count(query);
        PageUtils pageUtils = new PageUtils(departmentList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:department:add")
    String add(){
        return "baseinfomation/department/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:department:edit")
    String edit(@PathVariable("id") Long id,Model model){
        DepartmentDO department = departmentService.get(id);
        model.addAttribute("department", department);
        return "baseinfomation/department/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:department:add")
    public R save( DepartmentDO department){
        if(departmentService.save(department)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:department:edit")
    public R update( DepartmentDO department){
        departmentService.update(department);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:department:remove")
    public R remove(Long id){
        if(departmentService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:department:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        departmentService.batchRemove(ids);
        return R.ok();
    }
}
