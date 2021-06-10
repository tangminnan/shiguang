package com.shiguang.mfrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.InvoiceDO;
import com.shiguang.mfrs.domain.PayDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.InvoiceService;
import com.shiguang.mfrs.service.PayService;
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

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.service.BrandService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-09 12:01:40
 */
 
@Controller
@RequestMapping("/mfrs/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PayService payService;
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping()
	@RequiresPermissions("mfrs:brand:brand")
	String Brand(){
	    return "mfrs/brand/brand";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:brand:brand")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BrandDO> brandList = brandService.list(query);
		int total = brandService.count(query);
		PageUtils pageUtils = new PageUtils(brandList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:brand:add")
	String add(Model model){
		Map<String,Object> map = new HashMap<>();
		//商品
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList",goodsDOList);
		//支付
		List<PayDO> payDOList = payService.list(map);
		model.addAttribute("payDOList",payDOList);
		//开票
		List<InvoiceDO> invoiceDOList = invoiceService.list(map);
		model.addAttribute("invoiceDOList",invoiceDOList);
	    return "mfrs/brand/add";
	}

	@GetMapping("/edit/{brandid}")
	@RequiresPermissions("mfrs:brand:edit")
	String edit(@PathVariable("brandid") Integer brandid,Model model){
		BrandDO brand = brandService.get(brandid);
		model.addAttribute("brand", brand);
	    return "mfrs/brand/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:brand:add")
	public R save( BrandDO brand){
		if(brandService.save(brand)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:brand:edit")
	public R update( BrandDO brand){
		brandService.update(brand);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:brand:remove")
	public R remove( Integer brandid){
		if(brandService.remove(brandid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:brand:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] brandids){
		brandService.batchRemove(brandids);
		return R.ok();
	}
	
}
