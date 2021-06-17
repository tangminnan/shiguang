package com.shiguang.checkout.service.impl;

import com.shiguang.checkout.dao.CostDao;
import com.shiguang.checkout.domain.CostDO;
import com.shiguang.checkout.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class CostServiceImpl implements CostService {
	@Autowired
	private CostDao costDao;
	
	@Override
	public CostDO get(Long id){
		return costDao.get(id);
	}

	@Override
	public List<CostDO> getMemberNum(String cardNumber){
		return costDao.getMemberNum(cardNumber);
	}
	
	@Override
	public List<CostDO> list(Map<String, Object> map){
		return costDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return costDao.count(map);
	}
	
	@Override
	public int save(CostDO cost){
		return costDao.save(cost);
	}
	
	@Override
	public int update(CostDO cost){
		return costDao.update(cost);
	}

	@Override
	public int updateMember(CostDO cost){
		return costDao.updateMember(cost);
	}
	
	@Override
	public int remove(Long id){
		return costDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return costDao.batchRemove(ids);
	}
	
}
