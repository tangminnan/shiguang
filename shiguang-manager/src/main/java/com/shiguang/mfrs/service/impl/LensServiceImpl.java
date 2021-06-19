package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.LensDao;
import com.shiguang.mfrs.domain.LensDO;
import com.shiguang.mfrs.service.LensService;



@Service
public class LensServiceImpl implements LensService {
	@Autowired
	private LensDao lensDao;
	
	@Override
	public LensDO get(Integer id){
		return lensDao.get(id);
	}
	
	@Override
	public List<LensDO> list(Map<String, Object> map){
		return lensDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return lensDao.count(map);
	}
	
	@Override
	public int save(LensDO lens){
		return lensDao.save(lens);
	}
	
	@Override
	public int update(LensDO lens){
		return lensDao.update(lens);
	}
	
	@Override
	public int remove(Integer id){
		return lensDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return lensDao.batchRemove(ids);
	}
	
}
