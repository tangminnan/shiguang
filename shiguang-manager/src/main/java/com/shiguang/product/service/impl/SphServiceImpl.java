package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.SphDao;
import com.shiguang.product.domain.SphDO;
import com.shiguang.product.service.SphService;



@Service
public class SphServiceImpl implements SphService {
	@Autowired
	private SphDao sphDao;
	
	@Override
	public SphDO get(Long id){
		return sphDao.get(id);
	}
	
	@Override
	public List<SphDO> list(Map<String, Object> map){
		return sphDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sphDao.count(map);
	}
	
	@Override
	public int save(SphDO sph){
		return sphDao.save(sph);
	}
	
	@Override
	public int update(SphDO sph){
		return sphDao.update(sph);
	}
	
	@Override
	public int remove(Long id){
		return sphDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sphDao.batchRemove(ids);
	}
	
}
