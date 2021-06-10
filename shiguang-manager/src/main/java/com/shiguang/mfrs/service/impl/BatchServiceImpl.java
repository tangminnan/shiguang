package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.BatchDao;
import com.shiguang.mfrs.domain.BatchDO;
import com.shiguang.mfrs.service.BatchService;



@Service
public class BatchServiceImpl implements BatchService {
	@Autowired
	private BatchDao batchDao;
	
	@Override
	public BatchDO get(Integer batchid){
		return batchDao.get(batchid);
	}
	
	@Override
	public List<BatchDO> list(Map<String, Object> map){
		return batchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return batchDao.count(map);
	}
	
	@Override
	public int save(BatchDO batch){
		return batchDao.save(batch);
	}
	
	@Override
	public int update(BatchDO batch){
		return batchDao.update(batch);
	}
	
	@Override
	public int remove(Integer batchid){
		return batchDao.remove(batchid);
	}
	
	@Override
	public int batchRemove(Integer[] batchids){
		return batchDao.batchRemove(batchids);
	}
	
}
