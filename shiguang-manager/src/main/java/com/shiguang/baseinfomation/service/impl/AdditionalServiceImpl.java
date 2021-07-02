package com.shiguang.baseinfomation.service.impl;

import com.shiguang.baseinfomation.dao.AdditionalDao;
import com.shiguang.baseinfomation.domain.AdditionalDO;
import com.shiguang.baseinfomation.service.AdditionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class AdditionalServiceImpl implements AdditionalService {
	@Autowired
	private AdditionalDao additionalDao;
	
	@Override
	public AdditionalDO get(Long id){
		return additionalDao.get(id);
	}
	
	@Override
	public List<AdditionalDO> list(Map<String, Object> map){
		return additionalDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return additionalDao.count(map);
	}
	
	@Override
	public int save(AdditionalDO additional){
		return additionalDao.save(additional);
	}
	
	@Override
	public int update(AdditionalDO additional){
		return additionalDao.update(additional);
	}
	
	@Override
	public int remove(Long id){
		return additionalDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return additionalDao.batchRemove(ids);
	}
	
}
