package com.shiguang.line.controller;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.LineMemberDO;
import com.shiguang.line.domain.OpticianDO;
import com.shiguang.line.service.LineMemberService;
import com.shiguang.line.service.LineService;
import com.shiguang.line.service.OpticianService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 验光师列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-15 14:09:10
 */
 
@Controller
@RequestMapping("/information/optician")
public class OpticianController {
	@Autowired
	private OpticianService opticianService;
	
	@GetMapping()
	@RequiresPermissions("information:optician:optician")
	String Line(){
	    return "line/optician";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:optician:optician")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
		query.put("storey","4");
        List<OpticianDO> lineList = opticianService.list(query);
		int total = opticianService.count(query);
		PageUtils pageUtils = new PageUtils(lineList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:optician:add")
	String add(){
	    return "line/opticianadd";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:optician:edit")
	String edit(@PathVariable("id") Long id,Model model){
		OpticianDO line = opticianService.get(id);
		model.addAttribute("line", line);
	    return "line/opticianedit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:optician:add")
	public R save(OpticianDO line){
		line.setCreateTime(new Date());
		if(opticianService.save(line)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:optician:edit")
	public R update( OpticianDO line){
		opticianService.update(line);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:optician:remove")
	public R remove( Long id){
		if(opticianService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:optician:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		opticianService.batchRemove(ids);
		return R.ok();
	}
	
}
