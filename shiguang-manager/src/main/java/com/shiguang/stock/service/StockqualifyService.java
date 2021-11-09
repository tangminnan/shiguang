package com.shiguang.stock.service;

import com.shiguang.stock.domain.StockqualifyDO;

import java.util.List;
import java.util.Map;

/**
 * 合格仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
public interface StockqualifyService {
	
	StockqualifyDO get(Long id);
	
	List<StockqualifyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StockqualifyDO stockqualify);
	
	int update(StockqualifyDO stockqualify);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
