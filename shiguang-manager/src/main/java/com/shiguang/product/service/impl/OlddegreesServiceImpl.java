package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.OlddegreesDao;
import com.shiguang.product.domain.OlddegreesDO;
import com.shiguang.product.service.OlddegreesService;



@Service
public class OlddegreesServiceImpl implements OlddegreesService {
	@Autowired
	private OlddegreesDao olddegreesDao;
	
	@Override
	public OlddegreesDO get(Long oldId){
		return olddegreesDao.get(oldId);
	}
	
	@Override
	public List<OlddegreesDO> list(Map<String, Object> map){
		return olddegreesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return olddegreesDao.count(map);
	}
	
	@Override
	public int save(OlddegreesDO olddegrees){
		return olddegreesDao.save(olddegrees);
	}
	
	@Override
	public int update(OlddegreesDO olddegrees){
		return olddegreesDao.update(olddegrees);
	}
	
	@Override
	public int remove(Long oldId){
		return olddegreesDao.remove(oldId);
	}
	
	@Override
	public int batchRemove(Long[] oldIds){
		return olddegreesDao.batchRemove(oldIds);
	}
	
}
