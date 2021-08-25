package com.shiguang.unqualiffed.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.unqualiffed.domain.UnqualiffedDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 不合格表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-08-24 15:55:17
 */
@Mapper
public interface UnqualiffedDao {

	UnqualiffedDO get(Long id);
	
	List<UnqualiffedDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UnqualiffedDO unqualiffed);
	
	int update(UnqualiffedDO unqualiffed);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
