package com.shiguang.mfrs.controller;

import java.util.List;
import java.util.Map;

import com.shiguang.common.config.BootdoConfig;
import com.shiguang.common.utils.FileUtil;
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

import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公司维护表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-10 15:09:26
 */
 
@Controller
@RequestMapping("/mfrs/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("mfrs:company:company")
	String Company(){
	    return "mfrs/company/company";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("mfrs:company:company")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CompanyDO> companyList = companyService.list(query);
		int total = companyService.count(query);
		PageUtils pageUtils = new PageUtils(companyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("mfrs:company:add")
	String add(){
	    return "mfrs/company/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("mfrs:company:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CompanyDO company = companyService.get(id);
		model.addAttribute("company", company);
	    return "mfrs/company/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("mfrs:company:add")
	public R save( CompanyDO company){
		try{
			MultipartFile file = company.getImgFile();
			if(file!=null && file.getSize()>0){
				String fileName = FileUtil.renameToUUID(file.getOriginalFilename());
				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setLogo("/files/company/"+fileName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		try{
			MultipartFile file1 = company.getImgFile1();
			if(file1!=null && file1.getSize()>0){
				String fileName = FileUtil.renameToUUID(file1.getOriginalFilename());
				FileUtil.uploadFile(file1.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setBackgroundimage("/files/company/"+fileName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		try{
			MultipartFile file2= company.getImgFile2();
			if(file2!=null && file2.getSize()>0){
				String fileName = FileUtil.renameToUUID(file2.getOriginalFilename());
				FileUtil.uploadFile(file2.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setDepartmentimage("/files/company/"+fileName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(companyService.save(company)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("mfrs:company:edit")
	public R update( CompanyDO company){
		try{
			MultipartFile file = company.getImgFile();
			if(file!=null && file.getSize()>0){
				String fileName = FileUtil.renameToUUID(file.getOriginalFilename());
				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setLogo("/files/company/"+fileName);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		try{
			MultipartFile file1 = company.getImgFile1();
			if(file1!=null && file1.getSize()>0){
				String fileName = FileUtil.renameToUUID(file1.getOriginalFilename());
				FileUtil.uploadFile(file1.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setBackgroundimage("/files/company/"+fileName);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		try{
			MultipartFile file2 = company.getImgFile2();
			if(file2!=null && file2.getSize()>0){
				String fileName = FileUtil.renameToUUID(file2.getOriginalFilename());
				FileUtil.uploadFile(file2.getBytes(), bootdoConfig.getUploadPath()+"company/", fileName);
				company.setDepartmentimage("/files/company/"+fileName);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		companyService.update(company);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("mfrs:company:remove")
	public R remove( Integer id){
		if(companyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("mfrs:company:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		companyService.batchRemove(ids);
		return R.ok();
	}
	
}
