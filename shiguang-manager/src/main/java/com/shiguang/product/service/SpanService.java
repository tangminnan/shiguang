package com.shiguang.product.service;

import com.shiguang.product.domain.SpanDO;

import java.util.List;
import java.util.Map;

/**
 * 跨度表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 10:48:53
 */
public interface SpanService {
	
	SpanDO get(Long spanId);
	
	List<SpanDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpanDO span);
	
	int update(SpanDO span);
	
	int remove(Long spanId);
	
	int batchRemove(Long[] spanIds);
}
