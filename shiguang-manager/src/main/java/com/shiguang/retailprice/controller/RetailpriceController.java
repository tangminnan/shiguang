package com.shiguang.retailprice.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.product.domain.ProducaDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiguang.retailprice.domain.RetailpriceDO;
import com.shiguang.retailprice.service.RetailpriceService;

/**
 * 零售价价格调整表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-01-08 14:42:35
 */
 
@Controller
@RequestMapping("/retailprice/retailprice")
public class RetailpriceController {
	@Autowired
	private RetailpriceService retailpriceService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	@GetMapping()
	@RequiresPermissions("retailprice:retailprice:retailprice")
	String Retailprice(){
	    return "retailprice/retailprice/retailprice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("retailprice:retailprice:retailprice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RetailpriceDO> retailpriceList = retailpriceService.list(query);
		int total = retailpriceService.count(query);
		PageUtils pageUtils = new PageUtils(retailpriceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("retailprice:retailprice:add")
	String add(Model model){

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String createTime=df.format(new Date());// new Date()为获取当前系统时间
//		Calendar cal = Calendar.getInstance();
//		int year = cal.get(Calendar.YEAR);//获取年份
//		int month=(cal.get(Calendar.MONTH))+1;//获取月份
//		int day=cal.get(Calendar.DATE);//获取日
//		int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
//		int minute=cal.get(Calendar.MINUTE);//分
//		int second=cal.get(Calendar.SECOND);//秒
//		String number="PC"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
		Long uuid = GuuidUtil.getUUID();
		String uuidstr = "PC" + uuid.toString();
		model.addAttribute("createTime",createTime);
		model.addAttribute("number",uuidstr);
		model.addAttribute("people", ShiroUtils.getUser().getName());
	    return "retailprice/retailprice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("retailprice:retailprice:edit")
	String edit(@PathVariable("id") Long id,Model model){
		RetailpriceDO retailprice = retailpriceService.get(id);
		model.addAttribute("retailprice", retailprice);
	    return "retailprice/retailprice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("retailprice:retailprice:add")
	public R save( RetailpriceDO retailprice){
		if(retailpriceService.save(retailprice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("retailprice:retailprice:edit")
	public R update( RetailpriceDO retailprice){
		retailpriceService.update(retailprice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("retailprice:retailprice:remove")
	public R remove( Long id){
		if(retailpriceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("retailprice:retailprice:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		retailpriceService.batchRemove(ids);
		return R.ok();
	}

	//品种选择
	@GetMapping("/getbrand")
	String findmfrs( Model model) {
		Map<String, Object> map = new HashMap<>();
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		return "/retailprice/retailprice/getBrand";
	}
	//镜架List
	@ResponseBody
	@RequestMapping("/jjlist")
	public PageUtils selectjingjia(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<ProducaDO> jjlist = retailpriceService.jjlist(query);
//		int total = retailpriceService.jjlistCount(query);
			int total = jjlist.size();
		PageUtils pageUtils = new PageUtils(jjlist, total);
		return pageUtils;
	}
}
