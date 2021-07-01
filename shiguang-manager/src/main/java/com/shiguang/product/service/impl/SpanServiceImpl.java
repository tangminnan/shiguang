package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.SpanDao;
import com.shiguang.product.domain.SpanDO;
import com.shiguang.product.service.SpanService;



@Service
public class SpanServiceImpl implements SpanService {
	@Autowired
	private SpanDao spanDao;
	
	@Override
	public SpanDO get(Long spanId){
		return spanDao.get(spanId);
	}
	
	@Override
	public List<SpanDO> list(Map<String, Object> map){
		return spanDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return spanDao.count(map);
	}
	
	@Override
	public int save(SpanDO span){
		return spanDao.save(span);
	}
	
	@Override
	public int update(SpanDO span){
		return spanDao.update(span);
	}
	
	@Override
	public int remove(Long spanId){
		return spanDao.remove(spanId);
	}
	
	@Override
	public int batchRemove(Long[] spanIds){
		return spanDao.batchRemove(spanIds);
	}
	
}
