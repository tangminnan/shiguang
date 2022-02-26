package com.shiguang.line.service.impl;

import com.shiguang.line.dao.LineDao;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.LineMemberDO;
import com.shiguang.line.service.LineMemberService;
import com.shiguang.line.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class LineServiceImpl implements LineService {
	@Autowired
	private LineDao lineDao;
	@Autowired
	private LineMemberService lineMemberService;
	
	@Override
	public LineDO get(Long id){
		return lineDao.get(id);
	}
	
	@Override
	public List<LineDO> list(Map<String, Object> map){
		return lineDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lineDao.count(map);
	}
	
	@Override
	public int save(LineDO line){
		return lineDao.save(line);
	}
	
	@Override
	public int update(LineDO line){
		return lineDao.update(line);
	}
	
	@Override
	public int remove(Long id){
		return lineDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return lineDao.batchRemove(ids);
	}

	@Override
	public int updateByMember(LineDO line){
		return lineDao.updateByMember(line);
	}

	@Override
	public List<LineDO> lineList(Map<String, Object> map){
		return lineDao.lineList(map);
	}

	@Override
	public int removeMember(LineDO lineDO){
		return lineDao.removeMember(lineDO);
	}

	@Override
	public List<LineDO> newList(Map<String, Object> map) {
		return lineDao.newList(map);
	}

	@Override
	public List<LineDO> oldList(Map<String, Object> map) {
		return lineDao.oldList(map);
	}

	public Map<String,Object> callList(Map<String,Object> maps){
		Map<String,Object> resultMap = new HashMap<>();
		List<LineMemberDO> lineMemberDOList = new ArrayList<>();
		if ("取镜".equals(maps.get("type"))){
			LineMemberDO lineMemberDO = new LineMemberDO();
				lineMemberDO.setMemberName(maps.get("memberName").toString());
				lineMemberDOList.add(lineMemberDO);
			resultMap.put("lineMemberDOS",lineMemberDOList);
			resultMap.put("content","请"+maps.get("memberName")+"到取镜处取镜");
		} else {
			Map<String,Object> map = new HashMap<>();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			map.put("lineTime",simpleDateFormat.format(new Date()));
			map.put("storey","4");
			List<LineDO> lineDOList = this.lineList(map);
			resultMap.put("lineDOList",lineDOList);
			List<LineMemberDO> lineMemberDOS = lineMemberService.list(map);
			LineMemberDO lineMemberDO = new LineMemberDO();
			if (null != lineMemberDOS && lineMemberDOS.size() > 0){
				lineMemberDO.setMemberName(lineMemberDOS.get(0).getMemberName());
				lineMemberDO.setSex(lineMemberDOS.get(0).getSex());
				lineMemberDO.setConsultRoom(lineMemberDOS.get(0).getConsultRoom());
				lineMemberDO.setMemberNumber(lineMemberDOS.get(0).getConsultRoom());
				lineMemberDO.setId(lineMemberDOS.get(0).getId());
				lineMemberDOList.add(lineMemberDO);
			}
			resultMap.put("lineMemberDOS",lineMemberDOList);
			resultMap.put("content","请"+lineMemberDOS.get(0).getMemberName()+"到训练室"+lineMemberDOS.get(0).getConsultRoom()+"就诊");
			List<Map<String,Object>> roomList = new ArrayList<>();
			List<LineDO> lineMemberDOList1 = lineMemberService.listMember(map);
			if (null != lineMemberDOList1 && lineMemberDOList1.size() > 0){
				for (LineDO lineMemberDOstr : lineMemberDOList1){
					if (!"".equals(lineMemberDOstr.getConsultRoom())){
						Map<String,Object> roomMap = new HashMap<>();
						roomMap.put("id",lineMemberDOstr.getId());
						roomMap.put("memberNumber",lineMemberDOstr.getMemberNumber());
						roomMap.put("memberName",lineMemberDOstr.getMemberName());
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
		}
		return resultMap;
	}
	
}
