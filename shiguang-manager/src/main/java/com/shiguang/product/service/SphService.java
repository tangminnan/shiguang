package com.shiguang.product.service;

import com.shiguang.product.domain.SphDO;

import java.util.List;
import java.util.Map;

/**
 * 球镜表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
public interface SphService {
	
	SphDO get(Long id);
	
	List<SphDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SphDO sph);
	
	int update(SphDO sph);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
