package com.shiguang.storeCard.dao;

import com.shiguang.storeCard.domain.CardDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-20 16:22:19
 */
@Mapper
public interface CardDao {

	CardDO get(Long id);
	
	List<CardDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CardDO card);
	
	int update(CardDO card);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
