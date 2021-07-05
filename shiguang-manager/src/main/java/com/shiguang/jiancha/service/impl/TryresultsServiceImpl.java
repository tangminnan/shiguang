package com.shiguang.jiancha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.TryresultsDao;
import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.jiancha.service.TryresultsService;



@Service
public class TryresultsServiceImpl implements TryresultsService {
	@Autowired
	private TryresultsDao tryresultsDao;
	
	@Override
	public TryresultsDO get(Long id){
		return tryresultsDao.get(id);
	}
	
	@Override
	public List<TryresultsDO> list(Map<String, Object> map){
		return tryresultsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tryresultsDao.count(map);
	}
	
	@Override
	public int save(TryresultsDO tryresults){
		return tryresultsDao.save(tryresults);
	}
	
	@Override
	public int update(TryresultsDO tryresults){
		return tryresultsDao.update(tryresults);
	}
	
	@Override
	public int remove(Long id){
		return tryresultsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tryresultsDao.batchRemove(ids);
	}
	
}