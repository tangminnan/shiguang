package com.shiguang.product.dao;

import com.shiguang.product.domain.SpanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 跨度表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 10:48:53
 */
@Mapper
public interface SpanDao {

	SpanDO get(Long spanId);
	
	List<SpanDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SpanDO span);
	
	int update(SpanDO span);
	
	int remove(Long span_id);
	
	int batchRemove(Long[] spanIds);
}
