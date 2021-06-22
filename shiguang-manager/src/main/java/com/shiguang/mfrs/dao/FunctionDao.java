package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.FunctionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 镜片功能表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-21 15:08:08
 */
@Mapper
public interface FunctionDao {

	FunctionDO get(Integer functionId);
	
	List<FunctionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FunctionDO function);
	
	int update(FunctionDO function);
	
	int remove(Integer function_id);
	
	int batchRemove(Integer[] functionIds);
}
