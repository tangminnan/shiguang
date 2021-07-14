package com.shiguang.jiancha.dao;

import com.shiguang.jiancha.domain.PharmacyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:51:54
 */
@Mapper
public interface PharmacyDao {

	PharmacyDO get(Long pharmacyId);
	
	List<PharmacyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PharmacyDO pharmacy);
	
	int update(PharmacyDO pharmacy);
	
	int remove(Long pharmacy_id);
	
	int batchRemove(Long[] pharmacyIds);
}
