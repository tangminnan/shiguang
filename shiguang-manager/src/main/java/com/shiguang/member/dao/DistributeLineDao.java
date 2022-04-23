package com.shiguang.member.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.member.domain.LineDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2022-04-23 10:11:11
 */
@Mapper
public interface DistributeLineDao {

	LineDO get(Long id);
	
	List<LineDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LineDO line);
	
	int update(LineDO line);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
