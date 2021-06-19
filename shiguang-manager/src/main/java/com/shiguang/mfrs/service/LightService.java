package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.LightDO;

import java.util.List;
import java.util.Map;

/**
 * 光度分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
public interface LightService {
	
	LightDO get(Integer id);
	
	List<LightDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LightDO light);
	
	int update(LightDO light);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
