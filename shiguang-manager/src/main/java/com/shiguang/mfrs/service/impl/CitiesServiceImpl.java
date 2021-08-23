package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.CitiesDao;
import com.shiguang.mfrs.domain.CitiesDO;
import com.shiguang.mfrs.service.CitiesService;



@Service
public class CitiesServiceImpl implements CitiesService {
	@Autowired
	private CitiesDao citiesDao;
	
	@Override
	public CitiesDO get(Integer id){
		return citiesDao.get(id);
	}
	
	@Override
	public List<CitiesDO> list(Map<String, Object> map){
		return citiesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return citiesDao.count(map);
	}
	
	@Override
	public int save(CitiesDO cities){
		return citiesDao.save(cities);
	}
	
	@Override
	public int update(CitiesDO cities){
		return citiesDao.update(cities);
	}
	
	@Override
	public int remove(Integer id){
		return citiesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return citiesDao.batchRemove(ids);
	}
	
}
