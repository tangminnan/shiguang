package com.shiguang.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.MaterialService;
import com.shiguang.mfrs.service.MfrsService;
import com.shiguang.mfrs.service.UnitService;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.domain.TechnologyDO;
import com.shiguang.product.service.StyleService;
import com.shiguang.product.service.TechnologyService;
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

import com.shiguang.product.domain.ProducaDO;
import com.shiguang.product.service.ProducaService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;

import javax.rmi.CORBA.Util;

/**
 * 镜架新增表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
 
@Controller
@RequestMapping("/product/produca")
public class ProducaController {
	@Autowired
	private ProducaService producaService;
    //制造商
    @Autowired
    private MfrsService mfrsService;
	//计量单位
	@Autowired
	private UnitService unitService;
	//款式
	@Autowired
	private StyleService styleService;
	//工艺类型
	@Autowired
	private TechnologyService technologyService;
	//镜架材质
	@Autowired
	private MaterialService materialService;
	
	@GetMapping()
	@RequiresPermissions("product:produca:produca")
	String Produca(Model model){
		Map<String,Object> map=new HashMap<>();
		//制造商
		List<MgDO> mfrsDOList = producaService.mglist(map);
		model.addAttribute("mfrsDOList", mfrsDOList);
		//计量单位
		List<UnitDO> unitDOList = unitService.list(map);
		model.addAttribute("unitDOList", unitDOList);
		//款式
		List<StyleDO> styleDOList = styleService.list(map);
		model.addAttribute("styleDOList", styleDOList);
		//工艺类型
		List<TechnologyDO> technologyDOList = technologyService.list(map);
		model.addAttribute("technologyDOList", technologyDOList);
		//镜架材质
		List<MaterialDO> materialDOList = materialService.list(map);
		model.addAttribute("materialDOList", materialDOList);
	    return "product/produca/produca";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:produca:produca")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProducaDO> producaList = producaService.list(query);
		int total = producaService.count(query);
		PageUtils pageUtils = new PageUtils(producaList, total);
		return pageUtils;
	}

	
	@GetMapping("/add")
	@RequiresPermissions("product:produca:add")
	String add(Model model){
		Map<String,Object> map=new HashMap<>();
        //制造商
        List<MgDO> mfrsDOList = producaService.mglist(map);
        model.addAttribute("mfrsDOList", mfrsDOList);
		//计量单位
		List<UnitDO> unitDOList = unitService.list(map);
		model.addAttribute("unitDOList", unitDOList);
		//款式
		List<StyleDO> styleDOList = styleService.list(map);
		model.addAttribute("styleDOList", styleDOList);
		//工艺类型
		List<TechnologyDO> technologyDOList = technologyService.list(map);
		model.addAttribute("technologyDOList", technologyDOList);
		//镜架材质
		List<MaterialDO> materialDOList = materialService.list(map);
		model.addAttribute("materialDOList", materialDOList);
	    return "product/produca/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:produca:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ProducaDO produca = producaService.get(id);
		model.addAttribute("produca", produca);
	    return "product/produca/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:produca:add")
	public R save( ProducaDO produca){
		if(producaService.save(produca)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:produca:edit")
	public R update( ProducaDO produca){
		producaService.update(produca);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:produca:remove")
	public R remove( Long id){
		if(producaService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:produca:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		producaService.batchRemove(ids);
		return R.ok();
	}
	//制造商——商品类别菜单下来选择
	@ResponseBody
	@RequestMapping(value = "/choice")
	List<BrandDO> choice(Integer mfrsid, Model model) {
		List<BrandDO> brandDOList = producaService.choice(mfrsid);
		model.addAttribute("brandDOList", brandDOList);
		return brandDOList;
	}

}
