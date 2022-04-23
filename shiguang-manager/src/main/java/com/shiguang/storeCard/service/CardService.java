package com.shiguang.storeCard.service;


import com.shiguang.storeCard.domain.CardDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-20 16:22:19
 */
public interface CardService {
	
	CardDO get(Long id);

	CardDO getMemberNum(String memberNumber);

	CardDO getCardNum(String cardNumber);
	
	List<CardDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CardDO card);
	
	int update(CardDO card);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
