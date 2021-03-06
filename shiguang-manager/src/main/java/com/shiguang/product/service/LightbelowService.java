package com.shiguang.product.service;

import com.shiguang.product.domain.LightbelowDO;

import java.util.List;
import java.util.Map;

/**
 * 下加光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public interface LightbelowService {
	
	LightbelowDO get(Long lightbelowId);
	
	List<LightbelowDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LightbelowDO lightbelow);
	
	int update(LightbelowDO lightbelow);
	
	int remove(Long lightbelowId);
	
	int batchRemove(Long[] lightbelowIds);
}
