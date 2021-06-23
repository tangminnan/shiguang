package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.GradualDO;

import java.util.List;
import java.util.Map;

/**
 * 渐进片分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
public interface GradualService {
	
	GradualDO get(Integer gradualId);
	
	List<GradualDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GradualDO gradual);
	
	int update(GradualDO gradual);
	
	int remove(Integer gradualId);
	
	int batchRemove(Integer[] gradualIds);
}
