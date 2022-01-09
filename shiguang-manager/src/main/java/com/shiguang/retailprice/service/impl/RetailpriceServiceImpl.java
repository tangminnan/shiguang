package com.shiguang.retailprice.service.impl;

import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.domain.ProducaDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.retailprice.dao.RetailpriceDao;
import com.shiguang.retailprice.domain.RetailpriceDO;
import com.shiguang.retailprice.service.RetailpriceService;



@Service
public class RetailpriceServiceImpl implements RetailpriceService {
	@Autowired
	private RetailpriceDao retailpriceDao;
	
	@Override
	public RetailpriceDO get(Long id){
		return retailpriceDao.get(id);
	}
	
	@Override
	public List<RetailpriceDO> list(Map<String, Object> map){
		return retailpriceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return retailpriceDao.count(map);
	}
	
	@Override
	public int save(RetailpriceDO retailprice){
		return retailpriceDao.save(retailprice);
	}
	
	@Override
	public int update(RetailpriceDO retailprice){
		return retailpriceDao.update(retailprice);
	}
	
	@Override
	public int remove(Long id){
		return retailpriceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return retailpriceDao.batchRemove(ids);
	}

	@Override
	public List<PartsDO> pjlist(Map<String, Object> map) {
		return retailpriceDao.pjlist(map);
	}

	@Override
	public int pjlistCount(Map<String, Object> map) {
		return retailpriceDao.pjlistCount(map);
	}
}
