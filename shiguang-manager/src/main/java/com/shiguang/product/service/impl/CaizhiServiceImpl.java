package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.CaizhiDao;
import com.shiguang.product.domain.CaizhiDO;
import com.shiguang.product.service.CaizhiService;



@Service
public class CaizhiServiceImpl implements CaizhiService {
	@Autowired
	private CaizhiDao caizhiDao;
	
	@Override
	public CaizhiDO get(Long caizhiId){
		return caizhiDao.get(caizhiId);
	}
	
	@Override
	public List<CaizhiDO> list(Map<String, Object> map){
		return caizhiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return caizhiDao.count(map);
	}
	
	@Override
	public int save(CaizhiDO caizhi){
		return caizhiDao.save(caizhi);
	}
	
	@Override
	public int update(CaizhiDO caizhi){
		return caizhiDao.update(caizhi);
	}
	
	@Override
	public int remove(Long caizhiId){
		return caizhiDao.remove(caizhiId);
	}
	
	@Override
	public int batchRemove(Long[] caizhiIds){
		return caizhiDao.batchRemove(caizhiIds);
	}
	
}
