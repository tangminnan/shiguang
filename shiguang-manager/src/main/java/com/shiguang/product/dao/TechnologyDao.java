package com.shiguang.product.dao;

import com.shiguang.product.domain.TechnologyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 工艺类型表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface TechnologyDao {

	TechnologyDO get(Long technologyId);
	
	List<TechnologyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TechnologyDO technology);
	
	int update(TechnologyDO technology);
	
	int remove(Long technology_id);
	
	int batchRemove(Long[] technologyIds);
}
