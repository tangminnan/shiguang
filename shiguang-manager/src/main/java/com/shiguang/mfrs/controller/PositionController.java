package com.shiguang.mfrs.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓位维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-22 17:49:08
 */

@Controller
@RequestMapping("/mfrs/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    //部门维护
    @Autowired
    private DepartmentService departmentService;


    @GetMapping()
    @RequiresPermissions("mfrs:position:position")
    String Position(Model model) {
        //部门
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList", departmentDOList);

        return "mfrs/position/position";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:position:position")
    public PageUtils list(@RequestParam Map<String, Object> params,Model model) {
        //查询列表数据
        Query query = new Query(params);
        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if(companyId != null){
            query.put("companyId",companyId);
        }else if (companyId == null){
            String departNumber=ShiroUtils.getUser().getStoreNum();
            query.put("departNumber",departNumber);
        }
        List<PositionDO> positionList = positionService.list(query);
        int total = positionService.count(query);
        PageUtils pageUtils = new PageUtils(positionList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:position:add")
    String add(Model model) {
        //部门
        Map<String, Object> map = new HashMap<>();
        //———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        if(companyId == null){
            String departNumber=ShiroUtils.getUser().getStoreNum();
            map.put("departNumber",departNumber);
        }else if (companyId != null){
            map.put("companyId",companyId);
        }
        map.put("status","0");
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList", departmentDOList);
        return "mfrs/position/add";
    }

    @GetMapping("/edit/{positionId}")
    @RequiresPermissions("mfrs:position:edit")
    String edit(@PathVariable("positionId") Long positionId, Model model) {
        PositionDO position = positionService.get(positionId);
        model.addAttribute("position", position);
        Map<String, Object> map = new HashMap<>();
        List<DepartmentDO> departmentDOList = departmentService.list(map);
        model.addAttribute("departmentDOList", departmentDOList);
        return "mfrs/position/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:position:add")
    public R save(PositionDO position) {
        //判断是否已存在
        String positionNum = position.getPositionNum();
        Map<String, Object> map = new HashMap<>();
        map.put("positionNum", positionNum);
//———获取当前登录用户的公司id————
        String companyId=ShiroUtils.getUser().getCompanyId();
        map.put("companyId",companyId);
        List<PositionDO> list = positionService.haveNum(map);
        if (list.size() > 0) {
            return R.error("仓位代码已存在");
        }

        if (positionService.save(position) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("mfrs:position:edit")
    public R update(PositionDO position) {
        positionService.update(position);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("mfrs:position:remove")
    public R remove(Long positionId) {
        if (positionService.remove(positionId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:position:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] positionIds) {
        positionService.batchRemove(positionIds);
        return R.ok();
    }

    /**
     * 启用修改状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long positionId, Long enable) {
        PositionDO positionDO = new PositionDO();
        positionDO.setPositionId(positionId);
        positionDO.setXsstate(enable);
        positionService.update(positionDO);
        return R.ok();
    }

//    /**
//     * 删除修改状态
//     */
//    @ResponseBody
//    @RequestMapping("/remove")
//    @RequiresPermissions("mfrs:position:remove")
//    public R updateStatus(Long positionId) {
//        PositionDO positionDO = new PositionDO();
//        positionDO.setState(0L);
//        positionDO.setPositionId(positionId);
//        if (positionService.updateState(positionDO) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }

}
