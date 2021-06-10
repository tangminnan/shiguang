package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.BrandDao;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.service.BrandService;



@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	
	@Override
	public BrandDO get(Integer brandid){
		return brandDao.get(brandid);
	}
	
	@Override
	public List<BrandDO> list(Map<String, Object> map){
		return brandDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return brandDao.count(map);
	}
	
	@Override
	public int save(BrandDO brand){
		return brandDao.save(brand);
	}
	
	@Override
	public int update(BrandDO brand){
		return brandDao.update(brand);
	}
	
	@Override
	public int remove(Integer brandid){
		return brandDao.remove(brandid);
	}
	
	@Override
	public int batchRemove(Integer[] brandids){
		return brandDao.batchRemove(brandids);
	}
	
}
