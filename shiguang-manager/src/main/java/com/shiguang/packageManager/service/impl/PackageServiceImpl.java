package com.shiguang.packageManager.service.impl;

import com.shiguang.packageManager.dao.PackageDao;
import com.shiguang.packageManager.domain.PackageDO;
import com.shiguang.packageManager.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class PackageServiceImpl implements PackageService {
	@Autowired
	private PackageDao packageDao;
	
	@Override
	public PackageDO get(Long id){
		return packageDao.get(id);
	}
	
	@Override
	public List<PackageDO> list(Map<String, Object> map){
		return packageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return packageDao.count(map);
	}
	
	@Override
	public int save(PackageDO packages){
		return packageDao.save(packages);
	}
	
	@Override
	public int update(PackageDO packages){
		return packageDao.update(packages);
	}
	
	@Override
	public int remove(Long id){
		return packageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return packageDao.batchRemove(ids);
	}
	
}
