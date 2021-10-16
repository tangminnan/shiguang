package com.shiguang.line.service.impl;

import com.shiguang.common.utils.R;
import com.shiguang.line.dao.RefractionDao;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.domain.RefractionDO;
import com.shiguang.line.domain.RefractionLineDO;
import com.shiguang.line.domain.RefractionLineMemberDO;
import com.shiguang.line.service.LineService;
import com.shiguang.line.service.RefractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RefractionServiceImpl implements RefractionService {
	@Autowired
	private RefractionDao lineDao;
	
	@Override
	public RefractionLineDO get(Long id){
		return lineDao.get(id);
	}

	@Override
	public RefractionDO getRefraction(String name){
		return lineDao.getRefraction(name);
	}
	
	@Override
	public List<RefractionLineDO> list(Map<String, Object> map){
		return lineDao.list(map);
	}

	@Override
	public List<RefractionLineDO> refrationlineList(Map<String, Object> map){
		return lineDao.refrationlineList(map);
	}

	@Override
	public List<RefractionLineDO> refrationlinesList(Map<String, Object> map){
		return lineDao.refrationlinesList(map);
	}

	@Override
	public List<RefractionLineMemberDO> listMember(Map<String, Object> map){
		return lineDao.listMember(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lineDao.count(map);
	}
	
	@Override
	public int save(RefractionDO line){
		return lineDao.save(line);
	}

	public int saveLine(RefractionLineDO line){
		return lineDao.saveLine(line);
	}

	public int saveLineMember(RefractionLineMemberDO line){
		return lineDao.saveLineMember(line);
	}
	
	@Override
	public int update(RefractionDO line){
		return lineDao.update(line);
	}

	@Override
	public int updateLine(RefractionLineDO line){
		return lineDao.updateLine(line);
	}
	
	@Override
	public int remove(String name){
		return lineDao.remove(name);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return lineDao.batchRemove(ids);
	}

	@Override
	public int updateByMember(RefractionDO line){
		return lineDao.updateByMember(line);
	}

	@Override
	public List<RefractionDO> lineList(Map<String, Object> map){
		return lineDao.lineList(map);
	}

	@Override
	public int removeMember(Long id){
		return lineDao.removeMember(id);
	}
	
}
