package com.shiguang.stock.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.WeiwaiService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-14 16:17:31
 */
 
@Controller
@RequestMapping("/stock/weiwai")
public class WeiwaiController {
	@Autowired
	private WeiwaiService weiwaiService;

//	select s.sale_number,s.member_number,m.name,m.phone_1,sa.eye_type,sa.peijing_time,sa.mirror_time
//from settlement s
//left join member m on s.member_number=m.card_number
//left join store_sales sa on s.sale_number=sa.sale_number
	@GetMapping()
	@RequiresPermissions("stock:weiwai:weiwai")
	String Weiwai(){
	    return "stock/weiwai/weiwai";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwai:weiwai")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WeiwaiDO> weiwaiList = weiwaiService.weiwailist(query);
		int total = weiwaiService.countList(query);
		PageUtils pageUtils = new PageUtils(weiwaiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwai:add")
	String add(){
	    return "stock/weiwai/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:weiwai:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WeiwaiDO weiwai = weiwaiService.get(id);
		model.addAttribute("weiwai", weiwai);
	    return "stock/weiwai/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:weiwai:add")
	public R save( WeiwaiDO weiwai){
		if(weiwaiService.save(weiwai)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwai:edit")
	public R update( WeiwaiDO weiwai){
		weiwaiService.update(weiwai);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:remove")
	public R remove( Long id){
		if(weiwaiService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwai:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		weiwaiService.batchRemove(ids);
		return R.ok();
	}
	
}
