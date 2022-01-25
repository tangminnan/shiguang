package com.shiguang.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.stock.dao.WeiwaishujuDao;
import com.shiguang.stock.domain.WeiwaishujuDO;
import com.shiguang.stock.service.WeiwaishujuService;



@Service
public class WeiwaishujuServiceImpl implements WeiwaishujuService {
	@Autowired
	private WeiwaishujuDao weiwaishujuDao;

	@Override
	public WeiwaishujuDO get(Long id){
		return weiwaishujuDao.get(id);
	}

	@Override
	public List<WeiwaishujuDO> list(Map<String, Object> map){
		return weiwaishujuDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return weiwaishujuDao.count(map);
	}

	@Override
	public int save(WeiwaishujuDO weiwaishuju){
		return weiwaishujuDao.save(weiwaishuju);
	}

	@Override
	public int update(WeiwaishujuDO weiwaishuju){
		return weiwaishujuDao.update(weiwaishuju);
	}

	@Override
	public int remove(Long id){
		return weiwaishujuDao.remove(id);
	}

	@Override
	public int removes(String number) {
		return weiwaishujuDao.removes(number);
	}

	@Override
	public int batchRemove(Long[] ids){
		return weiwaishujuDao.batchRemove(ids);
	}



	@Override
	public List<WeiwaishujuDO> getWeiwaiShuju(Map<String, Object> map) {
		return weiwaishujuDao.getWeiwaiShuju(map);
	}
}
