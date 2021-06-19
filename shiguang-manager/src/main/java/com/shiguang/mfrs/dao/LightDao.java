package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.LightDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 光度分类表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
@Mapper
public interface LightDao {

	LightDO get(Integer id);
	
	List<LightDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LightDO light);
	
	int update(LightDO light);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
