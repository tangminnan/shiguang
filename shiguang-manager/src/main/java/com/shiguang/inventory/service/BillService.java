package com.shiguang.inventory.service;


import com.shiguang.inventory.domain.BillDO;

import java.util.List;
import java.util.Map;

/**
 * 盘点商品单表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
public interface BillService {
	
	BillDO get(Long id);

	List<BillDO> getInventoryId(Long inventoryId);
	
	List<BillDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BillDO bill);
	
	int update(BillDO bill);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
