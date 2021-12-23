package com.shiguang.inventory.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.inventory.domain.BillDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 盘点商品单表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
@Mapper
public interface BillDao {

	BillDO get(Long id);

	List<BillDO> getInventoryId(Long inventoryId);
	
	List<BillDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BillDO bill);
	
	int update(BillDO bill);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int removeInventoryId(Long inventoryId);
}
