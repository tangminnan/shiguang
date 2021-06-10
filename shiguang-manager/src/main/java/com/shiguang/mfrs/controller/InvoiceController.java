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

import com.shiguang.mfrs.domain.InvoiceDO;
import com.shiguang.mfrs.service.InvoiceService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 开票状态表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 11:43:55
 */
 
@Controller
@RequestMapping("/mfrs/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:invoice:invoice")
	String Invoice(){
	    return "mfrs/invoice/invoice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:invoice:invoice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<InvoiceDO> invoiceList = invoiceService.list(query);
		int total = invoiceService.count(query);
		PageUtils pageUtils = new PageUtils(invoiceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:invoice:add")
	String add(){
	    return "mfrs/invoice/add";
	}

	@GetMapping("/edit/{invoiceid}")
	@RequiresPermissions("mfrs:invoice:edit")
	String edit(@PathVariable("invoiceid") Integer invoiceid,Model model){
		InvoiceDO invoice = invoiceService.get(invoiceid);
		model.addAttribute("invoice", invoice);
	    return "mfrs/invoice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:invoice:add")
	public R save( InvoiceDO invoice){
		if(invoiceService.save(invoice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:invoice:edit")
	public R update( InvoiceDO invoice){
		invoiceService.update(invoice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:invoice:remove")
	public R remove( Integer invoiceid){
		if(invoiceService.remove(invoiceid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:invoice:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] invoiceids){
		invoiceService.batchRemove(invoiceids);
		return R.ok();
	}
	
}
