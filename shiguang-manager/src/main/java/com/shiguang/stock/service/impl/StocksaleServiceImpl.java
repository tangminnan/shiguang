package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.StocksaleDao;
import com.shiguang.stock.domain.StocksaleDO;
import com.shiguang.stock.service.StocksaleService;



@Service
public class StocksaleServiceImpl implements StocksaleService {
	@Autowired
	private StocksaleDao stocksaleDao;
	
	@Override
	public StocksaleDO get(Long id){
		return stocksaleDao.get(id);
	}
	
	@Override
	public List<StocksaleDO> list(Map<String, Object> map){
		return stocksaleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stocksaleDao.count(map);
	}
	
	@Override
	public int save(StocksaleDO stocksale){
		return stocksaleDao.save(stocksale);
	}
	
	@Override
	public int update(StocksaleDO stocksale){
		return stocksaleDao.update(stocksale);
	}
	
	@Override
	public int remove(Long id){
		return stocksaleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return stocksaleDao.batchRemove(ids);
	}
	
}
