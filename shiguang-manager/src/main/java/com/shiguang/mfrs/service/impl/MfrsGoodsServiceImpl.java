package com.shiguang.mfrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.shiguang.mfrs.dao.MfrsGoodsDao;
import com.shiguang.mfrs.domain.MfrsGoodsDO;
import com.shiguang.mfrs.service.MfrsGoodsService;



@Service
public class MfrsGoodsServiceImpl implements MfrsGoodsService {
	@Autowired
	private MfrsGoodsDao mfrsGoodsDao;
	
	@Override
	public MfrsGoodsDO get(Integer id){
		return mfrsGoodsDao.get(id);
	}
	
	@Override
	public List<MfrsGoodsDO> list(Map<String, Object> map){
		return mfrsGoodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return mfrsGoodsDao.count(map);
	}
	
	@Override
	public int save(MfrsGoodsDO mfrsGoods){
		return mfrsGoodsDao.save(mfrsGoods);
	}
	
	@Override
	public int update(MfrsGoodsDO mfrsGoods){
		return mfrsGoodsDao.update(mfrsGoods);
	}
	
	@Override
	public int remove(Integer id){
		return mfrsGoodsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return mfrsGoodsDao.batchRemove(ids);
	}
	
}
