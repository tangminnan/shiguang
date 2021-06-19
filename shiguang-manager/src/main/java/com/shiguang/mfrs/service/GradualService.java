package com.shiguang.mfrs.service;

import com.shiguang.mfrs.domain.GradualDO;

import java.util.List;
import java.util.Map;

/**
 * 渐进片分类表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
public interface GradualService {
	
	GradualDO get(Integer id);
	
	List<GradualDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GradualDO gradual);
	
	int update(GradualDO gradual);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
