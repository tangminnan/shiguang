package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.StockqualifyDao;
import com.shiguang.stock.domain.StockqualifyDO;
import com.shiguang.stock.service.StockqualifyService;



@Service
public class StockqualifyServiceImpl implements StockqualifyService {
	@Autowired
	private StockqualifyDao stockqualifyDao;
	
	@Override
	public StockqualifyDO get(Long id){
		return stockqualifyDao.get(id);
	}
	
	@Override
	public List<StockqualifyDO> list(Map<String, Object> map){
		return stockqualifyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stockqualifyDao.count(map);
	}
	
	@Override
	public int save(StockqualifyDO stockqualify){
		return stockqualifyDao.save(stockqualify);
	}
	
	@Override
	public int update(StockqualifyDO stockqualify){
		return stockqualifyDao.update(stockqualify);
	}
	
	@Override
	public int remove(Long id){
		return stockqualifyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return stockqualifyDao.batchRemove(ids);
	}
	
}
