package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.WeiwaiDao;
import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.service.WeiwaiService;



@Service
public class WeiwaiServiceImpl implements WeiwaiService {
	@Autowired
	private WeiwaiDao weiwaiDao;
	
	@Override
	public WeiwaiDO get(Long id){
		return weiwaiDao.get(id);
	}
	
	@Override
	public List<WeiwaiDO> list(Map<String, Object> map){
		return weiwaiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weiwaiDao.count(map);
	}
	
	@Override
	public int save(WeiwaiDO weiwai){
		return weiwaiDao.save(weiwai);
	}
	
	@Override
	public int update(WeiwaiDO weiwai){
		return weiwaiDao.update(weiwai);
	}
	
	@Override
	public int remove(Long id){
		return weiwaiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return weiwaiDao.batchRemove(ids);
	}

	@Override
	public List<WeiwaiDO> weiwailist(Map<String, Object> map) {
		return weiwaiDao.weiwailist(map);
	}

	@Override
	public int countList(Map<String, Object> map) {
		return weiwaiDao.countList(map);
	}
}