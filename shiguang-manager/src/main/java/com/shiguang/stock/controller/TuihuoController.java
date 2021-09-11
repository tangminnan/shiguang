package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.BrandService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;
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

import com.shiguang.stock.domain.TuihuoDO;
import com.shiguang.stock.service.TuihuoService;

/**
 * 退货表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-10 18:05:35
 */
 
@Controller
@RequestMapping("/stock/tuihuo")
public class TuihuoController {
	@Autowired
	private TuihuoService tuihuoService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	//品牌
	@Autowired
	private BrandService brandService;
	//批调
	@Autowired
	private PidiaoService pidiaoService;
	
	@GetMapping()
	@RequiresPermissions("stock:tuihuo:tuihuo")
	String Tuihuo(){
	    return "stock/tuihuo/tuihuo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:tuihuo:tuihuo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TuihuoDO> tuihuoList = tuihuoService.list(query);
		int total = tuihuoService.count(query);
		PageUtils pageUtils = new PageUtils(tuihuoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:tuihuo:add")
	String add(Model model){
		//———生成验光号————
		Long uuid = GuuidUtil.getUUID();
		String uuidstr = "TH" + uuid.toString();
		model.addAttribute("uuidstr", uuidstr);
		//———获取当前登录用户的名称————
		model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String danjuDay = sdf.format(date);
		model.addAttribute("danjuDay", danjuDay);

		//部门
		Map<String, Object> map = new HashMap<>();
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			String outDepartment=ShiroUtils.getUser().getStoreNum();
			map.put("outDepartment",outDepartment);
		}else if (companyId != null){
			map.put("companyId",companyId);
		}
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
	    return "stock/tuihuo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:tuihuo:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TuihuoDO tuihuo = tuihuoService.get(id);
		model.addAttribute("tuihuo", tuihuo);
	    return "stock/tuihuo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:tuihuo:add")
	public R save( TuihuoDO tuihuo){
		if(tuihuoService.save(tuihuo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:tuihuo:edit")
	public R update( TuihuoDO tuihuo){
		tuihuoService.update(tuihuo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:tuihuo:remove")
	public R remove( Long id){
		if(tuihuoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:tuihuo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		tuihuoService.batchRemove(ids);
		return R.ok();
	}
	//跳转制造商
	@GetMapping("/findmfrs")
	@RequiresPermissions("stock:tuihuo:findmfrs")
	String findmfrs( Model model) {
		Map<String, Object> map = new HashMap<>();
		//商品
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		return "/stock/tuihuo/findmfrs";
	}
	//跳转库存查询
	@GetMapping("/getGood/{positionId}/{positionName}/{mfrsid}/{mfrsName}")
	String getGood(@PathVariable("positionId") String positionId,@PathVariable("positionName") String positionName,
				   @PathVariable("mfrsid") Integer  mfrsid,@PathVariable("mfrsName") String mfrsName,Model model) {
		Map<String, Object> map = new HashMap<>();
		//商品
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		model.addAttribute("positionId", positionId);
		model.addAttribute("positionName", positionName);
		model.addAttribute("mfrsid", mfrsid);
		model.addAttribute("mfrsName", mfrsName);
		return "/stock/tuihuo/getGood";
	}

}
