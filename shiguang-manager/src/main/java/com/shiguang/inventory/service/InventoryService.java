package com.shiguang.inventory.service;


import com.shiguang.common.utils.R;
import com.shiguang.inventory.domain.InventoryDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 盘点表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-09 13:37:02
 */
public interface InventoryService {
	
	InventoryDO get(Long id);

	InventoryDO getInventory(Long inventoryId);
	
	List<InventoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InventoryDO inventory);
	
	int update(InventoryDO inventory);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	R importInventory(String documentNo, String inventoryName, String inventoryPosition, String inventoryType, List<MultipartFile> file);
}
