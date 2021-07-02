package com.shiguang.product.dao;

import com.shiguang.product.domain.OlddegreesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 老花镜度数表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 16:19:35
 */
@Mapper
public interface OlddegreesDao {

	OlddegreesDO get(Long oldId);
	
	List<OlddegreesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OlddegreesDO olddegrees);
	
	int update(OlddegreesDO olddegrees);
	
	int remove(Long old_id);
	
	int batchRemove(Long[] oldIds);
}
