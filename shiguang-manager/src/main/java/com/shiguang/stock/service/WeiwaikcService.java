package com.shiguang.stock.service;

import com.shiguang.stock.domain.WeiwaiDO;
import com.shiguang.stock.domain.WeiwaikcDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-09-30 01:34:01
 */
public interface WeiwaikcService {
	
	WeiwaikcDO get(Long id);
	
	List<WeiwaikcDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WeiwaikcDO weiwaikc);
	
	int update(WeiwaikcDO weiwaikc);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	//确认收货
	int updateStatus(WeiwaikcDO weiwaikcDO);
}
