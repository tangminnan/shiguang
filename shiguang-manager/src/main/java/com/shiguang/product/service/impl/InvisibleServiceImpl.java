package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.InvisibleDao;
import com.shiguang.product.domain.InvisibleDO;
import com.shiguang.product.service.InvisibleService;



@Service
public class InvisibleServiceImpl implements InvisibleService {
	@Autowired
	private InvisibleDao invisibleDao;
	
	@Override
	public InvisibleDO get(Long invisibleId){
		return invisibleDao.get(invisibleId);
	}
	
	@Override
	public List<InvisibleDO> list(Map<String, Object> map){
		return invisibleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return invisibleDao.count(map);
	}
	
	@Override
	public int save(InvisibleDO invisible){
		return invisibleDao.save(invisible);
	}
	
	@Override
	public int update(InvisibleDO invisible){
		return invisibleDao.update(invisible);
	}
	
	@Override
	public int remove(Long invisibleId){
		return invisibleDao.remove(invisibleId);
	}
	
	@Override
	public int batchRemove(Long[] invisibleIds){
		return invisibleDao.batchRemove(invisibleIds);
	}
	
}
