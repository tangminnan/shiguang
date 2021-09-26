package com.shiguang.line.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.shiguang.common.utils.PageUtils;
import com.shiguang.common.utils.Query;
import com.shiguang.common.utils.R;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.LineMemberDO;
import com.shiguang.line.service.LineMemberService;
import com.shiguang.line.service.LineService;
import io.swagger.models.auth.In;
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
 * 排队列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-15 14:09:10
 */
 
@Controller
@RequestMapping("/information/line")
public class LineController {
	@Autowired
	private LineService lineService;
	@Autowired
	private LineMemberService lineMemberService;
	
	@GetMapping()
	@RequiresPermissions("information:line:line")
	String Line(){
	    return "line/line";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:line:line")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        query.put("lineTime",simpleDateFormat.format(new Date()));
        List<LineDO> lineList = lineService.list(query);
		if (null != lineList && lineList.size() > 0){
			for (LineDO lineDO : lineList){
				if (lineDO.getSex() == 0){
					lineDO.setSexx("男");
				}else if (lineDO.getSex() == 1){
					lineDO.setSexx("女");
				}
			}
		}
		int total = lineService.count(query);
		PageUtils pageUtils = new PageUtils(lineList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:line:add")
	String add(){
	    return "line/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:line:edit")
	String edit(@PathVariable("id") Long id,Model model){
		LineDO line = lineService.get(id);
		model.addAttribute("line", line);
	    return "line/edit";
	}

	/**
	 * 输入诊室
	 * @return
	 */
	@GetMapping("/consultRoom")
	@RequiresPermissions("information:line:consultRoom")
	String consultRoom(){
		return "line/consultRoom";
	}

	/**
	 * 叫号
	 */
	@PostMapping( "/addCall")
	@ResponseBody
	@RequiresPermissions("information:line:addCall")
	public R addCall(String consultRoom){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = new HashMap<>();
		map.put("consultRoom",consultRoom);
		map.put("lineTime",simpleDateFormat.format(new Date()));
		List<LineDO> lineDOList = lineService.list(map);
		if (null != lineDOList && lineDOList.size() > 0){
			Long lineId = lineDOList.get(0).getId();
			LineDO lineDOs = lineService.get(lineId);
			int callStatus = 0;
			if (Integer.parseInt(lineDOs.getCallStatus())<4){
				callStatus = Integer.parseInt(lineDOs.getCallStatus()) + 1;
			} else {
				callStatus = 4;
			}
			LineDO lineDO = new LineDO();
			lineDO.setId(lineId);
			lineDO.setConsultRoom(consultRoom);
			lineDO.setCallStatus(String.valueOf(callStatus));
			lineService.update(lineDO);
			LineMemberDO lineMemberDO = new LineMemberDO();
			lineMemberDO.setMemberNumber(lineDOs.getMemberNumber());
			lineMemberDO.setConsultRoom(consultRoom);
			lineMemberDO.setName(lineDOs.getName());
			lineMemberDO.setSex(lineDOs.getSex());
			lineMemberDO.setLineTime(lineDOs.getLineTime());
			if(lineMemberService.save(lineMemberDO)>0){
				return R.ok();
			}
		}
		return R.error();
	}

	/**
	 * 排队级叫号列表
	 * @return
	 */
	@GetMapping( "/callList")
	@ResponseBody
	public Map<String,Object> callList(){
		Map<String,Object> resultMap = new HashMap<>();
		Map<String,Object> map = new HashMap<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		map.put("lineTime",simpleDateFormat.format(new Date()));
		List<LineDO> lineDOList = lineService.lineList(map);
		resultMap.put("lineDOList",lineDOList);
		List<LineMemberDO> lineMemberDOList = new ArrayList<>();
		List<LineMemberDO> lineMemberDOS = lineMemberService.list(map);
		LineMemberDO lineMemberDO = new LineMemberDO();
		if (null != lineMemberDOS && lineMemberDOS.size() > 0){
			lineMemberDO.setName(lineMemberDOS.get(0).getName());
			lineMemberDO.setSex(lineMemberDOS.get(0).getSex());
			lineMemberDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
			lineMemberDO.setMemberNumber(lineMemberDOS.get(0).getConsultRoom());
			lineMemberDO.setId(lineMemberDOS.get(0).getId());
			lineMemberDOList.add(lineMemberDO);
		}
		resultMap.put("lineMemberDOS",lineMemberDOList);
		List<Map<String,Object>> roomList = new ArrayList<>();
		List<LineDO> lineMemberDOList1 = lineMemberService.listMember(map);
		if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
			for (LineDO lineMemberDOstr : lineMemberDOList1){
				if (!"".equals(lineMemberDOstr.getConsultRoom())){
					Map<String,Object> roomMap = new HashMap<>();
					roomMap.put("id",lineMemberDOstr.getId());
					roomMap.put("memberNumber",lineMemberDOstr.getMemberNumber());
					roomMap.put("name",lineMemberDOstr.getName());
					roomMap.put("sex",lineMemberDOstr.getSex());
					roomMap.put("consultRoom",lineMemberDOstr.getConsultRoom());
					roomList.add(roomMap);
				}
			}
		}
		resultMap.put("roomList",roomList);
		if (null != lineMemberDOS && lineMemberDOS.size() > 0){
//				LineDO lineDO = new LineDO();
//				lineDO.setMemberNumber(lineMemberDO.getMemberNumber());
//				lineDO.setLineDate(simpleDateFormat.format(new Date()));
//				lineService.removeMember(lineDO);
				lineMemberService.remove(lineMemberDOS.get(0).getId());
		}
		return resultMap;
	}

	@PostMapping( "/randomCall")
	@ResponseBody
	@RequiresPermissions("information:line:randomCall")
	public R randomCall(Long id,String consultRoom){
		LineDO lineDOs = lineService.get(id);
		int callStatus = 0;
		if (Integer.parseInt(lineDOs.getCallStatus())<4){
			callStatus = Integer.parseInt(lineDOs.getCallStatus()) + 1;
		} else {
			callStatus = 4;
		}
		LineDO lineDO = new LineDO();
		lineDO.setId(id);
		lineDO.setConsultRoom(consultRoom);
		lineDO.setCallStatus(String.valueOf(callStatus));
		lineService.update(lineDO);
		LineMemberDO lineMemberDO = new LineMemberDO();
		lineMemberDO.setMemberNumber(lineDOs.getMemberNumber());
		lineMemberDO.setConsultRoom(consultRoom);
		lineMemberDO.setName(lineDOs.getName());
		lineMemberDO.setSex(lineDOs.getSex());
		if(lineMemberService.save(lineMemberDO)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:line:add")
	public R save(LineDO line){
		if(lineService.save(line)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:line:edit")
	public R update( LineDO line){
		lineService.update(line);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:line:remove")
	public R remove( Long id){
		if(lineService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:line:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		lineService.batchRemove(ids);
		return R.ok();
	}
	
}
