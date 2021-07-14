package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.PharmacyDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:51:54
 */
public interface PharmacyService {
	
	PharmacyDO get(Long pharmacyId);
	
	List<PharmacyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PharmacyDO pharmacy);
	
	int update(PharmacyDO pharmacy);
	
	int remove(Long pharmacyId);
	
	int batchRemove(Long[] pharmacyIds);
}
