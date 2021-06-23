package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.LightDO;

import java.util.List;
import java.util.Map;

/**
 * 光度分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public interface LightService {
	
	LightDO get(Integer lightId);
	
	List<LightDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LightDO light);
	
	int update(LightDO light);
	
	int remove(Integer lightId);
	
	int batchRemove(Integer[] lightIds);
}
