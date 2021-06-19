package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.MgDao;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.mfrs.service.MgService;



@Service
public class MgServiceImpl implements MgService {
	@Autowired
	private MgDao mgDao;
	
	@Override
	public MgDO get(Integer id){
		return mgDao.get(id);
	}
	
	@Override
	public List<MgDO> list(Map<String, Object> map){
		return mgDao.list(map);
	}
	public List<MgDO> mglist(Map<String, Object> map){
		return mgDao.mglist(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return mgDao.count(map);
	}
	
	@Override
	public int save(MgDO mg){
		return mgDao.save(mg);
	}
	
	@Override
	public int update(MgDO mg){
		return mgDao.update(mg);
	}
	
	@Override
	public int remove(Integer id){
		return mgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return mgDao.batchRemove(ids);
	}
	
}
