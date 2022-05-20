package com.shiguang.storeSales.service.impl;

import com.shiguang.storeSales.dao.InfoDao;
import com.shiguang.storeSales.domain.InfoDO;
import com.shiguang.storeSales.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	private InfoDao infoDao;
	
	@Override
	public InfoDO get(Long id){
		return infoDao.get(id);
	}
	
	@Override
	public List<InfoDO> list(Map<String, Object> map){
		return infoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return infoDao.count(map);
	}
	
	@Override
	public int save(InfoDO info){
		return infoDao.save(info);
	}
	
	@Override
	public int update(InfoDO info){
		return infoDao.update(info);
	}
	
	@Override
	public int remove(Long id){
		return infoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return infoDao.batchRemove(ids);
	}
	
}
