package com.shiguang.baseinfomation.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.baseinfomation.domain.AdditionalDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-30 16:55:50
 */
@Mapper
public interface AdditionalDao {

	AdditionalDO get(Long id);
	
	List<AdditionalDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdditionalDO additional);
	
	int update(AdditionalDO additional);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
