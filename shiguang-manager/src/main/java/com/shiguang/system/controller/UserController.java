package com.shiguang.system.controller;

import javax.servlet.http.HttpServletRequest;

import com.shiguang.baseinfomation.domain.DepartmentDO;
import com.shiguang.baseinfomation.service.DepartmentService;
import com.shiguang.mfrs.domain.CompanyDO;
import com.shiguang.mfrs.service.CompanyService;
import com.shiguang.system.obs.MultipartFileToFile;
import com.shiguang.system.obs.ObsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.shiguang.common.annotation.Log;
import com.shiguang.common.config.BootdoConfig;
import com.shiguang.common.config.Constant;
import com.shiguang.common.controller.BaseController;
import com.shiguang.common.domain.Tree;
import com.shiguang.common.service.DictService;
import com.shiguang.common.utils.*;
import com.shiguang.system.domain.DeptDO;
import com.shiguang.system.domain.RoleDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.service.RoleService;
import com.shiguang.system.service.UserService;
import com.shiguang.system.vo.UserVO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController {
	private String prefix="system/user"  ;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CompanyService companyService;
	
	
	@RequiresPermissions("sys:user:user")
	@GetMapping("")
	String user(Model model) {
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		String rname = "";
		List<UserDO> sysUserList = new ArrayList<>();
		int total = 0;
		if (null != ShiroUtils.getUser().getCompanyId()){
			query.put("roleType",5);
			String companyIds = ShiroUtils.getUser().getCompanyId();
			query.put("companyId",companyIds);
			sysUserList = userService.listManage(query);
			total = userService.countManage(query);
		} else {
			sysUserList = userService.list(query);
			Map<String,Object> map = new HashMap<>();
//			map.put("roleType",5);
			for(UserDO udo:sysUserList){
				List<RoleDO> rdol =roleService.listbyid(udo.getUserId(),map);
				for(int i=0;i<rdol.size();i++){
					rname =rname+ rdol.get(i).getRoleName();
					if(i<rdol.size()-1){
						rname =rname+",";
					}
				}
				udo.setRoleName(rname);
				rname = "";
			}
			total = userService.count(query);
		}



		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("sys:user:add") 
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		Map<String,Object> maps = new HashMap<>();
		maps.put("roleTypes",5);
		List<RoleDO> roles = roleService.list(maps);
		model.addAttribute("roles", roles);
		Map<String,Object> map = new HashMap<>();
		map.put("departType","销售门店");
		//UserDO userDO = ShiroUtils.getUser();
		if (null != ShiroUtils.getUser().getCompanyId()){
			String companyIds = ShiroUtils.getUser().getCompanyId();
			map.put("companyId",companyIds);
		}
		List<DepartmentDO> storeList = departmentService.list(map);
		model.addAttribute("storeList",storeList);
		return prefix + "/add";
	}

	@RequiresPermissions("sys:user:addManager")
	@Log("添加管理员")
	@GetMapping("/addManager")
	String addManager(Model model) {
		Map<String,Object> maps = new HashMap<>();
		maps.put("roleType",5);
		List<RoleDO> roles = roleService.list(maps);
		model.addAttribute("roles", roles);
		Map<String,Object> map = new HashMap<>();
		//map.put("departType","销售门店");
		//List<DepartmentDO> storeList = departmentService.list(map);
		List<CompanyDO> companyDOList =companyService.list(map);
		model.addAttribute("companyDOList",companyDOList);
		return prefix + "/addManager";
	}

	@RequiresPermissions("sys:user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		UserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
        Map<String,Object> maps = new HashMap<>();
        maps.put("roleType",5);
		List<RoleDO> roles = roleService.list(id,maps);
		model.addAttribute("roles", roles);
		Map<String,Object> map = new HashMap<>();
		map.put("departType","销售门店");
		List<DepartmentDO> storeList = departmentService.list(map);
		model.addAttribute("storeList",storeList);
		return prefix+"/edit";
	}

	@RequiresPermissions("sys:user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	R save(UserDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try {
			MultipartFile file = user.getImgFile();
			if(file!=null && file.getSize()>0){
				File file1 = MultipartFileToFile.multipartFileToFile(file);
				String fileName = FileUtil.renameToUUID(file.getOriginalFilename());
				ObsService obsService = new ObsService();
				String url = obsService.beginUpload(fileName,file1);
				user.setHead(url);
//				String fileName = FileUtil.renameToUUID(file.getOriginalFilename());
//				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath()+"userTX/", fileName);
//				user.setHead("/files/userTX/"+fileName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		DepartmentDO departmentDO = departmentService.getDepartName(user.getStoreNum());
		user.setStore(departmentDO.getDepartName());
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(UserDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try {
			MultipartFile file = user.getImgFile();
			if(file!=null && file.getSize()>0){
				File file1 = MultipartFileToFile.multipartFileToFile(file);
				String fileName = FileUtil.renameToUUID(file.getOriginalFilename());
				ObsService obsService = new ObsService();
				String url = obsService.beginUpload(fileName,file1);
				user.setHead(url);
//				FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath()+"userTX/", fileName);
//				user.setHead("/files/userTX/"+fileName);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		DepartmentDO departmentDO = departmentService.getDepartName(user.getStoreNum());
		user.setStore(departmentDO.getDepartName());
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/updatePeronal")
	@ResponseBody
	R updatePeronal(UserDO user) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (userService.updatePersonal(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("sys:user:remove")
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:batchRemove")
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		int r = userService.batchremove(userIds);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userService.exit(params);
	}

	@RequiresPermissions("sys:user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		UserDO userDO = new UserDO();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return prefix + "/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(UserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try{
			userService.resetPwd(userVO,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@RequiresPermissions("sys:user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(UserVO userVO) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		try{
			userService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = userService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	String personal(Model model) {
		UserDO userDO  = userService.get(getUserId());
		model.addAttribute("user",userDO);
		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}
	@ResponseBody
	@PostMapping("/uploadImg")
	R uploadImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		Map<String, Object> result = new HashMap<>();
		try {
			result = userService.updatePersonalImg(file, avatar_data, getUserId());
		} catch (Exception e) {
			return R.error("更新图像失败！");
		}
		if(result!=null && result.size()>0){
			return R.ok(result);
		}else {
			return R.error("更新图像失败！");
		}
	}
	
	@RequiresPermissions("sys:user:edit")
	@Log("编辑用户")
	@GetMapping("/sysedit")
	String sysedit(Model model) {
		UserDO userDO = userService.get(ShiroUtils.getUserId());
		model.addAttribute("user", userDO);
		
		return prefix+"/sysedit";
	}
	
	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/sysupdate")
	@ResponseBody
	R sysupdate(UserDO user) {
		System.out.println(user.getZhongxinName());
		try {
			MultipartFile imgFile = user.getImgFile();
			if(imgFile!=null && imgFile.getSize()>0){
				String fileName = FileUtil.renameToUUID(imgFile.getOriginalFilename());
				FileUtil.uploadFile(imgFile.getBytes(), bootdoConfig.getUploadPath()+"zhongxin/", fileName);
				user.setZhongxinImg("/files/zhongxin/"+fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userService.sysupdate(user) > 0) {
			return R.ok();
		}
		return R.error();
	}
}
