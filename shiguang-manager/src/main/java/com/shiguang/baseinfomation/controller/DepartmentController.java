package com.shiguang.baseinfomation.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.service.CompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;

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
        query.put("state",1);
        if (null != ShiroUtils.getUser().getCompanyId()){
            query.put("companyId",ShiroUtils.getUser().getCompanyId());
        } else if (null != ShiroUtils.getUser().getStoreNum()){
            query.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
        List<DepartmentDO> departmentList = departmentService.list(query);
        int total = departmentService.count(query);
        PageUtils pageUtils = new PageUtils(departmentList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:department:add")
    String add(Model model){
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("ids",ShiroUtils.getUser().getCompanyId());
        } else if (null != ShiroUtils.getUser().getStoreNum()){
            map.put("departNumber",ShiroUtils.getUser().getStoreNum());
        }
        List<CompanyDO> list = companyService.list(map);
        model.addAttribute("companyList",list);
        map.put("departType","加工中心");
        map.put("state",1);
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
        return "baseinfomation/department/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:department:edit")
    String edit(@PathVariable("id") Long id,Model model){
        DepartmentDO department = departmentService.get(id);
        model.addAttribute("department", department);
        Map<String,Object> map = new HashMap<>();
        List<CompanyDO> list = companyService.list(map);
        model.addAttribute("companyList",list);
        map.put("departType","加工中心");
        map.put("state",1);
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList",departmentDOList);
        return "baseinfomation/department/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:department:add")
    public R save( DepartmentDO department){
        Map<String,Object> map = new HashMap<>();
        String departNumber = department.getDepartNumber();
        map.put("departNumber",departNumber);
        List<DepartmentDO> list = departmentService.list(map);
        if (list.size() > 0){
            return R.error("部门编码已存在");
        }
        if (null == department.getSameSell()){
            department.setSameSell(2L);
        }
        department.setStatus(0L);
        department.setState(1L);
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
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("information:department:remove")
    public R updateStatus( Long id){
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setState(0L);
        departmentDO.setId(id);
        if(departmentService.updateStatus(departmentDO)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping(value="/updateEnable")
    public R updateEnable(Long id,Long enable) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setId(id);
        departmentDO.setStatus(enable);
        departmentService.update(departmentDO);
        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    @RequiresPermissions("information:department:remove")
//    public R remove(Long id){
//        if(departmentService.remove(id)>0){
//            return R.ok();
//        }
//        return R.error();
//    }

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
