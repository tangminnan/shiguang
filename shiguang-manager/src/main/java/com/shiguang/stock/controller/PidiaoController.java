package com.shiguang.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.baseinfomation.service.impl.DepartmentServiceImpl;
import com.shiguang.common.utils.*;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.mfrs.service.GoodsService;
import com.shiguang.mfrs.service.PositionService;
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

import com.shiguang.stock.domain.PidiaoDO;
import com.shiguang.stock.service.PidiaoService;

/**
 * 批调表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-08-26 14:50:55
 */
 
@Controller
@RequestMapping("/stock/pidiao")
public class PidiaoController {
	@Autowired
	private PidiaoService pidiaoService;
	//部门
	@Autowired
	private DepartmentService departmentService;
	//公司
	@Autowired
	private CompanyService companyService;
	//商品类别
	@Autowired
	private GoodsService goodsService;
	//仓位
	@Autowired
	private PositionService positionService;
	@GetMapping()
	@RequiresPermissions("stock:pidiao:pidiao")
	String Pidiao(){
	    return "stock/pidiao/pidiao";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("stock:pidiao:pidiao")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PidiaoDO> pidiaoList = pidiaoService.list(query);
		int total = pidiaoService.count(query);
		PageUtils pageUtils = new PageUtils(pidiaoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("stock:pidiao:add")
	String add(Model model){
		//———生成单据编号————
		Long uuid = GuuidUtil.getUUID();
		String pidiaoNum = "PD" + uuid.toString();
		model.addAttribute("pidiaoNum", pidiaoNum);
		//部门
		Map<String, Object> map = new HashMap<>();
		//———获取当前登录用户的公司id————
		String companyId=ShiroUtils.getUser().getCompanyId();
		if(companyId == null){
			String departNumber=ShiroUtils.getUser().getStoreNum();
			map.put("departNumber",departNumber);
		}else if (companyId != null){
			map.put("companyId",companyId);
		}
		map.put("status","0");
		List<DepartmentDO> departmentDOList = departmentService.list(map);
		model.addAttribute("departmentDOList", departmentDOList);

		map.put("xsstate",0);
		List<CompanyDO> companyList = companyService.list(map);
		model.addAttribute("companyList", companyList);
		return "stock/pidiao/add";
	}
	//发出仓位
	@ResponseBody
	@RequestMapping(value = "/outposion")
	public List<PidiaoDO> outposion(String outDepartment, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("outDepartment", outDepartment);
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
		return outPositiion;
	}
	//接收部门
	@ResponseBody
	@RequestMapping(value = "/indepartment")
	public List<PidiaoDO> indepartment(String inCompany, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("inCompany", inCompany);
		List<PidiaoDO> indepartment = pidiaoService.indepartment(map);
		model.addAttribute("indepartment", indepartment);
		return indepartment;
	}
	//接收仓位
	@ResponseBody
	@RequestMapping(value = "/inposion")
	public List<PidiaoDO> inposion(String inDepartment, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("inDepartment", inDepartment);
		List<PidiaoDO> outPositiion = pidiaoService.outPosition(map);
		model.addAttribute("outPositiion", outPositiion);
		return outPositiion;
	}
	//跳转库存查询
	@GetMapping("/selextkc")
	String selextkc(Model model) {
		Map<String, Object> map = new HashMap<>();
		//商品
		List<GoodsDO> goodsDOList = goodsService.list(map);
		model.addAttribute("goodsDOList", goodsDOList);
		//仓位
		map.put("xsstate", 0);
		List<PositionDO> positionList = positionService.stockList(map);
		model.addAttribute("positionList", positionList);
		return "/stock/pidiao/selectGoods";
	}


	@GetMapping("/edit/{id}")
	@RequiresPermissions("stock:pidiao:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PidiaoDO pidiao = pidiaoService.get(id);
		model.addAttribute("pidiao", pidiao);
	    return "stock/pidiao/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("stock:pidiao:add")
	public R save( PidiaoDO pidiao){
		if(pidiaoService.save(pidiao)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("stock:pidiao:edit")
	public R update( PidiaoDO pidiao){
		pidiaoService.update(pidiao);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:remove")
	public R remove( Long id){
		if(pidiaoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("stock:pidiao:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		pidiaoService.batchRemove(ids);
		return R.ok();
	}
	
}
