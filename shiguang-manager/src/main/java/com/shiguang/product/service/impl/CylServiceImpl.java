package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.CylDao;
import com.shiguang.product.domain.CylDO;
import com.shiguang.product.service.CylService;



@Service
public class CylServiceImpl implements CylService {
	@Autowired
	private CylDao cylDao;
	
	@Override
	public CylDO get(Long cylId){
		return cylDao.get(cylId);
	}
	
	@Override
	public List<CylDO> list(Map<String, Object> map){
		return cylDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cylDao.count(map);
	}
	
	@Override
	public int save(CylDO cyl){
		return cylDao.save(cyl);
	}
	
	@Override
	public int update(CylDO cyl){
		return cylDao.update(cyl);
	}
	
	@Override
	public int remove(Long cylId){
		return cylDao.remove(cylId);
	}
	
	@Override
	public int batchRemove(Long[] cylIds){
		return cylDao.batchRemove(cylIds);
	}
	
}
