package com.shiguang.product.dao;

import com.shiguang.product.domain.LightbelowDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 下加光表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface LightbelowDao {

	LightbelowDO get(Long lightbelowId);
	
	List<LightbelowDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LightbelowDO lightbelow);
	
	int update(LightbelowDO lightbelow);
	
	int remove(Long lightbelow_id);
	
	int batchRemove(Long[] lightbelowIds);
}
