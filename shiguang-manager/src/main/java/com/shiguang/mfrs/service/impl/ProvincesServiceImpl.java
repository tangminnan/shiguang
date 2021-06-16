package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.ProvincesDao;
import com.shiguang.mfrs.domain.ProvincesDO;
import com.shiguang.mfrs.service.ProvincesService;



@Service
public class ProvincesServiceImpl implements ProvincesService {
	@Autowired
	private ProvincesDao provincesDao;
	
	@Override
	public ProvincesDO get(Integer id){
		return provincesDao.get(id);
	}
	
	@Override
	public List<ProvincesDO> list(Map<String, Object> map){
		return provincesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return provincesDao.count(map);
	}
	
	@Override
	public int save(ProvincesDO provinces){
		return provincesDao.save(provinces);
	}
	
	@Override
	public int update(ProvincesDO provinces){
		return provincesDao.update(provinces);
	}
	
	@Override
	public int remove(Integer id){
		return provincesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return provincesDao.batchRemove(ids);
	}
	
}
