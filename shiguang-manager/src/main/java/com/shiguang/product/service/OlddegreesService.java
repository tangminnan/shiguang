package com.shiguang.product.service;

import com.shiguang.product.domain.OlddegreesDO;

import java.util.List;
import java.util.Map;

/**
 * 老花镜度数表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 16:19:35
 */
public interface OlddegreesService {
	
	OlddegreesDO get(Long oldId);
	
	List<OlddegreesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OlddegreesDO olddegrees);
	
	int update(OlddegreesDO olddegrees);
	
	int remove(Long oldId);
	
	int batchRemove(Long[] oldIds);
}
