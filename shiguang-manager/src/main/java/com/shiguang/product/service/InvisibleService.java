package com.shiguang.product.service;

import com.shiguang.product.domain.InvisibleDO;

import java.util.List;
import java.util.Map;

/**
 * 隐形类别表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
public interface InvisibleService {
	
	InvisibleDO get(Long invisibleId);
	
	List<InvisibleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(InvisibleDO invisible);
	
	int update(InvisibleDO invisible);
	
	int remove(Long invisibleId);
	
	int batchRemove(Long[] invisibleIds);
}
