package com.shiguang.integral.dao;


import java.util.List;
import java.util.Map;

import com.shiguang.integral.domain.IntegralDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分设置表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-06 15:20:18
 */
@Mapper
public interface IntegralDao {

	IntegralDO get(Long id);
	
	List<IntegralDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IntegralDO integral);
	
	int update(IntegralDO integral);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<IntegralDO> getPoints(Map<String,Object> map);
}
