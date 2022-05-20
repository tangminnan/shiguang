package com.shiguang.integral.service.impl;

import com.shiguang.integral.dao.IntegralDao;
import com.shiguang.integral.domain.IntegralDO;
import com.shiguang.integral.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class IntegralServiceImpl implements IntegralService {
	@Autowired
	private IntegralDao integralDao;
	
	@Override
	public IntegralDO get(Long id){
		return integralDao.get(id);
	}
	
	@Override
	public List<IntegralDO> list(Map<String, Object> map){
		return integralDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return integralDao.count(map);
	}
	
	@Override
	public int save(IntegralDO integral){
		return integralDao.save(integral);
	}
	
	@Override
	public int update(IntegralDO integral){
		return integralDao.update(integral);
	}
	
	@Override
	public int remove(Long id){
		return integralDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return integralDao.batchRemove(ids);
	}

	@Override
	public List<IntegralDO> getPoints(Map<String,Object> map){
		return integralDao.getPoints(map);
	}
	
}
