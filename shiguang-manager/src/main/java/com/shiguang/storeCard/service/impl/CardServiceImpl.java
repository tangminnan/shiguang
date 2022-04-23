package com.shiguang.storeCard.service.impl;

import com.shiguang.storeCard.dao.CardDao;
import com.shiguang.storeCard.domain.CardDO;
import com.shiguang.storeCard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardDao cardDao;
	
	@Override
	public CardDO get(Long id){
		return cardDao.get(id);
	}

	@Override
	public CardDO getMemberNum(String memberNumber){
		return cardDao.getMemberNum(memberNumber);
	}

	@Override
	public CardDO getCardNum(String cardNum){
		return cardDao.getCardNum(cardNum);
	}
	
	@Override
	public List<CardDO> list(Map<String, Object> map){
		return cardDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cardDao.count(map);
	}
	
	@Override
	public int save(CardDO card){
		return cardDao.save(card);
	}
	
	@Override
	public int update(CardDO card){
		return cardDao.update(card);
	}
	
	@Override
	public int remove(Long id){
		return cardDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return cardDao.batchRemove(ids);
	}
	
}
