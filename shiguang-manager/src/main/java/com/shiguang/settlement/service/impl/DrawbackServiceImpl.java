package com.shiguang.settlement.service.impl;

import com.shiguang.settlement.dao.DrawbackDao;
import com.shiguang.settlement.domain.DrawbackDO;
import com.shiguang.settlement.service.DrawbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class DrawbackServiceImpl implements DrawbackService {
	@Autowired
	private DrawbackDao drawbackDao;
	
	@Override
	public DrawbackDO get(Long id){
		return drawbackDao.get(id);
	}
	
	@Override
	public List<DrawbackDO> list(Map<String, Object> map){
		return drawbackDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return drawbackDao.count(map);
	}
	
	@Override
	public int save(DrawbackDO drawback){
		return drawbackDao.save(drawback);
	}
	
	@Override
	public int update(DrawbackDO drawback){
		return drawbackDao.update(drawback);
	}
	
	@Override
	public int remove(Long id){
		return drawbackDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return drawbackDao.batchRemove(ids);
	}
	
}
