package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.TypeDao;
import com.shiguang.mfrs.domain.TypeDO;
import com.shiguang.mfrs.service.TypeService;



@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;
	
	@Override
	public TypeDO get(Integer typeId){
		return typeDao.get(typeId);
	}
	
	@Override
	public List<TypeDO> list(Map<String, Object> map){
		return typeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return typeDao.count(map);
	}
	
	@Override
	public int save(TypeDO type){
		return typeDao.save(type);
	}
	
	@Override
	public int update(TypeDO type){
		return typeDao.update(type);
	}
	
	@Override
	public int remove(Integer typeId){
		return typeDao.remove(typeId);
	}
	
	@Override
	public int batchRemove(Integer[] typeIds){
		return typeDao.batchRemove(typeIds);
	}
	
}
