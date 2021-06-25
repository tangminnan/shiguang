package com.shiguang.product.dao;

import com.shiguang.product.domain.LightbelowDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 下加光表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 16:58:43
 */
@Mapper
public interface LightbelowDao {

	LightbelowDO get(Long id);
	
	List<LightbelowDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LightbelowDO lightbelow);
	
	int update(LightbelowDO lightbelow);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
