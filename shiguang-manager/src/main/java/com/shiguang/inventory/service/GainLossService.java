package com.shiguang.inventory.service;


import com.shiguang.inventory.domain.GainLossDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-07 15:27:42
 */
public interface GainLossService {
	
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
