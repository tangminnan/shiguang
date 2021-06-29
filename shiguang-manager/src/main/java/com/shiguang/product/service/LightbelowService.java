package com.shiguang.product.service;

import com.shiguang.product.domain.LightbelowDO;

import java.util.List;
import java.util.Map;

/**
 * 下加光表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:26:17
 */
public interface LightbelowService {
	
	LightbelowDO get(Long id);
	
	List<LightbelowDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LightbelowDO lightbelow);
	
	int update(LightbelowDO lightbelow);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
