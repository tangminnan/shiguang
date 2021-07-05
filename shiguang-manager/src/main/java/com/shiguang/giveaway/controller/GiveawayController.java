package com.shiguang.giveaway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.giveaway.domain.GiftDO;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.product.domain.ProducaDO;
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

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-05 11:09:07
 */
 
@Controller
@RequestMapping("/information/giveaway")
public class GiveawayController {
	@Autowired
	private GiveawayService giveawayService;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping()
	@RequiresPermissions("information:giveaway:giveaway")
	String Giveaway(){
	    return "giveaway/giveaway";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:giveaway:giveaway")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GiveawayDO> giveawayList = giveawayService.list(query);
		int total = giveawayService.count(query);
		PageUtils pageUtils = new PageUtils(giveawayList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:giveaway:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("departType","销售门店");
		map.put("state",1);
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList",departmentDOList);
		List<ProducaDO> producaDOList = giveawayService.findGoods(map);
		model.addAttribute("producaDOList",producaDOList);
		List<GiftDO> giftDOList = giveawayService.findGiftList(map);
		model.addAttribute("giftDOList",giftDOList);
	    return "giveaway/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:giveaway:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GiveawayDO giveaway = giveawayService.get(id);
		model.addAttribute("giveaway", giveaway);
	    return "giveaway/edit";
	}

	/**
	 * 商品信息
	 */
	@GetMapping("/goods")
	@RequiresPermissions("information:giveaway:goods")
	String goods(Model model){
		return "giveaway/goodsAll";
	}

	/**
	 * 查询商品
	 *
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/goodslist")
	@RequiresPermissions("information:giveaway:goods")
	public PageUtils jingjialist(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<ProducaDO> producaDOList = giveawayService.findGoods(query);
		int total = giveawayService.coungGoods(query);
		PageUtils pageUtils = new PageUtils(producaDOList, total);
		return pageUtils;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:giveaway:add")
	public R save(GiveawayDO giveaway){
		if(giveawayService.save(giveaway)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:giveaway:edit")
	public R update( GiveawayDO giveaway){
		giveawayService.update(giveaway);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:giveaway:remove")
	public R remove( Long id){
		if(giveawayService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:giveaway:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		giveawayService.batchRemove(ids);
		return R.ok();
	}
	
}
