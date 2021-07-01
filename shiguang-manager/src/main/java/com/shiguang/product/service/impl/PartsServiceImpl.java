package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.PartsDao;
import com.shiguang.product.domain.PartsDO;
import com.shiguang.product.service.PartsService;



@Service
public class PartsServiceImpl implements PartsService {
	@Autowired
	private PartsDao partsDao;
	
	@Override
	public PartsDO get(Long id){
		return partsDao.get(id);
	}
	
	@Override
	public List<PartsDO> list(Map<String, Object> map){
		return partsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return partsDao.count(map);
	}
	
	@Override
	public int save(PartsDO parts){
		return partsDao.save(parts);
	}
	
	@Override
	public int update(PartsDO parts){
		return partsDao.update(parts);
	}
	
	@Override
	public int remove(Long id){
		return partsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return partsDao.batchRemove(ids);
	}
	//查询配件制造商
	@Override
	public List<MgDO> mglist(Map<String, Object> map) {
		return partsDao.mglist(map);
	}
	//菜单联动显示
	@Override
	public List<BrandDO> choice(Integer mfrsid) {
		return partsDao.choice(mfrsid);
	}
}
