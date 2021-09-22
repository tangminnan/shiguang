package com.shiguang.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.product.domain.HcDO;
import com.shiguang.storeSales.domain.SalesDO;
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

/**
 * 委外表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-15 11:26:24
 */
 
@Controller
@RequestMapping("/stock/weiwai")
public class WeiwaiController {
	@Autowired
	private WeiwaiService weiwaiService;
	@Autowired
	private DepartmentService departmentService;

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
		List<WeiwaiDO> weiwaiList = weiwaiService.list(query);
		int total = weiwaiService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwai:add")
	String add(Model model){
		//———生成单据编号————
		Long uuid = GuuidUtil.getUUID();
		String danjuNumber = "OUT" + uuid.toString();
		model.addAttribute("danjuNumber", danjuNumber);
		//———获取当前系统时间—————
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
		Date date = new Date();
		String danjuDay = sdf.format(date);
		model.addAttribute("danjuDay", danjuDay);
		//———获取当前登录用户的名称————
		model.addAttribute("zhidanPeople", ShiroUtils.getUser().getName());
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			String departNumber=ShiroUtils.getUser().getStoreNum();
			DepartmentDO departmentDO= weiwaiService.phoneOrAddres(departNumber);
			String departTel=departmentDO.getDepartTel();
			String departAddress=departmentDO.getDepartAddress();
			model.addAttribute("departTel",departTel);
			model.addAttribute("departAddress",departAddress);
		}else if (companyId != null){
			model.addAttribute("departTel","");
			model.addAttribute("departAddress","");
		}

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

//外部配镜单查询
@GetMapping("/getGoods/{eyeStyle}/{mfrsid}/{zhidanPeople}")
String getGoods(@PathVariable("eyeStyle") Integer eyeStyle,@PathVariable("mfrsid") Integer mfrsid,@PathVariable("zhidanPeople") String zhidanPeople, Model model) {
	//商品类别
	if (eyeStyle == 3){
		model.addAttribute("eyeStyles", "框镜订做");
		model.addAttribute("eyeStyle", eyeStyle);
	}else if (eyeStyle == 4){
		model.addAttribute("eyeStyles", "隐形订做");
		model.addAttribute("eyeStyle", eyeStyle);
	}
	model.addAttribute("mfrsid",mfrsid);
	model.addAttribute("zhidanPeople",zhidanPeople);
	//———生成单据编号————
	Long uuid = GuuidUtil.getUUID();
	String danjunum = "W" + uuid.toString();
	model.addAttribute("danjunum", danjunum);

	//———获取当前系统时间—————
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//yyyy-MM-dd HH:mm:ss
	Date date = new Date();
	String newDate = sdf.format(date);
	model.addAttribute("danjuDay", newDate);
	//部门
	Map<String, Object> map = new HashMap<>();
	//———获取当前登录用户的公司id————
	//String departNumber=ShiroUtils.getUser().getStoreNum();
	if(null != ShiroUtils.getUser().getStoreNum()){
		map.put("departNumber",ShiroUtils.getUser().getStoreNum());
	}else {
		map.put("departNumber","");
	}
	model.addAttribute("departmentName",ShiroUtils.getUser().getStore());
//	return "/stock/weiwai/getGoods";
	return "/stock/weiwaishuju/add";
}



	@GetMapping("/PeiJing/{eyeStyle}")
	String PeiJing(@PathVariable("eyeStyle") Integer eyeStyle, Model model) {
		model.addAttribute("eyeStyle",eyeStyle);
		return "/stock/weiwai/yuanPeiJing";
	}
	//销售单
	@ResponseBody
	@RequestMapping(value = "/selectOrder")
	public List<SalesDO> orderList(Integer eyeStyle, Model model) {
		Map<String, Object> map = new HashMap<>();
		if (eyeStyle == 3){
			map.put("classtype", "2");
			map.put("eyeStyles", "框镜");
		}else if (eyeStyle == 4){
			map.put("classtype", "2");
			map.put("eyeStyles", "隐形");
		}
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			String departNumber=ShiroUtils.getUser().getStoreNum();
			map.put("departNumber",departNumber);
		}else if (companyId != null){
			map.put("departNumber","");
		}
		List<SalesDO> selectOrder = weiwaiService.selectOrder(map);
		model.addAttribute("selectOrder", selectOrder);
		return selectOrder;
	}

	
}
