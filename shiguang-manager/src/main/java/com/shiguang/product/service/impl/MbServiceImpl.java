package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.MbDao;
import com.shiguang.product.domain.MbDO;
import com.shiguang.product.service.MbService;



@Service
public class MbServiceImpl implements MbService {
	@Autowired
	private MbDao mbDao;
	
	@Override
	public MbDO get(Integer id){
		return mbDao.get(id);
	}
	
	@Override
	public List<MbDO> list(Map<String, Object> map){
		return mbDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return mbDao.count(map);
	}
	
	@Override
	public int save(MbDO mb){
		return mbDao.save(mb);
	}
	
	@Override
	public int update(MbDO mb){
		return mbDao.update(mb);
	}
	
	@Override
	public int remove(Integer id){
		return mbDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return mbDao.batchRemove(ids);
	}
	
}
