package com.shiguang.giveaway.service.impl;

import com.shiguang.giveaway.dao.GiveawayDao;
import com.shiguang.giveaway.domain.GiftDO;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.giveaway.service.GiveawayService;
import com.shiguang.product.domain.ProducaDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class GiveawayServiceImpl implements GiveawayService {
	@Autowired
	private GiveawayDao giveawayDao;
	
	@Override
	public GiveawayDO get(Long id){
		return giveawayDao.get(id);
	}
	
	@Override
	public List<GiveawayDO> list(Map<String, Object> map){
		return giveawayDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return giveawayDao.count(map);
	}
	
	@Override
	public int save(GiveawayDO giveaway){
		return giveawayDao.save(giveaway);
	}
	
	@Override
	public int update(GiveawayDO giveaway){
		return giveawayDao.update(giveaway);
	}
	
	@Override
	public int remove(Long id){
		return giveawayDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return giveawayDao.batchRemove(ids);
	}

	@Override
	public List<ProducaDO> findGoods(Map<String, Object> map){
		return giveawayDao.findGoods(map);
	}

	@Override
	public int coungGoods(Map<String, Object> map){
		return giveawayDao.coungGoods(map);
	}

	@Override
	public List<GiftDO> findGiftList(Map<String, Object> map){
		return giveawayDao.findGiftList(map);
	}
}
