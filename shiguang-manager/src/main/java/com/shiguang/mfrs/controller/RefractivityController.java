package com.shiguang.mfrs.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.service.RefractivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 折射率维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 18:30:49
 */

@Controller
@RequestMapping("/mfrs/refractivity")
public class RefractivityController {
    @Autowired
    private RefractivityService refractivityService;

    @GetMapping()
    @RequiresPermissions("mfrs:refractivity:refractivity")
    String Refractivity() {
        return "mfrs/refractivity/refractivity";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("mfrs:refractivity:refractivity")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RefractivityDO> refractivityList = refractivityService.list(query);
        int total = refractivityService.count(query);
        PageUtils pageUtils = new PageUtils(refractivityList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("mfrs:refractivity:add")
    String add() {
        return "mfrs/refractivity/add";
    }

    @GetMapping("/edit/{refractivityid}")
    @RequiresPermissions("mfrs:refractivity:edit")
    String edit(@PathVariable("refractivityid") Integer refractivityid, Model model) {
        RefractivityDO refractivity = refractivityService.get(refractivityid);
        model.addAttribute("refractivity", refractivity);
        return "mfrs/refractivity/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("mfrs:refractivity:add")
    public R save(RefractivityDO refractivity) {

        String refractivitynum = refractivity.getRefractivitynum();
        Map<String, Object> map = new HashMap<>();
        map.put("refractivitynum", refractivitynum);
        List<RefractivityDO> list = refractivityService.list(map);
        if (list.size() > 0) {
            return R.error("折射率编码已存在");
        }


        if (refractivityService.save(refractivity) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("mfrs:refractivity:edit")
    public R update(RefractivityDO refractivity) {
        refractivityService.update(refractivity);
        return R.ok();
    }

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:refractivity:remove")
	public R remove( Integer refractivityid){
		if(refractivityService.remove(refractivityid)>0){
		return R.ok();
		}
		return R.error();
	}

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("mfrs:refractivity:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] refractivityids) {
        refractivityService.batchRemove(refractivityids);
        return R.ok();
    }


}
