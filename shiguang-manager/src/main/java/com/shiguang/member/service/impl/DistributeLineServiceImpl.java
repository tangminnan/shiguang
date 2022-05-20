package com.shiguang.member.service.impl;

import com.shiguang.member.dao.DistributeLineDao;
import com.shiguang.member.domain.LineDO;
import com.shiguang.member.service.DistributeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class DistributeLineServiceImpl implements DistributeLineService {
	@Autowired
	private DistributeLineDao lineDao;
	
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
	
}
