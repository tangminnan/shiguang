package com.shiguang.settlement.service;


import com.shiguang.settlement.domain.DrawbackDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 16:40:11
 */
public interface DrawbackService {
	
	DrawbackDO get(Long id);
	
	List<DrawbackDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DrawbackDO drawback);
	
	int update(DrawbackDO drawback);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
