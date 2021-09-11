package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.TuihuoDao;
import com.shiguang.stock.domain.TuihuoDO;
import com.shiguang.stock.service.TuihuoService;



@Service
public class TuihuoServiceImpl implements TuihuoService {
	@Autowired
	private TuihuoDao tuihuoDao;
	
	@Override
	public TuihuoDO get(Long id){
		return tuihuoDao.get(id);
	}
	
	@Override
	public List<TuihuoDO> list(Map<String, Object> map){
		return tuihuoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tuihuoDao.count(map);
	}
	
	@Override
	public int save(TuihuoDO tuihuo){
		return tuihuoDao.save(tuihuo);
	}
	
	@Override
	public int update(TuihuoDO tuihuo){
		return tuihuoDao.update(tuihuo);
	}
	
	@Override
	public int remove(Long id){
		return tuihuoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tuihuoDao.batchRemove(ids);
	}
	
}
