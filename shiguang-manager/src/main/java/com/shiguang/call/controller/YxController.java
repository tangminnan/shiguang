package com.shiguang.call.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shiguang.call.domain.YxDO;
import com.shiguang.call.domain.YxLineDO;
import com.shiguang.call.service.YxService;
import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.member.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.velocity.runtime.directive.ForeachScope;
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
 * 隐形呼叫
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-05-17 10:29:34
 */
 
@Controller
@RequestMapping("/information/yx")
public class YxController {
	@Autowired
	private YxService yxService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping()
	@RequiresPermissions("information:yx:yx")
	String Yx(){
	    return "call/yx";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:yx:yx")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YxLineDO> yxlinelist = yxService.yxlinelist(query);
		int total = yxService.yxlinecount(query);
		PageUtils pageUtils = new PageUtils(yxlinelist, total);
		return pageUtils;
	}

	/**
	 * 取号机查询顾客
	 * @return
	 */
	@GetMapping( "/findMemberList")
	@ResponseBody
	public Map<String,Object> memberList(String memberInfo){
		Map<String,Object> paraMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		map.put("memberNumber",memberInfo);
		map.put("identityId",memberInfo);
		map.put("tel",memberInfo);
		List<MemberDO> memberDOList = memberService.list(map);
		paraMap.put("memberDOList",memberDOList);
		return paraMap;
	}

	/**
	 * 取号
	 * @param memberNumber
	 * @param type
	 * @return
	 */
	@GetMapping( "/memberLine")
	@ResponseBody
	public Map<String,Object> saveLine(String memberNumber,String type){
		Map<String,Object> map = new HashMap<>();
		MemberDO memberDO = memberService.getCardNumber(memberNumber);
		YxLineDO yxLineDO = new YxLineDO();
		yxLineDO.setMemberName(memberDO.getName());
		yxLineDO.setMemberNumber(memberNumber);
		if ("0".equals(memberDO.getSex())){
			yxLineDO.setSex("男");
		} else if ("1".equals(memberDO.getSex())){
			yxLineDO.setSex("女");
		}
		yxLineDO.setPhone(memberDO.getPhone1());
		yxLineDO.setType(type);
		yxLineDO.setCreateTime(new Date());
		yxService.yxlinesave(yxLineDO);
		map.put("code","200");
		map.put("message","取号成功");
		return map;
	}

	/**
	 * 隐形叫号
	 * @param id
	 * @return
	 */
	@PostMapping( "/addCall")
	@ResponseBody
	@RequiresPermissions("information:yx:addCall")
	public R callYx(Long id){
		//MemberDO memberDO = memberService.getCardNumber(memberNumber);
		YxLineDO memberDO = yxService.getYxLine(id);
		YxDO yxDO = new YxDO();
		yxDO.setMemberName(memberDO.getMemberName());
		yxDO.setMemberNumber(memberDO.getMemberNumber());
		yxDO.setSex(memberDO.getSex());
		yxDO.setType(memberDO.getType());
		yxService.save(yxDO);
		return R.ok("呼叫成功");
	}

	/**
	 * 取号机定时访问是否有被呼叫的顾客
	 * @return
	 */
	public Map<String,Object> yxlist(){
		Map<String,Object> parmap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		List<YxDO> yxDOList = yxService.list(map);
		if ("复查".equals(yxDOList.get(0).getType())){
			parmap.put("content","请"+yxDOList.get(0).getMemberName()+"到二楼隐形档案室就诊");
		} else if ("取镜".equals(yxDOList.get(0).getType())){
			parmap.put("content","请"+yxDOList.get(0).getMemberName()+"到二楼隐形咨询室就诊");
		}
		parmap.put("yxDOList",yxDOList);
		yxService.remove(yxDOList.get(0).getId());
		return parmap;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:yx:add")
	String add(){
	    return "call/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:yx:edit")
	String edit(@PathVariable("id") Long id,Model model){
		YxDO yx = yxService.get(id);
		model.addAttribute("yx", yx);
	    return "call/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:yx:add")
	public R save(YxDO yx){
		if(yxService.save(yx)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:yx:edit")
	public R update( YxDO yx){
		yxService.update(yx);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:yx:remove")
	public R remove( Long id){
		if(yxService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:yx:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		yxService.batchRemove(ids);
		return R.ok();
	}
	
}
