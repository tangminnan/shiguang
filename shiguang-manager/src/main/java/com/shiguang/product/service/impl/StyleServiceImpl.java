package com.shiguang.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.product.dao.StyleDao;
import com.shiguang.product.domain.StyleDO;
import com.shiguang.product.service.StyleService;



@Service
public class StyleServiceImpl implements StyleService {
	@Autowired
	private StyleDao styleDao;
	
	@Override
	public StyleDO get(Long styleId){
		return styleDao.get(styleId);
	}
	
	@Override
	public List<StyleDO> list(Map<String, Object> map){
		return styleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return styleDao.count(map);
	}
	
	@Override
	public int save(StyleDO style){
		return styleDao.save(style);
	}
	
	@Override
	public int update(StyleDO style){
		return styleDao.update(style);
	}
	
	@Override
	public int remove(Long styleId){
		return styleDao.remove(styleId);
	}
	
	@Override
	public int batchRemove(Long[] styleIds){
		return styleDao.batchRemove(styleIds);
	}
	
}
