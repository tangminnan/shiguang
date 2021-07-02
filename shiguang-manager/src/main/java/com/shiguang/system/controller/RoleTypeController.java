package com.shiguang.system.controller;

import com.shiguang.common.controller.BaseController;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.system.domain.RoleTypeDO;
import com.shiguang.system.service.RoleTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/information/roleType")
@Controller
public class RoleTypeController extends BaseController {
    @Autowired
    private RoleTypeService roleTypeService;

    @GetMapping()
    @RequiresPermissions("information:roleType:roleType")
    String Type() {
        return "system/roleType/roleType";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:roleType:roleType")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RoleTypeDO> typeList = roleTypeService.list(query);
        int total = roleTypeService.count(query);
        PageUtils pageUtils = new PageUtils(typeList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:roleType:add")
    String add() {
        return "system/roleType/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:roleType:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleTypeDO type = roleTypeService.get(id);
        model.addAttribute("type", type);
        return "system/roleType/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:roleType:add")
    public R save(RoleTypeDO type) {
        RoleTypeDO roleTypeDO = roleTypeService.getNum(type.getRoleNum());
        if (null != roleTypeDO) {
            return R.error("该角色已存在");
        }
        if (roleTypeService.save(type) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:roleType:edit")
    public R update(RoleTypeDO type) {
        RoleTypeDO roleTypeDO = roleTypeService.getNum(type.getRoleNum());
        if (null != roleTypeDO) {
            return R.error("该角色已存在");
        }
        roleTypeService.update(type);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:roleType:remove")
    public R remove(Long id) {
        if (roleTypeService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:roleType:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        roleTypeService.batchRemove(ids);
        return R.ok();
    }
}
