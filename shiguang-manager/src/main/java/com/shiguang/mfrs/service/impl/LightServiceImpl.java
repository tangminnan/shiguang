package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.LightDao;
import com.shiguang.mfrs.domain.LightDO;
import com.shiguang.mfrs.service.LightService;



@Service
public class LightServiceImpl implements LightService {
	@Autowired
	private LightDao lightDao;
	
	@Override
	public LightDO get(Integer id){
		return lightDao.get(id);
	}
	
	@Override
	public List<LightDO> list(Map<String, Object> map){
		return lightDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lightDao.count(map);
	}
	
	@Override
	public int save(LightDO light){
		return lightDao.save(light);
	}
	
	@Override
	public int update(LightDO light){
		return lightDao.update(light);
	}
	
	@Override
	public int remove(Integer id){
		return lightDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return lightDao.batchRemove(ids);
	}
	
}
