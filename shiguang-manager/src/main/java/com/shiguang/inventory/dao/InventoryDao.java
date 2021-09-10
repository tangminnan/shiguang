package com.shiguang.inventory.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.inventory.domain.InventoryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 盘点表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
@Mapper
public interface InventoryDao {

	InventoryDO get(Long id);
	
	List<InventoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InventoryDO inventory);
	
	int update(InventoryDO inventory);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
