package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.WeiwaikcDao;
import com.shiguang.stock.domain.WeiwaikcDO;
import com.shiguang.stock.service.WeiwaikcService;



@Service
public class WeiwaikcServiceImpl implements WeiwaikcService {
	@Autowired
	private WeiwaikcDao weiwaikcDao;
	
	@Override
	public WeiwaikcDO get(Long id){
		return weiwaikcDao.get(id);
	}
	
	@Override
	public List<WeiwaikcDO> list(Map<String, Object> map){
		return weiwaikcDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weiwaikcDao.count(map);
	}
	
	@Override
	public int save(WeiwaikcDO weiwaikc){
		return weiwaikcDao.save(weiwaikc);
	}
	
	@Override
	public int update(WeiwaikcDO weiwaikc){
		return weiwaikcDao.update(weiwaikc);
	}
	
	@Override
	public int remove(Long id){
		return weiwaikcDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return weiwaikcDao.batchRemove(ids);
	}
	
}
