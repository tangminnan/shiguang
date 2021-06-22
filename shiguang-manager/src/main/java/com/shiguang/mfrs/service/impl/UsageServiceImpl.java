package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.UsageDao;
import com.shiguang.mfrs.domain.UsageDO;
import com.shiguang.mfrs.service.UsageService;



@Service
public class UsageServiceImpl implements UsageService {
	@Autowired
	private UsageDao usageDao;
	
	@Override
	public UsageDO get(Integer usageId){
		return usageDao.get(usageId);
	}
	
	@Override
	public List<UsageDO> list(Map<String, Object> map){
		return usageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return usageDao.count(map);
	}
	
	@Override
	public int save(UsageDO usage){
		return usageDao.save(usage);
	}
	
	@Override
	public int update(UsageDO usage){
		return usageDao.update(usage);
	}
	
	@Override
	public int remove(Integer usageId){
		return usageDao.remove(usageId);
	}
	
	@Override
	public int batchRemove(Integer[] usageIds){
		return usageDao.batchRemove(usageIds);
	}
	
}
