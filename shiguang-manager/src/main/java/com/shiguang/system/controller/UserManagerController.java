package com.shiguang.system.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.annotation.Log;
import com.shiguang.common.config.BootdoConfig;
import com.shiguang.common.config.Constant;
import com.shiguang.common.controller.BaseController;
import com.shiguang.common.service.DictService;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.system.domain.RoleDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.obs.MultipartFileToFile;
import com.shiguang.system.obs.ObsService;
import com.shiguang.system.service.RoleService;
import com.shiguang.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/userManager")
@Controller
public class UserManagerController extends BaseController {
    private String prefix="system/user"  ;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    DictService dictService;
    @Autowired
    private BootdoConfig bootdoConfig;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;


    @RequiresPermissions("sys:userManager:userManager")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/userManager";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        String rname = "";
        query.put("roleTypes",5);
        List<UserDO> sysUserList = userService.listManage(query);
//        Map<String,Object> map = new HashMap<>();
//        map.put("roleType",5);
//        for(UserDO udo:sysUserList){
//            List<RoleDO> rdol =roleService.listbyid(udo.getUserId(),map);
//            for(int i=0;i<rdol.size();i++){
//                rname =rname+ rdol.get(i).getRoleName();
//                if(i<rdol.size()-1){
//                    rname =rname+",";
//                }
//            }
//            udo.setRoleName(rname);
//            rname = "";
//        }
        int total = userService.countManage(query);
        PageUtils pageUtil = new PageUtils(sysUserList, total);
        return pageUtil;
    }

    @RequiresPermissions("sys:userManager:add")
    @Log("添加管理员")
    @GetMapping("/add")
    String addManager(Model model) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("roleType",5);
        List<RoleDO> roles = roleService.list(maps);
        model.addAttribute("roles", roles);
        Map<String,Object> map = new HashMap<>();
        //map.put("departType","销售门店");
        //List<DepartmentDO> storeList = departmentService.list(map);
        List<CompanyDO> companyDOList =companyService.list(map);
        model.addAttribute("companyDOList",companyDOList);
        return prefix + "/addManager";
    }

    @RequiresPermissions("sys:userManager:edit")
    @Log("编辑管理员用户")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        UserDO userDO = userService.get(id);
        model.addAttribute("user", userDO);
        Map<String,Object> maps = new HashMap<>();
        maps.put("roleType",5);
        List<RoleDO> roles = roleService.list(id,maps);
        model.addAttribute("roles", roles);
        Map<String,Object> map = new HashMap<>();
//        map.put("departType","销售门店");
//        List<DepartmentDO> storeList = departmentService.list(map);
//        model.addAttribute("storeList",storeList);
        List<CompanyDO> companyDOList =companyService.list(map);
        model.addAttribute("companyDOList",companyDOList);
        return prefix+"/editManager";
    }

    @RequiresPermissions("sys:userManager:add")
    @Log("保存用户")
    @PostMapping("/save")
    @ResponseBody
    R save(UserDO user) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        if (userService.save(user) > 0) {
            return R.ok();
        }
        return R.error();
    }
    @RequiresPermissions("sys:userManager:remove")
    @Log("删除用户")
    @PostMapping("/remove")
    @ResponseBody
    R remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (userService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @RequiresPermissions("sys:userManager:batchRemove")
    @Log("批量删除用户")
    @PostMapping("/batchRemove")
    @ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] userIds) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int r = userService.batchremove(userIds);
        if (r > 0) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !userService.exit(params);
    }
}
