package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.PayDao;
import com.shiguang.mfrs.domain.PayDO;
import com.shiguang.mfrs.service.PayService;



@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private PayDao payDao;
	
	@Override
	public PayDO get(Integer payid){
		return payDao.get(payid);
	}
	
	@Override
	public List<PayDO> list(Map<String, Object> map){
		return payDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return payDao.count(map);
	}
	
	@Override
	public int save(PayDO pay){
		return payDao.save(pay);
	}
	
	@Override
	public int update(PayDO pay){
		return payDao.update(pay);
	}
	
	@Override
	public int remove(Integer payid){
		return payDao.remove(payid);
	}
	
	@Override
	public int batchRemove(Integer[] payids){
		return payDao.batchRemove(payids);
	}
	
}
