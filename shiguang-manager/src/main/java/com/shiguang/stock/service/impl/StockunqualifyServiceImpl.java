package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.StockunqualifyDao;
import com.shiguang.stock.domain.StockunqualifyDO;
import com.shiguang.stock.service.StockunqualifyService;



@Service
public class StockunqualifyServiceImpl implements StockunqualifyService {
	@Autowired
	private StockunqualifyDao stockunqualifyDao;
	
	@Override
	public StockunqualifyDO get(Long id){
		return stockunqualifyDao.get(id);
	}
	
	@Override
	public List<StockunqualifyDO> list(Map<String, Object> map){
		return stockunqualifyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stockunqualifyDao.count(map);
	}
	
	@Override
	public int save(StockunqualifyDO stockunqualify){
		return stockunqualifyDao.save(stockunqualify);
	}
	
	@Override
	public int update(StockunqualifyDO stockunqualify){
		return stockunqualifyDao.update(stockunqualify);
	}
	
	@Override
	public int remove(Long id){
		return stockunqualifyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return stockunqualifyDao.batchRemove(ids);
	}
	
}
