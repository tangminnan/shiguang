package com.shiguang.unqualiffed.service.impl;

import com.shiguang.unqualiffed.dao.UnqualiffedDao;
import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import com.shiguang.unqualiffed.service.UnqualiffedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class UnqualiffedServiceImpl implements UnqualiffedService {
	@Autowired
	private UnqualiffedDao unqualiffedDao;
	
	@Override
	public UnqualiffedDO get(Long id){
		return unqualiffedDao.get(id);
	}
	
	@Override
	public List<UnqualiffedDO> list(Map<String, Object> map){
		return unqualiffedDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return unqualiffedDao.count(map);
	}
	
	@Override
	public int save(UnqualiffedDO unqualiffed){
		return unqualiffedDao.save(unqualiffed);
	}
	
	@Override
	public int update(UnqualiffedDO unqualiffed){
		return unqualiffedDao.update(unqualiffed);
	}
	
	@Override
	public int remove(Long id){
		return unqualiffedDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return unqualiffedDao.batchRemove(ids);
	}
	
}
