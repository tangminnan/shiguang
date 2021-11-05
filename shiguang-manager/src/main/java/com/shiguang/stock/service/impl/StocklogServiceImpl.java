package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.StocklogDao;
import com.shiguang.stock.domain.StocklogDO;
import com.shiguang.stock.service.StocklogService;



@Service
public class StocklogServiceImpl implements StocklogService {
	@Autowired
	private StocklogDao stocklogDao;
	
	@Override
	public StocklogDO get(Long id){
		return stocklogDao.get(id);
	}
	
	@Override
	public List<StocklogDO> list(Map<String, Object> map){
		return stocklogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stocklogDao.count(map);
	}
	
	@Override
	public int save(StocklogDO stocklog){
		return stocklogDao.save(stocklog);
	}
	
	@Override
	public int update(StocklogDO stocklog){
		return stocklogDao.update(stocklog);
	}
	
	@Override
	public int remove(Long id){
		return stocklogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return stocklogDao.batchRemove(ids);
	}
	
}
