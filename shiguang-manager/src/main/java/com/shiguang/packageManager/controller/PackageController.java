<<<<<<< HEAD
package com.shiguang.packageManager.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.GuuidUtil;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.*;
import com.shiguang.mfrs.service.*;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.domain.PackageInfoDO;
import com.shiguang.packageManager.service.PackageInfoService;
import com.shiguang.packageManager.service.PackageService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
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
 * 套餐表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-13 13:48:48
 */
 
@Controller
@RequestMapping("/information/package")
public class PackageController {
	@Autowired
	private PackageService packageService;
	@Autowired
	private PackageInfoService packageInfoService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RefractivityService refractivityService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private LightService lightService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private ProducaService producaService;
	@Autowired
	private PartsService partsService;
	@Autowired
	private JpcpService jpcpService;
	@Autowired
	private JpdzService jpdzService;
	@Autowired
	private TyjService tyjService;
	@Autowired
	private OldlensService oldlensService;
	@Autowired
	private HcService hcService;
	@Autowired
	private ShiguangService shiguangService;
	@Autowired
	private HlyService hlyService;
	@Autowired
	private TypeService typeService;
	
	@GetMapping()
	@RequiresPermissions("information:package:package")
	String Package(){
	    return "packageInfo/package";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:package:package")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PackageDO> packageList = packageService.list(query);
		int total = packageService.count(query);
		PageUtils pageUtils = new PageUtils(packageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:package:add")
	String add(Model model){
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
		Map<String,Object> map = new HashMap<>();
		//镜架材质
		List<MaterialDO> materialDOList = materialService.list(map);
		model.addAttribute("materialDOList",materialDOList);
		//折射率
		List<RefractivityDO> refractivityDOList = refractivityService.list(map);
		model.addAttribute("refractivityDOList",refractivityDOList);
		//光度分类
		List<LightDO> lightDOList = lightService.list(map);
		model.addAttribute("lightDOList",lightDOList);
		//镜片功能
		List<FunctionDO> functionDOList = functionService.list(map);
		model.addAttribute("functionDOList",functionDOList);
		//抛弃型分类
		List<TypeDO> typeDOList = typeService.list(map);
		model.addAttribute("typeDOList",typeDOList);
	    return "packageInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:package:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PackageDO packages = packageService.get(id);
		model.addAttribute("package", packages);
	    return "packageInfo/edit";
	}

	@GetMapping("/store")
	@RequiresPermissions("information:package:store")
	String store(){
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
		return "packageInfo/store";
	}

	@ResponseBody
	@GetMapping("/storelist")
	@RequiresPermissions("information:package:store")
	public PageUtils storelist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		query.put("departType","销售门店");
		query.put("state",1);
		List<DepartmentDO> departmentDOList = departmentService.list(query);
		int total = departmentService.count(query);
		PageUtils pageUtils = new PageUtils(departmentDOList, total);
		return pageUtils;
	}

	@GetMapping("/goodsInfo/{goodsType}")
	@RequiresPermissions("information:package:goodsInfo")
	String goodsInfo(@PathVariable("goodsType") String goodsType,Model model){
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
		model.addAttribute("goodsType",goodsType);
		return "packageInfo/goodsInfo";
	}

	@ResponseBody
	@GetMapping("/goodsInfolist")
	@RequiresPermissions("information:package:goodsInfo")
	public PageUtils goodsInfolist(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<ProducaDO> producaDOList =new ArrayList<>();
		List<PartsDO> partsDOList = new ArrayList<>();
		List<JpcpDO> jpcpDOList = new ArrayList<>();
		List<JpdzDO> jpdzDOList = new ArrayList<>();
		List<TyjDO> tyjDOList = new ArrayList<>();
		List<OldlensDO> oldlensDOList = new ArrayList<>();
		List<HcDO> hcDOList = new ArrayList<>();
		List<ShiguangDO> shiguangDOList = new ArrayList<>();
		List<HlyDO> hlyDOList = new ArrayList<>();
		PageUtils pageUtils = null;
		if ("镜架".equals(query.get("goodsType"))){
			producaDOList = producaService.list(query);
//			if(null != producaDOList && producaDOList.size() > 0){
//				for (ProducaDO producaDO : producaDOList){
//					producaDO.
//				}
//			}
			int total = producaService.count(query);
			pageUtils = new PageUtils(producaDOList, total);
		} else if ("配件".equals(query.get("goodsType"))){
			partsDOList = partsService.list(query);
			int total = partsService.count(query);
			pageUtils = new PageUtils(partsDOList, total);
		} else if ("成品片".equals(query.get("goodsType"))){
			jpcpDOList = jpcpService.list(query);
			int total = jpcpService.count(query);
			pageUtils = new PageUtils(jpcpDOList, total);
		} else if ("订做片".equals(query.get("goodsType"))){
			jpdzDOList = jpdzService.listDz(query);
			int total = jpdzService.countDz(query);
			pageUtils = new PageUtils(jpdzDOList, total);
		} else if ("太阳镜".equals(query.get("goodsType"))){
			tyjDOList = tyjService.list(query);
			int total = tyjService.count(query);
			pageUtils = new PageUtils(tyjDOList,total);
		} else if ("老花镜".equals(query.get("goodsType"))){
			oldlensDOList = oldlensService.list(query);
			int total = oldlensService.count(query);
			pageUtils = new PageUtils(oldlensDOList,total);
		} else if ("耗材".equals(query.get("goodsType"))){
			hcDOList = hcService.list(query);
			int total = hcService.count(query);
			pageUtils = new PageUtils(hcDOList,total);
		} else if ("视光".equals(query.get("goodsType"))){
			shiguangDOList = shiguangService.list(query);
			int total = shiguangService.count(query);
			pageUtils = new PageUtils(shiguangDOList,total);
		} else if ("隐形护理液".equals(query.get("goodsType"))){
			hlyDOList = hlyService.list(query);
			int total = hlyService.count(query);
			pageUtils = new PageUtils(hlyDOList,total);
		}
//		List<DepartmentDO> departmentDOList = departmentService.list(query);
//		int total = departmentService.count(query);
//		PageUtils pageUtils = new PageUtils(departmentDOList, total);
		return pageUtils;
	}

	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:package:detail")
	String detail(@PathVariable("id") Long id,Model model){
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		PackageDO packageDO = packageService.get(id);
		packageDO.setPackageDate(simpleDateFormat.format(packageDO.getPackageTime()));
		packageDO.setEffectiveTime(simpleDateFormat.format(packageDO.getEffectiveDate()));
		packageDO.setExpiryTime(simpleDateFormat.format(packageDO.getExpiryDate()));
		model.addAttribute("package",packageDO);
		return "packageInfo/detail";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:package:add")
	public R save(PackageDO packages){
		Long packageId = GuuidUtil.getUUID();
		packages.setPackageId(packageId);
		int pack = packageService.save(packages);
		PackageInfoDO packageInfoDO = new PackageInfoDO();
		packageInfoDO.setPackageId(packageId);
		packageInfoDO.setGoodsType(packages.getGoodsType());
		packageInfoDO.setGoodsCode(packages.getGoodsCode());
		packageInfoDO.setGoodsName(packages.getGoodsName());
		packageInfoDO.setBuyWay(packages.getBuyWay());
		packageInfoDO.setPackageStartPrice(packages.getPackageStartPrice());
		packageInfoDO.setPackageEndPrice(packages.getPackageEndPrice());
		packageInfoDO.setSaleNumber(packages.getSaleNumber());
		packageInfoDO.setFullStartPrice(packages.getFullStartPrice());
		packageInfoDO.setFullEndPrice(packages.getFullEndPrice());
		packageInfoDO.setPreferentialWay(packages.getPreferentialWay());
		packageInfoDO.setPreferentialPrice(packages.getPreferentialPrice());
		packageInfoDO.setUnitPrice(packages.getUnitPrice());
		packageInfoDO.setSpecialPrice(packages.getSpecialPrice());
		packageInfoDO.setPreferentialRebate(packages.getPreferentialRebate());
		int packinfo = packageInfoService.save(packageInfoDO);
		if (pack > 0 && packinfo > 0){
			return R.ok();
		}
//		if(packageService.save(packages)>0){
//			return R.ok();
//		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:package:edit")
	public R update( PackageDO packages){
		packageService.update(packages);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:package:remove")
	public R remove( Long id){
		if(packageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:package:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		packageService.batchRemove(ids);
		return R.ok();
	}
	
}
=======
package com.shiguang.packageManager.controller;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.mfrs.domain.FunctionDO;
import com.shiguang.mfrs.domain.LightDO;
import com.shiguang.mfrs.domain.MaterialDO;
import com.shiguang.mfrs.domain.RefractivityDO;
import com.shiguang.mfrs.service.FunctionService;
import com.shiguang.mfrs.service.LightService;
import com.shiguang.mfrs.service.MaterialService;
import com.shiguang.mfrs.service.RefractivityService;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.service.PackageService;
import com.shiguang.product.domain.*;
import com.shiguang.product.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 套餐表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-13 13:48:48
 */

@Controller
@RequestMapping("/information/package")
public class PackageController {
    @Autowired
    private PackageService packageService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RefractivityService refractivityService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private LightService lightService;
    @Autowired
    private FunctionService functionService;
    @Autowired
    private ProducaService producaService;
    @Autowired
    private PartsService partsService;
    @Autowired
    private JpcpService jpcpService;
    @Autowired
    private JpdzService jpdzService;
    @Autowired
    private TyjService tyjService;
    @Autowired
    private OldlensService oldlensService;
    @Autowired
    private HcService hcService;
    @Autowired
    private ShiguangService shiguangService;
    @Autowired
    private HlyService hlyService;

    @GetMapping()
    @RequiresPermissions("information:package:package")
    String Package() {
        return "packageInfo/package";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:package:package")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PackageDO> packageList = packageService.list(query);
        int total = packageService.count(query);
        PageUtils pageUtils = new PageUtils(packageList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("information:package:add")
    String add(Model model) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
        Map<String, Object> map = new HashMap<>();
        //镜架材质
        List<MaterialDO> materialDOList = materialService.list(map);
        model.addAttribute("materialDOList", materialDOList);
        //折射率
        List<RefractivityDO> refractivityDOList = refractivityService.list(map);
        model.addAttribute("refractivityDOList", refractivityDOList);
        //光度分类
        List<LightDO> lightDOList = lightService.list(map);
        model.addAttribute("lightDOList", lightDOList);
        //镜片功能
        List<FunctionDO> functionDOList = functionService.list(map);
        model.addAttribute("functionDOList", functionDOList);
        return "packageInfo/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:package:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        PackageDO packages = packageService.get(id);
        model.addAttribute("package", packages);
        return "packageInfo/edit";
    }

    @GetMapping("/store")
    @RequiresPermissions("information:package:store")
    String store() {
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
        return "packageInfo/store";
    }

    @ResponseBody
    @GetMapping("/storelist")
    @RequiresPermissions("information:package:store")
    public PageUtils storelist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        query.put("departType", "销售门店");
        query.put("state", 1);
        List<DepartmentDO> departmentDOList = departmentService.list(query);
        int total = departmentService.count(query);
        PageUtils pageUtils = new PageUtils(departmentDOList, total);
        return pageUtils;
    }

    @GetMapping("/goodsInfo/{goodsType}")
    @RequiresPermissions("information:package:goodsInfo")
    String goodsInfo(@PathVariable("goodsType") String goodsType, Model model) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("departType","销售门店");
//		map.put("state",1);
//		List<DepartmentDO> departmentDOList = departmentService.list(map);
//		model.addAttribute("departmentDOList",departmentDOList);
        model.addAttribute("goodsType", goodsType);
        return "packageInfo/goodsInfo";
    }

    @ResponseBody
    @GetMapping("/goodsInfolist")
    @RequiresPermissions("information:package:goodsInfo")
    public PageUtils goodsInfolist(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ProducaDO> producaDOList = new ArrayList<>();
        List<PartsDO> partsDOList = new ArrayList<>();
        List<JpcpDO> jpcpDOList = new ArrayList<>();
        List<JpdzDO> jpdzDOList = new ArrayList<>();
        List<TyjDO> tyjDOList = new ArrayList<>();
        List<OldlensDO> oldlensDOList = new ArrayList<>();
        List<HcDO> hcDOList = new ArrayList<>();
        List<ShiguangDO> shiguangDOList = new ArrayList<>();
        List<HlyDO> hlyDOList = new ArrayList<>();
        PageUtils pageUtils = null;
        if ("镜架".equals(query.get("goodsType"))) {
            producaDOList = producaService.list(query);
//			if(null != producaDOList && producaDOList.size() > 0){
//				for (ProducaDO producaDO : producaDOList){
//					producaDO.
//				}
//			}
            int total = producaService.count(query);
            pageUtils = new PageUtils(producaDOList, total);
        } else if ("配件".equals(query.get("goodsType"))) {
            partsDOList = partsService.list(query);
            int total = partsService.count(query);
            pageUtils = new PageUtils(partsDOList, total);
        } else if ("成品片".equals(query.get("goodsType"))) {
            jpcpDOList = jpcpService.list(query);
            int total = jpcpService.count(query);
            pageUtils = new PageUtils(jpcpDOList, total);
        } else if ("订做片".equals(query.get("goodsType"))) {
            jpdzDOList = jpdzService.listDz(query);
            int total = jpdzService.countDz(query);
            pageUtils = new PageUtils(jpdzDOList, total);
        } else if ("太阳镜".equals(query.get("goodsType"))) {
            tyjDOList = tyjService.list(query);
            int total = tyjService.count(query);
            pageUtils = new PageUtils(tyjDOList, total);
        } else if ("老花镜".equals(query.get("goodsType"))) {
            oldlensDOList = oldlensService.list(query);
            int total = oldlensService.count(query);
            pageUtils = new PageUtils(oldlensDOList, total);
        } else if ("耗材".equals(query.get("goodsType"))) {
            hcDOList = hcService.list(query);
            int total = hcService.count(query);
            pageUtils = new PageUtils(hcDOList, total);
        } else if ("视光".equals(query.get("goodsType"))) {
            shiguangDOList = shiguangService.list(query);
            int total = shiguangService.count(query);
            pageUtils = new PageUtils(shiguangDOList, total);
        } else if ("隐形护理液".equals(query.get("goodsType"))) {
            hlyDOList = hlyService.list(query);
            int total = hlyService.count(query);
            pageUtils = new PageUtils(hlyDOList, total);
        }
//		List<DepartmentDO> departmentDOList = departmentService.list(query);
//		int total = departmentService.count(query);
//		PageUtils pageUtils = new PageUtils(departmentDOList, total);
        return pageUtils;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:package:add")
    public R save(PackageDO packages) {
        if (packageService.save(packages) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("information:package:edit")
    public R update(PackageDO packages) {
        packageService.update(packages);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:package:remove")
    public R remove(Long id) {
        if (packageService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:package:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        packageService.batchRemove(ids);
        return R.ok();
    }

}
>>>>>>> 8ab39c1aa472f433caf74281658d3a965d62bf87
