package com.shiguang.mfrs.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.stock.domain.PidiaoDO;
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
    @Autowired
    private DepartmentService departmentService;


    @GetMapping()
    @RequiresPermissions("mfrs:position:position")
    String Position(Model model) {
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
        if (null != ShiroUtils.getUser().getCompanyId()){
            if(ShiroUtils.getUser().getCompanyId().equals("3")){
                query.put("companyId","");
            }else {
                query.put("companyId",ShiroUtils.getUser().getCompanyId());
            }
        }
        query.put("state",1);
        List<PositionDO> positionList = positionService.list(query);
        int total = positionService.count(query);
        PageUtils pageUtils = new PageUtils(positionList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:position:add")
    String add(Model model) {
        Map<String, Object> map = new HashMap<>();
        if (null != ShiroUtils.getUser().getCompanyId()){
            map.put("companyId",ShiroUtils.getUser().getCompanyId());
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
        String positionNum = position.getPositionNum();
        String companyId = position.getCompanyId();
        Map<String, Object> map = new HashMap<>();
        map.put("positionNum", positionNum);
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
        String departNumber=position.getDepartNumber();
        DepartmentDO departmentDO=positionService.getComponid(departNumber);
        Integer companyId=departmentDO.getCompanyId();
        position.setCompanyId(companyId.toString());
        positionService.update(position);
        return R.ok();
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

    @ResponseBody
    @RequestMapping(value = "/updateEnable")
    public R updateEnable(Long positionId, Long enable) {
        PositionDO positionDO = new PositionDO();
        positionDO.setPositionId(positionId);
        positionDO.setXsstate(enable);
        positionService.update(positionDO);
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("mfrs:position:remove")
    public R updateStatus(Long positionId) {
        PositionDO positionDO = new PositionDO();
        positionDO.setState(0L);
        positionDO.setPositionId(positionId);
        if (positionService.updateState(positionDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
    @ResponseBody
    @RequestMapping(value = "/getCompony")
    public List<DepartmentDO> getCompony(String departNumber,String departName, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("departNumber", departNumber);
        map.put("departName", departName);
        List<DepartmentDO> departmentDOS = departmentService.list(map);
        model.addAttribute("departmentDOS", departmentDOS);
        return departmentDOS;
    }
}
