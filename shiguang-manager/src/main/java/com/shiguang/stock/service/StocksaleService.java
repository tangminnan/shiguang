package com.shiguang.stock.service;

import com.shiguang.stock.domain.StocksaleDO;

import java.util.List;
import java.util.Map;

/**
 * 销售仓表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-11-09 09:23:30
 */
public interface StocksaleService {
	
	StocksaleDO get(Long id);
	
	List<StocksaleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StocksaleDO stocksale);
	
	int update(StocksaleDO stocksale);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
