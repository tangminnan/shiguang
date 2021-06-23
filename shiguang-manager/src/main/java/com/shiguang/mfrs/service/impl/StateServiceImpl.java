package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.StateDao;
import com.shiguang.mfrs.domain.StateDO;
import com.shiguang.mfrs.service.StateService;



@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateDao stateDao;
	
	@Override
	public StateDO get(Integer stateId){
		return stateDao.get(stateId);
	}
	
	@Override
	public List<StateDO> list(Map<String, Object> map){
		return stateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stateDao.count(map);
	}
	
	@Override
	public int save(StateDO state){
		return stateDao.save(state);
	}
	
	@Override
	public int update(StateDO state){
		return stateDao.update(state);
	}
	
	@Override
	public int remove(Integer stateId){
		return stateDao.remove(stateId);
	}
	
	@Override
	public int batchRemove(Integer[] stateIds){
		return stateDao.batchRemove(stateIds);
	}
	
}
