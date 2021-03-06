package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.LightbelowDao;
import com.shiguang.product.domain.LightbelowDO;
import com.shiguang.product.service.LightbelowService;



@Service
public class LightbelowServiceImpl implements LightbelowService {
	@Autowired
	private LightbelowDao lightbelowDao;
	
	@Override
	public LightbelowDO get(Long lightbelowId){
		return lightbelowDao.get(lightbelowId);
	}
	
	@Override
	public List<LightbelowDO> list(Map<String, Object> map){
		return lightbelowDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lightbelowDao.count(map);
	}
	
	@Override
	public int save(LightbelowDO lightbelow){
		return lightbelowDao.save(lightbelow);
	}
	
	@Override
	public int update(LightbelowDO lightbelow){
		return lightbelowDao.update(lightbelow);
	}
	
	@Override
	public int remove(Long lightbelowId){
		return lightbelowDao.remove(lightbelowId);
	}
	
	@Override
	public int batchRemove(Long[] lightbelowIds){
		return lightbelowDao.batchRemove(lightbelowIds);
	}
	
}
