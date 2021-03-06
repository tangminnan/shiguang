package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.GradualDao;
import com.shiguang.mfrs.domain.GradualDO;
import com.shiguang.mfrs.service.GradualService;



@Service
public class GradualServiceImpl implements GradualService {
	@Autowired
	private GradualDao gradualDao;
	
	@Override
	public GradualDO get(Integer gradualId){
		return gradualDao.get(gradualId);
	}
	
	@Override
	public List<GradualDO> list(Map<String, Object> map){
		return gradualDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return gradualDao.count(map);
	}
	
	@Override
	public int save(GradualDO gradual){
		return gradualDao.save(gradual);
	}
	
	@Override
	public int update(GradualDO gradual){
		return gradualDao.update(gradual);
	}
	
	@Override
	public int remove(Integer gradualId){
		return gradualDao.remove(gradualId);
	}
	
	@Override
	public int batchRemove(Integer[] gradualIds){
		return gradualDao.batchRemove(gradualIds);
	}
	
}
