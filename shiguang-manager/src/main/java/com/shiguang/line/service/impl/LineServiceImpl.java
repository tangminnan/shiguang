package com.shiguang.line.service.impl;

import com.shiguang.line.dao.LineDao;
import com.shiguang.line.domain.LineDO;
import com.shiguang.line.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class LineServiceImpl implements LineService {
	@Autowired
	private LineDao lineDao;
	
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
	
}
