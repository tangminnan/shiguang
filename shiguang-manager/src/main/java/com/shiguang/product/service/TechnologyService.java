package com.shiguang.product.service;

import com.shiguang.product.domain.TechnologyDO;

import java.util.List;
import java.util.Map;

/**
 * 工艺类型表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 17:58:57
 */
public interface TechnologyService {
	
	TechnologyDO get(Long technologyId);
	
	List<TechnologyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TechnologyDO technology);
	
	int update(TechnologyDO technology);
	
	int remove(Long technologyId);
	
	int batchRemove(Long[] technologyIds);
}
