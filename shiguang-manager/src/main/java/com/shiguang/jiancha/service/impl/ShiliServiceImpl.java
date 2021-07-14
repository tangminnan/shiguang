package com.shiguang.jiancha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.ShiliDao;
import com.shiguang.jiancha.domain.ShiliDO;
import com.shiguang.jiancha.service.ShiliService;



@Service
public class ShiliServiceImpl implements ShiliService {
	@Autowired
	private ShiliDao shiliDao;
	
	@Override
	public ShiliDO get(Long id){
		return shiliDao.get(id);
	}
	
	@Override
	public List<ShiliDO> list(Map<String, Object> map){
		return shiliDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return shiliDao.count(map);
	}
	
	@Override
	public int save(ShiliDO shili){
		return shiliDao.save(shili);
	}
	
	@Override
	public int update(ShiliDO shili){
		return shiliDao.update(shili);
	}
	
	@Override
	public int remove(Long id){
		return shiliDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return shiliDao.batchRemove(ids);
	}
	
}
