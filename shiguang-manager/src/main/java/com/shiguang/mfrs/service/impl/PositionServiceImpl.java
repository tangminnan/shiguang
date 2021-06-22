package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.PositionDao;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;



@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionDao positionDao;
	
	@Override
	public PositionDO get(Long positionId){
		return positionDao.get(positionId);
	}
	
	@Override
	public List<PositionDO> list(Map<String, Object> map){
		return positionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return positionDao.count(map);
	}
	
	@Override
	public int save(PositionDO position){
		return positionDao.save(position);
	}
	
	@Override
	public int update(PositionDO position){
		return positionDao.update(position);
	}
	
	@Override
	public int remove(Long positionId){
		return positionDao.remove(positionId);
	}
	
	@Override
	public int batchRemove(Long[] positionIds){
		return positionDao.batchRemove(positionIds);
	}
	
}
