package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.GradualDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 渐进片分类表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
@Mapper
public interface GradualDao {

	GradualDO get(Integer gradualId);
	
	List<GradualDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GradualDO gradual);
	
	int update(GradualDO gradual);
	
	int remove(Integer gradual_id);
	
	int batchRemove(Integer[] gradualIds);
}
