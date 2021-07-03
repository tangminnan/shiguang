package com.shiguang.jiancha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.jiancha.dao.SubjectiveDao;
import com.shiguang.jiancha.domain.SubjectiveDO;
import com.shiguang.jiancha.service.SubjectiveService;



@Service
public class SubjectiveServiceImpl implements SubjectiveService {
	@Autowired
	private SubjectiveDao subjectiveDao;
	
	@Override
	public SubjectiveDO get(Long id){
		return subjectiveDao.get(id);
	}
	
	@Override
	public List<SubjectiveDO> list(Map<String, Object> map){
		return subjectiveDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subjectiveDao.count(map);
	}
	
	@Override
	public int save(SubjectiveDO subjective){
		return subjectiveDao.save(subjective);
	}
	
	@Override
	public int update(SubjectiveDO subjective){
		return subjectiveDao.update(subjective);
	}
	
	@Override
	public int remove(Long id){
		return subjectiveDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return subjectiveDao.batchRemove(ids);
	}
	
}
