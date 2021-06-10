package com.shiguang.mfrs.controller;

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

import com.shiguang.mfrs.domain.MfrsGoodsDO;
import com.shiguang.mfrs.service.MfrsGoodsService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 制造商与商品类别关联表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 16:09:37
 */
 
@Controller
@RequestMapping("/mfrs/mfrsGoods")
public class MfrsGoodsController {
	@Autowired
	private MfrsGoodsService mfrsGoodsService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:mfrsGoods:mfrsGoods")
	String MfrsGoods(){
	    return "mfrs/mfrsGoods/mfrsGoods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:mfrsGoods:mfrsGoods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MfrsGoodsDO> mfrsGoodsList = mfrsGoodsService.list(query);
		int total = mfrsGoodsService.count(query);
		PageUtils pageUtils = new PageUtils(mfrsGoodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:mfrsGoods:add")
	String add(){
	    return "mfrs/mfrsGoods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:mfrsGoods:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		MfrsGoodsDO mfrsGoods = mfrsGoodsService.get(id);
		model.addAttribute("mfrsGoods", mfrsGoods);
	    return "mfrs/mfrsGoods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:mfrsGoods:add")
	public R save( MfrsGoodsDO mfrsGoods){
		if(mfrsGoodsService.save(mfrsGoods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:mfrsGoods:edit")
	public R update( MfrsGoodsDO mfrsGoods){
		mfrsGoodsService.update(mfrsGoods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:mfrsGoods:remove")
	public R remove( Integer id){
		if(mfrsGoodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:mfrsGoods:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		mfrsGoodsService.batchRemove(ids);
		return R.ok();
	}
	
}
