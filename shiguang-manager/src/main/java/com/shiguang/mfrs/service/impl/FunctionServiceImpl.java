package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.FunctionDao;
import com.shiguang.mfrs.domain.FunctionDO;
import com.shiguang.mfrs.service.FunctionService;



@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionDao functionDao;
	
	@Override
	public FunctionDO get(Integer functionId){
		return functionDao.get(functionId);
	}
	
	@Override
	public List<FunctionDO> list(Map<String, Object> map){
		return functionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return functionDao.count(map);
	}
	
	@Override
	public int save(FunctionDO function){
		return functionDao.save(function);
	}
	
	@Override
	public int update(FunctionDO function){
		return functionDao.update(function);
	}
	
	@Override
	public int remove(Integer functionId){
		return functionDao.remove(functionId);
	}
	
	@Override
	public int batchRemove(Integer[] functionIds){
		return functionDao.batchRemove(functionIds);
	}
	
}
