package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.GradualDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 渐进片分类表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 10:40:35
 */
@Mapper
public interface GradualDao {

	GradualDO get(Integer id);
	
	List<GradualDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GradualDO gradual);
	
	int update(GradualDO gradual);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
