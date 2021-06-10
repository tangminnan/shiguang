package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.UnitDao;
import com.shiguang.mfrs.domain.UnitDO;
import com.shiguang.mfrs.service.UnitService;



@Service
public class UnitServiceImpl implements UnitService {
	@Autowired
	private UnitDao unitDao;
	
	@Override
	public UnitDO get(Integer unitid){
		return unitDao.get(unitid);
	}
	
	@Override
	public List<UnitDO> list(Map<String, Object> map){
		return unitDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return unitDao.count(map);
	}
	
	@Override
	public int save(UnitDO unit){
		return unitDao.save(unit);
	}
	
	@Override
	public int update(UnitDO unit){
		return unitDao.update(unit);
	}
	
	@Override
	public int remove(Integer unitid){
		return unitDao.remove(unitid);
	}
	
	@Override
	public int batchRemove(Integer[] unitids){
		return unitDao.batchRemove(unitids);
	}
	
}
