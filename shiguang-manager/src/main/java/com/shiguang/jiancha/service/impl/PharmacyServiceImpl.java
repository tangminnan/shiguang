package com.shiguang.jiancha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.PharmacyDao;
import com.shiguang.jiancha.domain.PharmacyDO;
import com.shiguang.jiancha.service.PharmacyService;



@Service
public class PharmacyServiceImpl implements PharmacyService {
	@Autowired
	private PharmacyDao pharmacyDao;
	
	@Override
	public PharmacyDO get(Long pharmacyId){
		return pharmacyDao.get(pharmacyId);
	}
	
	@Override
	public List<PharmacyDO> list(Map<String, Object> map){
		return pharmacyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return pharmacyDao.count(map);
	}
	
	@Override
	public int save(PharmacyDO pharmacy){
		return pharmacyDao.save(pharmacy);
	}
	
	@Override
	public int update(PharmacyDO pharmacy){
		return pharmacyDao.update(pharmacy);
	}
	
	@Override
	public int remove(Long pharmacyId){
		return pharmacyDao.remove(pharmacyId);
	}
	
	@Override
	public int batchRemove(Long[] pharmacyIds){
		return pharmacyDao.batchRemove(pharmacyIds);
	}
	
}
