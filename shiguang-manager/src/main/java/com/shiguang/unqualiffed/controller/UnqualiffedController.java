package com.shiguang.unqualiffed.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import com.shiguang.storeSales.domain.SaleGoodsDO;
import com.shiguang.storeSales.domain.SalesDO;
import com.shiguang.storeSales.service.SalesService;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.UserService;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import com.shiguang.unqualiffed.service.UnqualiffedService;
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
 * 不合格表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
 
@Controller
@RequestMapping("/information/unqualiffed")
public class UnqualiffedController {
	@Autowired
	private UnqualiffedService unqualiffedService;
	@Autowired
	private UserService userService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private SalesService salesService;
	
	@GetMapping()
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	String Unqualiffed(){
	    return "unqualiffed/unqualiffed";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:unqualiffed:unqualiffed")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("companyId",ShiroUtils.getUser().getCompanyId());
		}
		List<UnqualiffedDO> unqualiffedList = unqualiffedService.list(query);
		int total = unqualiffedService.count(query);
		PageUtils pageUtils = new PageUtils(unqualiffedList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:unqualiffed:add")
	String add(Model model){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String documentNumber = String.valueOf(GuuidUtil.getUUID());
		String preparedName = ShiroUtils.getUser().getName();
		String departmentAppli = ShiroUtils.getUser().getStore();
		String billDate = simpleDateFormat.format(new Date());
		Map<String,Object> map = new HashMap<>();
		map.put("roleType","6");
		List<UserDO> userDOList = userService.getRoleList(map);
		List<PositionDO> positionDOS = positionService.positionList(map);
		model.addAttribute("documentNumber",documentNumber);
		model.addAttribute("preparedName",preparedName);
		model.addAttribute("departmentAppli",departmentAppli);
		model.addAttribute("billDate",billDate);
		model.addAttribute("userDOList",userDOList);
		model.addAttribute("positionDOS",positionDOS);
	    return "unqualiffed/add";
	}

	@GetMapping("/goods")
	@RequiresPermissions("information:unqualiffed:goods")
	String goods(Model model){
		return "unqualiffed/goods";
	}

	/**
	 * 按配镜单添加商品
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/goodslist")
	@RequiresPermissions("information:unqualiffed:goods")
	public PageUtils goodslist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SalesDO> salesDOList = salesService.peijinglist(query);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (SalesDO salesDO : salesDOList){
			salesDO.setMirrorDate(simpleDateFormat.format(salesDO.getMirrorTime()));
			salesDO.setPeijingDate(simpleDateFormat.format(salesDO.getPeijingTime()));
		}
		for (int i=0;i<salesDOList.size();i++){
			List<SaleGoodsDO> list = new ArrayList<>();
			String[] storeDescribe = salesDOList.get(i).getStoreDescribe().split(",");
			String[] goodsCode = salesDOList.get(i).getGoodsCode().split(",");
			String[] goodsNum = salesDOList.get(i).getGoodsNum().split(",");
			String[] goodsName = salesDOList.get(i).getStoreName().split(",");
			String[] goodsCount = salesDOList.get(i).getStoreCount().split(",");
			for (int a=0;a<storeDescribe.length;a++){
				if ("镜片".equals(storeDescribe[a])){
					SaleGoodsDO saleGoodsDO = new SaleGoodsDO();
					saleGoodsDO.setGoodsCode(goodsCode[a]);
					saleGoodsDO.setGoodsNum(goodsNum[a]);
					saleGoodsDO.setGoodsName(goodsName[a]);
					saleGoodsDO.setSaleCount(goodsCount[a]);
					list.add(saleGoodsDO);
				}
			}
			salesDOList.get(i).setList(list);

		}
		int total = salesService.peijingcount(query);
		PageUtils pageUtils = new PageUtils(salesDOList, total);
		return pageUtils;
	}


	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:unqualiffed:edit")
	String edit(@PathVariable("id") Long id,Model model){
		UnqualiffedDO unqualiffed = unqualiffedService.get(id);
		model.addAttribute("unqualiffed", unqualiffed);
	    return "unqualiffed/edit";
	}

	@GetMapping("/salegoods")
	@RequiresPermissions("information:unqualiffed:salegoods")
	String salegoods(Model model){
		return "unqualiffed/saleGoods";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:unqualiffed:add")
	public R save(UnqualiffedDO unqualiffed){
		if(unqualiffedService.save(unqualiffed)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:unqualiffed:edit")
	public R update( UnqualiffedDO unqualiffed){
		unqualiffedService.update(unqualiffed);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:remove")
	public R remove( Long id){
		if(unqualiffedService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:unqualiffed:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		unqualiffedService.batchRemove(ids);
		return R.ok();
	}
	
}
