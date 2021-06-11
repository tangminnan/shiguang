package com.shiguang.baseinfomation.controller;


import com.shiguang.baseinfomation.domain.PersonSortDO;
import com.shiguang.baseinfomation.service.PersonSortService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/information/personSort")
public class PersonSortController {
    @Autowired
    private PersonSortService sortService;

    @GetMapping()
    @RequiresPermissions("information:personSort:personSort")
    String Sort(){
        return "baseinfomation/personSort/personSort";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:personSort:personSort")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<PersonSortDO> sortList = sortService.list(query);
//        if (null != sortList && sortList.size() > 0){
//            for (PersonSortDO personSortDO : sortList){
//                if (Integer.parseInt(personSortDO.getCrowdNumber()) < 10){
//                    personSortDO.setCrowdNumber("0"+personSortDO.getCrowdNumber());
//                }
//            }
//        }
        int total = sortService.count(query);
        PageUtils pageUtils = new PageUtils(sortList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:personSort:add")
    String add(){
        return "baseinfomation/personSort/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:personSort:edit")
    String edit(@PathVariable("id") Long id, Model model){
        PersonSortDO sort = sortService.get(id);
        model.addAttribute("sort", sort);
        return "baseinfomation/personSort/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:personSort:add")
    public R save(PersonSortDO sort){
        String crowdNumber = sort.getCrowdNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("crowdNumber",crowdNumber);
        List<PersonSortDO> list = sortService.list(map);
        if (list.size() > 0){
            return R.error("人群编码已存在");
        }
        if(sortService.save(sort)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:personSort:edit")
    public R update( PersonSortDO sort){
        sortService.update(sort);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("information:personSort:remove")
    public R remove( Long id){
        if(sortService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:personSort:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids){
        sortService.batchRemove(ids);
        return R.ok();
    }
}
