package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.MfrsDao;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.MfrsService;



@Service
public class MfrsServiceImpl implements MfrsService {
	@Autowired
	private MfrsDao mfrsDao;
	
	@Override
	public MfrsDO get(Integer mfrsid){
		return mfrsDao.get(mfrsid);
	}
	
	@Override
	public List<MfrsDO> list(Map<String, Object> map){
		return mfrsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return mfrsDao.count(map);
	}
	
	@Override
	public int save(MfrsDO mfrs){
		return mfrsDao.save(mfrs);
	}
	
	@Override
	public int update(MfrsDO mfrs){
		return mfrsDao.update(mfrs);
	}
	
	@Override
	public int remove(Integer mfrsid){
		return mfrsDao.remove(mfrsid);
	}
	
	@Override
	public int batchRemove(Integer[] mfrsids){
		return mfrsDao.batchRemove(mfrsids);
	}
	
}
