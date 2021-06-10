package com.shiguang.mfrs.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.R;
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

import com.shiguang.mfrs.domain.PayDO;
import com.shiguang.mfrs.service.PayService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 采购结算方式表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
 
@Controller
@RequestMapping("/mfrs/pay")
public class PayController {
	@Autowired
	private PayService payService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:pay:pay")
	String Pay(){
	    return "mfrs/pay/pay";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:pay:pay")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PayDO> payList = payService.list(query);
		int total = payService.count(query);
		PageUtils pageUtils = new PageUtils(payList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:pay:add")
	String add(){
	    return "mfrs/pay/add";
	}

	@GetMapping("/edit/{payid}")
	@RequiresPermissions("mfrs:pay:edit")
	String edit(@PathVariable("payid") Integer payid,Model model){
		PayDO pay = payService.get(payid);
		model.addAttribute("pay", pay);
	    return "mfrs/pay/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:pay:add")
	public R save(PayDO pay){
		if(payService.save(pay)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:pay:edit")
	public R update( PayDO pay){
		payService.update(pay);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:pay:remove")
	public R remove( Integer payid){
		if(payService.remove(payid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:pay:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] payids){
		payService.batchRemove(payids);
		return R.ok();
	}
	
}
