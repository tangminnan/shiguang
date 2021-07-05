package com.shiguang.giveaway.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.giveaway.domain.GiftDO;
import com.shiguang.giveaway.domain.GiveawayDO;
import com.shiguang.product.domain.ProducaDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-05 11:09:07
 */
@Mapper
public interface GiveawayDao {

	GiveawayDO get(Long id);
	
	List<GiveawayDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GiveawayDO giveaway);
	
	int update(GiveawayDO giveaway);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<ProducaDO> findGoods(Map<String,Object> map);

	int coungGoods(Map<String,Object> map);

	List<GiftDO> findGiftList(Map<String,Object> map);
}
