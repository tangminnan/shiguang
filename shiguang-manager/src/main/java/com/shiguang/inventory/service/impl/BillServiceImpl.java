package com.shiguang.inventory.service.impl;

import com.shiguang.inventory.dao.BillDao;
import com.shiguang.inventory.domain.BillDO;
import com.shiguang.inventory.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDao billDao;
	
	@Override
	public BillDO get(Long id){
		return billDao.get(id);
	}
	
	@Override
	public List<BillDO> list(Map<String, Object> map){
		return billDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return billDao.count(map);
	}
	
	@Override
	public int save(BillDO bill){
		return billDao.save(bill);
	}
	
	@Override
	public int update(BillDO bill){
		return billDao.update(bill);
	}
	
	@Override
	public int remove(Long id){
		return billDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return billDao.batchRemove(ids);
	}
	
}
