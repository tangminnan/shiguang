package com.shiguang.inventory.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.inventory.domain.GainLossDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-07 15:27:42
 */
@Mapper
public interface GainLossDao {

	GainLossDO get(Long id);
	
	List<GainLossDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GainLossDO gainLoss);
	
	int update(GainLossDO gainLoss);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	GainLossDO getInventoryNumber(String inventoryNumber);

	int removeInventoryNumber(String inventoryNumber);
}
