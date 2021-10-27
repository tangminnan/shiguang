package com.shiguang.stock.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.product.domain.HcDO;
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

import com.shiguang.stock.domain.WeiwaishujuDO;
import com.shiguang.stock.service.WeiwaishujuService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-18 18:14:35
 */
 
@Controller
@RequestMapping("/stock/weiwaishuju")
public class WeiwaishujuController {
	@Autowired
	private WeiwaishujuService weiwaishujuService;
	
	@GetMapping()
	@RequiresPermissions("stock:weiwaishuju:weiwaishuju")
	String Weiwaishuju(){
	    return "stock/weiwaishuju/weiwaishuju";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:weiwaishuju:weiwaishuju")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WeiwaishujuDO> weiwaishujuList = weiwaishujuService.list(query);
		int total = weiwaishujuService.count(query);
		PageUtils pageUtils = new PageUtils(weiwaishujuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:weiwaishuju:add")
	String add(){
	    return "stock/weiwaishuju/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:weiwaishuju:edit")
	String edit(@PathVariable("id") Long id,Model model){
		WeiwaishujuDO weiwaishuju = weiwaishujuService.get(id);
		model.addAttribute("weiwaishuju", weiwaishuju);
	    return "stock/weiwaishuju/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( WeiwaishujuDO weiwaishuju){
		if (weiwaishuju.getCode()!="" && weiwaishuju.getCode()!=null){
			String[] codeskc=weiwaishuju.getCode().split(",");
			String codeKcs="";
			for (int i=0;i<codeskc.length;i++){
				codeKcs += codeskc[i]+"00000000,";
			}
			weiwaishuju.setCode(codeKcs);
		}
		if (weiwaishuju.getCodeyx()!="" && weiwaishuju.getCodeyx() != null){
			String[] codeskcyx=weiwaishuju.getCodeyx().split(",");
			String codeKcsyx="";
			for (int i=0;i<codeskcyx.length;i++){
				codeKcsyx += codeskcyx[i]+"00000000,";
			}
			weiwaishuju.setCodeyx(codeKcsyx);
		}
		if(weiwaishujuService.save(weiwaishuju)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:weiwaishuju:edit")
	public R update( WeiwaishujuDO weiwaishuju){
		weiwaishujuService.update(weiwaishuju);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaishuju:remove")
	public R remove( Long id){
		if(weiwaishujuService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:weiwaishuju:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		weiwaishujuService.batchRemove(ids);
		return R.ok();
	}


	//得到委外数据
	@ResponseBody
	@RequestMapping(value = "/getWeiwaiShuju")
	public List<WeiwaishujuDO> getWeiwaiShuju(String number, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("number", number);
		List<WeiwaishujuDO> weiwaiShuju = weiwaishujuService.getWeiwaiShuju(map);
		model.addAttribute("weiwaiShuju", weiwaiShuju);
		return weiwaiShuju;
	}


}
