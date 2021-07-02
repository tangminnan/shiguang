package com.shiguang.baseinfomation.service;


import com.shiguang.baseinfomation.domain.AdditionalDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-30 16:55:50
 */
public interface AdditionalService {
	
	AdditionalDO get(Long id);
	
	List<AdditionalDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdditionalDO additional);
	
	int update(AdditionalDO additional);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
