package com.shiguang.jiancha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.ZyDao;
import com.shiguang.jiancha.domain.ZyDO;
import com.shiguang.jiancha.service.ZyService;



@Service
public class ZyServiceImpl implements ZyService {
	@Autowired
	private ZyDao zyDao;
	
	@Override
	public ZyDO get(Long zyId){
		return zyDao.get(zyId);
	}
	
	@Override
	public List<ZyDO> list(Map<String, Object> map){
		return zyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zyDao.count(map);
	}
	
	@Override
	public int save(ZyDO zy){
		return zyDao.save(zy);
	}
	
	@Override
	public int update(ZyDO zy){
		return zyDao.update(zy);
	}
	
	@Override
	public int remove(Long zyId){
		return zyDao.remove(zyId);
	}
	
	@Override
	public int batchRemove(Long[] zyIds){
		return zyDao.batchRemove(zyIds);
	}
	
}
