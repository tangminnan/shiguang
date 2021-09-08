package com.shiguang.inventory.service.impl;

import com.shiguang.inventory.dao.GainLossDao;
import com.shiguang.inventory.domain.GainLossDO;
import com.shiguang.inventory.service.GainLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class GainLossServiceImpl implements GainLossService {
	@Autowired
	private GainLossDao gainLossDao;
	
	@Override
	public GainLossDO get(Long id){
		return gainLossDao.get(id);
	}
	
	@Override
	public List<GainLossDO> list(Map<String, Object> map){
		return gainLossDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return gainLossDao.count(map);
	}
	
	@Override
	public int save(GainLossDO gainLoss){
		return gainLossDao.save(gainLoss);
	}
	
	@Override
	public int update(GainLossDO gainLoss){
		return gainLossDao.update(gainLoss);
	}
	
	@Override
	public int remove(Long id){
		return gainLossDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return gainLossDao.batchRemove(ids);
	}
	
}
