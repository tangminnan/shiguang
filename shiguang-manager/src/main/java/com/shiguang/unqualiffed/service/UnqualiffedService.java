package com.shiguang.unqualiffed.service;


import com.shiguang.unqualiffed.domain.UnqualiffedDO;

import java.util.List;
import java.util.Map;

/**
 * 不合格表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
public interface UnqualiffedService {
	
	UnqualiffedDO get(Long id);
	
	List<UnqualiffedDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UnqualiffedDO unqualiffed);
	
	int update(UnqualiffedDO unqualiffed);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
